package edittextlistener.ifpb.edu.br.edittextlistenerapp.activity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyListActivity extends ListActivity {

        public void onCreate(Bundle bundle) {

                super.onCreate(bundle);

                List<String> sos = new ArrayList<String>();
                sos.add("Android");
                sos.add("iPhone");

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                                android.R.layout.simple_list_item_1, sos);

                setListAdapter(adapter);
        }
}