package br.edu.ifpb.gsonapp.asynctask;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import br.edu.ifpb.gsonapp.entidade.Pessoa;

/**
 * Created by Rhavy on 26/09/2016.
 */
public class CadastrarPessoaAsyncTask extends AsyncTask<Pessoa, Void, String> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Pessoa... pessoas) {

        try {
            // Converter Pessoa para Json
            Gson gson = new Gson();
            String pessoaJson = gson.toJson(pessoas[0]);

            Log.i("MainActivity", pessoaJson);

            // Conectar com o servidor e enviar os dados.
            URL url = new URL("ladoss.com.br:8080/meuservico");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.connect();
            // create data output stream

            DataOutputStream wr = new DataOutputStream(
                    urlConnection.getOutputStream());
            // write to the output stream from the string
            wr.writeBytes(pessoaJson);
            wr.close();

        } catch (IOException e) {

            Log.e("CadastrarPessoa", e.getMessage());
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
