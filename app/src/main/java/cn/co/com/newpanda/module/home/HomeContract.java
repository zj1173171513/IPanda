package cn.co.com.newpanda.module.home;


import cn.co.com.newpanda.base.BasePresenter;
import cn.co.com.newpanda.base.BaseView;
import cn.co.com.newpanda.model.entity.homeBean.HomeBean;

public interface HomeContract {

    interface View extends BaseView<Presenter> {
        void showProgressDialog();
        void dismissDialog();
        void setResult(HomeBean homeBean);
        void showMessage(String msg);
    }

    interface Presenter extends BasePresenter {

    }
}
