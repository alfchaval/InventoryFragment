package com.example.usuario.inventoryfragment.ui.dependency;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.usuario.inventoryfragment.R;
import com.example.usuario.inventoryfragment.ui.base.BaseActivity;
import com.example.usuario.inventoryfragment.ui.dependency.presenter.AddEditPresenter;
import com.example.usuario.inventoryfragment.ui.dependency.presenter.DetailPresenter;
import com.example.usuario.inventoryfragment.ui.dependency.presenter.ListPresenter;

/**
 * @author Alfonso Chamorro Valle
 * Activity con una lista de dependencias
 */

public class DependencyActivity extends BaseActivity implements ListDependency.listDependencyListener{

    private ListDependency listDependency;
    private AddEditDependency addEditDependency;
    private DetailDependency detailDependency;

    private ListPresenter listPresenter;
    private AddEditPresenter addEditPresenter;
    private DetailPresenter detailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //1. Se crea la vista
        listDependency = (ListDependency)fragmentManager.findFragmentByTag(ListDependency.TAG);
        if(listDependency == null) {
            listDependency = ListDependency.newInstance(null);
            fragmentTransaction.add(android.R.id.content, listDependency, ListDependency.TAG);
            fragmentTransaction.commit();
        }
        //2. Se cra el presentador, y se le pasa en el constructor la vista correspondiente
        listPresenter = new ListPresenter(listDependency);
        listDependency.setPresenter(listPresenter);
    }

    /**
     * Método que se ejecuta cuando se crea una nueva Dependency
     */
    @Override
    public void addNewDependency() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //1. Se crea la vista
        addEditDependency = (AddEditDependency) fragmentManager.findFragmentByTag(AddEditDependency.TAG);
        if(addEditDependency == null) {
            addEditDependency = AddEditDependency.newInstance(null);
            fragmentTransaction.replace(android.R.id.content, addEditDependency, AddEditDependency.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        //2. Se crea el presentador, y se le pasa al constructor la vista conrrespondiente
        addEditPresenter = new AddEditPresenter(addEditDependency);
    }
}
