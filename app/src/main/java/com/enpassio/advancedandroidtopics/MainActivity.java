package com.enpassio.advancedandroidtopics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.enpassio.advancedandroidtopics.daggerexamplebyharivignesh.DaggerExampleActivityByHariVignesh;
import com.enpassio.advancedandroidtopics.daggerexamplemindorks.view.DaggerExampleMindorks;
import com.enpassio.advancedandroidtopics.mvpwithdaggermindorks.ui.MvpWithDaggerActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mvpWithDaggerMindorkd = findViewById(R.id.mvp_with_dagger_mindorks);
        Button daggerExampleByHariVignesh = findViewById(R.id.dagger_example_hari_vignesh);
        Button daggerExampleMindorks = findViewById(R.id.dagger_example_mindorks);
        //set click listeners on buttons
        mvpWithDaggerMindorkd.setOnClickListener(this);
        daggerExampleByHariVignesh.setOnClickListener(this);
        daggerExampleMindorks.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mvp_with_dagger_mindorks:
                startActivity(new Intent(MainActivity.this, MvpWithDaggerActivity.class));
                break;
            case R.id.dagger_example_hari_vignesh:
                //referenced from: https://medium.com/@harivigneshjayapalan/dagger-2-for-android-beginners-introduction-be6580cb3edb
                startActivity(new Intent(MainActivity.this, DaggerExampleActivityByHariVignesh.class));
                break;
            case R.id.dagger_example_mindorks:
                startActivity(new Intent(MainActivity.this, DaggerExampleMindorks.class));
                break;
        }
    }
}
