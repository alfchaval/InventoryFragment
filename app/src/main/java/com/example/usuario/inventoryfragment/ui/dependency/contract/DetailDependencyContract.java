package com.example.usuario.inventoryfragment.ui.dependency.contract;

import com.example.usuario.inventoryfragment.ui.base.BasePresenter;
import com.example.usuario.inventoryfragment.ui.base.BaseView;

/**
 * Created by usuario on 11/23/17.
 */

public interface DetailDependencyContract {

    interface View extends BaseView {
    }

    interface Presenter extends BasePresenter{
        void addNewDependency();
    }
}
