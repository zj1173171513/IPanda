package cn.co.com.newpanda.view.fragment.pandalive_fragment.bottonlive_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.adapter.pandalive_adapter.bottonlive_adapter.MyRecycleAdapter;
import cn.co.com.newpanda.adapter.pandalive_adapter.bottonlive_adapter.SpaceItemDecoration;
import cn.co.com.newpanda.base.BaseFragment;
import cn.co.com.newpanda.model.entity.PandaLiveBean;
import cn.co.com.newpanda.net.OkHttpUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static cn.co.com.newpanda.config.UrlsUtils.HOMELIVE;

/**
 * A simple {@link Fragment} subclass.
 */
public class MuchliveFragment extends BaseFragment implements MyRecycleAdapter.OnItemClickListener {

    @BindView(R.id.my_recycler_view)
    RecyclerView myRecyclerView;
    Unbinder unbinder;
    private GridLayoutManager gridLayoutManager;
    private MyRecycleAdapter mAdapter;
    private ArrayList<PandaLiveBean.ListBean> pandalist = new ArrayList<>();
    private PandaLiveBean liveBean;
    int spanCount = 3; // 3 columns
    int spacing = 35; // 50px
    boolean includeEdge = false;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_muchlive;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {
        gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        myRecyclerView.setLayoutManager(gridLayoutManager);
        myRecyclerView.addItemDecoration(new SpaceItemDecoration(spanCount, spacing, includeEdge));
        mAdapter = new MyRecycleAdapter(getActivity(), pandalist);
        myRecyclerView.setAdapter(mAdapter);

        OkHttpUtils.getInstance().sendGet(HOMELIVE, new Callback() {


            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();

                // Log.e("aaaaa", json);
                Gson gson = new Gson();
                liveBean = gson.fromJson(json, PandaLiveBean.class);
                pandalist.addAll(liveBean.getList());
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter.notifyDataSetChanged();
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
    public void click(int position) {
//        Bundle bundle = new Bundle();
//        bundle.putString("title",liveBean.getList().get(position).getTitle());
//        bundle.putString("img",liveBean.getList().get(position).getImage());
        Toast.makeText(getActivity(), "111111", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }


}
