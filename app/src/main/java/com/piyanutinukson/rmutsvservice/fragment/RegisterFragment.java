package com.piyanutinukson.rmutsvservice.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toolbar;

import com.piyanutinukson.rmutsvservice.MainActivity;
import com.piyanutinukson.rmutsvservice.R;
import com.piyanutinukson.rmutsvservice.utillity.MyAlert;

/**
 * Created by lenovo on 7/11/2560.
 */

public class RegisterFragment extends android.support.v4.app.Fragment {

    // Explicit
    private String nameString, userString, passwordString, categoryString;
    private boolean aBoolean = true;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //      Toolbar Controller
        toolbarController();

        //       save controller
        saveController();

        //   category controller
        categoryController();


    }   // Main Method

    private void categoryController() {
        RadioGroup radioGroup = getView().findViewById(R.id.ragCategory);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                aBoolean = false;
                switch (i) {
                    case R.id.radBuyer:
                        categoryString = "Buyer";
                        break;
                    case R.id.radSaler:
                        categoryString = "Saler";
                        break;
                }


            }
        });
    }

    private void saveController() {
        ImageView imageView = getView().findViewById(R.id.imvSave);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //   Initial View

                EditText nameEditText = getView().findViewById(R.id.edtname);
                EditText userEditText = getView().findViewById(R.id.edtuser);
                EditText passwordEditText = getView().findViewById(R.id.edtpassword);

                //  Change Data Type
                nameString = nameEditText.getText().toString().trim();
                userString = userEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();

                //      Check space
                if (nameString.equals("") || userString.equals("") || passwordString.equals("")) {
                    //           Have space
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.myDialog("Have space",
                            "Please Fill All Every Blank");
                } else if (aBoolean) {
//                    Non choose choice
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.myDialog("Non Chose Category",
                            "Please Choose Category");

                } else {
//                    choosed choice
                }
            }

            // onClick
        });
    }

    private void toolbarController() {
        android.support.v7.widget.Toolbar toolbar = getView().findViewById(R.id.toolberRegister);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        ((MainActivity) getActivity())
                .getSupportActionBar()
                .setTitle(getResources().getString(R.string.resister));

        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();


            }
        });


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resister, container, false);
        return view;
    }
}//main class
