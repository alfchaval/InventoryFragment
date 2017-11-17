package com.example.usuario.inventory.ui.base;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import com.example.usuario.inventory.R;

/**
 * Created by usuario on 11/13/17.
 */

public class BaseActivity extends AppCompatActivity {

    public void onError(String message) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show();
    }

    public void onError(int resId) {
        Snackbar.make(findViewById(android.R.id.content), getResources().getString(resId), Snackbar.LENGTH_SHORT).show();
    }
}
