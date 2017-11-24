package com.example.usuario.inventoryfragment.ui.dependency;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.usuario.inventoryfragment.R;
import com.example.usuario.inventoryfragment.ui.base.BasePresenter;
import com.example.usuario.inventoryfragment.ui.dependency.contract.AddEditDependencyContract;
import com.example.usuario.inventoryfragment.ui.dependency.interactor.AddEditInteractor;

/**
 * @author Alfonso Chamorro Valle
 */

public class AddEditDependency extends Fragment implements AddEditDependencyContract.View, AddEditInteractor.OnAddEditDependencyFinishedListener {

    public static final String TAG = "AddEditDependency";
    private AddEditDependencyContract.Presenter presenter;

    private FloatingActionButton fab;
    private TextInputLayout tilName;
    private TextInputLayout tilShortName;
    private TextInputLayout tilDescription;

    public static AddEditDependency newInstance(Bundle arguments) {
        AddEditDependency addEditDependency = new AddEditDependency();
        if(arguments != null) {
            addEditDependency.setArguments(arguments);
        }
        return addEditDependency;
    }

    @Nullable
    @Override
    public android.view.View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_edit_dependency, container, false);
        tilName = rootView.findViewById(R.id.tilName);
        tilShortName = rootView.findViewById(R.id.tilShortName);
        tilDescription = rootView.findViewById(R.id.tilDescription);
        fab = rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.validateDependency();
            }
        });

        if(getArguments() != null) {

        }
        return rootView;
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (AddEditDependencyContract.Presenter) presenter;
    }

    @Override
    public void onNameEmptyError() {
        tilName.setError("El nombre no puede estar vacío");
    }

    @Override
    public void onNameAlreadyExistError() {
        tilName.setError("El nombre no puede estar vacío");
    }

    @Override
    public void onShortNameEmptyError() {
        tilShortName.setError("El nombre no puede estar vacío");
    }

    @Override
    public void onShortnameAlreadyExistError() {
        tilShortName.setError("El nombre no puede estar vacío");
    }

    @Override
    public void onSuccess() {
        tilName.setError("El nombre no puede estar vacío");
    }
}
