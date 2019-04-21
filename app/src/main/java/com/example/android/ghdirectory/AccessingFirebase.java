package com.example.android.ghdirectory;

import android.support.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AccessingFirebase
{
    DatabaseReference alluserdetails;

    AccessingFirebase()
    {
        alluserdetails=FirebaseDatabase.getInstance().getReference("alluserdetails");
    }

    public void addObjectToFirebase(final user u)
    {
        alluserdetails.addValueEventListener(new ValueEventListener()
        {
            int counter=0,flag=1;
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot userincoating : dataSnapshot.getChildren())
                {
                    counter++;
                    user user=userincoating.getValue(user.class);
                    if( (user.getEmail()).equals(u.getEmail()) )
                    {
                        flag=0;
                        break;
                    }
                }

                if(flag==1)
                {
                    u.setCount(++counter);
                    String id = alluserdetails.push().getKey(); //This lets us make new user every time by generating new id each time
                    alluserdetails.child(id).setValue(u);

                    //TODO ??? toast that user added

                }
                else
                    //TODO  ??? toast that user not added
                    ;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    public String[] userdetails (String scategory,String ssearch) {
        FirebaseUser users = FirebaseAuth.getInstance().getCurrentUser();
        String category=scategory;
        final String search = ssearch ;
        final String[] result = new String[11] ;

        if (category.equals("Name")) {
            alluserdetails.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    for (DataSnapshot userincoating : dataSnapshot.getChildren()){
                        user users = userincoating.getValue(user.class);
                        if ((users.getFullname()).equals(search)) {
                            result[0] = users.getEmail() ;
                            result[1] = users.getFullname() ;
                            result[2] = users.getCaste() ;
                            result[3] = users.getBldgrp() ;
                            result[4] = users.getGender() ;
                            result[5] = users.getDob() ;
                            result[6] = users.getMardate() ;
                            result[7] = users.getEducation() ;
                            result[8] = users.getProfadd() ;
                            result[9] = users.getPhonenumber() ;
                            result[10] = users.getResiadd() ;
                            DatabaseReference childref = userincoating.getRef();
                            childref.setValue(users);
                            break;
                        }

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        else if (category.equals("Blood Group")) {
            alluserdetails.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    for (DataSnapshot userincoating : dataSnapshot.getChildren()) {
                        user users = userincoating.getValue(user.class);
                        if ((users.getBldgrp()).equals(search)) {
                            DatabaseReference childref = userincoating.getRef();
                            result[0] = users.getEmail() ;
                            result[1] = users.getFullname() ;
                            result[2] = users.getCaste() ;
                            result[3] = users.getBldgrp() ;
                            result[4] = users.getGender() ;
                            result[5] = users.getDob() ;
                            result[6] = users.getMardate() ;
                            result[7] = users.getEducation() ;
                            result[8] = users.getProfadd() ;
                            result[9] = users.getPhonenumber() ;
                            result[10] = users.getResiadd() ;
                            childref.setValue(users);
                            break;
                        }

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        else if (category.equals("Caste")) {
            alluserdetails.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    for (DataSnapshot userincoating : dataSnapshot.getChildren()) {
                        user users = userincoating.getValue(user.class);
                        if ((users.getCaste()).equals(search)) {
                            DatabaseReference childref = userincoating.getRef();
                            result[0] = users.getEmail() ;
                            result[1] = users.getFullname() ;
                            result[2] = users.getCaste() ;
                            result[3] = users.getBldgrp() ;
                            result[4] = users.getGender() ;
                            result[5] = users.getDob() ;
                            result[6] = users.getMardate() ;
                            result[7] = users.getEducation() ;
                            result[8] = users.getProfadd() ;
                            result[9] = users.getPhonenumber() ;
                            result[10] = users.getResiadd() ;
                            childref.setValue(users);
                            break;
                        }

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        return result ;

    }

}

