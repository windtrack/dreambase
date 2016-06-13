package com.sjf.faraway.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.sjf.baselib.base.BaseAdapter;
import com.sjf.baselib.base.BaseViewHolder;
import com.sjf.faraway.R;

import java.util.List;

/**
 * Desc:
 * Created by sunjinfang on 2016/6/3 13:11.
 */
public class AnimationAdapter extends BaseAdapter<String,ListView> {
    public AnimationAdapter(Context context, List<String> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String name = (String)getItem(position) ;
        if(convertView == null){
            convertView = View.inflate(mContext, R.layout.item_listview_anim, null);
        }
        TextView textView_name = BaseViewHolder.get(convertView,R.id.textView_name);
        TextView textView_num = (TextView) convertView.findViewById(R.id.textView_num);
        LinearLayout ll = (LinearLayout) convertView.findViewById(R.id.ll);

        if(position>8){
            textView_num.setText(String.valueOf(position+1));
        }else{
            textView_num.setText("0"+(position+1));
        }

        textView_name.setText(name);

        if(position%2==0){
            ll.setBackgroundResource(R.drawable.call_locate_gray);
        }else{
            ll.setBackgroundResource(R.drawable.call_locate_green);
        }
        return convertView;
    }
}
