package com.mycompany.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


//UI, choose timer record/ 2 buzzers record/ 3 buzzers record/ 4 buzzers record
public class RecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record);
        Button btn1 =(Button)findViewById(R.id.reactionRecordButton);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RecordActivity.this, ReactionRecordActivity.class);
                startActivity(intent);

            }
        });
        Button btn2 =(Button)findViewById(R.id.twoBuzzersRecordButton);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RecordActivity.this, TwoBuzzerRecordActivity.class);
                startActivity(intent);

            }
        });
        Button btn3 =(Button)findViewById(R.id.threeBuzzersRecordButton);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RecordActivity.this, ThreeBuzzerRecordActivity.class);
                startActivity(intent);

            }
        });
        Button btn4 =(Button)findViewById(R.id.fourBuzzersRecordButton);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RecordActivity.this, FourBuzzerRecordActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_record, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }
}
