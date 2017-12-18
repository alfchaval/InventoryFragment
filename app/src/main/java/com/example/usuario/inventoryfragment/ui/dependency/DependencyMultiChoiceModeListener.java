package com.example.usuario.inventoryfragment.ui.dependency;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;

import com.example.usuario.inventoryfragment.R;
import com.example.usuario.inventoryfragment.ui.dependency.contract.ListDependencyContract;
import com.example.usuario.inventoryfragment.ui.dependency.presenter.ListDependencyPresenter;

/**
 * Created by usuario on 12/18/17.
 */

public class DependencyMultiChoiceModeListener implements AbsListView.MultiChoiceModeListener {

    private ListDependencyContract.Presenter presenter;
    private int count;

    @Override
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long l, boolean checked) {
        if(checked) {
            count++;
            presenter.setNewSelection(position.checked);
        }
        else {
            count--;
            presenter.removeSelection(position);
        }
        actionMode.setTitle(count+" seleccionados");
    }

    @Override
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        MenuInflater inflater = actionMode.getMenuInflater();
        inflater.inflate(R.menu.menu_list_dependency, menu);
        actionMode.setTitle("Iniciando ActionMode");
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.action_account_settings:
                presenter.deleteSelection();
                break;
        }
        actionMode.finish();
        return true;
    }

    @Override
    public void onDestroyActionMode(ActionMode actionMode) {
        count = 0;
        presenter.clearSelection();
    }
}
