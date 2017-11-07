package com.piyanutinukson.rmutsvservice.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.piyanutinukson.rmutsvservice.R;

/**
 * Created by lenovo on 7/11/2560.
 */

public class RegisterFragment extends android.support.v4.app.Fragment{

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            View view=inflater.inflate(R.layout.fragment_resister,container,false);
            return view;
        }
    }//main class
