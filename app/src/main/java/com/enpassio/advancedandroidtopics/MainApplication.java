package com.enpassio.advancedandroidtopics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.component.DaggerRandomUserComponent;
import com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.component.RandomUserComponent;
import com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.module.ContextModule;
import com.enpassio.advancedandroidtopics.daggerexamplemindorks.data.DataManager;
import com.enpassio.advancedandroidtopics.daggerexamplemindorks.di.component.ApplicationComponent;
import com.enpassio.advancedandroidtopics.daggerexamplemindorks.di.component.DaggerApplicationComponent;
import com.enpassio.advancedandroidtopics.daggerexamplemindorks.di.module.ApplicationModule;

import javax.inject.Inject;

import timber.log.Timber;

public class MainApplication extends Application {

    protected ApplicationComponent applicationComponent;

    /*
     * Handle parts of HariVignesh example
     * */
    //add application name in Manifest file
    private RandomUserComponent randomUserApplicationComponent;

    public static MainApplication get(Activity activity) {
        return (MainApplication) activity.getApplication();
    }


    @Inject
    DataManager dataManager;

    public static MainApplication get(Context context) {
        return (MainApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);

        //for hari vignesh sample
        Timber.plant(new Timber.DebugTree());

        randomUserApplicationComponent = DaggerRandomUserComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }

    public RandomUserComponent getRandomUserApplicationComponent() {
        return randomUserApplicationComponent;
    }
}