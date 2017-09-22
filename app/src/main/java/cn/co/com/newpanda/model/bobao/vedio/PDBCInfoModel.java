package cn.co.com.newpanda.model.bobao.vedio;


import cn.co.com.newpanda.model.biz.BaseModel;
import cn.co.com.newpanda.model.entity.BoBaoBean.PDBCInfotwoBean;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;



public interface PDBCInfoModel extends BaseModel {

    void getPDBCinfo(MyNetWorkCallback<PDBCInfotwoBean> callback);

}
