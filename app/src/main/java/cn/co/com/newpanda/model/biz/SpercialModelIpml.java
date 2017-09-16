package cn.co.com.newpanda.model.biz;

import cn.co.com.newpanda.config.UrlsUtils;
import cn.co.com.newpanda.model.entity.pandaliveBean.SpecialBean;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;

/**
 * Created by 丶 on 2017/9/16.
 */

public class SpercialModelIpml implements SpecialModel{
    @Override
    public void getSpecialModel(MyNetWorkCallback<SpecialBean> callback) {
        iHttp.get(UrlsUtils.PROGREM,null,callback);
    }
}
