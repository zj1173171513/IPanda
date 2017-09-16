package cn.co.com.newpanda.presenter;

import cn.co.com.newpanda.model.biz.TopModel;
import cn.co.com.newpanda.model.biz.TopModelImpl;
import cn.co.com.newpanda.model.entity.pandaliveBean.TopBean;
import cn.co.com.newpanda.module.home.contract.TopContract;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;

/**
 * Created by 丶 on 2017/9/15.
 */

public class TopModelPresnter implements TopContract.TopPresnter {

    private TopContract.View topContractView;
    private TopModel topModel;


    public TopModelPresnter(TopContract.View yopContractView) {
        this.topContractView = yopContractView;
        this.topContractView.setPresenter(this);
        topModel = new TopModelImpl();
    }


    @Override
    public void start() {
        topModel.getTopModel(new MyNetWorkCallback<TopBean>() {
            @Override
            public void onSuccess(TopBean topBean) {
                topContractView.setResult(topBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                topContractView.showMessage(errorMsg);
            }
        });

    }
}
