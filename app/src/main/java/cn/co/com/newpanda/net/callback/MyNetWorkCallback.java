package cn.co.com.newpanda.net.callback;


public interface MyNetWorkCallback<T> {

    void onSuccess(T t);
    void onError(int errorCode, String errorMsg);

}
