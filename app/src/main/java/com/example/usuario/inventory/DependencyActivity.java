package com.example.usuario.inventory;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class DependencyActivity extends ListActivity {

    private ArrayAdapter<Dependency> dependencies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);
        dependencies = new ArrayAdapter<Dependency>(this, android.R.layout.simple_list_item_1,
                ((InventoryApplication) getApplicationContext()).getDependencies());
        getListView().setAdapter(dependencies);
    }
}
