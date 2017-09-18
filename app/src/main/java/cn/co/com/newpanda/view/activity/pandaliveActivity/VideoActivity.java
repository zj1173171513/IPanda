package cn.co.com.newpanda.view.activity.pandaliveActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cn.co.com.newpanda.R;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class VideoActivity extends AppCompatActivity {

    private JCVideoPlayer pandalivevideo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        initView();
        initData();
    }


    private void initView() {
        pandalivevideo = (JCVideoPlayer) findViewById(R.id.pandalivevideo);
    }

    private void initData() {

        pandalivevideo.setUp("http://asp.cntv.lxdns.com/asp/hls/main/0303000a/3/default/b258dc46dd0044f9a66ab99345412822/main.m3u8?maxbr=4096","   ");
    }

}
