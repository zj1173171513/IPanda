package cn.co.com.newpanda.model.biz;

import cn.co.com.newpanda.config.UrlsUtils;
import cn.co.com.newpanda.model.entity.pandaliveBean.VideoBeans;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;

import static cn.co.com.newpanda.view.activity.pandaliveActivity.VideoActivity.vid;

/**
 * Created by 丶 on 2017/9/20.
 */

public class VideoActivityModelImpl implements VideoActivityModel {
    @Override
    public void getVideoActivityModel(MyNetWorkCallback<VideoBeans> callback) {
        iHttp.get(UrlsUtils.URLK + vid, null, callback);
    }
}
