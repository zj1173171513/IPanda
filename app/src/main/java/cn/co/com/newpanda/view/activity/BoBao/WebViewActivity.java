package cn.co.com.newpanda.view.activity.BoBao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RelativeLayout;

import cn.co.com.newpanda.R;
import cn.co.com.newpanda.model.entity.BoBaoBean.PandaBroadcastInfoBean;

public class WebViewActivity extends AppCompatActivity {

    private WebView webview;
    private RelativeLayout activity_web_view2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view2);
        initView();
        Intent intent = getIntent();
        PandaBroadcastInfoBean.ListBean listBean = intent.getParcelableExtra("name");
        Log.e("TAG", listBean.getUrl());
        String id = listBean.getId();
        Log.e("URL",id);
        webview.loadUrl(listBean.getUrl());
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
    }

    private void initView() {
        webview = (WebView) findViewById(R.id.webview);
        webview.setInitialScale(39);
        activity_web_view2 = (RelativeLayout) findViewById(R.id.activity_web_view2);
        //方式1. 加载一个网页：
    }

}
