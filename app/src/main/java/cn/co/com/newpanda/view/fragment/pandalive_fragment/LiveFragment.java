package cn.co.com.newpanda.view.fragment.pandalive_fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.adapter.pandalive_adapter.bottonlive_adapter.MyViewPagerAdapter;
import cn.co.com.newpanda.base.BaseFragment;
import cn.co.com.newpanda.view.fragment.pandalive_fragment.bottonlive_fragment.MuchliveFragment;
import cn.co.com.newpanda.view.fragment.pandalive_fragment.bottonlive_fragment.SeechatFragment;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * A simple {@link Fragment} subclass.
 */
public class LiveFragment extends BaseFragment implements TabLayout.OnTabSelectedListener {

    int image[] = new int[]{
            R.mipmap.live_china_detail_down,
            R.mipmap.live_china_detail_up
    };
    int i = 0;
    int count = 0;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.bridf)
    TextView bridf;
    @BindView(R.id.pandaTitle)
    TextView pandaTitle;
    Unbinder unbinder;
    @BindView(R.id.pandaZK)
    ImageView pandaZK;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.pandaLiveJCVideo)
    JCVideoPlayer pandaLiveJCVideo;
    private List<Fragment> fragments = new ArrayList<>();
    private String[] titles = new String[]{"多视角直播", "边看边聊"};
    private MuchliveFragment muchliveFragment;
    private SeechatFragment seechatFragment;
    private View rootView;

    private MyViewPagerAdapter viewPagerAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_live;
    }

    @Override
    protected void init(View view) {


    }

    @Override
    protected void loadData() {
        muchliveFragment = new MuchliveFragment();
        seechatFragment = new SeechatFragment();
        tabLayout.setOnTabSelectedListener(this);

        fragments.add(muchliveFragment);
        fragments.add(seechatFragment);
        viewPagerAdapter = new MyViewPagerAdapter(getChildFragmentManager(), titles, fragments);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }


/*
pandaTitle.setText("[正在直播]" + pandaLiveBean.getLive().get(0).getTitle());
zkName.setText(pandaLiveBean.getLive().get(0).getBrief());
String videoUrl="http://ipanda.vtime.cntv.cloudcdn.net/live/ipandahls_/index.m3u8?AUTH=aWlpj1YkabVe7sjrBFGz4qTnHjUNVRbYCytsKFFHkxMIs48f8K6oQFzcJu9o+PGbza+plcak5wb265g/m/TD+g==";
liveJCV.setUp(videoUrl,pandaLiveBean.getLive().get(0).getTitle(),true);
Glide.with(App.mContext).load(pandaLiveBean.getLive().get(0).getImage()).into(liveJCV.ivThumb);
 */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        String videoUrl="http://ipanda.vtime.cntv.cloudcdn.net/live/ipandahls_/index.m3u8?AUTH=aWlpj1YkabVe7sjrBFGz4qTnHjUNVRbYCytsKFFHkxMIs48f8K6oQFzcJu9o+PGbza+plcak5wb265g/m/TD+g==";
        pandaLiveJCVideo.setUp(videoUrl, "");

        pandaZK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.pandaZK:
                        switch (i) {
                            case 0:
                                i = 1;
                                bridf.setText("翻身、吃饭、睡觉、喝奶、打闹、攀爬……这里是成都大熊猫繁育研究基地，24小时高清直播大熊猫生活实况的地方。成年园、幼年园、幼儿园、母子园、一号别墅，11路直播信号28个摄像头，让你零距离了解国宝们的日常起居。");
                                bridf.setVisibility(View.VISIBLE);
                                break;
                            case 1:
                                i = 0;
                                bridf.setVisibility(View.GONE);
                                break;
                        }
                        pandaZK.setImageResource(image[++count % image.length]);
                        break;
                }
            }
        });
        return rootView;

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onPause() {
        super.onPause();
//        pandaLiveJCVideo.releaseAllVideos();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

}
