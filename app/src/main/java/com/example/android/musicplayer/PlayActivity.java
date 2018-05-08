package com.example.android.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        // Find the favourites button
        Button favourites = (Button) findViewById(R.id.favourites_button);

        // Set a click listener on that button
        favourites.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent favouritesIntent = new Intent(PlayActivity.this, FavouritesActivity.class);
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
                Intent phrasesIntent = new Intent(PlayActivity.this, AllsongsActivity.class);
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
                Intent familyIntent = new Intent(PlayActivity.this, GenresActivity.class);
                startActivity(familyIntent);
            }
        });

        //Get title and artist from previous Activity.
        Intent intent = getIntent();
        SongObject songPlaying = intent.getParcelableExtra("Song Playing");
        int imageRes = songPlaying.getImageResourceId();
        String title = songPlaying.getSong();
        String artist = songPlaying.getArtist();

        //Sets song description using the clicked item
        TextView songTitle = findViewById(R.id.song_name_playing);
        songTitle.setText(title);
        TextView artistTitle = findViewById(R.id.artist_name_playing);
        artistTitle.setText(artist);
        ImageView imageView = findViewById(R.id.image_playview);
        imageView.setImageResource(imageRes);

    }
}
