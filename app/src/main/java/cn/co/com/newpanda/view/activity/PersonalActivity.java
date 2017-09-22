package cn.co.com.newpanda.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import cn.co.com.newpanda.R;

public class PersonalActivity extends AppCompatActivity {

    private LinearLayout personal_landfall;
    private LinearLayout personal_history;
    private LinearLayout personal_collect;
    private LinearLayout personal_setting;
    private ImageView iconurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        initView();
        initData();
        initIntent();
    }

    private void initIntent() {
        Intent intent = getIntent();
        String iconur = intent.getStringExtra("iconurl");
        if (iconur == null){
            return;
        }else {
            Glide.with(this).load(iconur).into(iconurl);
            Log.e("TAG",iconur);
        }
    }


    private void initView() {
        personal_landfall = (LinearLayout) findViewById(R.id.personal_landfall);
        personal_history = (LinearLayout) findViewById(R.id.personal_history);
        personal_collect = (LinearLayout) findViewById(R.id.personal_collect);
        personal_setting = (LinearLayout) findViewById(R.id.personal_setting);
        iconurl = (ImageView) findViewById(R.id.iconurl);
    }

    private void initData() {
        //点击登陆的跳转
        personal_landfall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PersonalActivity.this, landfallActivity.class));
            }
        });
        //点击设置的跳转
        personal_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PersonalActivity.this, settingActivity.class));
            }
        });
        personal_collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PersonalActivity.this, ShouCangActivity.class));
            }
        });
    }
}
