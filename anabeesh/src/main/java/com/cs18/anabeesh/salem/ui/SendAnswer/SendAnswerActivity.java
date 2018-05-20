package com.cs18.anabeesh.salem.ui.SendAnswer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cs18.anabeesh.R;
import com.cs18.anabeesh.beshary.store.AuthRepo;
import com.cs18.anabeesh.salem.Adapters.AllAnswersAdapter;
import com.cs18.anabeesh.salem.Others.GlideApp;
import com.cs18.anabeesh.salem.model.AllAnswers;
import com.rxmuhammadyoussef.core.util.PreferencesUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SendAnswerActivity extends AppCompatActivity implements SendAnswerView {
    private final String QuestionId = "1";//getIntent().getStringExtra("QuestionId");
    @BindView(R.id.iv_user_post)
    ImageView posterUserImageActivity;
    @BindView(R.id.tv_poster_user_name)
    TextView posterUserNameActivity;
    @BindView(R.id.tv_poster_tittle)
    TextView postTittle;
    @BindView(R.id.tv_poster_detail)
    TextView postDetail;
    @BindView(R.id.rv_comments)
    RecyclerView commentsRecyclerView;
    @BindView(R.id.tb_send_answer)
    Toolbar sendAnswerToolbar;
    private SendAnswerPressnter sendAnswerPressnter;
    private AllAnswersAdapter answersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_answer);
        ButterKnife.bind(this);
        sendAnswerPressnter = new SendAnswerPressnter(this, new AuthRepo(new PreferencesUtil(this)));
        InitializeViews();
        sendAnswerPressnter.CreateUI();

    }

    //The Question Detail Views
    void InitializeViews() {
        String postUserName = getIntent().getStringExtra("poster_user_name");
        String PostTittle = getIntent().getStringExtra("post_tittle");
        String PostDesc = getIntent().getStringExtra("post_descr");
        String postUserImg = getIntent().getStringExtra("poster_user_img");

        GlideApp.with(this)
                .load(postUserImg)
                .placeholder(R.mipmap.ic_launcher_round)
                .into(posterUserImageActivity);
        posterUserNameActivity.setText(postUserName);
        postTittle.setText(PostTittle);
        postDetail.setText(PostDesc);
    }

    @Override
    public void setupToolBar() {

        setSupportActionBar(sendAnswerToolbar);
        if (sendAnswerToolbar != null) {
            getSupportActionBar().setTitle(R.string.question_details);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            sendAnswerToolbar.setNavigationOnClickListener(view -> onBackPressed());
        }
    }

    @Override
    public void setUpAnswerRecyclerView(List<AllAnswers> allAnswersList) {
        answersAdapter = new AllAnswersAdapter(allAnswersList, this);
        commentsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        commentsRecyclerView.setAdapter(answersAdapter);
    }

    @Override
    public void showResponseMsg(String Msg) {
        Toast.makeText(this, Msg, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.fab_send_comment)
    void sendComment() {
        sendAnswerPressnter.inisializeCutomDailog(this,QuestionId);
    }
}

