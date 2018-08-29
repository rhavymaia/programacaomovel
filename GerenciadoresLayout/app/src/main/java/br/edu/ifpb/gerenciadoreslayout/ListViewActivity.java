package br.edu.ifpb.gerenciadoreslayout;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends Activity
        implements OnItemClickListener{

    List<String> paises = new ArrayList<String>();
    ListView listview;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        paises.add("Brasil");
        paises.add("Argentina");

        // Criação da ListView e configuração do Adapter.
        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                paises);

        listview = (ListView) findViewById(R.id.paisesListView);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);

        Button adicionarButton = findViewById(R.id.adicionarButton);
        adicionarButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Log.i("ListView", "Clicou no botão");
        EditText paisEditText = findViewById(R.id.paisEditText);
        String pais = paisEditText.getText().toString();

        paises.add(pais);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Log.i("ListView", "Clicou no item do ListView");
        String pais = paises.get(position);

        Toast toast = Toast.makeText(this,
                "Clicou no item: " + position + " Valor: " + pais,
                Toast.LENGTH_LONG);
        toast.show();
    }
}
