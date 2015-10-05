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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//show the record of reaction timer
//Base on http://github.com/yourusernameatgithub/yourassignment1.git

public class ReactionRecordActivity extends AppCompatActivity {
    private List<Double> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reaction_record);
        Datasave data = Datasave.sharedDatasave();

        TextView last10Min = (TextView) this.findViewById(R.id.MinimumLast10);
        TextView last100Min = (TextView) this.findViewById(R.id.MinimumLast100);
        TextView allTimeMin = (TextView) this.findViewById(R.id.MinimumAllTime);

        TextView last10Max = (TextView) this.findViewById(R.id.MaximumLast10);
        TextView last100Max = (TextView) this.findViewById(R.id.MaximumLast100);
        TextView allTimeMax = (TextView) this.findViewById(R.id.MaximumAllTime);

        TextView last10Avg = (TextView) this.findViewById(R.id.AverageLast10);
        TextView last100Avg = (TextView) this.findViewById(R.id.AverageLast100);
        TextView allTimeAvg = (TextView) this.findViewById(R.id.AverageAllTime);

        TextView last10Med = (TextView) this.findViewById(R.id.MedianLast10);
        TextView last100Med = (TextView) this.findViewById(R.id.MedianLast100);
        TextView allTimeMed = (TextView) this.findViewById(R.id.MedianAllTime);

        this.setString(String.format("%.3f", this.min(this.last10(data.ReactionTime))), last10Min);
        this.setString(String.format("%.3f", this.min(this.last100(data.ReactionTime))), last100Min);
        this.setString(String.format("%.3f", this.min(data.ReactionTime)), allTimeMin);

        this.setString(String.format("%.3f", this.max(this.last10(data.ReactionTime))), last10Max);
        this.setString(String.format("%.3f", this.max(this.last100(data.ReactionTime))), last100Max);
        this.setString(String.format("%.3f", this.max(data.ReactionTime)), allTimeMax);

        this.setString(String.format("%.3f", this.average(this.last10(data.ReactionTime))), last10Avg);
        this.setString(String.format("%.3f", this.average(this.last100(data.ReactionTime))), last100Avg);
        this.setString(String.format("%.3f", this.average(data.ReactionTime)), allTimeAvg);

        this.setString(String.format("%.3f", this.median(this.last10(data.ReactionTime))), last10Med);
        this.setString(String.format("%.3f", this.median(this.last100(data.ReactionTime))), last100Med);
        this.setString(String.format("%.3f", this.median(data.ReactionTime)), allTimeMed);


    }
    private void setInt(int i, TextView textView) {
        this.setString(String.format("%d", i), textView);
    }

    private void setString(String string, TextView textView) {
        textView.setText(string.toCharArray(), 0, string.length());
    }

    private List<Double> last10(List<Double> list) {
        List<Double> newList = new ArrayList<Double>();
        for (int i = 0; i < Math.min(10, list.size()); ++i) {
            newList.add(list.get(list.size() - 1 - i));
        }
        return newList;
    }

    private List<Double> last100(List<Double> list) {
        List<Double> newList = new ArrayList<Double>();
        for (int i = 0; i < Math.min(100, list.size()); ++i) {
            newList.add(list.get(list.size() - 1 - i));
        }
        return newList;
    }

    private Double min(List<Double> list) {
        if (list.size() == 0) {
            return 0.0;
        }
        Double min = Double.MAX_VALUE;
        for (Double d : list) {
            if (min > d) {
                min = d;
            }
        }
        return min;
    }

    private Double max(List<Double> list) {
        Double max = 0.0;
        for (Double d : list) {
            if (max < d) {
                max = d;
            }
        }
        return max;
    }

    private Double average(List<Double> list) {
        if (list.size() == 0) {
            return 0.0;
        }
        Double sum = 0.0;
        for (Double d : list) {
            sum += d;
        }
        return sum / list.size();
    }

    private Double median(List<Double> list) {
        Collections.sort(list);
        if (list.size() % 2 == 1) {
            return list.get((int) Math.floor(((double) list.size()) / 2.0));
        } else {
            if (list.size() == 0) {
                return 0.0;
            }
            List<Double> newList = new ArrayList<Double>();
            newList.add(list.get(list.size() / 2));
            newList.add(list.get(list.size() / 2 - 1));
            return this.average(newList);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_reaction_record, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.clear) {
            Datasave.sharedDatasave().reset(this);
            Intent intent = new Intent(this, ReactionRecordActivity.class);
            this.startActivity(intent);
            this.finish();
        }

        if (id == R.id.email) {
            String Statistics = "";

            Statistics += "Minimum:\n";
            Statistics += "\tLast 10: " + ((TextView) this.findViewById(R.id.MinimumLast10)).getText() + "\n";
            Statistics += "\tLast 100: " + ((TextView) this.findViewById(R.id.MinimumLast100)).getText() + "\n";
            Statistics += "\tAll Time: " + ((TextView) this.findViewById(R.id.MinimumAllTime)).getText() + "\n";

            Statistics += "Maximum:\n";
            Statistics += "\tLast 10: " + ((TextView) this.findViewById(R.id.MaximumLast10)).getText() + "\n";
            Statistics += "\tLast 100: " + ((TextView) this.findViewById(R.id.MaximumLast100)).getText() + "\n";
            Statistics += "\tAll Time: " + ((TextView) this.findViewById(R.id.MaximumAllTime)).getText() + "\n";

            Statistics += "Average:\n";
            Statistics += "\tLast 10: " + ((TextView) this.findViewById(R.id.AverageLast10)).getText() + "\n";
            Statistics += "\tLast 100: " + ((TextView) this.findViewById(R.id.AverageLast100)).getText() + "\n";
            Statistics += "\tAll Time: " + ((TextView) this.findViewById(R.id.AverageAllTime)).getText() + "\n";

            Statistics += "Median:\n";
            Statistics += "\tLast 10: " + ((TextView) this.findViewById(R.id.MedianLast10)).getText() + "\n";
            Statistics += "\tLast 100: " + ((TextView) this.findViewById(R.id.MedianLast100)).getText() + "\n";
            Statistics += "\tAll Time: " + ((TextView) this.findViewById(R.id.MedianAllTime)).getText() + "\n";

            Statistics += "Jiaxuan Yue\n";

            // http://stackoverflow.com/a/2197841/393009
            Intent text = new Intent(Intent.ACTION_SEND);
            text.setType("message/rfc822");
            text.putExtra(Intent.EXTRA_SUBJECT, "Reaction Statistics");
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