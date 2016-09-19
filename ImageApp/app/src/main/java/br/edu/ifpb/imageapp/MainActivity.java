package br.edu.ifpb.imageapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener{

    private ImageView imagemCarregadaImageView;
    private ProgressDialog simpleWaitDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button carregarImagemButton = (Button) findViewById(R.id.carregarImagemButton);
        carregarImagemButton.setOnClickListener(this);

        imagemCarregadaImageView = (ImageView) findViewById(R.id.imagemCarregadaImageView);
    }

    @Override
    public void onClick(View view) {
        Log.i("MainActivity","OnClick");

        ImagemAsyncTask imagemAsyncTask = new ImagemAsyncTask(imagemCarregadaImageView);
        imagemAsyncTask.execute("https://www.ifpb.edu.br/noticias/2016/09/psct-ifpb-seleciona-estudantes-para-cursos-tecnicos/postagem_geral_1.jpg/@@images/d49271ad-213a-4c83-b08a-ca321a844094.jpeg");
    }
}
