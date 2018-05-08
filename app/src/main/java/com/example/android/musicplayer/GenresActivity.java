package com.example.android.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class GenresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songlist);

        // Find the favourites button
        Button favourites = (Button) findViewById(R.id.favourites_button);

        // Set a click listener on that button
        favourites.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent favouritesIntent = new Intent(GenresActivity.this, FavouritesActivity.class);
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
                Intent allsongsIntent = new Intent(GenresActivity.this, AllsongsActivity.class);
                startActivity(allsongsIntent);
            }
        });

        final ArrayList<GenreObject> genres = new ArrayList<GenreObject>();
        genres.add(new GenreObject("POP", R.drawable.list_item_icon_small));
        genres.add(new GenreObject("ROCK", R.drawable.list_item_icon_small));
        genres.add(new GenreObject("LATINO", R.drawable.list_item_icon_small));
        genres.add(new GenreObject("DANCE", R.drawable.list_item_icon_small));
        genres.add(new GenreObject("CLASSIC", R.drawable.list_item_icon_small));
        genres.add(new GenreObject("ELECTRONIC", R.drawable.list_item_icon_small));
        genres.add(new GenreObject("HIP HOP", R.drawable.list_item_icon_small));
        genres.add(new GenreObject("OLDIES", R.drawable.list_item_icon_small));
        genres.add(new GenreObject("OTHER", R.drawable.list_item_icon_small));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        GenreAdapter adapter = new GenreAdapter(this, genres);

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
                Intent intent = new Intent(GenresActivity.this, AllsongsActivity.class);
                startActivity(intent);
            }


        });
    }
}
