package com.example.usuario.inventoryfragment.ui.dependency.interactor;

import android.text.TextUtils;

import com.example.usuario.inventoryfragment.db.repository.DependencyRepository;
import com.example.usuario.inventoryfragment.pojo.Dependency;
import com.example.usuario.inventoryfragment.ui.utils.CommonUtils;

import java.util.ArrayList;

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
        else {
            DependencyRepository.getInstance().addDependency(new Dependency(DependencyRepository.getInstance().getDependencies().size()+1, name, shortname, description));
            listener.onSuccess();
        }
    }

    public interface OnAddEditDependencyFinishedListener {
        void onNameEmptyError();
        void onNameAlreadyExistError();
        void onShortNameEmptyError();
        void onShortnameAlreadyExistError();
        void onSuccess();
    }
}
