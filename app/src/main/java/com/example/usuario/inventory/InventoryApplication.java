package com.example.usuario.inventory;

import android.app.Application;

import com.example.usuario.inventory.pojo.Dependency;
import com.example.usuario.inventory.repository.DependencyRepository;

import java.util.ArrayList;

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
