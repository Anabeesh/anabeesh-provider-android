package com.cs18.anabeesh.muhammad.di.activity;

import com.cs18.anabeesh.muhammad.ui.home.HomeActivity;
import com.cs18.anabeesh.muhammad.ui.landingpage.LandingPageActivity;
import com.cs18.anabeesh.muhammad.ui.login.LoginActivity;
import com.cs18.anabeesh.muhammad.ui.register.RegisterActivity;

import dagger.Subcomponent;

/**
 This interface is used by dagger to generate the code that defines the connection between the provider of objects
 (i.e. {@link ActivityModule}), and the object which expresses a dependency.
 */

@ActivityScope
@Subcomponent(
        modules = {ActivityModule.class}
)
public interface ActivityComponent {

    void inject(LandingPageActivity landingPageActivity);

    void inject(LoginActivity loginActivity);

    void inject(RegisterActivity registerActivity);

    void inject(HomeActivity homeActivity);
}
