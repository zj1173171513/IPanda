package cn.co.com.newpanda.presenter;


import cn.co.com.newpanda.model.biz.WonderfulMomentModel;
import cn.co.com.newpanda.model.biz.WonderfulMomentModelImpl;
import cn.co.com.newpanda.model.entity.pandaliveBean.WonderfuMomentBean;
import cn.co.com.newpanda.module.home.contract.WonderfulMomentContract;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;
import cn.co.com.newpanda.view.fragment.pandalive_fragment.WonderfulMoment;

/**
 * Created by 丶 on 2017/9/14.
 */

public class WonderfulMomentPresenter implements WonderfulMomentContract.WonderPresenter {

    private WonderfulMomentModel wonderfulMomentModel;
    private WonderfulMomentContract.View wonderfulView;

    public WonderfulMomentPresenter(WonderfulMoment wonderfulView) {
        this.wonderfulView =wonderfulView;
        this.wonderfulView.setPresenter(this);
        wonderfulMomentModel = new WonderfulMomentModelImpl();

    }

    @Override
    public void start() {
        wonderfulMomentModel.getWonderFu(new MyNetWorkCallback<WonderfuMomentBean>() {
            @Override
            public void onSuccess(WonderfuMomentBean wonderfuMomentBean) {
                wonderfulView.setResult(wonderfuMomentBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                wonderfulView.showMessage(errorMsg);
            }
        });

    }
}
