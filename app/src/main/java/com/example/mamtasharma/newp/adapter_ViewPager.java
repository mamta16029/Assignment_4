package com.example.mamtasharma.newp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Mamta Sharma on 11/6/2016.
 */

public class adapter_ViewPager extends FragmentPagerAdapter {
    ArrayList<RecyclerData> Data_List;
    int position;
    public adapter_ViewPager(FragmentManager fm, ArrayList<RecyclerData> list_items, int position) {
        super(fm);
        this.Data_List =list_items;
        this.position=position;
    }

    @Override
    public Fragment getItem(int position) {
        return new fragment_Pager(Data_List.get(position));
    }

    @Override
    public int getCount() {
        return Data_List.size();
    }
}
