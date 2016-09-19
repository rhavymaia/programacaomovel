package edittextlistener.ifpb.edu.br.edittextlistenerapp.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import edittextlistener.ifpb.edu.br.edittextlistenerapp.R;

public class SenhaActivity extends Activity implements TextWatcher{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senha);

        EditText senhaEditText = (EditText) findViewById(R.id.senhaEditText);
        senhaEditText.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.i("SenhaActivity", "Valor digitado: " + s);

        TextView senhaTextView = (TextView) findViewById(R.id.senhaTextView);
        senhaTextView.setText(s.toString());
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
