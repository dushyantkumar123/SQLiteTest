package com.source.administrator.starbuzz;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteOpenHelper starbuzzDatabaseHelper = new SqlLiteHelper(this);
        SQLiteDatabase db = starbuzzDatabaseHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM DRINK",null);
        if(cursor.moveToFirst())
        Toast.makeText(this,cursor.getString(2),Toast.LENGTH_LONG).show();
    }
}
