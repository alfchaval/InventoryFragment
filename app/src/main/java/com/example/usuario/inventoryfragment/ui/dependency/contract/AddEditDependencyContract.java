package com.example.usuario.inventoryfragment.ui.dependency.contract;

import com.example.usuario.inventoryfragment.ui.base.BasePresenter;
import com.example.usuario.inventoryfragment.ui.base.BaseView;
import com.example.usuario.inventoryfragment.ui.dependency.interactor.AddEditInteractor;


public interface AddEditDependencyContract {

    interface View extends BaseView {
        void setNameEmptyError();
        void setNameAlreadyExistError();
        void setShortNameEmptyError();
        void setShortNameAlreadyExistError();
    }

    interface Presenter extends BasePresenter{
        void validateDependency(String name, String shortname, String description, AddEditInteractor.OnAddEditDependencyFinishedListener onAddEditDependencyFinishedListener);
    }
}