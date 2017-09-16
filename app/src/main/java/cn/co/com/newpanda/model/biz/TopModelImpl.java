package cn.co.com.newpanda.model.biz;

import cn.co.com.newpanda.config.UrlsUtils;
import cn.co.com.newpanda.model.entity.pandaliveBean.TopBean;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;

/**
 * Created by 丶 on 2017/9/15.
 */

public class TopModelImpl implements TopModel {

    @Override
    public void getTopModel(MyNetWorkCallback<TopBean> callback) {
        iHttp.get(UrlsUtils.TOP, null, callback);
    }
}
