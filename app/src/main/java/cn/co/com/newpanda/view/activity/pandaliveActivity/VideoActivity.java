package cn.co.com.newpanda.view.activity.pandaliveActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.model.entity.pandaliveBean.VideoBeans;
import cn.co.com.newpanda.module.home.contract.VideoContract;
import cn.co.com.newpanda.presenter.VideoActivityPresenter;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;


public class VideoActivity extends AppCompatActivity implements VideoContract.View {

    VideoContract.ActivityPresnter activityPresnter;
    @BindView(R.id.pandalivevideo)
    JCVideoPlayer pandalivevideo;

    public static String urls;
    public static String vid;
    private String title;
    private String data;
    private String len;
    private String urlIg;
    private String img;
    private int position;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//        }

        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);

        new VideoActivityPresenter(this);
        vid = getIntent().getStringExtra("vid");
        //position = getIntent().getIntExtra("position");
        title = getIntent().getStringExtra("title");
        data = getIntent().getStringExtra("data");
        len = getIntent().getStringExtra("len");
        urlIg = getIntent().getStringExtra("urlIg");
        activityPresnter.start();


    }

//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
//            View decorView = getWindow().getDecorView();
//            decorView.setSystemUiVisibility(
//                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
//        }
//    }

    @Override
    public void setPresenter(VideoContract.ActivityPresnter videoPresenter) {
        this.activityPresnter = videoPresenter;

    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void setResult(final VideoBeans videoBeans) {
        Log.e("cccccc", "++++++++++");
        urls = videoBeans.getVideo().getChapters().get(0).getUrl();
        img = videoBeans.getVideo().getChapters().get(0).getImage();
        pandalivevideo.setUp(urls, title);

    }


    @Override
    public void showMessage(String msg) {

    }


    @Override
    protected void onPause() {
        super.onPause();
        pandalivevideo.releaseAllVideos();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
