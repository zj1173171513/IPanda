package cn.co.com.newpanda.module.home.homeview;

/**
 * Created by ASUS on 2017/9/21.
 */

public interface HomeView<T> {
    void toSucceed(T t);
    void tofail(String e);
}
