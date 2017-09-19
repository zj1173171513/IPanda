package cn.co.com.newpanda.view.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.adapter.BoBaoAdapter.MyRecycAdapter;
import cn.co.com.newpanda.adapter.BoBaoAdapter.SimplePaddingDecoration;
import cn.co.com.newpanda.app.App;
import cn.co.com.newpanda.base.BaseFragment;
import cn.co.com.newpanda.model.entity.BoBaoBean.PandaBroadCastBean;
import cn.co.com.newpanda.model.entity.BoBaoBean.PandaBroadcastInfoBean;
import cn.co.com.newpanda.module.pandabroadcast.PandaBroadcastContract;
import cn.co.com.newpanda.module.pandabroadcast.PandaBroadcastPresenter;
import cn.co.com.newpanda.view.activity.BoBao.BoBaoActivity;


/**
 * Created by Administrator on 2017/9/12.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class PandaBroadcast extends BaseFragment implements PandaBroadcastContract.View{
    PandaBroadcastContract.Presenter presenter;
    @BindView(R.id.image)
    ImageView imagetu;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;
    private ProgressDialog dialog;
    @Override
    protected int getLayoutId() {
        return R.layout.pandabroadcast_fragment;
    }

    @Override
    protected void init(View view) {

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

    }

    @Override
    public void setResult(final PandaBroadCastBean pdbcBean) {
        showProgressDialog();
        String image = pdbcBean.getData().getBigImg().get(0).getImage();
        Glide.with(App.context).load(image).into(imagetu);
        imagetu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), BoBaoActivity.class);
                intent.putExtra("title",pdbcBean.getData().getBigImg().get(0).getTitle());
                intent.putExtra("pid",pdbcBean.getData().getBigImg().get(0).getPid());
                Log.e("TAG",pdbcBean.getData().getBigImg().get(0).getPid());
                startActivity(intent);
            }
        });
    }




    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setInfo(PandaBroadcastInfoBean pdbcInfoBean) {
        List<PandaBroadcastInfoBean.ListBean> list1 = pdbcInfoBean.getList();
        List<PandaBroadcastInfoBean.ListBean> list = new ArrayList<PandaBroadcastInfoBean.ListBean>();
        list.addAll(list1);
        MyRecycAdapter adapter  = new MyRecycAdapter(App.context,list);
        LinearLayoutManager manager = new LinearLayoutManager(App.context);
        recycler.addItemDecoration(new SimplePaddingDecoration(App.context));
        recycler.setLayoutManager(manager);
        recycler.setAdapter(adapter);
        dialog.dismiss();
    }
}


