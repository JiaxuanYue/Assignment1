package com.mycompany.assignment1;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
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
    private static final String FileName = "Data.bin";


    public static Datasave sharedDatasave() {
        if (instance == null) {
            instance = new Datasave();
        }
        return instance;
    }



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

    public void loadFromFile(Context context) {
        try {
            FileInputStream fis = context.openFileInput(FileName);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            // Following line based on https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html retrieved 2015-09-21
            Type listType = new TypeToken<Datasave>() {}.getType();
            instance = gson.fromJson(in, listType);

        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveInFile(Context context) {
        try {
            FileOutputStream fos = context.openFileOutput(FileName,
                    0);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(instance, writer);
            writer.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}