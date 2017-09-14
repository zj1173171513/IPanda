package cn.co.com.newpanda;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.co.com.newpanda.base.BaseActivity;
import cn.co.com.newpanda.view.activity.TwoActivity;

/**
 * 张泽彪修改
 * 二次哦
 */

/**
 * 张晓阳修改
 * 一次哦
 */

/*
* 李翰我欣赏
* 无数次了
* */

    /*
    *
    *
    *
    * */
public class MainActivity extends BaseActivity {


    @BindView(R.id.mainImg)
    ImageView mainImg;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        //CountDownTimer构造器的两个参数分别是第一个参数表示总时间，第二个参数表示间隔时间。
        //意思就是每隔xxx会回调一次方法onTick，然后xxx之后会回调onFinish方法。
        CountDownTimer timer = new CountDownTimer(3200, 1000) {
            int num = 2;

            @Override
            public void onTick(long millisUntilFinished) {
                num--;
            }

            @Override
            public void onFinish() {
                //计时完成调用
                Intent i = new Intent(MainActivity.this, TwoActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                finish();
            }
        };
        timer.start();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }


}
