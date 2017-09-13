package cn.co.com.newpanda.net;


public class HttpFactroy {
    public static IHttp create(){
        return OkHttpUtils.getInstance();
    }
}
