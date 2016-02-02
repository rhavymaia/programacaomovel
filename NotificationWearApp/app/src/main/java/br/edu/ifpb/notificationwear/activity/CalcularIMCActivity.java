package br.edu.ifpb.notificationwear.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import br.edu.ifpb.notificationwear.R;
import br.edu.ifpb.notificationwear.asynctask.CalcularIMCAsyncTask;
import br.edu.ifpb.notificationwear.listener.CalcularIMCListener;

public class CalcularIMCActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.calcular_imc);

        Button calcularIMCButton = (Button) findViewById(R.id.calcularIMCButton);
        calcularIMCButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        // Calcular o IMC.
        Log.i("NotificationWearApp", "Clique no botão da AsyncTask");

        JSONObject geral = new JSONObject();

        try {
            // Peso
            EditText pesoEditText = (EditText) findViewById(R.id.pesoEditText);
            String peso = pesoEditText.getText().toString();
            geral.put("peso", peso);

            // Altura
            EditText alturaEditText = (EditText) findViewById(R.id.alturaEditText);
            String altura = alturaEditText.getText().toString();
            geral.put("altura", altura);

            CalcularIMCAsyncTask calcularIMCAsyncTask = new CalcularIMCAsyncTask(this);
            calcularIMCAsyncTask.execute(geral);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
