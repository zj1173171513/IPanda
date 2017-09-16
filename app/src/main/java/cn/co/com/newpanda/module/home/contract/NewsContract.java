package cn.co.com.newpanda.module.home.contract;

import cn.co.com.newpanda.base.BasePresenter;
import cn.co.com.newpanda.base.BaseView;
import cn.co.com.newpanda.model.entity.pandaliveBean.NewsBean;

/**
 * Created by 丶 on 2017/9/16.
 */

public interface NewsContract {
    interface  View extends BaseView<NewsPresnter> {
        void showProgressDialog();
        void dismissDialog();
        void setResult(NewsBean newsBean);
        void showMessage(String msg);

    }
    interface  NewsPresnter extends BasePresenter {

    }
}
