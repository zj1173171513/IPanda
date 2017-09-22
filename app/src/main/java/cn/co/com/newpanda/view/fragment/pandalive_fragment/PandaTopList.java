package cn.co.com.newpanda.view.fragment.pandalive_fragment;

import android.content.Intent;
import android.os.Bundle;
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
import cn.co.com.newpanda.adapter.pandalive_adapter.TopAdapter;
import cn.co.com.newpanda.app.App;
import cn.co.com.newpanda.base.BaseFragment;
import cn.co.com.newpanda.model.entity.pandaliveBean.TopBean;
import cn.co.com.newpanda.module.home.contract.TopContract;
import cn.co.com.newpanda.view.activity.pandaliveActivity.VideoActivity;
import cn.co.com.newpanda.view.listview.MyListView;

/**
 * Created by 丶 on 2017/9/16.
 */

public class PandaTopList extends BaseFragment implements TopContract.View {
    TopContract.TopPresnter topPresnter;
    @BindView(R.id.pandaLiveListView)
    MyListView pandaLiveListView;
    Unbinder unbinder;
    List<TopBean.VideoBean> topList = new ArrayList<>();
    TopAdapter topAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_panda_toplist;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {
        topPresnter.start();

    }

    @Override
    public void setPresenter(TopContract.TopPresnter topPresnter) {
        this.topPresnter = topPresnter;
    }
    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void setResult(TopBean topBean) {
        topList.addAll(topBean.getVideo());
        topAdapter = new TopAdapter(App.context,R.layout.pandalive_list_item,topList);
        pandaLiveListView.setAdapter(topAdapter);

        pandaLiveListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(App.context, VideoActivity.class);
                intent.putExtra("position",i);
                intent.putExtra("vid", topList.get(i).getVid());
                intent.putExtra("title", topList.get(i).getT());
                intent.putExtra("data", topList.get(i).getPtime());
                intent.putExtra("len", topList.get(i).getLen());
                //Log.e("aaaaaa",pandaLiveList.get(i).getVid());
                intent.putExtra("urlIg", topList.get(i).getImg());
                startActivity(intent);
            }
        });

    }

    @Override
    public void showMessage(String msg) {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_panda_toplist, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
