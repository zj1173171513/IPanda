package cn.co.com.newpanda.model.biz;

import cn.co.com.newpanda.model.entity.pandaliveBean.TopBean;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;

/**
 * Created by 丶 on 2017/9/15.
 */

public interface TopModel extends BaseModel{
    void getTopModel(MyNetWorkCallback<TopBean> callback);
}
