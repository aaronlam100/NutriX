package com.nutrix.nutrix;

import android.content.Intent;
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

public class ChangeProfileSettings extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private EditText etName, etAge, etHeight, etWeight;
    private UserLocalStore uls = new UserLocalStore(this);
    User user = uls.getLoggedInUser();
    Spinner spSex, spPhysAct;
    Button bSave;
    String sex;
    int physAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_profile_settings);

        etName = (EditText) findViewById(R.id.etName);
        etAge = (EditText) findViewById(R.id.etAge);
        etWeight = (EditText) findViewById(R.id.etWeight);
        etHeight = (EditText) findViewById(R.id.etHeight);

        etName.setText(user.getName());
        etAge.setText(Integer.toString(user.getAge()));
        etWeight.setText(Integer.toString(user.getWeight()));
        etHeight.setText(Integer.toString(user.getHeight()));

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
        bSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.bRegister:
                user.setSex(spSex.getSelectedItem().toString());
                user.setPhysAct(Integer.parseInt(spPhysAct.getSelectedItem().toString()));
                Log.d("Sex", spSex.getSelectedItem().toString());
                Log.d("Physical Activity", spPhysAct.getSelectedItem().toString());
                UserLocalStore uls = new UserLocalStore(this); //not sure if this is right
                uls.storeUserData(user);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_change_profile_settings, menu);
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
