package cn.co.com.newpanda.adapter.pandalive_adapter.bottonlive_adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 丶 on 2017/9/14.
 */

public class BottonTabAdapter extends FragmentPagerAdapter {
    String[] str = {"多视角直播", "边看边聊"};
    ArrayList<Fragment> list;

    public BottonTabAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return str[position];
    }
}
