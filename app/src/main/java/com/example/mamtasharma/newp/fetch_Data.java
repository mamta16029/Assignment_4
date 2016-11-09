package com.example.mamtasharma.newp;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Mamta Sharma on 11/4/2016.
 */

public class fetch_Data
{
    static ArrayList<RecyclerData> dataList=new ArrayList<RecyclerData>();

    RecyclerData RD=new RecyclerData();
    public static void setArrayList(RecyclerData recyclerData){
        dataList.add(recyclerData);
    }
    public static ArrayList<RecyclerData> getArrayList(){
        return dataList;
    }
}
