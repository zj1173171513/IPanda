package cn.co.com.newpanda.module.pandabroadcast;

import cn.co.com.newpanda.model.bobao.IPDBCModel;
import cn.co.com.newpanda.model.bobao.PBDCModelImpl;
import cn.co.com.newpanda.model.entity.BoBaoBean.PandaBroadCastBean;
import cn.co.com.newpanda.model.entity.BoBaoBean.PandaBroadcastInfoBean;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/9/12.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class PandaBroadcastPresenter implements PandaBroadcastContract.Presenter{
    private IPDBCModel ipdbcModel;
    private PandaBroadcastContract.View homeview;
    public PandaBroadcastPresenter(PandaBroadcastContract.View homeview) {
        this.homeview = homeview;
        this.homeview.setPresenter(this);
        ipdbcModel = new PBDCModelImpl();
    }
    @Override
    public void start() {
        ipdbcModel.getPDNC(new MyNetWorkCallback<PandaBroadCastBean>() {
            @Override
            public void onSuccess(PandaBroadCastBean pandaBroadCastBean) {
                homeview.setResult(pandaBroadCastBean);
                homeview.dismissDialog();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                homeview.showMessage(errorMsg);
            }
        });

        ipdbcModel.getPDBCinfo(new MyNetWorkCallback<PandaBroadcastInfoBean>() {
            @Override
            public void onSuccess(PandaBroadcastInfoBean pandaBroadcastInfoBean) {
                homeview.setInfo(pandaBroadcastInfoBean);
                homeview.dismissDialog();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                homeview.showMessage(errorMsg);
                homeview.dismissDialog();
            }
        });
    }
}

