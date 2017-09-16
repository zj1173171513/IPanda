package cn.co.com.newpanda.module.home.contract;

import cn.co.com.newpanda.base.BasePresenter;
import cn.co.com.newpanda.base.BaseView;
import cn.co.com.newpanda.model.entity.pandaliveBean.PandaArchivesBean;

/**
 * Created by 丶 on 2017/9/15.
 */

public interface PandaArchivesModeContract {
    interface View extends BaseView<PandaArchivesPresenter>{
        void showProgressDialog();
        void dismissDialog();
        void setResult(PandaArchivesBean pandaArchivesBean);
        void showMessage(String msg);
    }
    interface PandaArchivesPresenter extends BasePresenter{

    }
}
