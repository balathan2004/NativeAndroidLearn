package com.example.learn;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learn.utils.Navigator;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main2);

        Button nextButton = findViewById(R.id.btn);

        nextButton.setOnClickListener(v -> {
            Navigator.NavigateMainActivity(MainActivity2.this);

        });
    }
}
