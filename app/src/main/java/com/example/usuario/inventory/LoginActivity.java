package com.example.usuario.inventory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edtUser, edtPassword;
    CheckBox chkRemember;
    Button btnSignUp, btnFacebookSignU, btnGoogleSignUp;

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
                checkLogin(edtUser.getText().toString(), edtPassword.getText().toString());
            }
        });
        btnFacebookSignU = (Button) findViewById(R.id.btnFacebookSignUp);
        btnGoogleSignUp = (Button) findViewById(R.id.btnGoogleSignUp);
    }

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
}
