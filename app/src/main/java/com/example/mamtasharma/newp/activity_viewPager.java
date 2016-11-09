package com.example.mamtasharma.newp;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import java.util.ArrayList;

public class activity_viewPager extends FragmentActivity {
    private ViewPager pager = null;
    private adapter_ViewPager viewpager_Adapter = null;
    ArrayList<RecyclerData> list;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        Bundle bundle=getIntent().getExtras();
        list=bundle.getParcelableArrayList("list");
        position=bundle.getInt("position");

        pager = (ViewPager) findViewById (R.id.activity_view_pager);
        viewpager_Adapter = new adapter_ViewPager(getSupportFragmentManager(),list,position);
        pager.setAdapter(viewpager_Adapter);
        pager.setCurrentItem(position);
    }
}
