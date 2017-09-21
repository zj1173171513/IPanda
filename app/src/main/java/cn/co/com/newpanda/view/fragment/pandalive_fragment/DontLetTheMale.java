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
import cn.co.com.newpanda.adapter.pandalive_adapter.DonAdapter;
import cn.co.com.newpanda.app.App;
import cn.co.com.newpanda.base.BaseFragment;
import cn.co.com.newpanda.model.entity.pandaliveBean.DonBean;
import cn.co.com.newpanda.module.home.contract.DonModelContract;
import cn.co.com.newpanda.view.activity.pandaliveActivity.VideoActivity;
import cn.co.com.newpanda.view.listview.MyListView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DontLetTheMale extends BaseFragment implements DonModelContract.View {

    DonModelContract.DonPresnter donPresnter;
    @BindView(R.id.pandaLiveListView)
    MyListView pandaLiveListView;
    Unbinder unbinder;
    List<DonBean.VideoBean> donList = new ArrayList<>();
    DonAdapter donAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_panda_toplist;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {
        donPresnter.start();

    }


    @Override
    public void setPresenter(DonModelContract.DonPresnter donPresnter) {
        this.donPresnter = donPresnter;
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void setResult(DonBean donBean) {
        donList.addAll(donBean.getVideo());
        donAdapter = new DonAdapter(App.context, R.layout.pandalive_list_item, donList);
        pandaLiveListView.setAdapter(donAdapter);

        pandaLiveListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(App.context, VideoActivity.class);
                intent.putExtra("position",i);
                intent.putExtra("vid", donList.get(i).getVid());
                intent.putExtra("title", donList.get(i).getT());
                intent.putExtra("data", donList.get(i).getPtime());
                intent.putExtra("len", donList.get(i).getLen());
                //Log.e("aaaaaa",pandaLiveList.get(i).getVid());
                intent.putExtra("urlIg", donList.get(i).getImg());
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

    @Override
    public void onResume() {
        super.onResume();

    }
}
