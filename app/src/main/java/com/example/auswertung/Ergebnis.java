package com.example.auswertung;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;

public class Ergebnis extends AppCompatActivity {
    int endergebnis = 0;
    double schnitt = 0;
    int serie1 = 0;
    int serie2 = 0;
    int serie3 = 0;
    int serie4 = 0;
    String [] sa = new String[45];
    public static String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/auswertung";
    static Calendar calendar = Calendar.getInstance();
    static String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ergebnis);
        Button save  = (Button) findViewById(R.id.save);

        TextView text = findViewById(R.id.tv1);
        TextView text2 = findViewById(R.id.tv2);

        Intent intent = getIntent();
        int [] ringe = intent.getIntArrayExtra(MainActivity.ergebnis);
        int schuss = intent.getIntExtra(MainActivity.schuss, 0);

        StringBuilder gesamt = new StringBuilder();
        for(int i = 0; i<10;i++){
            serie1 = serie1 + ringe[i];
        }
        for(int i = 10; i<20;i++){
            serie2 = serie2 + ringe[i];
        }
        for(int i = 20; i<30;i++){
            serie3 = serie3 + ringe[i];
        }
        for(int i = 30; i<40;i++){
            serie4 = serie4 + ringe[i];
        }
        for(int i = 0; i<40; i++){
            if(i==0){
                gesamt.append("1.Serie: " + serie1 + "\n");
            }
            if(i==10){
                gesamt.append("2.Serie: " + serie2 + "\n");
            }
            if(i==20){
                gesamt.append("3.Serie: " + serie3 + "\n");
            }
            if(i==30){
                gesamt.append("4.Serie: " + serie4 + "\n");
            }
            gesamt.append(i+1).append(". Schuss: ").append(ringe[i]).append("\n");
            endergebnis = endergebnis + ringe[i];

        }

        schnitt = (double) endergebnis / (double) schuss;

        text.setText(gesamt);
        text2.setText("Gesamt: " + endergebnis + "  Schnitt: " + Double.toString(schnitt) + "  Schüsse: " + schuss);

        sa[0] = "Gesamt: " + endergebnis + "  Schnitt: " + Double.toString(schnitt) + "  Schüsse: " + schuss;
        sa[1] = "1.Serie: " + serie1;
        for(int i = 0; i<10; i++){
            sa[i+2] = Integer.toString(ringe[i]) ;
        }
        sa[11] = "2.Serie: " + serie2;
        for(int i = 10; i<20; i++){
            sa[i+2] = Integer.toString(ringe[i]) ;
        }
        sa[21] = "3.Serie " + serie3;
        for(int i = 20; i<30; i++){
            sa[i+2] = Integer.toString(ringe[i]) ;
        }
        sa[31] = "4.Serie" + serie4;
        for(int i = 30; i<40; i++){
            sa[i+2] = Integer.toString(ringe[i]) ;
        }
        sa[41] = "Datum:";

        File dir = new File(path);
        dir.mkdirs();
    }

    public void speichern (View view){
        File file = new File(path + "/test.txt");
        String[] saveTest = {"Hallo"};
        Toast.makeText(getApplicationContext(), "Gespeichert", Toast.LENGTH_LONG).show();
        Save(file, sa);
    }

    public static void Save(File file, String[] data) {
        FileOutputStream fos = null;
        try
        {
            fos = new FileOutputStream(file);
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        try
        {
            try
            {
                for (int i = 0; i<data.length; i++)
                {
                    fos.write(data[i].getBytes());
                    if (i < data.length-1)
                    {
                        fos.write("\n".getBytes());
                    }
                }
            }
            catch (IOException e) {e.printStackTrace();}
        }
        finally
        {
            try
            {
                fos.close();
            }
            catch (IOException e) {e.printStackTrace();}
        }
    }
}
