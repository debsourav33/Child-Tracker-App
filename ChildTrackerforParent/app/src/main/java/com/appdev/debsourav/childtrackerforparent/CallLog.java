package com.appdev.debsourav.childtrackerforparent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//import static com.appdev.debsourav.childtrackerforparent.ChildList.childID;

public class CallLog extends AppCompatActivity {

    DatabaseReference mRef;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_log);

        setTitle("Call Log");

        mRef= FirebaseDatabase.getInstance().getReference().child(ChildList.childID).child("CallLog");
        recyclerView= findViewById(R.id.rView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerAdapter<Call, CallViewHolder> firebaseRecyclerAdapter= new FirebaseRecyclerAdapter <Call, CallViewHolder>
                (Call.class, R.layout.call_card, CallViewHolder.class, mRef) {
            @Override
            protected void populateViewHolder(CallViewHolder viewHolder, Call model, int position) {
                viewHolder.setCaller(model.getPhNumber());
                viewHolder.setCallerName(model.getCallerName());
                viewHolder.setCallType(model.getCallType());
                viewHolder.setCallDuration(model.getCallDuration());
                viewHolder.setCallDate(model.getCallDate());
            }
        };

        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}
