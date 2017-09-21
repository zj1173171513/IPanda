package cn.co.com.newpanda.module.pandabroadcast;

import cn.co.com.newpanda.base.BasePresenter;
import cn.co.com.newpanda.base.BaseView;
import cn.co.com.newpanda.model.entity.BoBaoBean.PandaBroadCastBean;
import cn.co.com.newpanda.model.entity.BoBaoBean.PandaBroadcastInfoBean;

/**
 * Created by Administrator on 2017/9/12.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public interface PandaBroadcastContract {
    interface View extends BaseView<Presenter> {
        void showProgressDialog();
        void setResult(PandaBroadCastBean pdbcBean);
        void showMessage(String msg);
        void setInfo(PandaBroadcastInfoBean pdbcInfoBean);
        void dismissDialog();
    }
    interface Presenter extends BasePresenter {

    }
}
