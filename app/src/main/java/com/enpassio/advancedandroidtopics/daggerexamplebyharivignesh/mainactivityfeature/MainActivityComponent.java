package com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.mainactivityfeature;

import com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.RandomUserComponent;
import com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.adapter.RandomUserAdapter;
import com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.interfaces.RandomUsersApi;

import dagger.Component;

/**
 * Created by Abhishek Raj on 12/19/2018.
 */
@Component(modules = MainActivityModule.class, dependencies = RandomUserComponent.class)
@MainActivityScope
public interface MainActivityComponent {

    RandomUserAdapter getRandomUserAdapter();

    RandomUsersApi getRandomUserService();

}