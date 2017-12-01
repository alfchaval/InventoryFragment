package com.example.usuario.inventoryfragment.db.repository;

import com.example.usuario.inventoryfragment.pojo.Dependency;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Alfonso Chamorro Valle
 * Repositorio de dependencias
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
        addDependency(new Dependency(3, "Ejemplo 3", "EJ3",
                "Esto es un ejemplo"));
        addDependency(new Dependency(4, "Ejemplo 4", "EJ4",
                "Esto es un ejemplo"));
        addDependency(new Dependency(5, "Ejemplo 5", "EJ5",
                "Esto es un ejemplo"));
        addDependency(new Dependency(6, "Ejemplo 6", "EJ6",
                "Esto es un ejemplo"));
        addDependency(new Dependency(7, "Ejemplo 7", "EJ7",
                "Esto es un ejemplo"));
        addDependency(new Dependency(8, "Ejemplo 8", "EJ8",
                "Esto es un ejemplo"));
        addDependency(new Dependency(9, "Ejemplo 9", "EJ9",
                "Esto es un ejemplo"));
        addDependency(new Dependency(10, "Ejemplo 10", "EJ10",
                "Esto es un ejemplo"));
        addDependency(new Dependency(11, "Ejemplo 11", "EJ11",
                "Esto es un ejemplo"));
        addDependency(new Dependency(12, "Ejemplo 12", "EJ12",
                "Esto es un ejemplo"));
        addDependency(new Dependency(13, "Ejemplo 13", "EJ13",
                "Esto es un ejemplo"));
    }

    /* Métodos */
    public static DependencyRepository getInstance() {
        if(dependencyRepository == null) {
            dependencyRepository = new DependencyRepository();
        }
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
        //El ArrayList se ordena según el criterio del método compareTo de la interfaz Comparable
        Collections.sort(dependencies);
        return dependencies;
    }

    public int getLastId() {
        return dependencies.get(dependencies.size() - 1).get_ID();
    }

    public boolean nameExist(String name) {
        boolean result = false;
        int index = 0;

        while (!result && index < dependencies.size()) {
            if (name.equals(dependencies.get(index).getName())) {
                result = true;
            } else {
                index++;
            }
        }

        return result;
    }

    public boolean shortNameExist(String shortname) {
        boolean result = false;
        int index = 0;

        while (!result && index < dependencies.size()) {
            if (shortname.equals(dependencies.get(index).getShortName())) {
                result = true;
            } else {
                index++;
            }
        }

        return result;
    }

    public boolean validateDependency(String name, String shortname) {
        return nameExist(name) || shortNameExist(shortname);
    }

    public void editDependency(Dependency dependency) {
        boolean found = false;
        int index = 0;

        while (!found && index < dependencies.size()) {
            if (dependency.get_ID() == dependencies.get(index).get_ID()) {
                dependencies.get(index).setDescription(dependency.getDescription());
                found = true;
            } else {
                index++;
            }
        }
    }

    public void deleteDependency(Dependency dependency) {
        boolean found = false;
        int index = 0;

        while (!found && index < dependencies.size()) {
            if (dependency.get_ID() == dependencies.get(index).get_ID()) {
                dependencies.remove(index);
                found = true;
            } else
                index++;
        }
    }
}
