package com.cs18.anabeesh.muhammad.di.activity;

import com.cs18.anabeesh.muhammad.ui.home.HomeActivity;
import com.cs18.anabeesh.muhammad.ui.landingpage.LandingPageActivity;
import com.cs18.anabeesh.muhammad.ui.login.LoginActivity;
import com.cs18.anabeesh.muhammad.ui.register.RegisterActivity;
import com.cs18.anabeesh.salem.ui.interestes.InterestsActivity;

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

<<<<<<< HEAD
    void inject(HomeActivity homeActivity);

    void inject(InterestesActivity interestesActivity);
=======
    void inject(InterestsActivity interestesActivity);
>>>>>>> f9a4717... S
}
