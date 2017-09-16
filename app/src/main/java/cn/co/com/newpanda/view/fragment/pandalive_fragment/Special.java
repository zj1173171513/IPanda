package cn.co.com.newpanda.view.fragment.pandalive_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.adapter.pandalive_adapter.SpecialAdapter;
import cn.co.com.newpanda.app.App;
import cn.co.com.newpanda.base.BaseFragment;
import cn.co.com.newpanda.model.entity.pandaliveBean.SpecialBean;
import cn.co.com.newpanda.module.home.contract.SpecialContract;
import cn.co.com.newpanda.view.listview.MyListView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Special extends BaseFragment implements SpecialContract.View {

    SpecialContract.SpecialPresnter specialPresnter;
    @BindView(R.id.pandaLiveListView)
    MyListView pandaLiveListView;
    Unbinder unbinder;
    List<SpecialBean.VideoBean> specialList = new ArrayList<>();
    private SpecialAdapter specialAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_special;
    }



    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {
        specialPresnter.start();

    }
    @Override
    public void setPresenter(SpecialContract.SpecialPresnter specialPresnter) {
        this.specialPresnter = specialPresnter;
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void setResult(SpecialBean specialBean) {
        specialList.addAll(specialBean.getVideo());
        specialAdapter = new SpecialAdapter(App.context,R.layout.pandalive_list_item,specialList);
        pandaLiveListView.setAdapter(specialAdapter);

    }

    @Override
    public void showMessage(String msg) {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_special, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
