package cn.co.com.newpanda.module.home.homeactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.co.com.newpanda.R;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class HomeLiveActivity extends AppCompatActivity {

    @BindView(R.id.homelivejc)
    JCVideoPlayer homelivejc;
    private String title;

    @Override
    protected void onPause() {
        JCVideoPlayer.releaseAllVideos();
        super.onPause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_live);
        ButterKnife.bind(this);
        initIntent();
    }
    private void initIntent() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        title = intent.getStringExtra("title");
        homelivejc.setUp(url, title);
        homelivejc.setFocusable(false);
        homelivejc.ivStart.performClick();
    }


}
