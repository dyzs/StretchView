package com.dyzs.card.stretchview;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    StretchView mStretchView;
    View mViewCoverPart;
    RelativeLayout mViewPartPic;
    Toolbar mToolbarLayout;
    StretchViewChildViewPager mViewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStretchView = findViewById(R.id.stretchView);
        mViewCoverPart = findViewById(R.id.view_cover);
        mViewPartPic = findViewById(R.id.part_pic);
        mToolbarLayout = findViewById(R.id.toolbar);
        mViewPager = findViewById(R.id.view_pager);

        mStretchView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mStretchView.invokeCoverView(mViewCoverPart);
                mStretchView.invokePartPicView(mViewPartPic, mToolbarLayout.getMeasuredHeight());
            }
        }, 50);

        layouts = new int[]{
                R.layout.welcome_slide1,
                R.layout.welcome_slide2,
                R.layout.welcome_slide3
        };

        myViewPagerAdapter = new MyViewPagerAdapter();
        mViewPager.setAdapter(myViewPagerAdapter);
    }

    private int[] layouts;
    public class MyViewPagerAdapter extends PagerAdapter {

        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}
