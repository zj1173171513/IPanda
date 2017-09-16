package cn.co.com.newpanda.module.home.contract;

import cn.co.com.newpanda.base.BasePresenter;
import cn.co.com.newpanda.base.BaseView;
import cn.co.com.newpanda.model.entity.pandaliveBean.WonderfuMomentBean;

/**
 * Created by 丶 on 2017/9/14.
 */

public interface WonderfulMomentContract {
    interface View extends BaseView<WonderPresenter>{
        void showProgressDialog();
        void dismissDialog();
        void setResult(WonderfuMomentBean wonderfuMomentBean);
        void showMessage(String msg);
    }
    interface WonderPresenter extends BasePresenter{

    }
}
