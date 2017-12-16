package com.cs18.anabeesh.ui.landingpage.core

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import butterknife.ButterKnife
import butterknife.OnClick
import com.cs18.anabeesh.R
import com.cs18.anabeesh.application.AnabeeshApplication
import com.cs18.anabeesh.ui.landingpage.di.LandingPageModule
import com.cs18.anabeesh.ui.landingpage.di.LandingPageScope
import com.cs18.anabeesh.ui.login.core.LoginActivity
import com.cs18.anabeesh.ui.register.core.RegisterActivity

@LandingPageScope
class LandingPageActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)
        AnabeeshApplication.getComponent(this)
                .plus(LandingPageModule(this))
                .inject(this)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.btn_facebook)
    fun continueWithFacebook() {

    }

    @OnClick(R.id.btn_google_plus)
    fun continueWithGooglePlus() {

    }

    @OnClick(R.id.btn_sign_up)
    fun signUpByEmail() {
        startActivity(Intent(this, RegisterActivity::class.java))
    }

    @OnClick(R.id.btn_sign_in)
    fun loginByEmail() {
        startActivity(Intent(this, LoginActivity::class.java))
    }
}
