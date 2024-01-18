package com.example.wht_clone.model;

import com.google.firebase.auth.FirebaseAuth;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Chatmessage {
    String senderid;
    String text;
    long time;
    boolean ismine;

    public Chatmessage(String senderid, String text, long time ) {
        this.senderid = senderid;
        this.text = text;
        this.time = time;


    }

    public Chatmessage() {
    }




    public String getSenderid() {
        return senderid;
    }

    public void setSenderid(String senderid) {
        this.senderid = senderid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isIsmine() {
        if(senderid.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())){
            return true;
        }
        return false;
    }

    public void setIsmine(boolean ismine) {
        this.ismine = ismine;
    }

    public String converttime(){
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
        Date date=new Date(getTime());
        sdf.setTimeZone(TimeZone.getDefault());
        return sdf.format(date);


    }
}
