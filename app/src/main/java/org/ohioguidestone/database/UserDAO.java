package org.ohioguidestone.database;

import android.database.sqlite.SQLiteDatabase;

/**
 * Data Access Object for user database table
 */
public class UserDAO {
    private DatabaseHelper dbHelper;

    public UserDAO(DatabaseHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    // TODO implement interface for database operations
    public void addUser(String name) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("SELECT * FROM User"); // something like this.
    }
}
