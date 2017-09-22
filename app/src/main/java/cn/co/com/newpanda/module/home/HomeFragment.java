package cn.co.com.newpanda.module.home;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.base.BaseFragment;
import cn.co.com.newpanda.model.entity.homeBean.HomeBean;
import cn.co.com.newpanda.module.home.adapter.HomeAdapter;


public class HomeFragment extends BaseFragment implements HomeContract.View {
    @BindView(R.id.swipe_refresh_widget)
    SwipeRefreshLayout swipeRefreshWidget;
    @BindView(R.id.home_fragment_img)
    ImageView homeFragmentImg;
    private ProgressDialog progressDialog;
    HomeContract.Presenter presenter;
    @BindView(R.id.home_recy)
    RecyclerView homeRecy;
    Unbinder unbinder;
    private List<HomeBean.DataBean> mList = new ArrayList<>();
    private HomeAdapter homeAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.home_fragment;
    }

    @Override
    protected void init(View view) {
        presenter = new HomePresenter(this);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        homeRecy.setLayoutManager(manager);
        homeAdapter = new HomeAdapter(mList, getActivity());
        homeRecy.setAdapter(homeAdapter);

        progressDialog = new ProgressDialog(getActivity());
        swipeRefreshWidget.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.start();
                homeAdapter.notifyDataSetChanged();
                swipeRefreshWidget.setRefreshing(false);
            }
        });

    }

    @Override
    protected void loadData() {

        presenter.start();
        homeFragmentImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "1111111111111111", Toast.LENGTH_SHORT).show();
                presenter.start();
                homeAdapter.notifyDataSetChanged();
            }
        });
    }


    @Override
    public void showProgressDialog() {
        progressDialog.show();
    }

    @Override
    public void dismissDialog() {
        progressDialog.dismiss();
    }

    @Override
    public void setResult(HomeBean homeBean) {
        mList.clear();
        HomeBean.DataBean data = homeBean.getData();
        for (int i = 0; i < 9; i++) {
            mList.add(data);
        }
        homeAdapter.notifyDataSetChanged();
        homeRecy.setVisibility(View.VISIBLE);
        homeFragmentImg.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(getContext(), "网络连接异常！", Toast.LENGTH_SHORT).show();
        homeRecy.setVisibility(View.GONE);
        homeFragmentImg.setVisibility(View.VISIBLE);
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        this.presenter = presenter;
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
