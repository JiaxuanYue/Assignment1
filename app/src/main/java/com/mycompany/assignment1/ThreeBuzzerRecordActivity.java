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


public class ThreeBuzzerRecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_buzzer_record);
        Datasave data = Datasave.sharedDatasave();
        TextView Player1 = (TextView) this.findViewById(R.id.threeplayers1);
        TextView Player2 = (TextView) this.findViewById(R.id.threeplayers2);
        TextView Player3 = (TextView) this.findViewById(R.id.threeplayers3);
        this.setString(String.format("%.0f", this.player1(data.Threeplayers1)), Player1);
        this.setString(String.format("%.0f", this.player2(data.Threeplayers2)), Player2);
        this.setString(String.format("%.0f", this.player3(data.Threeplayers3)), Player3);

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
    private Double player3(List<Double> list) {
        Double sum3 = 0.0;
        for (Double d : list) {
            sum3 += d;
        }
        return sum3;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_three_buzzer_record, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.clear) {
            Datasave.sharedDatasave().reset(this);
            Intent intent = new Intent(this, ThreeBuzzerRecordActivity.class);
            this.startActivity(intent);
            this.finish();
        }
        if (id == R.id.email) {
            String Statistics = "";
            Statistics += "\tthree_players1_win: " + ((TextView) this.findViewById(R.id.threeplayers1)).getText() + "\n";
            Statistics += "\tthree_players2_win: " + ((TextView) this.findViewById(R.id.threeplayers2)).getText() + "\n";
            Statistics += "\tthree_players3_win: " + ((TextView) this.findViewById(R.id.threeplayers3)).getText() + "\n";

            Statistics += "Jiaxuan Yue\n";

            //Following function based on http://stackoverflow.com/a/2197841/393009
            Intent text = new Intent(Intent.ACTION_SENDTO);
            text.setType("message/rfc822");
            text.putExtra(Intent.EXTRA_SUBJECT, "3 buzzer");
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
