package cn.co.com.newpanda.view.activity.BillowingVideoActicity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import cn.co.com.newpanda.R;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class ShiPinActivity extends AppCompatActivity {

    private JCVideoPlayer jCVideoPlayer;
    private ImageView sanjiaohao;
    private ListView shipinlistview;
    private String url;
    int ABS = 0;
    private TextView textName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shi_pin);

        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        initView();
        initData();
    }


    protected void initView() {
        jCVideoPlayer = (JCVideoPlayer) findViewById(R.id.videocontroller);

        sanjiaohao = (ImageView) findViewById(R.id.butImg);
        textName = (TextView) findViewById(R.id.textName);
        shipinlistview = (ListView) findViewById(R.id.shipinlistview);
        textName.setVisibility(View.GONE);

        sanjiaohao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.butImg:
                        switch (ABS) {
                            case 0:
                                ABS = 1;
                                textName.setText("显示");
                                textName.setVisibility(View.VISIBLE);

                                break;
                            case 1:
                                ABS = 0;
                                textName.setText("隐藏");
                                textName.setVisibility(View.GONE);
                                break;
                        }
                        break;
                }
            }
        });
    }

    private void initData() {
      /*  OkHttpUtils.getInstance().get(Urls.PINJIE3 + url, null, new MyNetWorkCallback<aa>() {
            @Override
            public void onSuccess(aa aa) {
                String url = aa.getVideo().getChapters().get(0).getUrl();
                String title = aa.getTitle();
                jCVideoPlayer.setUp(url, title);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });*/
        jCVideoPlayer.setUp("http://asp.cntv.lxdns.com/asp/hls/main/0303000a/3/default/b258dc46dd0044f9a66ab99345412822/main.m3u8?maxbr=4096", "小爱熊猫");
    }
}
