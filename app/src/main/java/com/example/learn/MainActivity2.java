package com.example.learn;

import static com.example.learn.R.*;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import android.widget.ImageView;

import com.example.learn.utils.Navigator;
import com.example.learn.utils.Player;
import com.example.learn.utils.PlayerApi;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main2);

        TextView text = findViewById(R.id.helloText);

        ImageView img = findViewById(R.id.avatar);
        ImageView flag = findViewById(R.id.flag);
        TextView nation = findViewById(id.nation);


        String player_name = intent.getStringExtra("player_name");

        text.setText(player_name);

        PlayerApi.fetchPlayer(player_name, new PlayerApi.PlayerCallback() {
            @Override
            public void onSuccess(Player player) {
                // runs in background thread; wrap in runOnUiThread if updating UI
                Log.i("Player", "Got player: " + player.getStrPlayer());
                runOnUiThread(() -> {
                    Glide.with(getApplicationContext()).load(player.getStrThumb())  // URL of the image
                            // optional: if failed
                            .into(img);


                    String nationality = player.getStrNationality().toLowerCase();

                    nation.setText(nationality);

                    Log.i("Player", "Got player: " + nationality);

                    int resId = getResources().getIdentifier(nationality, "string", getPackageName());

                    Log.i("Player", "Got player: " + resId);
                    String flagCode;
                    if (resId != 0) {
                        flagCode = getString(resId);
                    } else {
                        flagCode = "ar"; // fallback
                    }

                    String flagUrl = "https://flagcdn.com/108x81/" + flagCode + ".png";

                    Glide.with(getApplicationContext()).load(flagUrl)  // URL of the image
                            // optional: if failed
                            .into(flag);
                });
            }

            @Override
            public void onFailure(Exception e) {
                Log.e("Player", "Error fetching player: " + e.getMessage());
            }
        });

    }
}
