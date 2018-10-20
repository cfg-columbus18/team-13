package org.ohioguidestone.database;

import android.provider.BaseColumns;

public final class UserContract {
    private UserContract() {
        // private because we don't wan't other classes to be able to create instances of this class
    }

    public static class UserEntry implements BaseColumns {
        // database contract goes here, see
        // https://developer.android.com/training/data-storage/sqlite

    }
}
