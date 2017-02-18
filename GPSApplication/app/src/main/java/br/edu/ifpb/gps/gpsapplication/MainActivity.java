package br.edu.ifpb.gps.gpsapplication;

import android.Manifest;
import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import br.edu.ifpb.gps.gpsapplication.R;

/**
 *  Localização do Usuário através do GPS que informará a Latitude e Longitude.
 *
 *  A Activity é inicializada do modo convencional com o método onCreate.
 *
 *  A interface {@link LocationListener} possui assinaturas que precisam ser sobrescritas:
 *      - onLocationChanged
 *      - onStatusChanged
 *      - onProviderEnabled
 *      - onProviderDisabled
 */
public class MainActivity extends Activity implements LocationListener {

    // View
    private TextView latitudePosition;
    private TextView longitudePosition;
    private TextView currentCity;

    // Location
    private LocationManager locationManager;
    private Location location;

    // Configuração
    private final int REQUEST_LOCATION = 200;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Componentes para exibir o posicionamento do GPS.
        latitudePosition = (TextView) findViewById(R.id.latitude);
        longitudePosition = (TextView) findViewById(R.id.longitude);

        currentCity = (TextView) findViewById(R.id.city);

        // Inicializar comunicação com o módulo de GPS do dispositivo móvel.
        locationManager = (LocationManager) getSystemService(Service.LOCATION_SERVICE);

        /*
         * Verificar permissões de acesso. Desde a API 23 o usuário também precisa conscentir expressamente
         * que permite o acesso ao GPS. A permissão do manifest também precisa ser adicionada.
         */
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            // Requisitar permissão de acesso ao usuário.
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION);

        } else {

            // Caso a permissão já conscentida atualizar a localização.
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100, 2, this);

            if (locationManager != null) {
                // Localização atualizada.
                location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            }
        }

        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {

            if (location != null) {

                // Posições do GPS
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();

                // Exibir os dados do GPS nos TextView de latitude e longitude.
                latitudePosition.setText(String.valueOf(latitude));
                longitudePosition.setText(String.valueOf(longitude));

                // Exibir o nome do logradouro baseado na posição de latitude e longitude.
                getAddressFromLocation(location, getApplicationContext(), new GeoCoderHandler());
            }

        } else {

            showGPSDisabledAlertToUser();
        }
    }

    /**
     * Atualiza a posição do usuário caso o GPS leia novos valores.
     *
     * @param location
     */
    @Override
    public void onLocationChanged(Location location) {

        // Novas posições do GPS
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();

        // Exibir os dados do GPS nos TextView de latitude e longitude.
        latitudePosition.setText(String.valueOf(latitude));
        longitudePosition.setText(String.valueOf(longitude));

        // Recupera Logradouro
        getAddressFromLocation(location, getApplicationContext(), new GeoCoderHandler());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    @Override
    public void onProviderEnabled(String provider) {
    }

    @Override
    public void onProviderDisabled(String provider) {

        if (provider.equals(LocationManager.GPS_PROVIDER)) {
            showGPSDisabledAlertToUser();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        if (requestCode == REQUEST_LOCATION) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            }
        }
    }

    /**
     * Caixa de diálogo para habilitar o GPS nas configurações do dispositivo móvel.
     */
    private void showGPSDisabledAlertToUser() {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("O GPS está desabilitado no seu dispositivo. Deseja habilitar?")
                .setCancelable(false)
                .setPositiveButton("Direcione para as configurações para habilitar o GPS.", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent callGPSSettingIntent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(callGPSSettingIntent);
                    }
                });

        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });

        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    /**
     * Consutar o Logradouro na Internet da posição informada pelo GPS.
     *
     * Logradouro (também logradoiro, sobretudo em Portugal) é um termo que designa um terreno
     * ou um espaço anexo a uma habitação, usado para serventia da casa, ou ainda qualquer espaço
     * público comum que pode ser usufruído por toda a população e reconhecido pela administração
     * de um município, como largos, praças, jardins, parques, entre outros.
     *
     * @param location
     * @param context
     * @param handler
     */
    public static void getAddressFromLocation(final Location location,
                                              final Context context,
                                              final Handler handler) {

        // Conexão assíncrona para recuperar o Logradouro na internet.
        Thread thread = new Thread() {

            @Override
            public void run() {

                Geocoder geocoder = new Geocoder(context, Locale.getDefault());
                String result = null;

                try {

                    List<Address> list = geocoder.getFromLocation(
                            location.getLatitude(), location.getLongitude(), 1);

                    if (list != null && list.size() > 0) {
                        Address address = list.get(0);

                        // Resposta com a primeira linha de endereço e localidade.
                        result = address.getAddressLine(0) + ", " + address.getLocality() + ", " + address.getCountryName();
                    }

                } catch (IOException e) {

                    Log.e(TAG, "Impossível conectar ao Geocoder", e);

                } finally {

                    Message msg = Message.obtain();
                    msg.setTarget(handler);

                    if (result != null) {

                        msg.what = 1;
                        Bundle bundle = new Bundle();
                        bundle.putString("address", result);
                        msg.setData(bundle);

                    } else {
                        msg.what = 0;
                    }

                    msg.sendToTarget();
                }
            }
        };

        thread.start();
    }

    /**
     * Classe internat para auxiliar na recuperação e exibição dos dados do Logradouro.
     */
    private class GeoCoderHandler extends Handler {

        @Override
        public void handleMessage(Message message) {

            String result;

            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    result = bundle.getString("address");
                    break;
                default:
                    result = null;
            }
            currentCity.setText(result);
        }
    }
}