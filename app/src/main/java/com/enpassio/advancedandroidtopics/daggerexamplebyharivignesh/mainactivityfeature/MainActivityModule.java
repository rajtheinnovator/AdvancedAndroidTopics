package com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.mainactivityfeature;

import com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.DaggerExampleActivityByHariVignesh;
import com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.adapter.RandomUserAdapter;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Abhishek Raj on 12/19/2018.
 */
@Module
public class MainActivityModule {

    private final DaggerExampleActivityByHariVignesh daggerExampleActivityByHariVignesh;

    public MainActivityModule(DaggerExampleActivityByHariVignesh activity) {
        this.daggerExampleActivityByHariVignesh = activity;
    }

    @Provides
    @MainActivityScope
    public RandomUserAdapter randomUserAdapter(Picasso picasso) {
        return new RandomUserAdapter(daggerExampleActivityByHariVignesh, picasso);
    }
}
