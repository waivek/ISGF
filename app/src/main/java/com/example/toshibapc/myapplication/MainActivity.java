package com.example.toshibapc.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends ActionBarActivity {


    /*String[] countries = new String[] {
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
            *//*"Event Info",
            "Schedule",
            "Exhibition",
            "Speakers",
            "Venue",
            "Sponsors",
            "Floor Plan",
            "Registration",
            "More"*//*
    };*/

    int[] flags = new int[]{
            /*R.drawable.ic_event_info,
            R.drawable.ic_event_info,
            R.drawable.ic_event_info,
            R.drawable.ic_event_info,
            R.drawable.ic_event_info,
            R.drawable.ic_event_info,
            R.drawable.ic_event_info,
            R.drawable.ic_event_info,
            R.drawable.ic_event_info,*/
            R.drawable.event_info,
            R.drawable.schedule,
            R.drawable.exhibition,
            R.drawable.speaker,
            R.drawable.venue,
            R.drawable.sponsor,
            R.drawable.floor_plan,
            R.drawable.registration,
            R.drawable.more
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<HashMap<String, String>> hashMapList = new ArrayList<HashMap<String, String>>();

        for(int i = 0; i < 8; i++) {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            /*hashMap.put("txt", countries[i]);*/
            hashMap.put("flag", Integer.toString(flags[i]));
            hashMapList.add(hashMap);
        }

/*
        String from[] = { "flag", "txt"};
*/
        String from[] = { "flag"};

/*
        int to[] = {R.id.flag, R.id.txt};
*/
        int to[] = {R.id.flag};

        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), hashMapList, R.layout.gridview_layout, from, to);

        GridView gridView = (GridView) findViewById(R.id.gridView);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Class aClass = null;

                switch (position) {
                    case 0:
                        aClass = EventInfo.class;
                        break;
                    case 1:
                        aClass = EventSchedule.class;
                        break;
                    case 2:
                        aClass = ExhibitorsActivity.class;
                        break;
                    case 3:
                        aClass = SpeakerActivity.class;
/*
                        aClass = DummyActivity.class;
*/
                        break;
                    case 4:
                        aClass = Venue.class;
                        break;
                    case 5:
                        aClass = SponsorActivity.class;
                        break;
                    case 6:
                        aClass = FloorPlanActivity.class;
                        break;
                    case 7:
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://isgw.in/"));
                        startActivity(browserIntent);
                        break;
                    case 8:
                        aClass = EventInfo.class;
                        break;
                    default:
                        aClass = EventInfo.class;
                }
                if(aClass != null) {
                    Intent intent = new Intent(getApplicationContext() ,aClass);
                    startActivity(intent);
                }
            }
        });
        /*final ImageView imageView = (ImageView) findViewById(R.id.imageView);

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    imageView.setImageResource(R.drawable.bw_event_info);
                    startSessionActivity(v);
                } else {
                    imageView.setImageResource(R.drawable.event_info);
                }
                return true;
            }
        });*/

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
