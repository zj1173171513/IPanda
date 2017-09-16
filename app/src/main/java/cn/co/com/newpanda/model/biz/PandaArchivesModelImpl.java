package cn.co.com.newpanda.model.biz;

import cn.co.com.newpanda.config.UrlsUtils;
import cn.co.com.newpanda.model.entity.pandaliveBean.PandaArchivesBean;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;

/**
 * Created by 丶 on 2017/9/15.
 */

public class PandaArchivesModelImpl implements PandaArchivesModel {
    @Override
    public void getPandaArchivesModel(MyNetWorkCallback<PandaArchivesBean> callback) {
        iHttp.get(UrlsUtils.PANDAFILE,null,callback);
    }
}
