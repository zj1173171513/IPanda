package cn.co.com.newpanda.view.fragment.pandalive_fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.adapter.pandalive_adapter.NewsAdapter;
import cn.co.com.newpanda.app.App;
import cn.co.com.newpanda.base.BaseFragment;
import cn.co.com.newpanda.model.entity.pandaliveBean.NewsBean;
import cn.co.com.newpanda.module.home.contract.NewsContract;
import cn.co.com.newpanda.view.activity.pandaliveActivity.VideoActivity;
import cn.co.com.newpanda.view.listview.MyListView;

/**
 * A simple {@link Fragment} subclass.
 */
public class OriginalNews extends BaseFragment implements NewsContract.View {

    NewsContract.NewsPresnter newsPresnter;
    @BindView(R.id.pandaLiveListView)
    MyListView pandaLiveListView;
    Unbinder unbinder;
    List<NewsBean.VideoBean> newsList = new ArrayList<>();
    private NewsAdapter newsAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_original_news;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {
        newsPresnter.start();
    }


    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void setResult(NewsBean newsBean) {
        newsList.addAll(newsBean.getVideo());
        newsAdapter = new NewsAdapter(App.context,R.layout.pandalive_list_item,newsList);
        pandaLiveListView.setAdapter(newsAdapter);

        pandaLiveListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(App.context, VideoActivity.class);
                intent.putExtra("position",i);
                intent.putExtra("vid", newsList.get(i).getVid());
                intent.putExtra("title", newsList.get(i).getT());
                intent.putExtra("data", newsList.get(i).getPtime());
                intent.putExtra("len", newsList.get(i).getLen());
                //Log.e("aaaaaa",pandaLiveList.get(i).getVid());
                intent.putExtra("urlIg", newsList.get(i).getImg());
                startActivity(intent);
            }
        });
    }

    @Override
    public void setPresenter(NewsContract.NewsPresnter newsPresnter) {
        this.newsPresnter = newsPresnter;
    }

    @Override
    public void showMessage(String msg) {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_original_news, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
