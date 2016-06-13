package com.sjf.baselib.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.sjf.baselib.utils.AppManager;
import com.sjf.baselib.utils.ToastManager;
import com.sjf.baselib.utils.UIHandler;

/**
 * Desc: activity的基类
 * Created by sunjinfang on 2016/6/1 11:21.
 */
public abstract class BaseActivity extends Activity implements View.OnClickListener{


    protected UIHandler handler = new UIHandler(Looper.getMainLooper());
    protected Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());//设置布局
        AppManager.getInstance().addActivity(this);   //act压栈
        setHandler(); // 设置handler
        mContext = this.getApplicationContext(); //获取上下文
        initContentView(savedInstanceState);//初始化界面
        addListener() ;//添加监听
        initData(); //初始化数据
    }

    /**
     * Desc: 设置handler
     */
    private void setHandler() {
        handler.setHandler(new UIHandler.IHandler() {
            public void handleMessage(Message msg) {
                handler(msg);
            }
        });
    }

    @Override
    public void onClick(View v) {
        onClickView(v);
    }

    /**
     * 获取全局的Context
     */
    public Context getContext() {
        return mContext;
    }

    /**
     * 当前界面
     * @return
     */
    protected  abstract  int getLayoutId() ;

    /**
     * 设置 setContentView   当做onCreat()使用
     *
     * @param savedInstanceState
     */
    protected abstract void initContentView(Bundle savedInstanceState);

    /**
     * 添加监听
     */
    protected  abstract void addListener() ;
    /**
     * 初始化基础数据
     */
    protected abstract void initData();

    /**
     * handler消息接收
     *
     * @param msg
     */
    protected abstract void handler(Message msg);
    /**
     * 事件监听
     *
     * @param v
     */
    protected abstract void onClickView(View v);

    /**
     * 打印一条屏幕消息
     *
     * @param msg 消息内容
     */
    public void showToast(String msg) {
        ToastManager.makeToast(mContext, msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.pause();
        AppManager.getInstance().finishActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
