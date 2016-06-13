package com.sjf.faraway.activity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.sjf.baselib.base.BaseActivity;
import com.sjf.faraway.R;
import com.sjf.faraway.adapter.AnimationAdapter;
import com.sjf.faraway.config.ContantValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 * Created by sunjinfang on 2016/6/3 13:03.
 */
public class SimpleActivity extends BaseActivity{
    private ListView listView_anim_simple;
    private AnimationAdapter adapter ;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_anim_simple;
    }

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        listView_anim_simple = (ListView) findViewById(R.id.listView_anim_simple) ;
        List<String> list = new ArrayList<String>() ;
        for (String str:ContantValue.simpleName) {
            list.add(str) ;
        }
        adapter = new AnimationAdapter(this, list);
    }

    @Override
    protected void addListener() {

    }

    @Override
    protected void initData() {
        listView_anim_simple.setAdapter(adapter);
        listView_anim_simple.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Animation anim = AnimationUtils.loadAnimation(SimpleActivity.this,
                        ContantValue.simple[position]);
                listView_anim_simple.startAnimation(anim);
            }
        });
    }

    @Override
    protected void handler(Message msg) {

    }

    @Override
    protected void onClickView(View v) {

    }
}
