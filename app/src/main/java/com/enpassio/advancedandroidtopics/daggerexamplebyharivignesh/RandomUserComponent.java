package com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh;

import com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.interfaces.RandomUsersApi;
import com.squareup.picasso.Picasso;

import dagger.Component;

@Component(modules = {RandomUsersModule.class, PicassoModule.class})
public interface RandomUserComponent {
    RandomUsersApi getRandomUserService();

    Picasso getPicasso();
}