package cn.co.com.newpanda.view.activity.BoBao;

import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.app.App;
import cn.co.com.newpanda.base.BaseActivity;
import cn.co.com.newpanda.config.UMengUtls;
import cn.co.com.newpanda.model.entity.livechinaBean.dao.DaoMaster;
import cn.co.com.newpanda.model.entity.livechinaBean.dao.DaoSession;
import cn.co.com.newpanda.model.entity.livechinaBean.dao.DaoUtil;
import cn.co.com.newpanda.model.entity.livechinaBean.dao.SQLBeans;
import cn.co.com.newpanda.model.entity.livechinaBean.dao.SQLBeansDao;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class BoBaoActivity extends BaseActivity {

    @BindView(R.id.jiecaovedio)
    JCVideoPlayer jiecaovedio1;
    @BindView(R.id.image_shoucang)
    CheckBox imageShoucang;
    @BindView(R.id.image_share)
    CheckBox imageShare;
    @BindView(R.id.image_goback)
    ImageButton imageGoback;
    public static String id;
    private SQLiteDatabase w;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private SQLBeansDao sqlBeansDao;
    private SQLBeans sqlBeans;

    //设置播放器的全屏尺寸
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);


    @Override
    protected int getLayoutId() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
        return R.layout.activity_bo_bao;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        w = DaoUtil.getIn(App.getContext()).getW();
        daoMaster = new DaoMaster(w);
        daoSession = daoMaster.newSession();
        sqlBeansDao = daoSession.getSQLBeansDao();
        sqlBeans = new SQLBeans();
        //获取ImageLoader对象
        com.nostra13.universalimageloader.core.ImageLoader imageLoader= com.nostra13.universalimageloader.core.ImageLoader.getInstance();
        //使用默认的ImageLoaderConfiguration
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this.getApplicationContext());
        //初始化ImageLoader的配置
       imageLoader.init(configuration);

        final String url1 = getIntent().getStringExtra("url1");

        Log.e("VedioURL", url1);

        final String title = getIntent().getStringExtra("title");
        final String imageurl = getIntent().getStringExtra("imageurl");
        final String path = "http://vod.cntv.lxdns.com/flash/mp4video61/TMS/2017/09/14/29261a6b576f488a9124a7ded9d241d3_h264418000nero_aac32.mp4";
        jiecaovedio1.setUp(path, "            " + title);
        id = getIntent().getStringExtra("id1");
        imageShoucang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BoBaoActivity.this, "你点击了收藏", Toast.LENGTH_SHORT).show();
            }
        });

//    private void initData() {
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder().url(Urls.VIDEOPLAY + pid).build();
//        Call call = client.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.e("TAG", e.toString());
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String string = response.body().string();
//                Log.e("TAG", string);
//                Gson gson = new Gson();
//                BoBaoLive boBaoLive = gson.fromJson(string, BoBaoLive.class);
//                final String url = boBaoLive.getVideo().getChapters().get(0).getUrl();
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        jiecaovedio.setUp(url, title);
//                    }
//                });
//            }
//        });
//    }
//    private void initIntent() {
//        Intent intent = getIntent();
//        pid = intent.getStringExtra("pid");
//        title = intent.getStringExtra("title");
////        Log.e("TAG",pid);
//        Toast.makeText(this, ""+ pid, Toast.LENGTH_SHORT).show();
//    }

//    @Override
//    protected void onResume() {
//
//        /**
//         * 设置为横屏
//         */
//        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//        }
//
//        super.onResume();
//    }
        imageShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BoBaoActivity.this, "网络不是太给力哦", Toast.LENGTH_SHORT).show();
                UMImage imgs = new UMImage(App.context, imageurl);
                UMVideo video = new UMVideo("http://vod.cntv.lxdns.com/flash/mp4video61/TMS/2017/09/14/29261a6b576f488a9124a7ded9d241d3_h264418000nero_aac32.mp4");
                video.setTitle(title);//视频的标题
                video.setThumb(imgs);//视频的缩略图
                video.setDescription("PandaChannel");//视频的描述
                new ShareAction(BoBaoActivity.this)
                        .setPlatform(SHARE_MEDIA.QQ)//传入平台
                        .withMedia(video)
                        .setCallback(UMengUtls.shareListener)//回调监听器
                        .share();

            }
        });


        Log.e("VedioID", id);

//        Cursor pdbc = read.query("PDBC", null, null, null, null, null, null);
//        if (pdbc.moveToFirst()) {
//            do {
//                String vediourl = pdbc.getString(pdbc.getColumnIndex("vediourl"));
//                Log.e("Greendao",vediourl);
//            }while (pdbc.moveToNext());
//        }
//        pdbc.close();

    }


    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();

    }

    @Override
    protected void onResume() {
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        super.onResume();
    }


}





