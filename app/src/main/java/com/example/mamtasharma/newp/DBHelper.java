package com.example.mamtasharma.newp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Mamta Sharma on 10/2/2016.
 */

public class DBHelper extends SQLiteOpenHelper
{
    public static final int Version=1;
    public String create="create table "+ Info_Clas.Student_Table_Class.Table_Name_ID+"("+ Info_Clas.Student_Table_Class.titles+" TEXT, "+ Info_Clas.Student_Table_Class.descs+" TEXT);";
    public DBHelper(Context context) {
        super(context, Info_Clas.Student_Table_Class.Data_Base_ID, null, Version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

    }
    public boolean save(DBHelper dbH, String title, String desc)
    {
        SQLiteDatabase SQD=dbH.getWritableDatabase();
        ContentValues CV=new ContentValues();
        CV.put(Info_Clas.Student_Table_Class.titles,title);
        CV.put(Info_Clas.Student_Table_Class.descs,desc);

        SQD.insert(Info_Clas.Student_Table_Class.Table_Name_ID,null,  CV);
        //SQD.close();
        return true;
    }

    public Cursor view()
    {
        SQLiteDatabase SQD=this.getReadableDatabase();
        String [] Details={Info_Clas.Student_Table_Class.titles,Info_Clas.Student_Table_Class.descs};
        Cursor cursor=SQD.query(Info_Clas.Student_Table_Class.Table_Name_ID,Details,null,null,null,null,null);
        //SQD.close();
        return cursor;

    }
}
