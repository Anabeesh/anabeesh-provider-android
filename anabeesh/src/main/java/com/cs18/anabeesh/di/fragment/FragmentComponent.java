package com.cs18.anabeesh.di.fragment;

import com.cs18.anabeesh.ui.register.EmailPasswordFragment;

import dagger.Subcomponent;

/**
 This interface is used by dagger to generate the code that defines the connection between the provider of objects
 (i.e. {@link FragmentModule}), and the object which expresses a dependency.
 */

@FragmentScope
@Subcomponent(
        modules = {FragmentModule.class}
)
public interface FragmentComponent {
    void inject(EmailPasswordFragment emailPasswordFragment);
}
