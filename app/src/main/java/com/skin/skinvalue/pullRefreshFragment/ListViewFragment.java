package com.skin.skinvalue.pullRefreshFragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;


import com.example.wyq.pullrefreshlibrary.PullToRefreshView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.skin.skinvalue.R;
import com.skin.skinvalue.adapter.ChartDataAdapter;
import com.skin.skinvalue.common.ChartItem;
import com.skin.skinvalue.common.LineChartItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ListViewFragment extends BaseRefreshFragment {

    private PullToRefreshView mPullToRefreshView;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = (ViewGroup) inflater.inflate(R.layout.fragment_list_view, container, false);

        initHomeTabView();

        mPullToRefreshView = (PullToRefreshView) view.findViewById(R.id.pull_to_refresh);
        mPullToRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPullToRefreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPullToRefreshView.setRefreshing(false);
                        initHomeTabView();
                    }
                }, REFRESH_DELAY);
            }
        });

        return view;
    }
    //曲线显示
    private void initHomeTabView() {
        ListView lv = (ListView) view.findViewById(R.id.list_view);
        if(lv != null) {
            ArrayList<ChartItem> list = new ArrayList<ChartItem>();
            FragmentActivity frag = getActivity();
            list.add(new LineChartItem(generateDataLine(1), frag));

            ChartDataAdapter cda = new ChartDataAdapter(getActivity(), list);
            lv.setAdapter(cda);
        }
    }
    //假的数据
    /**
     * generates a random ChartData object with just one DataSet
     *
     * @return
     */
    private LineData generateDataLine(int cnt) {

        ArrayList<Entry> e1 = new ArrayList<Entry>();

        for (int i = 0; i < 5; i++) {
            e1.add(new Entry((int) (Math.random() * 65) + 10, i));
        }

        LineDataSet d1 = new LineDataSet(e1, "您的数据");
        d1.setLineWidth(2.5f);
        d1.setCircleSize(4.5f);
        d1.setHighLightColor(Color.rgb(244, 117, 117));
        d1.setDrawValues(false);

        ArrayList<Entry> e2 = new ArrayList<Entry>();

        for (int i = 0; i < 5; i++) {
            e2.add(new Entry(e1.get(i).getVal() - (13-i*2), i));
        }

        LineDataSet d2 = new LineDataSet(e2, "I优级均值");
        d2.setLineWidth(2.5f);
        d2.setCircleSize(4.5f);
        d2.setHighLightColor(Color.rgb(244, 117, 117));
        d2.setColor(ColorTemplate.VORDIPLOM_COLORS[0]);
        d2.setCircleColor(ColorTemplate.VORDIPLOM_COLORS[0]);
        d2.setDrawValues(false);

        ArrayList<LineDataSet> sets = new ArrayList<LineDataSet>();
        sets.add(d1);
        sets.add(d2);

        LineData cd = new LineData(getMonths(), sets);
        return cd;
    }
    private ArrayList<String> getMonths() {

        ArrayList<String> m = new ArrayList<String>();
        m.add("水润度");
        m.add("白皙度");
        m.add("紧实度");
        m.add("光泽度");
        m.add("气血");


        return m;
    }
}
