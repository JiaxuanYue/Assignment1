package com.mycompany.assignment1;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


//show the record of four buzzers game


public class TwoBuzzerRecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_buzzer_record);
        Datasave data = Datasave.sharedDatasave();
        TextView Player1 = (TextView) this.findViewById(R.id.twoplayers1);
        TextView Player2 = (TextView) this.findViewById(R.id.twoplayers2);
        this.setString(String.format("%.0f", this.player1(data.Twoplayers1)),Player1 );
        this.setString(String.format("%.0f", this.player2(data.Twoplayers2)),Player2 );

    }
    private void setInt(int i, TextView textView) {
        this.setString(String.format("%d", i), textView);
    }

    private void setString(String string, TextView textView) {
        textView.setText(string.toCharArray(), 0, string.length());
    }

    private Double player1(List<Double> list) {
        Double sum1 = 0.0;
        for (Double d : list) {
            sum1 += d;
        }
        return sum1;
    }
    private Double player2(List<Double> list) {
        Double sum2 = 0.0;
        for (Double d : list) {
            sum2 += d;
        }
        return sum2;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_two_buzzer_record, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.clear) {
            Datasave.sharedDatasave().reset(this);
            Intent intent = new Intent(this, TwoBuzzerRecordActivity.class);
            this.startActivity(intent);
            this.finish();
        }
        if (id == R.id.email) {
            String Statistics = "";
            Statistics += "\ttwo_players1_win: " + ((TextView) this.findViewById(R.id.twoplayers1)).getText() + "\n";
            Statistics += "\ttwo_players2_win: " + ((TextView) this.findViewById(R.id.twoplayers2)).getText() + "\n";

            Statistics += "Jiaxuan Yue\n";

            //Following function based on http://stackoverflow.com/a/2197841/393009
            Intent text = new Intent(Intent.ACTION_SENDTO);
            text.setType("message/rfc822");
            text.putExtra(Intent.EXTRA_SUBJECT, "2 buzzer");
            text.putExtra(Intent.EXTRA_TEXT, Statistics);
            text.setData(Uri.parse("mailto:jiaxuan2@ualberta.ca"));
            try {
                this.startActivity(Intent.createChooser(text, "Send mail..."));
            } catch (ActivityNotFoundException e) {
                Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
            }

        }
        return super.onOptionsItemSelected(item);
    }
}
