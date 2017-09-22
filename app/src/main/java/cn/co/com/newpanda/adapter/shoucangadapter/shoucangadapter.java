package cn.co.com.newpanda.adapter.shoucangadapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by lihan on 2017/9/20.
 */

public class shoucangadapter extends FragmentPagerAdapter {
    List<Fragment> listFragment;
    List<String> listString;

    public shoucangadapter(FragmentManager supportFragmentManager, List<Fragment> listFragment, List<String> listString) {
        super(supportFragmentManager);
        this.listFragment = listFragment;
        this.listString = listString;
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listString.get(position);
    }
}
