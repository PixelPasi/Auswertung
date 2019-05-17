package com.example.auswertung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static String ergebnis = "com.example.auswertung.ergebnis";
    public static String schuss = "com.example.auswertung.schuss";
    int[] ringe = new int[40];
    int j = 0;
    int endergebniss = 0;
    double schnitt = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b10 = findViewById(R.id.b10);
        Button b9 = findViewById(R.id.b9);
        Button b8 = findViewById(R.id.b8);
        Button b7 = findViewById(R.id.b7);
        Button b6 = findViewById(R.id.b6);
        Button b5 = findViewById(R.id.b5);
        Button b4 = findViewById(R.id.b4);
        Button b3 = findViewById(R.id.b3);
        Button b2 = findViewById(R.id.b2);
        Button b1 = findViewById(R.id.b1);
        Button b0 = findViewById(R.id.b0);

        b0.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b10.setOnClickListener(this);

        Button button = findViewById(R.id.bneu);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auswertung();
            }
        });
    }

    public void auswertung(){
        Intent intent = new Intent(this, Ergebnis.class);
        intent.putExtra(ergebnis, ringe);
        intent.putExtra(schuss, j);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if(j<40){
            switch (v.getId()) {
                case (R.id.b0):
                    ringe[j] = 0;
                    break;
                case (R.id.b1):
                    ringe[j] = 1;
                    break;
                case (R.id.b2):
                    ringe[j] = 2;
                    break;
                case (R.id.b3):
                    ringe[j] = 3;
                    break;
                case (R.id.b4):
                    ringe[j] = 4;
                    break;
                case (R.id.b5):
                    ringe[j] = 5;
                    break;
                case (R.id.b6):
                    ringe[j] = 6;
                    break;
                case (R.id.b7):
                    ringe[j] = 7;
                    break;
                case (R.id.b8):
                    ringe[j] = 8;
                    break;
                case (R.id.b9):
                    ringe[j] = 9;
                    break;
                case (R.id.b10):
                    ringe[j] = 10;
                    break;
            }

            endergebniss = endergebniss + ringe[j];

        schnitt = (double) endergebniss / (double) (j+1);

        TextView text3 = findViewById(R.id.text3);
        text3.setText("Gesamt: " + Integer.toString(endergebniss) + "  Schnitt: " + Double.toString(schnitt) + "  Schüsse: " + (j+1));

            j++;
        }
    }
}