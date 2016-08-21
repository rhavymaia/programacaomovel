package br.edu.ifpb.edittextexemplos.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import br.edu.ifpb.edittextexemplos.R;

public class SplashActivity extends Activity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(this, 3000);
    }

    @Override
    public void run() {

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

        finish();
    }
}
