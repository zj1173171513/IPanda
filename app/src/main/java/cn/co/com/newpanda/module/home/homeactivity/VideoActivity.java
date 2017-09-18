package cn.co.com.newpanda.module.home.homeactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.model.entity.homeBean.Video_Bean;
import cn.co.com.newpanda.module.home.homepresent.MPresenter;
import cn.co.com.newpanda.module.home.homeview.IGetView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class VideoActivity extends AppCompatActivity implements IGetView<Video_Bean> {


    @BindView(R.id.pandalivevideo)
    JCVideoPlayer pandalivevideo;
    @BindView(R.id.activity_video)
    LinearLayout activityVideo;
    private MPresenter mPresenter;
    private String title;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);
        mPresenter = new MPresenter(this);
        initIntent();

    }

    private void initIntent() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        title = intent.getStringExtra("title");
        Log.e("TAG", url);
        mPresenter.getVideoData(url);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismisLoading() {

    }

    @Override
    public void toMainSucceed(List<Video_Bean> list) {
        for (int i = 0; i < list.size(); i++) {
            url = list.get(i).getVideo().getChapters().get(0).getUrl();
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                pandalivevideo.setUp(url, title);
            }
        });
    }

    @Override
    public void toMainFail(String e) {

    }
}
