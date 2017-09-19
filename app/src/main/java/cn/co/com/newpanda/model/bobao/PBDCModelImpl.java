package cn.co.com.newpanda.model.bobao;

import cn.co.com.newpanda.config.Urls;
import cn.co.com.newpanda.model.entity.BoBaoBean.PandaBroadCastBean;
import cn.co.com.newpanda.model.entity.BoBaoBean.PandaBroadcastInfoBean;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/9/19.
 */

public class PBDCModelImpl implements IPDBCModel {

    @Override
    public void getPDNC(MyNetWorkCallback<PandaBroadCastBean> callback) {
        iHttp.get(Urls.PANDABOBAO,null,callback);

    }

    @Override
    public void getPDBCinfo(MyNetWorkCallback<PandaBroadcastInfoBean> callback) {
        iHttp.get(Urls.PANDABROADCASTINFO,null,callback);
    }
}

