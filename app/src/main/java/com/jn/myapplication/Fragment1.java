package com.jn.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {


    private ImageView mImageView;

    public Fragment1() {
        // Required empty public constructor
    }

    public static Fragment1 newInstance() {

        Bundle args = new Bundle();

        Fragment1 fragment = new Fragment1();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        mImageView = (ImageView) view.findViewById(R.id.imageView3);
        Button button = (Button) view.findViewById(R.id.btn_click);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNextFragment();
            }
        });
        return view;
    }

    private void addNextFragment() {
        Fragment2 fragment2 = Fragment2.newInstance();

        Slide slideTransition = new Slide(Gravity.RIGHT);
        slideTransition.setDuration(500);

        ChangeBounds changeBoundsTransition = new ChangeBounds();
        changeBoundsTransition.setDuration(500);

        fragment2.setEnterTransition(slideTransition);
        fragment2.setAllowEnterTransitionOverlap(false);
        fragment2.setAllowReturnTransitionOverlap(false);
        fragment2.setSharedElementEnterTransition(changeBoundsTransition);

        getFragmentManager().beginTransaction().replace(R.id.fragment, fragment2)
                .addToBackStack(null)
                .addSharedElement(mImageView,"image1")
                .commit();
    }
}
