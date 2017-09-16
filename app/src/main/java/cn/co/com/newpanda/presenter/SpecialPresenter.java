package cn.co.com.newpanda.presenter;

import cn.co.com.newpanda.model.biz.SpecialModel;
import cn.co.com.newpanda.model.biz.SpercialModelIpml;
import cn.co.com.newpanda.model.entity.pandaliveBean.SpecialBean;
import cn.co.com.newpanda.module.home.contract.SpecialContract;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;

/**
 * Created by 丶 on 2017/9/16.
 */

public class SpecialPresenter implements SpecialContract.SpecialPresnter {

    private SpecialContract.View specialContractView;
    private SpecialModel specialModel;
    public SpecialPresenter(SpecialContract.View specialContractView){
        this.specialContractView = specialContractView;
        this.specialContractView.setPresenter(this);
        specialModel = new SpercialModelIpml();
    }

    @Override
    public void start() {
        specialModel.getSpecialModel(new MyNetWorkCallback<SpecialBean>() {
            @Override
            public void onSuccess(SpecialBean specialBean) {
                specialContractView.setResult(specialBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                specialContractView.showMessage(errorMsg);
            }
        });

    }
}
