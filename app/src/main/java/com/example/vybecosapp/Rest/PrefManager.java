package com.example.vybecosapp.Rest;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    private PrefManager() {
    }
    private static final String PREF_NAME = "VYBECOS";
    private static final String FIRST_LOGIN = "FIRST_LOGIN";

    private static final String uname = "uname";
    private static final String pword = "pword";
    private static final String name_edtxt = "name_edtxt";
    private static final String email_edtxt = "email_edtxt";

    private static final String period = "period";
    private static final String futureSlection = "futureSlection";
    private static final String contentBox = "contentBox";
    private static final String ID = "ID";

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;
    // shared pref mode
    int PRIVATE_MODE = Context.MODE_PRIVATE;

    public PrefManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
    public void setRegistrationDetails(String uname, String pword, String name_edtxt, String email_edtxt) {
        editor.putString("uname", uname);
        editor.putString("pword", pword);
        editor.putString("name_edtxt", name_edtxt);
        editor.putString("email_edtxt", email_edtxt);
        editor.commit();
    }
    public String getuname() {
        return pref.getString(uname, "");
    }
    public String getpword() {
        return pref.getString(pword, "");
    }
    public String getname_edtxt() {
        return pref.getString(name_edtxt, "");
    }

    public String getemail_edtxt() {
        return pref.getString(email_edtxt, "");
    }

    public boolean IsFirstLogin(){
        return pref.getBoolean(FIRST_LOGIN,true);
    }

    public void setFirstTimeLaunch(boolean b) {
        editor.putBoolean(FIRST_LOGIN, b);
        editor.commit();
    }

    //clear all
    public void clearAll() {
        editor.clear();
        editor.commit();
    }

    public void setReviewDetails(Integer ID,String period, String futureSlection, String contentBox) {
        editor.putInt("ID", ID);
        editor.putString("period", period);
        editor.putString("futureSlection", futureSlection);
        editor.putString("contentBox", contentBox);
        editor.commit();
    }
    public Integer getID() {
        return pref.getInt(ID, 0);
    }
    public String getperiod() {
        return pref.getString(period, "");
    }
    public String getfutureSlection() {
        return pref.getString(futureSlection, "");
    }
    public String getcontentBox() {
        return pref.getString(contentBox, "");
    }

}