package com.skin.skinvalue.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.skin.skinvalue.R;
import com.skin.skinvalue.common.gridDataItem;
import com.skin.skinvalue.db.skindataDB;


import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class HistoryFragment extends Fragment {

    ViewGroup rootView;
    private ListView gridView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_history, container, false);
        gridView = (ListView) rootView.findViewById(R.id.gridData);
        Show();
        return rootView;
    }

    private void Show(){
        List<gridDataItem> data = new ArrayList<gridDataItem>();
        gridDataItem hm = new gridDataItem();
        hm.head = "姓名";
        hm.item1 = "水分含量";
        hm.item2 = "水分散失";
        hm.item3 = "皮肤油脂";
        hm.item4 = "皮肤PH值";
        data.add(hm);

        gridDataItem hmt1 = new gridDataItem();
        hmt1.head = "张三";
        hmt1.item1 = "26.8";
        hmt1.item2 = "28.89";
        hmt1.item3 = "5";
        hmt1.item4 = "6.0";
        data.add(hmt1);
        gridDataItem hmt2 = new gridDataItem();
        hmt2.head = "李四";
        hmt2.item1 = "83.26";
        hmt2.item2 = "39.15";
        hmt2.item3 = "60";
        hmt2.item4 = "4.8";
        data.add(hmt2);
        gridDataItem hmt3 = new gridDataItem();
        hmt3.head = "王五";
        hmt3.item1 = "22.16";
        hmt3.item2 = "21.65";
        hmt3.item3 = "49";
        hmt3.item4 = "5.9";
        data.add(hmt3);
        gridDataItem hmt4 = new gridDataItem();
        hmt4.head = "赵六";
        hmt4.item1 = "25.66";
        hmt4.item2 = "30.03";
        hmt4.item3 = "68";
        hmt4.item4 = "5.2";
        data.add(hmt4);


        List<skindataDB> books = skindataDB.listAll(skindataDB.class);
        for (int i=0;i < books.size();++i){
            gridDataItem hm1 = new gridDataItem();
            hm1.head = books.get(i).head;
            hm1.item1 = books.get(i).item1;
            hm1.item2 = books.get(i).item2;
            hm1.item3 = books.get(i).item3;
            hm1.item4 = books.get(i).item4;
            data.add(hm);
        }

        gridView.setAdapter(new GridAdapter(this.getContext(),R.layout.grid_data_item, data));
    }

    public class GridAdapter extends ArrayAdapter<gridDataItem> {

        private final LayoutInflater mInflater;
        private final List<gridDataItem> mData;

        public GridAdapter(Context context,   int layoutResourceId,List<gridDataItem> data) {
            super(context, layoutResourceId, data);
            mData = data;
            mInflater = LayoutInflater.from(context);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder = null;
            if(convertView==null) {
                convertView = mInflater.inflate(R.layout.grid_data_item,parent, false);
                holder=new Holder();
                holder.head=(TextView) convertView.findViewById(R.id.girdHead);
                holder.item1=(TextView) convertView.findViewById(R.id.gridItem1);
                holder.item2=(TextView) convertView.findViewById(R.id.gridItem2);
                holder.item3=(TextView) convertView.findViewById(R.id.gridItem3);
                holder.item4=(TextView) convertView.findViewById(R.id.gridItem4);
                convertView.setTag(holder);
            }else{
                holder=(Holder) convertView.getTag();
            }

            holder.head.setText(mData.get(position).head.toString());
            holder.item1.setText(mData.get(position).item1.toString());
            holder.item2.setText(mData.get(position).item2.toString());
            holder.item3.setText(mData.get(position).item3.toString());
            holder.item4.setText(mData.get(position).item4.toString());

            return convertView;
        }
    }
    class Holder{
        TextView head;
        TextView item1;
        TextView item2;
        TextView item3;
        TextView item4;
    }
}
