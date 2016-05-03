package com.example.toshibapc.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SponsorActivity extends ActionBarActivity {


    String[] speakerNames = new String[] {
            "Utility Partner",
            "Knowledge Partner",
            "Partners",
            "Media and Marketing Partners",

            "Supporting Partners",
            "Supporting Partners",
            "Supporting Partners",
            "Supporting Partners",
            "Supporting Partners",
            "Supporting Partners",
            "Supporting Partners",
            "Supporting Partners",
            "Supporting Partners",
            "Supporting Partners",
            "Supporting Partners",
            "Supporting Partners",

            "Media Partners",
            "Media Partners",
            "Media Partners",
            "Media Partners",
            "Media Partners",
            "Media Partners",
            "Media Partners",
            "Media Partners",
            "Media Partners",
            "Media Partners",
            "Media Partners",
            "Media Partners",
            "Media Partners",
            "Media Partners",
            "Media Partners",
            "Media Partners",
            "Media Partners",
    };

    int[] speakerImages = new int[]{
            R.drawable.ic_utility,
            R.drawable.ic_knowledge,
            R.drawable.ic_partners,
            R.drawable.ic_media_and_marketing,
            R.drawable.ic_supporting_partner_1,
            R.drawable.ic_supporting_partner_2,
            R.drawable.ic_supporting_partner_3,
            R.drawable.ic_supporting_partner_4,
            R.drawable.ic_supporting_partner_5,
            R.drawable.ic_supporting_partner_6,
            R.drawable.ic_supporting_partner_7,
            R.drawable.ic_supporting_partner_8,
            R.drawable.ic_supporting_partner_9,
            R.drawable.ic_supporting_partner_10,
            R.drawable.ic_supporting_partner_11,
            R.drawable.ic_supporting_partner_12,

            R.drawable.ic_media_partner_1,
            R.drawable.ic_media_partner_2,
            R.drawable.ic_media_partner_3,
            R.drawable.ic_media_partner_4,
            R.drawable.ic_media_partner_5,
            R.drawable.ic_media_partner_6,
            R.drawable.ic_media_partner_7,
            R.drawable.ic_media_partner_8,
            R.drawable.ic_media_partner_9,
            R.drawable.ic_media_partner_10,
            R.drawable.ic_media_partner_11,
            R.drawable.ic_media_partner_12,
            R.drawable.ic_media_partner_13,
            R.drawable.ic_media_partner_14,
            R.drawable.ic_media_partner_15,
            R.drawable.ic_media_partner_16,
            R.drawable.ic_media_partner_17
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsor);

        List<HashMap<String, String>> hashMapList = new ArrayList<HashMap<String, String>>();

        for(int i = 0; i < speakerNames.length; i++) {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("speakerText", speakerNames[i]);
            hashMap.put("speakerImage", Integer.toString(speakerImages[i]));
            hashMapList.add(hashMap);
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
        getMenuInflater().inflate(R.menu.menu_sponsor, menu);
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
