package com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.module;

import android.content.Context;

import com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.interfaces.ApplicationContext;
import com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.interfaces.RandomUserApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @ApplicationContext
    @RandomUserApplicationScope
    @Provides
    public Context context() {
        return context.getApplicationContext();
    }
}