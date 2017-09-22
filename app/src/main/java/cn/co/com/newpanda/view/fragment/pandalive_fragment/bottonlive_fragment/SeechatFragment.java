package cn.co.com.newpanda.view.fragment.pandalive_fragment.bottonlive_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.adapter.pandalive_adapter.bottonlive_adapter.MuchliveAdapter;
import cn.co.com.newpanda.base.BaseFragment;
import cn.co.com.newpanda.model.entity.pandaliveBean.PingLunBean;
import cn.co.com.newpanda.net.OkHttpUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.Invalid index 1, size is 1
 */
public class SeechatFragment extends BaseFragment {


    @BindView(R.id.seechat_recycle)
    RecyclerView seechatRecycle;
    Unbinder unbinder;
    @BindView(R.id.mAmEtMsg)
    EditText mAmEtMsg;
    private LinearLayoutManager layoutManager;
    private MuchliveAdapter muchliveAdapter;
    //private List<PingLunBean.DataBean> list2 = new ArrayList<>();
    private List<PingLunBean.DataBean.ContentBean> list = new ArrayList<>();

    private PingLunBean pingLunBean;

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
        muchliveAdapter = new MuchliveAdapter(list, getActivity());
        seechatRecycle.setAdapter(muchliveAdapter);
        OkHttpUtils.getInstance().sendGet("http://newcomment.cntv.cn/comment/list?prepage=20&app=ipandaApp&itemid=zhiboye_chat&nature=1&page=1", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                pingLunBean = gson.fromJson(string, PingLunBean.class);
//                list2.add(pingLunBean.getData());
                list.addAll(pingLunBean.getData().getContent());


                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        muchliveAdapter.notifyDataSetChanged();
                    }
                });
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
