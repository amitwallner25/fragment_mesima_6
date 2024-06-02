package com.example.a75shiur;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Objects;


public class SQLiteManager extends SQLiteOpenHelper {

    private static SQLiteManager sqLiteManager;

    private static final String DATABASE_NAME = "users.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "users";
    private static final String COUNTER = "counter";
    private static final String FIRST_FIELD = "un";
    private static final String SECOND_FIELD = "pw";

    public SQLiteManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //This is called a Singleton. It means there is only one instance of the class in the whole app
    //Why would you need it with this type or resource?
    public static SQLiteManager instanceOfDatabase(Context context) {
        if (sqLiteManager == null) {
            sqLiteManager = new SQLiteManager(context);
        }
        return sqLiteManager;
    }

    //חשוב לדעת קטע קוד חשוב
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE ")
                .append(TABLE_NAME)
                .append(" (")
                .append(COUNTER)
                .append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
                .append(FIRST_FIELD)
                .append(" TEXT, ")
                .append(SECOND_FIELD)
                .append(" TEXT) ");
        sqLiteDatabase.execSQL(sql.toString());
        //מוסיף משתמש ברירת מחדל

        ContentValues values = new ContentValues();
        values.put(FIRST_FIELD, "I HAVE NOTHING TO SAY");
        values.put(SECOND_FIELD, "I HAVE NOTHING TO SAY");

        sqLiteDatabase.insert(TABLE_NAME, null, values);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //on changing the DB. We are not implementing this for now
    }

    public void addUserToDB(String frag1,String farg2) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FIRST_FIELD, frag1);
        values.put(SECOND_FIELD, farg2);

        db.insert(TABLE_NAME, null, values);
    }

    public void updateUserToDB(String username,String password) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        if (username != null) {
            values.put(FIRST_FIELD, username);
        }
        if (username != null) {
            values.put(SECOND_FIELD, password);
        }

        //Here we are asking to update the table with TABLE_NAME with the values in values. We
        //only update the lines in the table WHERE ID equals the values in the string array that is
        // passed in the last argument
        db.update(TABLE_NAME, values, "un=?", new String [] {username});
    }

    public String [] getTextFromFragments() {
        SQLiteDatabase db = getReadableDatabase();
        String [] resultText = new String [2] ;


        //we try to get all the notes from the DB
        try (Cursor result = db.rawQuery("SELECT * FROM " + TABLE_NAME, null)) {
            //The results are given back an Object called Cursor that let's us iterate over all the results
            // Read more about Cursor at https://developer.android.com/reference/android/database/Cursor
            result.moveToLast();
                //The table we setup has 5 columns and this is how we can access each item in the row
            resultText[0] = result.getString(1);
            resultText[1] = result.getString(2);
        }
            catch(SQLiteException e){
                // handle exception, e.g. log error message
                Log.e("SQLiteManager", "Error executing query", e);
            }
            catch(CursorIndexOutOfBoundsException e){
                // handle exception, e.g. log error message
                Log.e("SQLiteManager", "There was a problem reading one of the fields", e);

            }

        return resultText;
    }
}
