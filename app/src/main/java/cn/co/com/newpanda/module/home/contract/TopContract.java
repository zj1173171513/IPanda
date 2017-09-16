package cn.co.com.newpanda.module.home.contract;

import cn.co.com.newpanda.base.BasePresenter;
import cn.co.com.newpanda.base.BaseView;
import cn.co.com.newpanda.model.entity.pandaliveBean.TopBean;

/**
 * Created by 丶 on 2017/9/15.
 */

public interface TopContract  {
    interface  View extends BaseView<TopPresnter> {
        void showProgressDialog();
        void dismissDialog();
        void setResult(TopBean topBean);
        void showMessage(String msg);

    }
    interface  TopPresnter extends BasePresenter {

    }
}
