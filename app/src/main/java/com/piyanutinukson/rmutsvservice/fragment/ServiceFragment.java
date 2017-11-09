package com.piyanutinukson.rmutsvservice.fragment;

import android.app.Fragment;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.piyanutinukson.rmutsvservice.MyServiceActivity;
import com.piyanutinukson.rmutsvservice.R;
import com.piyanutinukson.rmutsvservice.utillity.GetAllData;
import com.piyanutinukson.rmutsvservice.utillity.ListViewAdpter;
import com.piyanutinukson.rmutsvservice.utillity.Myconstant;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by lenovo on 9/11/2560.
 */

public class ServiceFragment extends android.support.v4.app.Fragment {

    public static ServiceFragment serviceInstance(String[] strings) {
        ServiceFragment serviceFragment = new ServiceFragment();
        Bundle bundle = new Bundle();
        bundle .putStringArray("Login",strings);
        serviceFragment.setArguments(bundle);
        return serviceFragment;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String[] strings = getArguments().getStringArray("Login");
        Log.d("9novV1", "Login(1)on ServiceFragment==>"+strings[1]);

//    Create Toolbar


        createToolbar(strings[1]);

//        Creater ListView

        createToolbar(strings[1]);

//        Create ListView
        createListView();


    }

    private void createListView() {
        ListView listView = getView().findViewById(R.id.livUser);
        Myconstant myconstant = new Myconstant();

        try {

            GetAllData getAllData = new GetAllData(getActivity());
            getAllData .execute(myconstant.getUrlGetAllUser());
            String resuIJSON = getAllData.get();
            Log.d("9novV1", "JSON==>" + resuIJSON);
            JSONArray jsonArray = new JSONArray(resuIJSON);

            String[] nameString = new String[jsonArray.length()];
            String[] catString = new String[jsonArray.length()];
            String[] userString = new String[jsonArray.length()];
            String[] passwordString = new String[jsonArray.length()];

            for (int i=0; i<jsonArray.length();i+=1) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                nameString[i] = jsonObject.getString("Name");
                catString[i] = jsonObject.getString("Category");
                userString[i] = jsonObject.getString("User");
                passwordString[i] = jsonObject.getString("Password");

            }  // for
            ListAdapter listAdapter = new ListViewAdpter(getActivity(),
                    nameString,catString,userString,passwordString);
            listView .setAdapter(listAdapter);







        }catch (Exception e){
        e.printStackTrace();

    }

    private void createToolbar(String setTile) {
        Toolbar toolbar = getView().findViewById(R.id.toolberService);

        ((MyServiceActivity )getActivity()) .setSupportActionBar(toolbar);
        ((MyServiceActivity) getActivity()).getSupportActionBar().setTitle(setTile);
        ((MyServiceActivity) getActivity()).getSupportActionBar().setSubtitle("Who Loged");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_my_service, container, false);
        return view;

    }
} // Main Class
