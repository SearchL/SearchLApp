package com.eduardo.workcomm.workcomm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    private CircleImageView photo;
    private TextView name;
    private RecyclerView message;
    private EditText nmessage;
    private ImageButton send;

    private AdapterMessage adapter;

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        photo = (CircleImageView)findViewById(R.id.photo);
        name = (TextView)findViewById(R.id.eduardo);
        message = (RecyclerView)findViewById(R.id.emessage);
        nmessage = (EditText)findViewById(R.id.nmessage);
        send = (ImageButton)findViewById(R.id.btnsend);

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("chat");

        adapter = new AdapterMessage(this);
        LinearLayoutManager l = new LinearLayoutManager(this);
        message.setLayoutManager(l);
        message.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.push().setValue(new Message(nmessage.getText().toString(),
                        name.getText().toString(),"","1","00:00"));
                nmessage.setText("");
            }
        });
        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                setScroll();
            }
        });
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Message m = dataSnapshot.getValue(Message.class);
                adapter.addMessage(m);

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
    }

    private void setScroll(){
        message.scrollToPosition(adapter.getItemCount()-1);
    }
}
