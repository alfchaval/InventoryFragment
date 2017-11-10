package com.example.usuario.inventory.ui.login;

/**
 * Created by usuario on 11/10/17.
 */

public interface LoginInteractor {

    void validateCredentials(String user, String password);

    interface OnLoginFinishedListener {
        void onUserEmptyError();
        void onUserPasswordEmptyError();
        void onUserPasswordError();
    }

}
