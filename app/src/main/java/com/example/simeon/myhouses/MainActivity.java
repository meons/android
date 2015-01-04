package com.example.simeon.myhouses;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity
{
    DbHelper db;

    public void addData(View view)
    {
        db = new DbHelper(getApplicationContext());
        //db.addRoom(new Room(1, "Cuisine", 12, 1));
        //db.addRoom(new Room(1, "Salon", 25, 1));

        EditText et = (EditText) findViewById(R.id.roomstest);

        for (Room r : db.getRoomsByHouse(1))
        {
            Log.d("MainActivity", r.getDesc());
            et.append(r.getDesc() + "\n");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Mes tests
        db = new DbHelper(getApplicationContext());

        House house = new House(0, "Maison principale", "Rte des Aunaires 31A", 90);
        db.addHouse(house);

        for (House h : db.getHouses())
        {
            Log.d("MainActivity", h.getDesc());
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
