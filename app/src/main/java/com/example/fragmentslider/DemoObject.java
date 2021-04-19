package com.example.fragmentslider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DemoObject#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DemoObject extends Fragment {

    @BindView(R.id.tvText)
    TextView textView;

    public DemoObject() {
        // Required empty public constructor
    }

    interface  Object{
        String ARG_OBJ = "object";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_demo_object, container, false);
        //Realizamos un atach al butterknife
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle arg = getArguments();
       int pos= arg.getInt(Object.ARG_OBJ);
       textView.setText("Fragment "+pos);
    }


}