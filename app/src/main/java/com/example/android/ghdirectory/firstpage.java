package com.example.android.ghdirectory;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class firstpage extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);


        mAuth = FirebaseAuth.getInstance();
    }

    EditText et1, et2;


    public void login(View v) {

        //Toast.makeText(MainActivity.this, et1.getText().toString(), Toast.LENGTH_LONG).show();

        if(et1.getText().toString().length()==0)
        {
            et1.setError("Field cannot be left blank");
            et1.requestFocus();
        }

        if(et2.getText().toString().length()==0)
            et2.setError("Field cannot be left blank");


        else
        {
            mAuth.signInWithEmailAndPassword(et1.getText().toString(), et2.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                Toast.makeText(firstpage.this,"Successful login", Toast.LENGTH_LONG).show();
                                //FirebaseUser user = mAuth.getCurrentUser();

                                Intent in = new Intent(firstpage.this, welcomepage.class);
                                startActivityForResult(in, 007);

                            }
                            else {

                                try{
                                    throw task.getException();
                                }catch(Exception e) {

                                    if(e.getMessage().equals("The profadd is invalid or the user does not have a profadd."))
                                    {
                                        Toast.makeText(firstpage.this,"Incorrect profadd", Toast.LENGTH_LONG).show();
                                        et2.setText("");
                                    }

                                    else
                                        Toast.makeText(firstpage.this, e.getMessage(), Toast.LENGTH_LONG).show();

                                }

                            }

                        }
                    });

        }

        Intent in = new Intent(this,welcomepage.class) ;
        startActivity(in);

    }


    public void forgotPassword(View v) {
        //TODO SENDING EMAIL
    }

    public void signup(View view){

        Intent in = new Intent(this,signup.class) ;
        startActivity(in);

    }
}
