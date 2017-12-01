package com.example.usuario.inventoryfragment.ui.base;


import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;

public class BaseFragment extends Fragment {

    public void showMessage(String message) {
        Snackbar.make(getActivity().findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show();
    }

    public void onError(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();
    }
}
