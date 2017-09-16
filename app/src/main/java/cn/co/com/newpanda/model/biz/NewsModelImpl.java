package cn.co.com.newpanda.model.biz;

import cn.co.com.newpanda.config.UrlsUtils;
import cn.co.com.newpanda.model.entity.pandaliveBean.NewsBean;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;

/**
 * Created by 丶 on 2017/9/16.
 */

public class NewsModelImpl implements NewsModel {

    @Override
    public void getNewsModel(MyNetWorkCallback<NewsBean> callback) {
        iHttp.get(UrlsUtils.NEWS,null,callback);
    }
}
