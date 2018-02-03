package com.cs18.anabeesh.ui.interestes;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cs18.anabeesh.Adapters.DataItem;
import com.cs18.anabeesh.Adapters.IntrastesAdapter;
import com.cs18.anabeesh.Adapters.images;
import com.cs18.anabeesh.schedulers.ComputationalThread;
import com.cs18.anabeesh.schedulers.ThreadSchedulers;
import com.cs18.anabeesh.store.InterestesPageRebo;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 TODO: Add class header
 */

public class interestesPresenter {
    private static ArrayList<DataItem> data;
    private final ThreadSchedulers threadSchedulers;
    private final InterestesPageRebo interestesPageRebo;
    private IntrastesAdapter intrastesAdapter;

    @Inject
    interestesPresenter(@ComputationalThread ThreadSchedulers threadSchedulers, InterestesPageRebo interestesPageRebo) {
        this.threadSchedulers = threadSchedulers;
        this.interestesPageRebo = interestesPageRebo;
    }

    void BulidRecyclerView(Context context, RecyclerView recyclerView) {

        recyclerView.setLayoutManager(new GridLayoutManager(context, 4));
        //Full the  recyclerview With Data  " Images"
        data = new ArrayList<>();
        for (int i = 0; i < images.image.length; i++) {
            data.add(new DataItem(

                    images.image[i]

            ));
        }
        intrastesAdapter = new IntrastesAdapter(context, data);
        recyclerView.setAdapter(intrastesAdapter);
        intrastesAdapter.notifyDataSetChanged();
    }

    /*public void getselecteditem(long id, int Selected) {
        if (Selected >= 3) {
            interestesPageRebo.MakeApicall();
        } else {

        }
    }*/
}
