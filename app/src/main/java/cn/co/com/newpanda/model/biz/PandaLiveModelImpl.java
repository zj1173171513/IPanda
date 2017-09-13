package cn.co.com.newpanda.model.biz;


import cn.co.com.newpanda.config.Urls;
import cn.co.com.newpanda.model.entity.PandaLiveBean;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;

public class PandaLiveModelImpl implements IPandaLiveModel {

    @Override
    public void getPadDaLive(MyNetWorkCallback<PandaLiveBean> callback) {
        //发送网络请求
        iHttp.get(Urls.PANDALIVE,null,callback);

    }
}
