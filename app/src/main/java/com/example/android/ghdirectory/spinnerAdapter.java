package com.example.android.ghdirectory;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class spinnerAdapter extends ArrayAdapter<String> {

    public String adcategory ;

    public spinnerAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        // TODO Auto-generated constructor stub

    }

    @Override
    public int getCount() {

        // TODO Auto-generated method stub
        int count = super.getCount();

        return count>0 ? count-1 : count ;


    }

}
