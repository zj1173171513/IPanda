package cn.co.com.newpanda.view.fragment.pandalive_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
    private DonAdapter donAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_dont_let_the_male;
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

    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dont_let_the_male, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }



}
