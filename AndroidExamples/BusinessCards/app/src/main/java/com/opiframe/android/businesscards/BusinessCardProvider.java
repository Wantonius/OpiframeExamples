package com.opiframe.android.businesscards;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

public class BusinessCardProvider extends ContentProvider {

    private SQLiteDatabase reader;
    private SQLiteDatabase writer;
    private static final String TAG = "BusinessCardProvider";
    private BusinessCardDatabaseHelper helper;
    private static final String DATABASENAME = "businesscard.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "BUSINESS_CARD";
    public static final String CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+BusinessCard._ID+" " +
                    "INTEGER PRIMARY KEY AUTOINCREMENT,"+BusinessCard.FIRST_NAME+
                    " VARCHAR(20),"+BusinessCard.LAST_NAME+" VARCHAR(50),"+
                    BusinessCard.TITLE+" VARCHAR(30),"+BusinessCard.PHONE+
                    " VARCHAR(20),"+BusinessCard.COMPANY+" VARCHAR(30))";


    public BusinessCardProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        Log.d(TAG,"onCreate");
        helper = new BusinessCardDatabaseHelper(getContext(),null,null,0,null);
        writer = helper.getWritableDatabase();
        reader = helper.getReadableDatabase();
        if(writer == null || reader==null) {
            Log.e(TAG,"Error in onCreate. No writable or readable database");
            return false;
        }
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private class BusinessCardDatabaseHelper extends SQLiteOpenHelper {

        public BusinessCardDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, DATABASENAME, factory, DATABASE_VERSION);
        }

        public BusinessCardDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
            super(context, DATABASENAME, factory, DATABASE_VERSION, errorHandler);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }

    }
}
