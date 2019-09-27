package com.example.caloriecounter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ExampleItem> mExampleList;
    private ArrayList<String> eatenList;

    //contains the recyclerView we created in xml layout
    private RecyclerView mRecyclerView;

    //adapter is the bridge between data and recyclerview(needs a class for implementation)
    private ExampleAdapter mAdapter;

    //layoutmanager is responsible for aligning items in the list(Linear LayoutManager will create a ListView)
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createExampleList();
        buildRecyclerView();

    }

    public void buildRecyclerView(){
        //initialize RecyclerView
        mRecyclerView = findViewById(R.id.recyclerView);
        //if RecyclerView won't change in size
        mRecyclerView.setHasFixedSize(true);
        //assign LayoutManager
        mLayoutManager = new LinearLayoutManager(this);
        //assigning Adapter
        mAdapter= new ExampleAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                //change this to add calories to the counter rather than displaying "clicked"
                if(mExampleList.get(position).getmText3()=="Add"){
                    mExampleList.get(position).changeText3("Added");
                    mExampleList.get(position).changeText3("Added");
                    String t=mExampleList.get(position).getmText4()+" is the serving size.";
                    Toast.makeText(getApplicationContext(),t, Toast.LENGTH_SHORT).show();
                    String temp=mExampleList.get(position).getmText1().toLowerCase();
                    //Log.i("upulie",temp);
                    eatenList.add(temp);

                }else{
                    mExampleList.get(position).changeText3("Add");
                }
                mAdapter.notifyItemChanged(position);
            }
        });
    }

    public void createExampleList(){
        mExampleList = new ArrayList<>();
        eatenList=new ArrayList<String>();
        mExampleList.add(new ExampleItem(R.drawable.apple,"Apple",getResources().getString(R.string.f),"Add","4 ounces"));
        mExampleList.add(new ExampleItem(R.drawable.avacado,"Avacado",getResources().getString(R.string.f),"Add","50 grams"));
        mExampleList.add(new ExampleItem(R.drawable.banana,"Banana",getResources().getString(R.string.f),"Add","1/2 a cup" ));
        mExampleList.add(new ExampleItem(R.drawable.bread,"Bread",getResources().getString(R.string.b),"Add","1 ounce"));
        mExampleList.add(new ExampleItem(R.drawable.butter,"Butter",getResources().getString(R.string.b),"Add","1 tablespoon"));
        mExampleList.add(new ExampleItem(R.drawable.carrot,"Carrot",getResources().getString(R.string.l),"Add","1 cup"));
        mExampleList.add(new ExampleItem(R.drawable.cheese,"Cheese",getResources().getString(R.string.s),"Add","1 1/2 ounce"));
        mExampleList.add(new ExampleItem(R.drawable.chicken,"Chicken",getResources().getString(R.string.di),"Add","3.5 ounces"));
        mExampleList.add(new ExampleItem(R.drawable.chocolate,"Chocolate",getResources().getString(R.string.s),"Add","41 grams"));
        mExampleList.add(new ExampleItem(R.drawable.curd,"Curd",getResources().getString(R.string.de),"Add","1 cup"));
        mExampleList.add(new ExampleItem(R.drawable.eggs,"Eggs",getResources().getString(R.string.b),"Add","50 grams"));
        mExampleList.add(new ExampleItem(R.drawable.frechfries,"French Fries",getResources().getString(R.string.s),"Add","0.75 ounces"));
        mExampleList.add(new ExampleItem(R.drawable.grapes,"Grapes",getResources().getString(R.string.f),"Add","1 cup"));
        mExampleList.add(new ExampleItem(R.drawable.hamburger,"Hamburger",getResources().getString(R.string.b),"Add","3.5 ounces"));
        mExampleList.add(new ExampleItem(R.drawable.hotdog,"HotDog",getResources().getString(R.string.b),"Add","50 grams"));
        mExampleList.add(new ExampleItem(R.drawable.icecream,"Ice cream",getResources().getString(R.string.de),"Add","1/2 cup"));
        mExampleList.add(new ExampleItem(R.drawable.juice,"Juice",getResources().getString(R.string.dr),"Add","1 cup"));
        mExampleList.add(new ExampleItem(R.drawable.mango,"Mango",getResources().getString(R.string.f),"Add","1 cup"));
        mExampleList.add(new ExampleItem(R.drawable.milk,"Milk",getResources().getString(R.string.dr),"Add","1 cup"));
        mExampleList.add(new ExampleItem(R.drawable.meat,"Meat",getResources().getString(R.string.di),"Add","3 ounces"));
        mExampleList.add(new ExampleItem(R.drawable.oats,"Oats",getResources().getString(R.string.b),"Add","1/5 cup"));
        mExampleList.add(new ExampleItem(R.drawable.orange,"Orange",getResources().getString(R.string.f),"Add","1 cup"));
        mExampleList.add(new ExampleItem(R.drawable.pasta,"Pasta",getResources().getString(R.string.l),"Add","57 grams"));
        mExampleList.add(new ExampleItem(R.drawable.peanuts,"Peanuts",getResources().getString(R.string.s),"Add","1 ounce"));
        mExampleList.add(new ExampleItem(R.drawable.pineapple,"Pineapple",getResources().getString(R.string.f),"Add","1/2 cup"));
        mExampleList.add(new ExampleItem(R.drawable.pizza,"Pizza",getResources().getString(R.string.l),"Add","6 slices"));
        mExampleList.add(new ExampleItem(R.drawable.pomengranate,"Pomengranate",getResources().getString(R.string.f),"Add","174 grams"));
        mExampleList.add(new ExampleItem(R.drawable.quinoa,"Quinoa",getResources().getString(R.string.l),"Add","93 grams"));
        mExampleList.add(new ExampleItem(R.drawable.rice,"Rice",getResources().getString(R.string.l),"Add","90 grams"));
//        exampleList.add(new ExampleItem(R.drawable.salad,"Salad",getResources().getString(R.string.b)));
//        exampleList.add(new ExampleItem(R.drawable.sandwiches,"Sandwiches",getResources().getString(R.string.b)));
//        exampleList.add(new ExampleItem(R.drawable.sauce,"Sauce",getResources().getString(R.string.di)));
//        exampleList.add(new ExampleItem(R.drawable.sausage,"Sausage",getResources().getString(R.string.di)));
//        exampleList.add(new ExampleItem(R.drawable.smoothie,"Smoothie",getResources().getString(R.string.dr)));
//        exampleList.add(new ExampleItem(R.drawable.spinach,"Spinach",getResources().getString(R.string.l)));
//        exampleList.add(new ExampleItem(R.drawable.watermelon,"Watermelon",getResources().getString(R.string.f)));
//        exampleList.add(new ExampleItem(R.drawable.yogurt,"Yogurt",getResources().getString(R.string.de)));


    }

    public void go(View view){
        //Log.i("upulie",eatenList.toString());

        Intent gointent=new Intent(this,CalorieResult.class);

        gointent.putExtra("myList",eatenList);
        startActivity(gointent);
    }
}
