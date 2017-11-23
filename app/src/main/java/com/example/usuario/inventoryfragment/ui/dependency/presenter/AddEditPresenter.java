package com.example.usuario.inventoryfragment.ui.dependency.presenter;

import com.example.usuario.inventoryfragment.ui.dependency.contract.AddEditDependencyContract;

/**
 * Created by usuario on 11/23/17.
 */

public class AddEditPresenter implements AddEditDependencyContract.Presenter {

    AddEditDependencyContract.View view;

    public AddEditPresenter(AddEditDependencyContract.View view) {
        this.view = view;
    }

    @Override
    public void addNewDependency() {

    }
}