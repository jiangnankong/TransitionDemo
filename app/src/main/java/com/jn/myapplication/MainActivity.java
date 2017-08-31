package com.jn.myapplication;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    private ImageView mImageView1;
    private ImageView mImageView2;
    private ImageView mImageView3;
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private ViewGroup mGroup;
    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGroup = (ViewGroup) findViewById(R.id.constraintLayout1);
        mImageView1 = (ImageView) findViewById(R.id.imageView1);
        mImageView2 = (ImageView) findViewById(R.id.imageView2);
        mImageView3 = (ImageView) findViewById(R.id.imageView3);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        Fade fade = new Fade();//渐隐
        fade.setDuration(500);
        Slide slide = new Slide(Gravity.END);//右边平移
        slide.setDuration(500);
        Explode explode = new Explode();//展开回收
        explode.setDuration(500);
        getWindow().setReenterTransition(slide);
        getWindow().setExitTransition(explode);
        getWindow().setAllowEnterTransitionOverlap(false);
        getWindow().setAllowReturnTransitionOverlap(false);

//        getWindow().setEnterTransition(fade);
//        getWindow().setReturnTransition(slide);
    }


    public void button(View view) {
        transitionToActivity(Main2Activity.class);
    }

    public void button2(View view) {
        transitionToActivity(Main3Activity.class, mImageView1, mImageView2, text1, text2);
    }

    public void button3(View view) {
        startActivity(Main4Activity.class, mImageView1);
    }

    //平移过渡动画
    private void transitionToActivity(Class target) {
        Intent i = new Intent(this, target);
        ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(this);
        startActivity(i, transitionActivityOptions.toBundle());
    }

    //share elements 单个元素
    private void startActivity(Class target, ImageView imageView1) {
        Intent i = new Intent(this, target);
        ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, imageView1, "image1");
        startActivity(i, transitionActivityOptions.toBundle());
    }

    //share elements 多个元素
    private void transitionToActivity(Class target, ImageView imageView, ImageView imageView2, TextView text1, TextView text2) {
        Pair[] pairs = new Pair[]{Pair.create(imageView, "image1"), Pair.create(imageView2, "image2"),
                Pair.create(text1, "text1"), Pair.create(text2, "text2")};
        Intent i = new Intent(this, target);
        ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, pairs);
        startActivity(i, transitionActivityOptions.toBundle());
    }
}

