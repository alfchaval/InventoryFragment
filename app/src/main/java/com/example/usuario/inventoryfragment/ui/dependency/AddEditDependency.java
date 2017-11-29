package com.example.usuario.inventoryfragment.ui.dependency;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.usuario.inventoryfragment.R;
import com.example.usuario.inventoryfragment.ui.base.BaseFragment;
import com.example.usuario.inventoryfragment.ui.base.BasePresenter;
import com.example.usuario.inventoryfragment.ui.dependency.contract.AddEditDependencyContract;
import com.example.usuario.inventoryfragment.ui.dependency.interactor.AddEditInteractor;

/**
 * @author Alfonso Chamorro Valle
 */

public class AddEditDependency extends BaseFragment implements AddEditDependencyContract.View {

    public static final String TAG = "AddEditDependency";
    private AddEditDependencyContract.Presenter presenter;
    private AddEditInteractor.OnAddEditDependencyFinishedListener callback;

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
                presenter.validateDependency(tilName.getEditText().getText().toString(),tilShortName.getEditText().getText().toString(), tilDescription.getEditText().getText().toString(), callback);
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

    public void showListDependency() {
        showMessage("Dependency saved");
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.popBackStack();
        //getActivity().finish();
        //startActivity(getActivity().getIntent());

    }

    @Override
    public void setNameEmptyError() {
        tilName.setError("El nombre no puede estar vacío");
    }

    @Override
    public void setNameAlreadyExistError() {
        tilName.setError("Ya existe el nombre de usuario");
    }

    @Override
    public void setShortNameEmptyError() {
        tilShortName.setError("El apodo no puede estar vacío");
    }

    @Override
    public void setShortNameAlreadyExistError() {
        tilShortName.setError("Ya existe el apodo");
    }

    public void onSuccess() {

    }
}
