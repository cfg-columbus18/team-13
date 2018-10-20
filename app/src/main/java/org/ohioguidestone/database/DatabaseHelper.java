package org.ohioguidestone.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "guidestone.db";
    private static final int DATABASE_VERSION = 1;

    private static DatabaseHelper instance;

    public static void createInstance(Context context) {
        instance = new DatabaseHelper(context);
    }

    public static DatabaseHelper getInstance() {
        return instance;
    }

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO add tables here
        // db.execSQL(STUFF);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int j) {
        onCreate(db);
    }
}
