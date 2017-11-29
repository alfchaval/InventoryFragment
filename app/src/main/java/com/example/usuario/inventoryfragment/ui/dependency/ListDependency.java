package com.example.usuario.inventoryfragment.ui.dependency;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.usuario.inventoryfragment.R;
import com.example.usuario.inventoryfragment.adapter.DependencyAdapter;
import com.example.usuario.inventoryfragment.pojo.Dependency;
import com.example.usuario.inventoryfragment.ui.base.BasePresenter;
import com.example.usuario.inventoryfragment.ui.dependency.contract.ListDependencyContract;
import com.example.usuario.inventoryfragment.ui.dependency.presenter.ListPresenter;

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
        void addNewDependency();
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
                callback.addNewDependency();
            }
        });
        presenter.loadDependency();
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.dependencyAdapter = new DependencyAdapter(getActivity());
        setRetainInstance(true);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListAdapter(new DependencyAdapter(getActivity()));
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (ListPresenter) presenter;
    }

    public void showDependency(List<Dependency> list)
    {
        dependencyAdapter.clear();
        dependencyAdapter.addAll(list);
    }
}
