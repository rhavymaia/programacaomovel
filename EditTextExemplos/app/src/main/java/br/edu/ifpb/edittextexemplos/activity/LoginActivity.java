package br.edu.ifpb.edittextexemplos.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import br.edu.ifpb.edittextexemplos.R;
import br.edu.ifpb.edittextexemplos.validation.EmailValidate;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view) {

        Log.i("EditTextExemplos", "Login do usuário.");

        EditText emailEditText = (EditText) findViewById(R.id.emailEditText);
        String email = emailEditText.getText().toString();


        if (!EmailValidate.isValidEmail(email)) {
            emailEditText.setError("E-mail inválido");
        } else {
            Log.i("EditTextExemplos", "E-mail: " + email);
        }

        EditText senhaEditText = (EditText) findViewById(R.id.senhaEditText);
        String senha = senhaEditText.getText().toString();

        if (senha == null
                || (senha !=null && senha.length() == 0)
                || (senha !=null && senha.length() > 5)) {

            senhaEditText.setError("Senha inválida");
        } else {
            Log.i("EditTextExemplos", "Senha: " + senha);
        }
    }
}
