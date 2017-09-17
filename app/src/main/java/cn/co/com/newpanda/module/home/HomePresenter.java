package cn.co.com.newpanda.module.home;


import cn.co.com.newpanda.model.biz.IPandaLiveModel;
import cn.co.com.newpanda.model.biz.PandaLiveModelImpl;
import cn.co.com.newpanda.model.entity.homeBean.HomeBean;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;

public class HomePresenter implements HomeContract.Presenter {

    private IPandaLiveModel pandaLiveModel;
    private HomeContract.View homeView;
    public HomePresenter(HomeContract.View homeView){
        this.homeView = homeView;
        this.homeView.setPresenter(this);
        pandaLiveModel = new PandaLiveModelImpl();
    }

    @Override
    public void start() {

        pandaLiveModel.getPadDaLive(new MyNetWorkCallback<HomeBean>() {
            @Override
            public void onSuccess(HomeBean homeBean) {

                homeView.setResult(homeBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

                homeView.showMessage(errorMsg);
            }
        });
    }
}
