package com.piyanutinukson.rmutsvservice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.piyanutinukson.rmutsvservice.R;

/**
 * Created by lenovo on 6/11/2560.
 */

public class MainFragment extends Fragment{

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

      //  Register controller
        registerController();


    }   // Main Method

    private void registerController() {
        TextView textView = getView().findViewById(R.id.textRegister);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Replace Fragment
//                getActivity().getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.contentFragmentMain,new RegisterFragment())
//                        .commit();

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentFragmentMain, new RegisterFragment())
                        .addToBackStack(null)
                        .commit();


                // onClick
            }
        });
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
      View view =inflater.inflate(R.layout.fragment_main,container,false);
        return view;
    }
}    //Main Class
