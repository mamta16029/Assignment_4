package com.example.mamtasharma.newp;

import android.content.Intent;
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

public class add_Activity extends AppCompatActivity
{
    EditText etTitle, etDescription;
    ImageView crossImage;
    Button btnAddItem;
    private DBHelper DBH;

    String title = "",description = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_);


        etTitle = (EditText) findViewById(R.id.etTitle);
        etDescription = (EditText) findViewById(R.id.etDescription);
        btnAddItem = (Button) findViewById(R.id.btnAddItem);
        DBH=new DBHelper(this);
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = etTitle.getText().toString();
                description = etDescription.getText().toString();
                //--------------------------------

                if (title.matches("")) {
                    Toast.makeText(v.getContext(), "You did not enter a Title", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (description.matches("")) {
                    Toast.makeText(v.getContext(), "You did not enter a description", Toast.LENGTH_SHORT).show();
                    return;
                }
                RecyclerData recyclerData=new RecyclerData();
                recyclerData.title=title;
                recyclerData.description=description;

                //----------------------------------


                    if(DBH.save(DBH,title,description)) {
                        Toast.makeText(getApplicationContext(), "New item Added!", Toast.LENGTH_SHORT).show();

                    }
                    else
                        Toast.makeText(getApplicationContext(),"Item Not Added!",Toast.LENGTH_SHORT).show();


                etTitle.setText("");
                etDescription.setText("");



            }
        });

    }

        @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar wil
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_back) {
            startActivity(new Intent(this,MainActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}

