package com.genndy.sportapp.menu.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObservable;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.genndy.sportapp.menu.models.Game;
import com.genndy.sportapp.services.DataBaseHelper;

import java.util.ArrayList;
import java.util.List;

public class DataBaseManagerMenu {
    private Context context;
    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase db;

    public DataBaseManagerMenu(Context context) {
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

    public void insertToDB(String _id, String name, String photoURL){
        openDB();
        ContentValues values = new ContentValues();
        values.put(Constants._ID, _id);
        values.put(Constants.NAME, name);
        values.put(Constants.PHOTO_URL, photoURL);
        db.insert(Constants.TABLE_NAME, null, values);
        closeDB();
    }

    public List<Game> readAllFromDB(){
        openDB();
        List<Game> allGames = new ArrayList<>();
        Cursor cursor = db.query(Constants.TABLE_NAME, null, null,
                null, null, null, null);
        while (cursor.moveToNext()){
            String _id = cursor.getString(cursor.getColumnIndex(Constants._ID));
            String name = cursor.getString(cursor.getColumnIndex(Constants.NAME));
            String photoURL = cursor.getString(cursor.getColumnIndex(Constants.PHOTO_URL));
            allGames.add(new Game(_id, name, photoURL));
        }
        cursor.close();
        closeDB();
        return allGames;
    }

    public void closeDB(){
        dataBaseHelper.close();
    }
}
