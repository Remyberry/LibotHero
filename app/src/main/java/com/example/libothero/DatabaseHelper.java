package com.example.libothero;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Define the database name and version
    private static final String DATABASE_NAME = "YourDatabaseName";
    private static final int DATABASE_VERSION = 1;

    // Define the table name and column names
    private static final String TABLE_NAME = "Account";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";

    // Add more columns as needed

    // Constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Override the onCreate method to create the database and table
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_EMAIL + " TEXT," +
                COLUMN_USERNAME + " TEXT," +
                COLUMN_PASSWORD + "TEXT)";
        // Execute the create table query
        db.execSQL(createTableQuery);
    }

    // Override the onUpgrade method to handle database upgrades
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Add a method to insert account information into the database
    public Boolean addAccount(String email, String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_PASSWORD, password);
        // Add more values as needed

        // Insert the values into the database
        long flag = db.insert(TABLE_NAME, null, values);
        if (flag==-1) return false;
        else
            return true;
    }
    public Boolean checkUser (String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM  TABLE_NAME WHERE username = ?",new String[]{username});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }
    public Boolean checklogin(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM  TABLE_NAME WHERE username = ? AND password = ?",new String[]{username, password});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }
}