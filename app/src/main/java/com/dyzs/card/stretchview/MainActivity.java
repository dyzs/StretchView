package com.dyzs.card.stretchview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    StretchView mStretchView;
    View mViewCoverPart;
    FrameLayout mViewPartPic;
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

    private void initRecycleView(View view){
        final String[] array=new String[100];
        for(int i=0;i<100;i++){
            array[i]="test i+"+i;
        }
        RecyclerView rv=view.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new Adapter<DemoViewHolder>() {
            @NonNull
            @Override
            public DemoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                return new DemoViewHolder(new TextView(MainActivity.this));
            }

            @Override
            public void onBindViewHolder(@NonNull DemoViewHolder viewHolder, int i) {
                viewHolder.mText.setText(array[i]);
            }

            @Override
            public int getItemCount() {
                return array.length;
            }

        });
    }
    class DemoViewHolder extends RecyclerView.ViewHolder{

        public TextView mText;

        public DemoViewHolder(TextView itemView) {
            super(itemView);
            mText = itemView;
        }
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
            if(position==0){
                initRecycleView(view);
            }
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
