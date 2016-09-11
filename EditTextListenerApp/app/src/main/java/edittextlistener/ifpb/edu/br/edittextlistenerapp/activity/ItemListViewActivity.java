package edittextlistener.ifpb.edu.br.edittextlistenerapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import edittextlistener.ifpb.edu.br.edittextlistenerapp.R;

public class ItemListViewActivity extends Activity implements View.OnClickListener{

    List<String> nomes;

    ArrayAdapter<String> nomesAdapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list_view);

        nomes = new ArrayList<String>();

        nomesAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, nomes);

        ListView nomesListView = (ListView) findViewById(R.id.nomesListView);
        nomesListView.setAdapter(nomesAdapter);
    }

    @Override
    public void onClick(View v) {

    }
}
