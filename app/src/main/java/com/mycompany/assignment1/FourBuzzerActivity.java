package com.mycompany.assignment1;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


//activity of four buzzers game


public class FourBuzzerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_buzzer);

        Button btn1=(Button)findViewById(R.id.fourPlayer1Button);

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(FourBuzzerActivity.this);
                builder.setTitle("\n" + "Congratulation");
                builder.setMessage("Player 1 WIN");
                builder.setPositiveButton("OK", null);
                builder.create().show();
                long Player1 =1;
                Double player1 = Double.valueOf(Player1);
                Datasave.sharedDatasave().Fourplayers1.add(player1);
                Datasave.sharedDatasave().saveInFile(v.getContext());

            }

        });

        Button btn2=(Button)findViewById(R.id.fourPlayer2Button);

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(FourBuzzerActivity.this);
                builder.setTitle("\n" + "Congratulation");
                builder.setMessage("Player 2 WIN");
                builder.setPositiveButton("OK", null);
                builder.create().show();
                long Player2 =1;
                Double player2 = Double.valueOf(Player2);
                Datasave.sharedDatasave().Fourplayers2.add(player2);
                Datasave.sharedDatasave().saveInFile(v.getContext());

            }

        });

        Button btn3=(Button)findViewById(R.id.fourPlayer3Button);

        btn3.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(FourBuzzerActivity.this);
                builder.setTitle("\n" + "Congratulation");
                builder.setMessage("Player 3 WIN");
                builder.setPositiveButton("OK", null);
                builder.create().show();
                long Player3 =1;
                Double player3 = Double.valueOf(Player3);
                Datasave.sharedDatasave().Fourplayers3.add(player3);
                Datasave.sharedDatasave().saveInFile(v.getContext());

            }

        });

        Button btn4=(Button)findViewById(R.id.fourPlayer4Button);

        btn4.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(FourBuzzerActivity.this);
                builder.setTitle("\n" + "Congratulation");
                builder.setMessage("Player 4 WIN");
                builder.setPositiveButton("OK", null);
                builder.create().show();
                long Player4 =1;
                Double player4 = Double.valueOf(Player4);
                Datasave.sharedDatasave().Fourplayers4.add(player4);
                Datasave.sharedDatasave().saveInFile(v.getContext());

            }

        });
    }

}
