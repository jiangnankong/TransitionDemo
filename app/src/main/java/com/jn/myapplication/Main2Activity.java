package com.jn.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Slide;
import android.view.Gravity;

public class Main2Activity extends AppCompatActivity {
    private String TAG = this.getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Explode explode = new Explode();
        explode.setDuration(500);
        Slide slide = new Slide();
        slide.setDuration(500);
        slide.setSlideEdge(Gravity.START);
        getWindow().setEnterTransition(slide);
        getWindow().setReturnTransition(explode);

    }
}
