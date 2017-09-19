package cn.co.com.newpanda.module.home.homeactivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.model.entity.homeBean.InfoBean;
import cn.co.com.newpanda.module.home.adapter.InteractionAdapter;
import cn.co.com.newpanda.module.home.homebase.Base_Activity;
import cn.co.com.newpanda.module.home.homepresent.MPresenter;
import cn.co.com.newpanda.module.home.homeview.IGetView;

public class InteractionActivity extends Base_Activity implements IGetView<InfoBean> {
    private List<InfoBean.InteractiveBean> mList = new ArrayList<>();
    private ProgressDialog progressDialog;

    @BindView(R.id.interaction_Listview)
    ListView interactionListview;
    private MPresenter mPresenter;

    @BindView(R.id.interaction_finish)
    ImageView interactionFinish;
    @BindView(R.id.inter_toolbar)
    Toolbar interToolbar;
    private InteractionAdapter interactionAdapter;


    @Override
    protected void initAdapter() {
        interactionAdapter = new InteractionAdapter(mList, this);
        interactionListview.setAdapter(interactionAdapter);
    }

    @Override
    public int initLayout() {
        return R.layout.activity_interaction;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        progressDialog = new ProgressDialog(this);
    }

    @Override
    public void initData() {
        mPresenter = new MPresenter(this);
        mPresenter.getData();
    }

    @Override
    public void initClick() {
        interactionFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        interactionListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(InteractionActivity.this,WebViewActivity.class);
                intent.putExtra("title",mList.get(i).getTitle());
                intent.putExtra("url",mList.get(i).getUrl());

                startActivity(intent);
            }
        });
    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void dismisLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void toMainSucceed(final List<InfoBean> info) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mList.addAll(info.get(0).getInteractive());
//                Toast.makeText(InteractionActivity.this, ""+info.get(0).getInteractive().get(2).getTitle(), Toast.LENGTH_SHORT).show();
                interactionAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void toMainFail(final String e) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(InteractionActivity.this, ""+e, Toast.LENGTH_SHORT).show();
            }
        });
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        // TODO: add setContentView(...) invocation
//        ButterKnife.bind(this);
//    }
}
