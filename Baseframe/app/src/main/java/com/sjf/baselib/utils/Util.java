package com.sjf.baselib.utils;

import com.sjf.baselib.http.MyOkHttpClient;
import com.sjf.faraway.config.ContantValue;
import com.sjf.faraway.config.UrlConfig;
import com.sjf.faraway.rpc.RpcEvent;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Desc:一个工具类
 * Created by sunjinfang on 2016/6/1 11:54.
 */
public class Util {

    /**
     * 发送一个rpc请求
     * @param event  命令
     * @param params 数据
     * @return 服务器返回的json数据
     */
    public static String addRpcEvent(RpcEvent event, Object ...params){
        String s = "";
        try {
            String uri = UrlConfig.APP_RPC;
            MyOkHttpClient client = new MyOkHttpClient(uri);
            client.setConnectTimeout(30, TimeUnit.SECONDS);
            String data = client.doRequest(event.name, params);
            JSONObject jsonObject = new JSONObject(data);
            s = jsonObject.getString("result");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return s;
    }


    public static List<String> toListString(String[] arrayStr, List<String> list ){
        for (String str: arrayStr) {
            list.add(str) ;
        }
        return list ;
    }


}
