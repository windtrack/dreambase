package com.sjf.faraway.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.sjf.baselib.base.BaseActivity;
import com.sjf.baselib.ui.PullDoorView;
import com.sjf.baselib.utils.LogManager;
import com.sjf.faraway.R;
import com.sjf.faraway.config.ContantValue;
import com.sjf.faraway.config.IntentAction;

/**
 * Desc:  测试的主界面
 * Created by sunjinfang on 2016/6/2 13:58.
 */
public class TestActivity  extends BaseActivity{

    private final static String TAG = "test_main_activity" ;

    private ListView listView_animation ;
    private TextView text_hint ;
    private ArrayAdapter<String> itemAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_testact;
    }

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        listView_animation = (ListView) findViewById(R.id.listView_animation) ;
        text_hint = (TextView) findViewById(R.id.tv_hint) ;

    }

    @Override
    protected void addListener() {
        itemAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, ContantValue.mainItem);
        listView_animation.setAdapter(itemAdapter);
        listView_animation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LogManager.i(TAG,"press id == " + position);
                switch (position){
                    case 0 : //简单动画
                        startIntent(IntentAction.Action_SimplerAnimation);
                        overridePendingTransition(R.anim.in_translate_top,R.anim.out_translate_top);
                        break ;
                    case 1 : //复杂动画
                        startIntent(IntentAction.Action_ComplexAnimation);
                        overridePendingTransition(R.anim.block_move_right, R.anim.small_2_big);
                        break ;
                    case 2 : //Splash引导动画
                        break ;
                    case 3 : //Flip效果合集(折叠)
                        break ;
                    case 4 : //NineOld
                        break ;
                    case 5 : //Property效果
                        break ;
                    case 6 : //高仿动画效果
                        break ;
                    case 7 : //Listview效果集合
                        break ;
                    case 8 : //自定义控件效果集合
                        break ;
                    case 9 : //页面滑动切换效果集合
                        break ;
                }
            }
        });
    }

    @Override
    protected void initData() {


        //文字效果
        Animation ani = new AlphaAnimation(0.1f, 1f);
        ani.setDuration(1500);
        ani.setRepeatMode(Animation.REVERSE);
        ani.setRepeatCount(Animation.INFINITE);
        text_hint.startAnimation(ani);
    }

    @Override
    protected void handler(Message msg) {

    }

    @Override
    protected void onClickView(View v) {

    }

    //进入sample
    public void goToSample(View e){
        startActivity(new Intent(IntentAction.Action_SampleActivity) );
    }

    private void  startIntent(String action){
        Intent intent = new Intent(action);
        startActivity(intent);
    }

}
