package cn.co.com.newpanda.module.home.contract;

import cn.co.com.newpanda.base.BasePresenter;
import cn.co.com.newpanda.base.BaseView;
import cn.co.com.newpanda.model.entity.pandaliveBean.VideoBeans;

/**
 * Created by 丶 on 2017/9/20.
 */

public interface VideoContract {
    interface View extends BaseView<ActivityPresnter> {
        void setResult(VideoBeans videoBeans);

        void showProgressDialog();

        void dismissDialog();

        void showMessage(String msg);

    }

    interface ActivityPresnter extends BasePresenter {

    }
}
