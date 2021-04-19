package com.example.fragmentslider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    ViewPagerAdapter adapter;

    @BindView(R.id.pager)
    ViewPager2 viewPager2;


    public ViewPagerAdapter getAdapter() {
        if(adapter == null)
            adapter= new ViewPagerAdapter(this);
        return adapter;
    }

    public void setAdapter(ViewPagerAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        viewPager2.setAdapter(getAdapter());
    }
}