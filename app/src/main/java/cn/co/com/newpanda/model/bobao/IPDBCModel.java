package cn.co.com.newpanda.model.bobao;

import cn.co.com.newpanda.model.biz.BaseModel;
import cn.co.com.newpanda.model.entity.BoBaoBean.PandaBroadCastBean;
import cn.co.com.newpanda.model.entity.BoBaoBean.PandaBroadcastInfoBean;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/9/19.
 */

public interface IPDBCModel extends BaseModel {
    void getPDNC(MyNetWorkCallback<PandaBroadCastBean> callback);
    void getPDBCinfo(MyNetWorkCallback<PandaBroadcastInfoBean> callback);
}


