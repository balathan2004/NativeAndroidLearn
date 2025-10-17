package com.example.learn;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        Button nextButton = findViewById(R.id.btn);

        nextButton.setOnClickListener(v -> {
            Intent ronaldo = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(ronaldo);
        });

    }
}
