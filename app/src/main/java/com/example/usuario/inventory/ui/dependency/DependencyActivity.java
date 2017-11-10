package com.example.usuario.inventory.ui.dependency;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.example.usuario.inventory.R;
import com.example.usuario.inventory.adapter.DependencyAdapter;

/**
 * @author Alfonso Chamorro Valle
 * Activity con una lista de dependencias
 */

public class DependencyActivity extends AppCompatActivity {

    //private ArrayAdapter<Dependency> dependencies;
    private DependencyAdapter adapter;
    private ListView listview;
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);
        //CASO 1: Adapter no personalizado
        //adapter = new ArrayAdapter<Dependency>(this, android.R.layout.simple_list_item_1, DependencyRepository.getInstance().getDependencies());
        //CASO 2: Adapter personalizado
        adapter = new DependencyAdapter(this);
        listview = (ListView) findViewById(android.R.id.list);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        fab = findViewById(R.id.fab);
        coordinatorLayout = findViewById(R.id.coordinator);

        listview.setAdapter(adapter);
        setSupportActionBar(toolbar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(coordinatorLayout, "Ejemplo Snackbar", Snackbar.LENGTH_SHORT).show();
                startActivity(new Intent(DependencyActivity.this, AddDependencyActivity.class));
            }
        });
    }
}
