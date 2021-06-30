package com.genndy.sportapp.content.rules.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.genndy.sportapp.content.rules.models.Rules;
import com.genndy.sportapp.services.DataBaseHelper;

import java.util.ArrayList;
import java.util.List;

public class DataBaseManagerRules {
    private Context context;
    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase db;

    public DataBaseManagerRules(Context context) {
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

    public void insertToDB(String _id, String name, String text){
        openDB();

        db.delete(Constants.TABLE_NAME, Constants.NAME + " = ? ", new String[]{name});

        ContentValues values = new ContentValues();
        values.put(Constants._ID, _id);
        values.put(Constants.NAME, name);
        values.put(Constants.TEXT, text);
        db.insert(Constants.TABLE_NAME, null, values);
        closeDB();
    }

    public List<Rules> readFromBDByGameName(String gameName){
        openDB();
        List<Rules> rules  = new ArrayList<>();
        Cursor cursor = db.query(Constants.TABLE_NAME, null, Constants.NAME + " = ?",
                new String[]{gameName}, null, null, null);

        while (cursor.moveToNext()){
            String _id = cursor.getString(cursor.getColumnIndex(Constants._ID));
            String name = cursor.getString(cursor.getColumnIndex(Constants.NAME));
            String text = cursor.getString(cursor.getColumnIndex(Constants.TEXT));
            rules.add(new Rules(_id, name, text));
        }
        closeDB();
        return rules;
    }

    public void closeDB(){
        dataBaseHelper.close();
    }
}
