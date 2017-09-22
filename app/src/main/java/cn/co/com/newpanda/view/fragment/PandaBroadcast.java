package cn.co.com.newpanda.view.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.adapter.BoBaoAdapter.MyRecycAdapter;
import cn.co.com.newpanda.app.App;
import cn.co.com.newpanda.base.BaseFragment;
import cn.co.com.newpanda.model.bobao.PBDCModelImpl;
import cn.co.com.newpanda.model.entity.BoBaoBean.PandaBroadCastBean;
import cn.co.com.newpanda.model.entity.BoBaoBean.PandaBroadcastInfoBean;
import cn.co.com.newpanda.module.pandabroadcast.PandaBroadcastContract;
import cn.co.com.newpanda.module.pandabroadcast.PandaBroadcastPresenter;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;
import cn.co.com.newpanda.view.activity.BoBao.BoBaoActivity;
import cn.co.com.newpanda.view.activity.BoBao.PDBCActivity;


/**
 * Created by Administrator on 2017/9/12.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class PandaBroadcast extends BaseFragment implements PullToRefreshBase.OnLastItemVisibleListener,PandaBroadcastContract.View, PullToRefreshBase.OnRefreshListener<ListView>, AdapterView.OnItemClickListener {
    PandaBroadcastContract.Presenter presenter;
    Unbinder unbinder;
    @BindView(R.id.recycler)
    PullToRefreshListView recycler;
    Unbinder unbinder1;

    private ProgressDialog dialog;
    private ImageView image1;
    private View top;
    private List<PandaBroadcastInfoBean.ListBean> list;
    private ListView listView;
    private View footer;
    private ProgressBar moreBar;

    @Override
    protected int getLayoutId() {
        return R.layout.pandabroadcast_fragment;
    }

    @Override
    protected void init(View view) {
        ButterKnife.bind(getActivity());


        top = View.inflate(getActivity(), R.layout.item_top_broad, null);
        image1 = top.findViewById(R.id.image);

        footer = View.inflate(getActivity(), R.layout.item_footer_broad, null);
        moreBar = footer.findViewById(R.id.moreBar);

        recycler.setOnItemClickListener(this);
        recycler.setOnRefreshListener(this);
        recycler.setOnLastItemVisibleListener(this);
    }

    @Override
    protected void loadData() {
        presenter = new PandaBroadcastPresenter(this);
        presenter.start();
    }

    @Override
    protected void onHidden() {
        super.onHidden();
    }


    @Override
    public void setPresenter(PandaBroadcastContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showProgressDialog() {
        dialog = new ProgressDialog(App.context);

        dialog.show();

    }

    @Override
    public void dismissDialog() {
//        dialog.dismiss();
    }

    @Override
    public void setResult(final PandaBroadCastBean pdbcBean) {
        showProgressDialog();
        String imagew = pdbcBean.getData().getBigImg().get(0).getImage();
        Glide.with(App.context).load(imagew).into(image1);
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(App.context, BoBaoActivity.class);
                intent.putExtra("url1", pdbcBean.getData().getBigImg().get(0).getUrl());
                intent.putExtra("title", pdbcBean.getData().getBigImg().get(0).getTitle());
                intent.putExtra("id1", pdbcBean.getData().getBigImg().get(0).getId());
                intent.putExtra("imageurl", pdbcBean.getData().getBigImg().get(0).getImage());
                startActivity(intent);
            }
        });
    }


    @Override
    public void showMessage(String msg) {
        Toast.makeText(getActivity(), "" + msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setInfo(PandaBroadcastInfoBean pdbcInfoBean) {
        List<PandaBroadcastInfoBean.ListBean> list1 = pdbcInfoBean.getList();
        list = new ArrayList<PandaBroadcastInfoBean.ListBean>();
        list.addAll(list1);
        MyRecycAdapter adapter = new MyRecycAdapter(App.context, list);
        recycler.setAdapter(adapter);
        listView = recycler.getRefreshableView();

        listView.addHeaderView(top);
        listView.addFooterView(footer);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Intent intent = new Intent(App.context, PDBCActivity.class);
        PandaBroadcastInfoBean.ListBean listBean = list.get(i - 1);
        intent.putExtra("list", listBean);
        startActivity(intent);

    }

    @Override
    public void onRefresh(PullToRefreshBase<ListView> refreshView) {


        String label = DateUtils.formatDateTime(getActivity(), System.currentTimeMillis(),
                DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);

        // 最后一次刷新的时间
        refreshView.getLoadingLayoutProxy().setLastUpdatedLabel("上次刷新时间   " + label);

        //设置刷新图标 下拉的时候显示的内容
        //refreshView.getLoadingLayoutProxy().setLoadingDrawable(getResources().getDrawable(R.mipmap.ic_launcher));

        // 下拉完成后，还没有刷新时 显示的内容
        // refreshView.getLoadingLayoutProxy().setReleaseLabel("默默地么么哒！！");

        //松开手，正在刷新时 ，显示的内容
        //     refreshView.getLoadingLayoutProxy().setRefreshingLabel("啦啦啦啦啦");

        // Toast.makeText(getActivity(), "刷新了", Toast.LENGTH_SHORT).show();

        recycler.setMode(PullToRefreshBase.Mode.PULL_FROM_START);

        recycler.setRefreshing();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                recycler.onRefreshComplete();
            }
        }, 2000);


        /**
         * 程序进来就执行刷新数据，自动执行刷新
         */
        recycler.setRefreshing();
    }



    @Override
    public void onLastItemVisible() {
        Toast.makeText(getActivity(), "人家是有底线的", Toast.LENGTH_SHORT).show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                new PBDCModelImpl().getPDBCinfo(new MyNetWorkCallback<PandaBroadcastInfoBean>() {
                    @Override
                    public void onSuccess(PandaBroadcastInfoBean pandaBroadcastInfoBean) {
                        List<PandaBroadcastInfoBean.ListBean> list1 = pandaBroadcastInfoBean.getList();


                        list.addAll(list1);


                    }

                    @Override
                    public void onError(int errorCode, String errorMsg) {

                    }
                });

                moreBar.cancelLongPress();
            }
        }, 2000);
//        recycler.setRefreshing();

    }
}


