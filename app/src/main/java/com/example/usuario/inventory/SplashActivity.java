package com.example.usuario.inventory;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.usuario.inventory.ui.login.LoginViewImpl;

/**
 * @author Alfonso Chamorro Valle
 * Splash al iniciar la aplicación
 */

public class SplashActivity extends AppCompatActivity {

    private int delay = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(SplashActivity.this, LoginViewImpl.class));
            }
        }, delay);


    }
}
