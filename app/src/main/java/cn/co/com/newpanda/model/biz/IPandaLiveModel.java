package cn.co.com.newpanda.model.biz;


import cn.co.com.newpanda.model.entity.PandaLiveBean;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;

public interface IPandaLiveModel extends BaseModel{

    void getPadDaLive(MyNetWorkCallback<PandaLiveBean> callback);
}
