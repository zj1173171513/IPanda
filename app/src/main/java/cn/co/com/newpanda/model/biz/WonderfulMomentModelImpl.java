package cn.co.com.newpanda.model.biz;

import cn.co.com.newpanda.config.UrlsUtils;
import cn.co.com.newpanda.model.entity.pandaliveBean.WonderfuMomentBean;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;

/**
 * Created by 丶 on 2017/9/14.
 */

public class WonderfulMomentModelImpl implements WonderfulMomentModel {
    @Override
    public void getWonderFu(MyNetWorkCallback<WonderfuMomentBean> callback) {
        int pagr = 1;
        iHttp.get(UrlsUtils.Wonderful,null,callback);
    }
}
