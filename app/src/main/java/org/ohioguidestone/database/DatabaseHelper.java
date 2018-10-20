package org.ohioguidestone.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {

    //The Android's default system path of your application database.
    private static String DB_PATH = "/data/data/org.ohioguidestone/databases/";

    private static String DB_NAME = "foo.db";

    private SQLiteDatabase myDataBase;

    private final Context myContext;

    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     * @param context
     */
    public DatabaseHelper(Context context) {

        super(context, DB_NAME, null, 1);
        this.myContext = context;
    }

    /**
     * Creates a empty database on the system and rewrites it with your own database.
     * */
    public void createDataBase() throws IOException {

        boolean dbExist = checkDataBase();

        if(dbExist){
            //do nothing - database already exist
        }else{

            //By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            this.getReadableDatabase();

            try {

                copyDataBase();

            } catch (IOException e) {

                throw new Error("Error copying database");

            }
        }

    }

    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     * @return true if it exists, false if it doesn't
     */
    private boolean checkDataBase(){

        SQLiteDatabase checkDB = null;

        try{
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        }catch(SQLiteException e){

            //database does't exist yet.

        }

        if(checkDB != null){

            checkDB.close();

        }

        return checkDB != null ? true : false;
    }

    /**
     * Copies your database from your local assets-folder to the just created empty database in the
     * system folder, from where it can be accessed and handled.
     * This is done by transfering bytestream.
     * */
    private void copyDataBase() throws IOException{

        //Open your local db as the input stream
        InputStream myInput = myContext.getAssets().open(DB_NAME);

        // Path to the just created empty db
        String outFileName = DB_PATH + DB_NAME;

        //Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        //transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }

        //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public void openDataBase() throws SQLException {

        //Open the database
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public synchronized void close() {

        if(myDataBase != null)
            myDataBase.close();

        super.close();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        SQLiteDatabase mydatabase = SQLiteDatabase.openOrCreateDatabase(DB_NAME,null);
        //create tags table
        String create_tags = "CREATE TABLE IF NOT EXISTS " +
                "Tags(tag_id INTEGER, " +
                "tag_name VARCHAR(50), " +
                "PRIMARY KEY(tag_id));";

        mydatabase.execSQL(create_tags);


        //create categories table
        String create_categories = "CREATE TABLE IF NOT EXISTS " +
                "Categories(category_id INTEGER, " +
                "category_name VARCHAR(200), " +
                "PRIMARY KEY(category_id));";

        mydatabase.execSQL(create_categories);

        //create templates table
        String create_templates = "CREATE TABLE IF NOT EXISTS " +
                "Templates(template_id INTEGER, " +
                "template_name VARCHAR(50), " +
                "PRIMARY KEY(tag_id));";
        mydatabase.execSQL(create_templates);

        //create activities
        String create_activities = "CREATE TABLE IF NOT EXISTS " +
                " Activities(activity_id INTEGER, " +
                "name VARCHAR(20), activity_desc VARCHAR(50), " +
                "is_favorite INTEGER, " + //treat like a bool
                "icon_filename VARCHAR(200), " +
                "category_id INTEGER, " +
                "template_id INTEGER, " +
                "PRIMARY KEY(activity_id), " +
                "FOREIGN KEY(category_id) REFERENCES categories(category_id)," +
                "FOREIGN KEY(template_id) REFERENCES templates(template_id));";
        mydatabase.execSQL(create_activities);
        //create activity-tag link table
        String create_link_table = "CREATE TABLE IF NOT EXISTS " +
                "Links(activity_id INTEGER, " +
                " tag_id INTEGER, " +
                "PRIMARY KEY(tag_id, activity_id)," +
                "FOREIGN KEY (activity_id) REFERENCES Activities(activity_id)," +
                "FOREIGN KEY (tag_id) REFERENCES Tags(tag_id));";
        mydatabase.execSQL(create_link_table);

        //create usage table
        String create_usage = "CREATE TABLE IF NOT EXISTS " +
                "Usage(usage_id INTEGER, " +
                "rating INTEGER, " +
                "activity_id INTEGER, " +
                "date_completed TEXT," +
                "time_spent INTEGER)";
        mydatabase.execSQL(create_usage);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // Add your public helper methods to access and get content from the database.
    // You could return cursors by doing "return myDataBase.query(....)" so it'd be easy
    // to you to create adapters for your views.

}