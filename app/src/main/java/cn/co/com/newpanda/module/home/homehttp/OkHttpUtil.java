package cn.co.com.newpanda.module.home.homehttp;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by ASUS on 2017/9/13.
 */

public class OkHttpUtil {
    private static OkHttpUtil utils;
    private OkHttpClient client;
    private OkHttpUtil(){
        client = new OkHttpClient();
    }
    public static synchronized OkHttpUtil getInstance(){
        if (utils == null){
            utils = new OkHttpUtil();
            return utils;
        }
        return utils;
    }
    public void getRequest(String url, Callback callback){
        Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
