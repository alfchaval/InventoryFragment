package com.example.usuario.inventoryfragment.ui.dependency.interactor;

import com.example.usuario.inventoryfragment.db.repository.DependencyRepository;
import com.example.usuario.inventoryfragment.pojo.Dependency;
import com.example.usuario.inventoryfragment.ui.dependency.contract.ListDependencyContract;
import com.example.usuario.inventoryfragment.ui.dependency.presenter.ListDependencyPresenter;

/**
 * Created by usuario on 11/23/17.
 */

public class ListInteractor {

    private ListDependencyPresenter listener;

    public ListInteractor(ListDependencyPresenter listener) {
        this.listener=listener;
    }

    public void loadDependency() {
        listener.onSuccess(DependencyRepository.getInstance().getDependencies());
    }

    public void deleteDependency(Dependency dependency, ListDependencyContract.Interactor.OnFinishedLoadDependency onFinishedLoadDependency) {
        DependencyRepository.getInstance().deleteDependency(dependency);
        listener.onSuccess(DependencyRepository.getInstance().getDependencies());
    }
}
