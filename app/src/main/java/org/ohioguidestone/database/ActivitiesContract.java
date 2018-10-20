package org.ohioguidestone.database;

import android.provider.BaseColumns;

public final class ActivitiesContract {
    private ActivitiesContract() {
        // private because we don't wan't other classes to be able to create instances of this class
    }

    public static class ActivitiesEntry implements BaseColumns {
        // database contract goes here, see
        // https://developer.android.com/training/data-storage/sqlite
        public static final String TABLE_NAME = "activity";
        public static final String COLUMN_ACTIVITY_NAME = "activityName";



    }
}
