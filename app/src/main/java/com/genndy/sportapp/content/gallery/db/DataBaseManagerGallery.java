package com.genndy.sportapp.content.gallery.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.genndy.sportapp.content.gallery.models.Photo;
import com.genndy.sportapp.menu.models.Game;
import com.genndy.sportapp.services.DataBaseHelper;

import java.util.ArrayList;
import java.util.List;

public class DataBaseManagerGallery {
    private Context context;
    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase db;

    public DataBaseManagerGallery(Context context) {
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

    public void insertToDB(String _id, String photoURL, String gameName){
        openDB();
        ContentValues values = new ContentValues();
        values.put(Constants._ID, _id);
        values.put(Constants.PHOTO_URL, photoURL);
        values.put(Constants.GAME_NAME, gameName);
        db.insert(Constants.TABLE_NAME, null, values);
        closeDB();
    }

    public List<Photo> readAllFromDB(String gameNameCurrent){
        openDB();
        List<Photo> allPhoto = new ArrayList<>();
        Cursor cursor = db.query(Constants.TABLE_NAME, null, Constants.GAME_NAME + " = ?",
                new String[]{gameNameCurrent}, null, null, null);
        while (cursor.moveToNext()){
            String _id = cursor.getString(cursor.getColumnIndex(Constants._ID));
            String photoURL = cursor.getString(cursor.getColumnIndex(Constants.PHOTO_URL));
            String gameName = cursor.getString(cursor.getColumnIndex(Constants.GAME_NAME));
            allPhoto.add(new Photo(_id, photoURL, gameName));
        }
        cursor.close();
        closeDB();
        return allPhoto;
    }

    public void closeDB(){
        db.close();
    }
}
