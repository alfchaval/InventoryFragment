package com.example.usuario.inventoryfragment.ui.login;

/**
 * Contiene los métodos necesarios para la comunicación entre el presentador y la vista
 * @Author Alfonso Chamorro
 */

public interface LoginView {

    void navigateToHome();

    void setUserEmptyError();

    void setPasswordEmptyError();

    void setPasswordError();
}
