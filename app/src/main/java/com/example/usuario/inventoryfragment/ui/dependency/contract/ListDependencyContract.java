package com.example.usuario.inventoryfragment.ui.dependency.contract;

import com.example.usuario.inventoryfragment.pojo.Dependency;
import com.example.usuario.inventoryfragment.ui.base.BasePresenter;
import com.example.usuario.inventoryfragment.ui.base.BaseView;

import java.util.List;

/**
 * Created by usuario on 11/23/17.
 */

public interface ListDependencyContract {

    interface View extends BaseView{
        void showDependency(List<Dependency> list);
    }

    interface Presenter extends BasePresenter{
        void addNewDependency();
    }
}
