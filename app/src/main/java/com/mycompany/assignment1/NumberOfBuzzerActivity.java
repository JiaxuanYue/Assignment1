package com.mycompany.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

//UI, choose the number of buzzer players

public class NumberOfBuzzerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number_of_buzzer);

        Button btn1 =(Button)findViewById(R.id.twoBuzzersButton);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NumberOfBuzzerActivity.this, TwoBuzzerActivity.class);
                startActivity(intent);
            }
        });

        Button btn2 =(Button)findViewById(R.id.threeBuzzersButton);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NumberOfBuzzerActivity.this, ThreeBuzzerActivity.class);
                startActivity(intent);
            }
        });

        Button btn3 =(Button)findViewById(R.id.fourBuzzersButton);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NumberOfBuzzerActivity.this, FourBuzzerActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_number_of_buzzer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }
}
