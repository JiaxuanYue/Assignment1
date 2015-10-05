package com.mycompany.assignment1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

//UI, choose reaction timer/buzzer/record


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Datasave.sharedDatasave().loadFromFile(this);

        Button btn1 =(Button)findViewById(R.id.reactionTimerButton);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ReactionTimerActivity.class);
                startActivity(intent);

            }
        });

        Button btn2 =(Button)findViewById(R.id.gameshowBuzzerButton);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,NumberOfBuzzerActivity.class);
                startActivity(intent);
            }
        });

        Button btn3 =(Button)findViewById(R.id.recordButton);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecordActivity.class);
                startActivity(intent);
            }
        });
    }

}
