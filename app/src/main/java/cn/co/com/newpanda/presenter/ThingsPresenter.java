package cn.co.com.newpanda.presenter;

import cn.co.com.newpanda.model.biz.ThingsModel;
import cn.co.com.newpanda.model.biz.ThingsModelImpl;
import cn.co.com.newpanda.model.entity.pandaliveBean.ThingsBean;
import cn.co.com.newpanda.module.home.contract.ThingsContract;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;

/**
 * Created by 丶 on 2017/9/16.
 */

public class ThingsPresenter implements ThingsContract.ThingsPresenter{

    private ThingsContract.View thingsContractView;
    private ThingsModel thingsModel;

    public ThingsPresenter(ThingsContract.View thingsContractView) {
        this.thingsContractView = thingsContractView;
        this.thingsContractView.setPresenter(this);
        thingsModel = new ThingsModelImpl();
    }


    @Override
    public void start() {
        thingsModel.getThingsModel(new MyNetWorkCallback<ThingsBean>() {
            @Override
            public void onSuccess(ThingsBean thingsBean) {
                thingsContractView.setResult(thingsBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                thingsContractView.showMessage(errorMsg);
            }
        });

    }
}
