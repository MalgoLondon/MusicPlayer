package com.example.android.musicplayer;

/**
 * {@link SongObject} represents a single Android platform release.
 * Each object has 3 properties: name, version number, and image resource ID.
 */
public class GenreObject {

    // Title of the genre
    private String mGenre;

    // Drawable resource ID
    private int mImageResourceId;

    /*
     * Create a new Genre object.
     *
     * @param vGenre is the title of the genre
     * @param image is drawable reference ID that corresponds to genre
     * */
    public GenreObject(String vGenre, int imageResourceId) {
        mGenre = vGenre;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the title of the genre
     */
    public String getGenre() {
        return mGenre;
    }

    /**
     * Get the image resource ID
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

}
