package com.appdev.debsourav.childtrackerforparent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.anychart.anychart.DataEntry;
import com.anychart.anychart.ValueDataEntry;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ChartData extends AppCompatActivity {

    DatabaseReference WeeklyRef;
    static List<DataEntry> data = new ArrayList<>();
    Button btnPie, btnFunnel;
    static int accessed=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_data);


        WeeklyRef= FirebaseDatabase.getInstance().getReference("Shan/WeeklyLog");

        WeeklyRef.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                int val = dataSnapshot.getValue(Integer.class);
                String key = dataSnapshot.getKey();
                //int val = Integer.parseInt(value);
                int hours = val/3600;
                int minutes = val/60;
                int seconds = val%60;
                String appname = "App Name: "+key;

                String duration = "\nRun Time: "+hours+" hours "+minutes+" minutes "+seconds+" seconds";
                System.out.println(appname+minutes);
                if(accessed==1) {
                    if (minutes > 4) data.add(new ValueDataEntry(key, minutes));
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btnPie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Weekly.class));
            }
        });
        btnFunnel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), WeeklyFunnel.class));
            }
        });
        accessed++;

    }
}