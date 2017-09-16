package cn.co.com.newpanda.module.home.contract;

import cn.co.com.newpanda.base.BasePresenter;
import cn.co.com.newpanda.base.BaseView;
import cn.co.com.newpanda.model.entity.pandaliveBean.DonBean;

/**
 * Created by 丶 on 2017/9/15.
 */

public interface DonModelContract {
    interface  View extends BaseView<DonPresnter>{
        void showProgressDialog();
        void dismissDialog();
        void setResult(DonBean donBean);
        void showMessage(String msg);

    }
    interface  DonPresnter extends BasePresenter{

    }
}
