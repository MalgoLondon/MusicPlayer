package com.example.android.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the favourites button
        Button favourites = (Button) findViewById(R.id.favourites_button);

        // Set a click listener on that button
        favourites.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent favouritesIntent = new Intent(MainActivity.this, FavouritesActivity.class);
                startActivity(favouritesIntent);
            }
        });

        // Find the All songs button
        Button allsongs = (Button) findViewById(R.id.allsongs_button);

        // Set a click listener on that button
        allsongs.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the phrases View is clicked on.
            @Override
            public void onClick(View view) {
                Intent phrasesIntent = new Intent(MainActivity.this, AllsongsActivity.class);
                startActivity(phrasesIntent);
            }
        });

        // Find the Genres button
        Button genres = (Button) findViewById(R.id.genres_button);

        // Set a click listener on that View
        genres.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family View is clicked on.
            @Override
            public void onClick(View view) {
                Intent familyIntent = new Intent(MainActivity.this, GenresActivity.class);
                startActivity(familyIntent);
            }
        });


    }
}