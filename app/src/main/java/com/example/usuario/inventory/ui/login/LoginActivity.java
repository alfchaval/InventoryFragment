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
 * @author Alfonso Chamorro Valle
 * Login de la aplicación
 */

public class LoginActivity extends AppCompatActivity {

    EditText edtUser, edtPassword;
    CheckBox chkRemember;
    Button btnSignUp, btnFacebookSignU, btnGoogleSignUp;
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUser = (EditText)findViewById(R.id.edtUser);
        edtPassword = (EditText)findViewById(R.id.edtPassword);
        chkRemember = (CheckBox)findViewById(R.id.chkRemember);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.validateCredentials(edtUser.getText().toString(), edtPassword.getText().toString());
            }
        });
        btnFacebookSignU = (Button) findViewById(R.id.btnFacebookSignUp);
        btnGoogleSignUp = (Button) findViewById(R.id.btnGoogleSignUp);
    }
}
