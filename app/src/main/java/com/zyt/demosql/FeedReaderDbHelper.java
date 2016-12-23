package com.zyt.demosql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FeedReaderDbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";

    public static final String TABLE_NAME = "entry";
    public static final String COLUMN_NAME_TITLE = "title";
    public static final String COLUMN_NAME_SUBTITLE = "subtitle";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    /*  CREATE TABLE STUDENT (ID INTEGER PRIMARY KEY,name TEXT ,age TEXT); */
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE student (ID INTEGER PRIMARY KEY,name TEXT ,age TEXT)";

    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
        String sql = "insert into student(ID,name,age) values(1,'shu','13')";
        db.execSQL(sql);

    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}