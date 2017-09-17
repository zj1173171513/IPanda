package cn.co.com.newpanda.module.home.homebase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ASUS on 2017/9/13.
 */

public abstract class Base_Activity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        initView();
        initClick();
        initData();
        initAdapter();
    }

    protected abstract void initAdapter();
    public abstract int initLayout();
    public abstract void initView();
    public abstract void initData();
    public abstract void initClick();

}
