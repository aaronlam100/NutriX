package com.nutrix.nutrix;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
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

    public static final String MyPREFERENCES = "Login";
    SharedPreferences prefs;
    private Toolbar toolbar;
    Button bHome, bProfile, bSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bHome = (Button) findViewById(R.id.bHome);
        bProfile = (Button) findViewById(R.id.bProfile);
        bSettings = (Button) findViewById(R.id.bSettings);

        prefs = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        bHome.setOnClickListener(this);
        bProfile.setOnClickListener(this);
        bSettings.setOnClickListener(this);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case(R.id.bHome):
                break;
            case(R.id.bProfile):
                startActivity(new Intent(this, ProfileActivity.class));
                break;
            case(R.id.bSettings):
                startActivity(new Intent(this, SettingsActivity.class));
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

    @Override //need this method for the action bar
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_searchable, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        MenuItem searchActionBarItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchActionBarItem);

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(true);
        searchView.setQueryHint(getResources().getString(R.string.search_hint));

        return true;
    }
}
