package com.mycompany.assignment1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;


//show the record of four buzzers game


public class FourBuzzerRecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_buzzer_record);
        Datasave data = Datasave.sharedDataCenter();
        TextView Player1 = (TextView) this.findViewById(R.id.fourplayer1);
        TextView Player2 = (TextView) this.findViewById(R.id.fourplayer2);
        TextView Player3 = (TextView) this.findViewById(R.id.fourplayer3);
        TextView Player4 = (TextView) this.findViewById(R.id.fourplayer4);
        this.setString(String.format("%.0f", this.player1(data.Fourplayers1)), Player1);
        this.setString(String.format("%.0f", this.player2(data.Fourplayers2)), Player2);
        this.setString(String.format("%.0f", this.player3(data.Fourplayers3)), Player3);
        this.setString(String.format("%.0f", this.player4(data.Fourplayers4)), Player4);

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
    private Double player4(List<Double> list) {
        Double sum4 = 0.0;
        for (Double d : list) {
            sum4 += d;
        }
        return sum4;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_four_buzzer_record, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.clear) {
            Datasave.sharedDataCenter().reset(this);
            Intent intent = new Intent(this, FourBuzzerRecordActivity.class);
            this.startActivity(intent);
            this.finish();
        }
        if (id == R.id.email) {
            String Statistics = "";
            Statistics += "\tfour_players1_win: " + ((TextView) this.findViewById(R.id.fourplayer1)).getText() + "\n";
            Statistics += "\tfour_players2_win: " + ((TextView) this.findViewById(R.id.fourplayer2)).getText() + "\n";
            Statistics += "\tfour_players3_win: " + ((TextView) this.findViewById(R.id.fourplayer3)).getText() + "\n";
            Statistics += "\tfour_players4_win: " + ((TextView) this.findViewById(R.id.fourplayer4)).getText() + "\n";

            Statistics += "Jiaxuan Yue\n";

            //Following function based on http://stackoverflow.com/a/2197841/393009
            Intent text = new Intent(Intent.ACTION_SENDTO);
            text.setType("message/rfc822");
            text.putExtra(Intent.EXTRA_SUBJECT, "Reaction Statistics");
            text.putExtra(Intent.EXTRA_TEXT, Statistics);
            text.setData(Uri.parse("mailto:jiaxuan2@ualberta.ca"));


        }

        return super.onOptionsItemSelected(item);
    }
}
