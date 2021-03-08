package com.pinnoocle.royalstarshop.home.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;

import com.github.chrisbanes.photoview.PhotoView;
import com.pinnoocle.royalstarshop.R;


import java.util.List;

public class TaskBigImgActivity extends AppCompatActivity {
    ViewPager viewPager;
    private int position;
    private List<String> paths;
    private PhotoView icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_big_img);
        viewPager = findViewById(R.id.big_img_vp);
        Intent intent = getIntent();
        position = intent.getIntExtra("position", 0);
        paths = intent.getStringArrayListExtra("paths");
        initView();
    }

    private void initView() {
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return paths == null ? 0 : paths.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object o) {
                return view == o;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View adView = LayoutInflater.from(TaskBigImgActivity.this).inflate(R.layout.item_big_img, null);
                icon = (PhotoView) adView.findViewById(R.id.flaw_img);
                icon.setBackgroundColor(Color.parseColor("#333333"));
                Glide.with(TaskBigImgActivity.this)
                        .load(paths.get(position))
                        .into(icon);
                container.addView(adView);
                icon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                return adView;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });

        viewPager.setCurrentItem(position, true);
    }
}
