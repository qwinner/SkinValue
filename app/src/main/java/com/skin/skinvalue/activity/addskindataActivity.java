package com.skin.skinvalue.activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.skin.skinvalue.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class addskindataActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addskindata);

        List<String> headList=new ArrayList<>();
        headList.add("额头");
        headList.add("眼角");
        headList.add("脸颊");
        headList.add("下巴");
        ListView listView = (ListView) this.findViewById(R.id.list_view);
        listView.setAdapter(new SkinCardAdapter(this, R.layout.skindata_item, headList));
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.commit:
                //saveData();
                break;
            default:
                break;
        }
    }

    class SkinCardAdapter extends ArrayAdapter<String> {

        private final LayoutInflater mInflater;
        private final List<String> mData;

        public SkinCardAdapter(Context context, int layoutResourceId, List<String> data) {
            super(context, layoutResourceId, data);
            mData = data;
            mInflater = LayoutInflater.from(context);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder = null;
            if(convertView==null) {
                convertView = mInflater.inflate(R.layout.skindata_item, parent, false);
                holder=new Holder();
                holder.title=(TextView) convertView.findViewById(R.id.textHead);
                convertView.setTag(holder);
            }else{
                holder=(Holder) convertView.getTag();
            }

            holder.title.setText(mData.get(position).toString());

            return convertView;
        }
        class Holder{
            TextView title;
            TextView content;
        }

    }
}
