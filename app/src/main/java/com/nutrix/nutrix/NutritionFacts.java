package com.nutrix.nutrix;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class NutritionFacts extends AppCompatActivity implements View.OnClickListener {

    private TextView tvCalories, tvTotalFat, tvCholesterol, tvSodium, tvSugar, tvProtein, tvCalcium, tvIron;
    private UserLocalStore uls;
    private User user;
    private Button bHome, bProfile, bSettings;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_facts);

        uls = new UserLocalStore(this);
        user = uls.getLoggedInUser();

        tvCalories = (TextView) findViewById(R.id.calories_value);
        tvTotalFat = (TextView) findViewById(R.id.total_fat_value);
        tvCholesterol = (TextView) findViewById(R.id.cholesterol_value);
        tvSodium = (TextView) findViewById(R.id.sodium_value);
        tvSugar = (TextView) findViewById(R.id.sugars_value);
        tvProtein = (TextView) findViewById(R.id.protein_value);
        tvCalcium = (TextView) findViewById(R.id.calcium_value);
        tvIron = (TextView) findViewById(R.id.iron_value);

        tvCalories.setText(String.valueOf((int)user.getReqCalories()));
        tvTotalFat.setText(String.valueOf((int)user.getReqTotalFat()));
        tvCholesterol.setText(String.valueOf(user.getReqCholesterol()));
        tvSodium.setText(String.valueOf(user.getReqSodium()));
        tvSugar.setText(String.valueOf((int)user.getReqSugar()));
        tvProtein.setText(String.valueOf((int)user.getReqProtein()));
        tvCalcium.setText(String.valueOf(user.getReqCalcium()));
        tvIron.setText(String.valueOf(user.getReqIron()));

        bHome = (Button) findViewById(R.id.bHome);
        bProfile = (Button) findViewById(R.id.bProfile);
        bSettings = (Button) findViewById(R.id.bSettings);

        bHome.setOnClickListener(this);
        bProfile.setOnClickListener(this);
        bSettings.setOnClickListener(this);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Your Nutrition Facts");
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
                startActivity(new Intent(this, SettingsActivity.class));
                break;
        }
    }

    @Override
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

        return super.onOptionsItemSelected(item);
    }
}
