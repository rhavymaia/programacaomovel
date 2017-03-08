package br.edu.ifpb.retrofit2app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import java.util.List;

import br.edu.ifpb.retrofit2app.APIService;
import br.edu.ifpb.retrofit2app.ConnectionServer;
import br.edu.ifpb.retrofit2app.Sine;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Activity principal da aplicação:
 *  Recuperar os sines do servidor através do clique do botão.
 */
public class MainActivity extends AppCompatActivity implements OnClickListener, Callback<List<Sine>> {

    List<Sine> sines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.listarSineButton);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        // Interface com Serviços disponíveis.
        APIService service = ConnectionServer.getInstance().getService();

        // Requisição dos Sines. O retorno é tratado pelos métodos onResponse e onFailure.
        Call<List<Sine>> call = service.getSines();
    }

    @Override
    public void onResponse(Call<List<Sine>> call, Response<List<Sine>> response) {

        Log.i("MainActivity", "Carregando Sines");

        if (response.isSuccessful()) {
            // Sines recuperados no servidor.
            sines = response.body();

            for (Sine sine: sines) {
                Log.i("MainActivity", sine.toString());
            }
        }
    }

    @Override
    public void onFailure(Call<List<Sine>> call, Throwable t) {

        Log.e("MainActivity", t.getMessage().toString());
    }
}
