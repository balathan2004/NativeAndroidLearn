package com.example.learn;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main2);

        Button nextButton = findViewById(R.id.btn);

        nextButton.setOnClickListener(v -> {
            Intent ronaldo = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(ronaldo);
        });


    }


}
