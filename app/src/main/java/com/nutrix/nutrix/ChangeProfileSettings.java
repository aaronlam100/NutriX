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
import android.widget.Toast;

public class ChangeProfileSettings extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private EditText etName, etAge, etHeight, etWeight;
    private UserLocalStore uls;
    private User user;
    private Spinner spSex, spPhysAct;
    private Button bSave;
    private String sex;
    private int physAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_profile_settings);

        uls = new UserLocalStore(this);
        user = uls.getLoggedInUser();

        etName = (EditText) findViewById(R.id.etName);
        etAge = (EditText) findViewById(R.id.etAge);
        etWeight = (EditText) findViewById(R.id.etWeight);
        etHeight = (EditText) findViewById(R.id.etHeight);
        bSave = (Button) findViewById(R.id.bSave);

        etName.setText(user.getName());
        etAge.setText(Integer.toString(user.getAge()));
        etWeight.setText(Integer.toString(user.getWeight()));
        etHeight.setText(Integer.toString(user.getHeight()));

        spSex = (Spinner) findViewById(R.id.spSex);
        ArrayAdapter<CharSequence> sexAdapter = ArrayAdapter.createFromResource(this, R.array.sex_array, android.R.layout.simple_spinner_item);
        sexAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSex.setAdapter(sexAdapter);
        spSex.setSelection(sexAdapter.getPosition(user.getSex()));

        spPhysAct = (Spinner) findViewById(R.id.spPhysAct);
        ArrayAdapter<CharSequence> physActAdapter = ArrayAdapter.createFromResource(this, R.array.physAct_array, android.R.layout.simple_spinner_item);
        physActAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPhysAct.setAdapter(physActAdapter);
        spPhysAct.setSelection(physActAdapter.getPosition(Integer.toString(user.getPhysAct())));

        spSex.setOnItemSelectedListener(this);
        spPhysAct.setOnItemSelectedListener(this);

        bSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        uls = new UserLocalStore(this);
        user = uls.getLoggedInUser();
        switch(view.getId()) {
            case R.id.bSave:
                user.setName(etName.getText().toString());
                user.setAge(Integer.parseInt(etAge.getText().toString()));
                user.setWeight(Integer.parseInt(etWeight.getText().toString()));
                user.setHeight(Integer.parseInt(etHeight.getText().toString()));
                user.setSex(spSex.getSelectedItem().toString());
                user.setPhysAct(Integer.parseInt(spPhysAct.getSelectedItem().toString()));

                Log.d("Sex", spSex.getSelectedItem().toString());
                Log.d("Physical Activity", spPhysAct.getSelectedItem().toString());
                uls.storeUserData(user);

                Toast.makeText(this, "Your settings have been saved!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, SettingsActivity.class));
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
