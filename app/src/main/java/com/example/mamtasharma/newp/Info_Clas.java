package com.example.mamtasharma.newp;

import android.provider.BaseColumns;

/**
 * Created by Mamta Sharma on 10/2/2016.
 */

public class Info_Clas
{
    public Info_Clas()
    {

    }

    public static abstract class Student_Table_Class implements BaseColumns
    {
        public static final String titles ="titles";
        public static final String descs ="descs";

        public static final String Data_Base_ID="DataBase";
        public static final String Table_Name_ID="TableName";

    }

}
