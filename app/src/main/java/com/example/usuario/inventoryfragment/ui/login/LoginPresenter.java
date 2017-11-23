package com.example.usuario.inventoryfragment.ui.login;

/**
 * @author Alfonso Chamorro Valle
 * Interfaz del presentador del Login
 */

public interface LoginPresenter {

    void validateCredentials(String user, String password);

    void onDestroy();
}
