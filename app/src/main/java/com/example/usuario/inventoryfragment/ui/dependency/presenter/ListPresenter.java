package com.example.usuario.inventoryfragment.ui.dependency.presenter;

import com.example.usuario.inventoryfragment.ui.dependency.contract.ListDependencyContract;

/**
 * Created by usuario on 11/23/17.
 */

public class ListPresenter implements ListDependencyContract.Presenter {

    ListDependencyContract.View view;

    public ListPresenter(ListDependencyContract.View view) {
        this.view = view;
    }

    @Override
    public void addNewDependency() {

    }
}
