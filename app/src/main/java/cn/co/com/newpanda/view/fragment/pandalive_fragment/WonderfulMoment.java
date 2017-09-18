package cn.co.com.newpanda.view.fragment.pandalive_fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.adapter.pandalive_adapter.WonderFuAdapter;
import cn.co.com.newpanda.app.App;
import cn.co.com.newpanda.base.BaseFragment;
import cn.co.com.newpanda.model.entity.pandaliveBean.WonderfuMomentBean;
import cn.co.com.newpanda.module.home.contract.WonderfulMomentContract;
import cn.co.com.newpanda.view.activity.pandaliveActivity.VideoActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class WonderfulMoment extends BaseFragment implements WonderfulMomentContract.View {

    String url = "http://www.ipanda.com/kehuduan/video/index.json";
    @BindView(R.id.pandaLiveListView)
    ListView pandaLiveListView;
    Unbinder unbinder;

    WonderfulMomentContract.WonderPresenter presenter;
    List<WonderfuMomentBean.VideoBean> pandaLiveList;
    private WonderFuAdapter wonderFuAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wonderful_moment;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {
        pandaLiveList = new ArrayList<>();
        presenter.start();
        onClickListener();
    }
    private void onClickListener() {
        pandaLiveListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), VideoActivity.class);
                intent.putExtra("WonderfulURL", pandaLiveList.get(i).getVid());
                startActivity(intent);
            }
        });
    }



    @Override
    public void setPresenter(WonderfulMomentContract.WonderPresenter presenter) {
        this.presenter = presenter;

    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissDialog() {

    }


    @Override
    public void setResult(WonderfuMomentBean wonderfuMomentBean) {
        pandaLiveList.addAll(wonderfuMomentBean.getVideo());
        //Log.e("TAG", "setResult: " + pandaLiveList.size());
        wonderFuAdapter = new WonderFuAdapter(App.context, R.layout.pandalive_list_item, pandaLiveList);
        pandaLiveListView.setAdapter(wonderFuAdapter);


    }


    @Override
    public void showMessage(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
