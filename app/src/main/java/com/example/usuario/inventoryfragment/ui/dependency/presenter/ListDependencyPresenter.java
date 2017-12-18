package com.example.usuario.inventoryfragment.ui.dependency.presenter;

import com.example.usuario.inventoryfragment.pojo.Dependency;
import com.example.usuario.inventoryfragment.ui.dependency.contract.ListDependencyContract;
import com.example.usuario.inventoryfragment.ui.dependency.interactor.ListInteractor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by usuario on 11/23/17.
 */

public class ListDependencyPresenter implements ListDependencyContract.Presenter, ListDependencyContract.Interactor.OnFinishedLoadDependency {

    ListDependencyContract.View view;
    ListInteractor listInteractor;

    public ListDependencyPresenter(ListDependencyContract.View view) {
        this.view = view;
        this.listInteractor = new ListInteractor(this);
    }

    @Override
    public void addNewDependency() {

    }

    public void loadDependency() {
        listInteractor.loadDependency();
    }

    @Override
    public void deleteDependency(Dependency dependency) {
        listInteractor.deleteDependency(dependency, this);
    }

    public void onSuccess(List<Dependency> list) {
        view.showDependency(list);
    }

    HashMap<Integer, Boolean> selection = new HashMap<>();

    /**
     * Método que elimina los elementos seleccionados en el mapa
     */
    @Override
    public void deleteSelection() {
        for (Map.Entry<Integer,Boolean> tmp:selection.entrySet()) {
            tmp.getKey();
        }
    }

    public void removeSelection(int position) {
        selection.remove(position);
    }

    public void setNewSelection(int position) {
        selection.put(position, true);
    }

    public void clearSelection() {
        selection.clear();
    }

    public boolean isPositionChecked(int position) {
        return  selection.get(position);
    }

    @Override
    public void onDestroy() {
        //view = null;
        //listInteractor = null;
    }
}