package br.edu.ifpb.textwatcherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nomeEditText;
    TextView hintTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Associar os componentes do Layout com a Activity.
        nomeEditText = (EditText) findViewById(R.id.nomeEditText);
        hintTextView = (TextView) findViewById(R.id.hintTextView);

        // Listener do TextWatcher.
        nomeEditText.addTextChangedListener(watch);
    }

    // Listener do EditText.
    TextWatcher watch = new TextWatcher(){

        @Override
        public void afterTextChanged(Editable s) {}

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        /**
         * Acompanha os valores digitados no campo de edição de texto (EditText).
         * @param text
         * @param start
         * @param before
         * @param count
         */
        @Override
        public void onTextChanged(CharSequence text,
                                  int start,
                                  int before,
                                  int count) {
            // Inserir texto digitado no EditText no TextView.
            hintTextView.setText(text);

            // Exibir a mensagem caso o texto digitado tenha 9 caracteres.
            if(text.length() >= 10){
                Toast.makeText(getApplicationContext(),
                        "Tamanho máximo alcançado.",
                        Toast.LENGTH_SHORT).show();
            }
        }
    };
}
