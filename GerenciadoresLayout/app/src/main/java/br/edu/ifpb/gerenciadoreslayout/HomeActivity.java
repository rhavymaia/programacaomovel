package br.edu.ifpb.gerenciadoreslayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends Activity {

    List<String> nomes;
    ArrayAdapter<String> adpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent it = getIntent();
        String nome = it.getStringExtra("nome");

        TextView nomeTextView = findViewById(R.id.nomeTextView);
        nomeTextView.setText(nome);

        // ListView
        nomes = new ArrayList<String>();
        nomes.add("Teste");
        ListView campiListView = findViewById(R.id.campiListView);
        adpter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, nomes);
        campiListView.setAdapter(adpter);
    }
}
