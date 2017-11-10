package com.example.usuario.inventory.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.usuario.inventory.DashboardActivity;
import com.example.usuario.inventory.R;

/**
 * Created by usuario on 11/10/17.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String user, String password) {

        loginInteractor.validateCredentials(user, password, this);
        loginView.navigateToHome();

        /**
        //Método que comprueba que el Login sea correcto
        private void checkLogin(String user, String password) {
            if(password.length() < 8) {
                Toast.makeText(getApplicationContext(), "La contraseña debe contener al menos 8 caracteres", Toast.LENGTH_SHORT).show();
            }
            boolean minus = false;
            boolean mayus = false;
            boolean digit = false;
            for (int i = 0; i < password.length(); i++) {
                if(!minus && Character.isLowerCase(password.charAt(i))) minus = true;
                if(!mayus && Character.isUpperCase(password.charAt(i))) mayus = true;
                if(!digit && Character.isDigit(password.charAt(i))) digit = true;
            }
            if(!digit) {
                Toast.makeText(getApplicationContext(), "La contraseña debe contener al menos un número", Toast.LENGTH_SHORT).show();
            }
            else if (!mayus) {
                Toast.makeText(getApplicationContext(), "La contraseña debe contener al menos una mayúscula", Toast.LENGTH_SHORT).show();
            }
            else if (!minus) {
                Toast.makeText(getApplicationContext(), "La contraseña debe contener al menos una minúscula", Toast.LENGTH_SHORT).show();
            }
            else {
                Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                startActivity(intent);
            }

        }
         */
    }

    @Override
    public void onUserEmptyError() {
        loginView.setUserEmptyError();
    }

    @Override
    public void onUserPasswordEmptyError() {
        loginView.setPasswordEmptyError();
    }

    @Override
    public void onUserPasswordError() {
        loginView.setPasswordError();
    }
}
