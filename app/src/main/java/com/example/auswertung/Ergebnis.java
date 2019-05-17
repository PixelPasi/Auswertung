package com.example.auswertung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Ergebnis extends AppCompatActivity {
    int endergebnis = 0;
    double schnitt = 0;
    int serie1 = 0;
    int serie2 = 0;
    int serie3 = 0;
    int serie4 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ergebnis);

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
    }
}
