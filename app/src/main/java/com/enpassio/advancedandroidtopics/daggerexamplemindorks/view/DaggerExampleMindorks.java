package com.enpassio.advancedandroidtopics.daggerexamplemindorks.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.enpassio.advancedandroidtopics.MainApplication;
import com.enpassio.advancedandroidtopics.R;
import com.enpassio.advancedandroidtopics.daggerexamplemindorks.data.DataManager;
import com.enpassio.advancedandroidtopics.daggerexamplemindorks.data.model.User;
import com.enpassio.advancedandroidtopics.daggerexamplemindorks.di.component.ActivityComponent;
import com.enpassio.advancedandroidtopics.daggerexamplemindorks.di.component.DaggerActivityComponent;
import com.enpassio.advancedandroidtopics.daggerexamplemindorks.di.module.ActivityModule;

import javax.inject.Inject;

//activity_dagger_example_mindorks
public class DaggerExampleMindorks extends AppCompatActivity {

    @Inject
    DataManager mDataManager;

    private ActivityComponent activityComponent;

    private TextView mTvUserInfo;
    private TextView mTvAccessToken;

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(MainApplication.get(this).getComponent())
                    .build();
        }
        return activityComponent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_example_mindorks);

        getActivityComponent().inject(this);

        mTvUserInfo = findViewById(R.id.tv_user_info);
        mTvAccessToken = findViewById(R.id.tv_access_token);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        createUser();
        getUser();
        mDataManager.saveAccessToken("FSGHFHG534I54HTVYFY4YTO6");

        String token = mDataManager.getAccessToken();
        if (token != null) {
            mTvAccessToken.setText(token);
        }
    }

    private void createUser() {
        try {
            mDataManager.createUser(new User("Abhi", "Bangalore, India"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getUser() {
        try {
            User user = mDataManager.getUser(1L);
            mTvUserInfo.setText(user.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

