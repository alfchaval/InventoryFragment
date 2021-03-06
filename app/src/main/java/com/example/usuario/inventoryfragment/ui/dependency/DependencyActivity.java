package com.example.usuario.inventoryfragment.ui.dependency;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.usuario.inventoryfragment.R;
import com.example.usuario.inventoryfragment.ui.base.BaseActivity;
import com.example.usuario.inventoryfragment.ui.dependency.presenter.AddEditPresenter;
import com.example.usuario.inventoryfragment.ui.dependency.presenter.DetailPresenter;
import com.example.usuario.inventoryfragment.ui.dependency.presenter.ListDependencyPresenter;

/**
 * @author Alfonso Chamorro Valle
 * Activity con una lista de dependencias
 */

public class DependencyActivity extends BaseActivity implements ListDependency.ListDependencyListener {

    private ListDependency listDependency;
    private AddEditDependency addEditDependency;
    private DetailDependency detailDependency;

    private ListDependencyPresenter listPresenter;
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
            fragmentTransaction.replace(android.R.id.content, listDependency, ListDependency.TAG);
            fragmentTransaction.commit();
        }

        //2. Se cra el presentador, y se le pasa en el constructor la vista correspondiente
        listPresenter = new ListDependencyPresenter(listDependency);

        //3. Asignar el presentador a su fragment
        listDependency.setPresenter(listPresenter);
    }

    /**
     * Método que se ejecuta cuando se crea una nueva Dependency
     */
    @Override
    public void addNewDependency(Bundle bundle) {
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

        //3. Asignar el presentador a su fragment
        addEditDependency.setPresenter(addEditPresenter);
    }

    public void listNewDependency(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(listDependency == null){
            listDependency = (ListDependency) fragmentManager.findFragmentByTag(ListDependency.TAG);
        }
        fragmentTransaction.replace( android.R.id.content,listDependency, ListDependency.TAG);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        //2. se crea el presentador y se le pasa
        listPresenter = new ListDependencyPresenter(listDependency);
        listDependency.setPresenter(listPresenter);
    }

    @Override
    public void onSuccess() {

    }
}
