package com.example.android.ghdirectory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.app.Activity;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

public class welcomepage extends AppCompatActivity {

    static EditText search ;

    public String searchfinal = "" ;

    public String category = "" ;

    Spinner spinner;
    String[] spinnerValue = {
            "Name",
            "Blood Group",
            "Caste"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomepage);

        spinner =(Spinner)findViewById(R.id.spinner1);


        final spinnerAdapter adapter = new spinnerAdapter(welcomepage.this, android.R.layout.simple_list_item_1);
        adapter.addAll(spinnerValue);
        adapter.add("Select Category");
        spinner.setAdapter(adapter);
        spinner.setSelection(adapter.getCount());

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // TODO Auto-generated method stub

                if(spinner.getSelectedItem() == "Select Category")
                {

                }
                else{

                    category = spinner.getSelectedItem().toString() ;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });

        search = findViewById(R.id.searchtext);

    }

    public void search (View view){

        searchfinal = welcomepage.search.getText().toString() ;

        Intent in = new Intent(this,results.class);
        startActivity(in);

    }

    public String returncategory (){
        return category ;
    }

    public String returnsearch (){
        return searchfinal ;
    }

}

