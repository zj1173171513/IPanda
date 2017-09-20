package cn.co.com.newpanda.view.activity.BillowingVideoActicity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.base.BaseActivity;
import cn.co.com.newpanda.config.Urls;
import cn.co.com.newpanda.model.entity.BillowingVideoBean.BillowingMoveBean;
import cn.co.com.newpanda.net.HttpUtils;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class toushipinActivity extends BaseActivity {

    @BindView(R.id.mVideoview)
    JCVideoPlayer mVideoview;

    private String url;
    private String title;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_toushipin;
    }

    @Override
    protected void initView() {

        String pid = getIntent().getStringExtra("pid");
        Log.e("TAG", pid);

        HttpUtils.doGet(Urls.MOVIE + "?pid=" + pid, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String string = response.body().string();
                Log.e("TAG", string);
                Gson gson = new Gson();
                BillowingMoveBean billowingMoveBean = gson.fromJson(string, BillowingMoveBean.class);
                Log.e("TAG", "0000000000000000000" + billowingMoveBean.toString());
                title = billowingMoveBean.getTitle();
                Log.e("Tag", "title====" + title);
                List<BillowingMoveBean.VideoBean.ChaptersBean> chapters = billowingMoveBean.getVideo().getChapters();
                url = chapters.get(0).getUrl();
                Log.e("Tag", "url====" + url);

            }
        });

        mVideoview.setUp(url, title);
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
