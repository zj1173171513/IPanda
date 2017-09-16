package cn.co.com.newpanda.presenter;


import cn.co.com.newpanda.model.biz.DonModel;
import cn.co.com.newpanda.model.biz.DonModelImpl;
import cn.co.com.newpanda.model.entity.pandaliveBean.DonBean;
import cn.co.com.newpanda.module.home.contract.DonModelContract;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;

/**
 * Created by 丶 on 2017/9/15.
 */

public class DonModelPresnter implements DonModelContract.DonPresnter {

    private DonModel donModel;
    private DonModelContract.View conTractView;

    public DonModelPresnter( DonModelContract.View conTractView) {
       this.conTractView = conTractView;
        conTractView.setPresenter(this);
        donModel = new DonModelImpl();
    }

    @Override
    public void start() {
        donModel.getDonModel(new MyNetWorkCallback<DonBean>() {
            @Override
            public void onSuccess(DonBean donBean) {
                conTractView.setResult(donBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                conTractView.showMessage(errorMsg);
            }
        });
    }
}
