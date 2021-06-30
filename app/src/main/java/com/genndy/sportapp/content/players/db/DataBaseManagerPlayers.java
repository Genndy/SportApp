package com.genndy.sportapp.content.players.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.genndy.sportapp.content.players.model.Player;
import com.genndy.sportapp.services.DataBaseHelper;

import java.util.ArrayList;
import java.util.List;

public class DataBaseManagerPlayers { // Players
    private Context context;
    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase db;

    public DataBaseManagerPlayers(Context context) {
        this.context = context;
        dataBaseHelper = new DataBaseHelper(context);
    }

    public void createTableIfNotExist(){
        openDB();
        db.execSQL(Constants.CREATE_TABLE);
        closeDB();
    }
    public void dropTableIfExist(){
        openDB();
        db.execSQL(Constants.DROP_TABLE);
        closeDB();
    }

    public void openDB(){
        db = dataBaseHelper.getWritableDatabase();
    }

    public void insertToDB(String _id, String name, String gameName, String photoURL){
        openDB();
        ContentValues values = new ContentValues();
        values.put(Constants._ID, _id);
        values.put(Constants.NAME, name);
        values.put(Constants.GAME_NAME, gameName);
        values.put(Constants.TEXT, photoURL);
        db.insert(Constants.TABLE_NAME, null, values);
        closeDB();
    }

    public List<Player> readAllFromDB(String currentGameName){
        openDB();
        List<Player> allPlayers = new ArrayList<>();  // Constants.NAME + " = ?"
        Cursor cursor = db.query(Constants.TABLE_NAME, null, Constants.GAME_NAME + " = ?",
                new String[]{currentGameName}, null, null, null);

        while (cursor.moveToNext()){
            String _id = cursor.getString(cursor.getColumnIndex(Constants._ID));
            String name = cursor.getString(cursor.getColumnIndex(Constants.NAME));
            String photoURL = cursor.getString(cursor.getColumnIndex(Constants.TEXT));
            String gameName = cursor.getString(cursor.getColumnIndex(Constants.GAME_NAME));
            allPlayers.add(new Player(_id, name, photoURL, gameName));
        }
        cursor.close();
        closeDB();
        return allPlayers;
    }

    public void closeDB(){
        dataBaseHelper.close();
    }
}
