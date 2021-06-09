package com.example.dough;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class Login extends AppCompatActivity {

    Button callSignUp, login_btn;
    ImageView logo;
    TextView logo_name, signin;
    TextInputLayout username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide(); //hide the title bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        callSignUp = findViewById(R.id.signup);
        login_btn = findViewById(R.id.login_btn);
        logo = findViewById(R.id.logo);
        logo_name = findViewById(R.id.logo_name);
        signin = findViewById(R.id.signin);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        callSignUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, SignUp.class);
                Pair[] pairs = new Pair [7];

                pairs [0] = new Pair<View, String>(logo, "logo");
                pairs [1] = new Pair<View, String>(logo_name, "logo_name");
                pairs [2] = new Pair<View, String>(username, "username");
                pairs [3] = new Pair<View, String>(signin, "signin");
                pairs [4] = new Pair<View, String>(password, "password");
                pairs [5] = new Pair<View, String>(login_btn, "button_tran");
                pairs [6] = new Pair<View, String>(signin, "login_signup_tran");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
                    startActivity(intent, options.toBundle());
                }


            }
        });

    }
}