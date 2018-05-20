package com.cs18.anabeesh.salem.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.cs18.anabeesh.R;
import com.cs18.anabeesh.salem.Others.GlideApp;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleDetailsActivity extends AppCompatActivity {
    @BindView(R.id.tv_article_name_detail)
    TextView articleNameDetail;
    @BindView(R.id.tv_expert_name_detail)
    TextView expertName;
    @BindView(R.id.tv_article_detail)
    TextView articleDetail;
    @BindView(R.id.iv_expert_img)
    ImageView expertImg;
    @BindView(R.id.iv_article_detail)
    ImageView articleImgDetail;
    @BindView(R.id.tb_article_detail)
    Toolbar articleDetailToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_details);
        ButterKnife.bind(this);
        AddToLayout();
        setSupportActionBar(articleDetailToolbar);
        getSupportActionBar().setTitle("تفاصيل المقال");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        articleDetailToolbar.setNavigationOnClickListener(view -> onBackPressed());
    }

    private void AddToLayout() {
        String articleName = getIntent().getStringExtra("Article_name");
        String articleDesc = getIntent().getStringExtra("Article_Desc");
        String expertname = getIntent().getStringExtra("Expert_Name");
        String articleImage = getIntent().getStringExtra("Article_img");
        GlideApp.with(this)
                .load(articleImage)
                .placeholder(R.drawable.greenland)
                .into(articleImgDetail);
        articleNameDetail.setText(articleName);
        expertName.setText(expertname);
        articleDetail.setText(articleDesc);
    }
}
