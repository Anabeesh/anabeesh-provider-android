package com.cs18.anabeesh.beshary.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.cs18.anabeesh.R;
import com.cs18.anabeesh.beshary.store.AuthRepo;
import com.cs18.anabeesh.beshary.ui.home.interest.categories.CategoryFragment;
import com.cs18.anabeesh.beshary.ui.home.profile.UserProfile;
import com.cs18.anabeesh.beshary.ui.landingpage.LandingPageActivity;
import com.cs18.anabeesh.salem.ui.expertHome.ExpertHomeFragment;
import com.rxmuhammadyoussef.core.util.PreferencesUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        ExpertHomeFragment Home = new ExpertHomeFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.frg, Home).commit();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        /**
         used to open navigation drawer from right to left :-
         */
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        View headerView = navigationView.getHeaderView(0);
        TextView userProfile = headerView.findViewById(R.id.tv_profile);
        userProfile.setOnClickListener(view ->
                onMyProfileClicked());
    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.interest:
                switchFragment(new CategoryFragment());
                break;
            case R.id.home:
                switchFragment(new ExpertHomeFragment());
                break;
            default:
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void switchFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frg, fragment)
                .commit();
    }

    @OnClick(R.id.logout)
    void onLogoutClicked() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(R.string.logout_message)
                .setPositiveButton(R.string.yes, (dialogInterface, i) ->
                        toLandingPage())
                .setNegativeButton(R.string.no, (dialogInterface, i) -> {
                })
                .show();
    }

    void toLandingPage() {
        new AuthRepo(new PreferencesUtil(this)).deleteCurrentUser();
        startActivity(new Intent(this, LandingPageActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
        finish();
    }

    void onMyProfileClicked() {
        startActivity(new Intent(this, UserProfile.class));
    }
}