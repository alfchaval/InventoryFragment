package com.example.usuario.inventory.repository;

import com.example.usuario.inventory.pojo.Dependency;

import java.util.ArrayList;

/**
 * Created by usuario on 10/26/17.
 */

public class DependencyRepository {

    /* Declaración */
    private ArrayList<Dependency> dependencies;
    private static DependencyRepository dependencyRepository;

    /* Inicialización */
    /* Inicializar todos los atributos de ámbito estático o de clase */
    static {
        dependencyRepository = new DependencyRepository();
    }

    public DependencyRepository() {
        this.dependencies = new ArrayList<>();
        initialize();
    }

    /**
     * El método ha de ser privado para garantizar que solo hay una instancia de Repository
     */
    private void initialize() {
        addDependency(new Dependency(1, "1º Ciclo Formativo Grado Superior", "1CFGS",
                "1CFGS Desarrollo de aplicaciones multiplataforma"));
        addDependency(new Dependency(2, "2º Ciclo Formativo Grado Superior", "2CFGS",
                "2CFGS Desarrollo de aplicaciones multiplataforma"));
    }

    /* Métodos */
    public static DependencyRepository getInstance() {
        /*
        if(dependencyRepository == null) {
            dependencyRepository = new DependencyRepository();
        }*/
        return dependencyRepository;
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
