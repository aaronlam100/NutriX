package com.nutrix.nutrix;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class LoginActivity extends ActionBarActivity implements View.OnClickListener {

    Button bLogin;
    EditText etUsername, etPassword;
    UserLocalStore uls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        User newUser = null;
//        try{
//            FileInputStream fis = new FileInputStream("LoginInfo.ser");
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            newUser = (User) ois.readObject();
//            ois.close();
//            System.out.println("Done");
//        }
//        catch(IOException i ){
//            i.printStackTrace();
//        }
//        catch(ClassNotFoundException c){
//            c.printStackTrace();
//        }
//        System.out.println("Username: " + newUser.getUsername());

        bLogin = (Button) findViewById(R.id.bLogin);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);

        bLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bLogin:
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                if (username.equals("admin") && password.equals("nutrix"))
                    logUserIn();
                else{
                    uls = new UserLocalStore(view.getContext());
                    authenticate(username, password);
                }
                break;
        }
    }

    private void authenticate(String u, String p) {
        if(uls.authenticate(u, p))
            logUserIn();
        else
            showErrorMessage();
    }

    private void logUserIn() {
        SharedPreferences.Editor editor = getSharedPreferences("Login", 0).edit();
        editor.putBoolean("LoggedIn", true);
        editor.commit();
        Intent returnIntent = new Intent(this, MainActivity.class);
        startActivity(returnIntent);

    }

    private void showErrorMessage() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(LoginActivity.this);
        dialogBuilder.setMessage("Incorrect user details");
        dialogBuilder.setPositiveButton("Ok", null);
        dialogBuilder.show();
    }
}
