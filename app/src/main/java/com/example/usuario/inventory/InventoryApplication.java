package com.example.usuario.inventory;

import android.app.Application;

import com.example.usuario.inventory.pojo.Dependency;
import com.example.usuario.inventory.repository.DependencyRepository;

import java.util.ArrayList;

/**
 * Created by usuario on 10/25/17.
 */

public class InventoryApplication extends Application {

    public InventoryApplication() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public DependencyRepository getDependencyRepository() {
        return getDependencyRepository();
    }
}
