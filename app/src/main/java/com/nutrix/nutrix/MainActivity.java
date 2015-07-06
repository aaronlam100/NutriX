package com.nutrix.nutrix;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etName, etAge, etUsername;
    Button bLogout;
    public static final String MyPREFERENCES = "Login";
    SharedPreferences prefs;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);                    //tabsetup
        tabHost.setup();
        TabHost.TabSpec home = tabHost.newTabSpec("Home");
        home.setContent(R.id.Home);
        home.setIndicator("Home");
        TabHost.TabSpec profile = tabHost.newTabSpec("Profile");
        profile.setContent(R.id.Profile);
        profile.setIndicator("Profile");
        TabHost.TabSpec settings = tabHost.newTabSpec("Settings");
        settings.setContent(R.id.Settings);
        settings.setIndicator("Settings");
        tabHost.addTab(home);
        tabHost.addTab(profile);
        tabHost.addTab(settings);

        bLogout = (Button) findViewById(R.id.bLogout);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        prefs = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        bLogout.setOnClickListener(this);
    }

    @Override //need this method for the action bar
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bLogout:
                SharedPreferences.Editor editor = getSharedPreferences("Login", 0).edit();
                editor.putBoolean("LoggedIn", false);
                editor.commit();
                Intent returnIntent = new Intent(this, LoginRegisterActivity.class);
                startActivity(returnIntent);
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
//        if (!prefs.contains("LoggedIn") && prefs.getBoolean("LoggedIn", true))
        if (!prefs.getBoolean("LoggedIn", false))
            startActivity(new Intent(this, LoginRegisterActivity.class));
    }
}
