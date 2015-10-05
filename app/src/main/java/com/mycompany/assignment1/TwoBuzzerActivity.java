package com.mycompany.assignment1;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


//activity of two buzzer activity


public class TwoBuzzerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_buzzer);

        Button btn1=(Button)findViewById(R.id.twoPlayer1Button);

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(TwoBuzzerActivity.this);
                builder.setTitle("\n" + "Congratulation");
                builder.setMessage("Player 1 WIN");
                builder.setPositiveButton("OK", null);
                builder.create().show();
                long Player1 =1;
                Double player1 = Double.valueOf(Player1);
                Datasave.sharedDatasave().Twoplayers1.add(player1);
                Datasave.sharedDatasave().saveInFile(v.getContext());

            }

        });

        Button btn2=(Button)findViewById(R.id.twoPlayer2Button);

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(TwoBuzzerActivity.this);
                builder.setTitle("\n" + "Congratulation");
                builder.setMessage("Player 2 WIN");
                builder.setPositiveButton("OK",null);
                builder.create().show();
                long Player2 =1;
                Double player2 = Double.valueOf(Player2);
                Datasave.sharedDatasave().Twoplayers2.add(player2);
                Datasave.sharedDatasave().saveInFile(v.getContext());

            }

        });
    }

}
