package com.example.lifecounter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Counter extends Activity {
    int playerHealth = 20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counter);
        // set button and textview variables

        Button bUserHealthUp = (Button) findViewById(R.id.bUserHealthUp);
        Button bUserHealthDown = (Button) findViewById(R.id.bUserHealthDown);
        TextView tvUserLife = (TextView) findViewById(R.id.tvUserLife);

        bUserHealthUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerHealth++;
                tvUserLife.setText("" + playerHealth);
            }
        });
        bUserHealthDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerHealth--;
                tvUserLife.setText("" + playerHealth);

            }
        });


    }


}
