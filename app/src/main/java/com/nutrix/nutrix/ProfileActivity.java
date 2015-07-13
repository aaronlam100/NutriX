package com.nutrix.nutrix;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class ProfileActivity extends ActionBarActivity implements View.OnClickListener{

    Button bHome, bProfile, bSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        bHome = (Button) findViewById(R.id.bHome);
        bProfile = (Button) findViewById(R.id.bProfile);
        bSettings = (Button) findViewById(R.id.bSettings);

        bHome.setOnClickListener(this);
        bProfile.setOnClickListener(this);
        bSettings.setOnClickListener(this);
    }

    public void onClick(View view){
        switch(view.getId()){
            case(R.id.bHome):
                startActivity(new Intent(this, MainActivity.class));
                break;
            case(R.id.bProfile):
                break;
            case(R.id.bSettings):
                startActivity(new Intent(this, SettingsActivity.class));
                break;
        }

    }
}
