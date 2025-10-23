package com.example.learn.utils;

import com.google.gson.Gson;

import android.util.Log;

import androidx.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PlayerApi {


    public static void fetchPlayer(String name, PlayerCallback callback) {


        OkHttpClient client = new OkHttpClient();

        String url = "https://www.thesportsdb.com/api/v1/json/123/searchplayers.php?p=" + name;

        Request req = new Request.Builder().url(url).build();

        client.newCall(req).enqueue(new Callback() {


            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

                e.printStackTrace();
                callback.onFailure(e);
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful() && response.body() != null) {
                    String json = response.body().string();
                    System.out.print("json");
                    try {
                        JSONObject jsonObject = new JSONObject(json);
                        JSONArray jsonPlayers = jsonObject.getJSONArray("player");

                        if (jsonPlayers.length() == 0) {
                            callback.onFailure(new Exception("No Players found"));
                        } else {
                            Player player = new Gson().fromJson(jsonPlayers.getJSONObject(0).toString(), Player.class);

                            callback.onSuccess(player);

                        }


                    } catch (JSONException e) {
                        callback.onFailure(e);

                        Log.e("API", "JSON parse error: " + e.getMessage());

                    }


                }
            }
        });


    }

    public interface PlayerCallback {
        void onSuccess(Player player);

        void onFailure(Exception e);
    }


}
