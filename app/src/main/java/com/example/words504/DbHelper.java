package com.example.words504;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DbHelper extends SQLiteOpenHelper {
    private static String dbname = "DB_504.sqlite";
    Context context;
    SQLiteDatabase database;
    String dbpath;

    public DbHelper(Context context) {
        super(context, dbname, null, 1);
        this.context = context;
        dbpath = context.getApplicationInfo().dataDir + "/databases/";
    }

    public DbHelper(Context context, String name, int version, SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }

    public void creatdatabase() throws IOException {

        boolean dbexist = checkdatabase();
        if (dbexist) {

        } else {
            this.getWritableDatabase();
            try {
                copydatabase();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void copydatabase() throws IOException {
        InputStream myinput = context.getAssets().open("DB_504.sqlite");
        String filename = dbpath + dbname;
        OutputStream myoutput = new FileOutputStream(filename);
        byte[] buffar = new byte[1024];
        int lenght;
        while ((lenght = myinput.read(buffar)) > 0) {
            myoutput.write(buffar, 0, lenght);
        }
        myoutput.flush();
        myoutput.close();
        myinput.close();
    }

    public boolean checkdatabase() {

        SQLiteDatabase database1 = null;
        try {
            String mypath = dbpath + dbname;
            database1 = SQLiteDatabase.openDatabase(mypath, null, SQLiteDatabase.OPEN_READONLY);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (database1 != null) {
            database1.close();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists DB_504.sqlite");
        onCreate(db);
    }
}
