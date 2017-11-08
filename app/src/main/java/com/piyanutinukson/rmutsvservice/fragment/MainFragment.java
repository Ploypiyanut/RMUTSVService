package com.piyanutinukson.rmutsvservice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.piyanutinukson.rmutsvservice.R;
import com.piyanutinukson.rmutsvservice.utillity.GetAllData;
import com.piyanutinukson.rmutsvservice.utillity.MyAlert;
import com.piyanutinukson.rmutsvservice.utillity.Myconstant;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by lenovo on 6/11/2560.
 */

public class MainFragment extends Fragment{

    private String userString, passwordString;
    private boolean userABoolean = true;  // true==>User False

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

      //  Register controller
        registerController();
    //     Login Controller
        loginController();

    }   // Main Method

    private void loginController() {
        Button button = getView().findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText userEditText = getView().findViewById(R.id.edtuser);
                EditText passwordEditText = getView().findViewById(R.id.edtpassword);

                userString = userEditText.getText().toString().trim();
                passString = passwordEditText.getText().toString().trim();

                if (userString.equals("")||passString.equals("")) {
                    //      Have Space
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.myDialog("Have Space", "Please Fill All Blank");
                }else{
                    checkUserAnpass();
                }
            } // onclick
        });
    }

    private void checkUserAnpass() {

        try {

            Myconstant myconstant = new Myconstant();
            String tag = "8novV1";
            GetAllData getAllData = new GetAllData(getActivity());
            getAllData.execute(myconstant.getUrlpostData());
            String strJSON = getAllData.get();
            Log.d(tag, "JSON==>" + strJSON);

            JSONArray jsonArray = new JSONArray(strJSON);
            for (int i=0;i<strJSON.length();i+=1 ) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);

                if (userString.equals(jsonObject.getString("neme"))){
                    userABoolean = false;

                    String[] strings = new String[]{"id", "Name", "Category",
                            "User", "Password"};
                }



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

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
