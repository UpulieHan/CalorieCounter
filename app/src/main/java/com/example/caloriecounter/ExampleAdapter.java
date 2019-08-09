package com.example.caloriecounter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    //creating an ArrayList to be passed below
    private ArrayList<ExampleItem> mExampleList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        //which item we clicked
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }

    //Adapter needs a ViewHolder(an inner class)
    public static class ExampleViewHolder extends RecyclerView.ViewHolder{


        //variables for the xml layout components
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;


        public ExampleViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            //adding the components to the view
            mImageView=itemView.findViewById(R.id.imageview1);
            mTextView1=itemView.findViewById(R.id.textview1);
            mTextView2=itemView.findViewById(R.id.textview2);

            //position of the clicked item is passed
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }


    //passing data from ArrayList to Adapter
    public ExampleAdapter(ArrayList<ExampleItem> exampleList){
        //using the above created ArrayList
        mExampleList=exampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //to pass layouts to adapter
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item,parent,false);
        ExampleViewHolder evh = new ExampleViewHolder(v,mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {

        //passing values to the components(position let's us know which item it is position could be 0,1,2,3,...)
        //if it's item to get data from ArrayList's 2nd item
        ExampleItem currentItem = mExampleList.get(position);

        holder.mImageView.setImageResource(currentItem.getmImageResource());
        holder.mTextView1.setText(currentItem.getmText1());
        holder.mTextView2.setText(currentItem.getmText2());

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
