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
        imagemAsyncTask.execute("https://www.ifpb.edu.br/campinagrande/noticias/2016/09/" +
                "processo-seletivo-do-ifpb-oferta-dois-novos-cursos-no-campus-campina/" +
                "psct-2017.jpg/@@images/0d03103f-6ab6-43d4-8870-2d6bd725a30e.jpeg");
    }
}
