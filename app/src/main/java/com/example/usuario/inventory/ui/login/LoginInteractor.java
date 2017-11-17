package com.example.usuario.inventory.ui.login;

import android.view.View;

/**
 * @author Alfonso Chamorro Valle
 * Interfaz del interactor dle Login
 */

public interface LoginInteractor {

    void validateCredentials(String user, String password, OnLoginFinishedListener onLoginFinishedListener);

    interface OnLoginFinishedListener {
        void onUserEmptyError();
        void onPasswordEmptyError();
        void onPasswordError();
        void onSuccess();
    }

}
