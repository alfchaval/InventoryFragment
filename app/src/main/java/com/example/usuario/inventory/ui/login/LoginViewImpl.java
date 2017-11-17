package com.example.usuario.inventory.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.usuario.inventory.DashboardActivity;
import com.example.usuario.inventory.R;
import com.example.usuario.inventory.ui.base.BaseActivity;

/**
 * @author Alfonso Chamorro Valle
 * Login de la aplicación
 */

public class LoginViewImpl extends BaseActivity implements LoginView {

    EditText edtUser, edtPassword;
    CheckBox chkRemember;
    Button btnSignIn, btnFacebookSignIn, btnGoogleSignIn;
    TextView txvSignUp;
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginPresenter = new LoginPresenterImpl(this);

        edtUser = (EditText)findViewById(R.id.edtUser);
        edtPassword = (EditText)findViewById(R.id.edtPassword);
        chkRemember = (CheckBox)findViewById(R.id.chkRemember);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.validateCredentials(edtUser.getText().toString(), edtPassword.getText().toString());
            }
        });
        btnFacebookSignIn = (Button) findViewById(R.id.btnFacebookSignIn);
        btnGoogleSignIn = (Button) findViewById(R.id.btnGoogleSignIn);
        txvSignUp = (TextView) findViewById(R.id.txvSignUp);
        txvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Registrarse
            }
        });
    }

    @Override
    public void navigateToHome() {
        Intent intent = new Intent(LoginViewImpl.this, DashboardActivity.class);
        startActivity(intent);
    }

    @Override
    public void setUserEmptyError() {
        onError(R.string.errorUserEmpty);
        Snackbar.make(findViewById(android.R.id.content), R.string.errorUserEmpty, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void setPasswordEmptyError() {
        onError(R.string.errorPasswordEmpty);
        Snackbar.make(findViewById(android.R.id.content), R.string.errorPasswordEmpty, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void setPasswordError() {
        onError(R.string.errorPassword);
        Snackbar.make(findViewById(android.R.id.content), R.string.errorPassword, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.onDestroy();
    }
}
