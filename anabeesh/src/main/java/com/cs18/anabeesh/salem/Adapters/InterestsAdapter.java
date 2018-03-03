package com.cs18.anabeesh.salem.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cs18.anabeesh.GlideApp;
import com.cs18.anabeesh.R;
import com.cs18.anabeesh.salem.model.InteresetsApiResponse;
import com.cs18.anabeesh.salem.model.MainInterests;
import com.cs18.anabeesh.salem.model.SubInterests;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InterestsAdapter extends RecyclerView.Adapter<InterestsAdapter.MyViewHolder> {

    private final List<SubInterests> SubList = new ArrayList<>();
    private InteresetsApiResponse apiResponse = InteresetsApiResponse.createDefault();
    private List<MainInterests> currentList = new ArrayList<>();
    private boolean positionSelected = false;

    public InterestsAdapter() {
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mV = LayoutInflater.from(parent.getContext()).inflate(R.layout.intreastes_images, parent, false);
        return new MyViewHolder(mV);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(currentList.get(position));
    }

    @Override
    public int getItemCount() {
        return currentList.size();
    }

    public void update(InteresetsApiResponse apiResponse) {
        this.apiResponse = apiResponse;
        if (!positionSelected) {
            currentList = apiResponse.getMainInterests();
        }
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.interests_Images_id)
        ImageView IntrastesImages;
        @BindView(R.id.CategoryName_id)
        TextView CatarogisTextView;
        @BindView(R.id.marker_IV_id)
        ImageView MarkCatagroy;
        private MainInterests mainInterests;
        private SubInterests subInterests;

        //TODO IF worked with all resposnse Remove On click Listener and  check Model Package For Edit Best of lack A5ok salem

        /**
         MarkCatagroy: to make  ( 3lamt el sa7 ) on Image
         positionSelected : to know if  this  item was  selected or  not
         **/
        MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(MainInterests mainInterests) {
            mainInterests = mainInterests;
            GlideApp.with(itemView)
                    .load(mainInterests.getImageUrl())
                    .placeholder(R.mipmap.ic_launcher_round)
                    .into(IntrastesImages);
            CatarogisTextView.setText(mainInterests.getName());
            MarkCatagroy.setImageResource(R.drawable.ic_done_register);
            MarkCatagroy.setVisibility(View.INVISIBLE);
            MainInterests finalMainInterests = mainInterests;
            IntrastesImages.setOnClickListener((View v) -> {
                if (!positionSelected) {
                    MarkCatagroy.setVisibility(View.VISIBLE);
                    positionSelected = true;
                    currentList.add(finalMainInterests);
                    notifyDataSetChanged();
                } else {
                    MarkCatagroy.setVisibility(View.INVISIBLE);
                    positionSelected = false;
                    currentList.remove(getAdapterPosition());
                    notifyDataSetChanged();
                }
            });
        }
    }
}
