package com.example.usuario.inventory;


import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Vector;

public class DashboardActivity extends AppCompatActivity {

    private GridLayout gridDashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_support);
        gridDashboard = (GridLayout) findViewById(R.id.gridDashboard);

        //Definir un array de int, que contendrá el id de las imágenes

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

        //No se utiliza en Java/android array de objetos. Se utiliza Vector o Colecciones
        //ImageView[] imageViews = new ImageView[images.length];

        //No utilizamos la clase Vector porque no trabajamos con hilos y no se requiere sincronización
        //Vector<ImageView> vectorImageViews = new Vector<ImageView>();

        ImageView imageView;
        float width = getResources().getDimension(R.dimen.imgDashboardWidth);
        float height = getResources().getDimension(R.dimen.imgDashboardHeight);

        for (int view: images) {
            imageView = new ImageView(this);
            imageView.setImageResource(view);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = (int) width;
            params.height = (int) height;
            params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f);
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f);
            imageView.setLayoutParams(params);
            gridDashboard.addView(imageView);
        }
    }
}