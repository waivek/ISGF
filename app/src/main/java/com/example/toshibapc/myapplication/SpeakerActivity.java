package com.example.toshibapc.myapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class SpeakerActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaker);


        List<HashMap<String, String>> hashMapList = new ArrayList<HashMap<String, String>>();

        Scanner scanner = new Scanner(getResources().openRawResource(R.raw.names));
        scanner.useDelimiter("\n");
        try {
            while(scanner.hasNext()) {
                HashMap<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("speakerText", scanner.next());
                hashMap.put("speakerImage", Integer.toString(R.drawable.ic_contact_image));
                hashMapList.add(hashMap);
            }
        } finally {
            scanner.close();
        }

        String from[] = {"speakerImage", "speakerText"};
        int to[] = {R.id.speakerImage, R.id.speakerText};

        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), hashMapList, R.layout.listview_layout, from, to);

        ListView listView = (ListView) findViewById(R.id.speakerList);


        listView.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_speaker, menu);
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
