package com.example.toshibapc.myapplication;

/**
 * Created by Toshiba PC on 06-01-2015.
 */
public class Speaker {
    private String name;
    private int image;
    private String position;
    private String details;
    public Speaker(String n, int i, String p, String d) {
        name = n;
        image = i;
        position = p;
        details = d;
    }
    public Speaker(String n, int i, String p) {
        name = n;
        image = i;
        position = p;
        details = "Biography Unavailable";
    }
    public Speaker(String n, String p, String d) {
        name = n;
        position = p;
        image = R.drawable.ic_contact_image;
        details = d;
    }
    public Speaker(String n, String p) {
        name = n;
        position = p;
        image = R.drawable.ic_contact_image;
        details = "Biography Unavailable";
    }
    public String getName() {
        return name;
    }
    public String getPosition() {
        return position;
    }
    public int getImage() {
        return image;
    }
    public String getDetails() {
        return  details;
    }
 }