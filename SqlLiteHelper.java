package com.source.administrator.starbuzz;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 7/11/2016.
 */
public class SqlLiteHelper extends SQLiteOpenHelper {
    private static final String DB_NAME="starbuzz";
    private static final int DB_VERSION=1;

    public SqlLiteHelper(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE DRINK(_id INTEGER PRIMARY KEY AUTOINCREMENT,"+"NAME TEXT,"+"DESCRIPTION TEXT,"+"IMAGE_RESOURCE_ID INTEGER);");
        insertDrink(db,"latte","Esspresso and steamed milk",R.drawable.latte);

    }
    private static void insertDrink(SQLiteDatabase db,String name,String description,int resourceId)
    {
        ContentValues drinkValues=new ContentValues();
        drinkValues.put("NAME",name);
        drinkValues.put("DESCRIPTION",description);
        drinkValues.put("IMAGE_RESOURCE_ID",resourceId);
        db.insert("DRINK",null,drinkValues);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
