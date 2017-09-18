package cn.co.com.newpanda.view.fragment.pandalive_fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.adapter.pandalive_adapter.ThingsAdapter;
import cn.co.com.newpanda.app.App;
import cn.co.com.newpanda.base.BaseFragment;
import cn.co.com.newpanda.model.entity.pandaliveBean.ThingsBean;
import cn.co.com.newpanda.module.home.contract.ThingsContract;
import cn.co.com.newpanda.view.activity.pandaliveActivity.VideoActivity;
import cn.co.com.newpanda.view.listview.MyListView;

/**
 * A simple {@link Fragment} subclass.
 */
public class PandaThoseThings extends BaseFragment implements ThingsContract.View {
    ThingsAdapter thingsAdapter;
    @BindView(R.id.pandaLiveListView)
    MyListView pandaLiveListView;
    ThingsContract.ThingsPresenter thingsPresenter;

    List<ThingsBean.VideoBean> thingsList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_panda_those_things;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {
        thingsPresenter.start();
        onClickListener();
    }

    private void onClickListener() {
        pandaLiveListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), VideoActivity.class);
                intent.putExtra("WonderfulURL", thingsList.get(i).getVid());
                startActivity(intent);
            }
        });
    }

    @Override
    public void setPresenter(ThingsContract.ThingsPresenter thingsPresenter) {
        this.thingsPresenter = thingsPresenter;
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void setResult(ThingsBean thingsBean) {

        thingsList.addAll(thingsBean.getVideo());
        thingsAdapter = new ThingsAdapter(App.context, R.layout.pandalive_list_item, thingsList);
        pandaLiveListView.setAdapter(thingsAdapter);
//        Log.e("TAG",thingsBean.getVideo().get(0).getT());
//        Log.e("TAG",thingsList.size()+"");
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
        Log.e("TAG", "showMessage: "+msg);

//        Toast.makeText(getContext(), thingsList.size()+"", Toast.LENGTH_SHORT).show();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_panda_those_things, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
