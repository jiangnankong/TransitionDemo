package com.jn.myapplication;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Main3Activity extends AppCompatActivity {

    private ImageView mImageView1;
    private ImageView mImageView2;
    private boolean sizeChanged;
    private int savedWidth;
    private boolean positionChanged;
    private ViewGroup mLayout;
    private Interpolator mInterpolator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mLayout = (ViewGroup) findViewById(R.id.constraintLayout1);
        mImageView1 = (ImageView) findViewById(R.id.imageView1);
        mImageView2 = (ImageView) findViewById(R.id.imageView2);

        Fade fade = new Fade();
        fade.setDuration(500);
        Slide slide = new Slide(Gravity.END);
        slide.setDuration(500);
        getWindow().setReturnTransition(fade);
        getWindow().setEnterTransition(slide);

    }

    public void button1(View view) {

        TransitionManager.beginDelayedTransition(mLayout);

        ViewGroup.LayoutParams params = mImageView1.getLayoutParams();

        if (sizeChanged) {
            params.width = savedWidth;
            params.height = savedWidth;
        } else {
            savedWidth = params.width;
            params.width = 500;
            params.height = 500;
        }
        sizeChanged = !sizeChanged;
        mImageView1.setLayoutParams(params);
    }

    public void button2(View view) {
        TransitionManager.beginDelayedTransition(mLayout);

        ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams) mImageView1.getLayoutParams();
        if (positionChanged) {
            lp.horizontalBias = 0.1f;
        } else {
            lp.horizontalBias = 0.5f;
        }
        positionChanged = !positionChanged;
        mImageView1.setLayoutParams(lp);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.out.println("按下了back键   onBackPressed()");
        finishAfterTransition();
    }
}
