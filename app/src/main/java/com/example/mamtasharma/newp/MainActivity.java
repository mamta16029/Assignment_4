package com.example.mamtasharma.newp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static RecyclerView mRecyclerView;

    static ArrayList<RecyclerData> myList;
    private static RecyclerAdapter mRecyclerAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private DBHelper DBH;
    String title = "",description = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    DBH=new DBHelper(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
       //
        mLayoutManager = new LinearLayoutManager(this);
        //mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        MainActivity.mRecyclerView.setLayoutManager(mLayoutManager);
        //
        myList= new ArrayList<>();
        Cursor cursor=DBH.view();
        while(cursor.moveToNext())
        {
            RecyclerData RD=new RecyclerData();
            RD.title=cursor.getString(0);
            RD.description=cursor.getString(1);
            myList.add(RD);
        }

        mRecyclerAdapter = new RecyclerAdapter(myList,this);
        MainActivity.mRecyclerView.setAdapter(mRecyclerAdapter);
                /*RecyclerData mLog = new RecyclerData();
                mLog.setTitle(title);
                mLog.setDescription(description);
                myList.add(mLog);*/

               // mRecyclerAdapter.notifyData(myList);

            }

        public static void updateList(String title,String desc)
        {
            RecyclerData RC=new RecyclerData();
            RC.title=title;
            RC.description=desc;
            myList.add(RC);
            mRecyclerAdapter.notifyDataSetChanged();

        }


        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add) {
            startActivity(new Intent(this,add_Activity.class));
        }

        return super.onOptionsItemSelected(item);
    }
/*
@Override
public void OnRemoveClick(int index)
        {
        myList.remove(index);
        mRecyclerAdapter.notifyData(myList);
        }
      */
}
