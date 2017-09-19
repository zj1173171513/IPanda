package cn.co.com.newpanda.app;

import android.app.Application;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import cn.co.com.newpanda.base.BaseActivity;


/**
 * Created by xingge on 2017/7/11.
 */

public class App extends Application {

//    去你大爷的你的

    public static BaseActivity context = null;
    {

        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
    }
    @Override
    public void onCreate() {
        super.onCreate();
        UMShareAPI.get(this);
    }
}
