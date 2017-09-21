
package cn.co.com.newpanda.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.co.com.newpanda.R;
import cn.co.com.newpanda.adapter.shoucangadapter.shoucangadapter;
import cn.co.com.newpanda.view.fragment.shoucang.jingcaikandianFragment;
import cn.co.com.newpanda.view.fragment.shoucang.zhiboFragment;

public class ShouCangActivity extends AppCompatActivity {
    List<String> listString = new ArrayList<>();
    List<Fragment> listFragment = new ArrayList<>();
    private TabLayout tablayout;
    private ViewPager viewpager;
    private TextView bianji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shou_cang);
        initView();
        initData();
    }

    private void initView() {
        tablayout = (TabLayout) findViewById(R.id.tablayout);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        bianji = (TextView) findViewById(R.id.shoucang_bianji);
    }

    private void initData() {
        listString.add("直播");
        listString.add("精彩看点");

        listFragment.add(new zhiboFragment());
        listFragment.add(new jingcaikandianFragment());

        shoucangadapter fPtAdapter = new shoucangadapter(this.getSupportFragmentManager(), listFragment, listString);
        viewpager.setAdapter(fPtAdapter);
        tablayout.setupWithViewPager(viewpager);
        viewpager.setCurrentItem(0);


    }
}
