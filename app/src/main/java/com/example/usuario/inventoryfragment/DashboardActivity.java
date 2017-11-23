package com.example.usuario.inventoryfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.usuario.inventoryfragment.ui.dependency.DependencyActivity;
import com.example.usuario.inventoryfragment.ui.inventory.InventoryActivity;
import com.example.usuario.inventoryfragment.ui.prefs.AccountSettingsActivity;
import com.example.usuario.inventoryfragment.ui.prefs.GeneralSettingsActivity;
import com.example.usuario.inventoryfragment.ui.product.ProductActivity;
import com.example.usuario.inventoryfragment.ui.sector.SectorActivity;

/**
 * @author Alfonso Chamorro Valle
 * Menú de la aplicación
 */

public class DashboardActivity extends AppCompatActivity {

    private GridLayout gridDashboard;
    private ClickListenerDashboard listenerDashboard;

    private final int INVENTORY = R.drawable.inventory_icon;
    private final int PRODUCT = R.drawable.product_icon;
    private final int DEPENDENCIES = R.drawable.dependences_icon;
    private final int SECTOR = R.drawable.sector_icon;
    private final int PREFERENCES = R.drawable.preferences_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_support);

        gridDashboard = (GridLayout) findViewById(R.id.gridDashboard);

        //Definir un array de int, que contendrá el id de las imágenes Inventory

        int[] images = {
                INVENTORY, PRODUCT, DEPENDENCIES, SECTOR//, PREFERENCES
        };

        //No se utiliza en Java/android array de objetos. Se utiliza Vector o Colecciones
        //ImageView[] imageViews = new ImageView[images.length];

        //No utilizamos la clase Vector porque no trabajamos con hilos y no se requiere sincronización
        //Vector<ImageView> vectorImageViews = new Vector<ImageView>();

        listenerDashboard = new ClickListenerDashboard();

        ImageView imageView;
        float width = getResources().getDimension(R.dimen.imgDashboardWidth);
        float height = getResources().getDimension(R.dimen.imgDashboardHeight);

        for (int i = 0; i < images.length; i++) {
            imageView = new ImageView(this);
            imageView.setImageResource(images[i]);
            imageView.setId(images[i]);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = (int) width;
            params.height = (int) height;
            params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f);
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f);
            imageView.setLayoutParams(params);
            imageView.setOnClickListener(listenerDashboard);
            gridDashboard.addView(imageView);
        }
    }

    class ClickListenerDashboard implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()) {
                case INVENTORY:
                    intent = new Intent(DashboardActivity.this, InventoryActivity.class);
                    break;
                case PRODUCT:
                    intent = new Intent(DashboardActivity.this, ProductActivity.class);
                    break;
                case DEPENDENCIES:
                    intent = new Intent(DashboardActivity.this, DependencyActivity.class);
                    break;
                case SECTOR:
                    intent = new Intent(DashboardActivity.this, SectorActivity.class);
                    break;
                case PREFERENCES:
                    intent = new Intent(DashboardActivity.this, null);
                    break;
            }
                if(intent != null) startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity_dashboard, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_account_settings:
                startActivity(new Intent(DashboardActivity.this, AccountSettingsActivity.class));
                break;
            case R.id.action_general_settings:
                startActivity(new Intent(DashboardActivity.this, GeneralSettingsActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}