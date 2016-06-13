package com.sjf.baselib.utils;

import android.app.Activity;
import android.content.Context;

import java.util.Stack;

/**
 * Desc: 管理当前活动的activity
 * Created by sunjinfang on 2016/6/1 13:22.
 */
public class AppManager {

    private static Stack<Activity> activityStack;
    private static AppManager instance;

    public static AppManager getInstance() {
        if (instance == null) {
            instance = new AppManager();
        }
        return instance;
    }

    private AppManager() {
        activityStack = new Stack<Activity>();
    }

    /**
     * 添加一个act
     *
     * @param activity
     */
    public void addActivity(Activity activity) {
        activityStack.add(activity);
    }

    /**
     * 结束一个act
     *
     * @param activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 获取当前act
     *
     * @return
     */
    public Activity getCurActivity() {
        Activity activity = activityStack.lastElement();
        return activity;
    }

    /**
     * 结束当前act
     */
    public void finishCurActivity() {
        finishActivity(getCurActivity());
    }

    /**
     * 结束所有的act
     */
    public void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
            }
        }
    }

    /**
     * 彻底退出应用程序，安全退出
     */
    public void safeExit(Context context) {
        try {
            finishAllActivity();
            System.exit(0);
            android.os.Process.killProcess(android.os.Process.myPid());
        } catch (Exception e) {
        }
    }
}
