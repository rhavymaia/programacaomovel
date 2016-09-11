package br.edu.ifpb.listenerapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.enviarButton);
        button.setOnClickListener(new LimparOnClickListener());
    }

    @Override
    public void onClick(View view) {
        Log.i("ListenerApp","Enviando dados!.");
    }
}
