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

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    private List<Fragment> fragments = new ArrayList<>();


    public LiveFragment() {

    }

    @BindView(R.id.pandaTitle)
    TextView pandaTitle;
    Unbinder unbinder;
    @BindView(R.id.videocontroller1)
    JCVideoPlayer videocontroller1;
    @BindView(R.id.pandaZK)
    ImageView pandaZK;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    private MuchliveFragment muchliveFragment;
    private SeechatFragment seechatFragment;
    private View rootView;
    private String[] titles = new String[]{"多视角直播", "边看边聊"};
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

//        tabLayout.addTab(tabLayout.newTab().setText("多视角直播"));
//        tabLayout.addTab(tabLayout.newTab().setText("边看边聊"));
        tabLayout.setOnTabSelectedListener(this);

        fragments.add(muchliveFragment);
        fragments.add(seechatFragment);
        viewPagerAdapter = new MyViewPagerAdapter(getChildFragmentManager(), titles, fragments);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);

        pandaZK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }


}
