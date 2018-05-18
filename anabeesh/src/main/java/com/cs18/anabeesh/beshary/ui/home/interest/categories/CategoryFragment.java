package com.cs18.anabeesh.beshary.ui.home.interest.categories;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.cs18.anabeesh.R;
import com.cs18.anabeesh.beshary.store.AuthRepo;
import com.cs18.anabeesh.beshary.store.model.user.UserCategories;
import com.rxmuhammadyoussef.core.util.PreferencesUtil;
import com.rxmuhammadyoussef.core.util.UiUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryFragment extends Fragment implements CategoryScreen{

    private CategoryPresenter presenter;
    private CategoriesAdapter categoriesAdapter;
    private UiUtil uiUtil;
    private Context mContext;
    private String userId;
    @BindView(R.id.rv_categories)
    RecyclerView categoryRecyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new CategoryPresenter(this);
        mContext  = getActivity().getApplicationContext();
        presenter.onCreate();
        userId = new AuthRepo(new PreferencesUtil(mContext)).getCurrentUser().getUserId();
        presenter.onCreate();
        presenter.loadCategoriesList(userId);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categories, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
    }

    @Override
    public void initializeComponents() {
        uiUtil = new UiUtil(mContext);
    }

    @Override
    public void toCategoriesAdapter(ArrayList<UserCategories> userCategories) {

        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        categoriesAdapter = new CategoriesAdapter(userCategories,presenter,mContext,userId);
        categoryRecyclerView.setAdapter(categoriesAdapter);
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        uiUtil.getErrorToast(errorMessage)
                .show();
    }

    @Override
    public void showLoadingAnimation() {

    }

    @Override
    public void hideLoadingAnimation() {

    }
}