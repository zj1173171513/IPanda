package cn.co.com.newpanda.module.home.contract;

import cn.co.com.newpanda.base.BasePresenter;
import cn.co.com.newpanda.base.BaseView;
import cn.co.com.newpanda.model.entity.pandaliveBean.SuperMOEshowBean;

/**
 * Created by 丶 on 2017/9/15.
 */

public interface SuperMOEshowContract {
    interface View extends BaseView<SuperPresenter>{
        void showProgressDialog();
        void dismissDialog();
        void setResult(SuperMOEshowBean superMOEshowBean);
        void showMessge(String msg);
    }
    interface SuperPresenter extends BasePresenter{

    }
}
