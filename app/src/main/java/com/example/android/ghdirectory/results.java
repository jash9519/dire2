package com.example.android.ghdirectory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class results extends AppCompatActivity {

    public String rescategory = "" ;
    public String ressearch  = "" ;

    public String[] finalresults = new String[11] ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

    }

    welcomepage wel = new welcomepage() ;

    AccessingFirebase af = new AccessingFirebase();

    public void resfunc () {

        ressearch = wel.searchfinal ;
        rescategory =wel.category;

        finalresults = af.userdetails(rescategory,ressearch) ;

        TextView textView0 = findViewById(R.id.caste);
        textView0.setText(finalresults[2]);
        TextView textView1 = findViewById(R.id.fullname);
        textView1.setText(finalresults[1]);
        TextView textView2 = findViewById(R.id.education);
        textView2.setText(finalresults[7]);
        TextView textView3 = findViewById(R.id.resiaddress);
        textView3.setText(finalresults[10]);
        TextView textView4 = findViewById(R.id.gender);
        textView4.setText(finalresults[4]);
        TextView textView5 = findViewById(R.id.profaddress);
        textView5.setText(finalresults[8]);
        TextView textView6 = findViewById(R.id.dateofbirth);
        textView6.setText(finalresults[5]);
        TextView textView7 = findViewById(R.id.marrdate);
        textView7.setText(finalresults[6]);
        TextView textView8 = findViewById(R.id.email);
        textView8.setText(finalresults[0]);
        TextView textView9 = findViewById(R.id.phonenumber);
        textView9.setText(finalresults[9]);
        TextView textView10 = findViewById(R.id.bldgrp);
        textView10.setText(finalresults[3]);

    }

}
