package com.enpassio.advancedandroidtopics.daggerexamplemindorks.di.component;

import com.enpassio.advancedandroidtopics.daggerexamplemindorks.di.PerActivity;
import com.enpassio.advancedandroidtopics.daggerexamplemindorks.di.module.ActivityModule;
import com.enpassio.advancedandroidtopics.daggerexamplemindorks.view.DaggerExampleMindorks;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(DaggerExampleMindorks daggerExampleMindorks);

}