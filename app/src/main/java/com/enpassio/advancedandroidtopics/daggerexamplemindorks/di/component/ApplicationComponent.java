package com.enpassio.advancedandroidtopics.daggerexamplemindorks.di.component;

import android.app.Application;
import android.content.Context;

import com.enpassio.advancedandroidtopics.MainApplication;
import com.enpassio.advancedandroidtopics.daggerexamplemindorks.data.DataManager;
import com.enpassio.advancedandroidtopics.daggerexamplemindorks.data.DbHelper;
import com.enpassio.advancedandroidtopics.daggerexamplemindorks.data.SharedPrefsHelper;
import com.enpassio.advancedandroidtopics.daggerexamplemindorks.di.ApplicationContext;
import com.enpassio.advancedandroidtopics.daggerexamplemindorks.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MainApplication demoApplication);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();

    DbHelper getDbHelper();

}