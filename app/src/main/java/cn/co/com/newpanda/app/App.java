package cn.co.com.newpanda.app;

import android.app.Application;
import android.content.Context;

import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.common.QueuedWork;

import cn.co.com.newpanda.base.BaseActivity;


/**
 * Created by xingge on 2017/7/11.
 */

public class App extends Application {

    public static BaseActivity context = null;


    public static Context mContext;
    public static int PAGER =1;

    public static Context getContext() {
        return context;
    }
    {

        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("906063583", "003aade4244b070ff9e26b9dec446894", "http://sns.whalecloud.com");
    }
    @Override
    public void onCreate() {
        super.onCreate();

//排队的工作
        QueuedWork.isUseThreadPool = false;

        UMShareAPI.get(this);
        Config.DEBUG = true;
    }




}
