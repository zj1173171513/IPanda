package cn.co.com.newpanda.model.biz;


import cn.co.com.newpanda.net.HttpFactroy;
import cn.co.com.newpanda.net.IHttp;

public interface BaseModel {
    public static IHttp iHttp = HttpFactroy.create();
}
