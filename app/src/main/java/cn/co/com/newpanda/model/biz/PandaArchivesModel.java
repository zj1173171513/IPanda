package cn.co.com.newpanda.model.biz;

import cn.co.com.newpanda.model.entity.pandaliveBean.PandaArchivesBean;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;

/**
 * Created by 丶 on 2017/9/15.
 */
public interface PandaArchivesModel extends BaseModel {

    void getPandaArchivesModel(MyNetWorkCallback<PandaArchivesBean> callback);
}
