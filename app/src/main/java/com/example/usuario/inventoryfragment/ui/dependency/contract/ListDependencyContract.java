package com.example.usuario.inventoryfragment.ui.dependency.contract;

/**
 * Created by usuario on 11/23/17.
 */

public interface ListDependencyContract {

    interface View {
        void setPresenter(ListDependencyContract.Presenter presenter);
    }

    interface Presenter {
        void addNewDependency();
    }
}
