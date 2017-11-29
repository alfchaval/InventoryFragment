package com.example.usuario.inventoryfragment.ui.dependency.interactor;

import com.example.usuario.inventoryfragment.db.repository.DependencyRepository;
import com.example.usuario.inventoryfragment.ui.dependency.presenter.ListPresenter;

/**
 * Created by usuario on 11/23/17.
 */

public class ListInteractor {

    private ListPresenter listener;

    public ListInteractor(ListPresenter listener) {
        this.listener=listener;
    }

    public void loadDependency() {
        listener.onSuccess(DependencyRepository.getInstance().getDependencies());
    }
}
