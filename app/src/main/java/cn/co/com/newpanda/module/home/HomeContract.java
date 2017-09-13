package cn.co.com.newpanda.module.home;


import cn.co.com.newpanda.base.BasePresenter;
import cn.co.com.newpanda.base.BaseView;
import cn.co.com.newpanda.model.entity.PandaLiveBean;

public interface HomeContract {

    interface View extends BaseView<Presenter> {
        void showProgressDialog();
        void dismissDialog();
        void setResult(PandaLiveBean pandaLiveBean);
        void showMessage(String msg);
    }

    interface Presenter extends BasePresenter {

    }
}
