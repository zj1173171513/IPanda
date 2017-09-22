package cn.co.com.newpanda.model.bobao.vedio;

import cn.co.com.newpanda.config.Urls;
import cn.co.com.newpanda.model.entity.BoBaoBean.PDBCInfotwoBean;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;



public class PDBCInfoModelImpl implements PDBCInfoModel{
    @Override
    public void getPDBCinfo(MyNetWorkCallback<PDBCInfotwoBean> callback) {
        iHttp.get(Urls.PDBCINFOURL,null,callback);
    }
}
