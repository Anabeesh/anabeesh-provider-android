package com.cs18.anabeesh.salem.ui.expertHome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cs18.anabeesh.R;

public class Test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ExpertHomeFragment Home = new ExpertHomeFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_id, Home).commit();
    }
}
