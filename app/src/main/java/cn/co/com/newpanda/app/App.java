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

    @Override
    public void onCreate() {
        super.onCreate();

//排队的工作
        QueuedWork.isUseThreadPool = false;

        UMShareAPI.get(this);
        Config.DEBUG =true;
//分享平台
        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "9c29cc8bc30f5edc087bde312ef083a1","http://sns.whalecloud.com");


        mContext =getApplicationContext();
    }



    /**
     * 获取全局的Context
     * @return
     */
    public static Context getContext(){
        return context;
    }

}
