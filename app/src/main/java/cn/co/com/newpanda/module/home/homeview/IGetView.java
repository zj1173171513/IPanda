package cn.co.com.newpanda.module.home.homeview;

import java.util.List;

/**
 * Created by ASUS on 2017/9/13.
 */

public interface IGetView<T> {
    void showLoading();
    void dismisLoading();

    void toMainSucceed(List<T> list);
    void toMainFail(String e);
}
