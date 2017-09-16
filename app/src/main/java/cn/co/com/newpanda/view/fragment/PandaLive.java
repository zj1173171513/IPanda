package cn.co.com.newpanda.view.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.adapter.pandalive_adapter.PandaLiveAdapter;
import cn.co.com.newpanda.base.BaseFragment;
import cn.co.com.newpanda.presenter.DonModelPresnter;
import cn.co.com.newpanda.presenter.LiveFragmentPresenter;
import cn.co.com.newpanda.presenter.NewsPresenter;
import cn.co.com.newpanda.presenter.PandaArchivesModelPresenter;
import cn.co.com.newpanda.presenter.SpecialPresenter;
import cn.co.com.newpanda.presenter.SuperMOEshowPresenter;
import cn.co.com.newpanda.presenter.ThingsPresenter;
import cn.co.com.newpanda.presenter.TopModelPresnter;
import cn.co.com.newpanda.presenter.WonderfulMomentPresenter;
import cn.co.com.newpanda.view.fragment.pandalive_fragment.DontLetTheMale;
import cn.co.com.newpanda.view.fragment.pandalive_fragment.LiveFragment;
import cn.co.com.newpanda.view.fragment.pandalive_fragment.OriginalNews;
import cn.co.com.newpanda.view.fragment.pandalive_fragment.PandaArchives;
import cn.co.com.newpanda.view.fragment.pandalive_fragment.PandaThoseThings;
import cn.co.com.newpanda.view.fragment.pandalive_fragment.PandaTopList;
import cn.co.com.newpanda.view.fragment.pandalive_fragment.Special;
import cn.co.com.newpanda.view.fragment.pandalive_fragment.SuperMOEshow;
import cn.co.com.newpanda.view.fragment.pandalive_fragment.WonderfulMoment;
import cn.co.com.newpanda.view.pager.NoScrollViewPager;


/**
 * Created by Administrator on 2017/9/12.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class PandaLive extends BaseFragment {


    @BindView(R.id.pandaLiveTly)
    TabLayout pandaLiveTly;
    @BindView(R.id.pandaLiveVip)
    NoScrollViewPager pandaLiveVip;
    Unbinder unbinder;
    LiveFragment liveFragment;
    WonderfulMoment wonderfulMoment;
    DontLetTheMale dontLetTheMale;
    SuperMOEshow superMOEshow;
    PandaArchives pandaArchives;
    PandaTopList pandaTopList;
    PandaThoseThings pandaThoseThings;
    Special special;
    OriginalNews originalNews;
    ArrayList<Fragment> list = new ArrayList<>();
    private PandaLiveAdapter pandaLiveAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.pandalive_fragment;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {
        liveFragment = new LiveFragment();
        wonderfulMoment = new WonderfulMoment();
        dontLetTheMale = new DontLetTheMale();
        superMOEshow = new SuperMOEshow();
        pandaArchives = new PandaArchives();
        pandaTopList = new PandaTopList();
        pandaThoseThings = new PandaThoseThings();
        special = new Special();
        originalNews = new OriginalNews();

        new LiveFragmentPresenter(liveFragment);
        new WonderfulMomentPresenter(wonderfulMoment);
        new DonModelPresnter(dontLetTheMale);
        new SuperMOEshowPresenter(superMOEshow);
        new PandaArchivesModelPresenter(pandaArchives);
        new TopModelPresnter(pandaTopList);
        new ThingsPresenter(pandaThoseThings);
        new SpecialPresenter(special);
        new NewsPresenter(originalNews);


        list.add(liveFragment);
        list.add(wonderfulMoment);
        list.add(dontLetTheMale);
        list.add(superMOEshow);
        list.add(pandaArchives);
        list.add(pandaTopList);
        list.add(pandaThoseThings);
        list.add(special);
        list.add(originalNews);

        pandaLiveAdapter = new PandaLiveAdapter(getChildFragmentManager(), list);
        pandaLiveVip.setAdapter(pandaLiveAdapter);
        pandaLiveTly.setTabMode(TabLayout.MODE_SCROLLABLE);
        pandaLiveTly.setupWithViewPager(pandaLiveVip);

        LinearLayout linearLayout = (LinearLayout) pandaLiveTly.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.layout_divider_vertical));
        linearLayout.setDividerPadding(dip2px(10));


    }

    //像素单位转换
    public int dip2px(int dip) {
        float density = getResources().getDisplayMetrics().density;
        return (int) (dip * density + 0.5);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @OnClick({R.id.pandaLiveTly, R.id.pandaLiveVip})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.pandaLiveTly:
                break;
            case R.id.pandaLiveVip:
                break;
        }
    }
}
