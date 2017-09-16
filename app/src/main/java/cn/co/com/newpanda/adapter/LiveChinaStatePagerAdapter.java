package cn.co.com.newpanda.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import cn.co.com.newpanda.model.entity.LiVeChinaBean;

/**
 * Created by Administrator on 2017/09/14.
 */

public class LiveChinaStatePagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> listfrag;
    private List<LiVeChinaBean.TablistBean> listtablistBeen;


    public LiveChinaStatePagerAdapter(FragmentManager fm, List<Fragment> listfrag, List<LiVeChinaBean.TablistBean> listtablistBeen) {
        super(fm);
        this.listfrag = listfrag;
        this.listtablistBeen = listtablistBeen;
    }

    @Override
    public Fragment getItem(int position) {

        return listfrag.get(position);
    }
    @Override
    public int getCount() {
        return listtablistBeen.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listtablistBeen.get(position).getTitle();
    }
}
