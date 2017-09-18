package cn.co.com.newpanda.view.fragment.pandalive_fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.adapter.pandalive_adapter.SuperMOEshowAdapter;
import cn.co.com.newpanda.app.App;
import cn.co.com.newpanda.base.BaseFragment;
import cn.co.com.newpanda.model.entity.pandaliveBean.SuperMOEshowBean;
import cn.co.com.newpanda.module.home.contract.SuperMOEshowContract;
import cn.co.com.newpanda.view.activity.pandaliveActivity.VideoActivity;
import cn.co.com.newpanda.view.listview.MyListView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SuperMOEshow extends BaseFragment implements SuperMOEshowContract.View {

    SuperMOEshowContract.SuperPresenter superPresenter;
    @BindView(R.id.pandaLiveListView)
    MyListView pandaLiveListView;
    Unbinder unbinder;
    List<SuperMOEshowBean.VideoBean> showLsit = new ArrayList<>();
    private SuperMOEshowAdapter superMOEshowAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_super_moeshow;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {
        superPresenter.start();
        onClickListener();
    }

    private void onClickListener() {
       pandaLiveListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent intent = new Intent(getContext(), VideoActivity.class);
               intent.putExtra("ROLLURL", showLsit.get(i).getVid());
           }
       });
    }

    @Override
    public void setPresenter(SuperMOEshowContract.SuperPresenter superPresenter) {
        this.superPresenter = superPresenter;
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void setResult(SuperMOEshowBean superMOEshowBean) {
        showLsit.addAll(superMOEshowBean.getVideo());
        superMOEshowAdapter = new SuperMOEshowAdapter(App.context,R.layout.pandalive_list_item,showLsit);
        pandaLiveListView.setAdapter(superMOEshowAdapter);
    }

    @Override
    public void showMessge(String msg) {
        Toast.makeText(App.context,msg,Toast.LENGTH_SHORT).show();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_super_moeshow, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

}
