package com.example.usuario.inventoryfragment.ui.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import com.example.usuario.inventoryfragment.R;
import com.example.usuario.inventoryfragment.pojo.Dependency;
import com.example.usuario.inventoryfragment.ui.dependency.contract.ListDependencyContract;

public class CommonDialog {

    public static final String MESSAGE = "message";
    public static final String TITLE = "tittle";
    public static final String DEPENDENCY = "dependency";

    public static Dialog showConfirmDialog(final Bundle bundle, Context context, final ListDependencyContract.Presenter presenter) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(bundle.getString(MESSAGE))
                .setTitle(bundle.getString(TITLE))
                .setPositiveButton(R.string.btnOk, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        presenter.deleteDependency((Dependency) bundle.getParcelable(DEPENDENCY));
                        dialog.cancel();
                    }
                })
                .setNegativeButton(R.string.btnCancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        return builder.create();
    }
}
