package com.example.android.musicplayer;

        import android.app.Activity;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;
        import java.util.ArrayList;

public class GenreAdapter extends ArrayAdapter<GenreObject> {
    public GenreAdapter(Activity context, ArrayList<GenreObject> genres) {
        // **Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // We use 0 as a second argument because we don't need to rely on the ArrayAdapter to create a ListView for us.
        // Instead, the getView method will handle the inflating of the layout from the layout ressource ID.*/
        super(context, 0, genres);
    }

    @Override
    //**Provides a view for an adapter View (ListView, GridView)
    // @param position - the adapter position that is requesting a view
    // @param convertView - the recycled view to populate
    // @param parent - the parent view which is used for inflation*/

    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_genre_object, parent, false);
        }

        // Get the object located at this position in the list
        GenreObject currentGenre = getItem(position);

        // Find the TextView in the activity_genre_object.xml layout
        TextView genreTextView = (TextView) listItemView.findViewById(R.id.genre_list_name);
        // Get the song title from the current song object
        // set this text on the name TextView
        genreTextView.setText(currentGenre.getGenre());

        // Find the ImageView in the activity_genre_object.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon_genre);
        // Get the image resource ID from the current GenreObject
        // set the image to iconView
        iconView.setImageResource(currentGenre.getImageResourceId());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
