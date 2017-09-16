package cn.co.com.newpanda.module.home.contract;

import cn.co.com.newpanda.base.BasePresenter;
import cn.co.com.newpanda.base.BaseView;
import cn.co.com.newpanda.model.entity.pandaliveBean.ThingsBean;

/**
 * Created by 丶 on 2017/9/16.
 */

public interface ThingsContract {
    interface View extends BaseView<ThingsPresenter>{
        void showProgressDialog();
        void dismissDialog();
        void setResult(ThingsBean thingsBean);
        void showMessage(String msg);
    }
    interface ThingsPresenter extends BasePresenter{

    }
}
