package com.nutrix.nutrix;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
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


public class RegisterActivity extends ActionBarActivity implements View.OnClickListener{
    EditText etName, etAge, etUsername, etPassword, etHeight, etWeight;
    Button bRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = (EditText) findViewById(R.id.etName);
        etAge = (EditText) findViewById(R.id.etAge);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bRegister = (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.bRegister:
                User newUser = new User(etUsername.toString(), etPassword.toString(), 17, 69, 170);
                try {
                    FileOutputStream fout = new FileOutputStream("LoginInfo.ser");
                    ObjectOutputStream oos = new ObjectOutputStream(fout);
                    oos.writeObject(newUser);
                    oos.close();
                }
                catch(IOException i){
                    i.printStackTrace();
                }
                startActivity(new Intent(RegisterActivity.this, LoginRegisterActivity.class));
        }
    }
}
