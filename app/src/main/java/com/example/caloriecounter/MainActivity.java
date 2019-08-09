package com.example.caloriecounter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ExampleItem> mExampleList;
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

        ArrayList<ExampleItem> exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.apple,"Apple",getResources().getString(R.string.f)));
        exampleList.add(new ExampleItem(R.drawable.avacado,"Avacado",getResources().getString(R.string.f)));
        exampleList.add(new ExampleItem(R.drawable.banana,"Banana",getResources().getString(R.string.f)));
        exampleList.add(new ExampleItem(R.drawable.bread,"Bread",getResources().getString(R.string.b)));
        exampleList.add(new ExampleItem(R.drawable.butter,"Butter",getResources().getString(R.string.b)));
        exampleList.add(new ExampleItem(R.drawable.carrot,"Carrot",getResources().getString(R.string.l)));
        exampleList.add(new ExampleItem(R.drawable.cheese,"Cheese",getResources().getString(R.string.s)));
        exampleList.add(new ExampleItem(R.drawable.chicken,"Chicken",getResources().getString(R.string.di)));
        exampleList.add(new ExampleItem(R.drawable.chocolate,"Chocolate",getResources().getString(R.string.s)));
        exampleList.add(new ExampleItem(R.drawable.curd,"Curd",getResources().getString(R.string.de)));
        exampleList.add(new ExampleItem(R.drawable.eggs,"Eggs",getResources().getString(R.string.b)));
        exampleList.add(new ExampleItem(R.drawable.frechfries,"French Fries",getResources().getString(R.string.s)));
        exampleList.add(new ExampleItem(R.drawable.grapes,"Grapes",getResources().getString(R.string.f)));
        exampleList.add(new ExampleItem(R.drawable.hamburger,"Hamburger",getResources().getString(R.string.b)));
        exampleList.add(new ExampleItem(R.drawable.hotdog,"HotDog",getResources().getString(R.string.b)));
        exampleList.add(new ExampleItem(R.drawable.icecream,"Ice cream",getResources().getString(R.string.de)));
        exampleList.add(new ExampleItem(R.drawable.juice,"Juice",getResources().getString(R.string.dr)));
        exampleList.add(new ExampleItem(R.drawable.mango,"Mango",getResources().getString(R.string.f)));
        exampleList.add(new ExampleItem(R.drawable.meat,"Meat",getResources().getString(R.string.di)));
        exampleList.add(new ExampleItem(R.drawable.milk,"Milk",getResources().getString(R.string.dr)));
        exampleList.add(new ExampleItem(R.drawable.oats,"Oats",getResources().getString(R.string.b)));
        exampleList.add(new ExampleItem(R.drawable.orange,"Orange",getResources().getString(R.string.f)));
        exampleList.add(new ExampleItem(R.drawable.pasta,"Pasta",getResources().getString(R.string.l)));
        exampleList.add(new ExampleItem(R.drawable.peanuts,"Peanuts",getResources().getString(R.string.s)));
        exampleList.add(new ExampleItem(R.drawable.pineapple,"Pineapple",getResources().getString(R.string.f)));
        exampleList.add(new ExampleItem(R.drawable.pizza,"Pizza",getResources().getString(R.string.l)));
        exampleList.add(new ExampleItem(R.drawable.pomengranate,"Pomengranate",getResources().getString(R.string.f)));
        exampleList.add(new ExampleItem(R.drawable.quinoa,"Quinoa",getResources().getString(R.string.l)));
        exampleList.add(new ExampleItem(R.drawable.rice,"Rice",getResources().getString(R.string.l)));
        exampleList.add(new ExampleItem(R.drawable.salad,"Salad",getResources().getString(R.string.b)));
        exampleList.add(new ExampleItem(R.drawable.sandwiches,"Sandwiches",getResources().getString(R.string.b)));
        exampleList.add(new ExampleItem(R.drawable.sauce,"Sauce",getResources().getString(R.string.di)));
        exampleList.add(new ExampleItem(R.drawable.sausage,"Sausage",getResources().getString(R.string.di)));
        exampleList.add(new ExampleItem(R.drawable.smoothie,"Smoothie",getResources().getString(R.string.dr)));
        exampleList.add(new ExampleItem(R.drawable.spinach,"Spinach",getResources().getString(R.string.l)));
        exampleList.add(new ExampleItem(R.drawable.watermelon,"Watermelon",getResources().getString(R.string.f)));
        exampleList.add(new ExampleItem(R.drawable.yogurt,"Yogurt",getResources().getString(R.string.de)));




        //initialize RecyclerView
        mRecyclerView = findViewById(R.id.recyclerView);
        //if RecyclerView won't change in size
        mRecyclerView.setHasFixedSize(true);
        //assign LayoutManager
        mLayoutManager = new LinearLayoutManager(this);
        //assigning Adapter
        mAdapter= new ExampleAdapter(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void createExampleList(){
        mExampleList=new ArrayList<>();
    }

    public void buildRecyclerView(){
        mRecyclerView=findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager=new LinearLayoutManager(this);
        mAdapter=new ExampleAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //change this to add calories to the counter rather than displaying "clicked"
                mExampleList.get(position).changeText1("Clicked");
                mAdapter.notifyItemChanged(position);
            }
        });
    }
}
