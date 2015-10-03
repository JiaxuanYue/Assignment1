package com.mycompany.assignment1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Looper;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.RenamingDelegatingContext;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

public class ReactionTimerActivity extends AppCompatActivity {
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reaction_timer);
        AlertDialog.Builder builder = new AlertDialog.Builder(ReactionTimerActivity.this);
        builder.setTitle("\n" + "HINT");
        builder.setMessage("click 'START' button to start game, and click button for timer if it shows RED 'click'");
        builder.setPositiveButton("OK", null);
        builder.create().show();
        Button btn2 =(Button)findViewById(R.id.clickButton);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Delay();
            }
        });
    }

    private void Delay() {
        if (btn == null) {
            int A = 10;
            int B = 2000;
            final String value = String.valueOf((int) (Math.random() * (1991) + 10));
            try {
                Thread.currentThread().sleep(Long.parseLong(value));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            btn = (Button) findViewById(R.id.clickButton);
            btn.setText("click");
            btn.setTextColor(Color.RED);
            final long startTime = System.nanoTime();
            Button btn2 = (Button) findViewById(R.id.clickButton);
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    long endTime = System.nanoTime();
                    long reactionTime = endTime - startTime;
                    float time= (float)(reactionTime/1000000000.0);
                    AlertDialog.Builder timer = new AlertDialog.Builder(ReactionTimerActivity.this);
                    timer.setTitle("\n" + "HINT");
                    timer.setMessage(String.format("%5f", time));
                    timer.setPositiveButton("RETRY", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which){
                            Delay2();
                        }
                    });
                    timer.create().show();

                }

            });
        }
    }
    private void Delay2(){
        int A = 10;
        int B = 2000;
        final String value = String.valueOf((int) (Math.random() * (1991) + 10));
        try {
            Thread.currentThread().sleep(Long.parseLong(value));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        btn = (Button) findViewById(R.id.clickButton);
        btn.setText("click");
        btn.setTextColor(Color.RED);
        final long startTime = System.nanoTime();
        Button btn2 = (Button) findViewById(R.id.clickButton);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long endTime = System.nanoTime();
                long reactionTime = endTime - startTime;
                float time= (float)(reactionTime/1000000000.0);
                AlertDialog.Builder timer = new AlertDialog.Builder(ReactionTimerActivity.this);
                timer.setTitle("\n" + "HINT");
                timer.setMessage(String.format("%5f", time));
                timer.setPositiveButton("retry", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        Delay2();
                    }
                });
                timer.create().show();

            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reaction_timer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
