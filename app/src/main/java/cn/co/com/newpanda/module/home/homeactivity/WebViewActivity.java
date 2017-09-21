package cn.co.com.newpanda.module.home.homeactivity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.model.entity.homeBean.InfoBean;
import cn.co.com.newpanda.module.home.homebase.Base_Activity;

public class WebViewActivity extends Base_Activity implements UMShareListener {


    @BindView(R.id.web_finish)
    ImageView webFinish;
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
        webToolbar.inflateMenu(R.menu.webright);
        webToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            private PopupWindow popupWindow;
            private Button popup_finish;
            private RadioGroup popup_moments;
            private RadioGroup popup_wechat;
            private RadioGroup popup_sinawebo;
            private RadioGroup popup_twitter;
            private RadioGroup popup_fab;

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                    View inflate = View.inflate(WebViewActivity.this, R.layout.popup_item, null);
                popupWindow = new PopupWindow(inflate, ViewGroup.MarginLayoutParams.MATCH_PARENT,
                        ViewGroup.MarginLayoutParams.WRAP_CONTENT,false);
                    popupWindow.setFocusable(false);
                    popupWindow.setOutsideTouchable(false);
//                    ColorDrawable dw = new ColorDrawable(0x30000000);
//                    popupWindow.setBackgroundDrawable(dw);
                    popupWindow.showAtLocation(webToolbar, Gravity.BOTTOM,0,0);

                    initPopup(inflate);
                    return true;
            }

            private void initPopup(View inflate) {
                RadioGroup pofab = inflate.findViewById(R.id.popup_fab);
                RadioGroup pomoments = inflate.findViewById(R.id.popup_moments);
                RadioGroup posinawebo = inflate.findViewById(R.id.popup_sinawebo);
                RadioGroup potwitter = inflate.findViewById(R.id.popup_twitter);
                RadioGroup powechat = inflate.findViewById(R.id.popup_wechat);
                Button button = inflate.findViewById(R.id.popup_finish);

                pofab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(WebViewActivity.this, "1111111111", Toast.LENGTH_SHORT).show();
                    }
                });
                potwitter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        UMImage umImage = new UMImage(WebViewActivity.this,R.mipmap.abc);
                        UMWeb umWeb = new UMWeb(url);
                        umWeb.setTitle(title);
                        umWeb.setThumb(umImage);
                        new ShareAction(WebViewActivity.this)
                                .setPlatform(SHARE_MEDIA.QQ)//传入平台
                                .withMedia(umWeb)
                                .setCallback(WebViewActivity.this)//回调监听器
                                .share();
                    }
                });
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                    }
                });
            }
        });
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onStart(SHARE_MEDIA share_media) {

    }

    @Override
    public void onResult(SHARE_MEDIA share_media) {

    }

    @Override
    public void onError(SHARE_MEDIA share_media, Throwable throwable) {

    }

    @Override
    public void onCancel(SHARE_MEDIA share_media) {

    }
}
