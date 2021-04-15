package com.example.lifecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v) {
        if (v.getId() == R.id.bLogin) {
            EditText editTextUserName = (EditText) findViewById(R.id.editTextUserName);
            String userUN = editTextUserName.getText().toString();
            EditText editTextUserPassword = (EditText) findViewById(R.id.editTextUserPassword);
            String userPW = editTextUserPassword.getText().toString();

            String password = helper.searchPassword(userUN);

            if (userPW.equals(password)){
                Intent life = new Intent(MainActivity.this, Counter.class);
                startActivity(life);
            }
            else{
                Toast message = Toast.makeText(MainActivity.this, "Password or User Name in incorrect", Toast.LENGTH_SHORT);
                message.show();
            }



        }
        if (v.getId() == R.id.bSignup1){
            Intent register = new Intent(MainActivity.this, Signup.class);
            startActivity(register);
        }
    }
}