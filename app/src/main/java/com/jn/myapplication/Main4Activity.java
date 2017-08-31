package com.jn.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.view.Gravity;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Slide slideTransition = new Slide(Gravity.LEFT);
        slideTransition.setDuration(500);
        Fragment1 fragment1 = Fragment1.newInstance();
        fragment1.setReenterTransition(slideTransition);
        fragment1.setExitTransition(slideTransition);
        fragment1.setSharedElementEnterTransition(new ChangeBounds());
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment1)
                .commit();
    }
}
