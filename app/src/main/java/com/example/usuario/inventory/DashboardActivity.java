package com.example.usuario.inventory;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.widget.ImageView;

public class DashboardActivity extends AppCompatActivity {

    private GridLayout gridDashboard;
    private ClickListenerDashboard listenerDashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_support);

        gridDashboard = (GridLayout) findViewById(R.id.gridDashboard);

        //Definir un array de int, que contendrá el id de las imágenes Inventory

        int[] images = {
                R.drawable.inventory_icon,
                R.drawable.product_icon,
                R.drawable.dependences_icon,
                R.drawable.sections_icon,
                R.drawable.preferences_icon,
        };

        /*
        int[] images = {
                R.drawable.closet,
                R.drawable.inventory,
                R.drawable.cpu,
                R.drawable.chair,
                R.drawable.keyboard,
                R.drawable.monitor,
                R.drawable.mouse,
                R.drawable.printer,
                R.drawable.proyector,
                R.drawable.table,
                R.drawable.whiteboard
        };
        */

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
            imageView.setId(i);
            imageView.setImageResource(images[i]);
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
                case 0:
                    intent = new Intent(DashboardActivity.this, InventoryActivity.class);
                    break;
                case 1:
                    intent = new Intent(DashboardActivity.this, ProductActivity.class);
                    break;
                case 2:
                    intent = new Intent(DashboardActivity.this, DependencyActivity.class);
                    break;
            }
                if(intent != null) startActivity(intent);
        }
    }
}