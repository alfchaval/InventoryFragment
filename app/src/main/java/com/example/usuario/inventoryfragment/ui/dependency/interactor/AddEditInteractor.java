package com.example.usuario.inventoryfragment.ui.dependency.interactor;

import android.text.TextUtils;

import com.example.usuario.inventoryfragment.db.repository.DependencyRepository;
import com.example.usuario.inventoryfragment.pojo.Dependency;

/**
 * Created by usuario on 11/23/17.
 */

public class AddEditInteractor {

    DependencyRepository dependencyRepository = DependencyRepository.getInstance();

    public void validateDependency(String name, String shortname, String description, OnAddEditDependencyFinishedListener listener) {

        if(TextUtils.isEmpty(name)) {
            listener.onNameEmptyError();
        }
        else if(dependencyRepository.nameExist(name)) {
            listener.onNameAlreadyExistError();
        }
        else if(TextUtils.isEmpty(shortname)) {
            listener.onShortNameEmptyError();
        }
        else if(dependencyRepository.shortNameExist(shortname)) {
            listener.onShortnameAlreadyExistError();
        }
        else if (DependencyRepository.getInstance().validateDependency(name, shortname)) {
            dependencyRepository.addDependency(new Dependency(dependencyRepository.getDependencies().size(), name, shortname, description));
            listener.onSuccess();
        } else {
            listener.onDependencyExists();
        }
    }

    public void addDependency(String name, String shortname, String description) {
        Dependency dependency = new Dependency(dependencyRepository.getDependencies().size(), name, shortname, description);
        dependencyRepository.addDependency(dependency);
    }

    public void editDependency(Dependency dependency, OnAddEditDependencyFinishedListener listener) {
        dependencyRepository.editDependency(dependency);
        listener.onSuccess();
    }

    public interface OnAddEditDependencyFinishedListener {
        void onNameEmptyError();
        void onNameAlreadyExistError();
        void onShortNameEmptyError();
        void onShortnameAlreadyExistError();
        void onDependencyExists();
        void onSuccess();
    }
}
