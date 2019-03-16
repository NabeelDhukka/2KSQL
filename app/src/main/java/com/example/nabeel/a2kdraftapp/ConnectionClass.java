package com.example.nabeel.a2kdraftapp;

import android.annotation.SuppressLint;
import android.os.StrictMode;

import java.sql.Connection;

/**
 * Created by Nabeel on 3/16/2019.
 */

public class ConnectionClass {

    String classs = "com.mysql.jdbc.Driver";
    //put IP Adress of the COMP and DB name
    String url = "jdbc:mysql://192.168.43.48/andro";
    String un  = "ride";
    String password = "789";


    @SuppressLint("NewApi")
    public Connection CONN(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy().Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


    }

}
