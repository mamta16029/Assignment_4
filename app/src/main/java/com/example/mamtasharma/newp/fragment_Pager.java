package com.example.mamtasharma.newp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Mamta Sharma on 11/6/2016.
 */

public class fragment_Pager extends android.support.v4.app.Fragment{
    private TextView desc;
    RecyclerData item;

    public fragment_Pager(){}
    public fragment_Pager(RecyclerData item){
        this.item=item;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.pager_fragment_layout,container,false);
        desc=(TextView)view.findViewById(R.id.pager_textview);
        desc.setText(item.getDescription());
        return view;
    }
}
