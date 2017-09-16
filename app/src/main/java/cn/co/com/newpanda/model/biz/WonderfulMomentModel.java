package cn.co.com.newpanda.model.biz;

import cn.co.com.newpanda.model.entity.pandaliveBean.WonderfuMomentBean;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;

/**
 * Created by 丶 on 2017/9/14.
 */


public interface WonderfulMomentModel extends BaseModel{
    void getWonderFu(MyNetWorkCallback<WonderfuMomentBean> callback);
}
