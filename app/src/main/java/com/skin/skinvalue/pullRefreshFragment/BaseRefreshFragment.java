package com.skin.skinvalue.pullRefreshFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;


import com.skin.skinvalue.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BaseRefreshFragment extends Fragment {

    public static final int REFRESH_DELAY = 2000;

    public static final String KEY_ICON = "icon";
    public static final String KEY_COLOR = "color";

    protected List<Map<String, Integer>> mSampleList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Map<String, Integer> map;
        mSampleList = new ArrayList<>();

        int[] icons = {
                R.drawable.icon_1,
                R.drawable.icon_2,
                R.drawable.icon_3};

        int[] colors = {
                R.color.saffron,
                R.color.eggplant,
                R.color.sienna};

        for (int i = 0; i < icons.length; i++) {
            map = new HashMap<>();
            map.put(KEY_ICON, icons[i]);
            map.put(KEY_COLOR, colors[i]);
            mSampleList.add(map);
        }
    }
}
