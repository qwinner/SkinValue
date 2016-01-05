package com.skin.skinvalue.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.skin.skinvalue.R;
import com.skin.skinvalue.activity.addskindataActivity;

import java.io.File;


public class homeFragment extends Fragment {
    public static final int CAMERA_WITH_DATA = 168;

    public static final int PHOTO_PICKED_WITH_DATA = CAMERA_WITH_DATA + 1;

    public static final int PHOTO_CROP = PHOTO_PICKED_WITH_DATA + 1;

    public static final File PHOTO_DIR = new File(Environment.getExternalStorageDirectory() + "/DCIM/Camera/");
    public static Uri imageUri;
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
