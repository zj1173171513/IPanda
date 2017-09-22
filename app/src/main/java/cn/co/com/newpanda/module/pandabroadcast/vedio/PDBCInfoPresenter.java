package cn.co.com.newpanda.module.pandabroadcast.vedio;


import cn.co.com.newpanda.model.bobao.vedio.PDBCInfoModel;
import cn.co.com.newpanda.model.bobao.vedio.PDBCInfoModelImpl;
import cn.co.com.newpanda.model.entity.BoBaoBean.PDBCInfotwoBean;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;



public class PDBCInfoPresenter implements PDBCInfoContract.Presenter {

    private PDBCInfoModel ipdbcModel;
    private PDBCInfoContract.View homeview;


    public PDBCInfoPresenter(PDBCInfoContract.View homeview) {
        this.homeview = homeview;
        this.homeview.setPresenter(this);
        ipdbcModel = new PDBCInfoModelImpl();
    }


    @Override
    public void start() {
        ipdbcModel.getPDBCinfo(new MyNetWorkCallback<PDBCInfotwoBean>() {
            @Override
            public void onSuccess(PDBCInfotwoBean pdbcInfotwoBean) {
                homeview.setResult(pdbcInfotwoBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                homeview.showMessage(errorMsg);
            }
        });
    }
}
