package com.skin.skinvalue.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.wyq.pullrefreshlibrary.PullToRefreshView;
import com.skin.skinvalue.R;
import com.skin.skinvalue.activity.addskindataActivity;


public class homeFragment extends Fragment {
    ViewGroup rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);
        Button btn = (Button) rootView.findViewById(R.id.adddata);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(rootView.getContext(), addskindataActivity.class));//启动另一个Activity
            }
        });
        return rootView;
    }

}
