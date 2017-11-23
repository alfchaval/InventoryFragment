package com.example.usuario.inventoryfragment.ui.login;

import android.text.TextUtils;

import com.example.usuario.inventoryfragment.ui.utils.CommonUtils;

/**
 * @author Alfonso Chamorro Valle
 * Interactor del Login
 */

public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void validateCredentials(String user, String password, OnLoginFinishedListener listener) {

        if(TextUtils.isEmpty(user)) {
            listener.onUserEmptyError();
        }
        else if(TextUtils.isEmpty(password)) {
            listener.onPasswordEmptyError();
        }
        else if(!CommonUtils.isPasswordValid(password)) {
            listener.onPasswordError();
        }
        else {
            listener.onSuccess();
        }
    }
}
