package com.nutrix.nutrix;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    EditText etName, etAge, etUsername, etPassword, etHeight, etWeight;
    Spinner spSex, spPhysAct;
    Button bRegister;
    String sex;
    int physAct;

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

        spSex = (Spinner) findViewById(R.id.spSex);
        ArrayAdapter<CharSequence> sexAdapter = ArrayAdapter.createFromResource(this, R.array.sex_array, android.R.layout.simple_spinner_item);
        sexAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSex.setAdapter(sexAdapter);

        spPhysAct = (Spinner) findViewById(R.id.spPhysAct);
        ArrayAdapter<CharSequence> physActAdapter = ArrayAdapter.createFromResource(this, R.array.physAct_array, android.R.layout.simple_spinner_item);
        physActAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPhysAct.setAdapter(physActAdapter);

        spSex.setOnItemSelectedListener(this);
        spPhysAct.setOnItemSelectedListener(this);
        bRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bRegister:
                User newUser = new User(etName.getText().toString(), etUsername.getText().toString(), etPassword.getText().toString(), etAge.getText().toString(), etWeight.getText().toString(), etHeight.getText().toString());
                newUser.setSex(spSex.getSelectedItem().toString());
                newUser.setPhysAct(Integer.parseInt(spPhysAct.getSelectedItem().toString()));
                Log.d("Sex", spSex.getSelectedItem().toString());
                Log.d("Physical Activity", spPhysAct.getSelectedItem().toString());
                UserLocalStore uls = new UserLocalStore(this); //not sure if this is right
                uls.storeUserData(newUser);
                startActivity(new Intent(RegisterActivity.this, LoginRegisterActivity.class));
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
