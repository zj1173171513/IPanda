package cn.co.com.newpanda.model.biz;

import cn.co.com.newpanda.model.entity.pandaliveBean.SuperMOEshowBean;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;

/**
 * Created by 丶 on 2017/9/15.
 */

public interface SuperMOEshowModel extends BaseModel {
    void getSuperMOEshow(MyNetWorkCallback<SuperMOEshowBean> callback);
}
