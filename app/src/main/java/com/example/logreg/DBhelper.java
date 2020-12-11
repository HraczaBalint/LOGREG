package com.example.logreg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "logreg.db";
    public static final int DB_VERSION = 1;

    public static final String FELHASZNALO_TABLE = "felhasznalo";

    public static final String COL_ID    = "id";
    public static final String COL_EMAIL = "email";
    public static final String COL_FELHNEV   = "felhnev";
    public static final String COL_JELSZO  = "jelszo";
    public static final String COL_TELJESNEV   = "teljesnev";

    public DBhelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + FELHASZNALO_TABLE +" (" +
                COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                COL_EMAIL +" VARCHAR(255) UNIQUE NOT NULL, " +
                COL_FELHNEV +" VARCHAR(255) UNIQUE NOT NULL, " +
                COL_JELSZO +" VARCHAR(255) UNIQUE NOT NULL, " +
                COL_TELJESNEV +" VARCHAR(255) UNIQUE NOT NULL" +
                ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + FELHASZNALO_TABLE;
        db.execSQL(sql);
        onCreate(db);
    }

    public void bejeletkezes(String felhasznalonev, String jelszo) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.get(felhasznalonev);
        values.get(jelszo);
        //return ;
    }

    public boolean regisztracio(String email, String felhasznaloNev, String jelszo, String teljesNev) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_EMAIL, email);
        values.put(COL_FELHNEV, felhasznaloNev);
        values.put(COL_JELSZO, jelszo);
        values.put(COL_TELJESNEV, teljesNev);
        return db.insert(FELHASZNALO_TABLE, null, values) != -1;
    }
}
