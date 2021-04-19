package com.example.fragmentslider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {
    interface  Object{
          String ARG_OBJ = "object";
    }
    Fragment fragment;
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        //Si tenemos un fragment distinto al fragment de DemoObject ponemos un switch
//        switch (position){
//            case 1 :
//                fragment = new OtroFragment;
//        }
        Fragment fragment =  new DemoObject();
        Bundle bundle = new Bundle();
        bundle.putInt(Object.ARG_OBJ,position+1);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
