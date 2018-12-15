package com.enpassio.advancedandroidtopics;

import android.app.Application;
import android.content.Context;

import com.enpassio.advancedandroidtopics.daggerexamplemindorks.data.DataManager;
import com.enpassio.advancedandroidtopics.daggerexamplemindorks.di.component.ApplicationComponent;
import com.enpassio.advancedandroidtopics.daggerexamplemindorks.di.component.DaggerApplicationComponent;
import com.enpassio.advancedandroidtopics.daggerexamplemindorks.di.module.ApplicationModule;

import javax.inject.Inject;

public class MainApplication extends Application {

    protected ApplicationComponent applicationComponent;

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
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }
}