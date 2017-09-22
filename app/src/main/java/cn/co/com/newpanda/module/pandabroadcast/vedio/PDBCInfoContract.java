package cn.co.com.newpanda.module.pandabroadcast.vedio;


import cn.co.com.newpanda.base.BasePresenter;
import cn.co.com.newpanda.base.BaseView;
import cn.co.com.newpanda.model.entity.BoBaoBean.PDBCInfotwoBean;


public interface PDBCInfoContract {
    interface View extends BaseView<Presenter> {

        void setResult(PDBCInfotwoBean pdbcinfoBean);
        void showMessage(String msg);
    }

    interface Presenter extends BasePresenter {

    }
}
