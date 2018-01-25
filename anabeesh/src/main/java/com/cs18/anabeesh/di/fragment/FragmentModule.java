package com.cs18.anabeesh.di.fragment;

import android.app.Fragment;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 This class is responsible for providing the requested objects to {@link FragmentScope} annotated classes
 */

@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @FragmentScope
    @Provides
    Fragment provideFragment() {
        return fragment;
    }

    @FragmentScope
    @Provides
    @ForFragment
    Context provideFragmentContext(){
        return fragment.getActivity();
    }

}
