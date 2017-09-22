package cn.co.com.newpanda.module.home.homepresent;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.co.com.newpanda.app.AppService;
import cn.co.com.newpanda.model.entity.homeBean.CcAcBean;
import cn.co.com.newpanda.model.entity.homeBean.CcMpBean;
import cn.co.com.newpanda.model.entity.homeBean.HomeBean;
import cn.co.com.newpanda.model.entity.homeBean.InfoBean;
import cn.co.com.newpanda.model.entity.homeBean.Video_Bean;
import cn.co.com.newpanda.module.home.homehttp.OkHttpUtil;
import cn.co.com.newpanda.module.home.homeview.IGetView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static cn.co.com.newpanda.app.AppService.VIDEOPLAY;


/**
 * Created by ASUS on 2017/9/13.
 */

public class MPresenter {
    private IGetView iGetView;
    public MPresenter(IGetView iGetView) {
        this.iGetView = iGetView;
    }
    public void getData(){
        iGetView.showLoading();
        OkHttpUtil.getInstance().getRequest(AppService.INTER_UTL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                iGetView.toMainFail(e.toString());
                iGetView.dismisLoading();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                InfoBean infoBean = gson.fromJson(string, InfoBean.class);
                List<InfoBean> list = new ArrayList<InfoBean>();
                list.add(infoBean);
                iGetView.toMainSucceed(list);
                iGetView.dismisLoading();
            }
        });

    }

    public void getHomeData() {
        iGetView.showLoading();
        OkHttpUtil.getInstance().getRequest(AppService.HOME_UTL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                iGetView.toMainFail(e.toString());
                iGetView.dismisLoading();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                HomeBean homeBean = gson.fromJson(string, HomeBean.class);
                List<HomeBean> list = new ArrayList<HomeBean>();
                list.add(homeBean);
                iGetView.toMainSucceed(list);
                iGetView.dismisLoading();
            }
        });
    }

    public void getVideoData(String url) {
        OkHttpUtil.getInstance().getRequest(VIDEOPLAY+url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG",e.toString());
                iGetView.toMainFail(e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                Video_Bean homeBean = gson.fromJson(string, Video_Bean.class);
                List<Video_Bean> list = new ArrayList<Video_Bean>();
                list.add(homeBean);
                iGetView.toMainSucceed(list);
            }
        });
    }

    public void getCctvData(String url) {
        OkHttpUtil.getInstance().getRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG",e.toString());
                iGetView.toMainFail(e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                CcAcBean ccAcBean = gson.fromJson(string, CcAcBean.class);
                ArrayList<CcAcBean> ccAcBeens = new ArrayList<>();
                ccAcBeens.add(ccAcBean);
                iGetView.toMainSucceed(ccAcBeens);
            }
        });
    }

    public void getCctvVid(String vid) {
        OkHttpUtil.getInstance().getRequest(AppService.VIDEOPLAY + vid, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG",e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                CcMpBean ccMpBean = gson.fromJson(string, CcMpBean.class);
                ArrayList<CcMpBean> ccMpBeen = new ArrayList<>();
                ccMpBeen.add(ccMpBean);
                iGetView.toMainSucceed(ccMpBeen);

            }
        });
    }

    public void getWonData(final String won) {
        OkHttpUtil.getInstance().getRequest(won, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG",e.toString());
                iGetView.toMainFail(e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                CcAcBean wonbean = gson.fromJson(string, CcAcBean.class);
                ArrayList<CcAcBean> ccMpBeen = new ArrayList<>();
                ccMpBeen.add(wonbean);
                iGetView.toMainSucceed(ccMpBeen);

            }
        });
    }
}
