package com.example.android.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class FavouritesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songlist);

        // Find the genres button
        Button genres = (Button) findViewById(R.id.genres_button);

        // Set a click listener on that button
        genres.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent genresIntent = new Intent(FavouritesActivity.this, GenresActivity.class);
                startActivity(genresIntent);
            }
        });

        // Find the All songs button
        Button allsongs = (Button) findViewById(R.id.allsongs_button);

        // Set a click listener on that button
        allsongs.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the phrases View is clicked on.
            @Override
            public void onClick(View view) {
                Intent allsongsIntent = new Intent(FavouritesActivity.this, AllsongsActivity.class);
                startActivity(allsongsIntent);
            }
        });

        final ArrayList<SongObject> songs = new ArrayList<SongObject>();
        songs.add(new SongObject("song1","artist1", R.drawable.list_item_icon_small)) ;
        songs.add(new SongObject("song2","artist1", R.drawable.list_item_icon_small)) ;
        songs.add(new SongObject("song3","artist1", R.drawable.list_item_icon_small)) ;
        songs.add(new SongObject("song4","artist2", R.drawable.list_item_icon_small)) ;
        songs.add(new SongObject("song5","artist2", R.drawable.list_item_icon_small)) ;
        songs.add(new SongObject("song6","artist2", R.drawable.list_item_icon_small)) ;
        songs.add(new SongObject("song7","artist3", R.drawable.list_item_icon_small)) ;
        songs.add(new SongObject("song8","artist3", R.drawable.list_item_icon_small)) ;
        songs.add(new SongObject("song9","artist3", R.drawable.list_item_icon_small)) ;
        songs.add(new SongObject("song10","artist4", R.drawable.list_item_icon_small)) ;
        songs.add(new SongObject("song11","artist4", R.drawable.list_item_icon_small)) ;
        songs.add(new SongObject("song12","artist1", R.drawable.list_item_icon_small)) ;

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        SongAdapter adapter = new SongAdapter(this, songs);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml file.
        ListView listView = findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FavouritesActivity.this, PlayActivity.class);
                intent.putExtra("Song Playing", songs.get(position));
                startActivity(intent);
            }


        });
    }
}
