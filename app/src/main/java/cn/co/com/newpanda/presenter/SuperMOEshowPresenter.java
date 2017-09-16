package cn.co.com.newpanda.presenter;

import cn.co.com.newpanda.model.biz.SuperMOEshowModel;
import cn.co.com.newpanda.model.biz.SuperMOEshowModelImpl;
import cn.co.com.newpanda.model.entity.pandaliveBean.SuperMOEshowBean;
import cn.co.com.newpanda.module.home.contract.SuperMOEshowContract;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;

/**
 * Created by 丶 on 2017/9/15.
 */

public class SuperMOEshowPresenter implements SuperMOEshowContract.SuperPresenter {
    private SuperMOEshowModel superMOEshowModel;
    private SuperMOEshowContract.View superMOEshowContractView;

    public SuperMOEshowPresenter(SuperMOEshowContract.View superMOEshowContractView) {
        this.superMOEshowContractView = superMOEshowContractView;
        this.superMOEshowContractView.setPresenter(this);
        superMOEshowModel = new SuperMOEshowModelImpl();
    }

    @Override
    public void start() {
        superMOEshowModel.getSuperMOEshow(new MyNetWorkCallback<SuperMOEshowBean>() {
            @Override
            public void onSuccess(SuperMOEshowBean superMOEshowBean) {
                superMOEshowContractView.setResult(superMOEshowBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                superMOEshowContractView.showMessge(errorMsg);
            }
        });
    }
}
