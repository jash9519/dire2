package com.example.android.ghdirectory;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity {

    static EditText fullname,dob,email,resiadd,profadd,caste,phonenumber,education,password,bldgrp,gender,mardate;


    AccessingFirebase fba;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        fullname=findViewById(R.id.fullname);
        dob=findViewById(R.id.dateofbirth);
        mardate=findViewById(R.id.marrdate);
        bldgrp=findViewById(R.id.bldgrp);
        gender=findViewById(R.id.gender);
        email=findViewById(R.id.email);
        resiadd=findViewById(R.id.resiaddress);
        profadd=findViewById(R.id.profaddress);
        caste=findViewById(R.id.caste);
        password=findViewById(R.id.password);
        phonenumber=findViewById(R.id.phonenumber);
        education=findViewById(R.id.education) ;

        email.setText("");
        password.setText("");

        mAuth = FirebaseAuth.getInstance();

    }

    public void signUp2(View v)
    {

        Toast.makeText(signup.this, "NO FIELD SHOULD BE LEFT BLANK",Toast.LENGTH_LONG).show();

         mAuth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
             @Override
             public void onComplete(@NonNull Task<AuthResult> task) {
                 if (task.isSuccessful()) {

                     FirebaseUser user = mAuth.getCurrentUser();
                     Toast.makeText(signup.this, "User registered successfully",Toast.LENGTH_LONG).show();

                     user u=new user();
                     u.setFullname(signup.fullname.getText().toString());
                     u.setDob(signup.dob.getText().toString());
                     u.setEmail(signup.email.getText().toString());
                     u.setResiadd(signup.resiadd.getText().toString());
                     u.setCaste(signup.caste.getText().toString()) ;
                     u.setEducation(signup.education.getText().toString()) ;
                     u.setProfadd(signup.profadd.getText().toString());
                     u.setMardate(signup.mardate.getText().toString());
                     u.setGender(signup.gender.getText().toString());
                     u.setBldgrp(signup.bldgrp.getText().toString());
                     u.setPassword(signup.password.getText().toString());
                     u.setPhonenumber(signup.phonenumber.getText().toString());

                     fba=new AccessingFirebase();
                     fba.addObjectToFirebase(u);

                     //TODO sign up ke baad wale page ka code

                 }
                 else {

                     try {
                         throw task.getException();
                     }
                     catch(FirebaseAuthUserCollisionException e) {
                         Toast.makeText(signup.this, "Email already in use for other account",Toast.LENGTH_LONG).show();
                         signup.email.setText("");
                     }
                     catch(FirebaseAuthWeakPasswordException e) {
                         signup.password.setError(e.getReason());
                         signup.password.requestFocus();
                     }
                     catch (FirebaseNetworkException e){
                         Toast.makeText(signup.this, "No internet connection",Toast.LENGTH_LONG).show();
                     }

                     catch(Exception e) {
                         Toast.makeText(signup.this,e.toString(),Toast.LENGTH_LONG).show();
                     }

                 }

             }
         });

    }


}

