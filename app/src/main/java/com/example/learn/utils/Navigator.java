package com.example.learn.utils;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learn.MainActivity;
import com.example.learn.MainActivity2;


public class Navigator {

    private Navigator() {

    }


    public static void NavigateMainActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public static void NavigateMainActivity2(Context context) {
        Intent intent = new Intent(context, MainActivity2.class);
        context.startActivity(intent);
    }

}