package com.example.android.musicplayer;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * {@link SongObject} represents a single Android platform release.
 * Each object has 3 properties: name, version number, and image resource ID.
 */
public class SongObject implements Parcelable {

    // Title of the song
    private String mSong;

    // Artist name
    private String mArtist;

    // Drawable resource ID
    private int mImageResourceId;

    /*
     * Create a new Song object.
     *
     * @param vSong is the title of the song
     * @param vArtist is the correspoding artist name
     * @param image is drawable reference ID that corresponds to song
     * */
    public SongObject(String vSong, String vArtist, int imageResourceId)
    {
        mSong = vSong;
        mArtist = vArtist;
        mImageResourceId = imageResourceId;
    }

    protected SongObject(Parcel in) {
        mSong = in.readString();
        mArtist = in.readString();
        mImageResourceId = in.readInt();
    }

    public static final Creator<SongObject> CREATOR = new Creator<SongObject>() {
        @Override
        public SongObject createFromParcel(Parcel in) {
            return new SongObject(in);
        }

        @Override
        public SongObject[] newArray(int size) {
            return new SongObject[size];
        }
    };

    /**
     * Get the title of the song
     */
    public String getSong() {
        return mSong;
    }

    /**
     * Get the artist name
     */
    public String getArtist() {
        return mArtist;
    }

    /**
     * Get the image resource ID
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mSong);
        dest.writeString(mArtist);
        dest.writeInt(mImageResourceId);
    }
}
