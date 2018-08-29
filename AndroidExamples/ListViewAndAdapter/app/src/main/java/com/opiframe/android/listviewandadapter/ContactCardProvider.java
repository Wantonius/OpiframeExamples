package com.opiframe.android.listviewandadapter;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.util.Log;

public class ContactCardProvider extends ContentProvider {

    private SQLiteDatabase reader;
    private SQLiteDatabase writer;
    private ContactCardDatabaseHelper helper;
    private static final String TAG = "ContactCardProvider";
    private static final String DATABASE_NAME = "contacts.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "contacts";
    private static final String CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+Contact._ID+
            " INTEGER PRIMARY KEY AUTOINCREMENT, "+Contact.FIRST_NAME+
            " VARCHAR(30),"+Contact.LAST_NAME+" VARCHAR(50),"+
            Contact.ADDRESS+" VARCHAR(50),"+Contact.EMAIL+
            " VARCHAR(50),"+Contact.PHONE+" VARCHAR(30),"+
            Contact.TITLE+" VARCHAR(30))";
    public ContactCardProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        Log.d(TAG,"Delete");
        int count = 0;
        count = writer.delete(TABLE_NAME, selection, selectionArgs);
        if(count > 0) {
            getContext().getContentResolver().notifyChange(uri,null);
        }
        return count;
    }

    @Override
    public String getType(Uri uri) {
        return Contact.CONTENT_TYPE;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Log.d(TAG,"insert");
        long rowId = 0;
        rowId = writer.insert(TABLE_NAME,"",values);
        if(rowId > 0) {
            Uri temp = ContentUris.withAppendedId(uri,rowId);
            getContext().getContentResolver().notifyChange(temp,null);
            return temp;
        }
        return null;
    }

    @Override
    public boolean onCreate() {
        Log.d(TAG,"onCreate");
        helper = new ContactCardDatabaseHelper(getContext(), null, null,0, null);
        reader = helper.getReadableDatabase();
        writer = helper.getWritableDatabase();
        if(reader == null || writer == null) {
            return false;
        }
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        builder.setTables(TABLE_NAME);
        Cursor c = builder.query(reader,projection, selection,selectionArgs,null, null,sortOrder);
        return c;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private class ContactCardDatabaseHelper extends SQLiteOpenHelper {

        public ContactCardDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, DATABASE_NAME, factory, DATABASE_VERSION);
        }

        public ContactCardDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
            super(context, DATABASE_NAME, factory, DATABASE_VERSION, errorHandler);
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
