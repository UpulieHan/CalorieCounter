package com.example.caloriecounter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CalorieResult extends AppCompatActivity {

    //retrieve data sent from the main activity
    private ArrayList<String> myList;

    //database reference to be used to retrieve data
    DatabaseReference dbRef;

    //to store the values retrieved in the Food class
    int cal;
    int total;
    String food;

    //to show the total calories
    TextView textView;
    ImageView im;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_result);


        myList= (ArrayList<String>) getIntent().getSerializableExtra("myList");

        textView=findViewById(R.id.textView3);


            dbRef= FirebaseDatabase.getInstance().getReference();
            dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for(String foodN:myList) {
                        food = foodN;
                        if (dataSnapshot.hasChildren()) {
                            cal = Integer.parseInt(dataSnapshot.child(food).getValue().toString());

                            total+=cal;
                            Log.i("upulie", Integer.toString(total));
                        } else {
                            Toast.makeText(getApplicationContext(), "No food items selected", Toast.LENGTH_LONG).show();
                        }
                    }
                    textView.setText(Integer.toString(total));

                    im = findViewById(R.id.imageView);

                    //should have done according to the bmi and the gender
                    if (total <=1750){
                        im.setImageResource(R.drawable.low);
                    }else if(total>1750 && total<=2000){
                        im.setImageResource(R.drawable.moderate);
                    }else{
                        im.setImageResource(R.drawable.high);
                    }

                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) { }
            });

    }
}
