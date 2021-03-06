package com.piyanutinukson.rmutsvservice.fragment;

import android.content.Intent;
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

import com.piyanutinukson.rmutsvservice.MyServiceActivity;
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
                passwordString = passwordEditText.getText().toString().trim();

                if (userString.equals("")||passwordString.equals("")) {
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
            getAllData.execute(myconstant.getUrlGetAllUser());
            String strJSON = getAllData.get();
            Log.d(tag, "JSON==>" + strJSON);
            String[] strings = new String[]{"id", "Name", "Category", "User", "Password"};
            String[] userString1 = new String[strings.length];

            JSONArray jsonArray = new JSONArray(strJONE);
            for (int i = 0; i < jsonArray.length(); i += 1) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);

                if (userString.equals(jsonObject.getString("User"))) {
                    userABoolean = false;
                }
                for (int i1 = 0; i1 < strings.length; i1 += 1) {
                    userString1[i1] = jsonObject.getString(strings[i1]);
                }


            }
        }   //for
        if (userABoolean) {
            MyAlert myAlert = new MyAlert(getActivity());
            myAlert.myDialog("User False","No This User in my Database");
        } else if (passwordString.equals(userString1[4])) {
            Toast.makeText(getActivity(),"Welcome" + userStrings1[1], Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getActivity(), MyServiceActivity.class);
            intent.putExtra("Login", userString);
            getActivity().startActivity(intent);
            getActivity().finish();
        } else {
            MyAlert myAlert = new MyAlert(getActivity());
            myAlert.myDialog("Password False", "Please Try Again Password False");
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
