package edittextlistener.ifpb.edu.br.edittextlistenerapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edittextlistener.ifpb.edu.br.edittextlistenerapp.R;

public class MostraSenhaActivity extends Activity implements OnClickListener, TextWatcher {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_senha);

        Button revelarButton = (Button) findViewById(R.id.revelarButton);
        revelarButton.setOnClickListener(this);

        EditText senhaEditText = (EditText) findViewById(R.id.senhaEditText);
        senhaEditText.addTextChangedListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.i("MostraSenhaActivity", "onClick");
        // Aqui 2
        EditText senhaEditText = (EditText) findViewById(R.id.senhaEditText);
        String senha = senhaEditText.getText().toString();

        TextView verificaSenhaTextView = (TextView) findViewById(R.id.verificaSenhaTextView);
        verificaSenhaTextView.setText(senha);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Log.i("MostraSenhaActivity", "beforeTextChanged");
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.i("MostraSenhaActivity", "onTextChanged");

        TextView verificaSenhaTextView = (TextView) findViewById(R.id.verificaSenhaTextView);
        verificaSenhaTextView.setText(s);
    }

    @Override
    public void afterTextChanged(Editable s) {
        Log.i("MostraSenhaActivity", "afterTextChanged");
    }
}
