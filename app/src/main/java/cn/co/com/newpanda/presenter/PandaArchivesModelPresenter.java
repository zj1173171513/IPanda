package cn.co.com.newpanda.presenter;

import cn.co.com.newpanda.model.biz.PandaArchivesModel;
import cn.co.com.newpanda.model.biz.PandaArchivesModelImpl;
import cn.co.com.newpanda.model.entity.pandaliveBean.PandaArchivesBean;
import cn.co.com.newpanda.module.home.contract.PandaArchivesModeContract;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;

/**
 * Created by 丶 on 2017/9/15.
 */

public class PandaArchivesModelPresenter implements PandaArchivesModeContract.PandaArchivesPresenter{
    private PandaArchivesModel pandaArchivesModel;
    private PandaArchivesModeContract.View pandaArchivesView;

    public PandaArchivesModelPresenter(PandaArchivesModeContract.View pandaArchivesView) {
        this.pandaArchivesView = pandaArchivesView;
        this.pandaArchivesView.setPresenter(this);
        pandaArchivesModel = new PandaArchivesModelImpl();
    }

    @Override
    public void start() {
        pandaArchivesModel.getPandaArchivesModel(new MyNetWorkCallback<PandaArchivesBean>() {
            @Override
            public void onSuccess(PandaArchivesBean pandaArchivesBean) {
                pandaArchivesView.setResult(pandaArchivesBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                pandaArchivesView.showMessage(errorMsg);
            }
        });
    }
}
