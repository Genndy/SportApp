package com.genndy.sportapp.content.players.db;

public class Constants {
    public static final String TABLE_NAME = "players";
    public static final String DB_NAME = "sportapp.db";
    public static final int DB_VERSION = 1;

    public static final String _ID = "id";
    public static final String NAME = "name";
    public static final String TEXT = "text";
    public static final String GAME_NAME = "game_name";

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME + " (" + _ID + " varchar(38) PRIMARY KEY," + NAME + " TEXT, " + GAME_NAME + " TEXT, " + TEXT + " TEXT)";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
}
