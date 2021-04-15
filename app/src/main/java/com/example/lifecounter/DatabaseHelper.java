package com.example.lifecounter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "users.db";
    private static final String TABLE_NAME = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_USERNAME = "userText";
    private static final String COLUMN_PASSWORD = "password";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table users (id integer  not null, name text not null, email text not null, userText text not null, password text not null)";


    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);

    }
    public void insertUser(Users appUsers){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from users";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();



        values.put(COLUMN_ID, count+1);
        values.put(COLUMN_NAME, appUsers.getName());
        values.put(COLUMN_EMAIL, appUsers.getEmail());
        values.put(COLUMN_USERNAME, appUsers.getUserName());
        values.put(COLUMN_PASSWORD, appUsers.getPassword());


        db.insert(TABLE_NAME, null, values);
        db.close();
    }


    public String searchPassword(String userName){
        db = this.getReadableDatabase();
        String query = "select * from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String uname, pword;
        pword = "Not Found";
        if (cursor.moveToFirst()){
            do {
                uname = cursor.getString(2);

                if (uname.equals(userName)){
                    pword = cursor.getString(3);
                    break;
                }
            }
            while(cursor.moveToNext());

        }
        return pword;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
