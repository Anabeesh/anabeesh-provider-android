package com.cs18.anabeesh.beshary.ui.register;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cs18.anabeesh.R;

public class FirstAndLastNameFragment extends Fragment {

    public FirstAndLastNameFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fr_first_and_last_name, container, false);
    }
}
