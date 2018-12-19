package com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh;

import android.content.Context;

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