package com.example.words504;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class SqlitClass {
    private static String dbname = "DB_504.sqlite";
    DbHelper dbHelper;
    String dbpath;
    SQLiteDatabase db;
    Context context;

    public SqlitClass(Context context) {
        this.context = context;
        dbHelper = new DbHelper(context);
        dbpath = context.getApplicationInfo().dataDir + "/databases/";
        try {
            dbHelper.creatdatabase();
            db = SQLiteDatabase.openDatabase(dbpath + dbname, null, SQLiteDatabase.OPEN_READWRITE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<Wordclass> getword() {
        Cursor currency = db.rawQuery("Select * from tbl_504 limit 20 offset 1", null);
        List<Wordclass> wordclasses = new ArrayList<>();
        if (currency.getCount() > 0) {
            currency.moveToFirst();
            do {

                Wordclass wordclass = new Wordclass();
                wordclass.setName(currency.getString(1));
                wordclass.setId(currency.getString(0));
                wordclass.setCoding(currency.getString(3));
                wordclass.setSpell(currency.getString(6));
                wordclass.setSynon(currency.getString(4));
                wordclass.setMean(currency.getString(2));
                wordclass.setFav(currency.getString(5));

                wordclasses.add(wordclass);
            }
            while (currency.moveToNext());
        }
        return wordclasses;
    }

    public void insteritems(String name) {
        Cursor cursor = db.rawQuery("insert into tbl_504 where name=" + name, null);

    }

    public List<Wordclass> lesson(int x) {
        Cursor cursor1 = db.rawQuery("SELECT * from tbl_504 LIMIT 12 OFFSET " + x, null);
        List<Wordclass> wordclasses = new ArrayList<>();
        if (cursor1.getCount() > 0) {
            cursor1.moveToFirst();
            do {

                Wordclass wordclass = new Wordclass();
                wordclass.setName(cursor1.getString(1));
                wordclass.setId(cursor1.getString(0));
                wordclass.setCoding(cursor1.getString(3));
                wordclass.setSpell(cursor1.getString(6));
                wordclass.setSynon(cursor1.getString(4));
                wordclass.setMean(cursor1.getString(2));
                wordclass.setFav(cursor1.getString(5));

                wordclasses.add(wordclass);
            }
            while (cursor1.moveToNext());
        }
        return wordclasses;
    }
    public Boolean fav(int x) {
        Cursor cursor2 = db.rawQuery("UPDATE fav from tbl_504 where id="+ x, null);
        if (cursor2.getCount() > 0) {
            cursor2.moveToFirst();
            return true;
        }
        else{
            return false;
        }
    }

}
