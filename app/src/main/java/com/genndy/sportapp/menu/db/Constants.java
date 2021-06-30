package com.genndy.sportapp.menu.db;

public class Constants {
    public static final String TABLE_NAME = "games";
    public static final String DB_NAME = "sportapp.db";
    public static final int DB_VERSION = 1;

    public static final String _ID = "_id";
    public static final String NAME = "name";
    public static final String PHOTO_URL = "photo_link";

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME + " (" + _ID + " varchar(38) PRIMARY KEY," + NAME + " TEXT, " + PHOTO_URL + " TEXT)";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
}
