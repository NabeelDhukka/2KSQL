package com.example.nabeel.a2kdraftapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import junit.runner.Version;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    private static final Logger LOGGER = Logger.getLogger(MainActivity.class.getName());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.RosterContainer);

        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String url = "jdbc:mysql://10.0.0.21/2Krosters";
        String user = "root";
        String pass ="";
        List<String> roster = new ArrayList<>();
        int i = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM 2Krosters");
            LOGGER.log(Level.FINE,"RESULT SET IS----->"+resultSet.toString());
            while(resultSet.next()){
                roster.add(resultSet.getString(i));
                i++;
            }

        } catch (SQLException e) {
            System.out.println("SQL ERRROR WAS FOUND");
        } catch (ClassNotFoundException e) {
//            Logger lgr =  LogRecord("ClassNotFound Exception was thrown");
            LOGGER.log(Level.FINE,"Class not found exception");
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                LOGGER.log(Level.WARNING, ex.getMessage(), ex);
            }
        }




    }

    public void fillRoster(List<String> roster){
        roster.add("Steph Curry");
        roster.add("Klay Thompson");
        roster.add("Kawhi Leonard");
        roster.add("Rudy Gay");
        roster.add("Rudy Gobert");
        roster.add("Boban Marjanovic");
        roster.add("Luka Doncic");
        roster.add("Serge Ibaka");
        roster.add("Chris Paul");
        roster.add("Brook Lopez");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, roster);
        listView.setAdapter(arrayAdapter);
    }



}
