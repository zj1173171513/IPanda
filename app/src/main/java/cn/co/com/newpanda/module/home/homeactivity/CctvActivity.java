package cn.co.com.newpanda.module.home.homeactivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.app.AppService;
import cn.co.com.newpanda.model.entity.homeBean.CcAcBean;
import cn.co.com.newpanda.model.entity.homeBean.CcMpBean;
import cn.co.com.newpanda.module.home.adapter.CcTvTabAdapter;
import cn.co.com.newpanda.module.home.homebase.Base_Activity;
import cn.co.com.newpanda.module.home.homefragment.PdFragment;
import cn.co.com.newpanda.module.home.homefragment.WonderfulFragment;
import cn.co.com.newpanda.module.home.homehttp.OkHttpUtil;
import cn.co.com.newpanda.module.home.homepresent.MPresenter;
import cn.co.com.newpanda.module.home.homeview.IGetView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class CctvActivity extends Base_Activity implements IGetView<CcAcBean>, UMShareListener {

    @BindView(R.id.cctv_jcvideo)
    JCVideoPlayer cctvJcvideo;
    @BindView(R.id.cctv_shou)
    TextView cctvShou;
    @BindView(R.id.cctv_time)
    TextView cctvTime;
    @BindView(R.id.cctv_img)
    ImageView cctvImg;
    @BindView(R.id.cctv_viewpager)
    ViewPager cctvViewpager;
    @BindView(R.id.cctv_finish)
    ImageView cctvFinish;
    @BindView(R.id.cctv_title)
    TextView cctvTitle;
    @BindView(R.id.cctv_content)
    TextView cctvContent;
    @BindView(R.id.cctv_tab)
    TabLayout cctvTab;
    @BindView(R.id.cctv_img_collect)
    ImageView cctvImgCollect;
    @BindView(R.id.cctv_img_share)
    ImageView cctvImgShare;
    private MPresenter mPresenter;
    private int tag = 0;
    private ArrayList<String> list;
    private ArrayList<Fragment> fragments;
    private BroadcastReceiver rece = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String vid = intent.getStringExtra("vid");
//            mPresenter.getCctvVid(vid);
            OkHttpUtil.getInstance().getRequest(AppService.VIDEOPLAY + vid, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.e("TAG", e.toString());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String string = response.body().string();
                    Gson gson = new Gson();
                    final CcMpBean ccMpBean = gson.fromJson(string, CcMpBean.class);
                    ArrayList<CcMpBean> ccMpBeen = new ArrayList<>();
                    ccMpBeen.add(ccMpBean);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String url = ccMpBean.getVideo().getChapters().get(0).getUrl();
                            cctvJcvideo.setUp(url, ccMpBean.getTitle());
                            cctvJcvideo.setFocusable(false);
                            cctvJcvideo.ivStart.performClick();
                        }
                    });
                }
            });
        }
    };
    private String won;
    private CcAcBean.VideosetBean videoset;
    private PopupWindow popupWindow;

    @Override
    protected void initAdapter() {

    }

    @Override
    public int initLayout() {
        return R.layout.activity_cctv;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        mPresenter = new MPresenter(this);
    }

    private void initTab() {
        list = new ArrayList<>();
        list.add("高清完整");
        list.add("精彩看点");

        fragments = new ArrayList<>();
        fragments.add(new PdFragment());
        fragments.add(new WonderfulFragment(won));

        cctvTab.addTab(cctvTab.newTab().setText(list.get(0)));
        cctvTab.addTab(cctvTab.newTab().setText(list.get(1)));

        cctvTab.setupWithViewPager(cctvViewpager);

        cctvViewpager.setAdapter(new CcTvTabAdapter(getSupportFragmentManager(), list, fragments));
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        //接收上个页面发过来的数据
        String cctv = intent.getStringExtra("cctv");
        won = intent.getStringExtra("won");
        int position = intent.getIntExtra("position", -1);

        mPresenter.getCctvData(cctv);


        //fragment 显示数据的广播注册（传回）
        IntentFilter filter = new IntentFilter("vid");
        registerReceiver(rece, filter);
        initTab();

        if (position == 0) {
            cctvJcvideo.setUp("http://vod.cntv.lxdns.com/flash/mp4video62/TMS/2017/09/21/fec8120b9d724686b6eea2f7b407b84f_h264418000nero_aac32-1.mp4", "");
            cctvJcvideo.setFocusable(false);
            cctvJcvideo.ivStart.performClick();
        } else if (position == 1) {
            cctvJcvideo.setUp("http://vod.cntv.lxdns.com/flash/mp4video62/TMS/2017/09/21/329e065f56dd4447b0251e7ccf6b4fd5_h264418000nero_aac32-1.mp4", "");
            cctvJcvideo.setFocusable(false);
            cctvJcvideo.ivStart.performClick();
        } else if (position == 2) {
            cctvJcvideo.setUp("http://vod.cntv.lxdns.com/flash/mp4video62/TMS/2017/09/21/11f73e7005ad45a38f944db07c6ad19c_h264418000nero_aac32-1.mp4", "");
            cctvJcvideo.setFocusable(false);
            cctvJcvideo.ivStart.performClick();
        } else if (position == 3) {
            cctvJcvideo.setUp("http://cntv.vod.cdn.myqcloud.com/flash/mp4video62/TMS/2017/09/21/b1c1a0a5539345bfb97aaabd5fe5d923_h264418000nero_aac32-1.mp4", "");
            cctvJcvideo.setFocusable(false);
            cctvJcvideo.ivStart.performClick();
        } else {
            Toast.makeText(this, "你穿的衣服好像不好看！换一件试试！", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void initClick() {
        cctvImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tag++;
                if (tag == 1) {
                    cctvContent.setVisibility(View.VISIBLE);
                    cctvImg.setImageResource(R.mipmap.com_facebook_tooltip_blue_topnub);
                } else {
                    cctvContent.setVisibility(View.GONE);
                    cctvImg.setImageResource(R.mipmap.com_facebook_tooltip_blue_bottomnub);
                    tag = 0;
                }
            }
        });

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismisLoading() {

    }

    @Override
    public void toMainSucceed(final List<CcAcBean> list) {
        videoset = list.get(0).getVideoset();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                cctvContent.setText(videoset.get_$0().getDesc());
                cctvTitle.setText(videoset.get_$0().getName());
                cctvTime.setText(videoset.get_$0().getSbsj());
                Intent intent = new Intent("pd");
                intent.putExtra("list", list.get(0));
                sendBroadcast(intent);

                cctvImgCollect.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tag++;
                        if (tag == 1){
                            cctvImgCollect.setImageResource(R.mipmap.collect_yes);
                            Toast.makeText(CctvActivity.this, "已添加，请到[我的收藏]中查看"+videoset.get_$0().getName(), Toast.LENGTH_SHORT).show();

                        }else {
                            cctvImgCollect.setImageResource(R.mipmap.collect_no);
                            Toast.makeText(CctvActivity.this, "已经取消收藏", Toast.LENGTH_SHORT).show();
                            tag = 0;
                        }
                    }
                });

                cctvImgShare.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        View inflate = View.inflate(CctvActivity.this, R.layout.popup_item, null);
                        popupWindow = new PopupWindow(inflate, ViewGroup.MarginLayoutParams.MATCH_PARENT,
                                ViewGroup.MarginLayoutParams.WRAP_CONTENT,false);
                        popupWindow.setFocusable(false);
                        popupWindow.setOutsideTouchable(false);
