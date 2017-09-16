package cn.co.com.newpanda.presenter;

import cn.co.com.newpanda.model.biz.NewsModel;
import cn.co.com.newpanda.model.biz.NewsModelImpl;
import cn.co.com.newpanda.model.entity.pandaliveBean.NewsBean;
import cn.co.com.newpanda.module.home.contract.NewsContract;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;

/**
 * Created by 丶 on 2017/9/16.
 */

public class NewsPresenter implements NewsContract.NewsPresnter{
    private NewsContract.View newsContractView;
    private NewsModel newsModel;

    public NewsPresenter(NewsContract.View newsContractView) {
        this.newsContractView = newsContractView;
        this.newsContractView.setPresenter(this);
        newsModel = new NewsModelImpl();
    }

    @Override
    public void start() {
        newsModel.getNewsModel(new MyNetWorkCallback<NewsBean>() {
            @Override
            public void onSuccess(NewsBean newsBean) {
                newsContractView.setResult(newsBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                newsContractView.showMessage(errorMsg);
            }
        });

    }
}
