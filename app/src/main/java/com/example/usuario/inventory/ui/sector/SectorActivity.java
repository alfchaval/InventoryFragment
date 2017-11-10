package com.example.usuario.inventory.ui.sector;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.usuario.inventory.R;
import com.example.usuario.inventory.adapter.SectorAdapter;
import com.example.usuario.inventory.pojo.Sector;

/**
 * @author Alfonso Chamorro Valle
 * Activity con un grid de sectores
 */

public class SectorActivity extends AppCompatActivity {

    private RecyclerView recyclerSector;
    private SectorAdapter sectorAdapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector);
        recyclerSector = (RecyclerView) findViewById(R.id.rvSector);
        recyclerSector.setHasFixedSize(true);
        recyclerSector.setLayoutManager(new GridLayoutManager(this, 2));
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(savedInstanceState != null) {
            sectorAdapter = new SectorAdapter(savedInstanceState.<Sector>getParcelableArrayList("sector"));
        }
        else {
            sectorAdapter = new SectorAdapter();
        }
        recyclerSector.setAdapter(sectorAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity_sector, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Almaceno los sectores que se han modificado en la vista y no han sido guardados
     * para
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("sector", sectorAdapter.getSectorsModified());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}