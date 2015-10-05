package com.mycompany.assignment1;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

//save all of the past data and stuff
//Base on http://github.com/yourusernameatgithub/yourassignment1.git

public class Datasave {
    private static Datasave instance = null;

    public List<Double> ReactionTime = new ArrayList<Double>();
    public List<Double> Twoplayers1 = new ArrayList<Double>();
    public List<Double> Twoplayers2 = new ArrayList<Double>();
    public List<Double> Threeplayers1 = new ArrayList<Double>();
    public List<Double> Threeplayers2 = new ArrayList<Double>();
    public List<Double> Threeplayers3 = new ArrayList<Double>();
    public List<Double> Fourplayers1 = new ArrayList<Double>();
    public List<Double> Fourplayers2 = new ArrayList<Double>();
    public List<Double> Fourplayers3 = new ArrayList<Double>();
    public List<Double> Fourplayers4 = new ArrayList<Double>();



    public static Datasave sharedDataCenter() {
        if (instance == null) {
            instance = new Datasave();
        }
        return instance;
    }

    private static final String FileName = "Data.bin";

    private Datasave() {
    }

    public void reset(Context context) {
        context.deleteFile(FileName);
        instance = new Datasave();
    }

    public void load(Context context) {
        try {
            FileInputStream inputStream = context.openFileInput(FileName);
            ObjectInputStream in = new ObjectInputStream(inputStream);
            this.ReactionTime = (List<Double>) in.readObject();
            this.Twoplayers1 = (List<Double>) in.readObject();
            this.Twoplayers2 = (List<Double>) in.readObject();
            this.Threeplayers1 = (List<Double>) in.readObject();
            this.Threeplayers2 = (List<Double>) in.readObject();
            this.Threeplayers3 = (List<Double>) in.readObject();
            this.Fourplayers1 = (List<Double>) in.readObject();
            this.Fourplayers2 = (List<Double>) in.readObject();
            this.Fourplayers3 = (List<Double>) in.readObject();
            this.Fourplayers4 = (List<Double>) in.readObject();
        } catch (Exception e) {}
    }

    public void save(Context context) {
        try {
            FileOutputStream outputStream = context.openFileOutput(FileName, context.MODE_PRIVATE);
            ObjectOutputStream out = new ObjectOutputStream(outputStream);
            out.writeObject(this.Twoplayers1);
            out.writeObject(this.Twoplayers2);
            out.writeObject(this.Threeplayers1);
            out.writeObject(this.Threeplayers2);
            out.writeObject(this.Threeplayers3);
            out.writeObject(this.Fourplayers1);
            out.writeObject(this.Fourplayers2);
            out.writeObject(this.Fourplayers3);
            out.writeObject(this.Fourplayers4);
            out.writeObject(this.ReactionTime);



            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            // Do nothing
            Log.e("", e.getStackTrace().toString());
            throw new RuntimeException(e);
        } catch (IOException e) {
            // Do nothing
            Log.e("", e.getStackTrace().toString());
            throw new RuntimeException(e);
        }
    }
}