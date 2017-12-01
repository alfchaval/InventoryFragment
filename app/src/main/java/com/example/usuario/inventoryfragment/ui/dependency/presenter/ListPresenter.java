package com.example.usuario.inventoryfragment.ui.dependency.presenter;

import com.example.usuario.inventoryfragment.pojo.Dependency;
import com.example.usuario.inventoryfragment.ui.dependency.contract.ListDependencyContract;
import com.example.usuario.inventoryfragment.ui.dependency.interactor.ListInteractor;

import java.util.List;

/**
 * Created by usuario on 11/23/17.
 */

public class ListPresenter implements ListDependencyContract.Presenter, ListDependencyContract.Interactor.OnFinishedLoadDependency {

    ListDependencyContract.View view;
    ListInteractor listInteractor;

    public ListPresenter(ListDependencyContract.View view) {
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

    @Override
    public void onDestroy() {
        //view = null;
        //listInteractor = null;
    }
}