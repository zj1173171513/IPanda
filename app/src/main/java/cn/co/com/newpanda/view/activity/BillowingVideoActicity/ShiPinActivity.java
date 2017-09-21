package cn.co.com.newpanda.view.activity.BillowingVideoActicity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.co.com.newpanda.R;
import cn.co.com.newpanda.adapter.BillowingVideoadapter.BillowingbottomAdapter;
import cn.co.com.newpanda.model.entity.BillowingVideoBean.BillowingItemBean;
import cn.co.com.newpanda.net.OkHttpUtils;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class ShiPinActivity extends AppCompatActivity {


    int count = 0;
    private JCVideoPlayer jCVideoPlayer;
    private ImageView sanjiaohao;
    private ListView shipinlistview;
    int ABS = 0;
    private TextView textName;
    private String id;
    int image[] = new int[]{
            R.mipmap.live_china_detail_down,
            R.mipmap.live_china_detail_up
    };

    private List<BillowingItemBean.VideoBean> list = new ArrayList<>();
    private String url;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shi_pin);


        id = getIntent().getStringExtra("id");
        initView();
        initData();
    }


    protected void initView() {
        jCVideoPlayer = (JCVideoPlayer) findViewById(R.id.videocontroller);
        jCVideoPlayer.setUp("http://asp.cntv.lxdns.com/asp/hls/main/0303000a/3/default/b258dc46dd0044f9a66ab99345412822/main.m3u8?maxbr=4096", "小爱熊猫");
        sanjiaohao = (ImageView) findViewById(R.id.butImg);
        textName = (TextView) findViewById(R.id.textName);
        shipinlistview = (ListView) findViewById(R.id.shipinlistview);
        shipinlistview.setVisibility(View.VISIBLE);
        textName.setVisibility(View.GONE);
        sanjiaohao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.butImg:
                        switch (ABS) {
                            case 0:
                                ABS = 1;
                                textName.setText(name);
                                textName.setVisibility(View.VISIBLE);
                                break;
                        /*    case 1:
                                ABS = 0;
                                textName.setText("隐藏");
                                textName.setVisibility(View.GONE);
                                break;*/
                        }
                        sanjiaohao.setImageResource(image[++count % image.length]);
                        break;

                }
            }
        });
    }

    private void initData() {
        OkHttpUtils.getInstance().get("http://api.cntv.cn/video/videolistById?vsid=" + id + "&n=7&serviceId=panda&o=desc&of=time&p=", null, new MyNetWorkCallback<BillowingItemBean>() {
            @Override
            public void onSuccess(BillowingItemBean billowingItemBean) {

                list.addAll(billowingItemBean.getVideo());

                List<BillowingItemBean.VideoBean> video = billowingItemBean.getVideo();

                BillowingItemBean.VideosetBean videoset = billowingItemBean.getVideoset();
                //获取标题名
                name = videoset.get_$0().getName();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

                Log.e("Tag", "请求失败deBillowingbottomActivity=" + errorMsg);
            }
        });

        final BillowingbottomAdapter billowingbottomAdapter = new BillowingbottomAdapter(this, R.layout.billowing_bottom_item, list);
        shipinlistview.setAdapter(billowingbottomAdapter);
        shipinlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                url = list.get(i).getUrl();
                jCVideoPlayer.setUp(url, "小熊猫");
            }
        });
    }
}
