package br.edu.ifpb.imageapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView nomesListView = (ListView) findViewById(R.id.nomeListView);

        List<String> nomes = new ArrayList<String>();
        nomes.add("Gabriel");
        nomes.add("Jaqueline");
        nomes.add("Diego");

        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, nomes);

        nomesListView.setAdapter(adapter);
    }
}
