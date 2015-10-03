package com.mycompany.assignment1;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ThreeBuzzerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_buzzer);

        Button btn1=(Button)findViewById(R.id.threePlayer1Button);

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ThreeBuzzerActivity.this);
                builder.setTitle("\n" + "Congratulation");
                builder.setMessage("Player 1 WIN");
                builder.setPositiveButton("OK", null);
                builder.create().show();

            }

        });

        Button btn2=(Button)findViewById(R.id.threePlayer2Button);

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ThreeBuzzerActivity.this);
                builder.setTitle("\n" + "Congratulation");
                builder.setMessage("Player 2 WIN");
                builder.setPositiveButton("OK", null);
                builder.create().show();

            }

        });

        Button btn3=(Button)findViewById(R.id.threePlayer3Button);

        btn3.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ThreeBuzzerActivity.this);
                builder.setTitle("\n" + "Congratulation");
                builder.setMessage("Player 3 WIN");
                builder.setPositiveButton("OK", null);
                builder.create().show();

            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_three_buzzer, menu);
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
