package com.example.usuario.inventoryfragment.ui.login;

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
