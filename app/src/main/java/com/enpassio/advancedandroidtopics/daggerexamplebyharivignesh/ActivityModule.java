package com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh;

import android.app.Activity;
import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Abhishek Raj on 12/18/2018.
 */
@Module
public class ActivityModule {

    private final Context context;

    ActivityModule(Activity context) {
        this.context = context;
    }

    @Named("activity_context")
    @RandomUserApplicationScope
    @Provides
    public Context context() {
        return context;
    }
}
