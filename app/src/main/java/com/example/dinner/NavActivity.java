package com.example.dinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NavActivity extends AppCompatActivity {

    private Button buttonK;
    private Button buttonD;
    private Button buttonC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
        buttonK = findViewById(R.id.Kbutton);
        buttonK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavActivity.this,KaiActivity.class);
                startActivity(intent);
            }
        });

        buttonD = findViewById(R.id.Dbutton);
        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavActivity.this,TypeActivity.class);
                startActivity(intent);
            }
        });

        buttonC = findViewById(R.id.Cbutton);
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NavActivity.this,ListActivity.class);
                startActivity(intent);
            }
        });
    }
}
