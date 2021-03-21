package com.example.lifecounter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends Activity {
    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

    }
    public void onSignupClick(View v) {
        if(v.getId() == R.id.bRegister){
            // set the values entered by user when registering
            EditText setupName = (EditText) findViewById(R.id.setupName);
            EditText setupEmail = (EditText) findViewById(R.id.setupEmail);
            EditText setupUserName = (EditText) findViewById(R.id.setupUserName);
            EditText setupPassword = (EditText) findViewById(R.id.setupPassword);
            EditText setupPassword2 = (EditText) findViewById(R.id.setupPassword2);

            // retrieve the entered values
            String setupNameStr = setupName.toString();
            String setupEmailStr = setupEmail.toString();
            String setupUserNameStr = setupUserName.toString();
            String setupPasswordStr = setupPassword.toString();
            String setupPassword2Str = setupPassword2.toString();

            // verify passwords match
            if(setupPasswordStr.equals(setupPassword2Str)){
                // popup a message
                // insert info into database
                Users appUser = new Users();
                appUser.setName(setupNameStr);
                appUser.setEmail(setupEmailStr);
                appUser.setUserName(setupUserNameStr);
                appUser.setPassword(setupPasswordStr);

                helper.insertUser(appUser);
                Intent main = new Intent(Signup.this, MainActivity.class);
                startActivity(main);
            }
            else {
                Toast pass = Toast.makeText(Signup.this, "Passwords don't match", Toast.LENGTH_SHORT);
                pass.show();


            }
        }

    }


}
