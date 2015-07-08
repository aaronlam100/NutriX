package com.nutrix.nutrix;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    EditText etName, etAge, etUsername, etPassword, etHeight, etWeight;
    Button bRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etName = (EditText) findViewById(R.id.etName);
        etAge = (EditText) findViewById(R.id.etAge);
        etWeight = (EditText) findViewById(R.id.etWeight);
        etHeight = (EditText) findViewById(R.id.etHeight);
        bRegister = (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.bRegister:
                User newUser = new User(etName.toString(), etUsername.toString(), etPassword.toString(), Integer.parseInt(etAge.toString()), Integer.parseInt(etWeight.toString()), Integer.parseInt(etHeight.toString()));
                UserLocalStore uls = new UserLocalStore(view.getContext()); //not sure if this is right
                uls.storeUserData(newUser);
                startActivity(new Intent(RegisterActivity.this, LoginRegisterActivity.class));
        }
    }
}
