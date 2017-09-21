package cn.co.com.newpanda.view.activity.BoBao;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import cn.co.com.newpanda.R;
import cn.co.com.newpanda.config.Urls;
import cn.co.com.newpanda.model.entity.BoBaoBean.BoBaoLive;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BoBaoActivity extends AppCompatActivity {

    private JCVideoPlayer videoController;
    private String pid;
    private String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_bo_bao);
        videoController = (JCVideoPlayer) findViewById(R.id.videocontroller1);
        initIntent();
        initData();
    }
    private void initData() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(Urls.VIDEOPLAY + pid).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG", e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e("TAG", string);
                Gson gson = new Gson();
                BoBaoLive boBaoLive = gson.fromJson(string, BoBaoLive.class);
                final String url = boBaoLive.getVideo().getChapters().get(0).getUrl();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        videoController.setUp(url, title);
                    }
                });
            }
        });
    }
    private void initIntent() {
        Intent intent = getIntent();
        pid = intent.getStringExtra("pid");
        title = intent.getStringExtra("title");
//        Log.e("TAG",pid);
        Toast.makeText(this, ""+ pid, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {

        /**
         * 设置为横屏
         */
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        super.onResume();
    }

}



