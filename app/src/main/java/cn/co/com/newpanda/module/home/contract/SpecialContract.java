package cn.co.com.newpanda.module.home.contract;

import cn.co.com.newpanda.base.BasePresenter;
import cn.co.com.newpanda.base.BaseView;
import cn.co.com.newpanda.model.entity.pandaliveBean.SpecialBean;

/**
 * Created by 丶 on 2017/9/16.
 */

public interface SpecialContract {
    interface  View extends BaseView<SpecialPresnter> {
        void showProgressDialog();
        void dismissDialog();
        void setResult(SpecialBean specialBean);
        void showMessage(String msg);

    }
    interface  SpecialPresnter extends BasePresenter {

    }
}
