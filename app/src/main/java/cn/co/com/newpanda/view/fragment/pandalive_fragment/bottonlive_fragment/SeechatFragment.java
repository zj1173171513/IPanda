package cn.co.com.newpanda.view.fragment.pandalive_fragment.bottonlive_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.adapter.pandalive_adapter.bottonlive_adapter.MuchliveAdapter;
import cn.co.com.newpanda.base.BaseFragment;
import cn.co.com.newpanda.net.OkHttpUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static cn.co.com.newpanda.config.UrlsUtils.PAGELIST;

/**
 * A simple {@link Fragment} subclass.
 */
public class SeechatFragment extends BaseFragment {


    @BindView(R.id.seechat_recycle)
    RecyclerView seechatRecycle;
    Unbinder unbinder;
    private LinearLayoutManager layoutManager;
    private MuchliveAdapter muchliveAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_seechat;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {
        layoutManager = new LinearLayoutManager(getActivity());
        seechatRecycle.setLayoutManager(layoutManager);
        muchliveAdapter = new MuchliveAdapter();
        seechatRecycle.setAdapter(muchliveAdapter);
        OkHttpUtils.getInstance().sendGet(PAGELIST, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String muchList = response.body().string();
                Log.e("aaaaa", muchList);
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
