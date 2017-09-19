package cn.co.com.newpanda.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.co.com.newpanda.adapter.LIveChinaRecyclerAdapter;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.base.BaseFragment;
import cn.co.com.newpanda.model.entity.livechinaBean.ZiLiveChinaBean;
import cn.co.com.newpanda.net.OkHttpUtils;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZiLiveChinaFragment extends BaseFragment {


    Unbinder unbinder;
    @BindView(R.id.recyclerView_live)
    RecyclerView recyclerViewLive;
    private List<ZiLiveChinaBean.LiveBean> listliveBeen = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zi_live_china;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {
        //请求
        OkHttpUtils.getInstance().get("http://www.ipanda.com/kehuduan/liebiao/badaling/index.json", null, new MyNetWorkCallback<ZiLiveChinaBean>() {
            @Override
            public void onSuccess(ZiLiveChinaBean ziLiveChinaBean) {
                listliveBeen.addAll(ziLiveChinaBean.getLive());
                LIveChinaRecyclerAdapter lIveChinaRecyclerAdapter = new LIveChinaRecyclerAdapter(getActivity(), listliveBeen);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                recyclerViewLive.setLayoutManager(linearLayoutManager);
                recyclerViewLive.setAdapter(lIveChinaRecyclerAdapter);

            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
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
