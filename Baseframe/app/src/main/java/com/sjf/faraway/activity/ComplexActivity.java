package com.sjf.faraway.activity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sjf.baselib.base.BaseActivity;
import com.sjf.baselib.utils.Util;
import com.sjf.faraway.R;
import com.sjf.faraway.adapter.AnimationAdapter;
import com.sjf.faraway.config.ContantValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc: 复杂动画
 * Created by sunjinfang on 2016/6/6 11:11.
 */
public class ComplexActivity extends BaseActivity {
    private AnimationAdapter adapter;
    private ListView listView_anim_complex;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_anim_complex;
    }

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        listView_anim_complex = (ListView) findViewById(R.id.listView_anim_complex);
        List<String> list = new ArrayList<String>() ;
        Util.toListString(ContantValue.animName,list);
        adapter = new AnimationAdapter(this, list);
    }

    @Override
    protected void addListener() {
        listView_anim_complex.setAdapter(adapter);
        listView_anim_complex.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Animation anim = AnimationUtils.loadAnimation(ComplexActivity.this,
                        ContantValue.complex[position]);
                listView_anim_complex.startAnimation(anim);
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void handler(Message msg) {

    }

    @Override
    protected void onClickView(View v) {

    }
}
