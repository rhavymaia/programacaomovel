package br.edu.ifpb.gerenciadoreslayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("GerenciadoresLayout","Criação da aplicação.");

        Button enviarButton = findViewById(R.id.enviarButton);
        enviarButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Mensagem no LogCat.
        Log.i("GerenciadoresLayout","Botão apertado.");

        // Exibir o Toast.
        EditText nomeEditText = findViewById(R.id.nomeEditText);
        String nome = nomeEditText.getText().toString();
        mostrarToast(nome);

        // Preparando valores para enviar para a próxima Activity.
        Bundle bundle = new Bundle();
        bundle.putString("nome", nome);

        // Intent: redirecionar para tela do Home.
        Intent it = new Intent(MainActivity.this, HomeActivity.class);

        // Adicionar valores na Intent.
        it.putExtras(bundle);

        startActivity(it);
    }

    private void mostrarToast(String texto) {

        Context contexto = getApplicationContext();
        int duracao = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(contexto, texto, duracao);
        toast.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("GerenciadoresLayout","Aplicação pronta no Resume!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("GerenciadoresLayout","Pause acionado!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("GerenciadoresLayout","Stop acionado!");
    }
}
