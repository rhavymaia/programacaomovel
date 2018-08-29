package br.edu.ifpb.gerenciadoreslayout;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TesteActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);

        Button button = findViewById(R.id.enviarButton);
        View.OnClickListener onClickListener = this;
        button.setOnClickListener(onClickListener);
    }

    @Override
    public void onClick(View v) {
        EditText editText = findViewById(R.id.nomeEditText);
        String nome = editText.getText().toString();
        Log.i("GerenciadorLayout", "Olá, " + nome);
    }
}
