package com.example.android.musicplayer;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<SongObject> {
    public SongAdapter(Activity context, ArrayList<SongObject> songs) {
        // **Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // We use 0 as a second argument because we don't need to rely on the ArrayAdapter to create a ListView for us.
        // Instead, the getView method will handle the inflating of the layout from the layout ressource ID.*/
        super(context, 0, songs);
    }
    @Override
    //**Provides a view for an adapter View (ListView, GridView)
    // @param position - the adapter position that is requesting a view
    // @param convertView - the recycled view to populate
    // @param parent - the parent view which is used for inflation*/

    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the object located at this position in the list
        SongObject currentSong = getItem(position);

        // Find the TextView in the list_item.xml layout
        TextView songTextView = (TextView) listItemView.findViewById(R.id.song_name);
        // Get the song title from the current song object
        // set this text on the name TextView
        songTextView.setText(currentSong.getSong());

        // Find the TextView in the list_item.xml layout
        TextView artistTextView = (TextView) listItemView.findViewById(R.id.artist_name);
        // Get the artist name from the current Song object
        // set this text on the number TextView
        artistTextView.setText(currentSong.getArtist());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        iconView.setImageResource(currentSong.getImageResourceId());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
