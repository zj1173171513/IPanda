package cn.co.com.newpanda.model.biz;

import cn.co.com.newpanda.model.entity.pandaliveBean.VideoBeans;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;

/**
 * Created by 丶 on 2017/9/20.
 */

public interface VideoActivityModel extends BaseModel {
    void getVideoActivityModel(MyNetWorkCallback<VideoBeans> callback);
}
