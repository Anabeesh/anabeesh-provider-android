package com.cs18.anabeesh.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.cs18.anabeesh.R;
import com.cs18.anabeesh.di.activity.ForActivity;
import com.cs18.anabeesh.ui.interestes.interestesPresenter;

import java.util.ArrayList;

/**
 TODO: Add class header
 */

public class IntrastesAdapter extends RecyclerView.Adapter<IntrastesAdapter.MyViewHolder> {
    private final ArrayList<DataItem> items;
    interestesPresenter presenter;
    Context mContect;
    private int itemClaickableCounter = 0;
    private boolean positionSelected = false;

    public IntrastesAdapter(@ForActivity Context mContect, ArrayList<DataItem> items) {
        this.mContect = mContect;
        this.items = items;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mV = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.intreastes_images, parent, false);
        return new MyViewHolder(mV);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DataItem ImageItem = items.get(position);
        ImageView image = holder.IntrastesImages;
        image.setImageResource(items.get(position).getImg());
        holder.view.setBackgroundColor(ImageItem.isSelected() ? Color.CYAN : Color.WHITE);
        holder.IntrastesImages.setOnClickListener((View view) -> {
            ImageItem.setSelected(!ImageItem.isSelected());
            if (ImageItem.isSelected()) {
                if (position == 3 && !positionSelected) {//Add Sub catagroies  to List
                    additem(ImageItem);
                    positionSelected = true;// make  this  postion didn't add more  items
                }
                holder.view.setBackgroundColor(Color.CYAN);
                itemClaickableCounter++;
                //  presenter.getselecteditem(getItemId(position), itemClaickableCounter);
                Toast.makeText(mContect, "Selected " + itemClaickableCounter, Toast.LENGTH_SHORT).show();
            } else {

                holder.view.setBackgroundColor(Color.WHITE);
            }
        });
        // presenter.getselecteditem(getItemId(position), itemClaickableCounter);
    }

    //Add new item to recyclerView
    private void additem(DataItem image) {

        items.add(image);
        items.add(image);
        items.add(image);
        notifyItemInserted(items.size() - 1);
    }

    @Override

    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        View view;
        ImageView IntrastesImages;

        public MyViewHolder(View itemView) {

            super(itemView);
            view = itemView;
            IntrastesImages = itemView.findViewById(R.id.intraestes_Images_id);
        }
    }
}
