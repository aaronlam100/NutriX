package com.nutrix.nutrix;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private Button bHome, bProfile, bSettings, bNutritionFacts;
    private UserLocalStore uls;
    private TextView tvName, tvAge, tvWeight, tvHeight, tvSex, tvPhysAct;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        bHome = (Button) findViewById(R.id.bHome);
        bProfile = (Button) findViewById(R.id.bProfile);
        bSettings = (Button) findViewById(R.id.bSettings);
        bNutritionFacts = (Button) findViewById(R.id.bNutritionFacts);

        bHome.setOnClickListener(this);
        bProfile.setOnClickListener(this);
        bSettings.setOnClickListener(this);
        bNutritionFacts.setOnClickListener(this);

        tvName = (TextView) findViewById(R.id.tvName);
        tvAge = (TextView) findViewById(R.id.tvAge);
        tvWeight = (TextView) findViewById(R.id.tvWeight);
        tvHeight = (TextView) findViewById(R.id.tvHeight);
        tvSex = (TextView) findViewById(R.id.tvSex);
        tvPhysAct = (TextView) findViewById(R.id.tvPhysAct);

        uls = new UserLocalStore(this);
        User user = uls.getLoggedInUser();
        tvName.setText(user.getName());
        tvAge.setText(user.getAge() + "");
        tvWeight.setText(user.getWeight() + " lbs");
        tvHeight.setText(user.getHeight() + "\"");
        tvSex.setText(user.getSex());
        tvPhysAct.setText(user.getPhysAct() + "");

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Profile");
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
            case(R.id.bNutritionFacts):
                startActivity(new Intent(this, NutritionFacts.class));
                break;
        }
    }

    @Override //need this method for the action bar
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_searchable, menu);
        inflater.inflate(R.menu.menu_main, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        MenuItem searchActionBarItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchActionBarItem);

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(true);
        searchView.setQueryHint(getResources().getString(R.string.search_hint));

        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        if(id == R.id.camera) {
            Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 0);
        }

        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bp = (Bitmap) data.getExtras().get("data");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
