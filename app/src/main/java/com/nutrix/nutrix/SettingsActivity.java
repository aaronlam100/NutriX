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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class SettingsActivity extends AppCompatActivity implements View.OnClickListener{

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
