package com.nutrix.nutrix;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity { //implements View.OnClickListener {

    //    UserLocalStore userLocalStore;
    EditText etName, etAge, etUsername;
    Button bLogout;
    boolean loggedIn = false;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
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

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

//        etUsername = (EditText) findViewById(R.id.etUsername);
//        etName = (EditText) findViewById(R.id.etName);
//        etAge = (EditText) findViewById(R.id.etAge);
//        bLogout = (Button) findViewById(R.id.bLogout);
//
//        bLogout.setOnClickListener(this);
    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.bLogout:
//                Intent loginIntent = new Intent(this, Login.class);
//                startActivity(loginIntent);
//                break;
//        }
//    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        if (!loggedIn)
//            startActivity(new Intent(MainActivity.this, Login.class));
//    }

    //    private boolean authenticate() {
//        if (userLocalStore.getLoggedInUser() == null) {
//            Intent intent = new Intent(this, Login.class);
//            startActivity(intent);
//            return false;
//        }
//        return true;
//    }
//
//    private void displayUserDetails() {
//        User user = userLocalStore.getLoggedInUser();
//        etUsername.setText(user.username);
//        etName.setText(user.name);
//        etAge.setText(user.age + "");
//    }
//
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    //
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
//        if(id == R.id.action_search) {
//            startActivity(new Intent(this, SearchActivity.class));
//        }

        return super.onOptionsItemSelected(item);
    }
}
