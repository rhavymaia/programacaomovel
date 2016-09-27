package br.edu.ifpb.gsonapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.util.Date;

import br.edu.ifpb.gsonapp.asynctask.CadastrarPessoaAsyncTask;
import br.edu.ifpb.gsonapp.entidade.Pessoa;

public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button enviarButton = (Button) findViewById(R.id.enviarButton);
        enviarButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("João");
        pessoa.setEndereco("Rua Tranquilino Coelho");
        pessoa.setNascimento(new Date());

        CadastrarPessoaAsyncTask cadastrarPessoaAsyncTask = new CadastrarPessoaAsyncTask();
        cadastrarPessoaAsyncTask.execute(pessoa);
    }
}
