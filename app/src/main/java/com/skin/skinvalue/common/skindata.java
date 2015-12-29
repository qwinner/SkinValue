package com.skin.skinvalue.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.skin.skinvalue.R;

/**
 * Created by wyq on 2015/12/29.
 */
public class skindata extends LinearLayout {
    private TextView head;

    public skindata(Context context, AttributeSet attrs){
        super(context, attrs);
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.skindata,this);
        head=(TextView)findViewById(R.id.textHead);

    }

    public void SetHeadText(String txt){
        head.setText(txt);
    }
}
