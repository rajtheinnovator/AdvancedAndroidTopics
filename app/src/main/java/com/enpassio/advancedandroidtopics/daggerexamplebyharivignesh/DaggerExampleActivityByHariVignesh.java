package com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.enpassio.advancedandroidtopics.MainApplication;
import com.enpassio.advancedandroidtopics.R;
import com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.adapter.RandomUserAdapter;
import com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.component.RandomUserComponent;
import com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.interfaces.RandomUsersApi;
import com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.mainactivityfeature.DaggerMainActivityComponent;
import com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.mainactivityfeature.MainActivityComponent;
import com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.mainactivityfeature.MainActivityModule;
import com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.model.RandomUsers;
import com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.module.ContextModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.io.File;

import javax.inject.Inject;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

////referenced from: https://medium.com/@harivigneshjayapalan/dagger-2-for-android-beginners-introduction-be6580cb3edb
public class DaggerExampleActivityByHariVignesh extends AppCompatActivity {

    Retrofit retrofit;
    RecyclerView recyclerView;

    Context context;
    Picasso picasso;

    @Inject
    RandomUsersApi randomUsersApi;

    @Inject
    RandomUserAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_example_by_hari_vignesh);
        initViews();
        context = this;
        //beforeDagger2();
        //afterDagger();
        afterActivityLevelComponent();
        populateUsers();

    }

    private void afterActivityLevelComponent() {
        MainActivityComponent mainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule(this))
                .randomUserComponent(MainApplication.get(this).getRandomUserApplicationComponent())
                .build();
        mainActivityComponent.injectMainActivity(this);
    }

    public void afterDagger() {
        RandomUserComponent daggerRandomUserComponent = DaggerRandomUserComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
        picasso = daggerRandomUserComponent.getPicasso();
        randomUsersApi = daggerRandomUserComponent.getRandomUserService();

    }

    private void beforeDagger2() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        Timber.plant(new Timber.DebugTree());

        File cacheFile = new File(context.getCacheDir(), "HttpCache");
        cacheFile.mkdirs();

        Cache cache = new Cache(cacheFile, 10 * 1000 * 1000); //10 MB

        HttpLoggingInterceptor httpLoggingInterceptor = new
                HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(@NonNull String message) {
                Timber.i(message);
            }
        });

        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .cache(cache)
                .addInterceptor(httpLoggingInterceptor)
                .build();

        OkHttp3Downloader okHttpDownloader = new OkHttp3Downloader(okHttpClient);

        picasso = new Picasso.Builder(context).downloader(okHttpDownloader).build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void populateUsers() {
        Call<RandomUsers> randomUsersCall = getRandomUserService().getRandomUsers(10);
        randomUsersCall.enqueue(new Callback<RandomUsers>() {
            @Override
            public void onResponse(Call<RandomUsers> call, @NonNull Response<RandomUsers> response) {
                if (response.isSuccessful()) {
                    mAdapter = new RandomUserAdapter(DaggerExampleActivityByHariVignesh.this, picasso);
                    mAdapter.setItems(response.body().getResults());
                    recyclerView.setAdapter(mAdapter);
                }
            }

            @Override
            public void onFailure(Call<RandomUsers> call, Throwable t) {
                Timber.i(t.getMessage());
            }
        });
    }

    public RandomUsersApi getRandomUserService() {
        return randomUsersApi;
    }


}