package com.example.android.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

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
