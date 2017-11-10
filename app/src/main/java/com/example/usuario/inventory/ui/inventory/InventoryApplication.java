package com.example.usuario.inventory.ui.inventory;

import android.app.Application;

import com.example.usuario.inventory.db.repository.DependencyRepository;

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
