package cn.co.com.newpanda.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import cn.co.com.newpanda.model.entity.livechinaBean.ShuLiveChina;

/**
 * Created by Administrator on 2017/09/14.
 */

public class LiveChinaStatePagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> listfrag;
    private List<ShuLiveChina> listdao;

    public LiveChinaStatePagerAdapter(FragmentManager fm, List<Fragment> listfrag, List<ShuLiveChina> listdao) {
        super(fm);
        this.listfrag = listfrag;
        this.listdao = listdao;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = listfrag.get(position);
        return fragment;
    }
    @Override
    public int getCount() {
        return listdao.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = listdao.get(position).getTitle();
        return title;
    }

}
