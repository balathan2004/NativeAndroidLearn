package com.example.learn;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import okhttp3.*;

import java.io.IOException;

import com.example.learn.utils.*;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        LinearLayout parent = findViewById(R.id.names);

        LayoutInflater inflater = LayoutInflater.from(this);


        String[] players = {"Messi", "Ronaldo", "Neymar", "Suarez", "Lewandowski"};

        for (String name : players) {
            TextView tv =
                    (TextView) inflater.inflate(R.layout.player_item, parent, false);
            tv.setText(name);
            tv.setTag(name);

            tv.setOnClickListener(e -> {
                String PlayerName = ((TextView) e).getText().toString();
                Navigator.NavigatePlayer(MainActivity.this, PlayerName
                );
            });
            parent.addView(tv);
        }


    }
}
