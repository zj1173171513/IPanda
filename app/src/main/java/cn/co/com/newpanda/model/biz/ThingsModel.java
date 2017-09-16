package cn.co.com.newpanda.model.biz;

import cn.co.com.newpanda.model.entity.pandaliveBean.ThingsBean;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;

/**
 * Created by 丶 on 2017/9/16.
 */

public interface ThingsModel extends BaseModel {
    void getThingsModel(MyNetWorkCallback<ThingsBean> callback);
}
