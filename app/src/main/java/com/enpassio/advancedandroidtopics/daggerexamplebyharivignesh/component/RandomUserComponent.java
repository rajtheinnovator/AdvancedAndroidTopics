package com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.component;

import com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.interfaces.RandomUserApplicationScope;
import com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.interfaces.RandomUsersApi;
import com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.module.PicassoModule;
import com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.module.RandomUsersModule;
import com.squareup.picasso.Picasso;

import dagger.Component;

@RandomUserApplicationScope
@Component(modules = {RandomUsersModule.class, PicassoModule.class})
public interface RandomUserComponent {
    RandomUsersApi getRandomUserService();

    Picasso getPicasso();
}