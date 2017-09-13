package cn.co.com.newpanda.net;


import java.util.Map;

import cn.co.com.newpanda.net.callback.MyNetWorkCallback;


public interface IHttp {

    <T> void get(String url, Map<String, String> params, MyNetWorkCallback<T> callback);
    <T> void post(String url, Map<String, String> params, MyNetWorkCallback<T> callback);
    void upload();
    void download();
    void loadImage();

}
