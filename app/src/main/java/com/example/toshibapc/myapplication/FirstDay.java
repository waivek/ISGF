package com.example.toshibapc.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Toshiba PC on 28/12/14.
 */
public class FirstDay extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.first_day, container, false);

        final ArrayList<Event> eventArrayList = new ArrayList<Event>();
        String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. ";



        eventArrayList.add(new Event("Inaugural Session", "10:00 - 11:00", loremIpsum));
        eventArrayList.add(new Event("Tea Break", "11:00 - 11:30", loremIpsum));
        eventArrayList.add(new Event("Plenary Session 1", "11:30 - 01:00", loremIpsum));
        eventArrayList.add(new Event("Lunch Break", "01:00 - 02:00", loremIpsum));
        eventArrayList.add(new Event("Technical Session 1", "02:00 - 03:30", loremIpsum));
        eventArrayList.add(new Event("Tea Break", "03:30 - 04:00", loremIpsum));
        eventArrayList.add(new Event("Plenary Session 2", "04:00 - 05:30", loremIpsum));
        eventArrayList.add(new Event("Networking Cocktails", "06:30 - 08:00", loremIpsum));

        ArrayAdapter arrayAdapter = new ArrayAdapter(this.getActivity(), android.R.layout.simple_list_item_2, android.R.id.text1, eventArrayList) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                TextView textView1 = (TextView) view.findViewById(android.R.id.text1);
                TextView textView2 = (TextView) view.findViewById(android.R.id.text2);

                textView1.setText(eventArrayList.get(position).getTitle());
                textView2.setText(eventArrayList.get(position).getTiming());

                return view;

            }
        };

        final ListView listView = (ListView) v.findViewById(R.id.listView);
        listView.setAdapter(arrayAdapter);

        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Event event = (Event) listView.getItemAtPosition(position);
                Intent intent = new Intent(getActivity(), EventDetailsActivity.class);

                intent.putExtra("ev", event);
                startActivity(intent);

            }
        });*/
        return v;

    }


    public static FirstDay newInstance() {
        FirstDay firstDay = new FirstDay();
        return firstDay;
    }

}
