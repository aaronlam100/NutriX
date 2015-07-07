package com.nutrix.nutrix;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class LoginRegisterActivity extends AppCompatActivity implements View.OnClickListener{

    Button bLogin, bSignUp;
    RelativeLayout layout;
    int background = 0xffff6331;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);


        bLogin = (Button) findViewById(R.id.bLogin);
        bSignUp = (Button) findViewById(R.id.bSignUp);
        layout = (RelativeLayout) findViewById(R.id.login_register);

        bLogin.setOnClickListener(this);
        bSignUp.setOnClickListener(this);


    }

    @Override
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.bLogin:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.bSignUp:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
//            case R.id.login_register:
//                view.setBackground();
        }
    }

}