//                    ColorDrawable dw = new ColorDrawable(0x30000000);
//                    popupWindow.setBackgroundDrawable(dw);
                        popupWindow.showAtLocation(cctvImgShare, Gravity.BOTTOM,0,0);

                        initPopup(inflate);
                    }
                    private void initPopup(View inflate) {
                        RadioGroup pofab = inflate.findViewById(R.id.popup_fab);
                        RadioGroup pomoments = inflate.findViewById(R.id.popup_moments);
                        RadioGroup posinawebo = inflate.findViewById(R.id.popup_sinawebo);
                        RadioGroup potwitter = inflate.findViewById(R.id.popup_twitter);
                        RadioGroup powechat = inflate.findViewById(R.id.popup_wechat);
                        Button button = inflate.findViewById(R.id.popup_finish);

                        pofab.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //One分享
                                Toast.makeText(CctvActivity.this, "1111111111", Toast.LENGTH_SHORT).show();
                            }
                        });
                        pomoments.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //Two分享
                            }
                        });
                        posinawebo.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //Three分享
                            }
                        });
                        potwitter.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //Four分享

                            }
                        });

                        powechat.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //Fiv分享
                                Toast.makeText(CctvActivity.this, "1111111111", Toast.LENGTH_SHORT).show();
                                UMImage umImage = new UMImage(CctvActivity.this, list.get(0).getVideo().get(0).getImg());
                                UMWeb umWeb = new UMWeb(list.get(0).getVideo().get(0).getUrl());
                                umWeb.setTitle(list.get(0).getVideo().get(0).getT());
                                umWeb.setThumb(umImage);
                                new ShareAction(CctvActivity.this)
                                        .setPlatform(SHARE_MEDIA.QQ)//传入平台
                                        .withMedia(umWeb)
                                        .setCallback(CctvActivity.this)//回调监听器
                                        .share();
                            }
                        });

                        cctvFinish.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                finish();
                            }
                        });

                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //取消按钮
                                popupWindow.dismiss();
                            }
                        });
                    }
                });
            }
        });
    }

    @Override
    public void toMainFail(String e) {
        Toast.makeText(this, "" + e, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(rece);
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
