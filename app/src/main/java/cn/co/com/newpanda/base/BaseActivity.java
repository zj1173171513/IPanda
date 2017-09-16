package cn.co.com.newpanda.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import cn.co.com.newpanda.app.App;


public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
        App.context =this;
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initView();
    }



    protected abstract int getLayoutId();
    protected abstract void initView();
}
