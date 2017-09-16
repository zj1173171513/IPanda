package cn.co.com.newpanda.model.biz;

import cn.co.com.newpanda.config.UrlsUtils;
import cn.co.com.newpanda.model.entity.pandaliveBean.DonBean;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;

/**
 * Created by 丶 on 2017/9/15.
 */

public class DonModelImpl implements DonModel {
    @Override
    public void getDonModel(MyNetWorkCallback<DonBean> callback) {
        iHttp.get(UrlsUtils.PANDA,null,callback);
    }
}
