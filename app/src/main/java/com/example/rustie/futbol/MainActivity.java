package com.example.rustie.futbol;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Firebase highScore;
    public int goals = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        highScore = new Firebase("https://brilliant-torch-6378.firebaseio.com/TestCase");
        final TextView goalCount = (TextView) findViewById(R.id.goals);
        goalCount.setText("" + goals);

        Button pressed = (Button) findViewById(R.id.button1);
        pressed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            goals++;

                goalCount.setText("" + goals);
            }
        });

    }

    public void sendScore(int goals){
        String goal = "" + goals;
        Random rand = new Random(1000);
        String player = "player" + rand;
        setHighScore score = new setHighScore("player1", goal);
        highScore.push().setValue(score);
    }
    /*protected void onStart(){
        super.onStart();
        Firebase storeScore = highScore.child("High Score");
        storeScore.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String message = dataSnapshot.getValue(String.class);
                Log.v("E Value", message);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        })
    }*/

}
