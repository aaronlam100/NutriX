package com.nutrix.nutrix;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class SettingsActivity extends ActionBarActivity implements View.OnClickListener{

    Button bHome, bProfile, bSettings, bLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        bHome = (Button) findViewById(R.id.bHome);
        bProfile = (Button) findViewById(R.id.bProfile);
        bSettings = (Button) findViewById(R.id.bSettings);
        bLogout = (Button) findViewById(R.id.bLogout);

        bHome.setOnClickListener(this);
        bProfile.setOnClickListener(this);
        bSettings.setOnClickListener(this);
        bLogout.setOnClickListener(this);
    }

    public void onClick(View view){
        switch(view.getId()){
            case(R.id.bHome):
                startActivity(new Intent(this, MainActivity.class));
                break;
            case(R.id.bProfile):
                startActivity(new Intent(this, ProfileActivity.class));
                break;
            case(R.id.bSettings):
                break;
            case(R.id.bLogout):
                SharedPreferences.Editor editor = getSharedPreferences("Login", 0).edit();
                editor.putBoolean("LoggedIn", false);
                editor.commit();
                Intent returnIntent = new Intent(this, LoginRegisterActivity.class);
                startActivity(returnIntent);
                break;
        }

    }
}
