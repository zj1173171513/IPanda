package cn.co.com.newpanda.module.home.homeactivity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.model.entity.homeBean.InfoBean;
import cn.co.com.newpanda.module.home.homebase.Base_Activity;

public class WebViewActivity extends Base_Activity {


    @BindView(R.id.web_finish)
    TextView webFinish;
    @BindView(R.id.web_title)
    TextView webTitle;
    @BindView(R.id.web_toolbar)
    Toolbar webToolbar;
    @BindView(R.id.web_webview)
    WebView webWebview;
    @BindView(R.id.web_linearlayout)
    LinearLayout webLinearlayout;
    private InfoBean.InteractiveBean list;
    private String title;
    private String url;

    @Override
    protected void initAdapter() {

    }

    @Override
    public int initLayout() {
        return R.layout.activity_web_view;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        url = intent.getStringExtra("url");
        webWebview.loadUrl(url);
        webTitle.setText(title);
        WebSettings settings = webWebview.getSettings();
        settings.setJavaScriptEnabled(true);
    }

    @Override
    public void initClick() {
        webFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webLinearlayout.removeView(webWebview);
                webWebview.destroy();
                finish();
            }
        });

    }

}
