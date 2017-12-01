package com.example.usuario.inventoryfragment.ui.dependency.presenter;

import com.example.usuario.inventoryfragment.pojo.Dependency;
import com.example.usuario.inventoryfragment.ui.dependency.contract.AddEditDependencyContract;
import com.example.usuario.inventoryfragment.ui.dependency.interactor.AddEditInteractor;

public class AddEditPresenter implements AddEditDependencyContract.Presenter, AddEditInteractor.OnAddEditDependencyFinishedListener {

    private AddEditDependencyContract.View view;
    private AddEditInteractor addEditInteractor = new AddEditInteractor();

    public AddEditPresenter(AddEditDependencyContract.View view) {
        this.view = view;
    }

    @Override
    public void onNameEmptyError() {
        view.setNameEmptyError();
    }

    @Override
    public void onNameAlreadyExistError() {
        view.setNameAlreadyExistError();
    }

    @Override
    public void onShortNameEmptyError() {
        view.setShortNameEmptyError();
    }

    @Override
    public void onShortnameAlreadyExistError() {
        view.setShortNameAlreadyExistError();;
    }

    @Override
    public void onDependencyExists() {
        view.setValidateDependencyError();
    }

    @Override
    public void onSuccess() {
        view.navigateToHome();
    }

    @Override
    public void saveDependency(String name, String shortName, String description) {
        addEditInteractor.validateDependency(name, shortName, description, this);
    }

    @Override
    public void editDependency(Dependency dependency) {
        addEditInteractor.editDependency(dependency, this);
    }

    @Override
    public void onDestroy() {
        view = null;
        addEditInteractor = null;
    }
}