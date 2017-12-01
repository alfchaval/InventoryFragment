package com.example.usuario.inventoryfragment.ui.dependency;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ListFragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.usuario.inventoryfragment.DashboardActivity;
import com.example.usuario.inventoryfragment.R;
import com.example.usuario.inventoryfragment.adapter.DependencyAdapter;
import com.example.usuario.inventoryfragment.pojo.Dependency;
import com.example.usuario.inventoryfragment.ui.base.BasePresenter;
import com.example.usuario.inventoryfragment.ui.dependency.contract.ListDependencyContract;
import com.example.usuario.inventoryfragment.ui.dependency.presenter.ListPresenter;
import com.example.usuario.inventoryfragment.ui.prefs.AccountSettingsActivity;
import com.example.usuario.inventoryfragment.ui.prefs.GeneralSettingsActivity;
import com.example.usuario.inventoryfragment.ui.utils.CommonDialog;

import java.util.List;

/**
 * Created by usuario on 11/23/17.
 */

public class ListDependency extends ListFragment  implements ListDependencyContract.View {

    public static final String TAG = "ListDependency";
    private DependencyAdapter dependencyAdapter;
    ListPresenter presenter;
    ListDependencyListener callback;

    interface ListDependencyListener {
        void addNewDependency(Bundle bundle);
        void onSuccess();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callback = (ListDependencyListener) activity;
        }catch (ClassCastException e) {
            throw new ClassCastException(getActivity().getLocalClassName() + " must implement ListDependencyListener");
        }
    }

    public static ListDependency newInstance(Bundle arguments) {
        ListDependency listDependency = new ListDependency();
        if(arguments != null) {
            listDependency.setArguments(arguments);
        }
        return listDependency;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list_dependency, container, false);
        //Como se encuentra en el fragment, usamos rootView
        FloatingActionButton fab = (FloatingActionButton)rootView.findViewById(R.id.fab);
        //Si el floatingActionButton se encontrara en el xml de la Activuty
        //FloatingActionButton fab = (FloatingActionButton)getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.addNewDependency(null);
            }
        });
        dependencyAdapter = new DependencyAdapter(getActivity());
        setListAdapter(dependencyAdapter);
        presenter = new ListPresenter(this);
        presenter.loadDependency();
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dependencyAdapter = new DependencyAdapter(getActivity());
        setRetainInstance(true);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setListAdapter(dependencyAdapter);

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Dependency dependency = (Dependency) parent.getItemAtPosition(position);
                Bundle bundle = new Bundle();
                bundle.putParcelable(AddEditDependency.EDIT_KEY, dependency);
                callback.addNewDependency(bundle);
            }
        });
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (ListPresenter) presenter;
    }

    public void showDependency(List<Dependency> list)
    {
        //dependencyAdapter.clear();
        dependencyAdapter.addAll(list);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Opciones lista de dependencia");
        getActivity().getMenuInflater().inflate(R.menu.menu_list_dependency, menu);
    }


    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Dependency dependency = (Dependency) getListView().getItemAtPosition(info.position);

        switch (item.getItemId()) {
            case R.id.action_list_dependency_delete:
                Bundle bundle = new Bundle();
                bundle.putString(CommonDialog.MESSAGE, "Desea eliminar la dependencia");
                bundle.putString(CommonDialog.TITLE, "Eliminar dependencia");
                bundle.putParcelable(CommonDialog.DEPENDENCY, dependency);
                Dialog dialog = CommonDialog.showConfirmDialog(bundle, getActivity(), presenter);
                dialog.show();
                break;
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity_sort_dependencies, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_sortName:

                break;
            case R.id.action_sortShotName:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
