package cn.co.com.newpanda.view.activity.BillowingVideoActicity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import java.util.ArrayList;
import java.util.List;

import cn.co.com.newpanda.R;
import cn.co.com.newpanda.adapter.BillowingVideoadapter.BillowingbottomAdapter;
import cn.co.com.newpanda.model.entity.BillowingVideoBean.BillowingItemBean;
import cn.co.com.newpanda.model.entity.livechinaBean.ShuLiveChina;
import cn.co.com.newpanda.model.entity.livechinaBean.dao.DaoMaster;
import cn.co.com.newpanda.model.entity.livechinaBean.dao.DaoSession;
import cn.co.com.newpanda.model.entity.livechinaBean.dao.ShuLiveChinaDao;
import cn.co.com.newpanda.net.OkHttpUtils;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class ShiPinActivity extends AppCompatActivity implements UMShareListener {


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
    private ImageView fenxiang;
    private ImageView shoucang;
    private String Title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shi_pin);


        id = getIntent().getStringExtra("id");
        Title = getIntent().getStringExtra("name");
        initView();
        initData();
        initoperation();//对分享、收藏的操作
    }


    protected void initView() {
        jCVideoPlayer = (JCVideoPlayer) findViewById(R.id.videocontroller);
        jCVideoPlayer.setUp("http://asp.cntv.lxdns.com/asp/hls/main/0303000a/3/default/b258dc46dd0044f9a66ab99345412822/main.m3u8?maxbr=4096", "小爱熊猫");
        sanjiaohao = (ImageView) findViewById(R.id.butImg);
        textName = (TextView) findViewById(R.id.textName);

        fenxiang = (ImageView) findViewById(R.id.mFenxiang);
        shoucang = (ImageView) findViewById(R.id.mShoucang);
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
                jCVideoPlayer.setUp("http://asp.cntv.lxdns.com/asp/hls/main/0303000a/3/default/b258dc46dd0044f9a66ab99345412822/main.m3u8?maxbr=4096", "小熊猫");
            }
        });
    }

    private void initoperation() {
        fenxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UMImage umImage = new UMImage(ShiPinActivity.this, R.mipmap.abc);
                UMWeb umWeb = new UMWeb("http://www.lrts.me/playlist");
                umWeb.setTitle(Title);
                umWeb.setThumb(umImage);
                new ShareAction(ShiPinActivity.this)
                        .setPlatform(SHARE_MEDIA.QQ)//传入平台
                        .withMedia(umWeb)
                        .setCallback(ShiPinActivity.this)//回调监听器
                        .share();

            }
        });
        shoucang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(ShiPinActivity.this, "aaa.db");
                DaoMaster daoMaster = new DaoMaster(helper.getReadableDb());
                DaoSession daoSession = daoMaster.newSession();
                ShuLiveChinaDao shuLiveChinaDao = daoSession.getShuLiveChinaDao();
                ShuLiveChina shu = new ShuLiveChina(null, Title, null);
                shuLiveChinaDao.insert(shu);
                Toast.makeText(ShiPinActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public void onStart(SHARE_MEDIA share_media) {

    }

    @Override
    public void onResult(SHARE_MEDIA share_media) {

    }

    @Override
    public void onError(SHARE_MEDIA share_media, Throwable throwable) {

    }

    @Override
    public void onCancel(SHARE_MEDIA share_media) {

    }
}