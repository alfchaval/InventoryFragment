package com.example.usuario.inventoryfragment.ui.dependency.contract;

import com.example.usuario.inventoryfragment.pojo.Dependency;
import com.example.usuario.inventoryfragment.ui.base.BasePresenter;
import com.example.usuario.inventoryfragment.ui.base.BaseView;
import com.example.usuario.inventoryfragment.ui.dependency.interactor.AddEditInteractor;


public interface AddEditDependencyContract {

    interface View extends BaseView {
        void navigateToHome();
        void setNameEmptyError();
        void setNameAlreadyExistError();
        void setShortNameEmptyError();
        void setShortNameAlreadyExistError();
        void setValidateDependencyError();
    }

    interface Presenter extends BasePresenter{
        void addDependency(String name, String shortName, String description);
        void editDependency(Dependency dependency);
    }
}