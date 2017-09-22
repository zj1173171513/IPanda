package cn.co.com.newpanda.app;

/**
 * Created by ASUS on 2017/9/13.
 */

public interface AppService {
    //个人互动地址
    public static final String INTER_UTL = "http://www.ipanda.com/kehuduan/PAGE14501767715521482/index.json";
    //首页Home地址
    public static final String HOME_UTL = "http://www.ipanda.com/kehuduan/PAGE14501749764071042/index.json";
    //视频地址
    public static final String VIDEOPLAY="http://115.182.35.91/api/getVideoInfoForCBox.do?pid=";
    //国宝档案 高清完整
    public static final String GUO_URL = "http://api.cntv.cn/video/videolistById?n=6&vsid=C14121&p=1&serviceId=panda&em=1";
    public static final String ZOU_URL = "http://api.cntv.cn/video/videolistById?n=6&vsid=C10352&p=1&serviceId=panda&em=1";
    public static final String HUA_URL = "http://api.cntv.cn/video/videolistById?n=6&vsid=C17604&p=1&serviceId=panda&em=1";
    public static final String ZHONG_URL = "http://api.cntv.cn/video/videolistById?n=6&vsid=C10471&p=1&serviceId=panda&em=1";

    //国宝档案 精彩看点
    public static final String GUO_WON = "http://api.cntv.cn/video/videolistById?n=6&vsid=C14121&p=1&serviceId=panda&em=2";
    public static final String ZOU_WON = "http://api.cntv.cn/video/videolistById?n=6&vsid=C10352&p=1&serviceId=panda&em=2";
    public static final String HUA_WON = "http://api.cntv.cn/video/videolistById?n=6&vsid=C17604&p=1&serviceId=panda&em=2";
    public static final String ZHONG_WON = "http://api.cntv.cn/video/videolistById?n=6&vsid=C10471&p=1&serviceId=panda&em=1";

    public static final String LIVE_URL="http://vdn.live.cntv.cn/api2/live.do?channel=pa://cctv_p2p_hd";
}
