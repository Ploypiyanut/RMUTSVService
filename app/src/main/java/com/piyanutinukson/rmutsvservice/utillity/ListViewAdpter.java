package com.piyanutinukson.rmutsvservice.utillity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.piyanutinukson.rmutsvservice.R;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by lenovo on 9/11/2560.
 */

public class ListViewAdpter extends BaseAdapter {


    private Context context;
    private String[] nameString, catString, userString, password;

    public ListViewAdpter(Context context, String[] nameString, String[] catString, String[] userString, String[] password) {
        this.context = context;
        this.nameString = nameString;
        this.catString = catString;
        this.userString = userString;
        this.password = password;
    }

    @Override
    public int getCount() {
        return nameString.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.loyout_listview, viewGroup, false)

        TextView nameTextView = view1.findViewById(R.id.txtname);
        TextView categpryTextView = view1.findViewById(R.id.txtCategory);
        TextView userTextView = view1.findViewById(R.id.txtUser);
        TextView passTextView = view1.findViewById(R.id.txtPassword);

        nameTextView .setText(nameString[i]);
        categpryTextView .setText(catString[i]);
        userTextView .setText(userString[i]);
        passTextView .setText(password[i]);



        return null;
    }



} //Main Class
