package com.cs18.anabeesh.salem.ui.writeArticle;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.Toast;

import com.cs18.anabeesh.R;
import com.rxmuhammadyoussef.core.util.PreferencesUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WriteActicleActivity extends AppCompatActivity implements WriteArticleScreen {
    @BindView(R.id.et_article_tittle)
    EditText ArticleTittle;
    @BindView(R.id.et_article_body)
    EditText ArticleBody;
    @BindView(R.id.fab_send_to)
    FloatingActionButton SendTo;
    @BindView(R.id.tb_write_articles)
    Toolbar toolbarWriteArticle;
    private ProgressDialog Loadingdialog;
    private WriteArticlePresenter writeArticlePresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_acticle);
        writeArticlePresenter = new WriteArticlePresenter(this,new PreferencesUtil(this));
        ButterKnife.bind(this);
        writeArticlePresenter.CreateUI();
    }

    @Override
    public void showErrorMessage(String errorMessage) {

        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccessMessage() {
        Toast.makeText(this, "شكرا لمشاركتك معنا ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setUpToolBarForWriteArticle() {
        setSupportActionBar(toolbarWriteArticle);
        getSupportActionBar().setTitle("كتابه مقال");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbarWriteArticle.setNavigationOnClickListener(view -> onBackPressed());
    }

    /*More Info about pick image from phone  please follow this link:
       *https://stackoverflow.com/questions/9107900/how-to-upload-image-from-gallery-in-android
        */
    @OnClick(R.id.fab_send_to)
    void SendTo() {
        if (writeArticlePresenter.CheckValidation(ArticleTittle, ArticleBody)) {
            writeArticlePresenter.SendTo(ArticleTittle.getText().toString(), ArticleBody.getText().toString());
        } else {

            Toast.makeText(this, " لا يمكن الارسال ", Toast.LENGTH_SHORT).show();
        }
    }
}


