package cn.co.com.newpanda.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import cn.co.com.newpanda.R;

public class landfallActivity extends AppCompatActivity implements View.OnClickListener, UMAuthListener {

    private LinearLayout landfall_wechat;
    private LinearLayout landfall_QQ;
    private LinearLayout landfall_sina_to;
    private EditText landfall_number;
    private EditText landfall_Pwd;
    private Button landfall_landfall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landfall);
        initView();
        initData();


    }

    private void initView() {
        landfall_wechat = (LinearLayout) findViewById(R.id.landfall_wechat);    //微信
        landfall_QQ = (LinearLayout) findViewById(R.id.landfall_QQ);    //QQ
        landfall_sina_to = (LinearLayout) findViewById(R.id.landfall_sina_to);    //微博
        landfall_number = (EditText) findViewById(R.id.landfall_number);//账号
        landfall_Pwd = (EditText) findViewById(R.id.landfall_Pwd);//密码
        landfall_landfall = (Button) findViewById(R.id.landfall_landfall);//登陆按钮

        landfall_landfall.setOnClickListener(this);
    }

    private void initData() {
        landfall_QQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UMShareAPI.get(landfallActivity.this).getPlatformInfo(landfallActivity.this, SHARE_MEDIA.QQ, landfallActivity.this);

            }
        });
        landfall_sina_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UMShareAPI.get(landfallActivity.this).getPlatformInfo(landfallActivity.this, SHARE_MEDIA.SINA, landfallActivity.this);
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.landfall_landfall:
                submit();
                break;
        }
    }


    private void submit() {
        // validate
        String number = landfall_number.getText().toString().trim();
        if (TextUtils.isEmpty(number)) {
            Toast.makeText(this, "账号:请输入邮箱或手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        String Pwd = landfall_Pwd.getText().toString().trim();
        if (TextUtils.isEmpty(Pwd)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        // TODO validate success, do something

    }

    @Override
    public void onStart(SHARE_MEDIA share_media) {

    }

    @Override
    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
        String iconurl = map.get("iconurl");
        Intent intent = new Intent(this,PersonalActivity.class);
        intent.putExtra("iconurl",iconurl);
        startActivity(intent);
        finish();
    }

    @Override
    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

    }

    @Override
    public void onCancel(SHARE_MEDIA share_media, int i) {

    }
}
