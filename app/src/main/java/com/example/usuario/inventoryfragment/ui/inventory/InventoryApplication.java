package com.example.usuario.inventoryfragment.ui.inventory;

import android.app.Application;

import com.example.usuario.inventoryfragment.db.repository.DependencyRepository;

/**
 * @author Alfonso Chamorro Valle
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
