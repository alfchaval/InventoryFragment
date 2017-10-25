package com.example.usuario.inventory;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by usuario on 10/25/17.
 */

public class InventoryApplication extends Application {

    ArrayList<Dependency> dependencies;

    public InventoryApplication() {
        dependencies = new ArrayList();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        addDependency(new Dependency(1, "1º Ciclo Formativo Grado Superior", "1CFGS",
                "1CFGS Desarrollo de aplicaciones multiplataforma"));
        addDependency(new Dependency(2, "2º Ciclo Formativo Grado Superior", "2CFGS",
                "2CFGS Desarrollo de aplicaciones multiplataforma"));
    }

    /**
     * Método que añade una dependencia
     * @param dependency
     */

    public int addDependency(Dependency dependency) {
        dependencies.add(dependency);
        return dependency.get_ID();
    }

    public ArrayList<Dependency> getDependencies() {
        return dependencies;
    }
}
