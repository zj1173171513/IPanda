package cn.co.com.newpanda.presenter;

import android.util.Log;

import cn.co.com.newpanda.model.biz.VideoActivityModel;
import cn.co.com.newpanda.model.biz.VideoActivityModelImpl;
import cn.co.com.newpanda.model.entity.pandaliveBean.VideoBeans;
import cn.co.com.newpanda.module.home.contract.VideoContract;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;

/**
 * Created by 丶 on 2017/9/20.
 */

public class VideoActivityPresenter implements VideoContract.ActivityPresnter {
    private VideoActivityModel videoActivityModel;
    private VideoContract.View viewModel;

    public VideoActivityPresenter(VideoContract.View viewModel) {
        this.viewModel = viewModel;
        this.viewModel.setPresenter(this);
        videoActivityModel = new VideoActivityModelImpl();

    }

    @Override
    public void start() {
//        Log.e("sssss"+"-------","ssss");
        videoActivityModel.getVideoActivityModel(new MyNetWorkCallback<VideoBeans>() {
            @Override
            public void onSuccess(VideoBeans videoBeans) {

                viewModel.setResult(videoBeans);
                Log.e("aaaaa", videoBeans.toString());
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                viewModel.showMessage(errorMsg);
            }
        });
    }
}
