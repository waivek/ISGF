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
public class SecondDay extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.second_day, container, false);

        final ArrayList<Event> eventArrayList = new ArrayList<Event>();
        eventArrayList.add(new Event("Plenary Session 3", "09:30 - 11:00"));
        eventArrayList.add(new Event("Tea Break", "11:00 - 11:30"));
        eventArrayList.add(new Event("Technical Session 2", "11:30 - 01:00"));
        eventArrayList.add(new Event("Lunch Break", "01:00 - 02:00"));
        eventArrayList.add(new Event("Technical Session 3", "02:00 - 03:30"));
        eventArrayList.add(new Event("Tea Break", "03:30 - 04:00"));
        eventArrayList.add(new Event("Plenary Session 4", "04:00 - 05:30"));
        eventArrayList.add(new Event("Cocktails, Cultural Program & Dinner", "06:30 - 10:00"));

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

        ListView listView = (ListView) v.findViewById(R.id.listView);
        listView.setAdapter(arrayAdapter);

        return v;
    }

    public static SecondDay newInstance() {
        SecondDay secondDay = new SecondDay();
        return secondDay;
    }
}
