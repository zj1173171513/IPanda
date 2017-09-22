package cn.co.com.newpanda.view.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.adapter.LIveChinaRecyclerAdapter;
import cn.co.com.newpanda.base.BaseFragment;
import cn.co.com.newpanda.model.entity.livechinaBean.ZiLiveChinaBean;
import cn.co.com.newpanda.net.OkHttpUtils;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZiLiveChinaFragment extends BaseFragment {


    Unbinder unbinder;
    @BindView(R.id.recyclerView_live)
    XRecyclerView recyclerViewLive;
    private List<ZiLiveChinaBean.LiveBean> listliveBeen ;
    private int times;
    private int refreshTime;
    private LIveChinaRecyclerAdapter lIveChinaRecyclerAdapter;
    private String url;
    private List<String> listshi = new ArrayList<>();
    private ProgressDialog progressDialog;

    public ZiLiveChinaFragment(String url) {
       this.url = url;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zi_live_china;
    }

    @Override
    protected void init(View view) {
    }

    @Override
    protected void loadData() {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.show();
        listliveBeen = new ArrayList<>();
        OkHttpUtils.getInstance().get(url, null,  new MyNetWorkCallback<ZiLiveChinaBean>() {

            @Override
            public void onSuccess(final ZiLiveChinaBean ziLiveChinaBean) {
                listliveBeen.addAll(ziLiveChinaBean.getLive());

//                for (int i = 0; i < listliveBeen.size(); i++){
//                    String id = listliveBeen.get(i).getId();
//                    String urls = "http://vdn.live.cntv.cn/api2/live.do?channel=pa://cctv_p2p_hd"+id+"&amp;client=androidapp";
//                    OkHttpUtils.getInstance().get(urls, null, new MyNetWorkCallback<LiveChinaShiPin>() {
//                        @Override
//                        public void onSuccess(LiveChinaShiPin liveChinaShiPin) {
//                            String hds1 = liveChinaShiPin.getHds_url().getHds1();
//                            listshi.add(hds1);
//                        }
//
//                        @Override
//                        public void onError(int errorCode, String errorMsg) {
//
//                        }
//                    });
//                }
                recyclerViewLive.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
                //关闭上拉加载
                recyclerViewLive.setLoadingMoreEnabled(false);
                recyclerViewLive.setLoadingListener(new XRecyclerView.LoadingListener() {
                    @Override
                    public void onRefresh() {
                        //刷新数据
                        refreshTime ++;
                        times = 0;
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                listliveBeen.clear();
                                if(listliveBeen!=null){
                                    listliveBeen.addAll(ziLiveChinaBean.getLive());
                                }else {
                                    Toast.makeText(getContext(), "网络错误", Toast.LENGTH_SHORT).show();
                                }
                                lIveChinaRecyclerAdapter.notifyDataSetChanged();
                                recyclerViewLive.refreshComplete();
                            }
                        }, 3000);            //refresh data here
                    }

                    @Override
                    public void onLoadMore() {
                        //加载数据
                        recyclerViewLive.setNoMore(true);
                    }
                });
                lIveChinaRecyclerAdapter = new LIveChinaRecyclerAdapter(getActivity(), listliveBeen);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                recyclerViewLive.setLayoutManager(linearLayoutManager);
                recyclerViewLive.setAdapter(lIveChinaRecyclerAdapter);
                progressDialog.dismiss();
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
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
