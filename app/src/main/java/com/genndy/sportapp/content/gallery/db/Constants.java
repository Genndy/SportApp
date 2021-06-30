package com.genndy.sportapp.content.gallery.db;

public class Constants {
    public static final String TABLE_NAME = "photo";
    public static final String DB_NAME = "sportapp.db";
    public static final int DB_VERSION = 1;

    public static final String _ID = "id";
    public static final String GAME_NAME = "game_name";
    public static final String PHOTO_URL = "photo_url";

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME + " (" + _ID + " varchar(38) PRIMARY KEY, " + PHOTO_URL + " TEXT, " + GAME_NAME + " TEXT)";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
}
