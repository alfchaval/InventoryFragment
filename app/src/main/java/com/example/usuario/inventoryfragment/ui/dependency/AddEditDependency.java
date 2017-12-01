package com.example.usuario.inventoryfragment.ui.dependency;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.usuario.inventoryfragment.R;
import com.example.usuario.inventoryfragment.db.repository.DependencyRepository;
import com.example.usuario.inventoryfragment.pojo.Dependency;
import com.example.usuario.inventoryfragment.ui.base.BaseFragment;
import com.example.usuario.inventoryfragment.ui.base.BasePresenter;
import com.example.usuario.inventoryfragment.ui.dependency.contract.AddEditDependencyContract;
import com.example.usuario.inventoryfragment.ui.dependency.contract.ListDependencyContract;
import com.example.usuario.inventoryfragment.ui.dependency.interactor.AddEditInteractor;
import com.example.usuario.inventoryfragment.ui.utils.AddEdit;

/**
 * @author Alfonso Chamorro Valle
 */

public class AddEditDependency extends BaseFragment implements AddEditDependencyContract.View {

    public static final String TAG = "AddEditDependency";
    public static final String EDIT_KEY = "edit";
    private AddEditDependencyContract.Presenter presenter;
    private ListDependency.ListDependencyListener callback;
    private AddEdit addEditMode;

    private FloatingActionButton fab;
    private TextInputLayout tilName;
    private TextInputLayout tilShortName;
    private TextInputLayout tilDescription;
    private EditText edtName;
    private EditText edtShortName;
    private EditText edtDescription;

    int position = -1;

    public static AddEditDependency newInstance(Bundle arguments) {
        AddEditDependency addEditDependency = new AddEditDependency();
        if(arguments != null) {
            addEditDependency.setArguments(arguments);
        }
        return addEditDependency;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            callback = (ListDependency.ListDependencyListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().getLocalClassName() + " must implements ListDependencyListener");
        }
    }

    @Nullable
    @Override
    public android.view.View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_add_edit_dependency, container, false);

        tilName = rootView.findViewById(R.id.tilName);
        tilShortName = rootView.findViewById(R.id.tilShortName);
        tilDescription = rootView.findViewById(R.id.tilDescription);

        edtName = rootView.findViewById(R.id.edtName);
        edtName.addTextChangedListener(textWatcher);
        edtShortName = rootView.findViewById(R.id.edtShortName);
        edtShortName.addTextChangedListener(textWatcher);
        edtDescription = rootView.findViewById(R.id.edtDescription);
        edtDescription.addTextChangedListener(textWatcher);

        fab = rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (addEditMode.getMode() == AddEdit.ADD_MODE) {
                    presenter.addDependency(tilName.getEditText().getText().toString(), tilShortName.getEditText().getText().toString(), tilDescription.getEditText().getText().toString());
                }
                else if (addEditMode.getMode() == AddEdit.EDIT_MODE) {
                    Dependency dependency = getArguments().getParcelable(EDIT_KEY);
                    dependency.setDescription(edtDescription.getText().toString());
                    presenter.editDependency(dependency);
                }
            }
        });

        addEditMode = new AddEdit();
        if(getArguments() != null) {
            edtName.setText(this.getArguments().getString("nombre"));
            edtShortName.setText(this.getArguments().getString("shortname"));
            edtDescription.setText(this.getArguments().getString("descripcion"));
            position = this.getArguments().getInt("posicion");
            addEditMode.setMode(AddEdit.EDIT_MODE);
        }
        else {
            addEditMode.setMode(AddEdit.ADD_MODE);
        }
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (addEditMode.getMode() == AddEdit.EDIT_MODE) {
            Dependency dependency = getArguments().getParcelable(EDIT_KEY);

            edtName.setText(dependency.getName());
            edtName.setEnabled(false);

            edtShortName.setText(dependency.getShortName());
            edtShortName.setEnabled(false);

            edtDescription.setText(dependency.getDescription());
        }
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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void navigateToHome() {
        DependencyRepository dependencyRepository = DependencyRepository.getInstance();

        if(addEditMode.getMode() == AddEdit.EDIT_MODE) {
            dependencyRepository.getDependencies().get(position).setName(edtName.getText().toString());
            dependencyRepository.getDependencies().get(position).setShortName(edtShortName.getText().toString());
            dependencyRepository.getDependencies().get(position).setDescription(edtDescription.getText().toString());
        }
        else{
            dependencyRepository.addDependency(new Dependency(dependencyRepository.getDependencies().toArray().length, edtName.getText().toString(), edtShortName.getText().toString(), edtDescription.getText().toString()));
        }
        //callback.listNewDependency();
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

    @Override
    public void setValidateDependencyError() {

    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }

    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    private TextWatcher textWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            tilName.setError(null);
            tilShortName.setError(null);
            tilDescription.setError(null);
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}
