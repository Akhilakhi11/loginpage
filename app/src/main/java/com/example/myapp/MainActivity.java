package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity<button> extends AppCompatActivity {

    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        //Intent startingIntent = getIntent();
      //  String whatYouSent = startingIntent.getStringExtra(key, value);

        ButterKnife.bind(this);




//       login = findViewById(R.id.login);
//       inputusername = findViewById(R.id.username);
//       inputpassword = findViewById(R.id.password);


//        //username.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                CheckCredentials();
//
//            }
//        });


    }
    @OnClick(R.id.login)

    public void onLoginClicked(){
        checkEmail();
    }
    public void checkEmail(){
        String email =username.getText().toString().trim();

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

// onClick of button perform this simplest code.
        if (email.matches(emailPattern)) {
            checkPassword();
        } else {
            Toast.makeText(getApplicationContext(), email + "Invalid email address", Toast.LENGTH_SHORT).show();
        }
    }
    public void checkPassword() {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password.getText());



        if (matcher.matches()) {
            String email= username.getText().toString();
            Intent intent=new Intent(MainActivity.this,Activity2.class);
            intent.putExtra("keyname",email);
            startActivity(intent);

        } else {
            Toast.makeText(getApplicationContext(),  "Invalid password", Toast.LENGTH_SHORT).show();
        }
    }
}


