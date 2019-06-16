package com.example.dinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.dinner.entity.Database;

public class SpecificActivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific);
        textView = findViewById(R.id.jianjie);
        textView.setText("简介:"+Database.content);
    }

}
