package com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.mainactivityfeature;

import com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.DaggerExampleActivityByHariVignesh;
import com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.RandomUserComponent;

import dagger.Component;

/**
 * Created by Abhishek Raj on 12/19/2018.
 */
@Component(modules = MainActivityModule.class, dependencies = RandomUserComponent.class)
@MainActivityScope
public interface MainActivityComponent {

    void injectMainActivity(DaggerExampleActivityByHariVignesh daggerExampleActivityByHariVignesh);

}