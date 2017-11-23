package com.example.usuario.inventoryfragment.ui.dependency;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by usuario on 11/23/17.
 */

public class DetailDependency extends Fragment{

    public static final String TAG = "DetailDependency";

    public static Fragment newInstance(Bundle arguments) {
        DetailDependency DetailDependency = new DetailDependency();
        if(arguments != null) {
            DetailDependency.setArguments(arguments);
        }
        return DetailDependency;
    }
}
