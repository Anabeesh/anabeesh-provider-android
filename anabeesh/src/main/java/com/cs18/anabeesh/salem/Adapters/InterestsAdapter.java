package com.cs18.anabeesh.salem.Adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cs18.anabeesh.R;
import com.cs18.anabeesh.salem.GlideApp;
import com.cs18.anabeesh.salem.model.MainInteresting;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 TODO: Add class header
 */

public class InterestsAdapter extends RecyclerView.Adapter<InterestsAdapter.MyViewHolder> {

    private final List<MainInteresting> currentInterestesList;
    private final int itemClaickableCounter = 0;
    private final boolean positionSelected = false;

    public InterestsAdapter() {
        currentInterestesList = new ArrayList<>();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mV = LayoutInflater.from(parent.getContext()).inflate(R.layout.intreastes_images, parent, false);
        return new MyViewHolder(mV);
    }

    @Override//
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(currentInterestesList.get(position));
    }

    @Override

    public int getItemCount() {
        return currentInterestesList.size();
    }

    public void update(List<MainInteresting> newInterestsList) {//if list Empty
        currentInterestesList.clear();
        currentInterestesList.addAll(newInterestsList);
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.intraestes_Images_id)
        ImageView IntrastesImages;
        @BindView(R.id.CatagroyName_id)
        TextView CatarogisTextView;
        private MainInteresting mainInteresting;

        MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(MainInteresting mainInteresting) {
            this.mainInteresting = mainInteresting;
            GlideApp.with(itemView)
                    .load(mainInteresting.getImageUrl())
                    .centerCrop()
                    .placeholder(R.mipmap.ic_launcher)
                    .into(IntrastesImages);
            CatarogisTextView.setText(mainInteresting.getName());
            IntrastesImages.setBackgroundColor(mainInteresting.isSelected() ? Color.CYAN : Color.WHITE);
        }

        @OnClick(R.id.intraestes_Images_id)
        void onImageClick() {
            IntrastesImages.setSelected(!mainInteresting.isSelected());
            if (mainInteresting.isSelected()) {
                //TODO highlight and open sub categories
            } else {
                IntrastesImages.setBackgroundColor(Color.WHITE);
            }
        }
    }
}
