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
import cn.co.com.newpanda.adapter.pandalive_adapter.PandaArchivesAdapter;
import cn.co.com.newpanda.app.App;
import cn.co.com.newpanda.base.BaseFragment;
import cn.co.com.newpanda.model.entity.pandaliveBean.PandaArchivesBean;
import cn.co.com.newpanda.module.home.contract.PandaArchivesModeContract;
import cn.co.com.newpanda.view.activity.pandaliveActivity.VideoActivity;
import cn.co.com.newpanda.view.listview.MyListView;

/**
 * A simple {@link Fragment} subclass.
 */
public class PandaArchives extends BaseFragment implements PandaArchivesModeContract.View {


    PandaArchivesModeContract.PandaArchivesPresenter pandaArchivesPresenter;
    List<PandaArchivesBean.VideoBean> pandaArchList = new ArrayList<>();

    @BindView(R.id.pandaLiveListView)
    MyListView pandaLiveListView;
    Unbinder unbinder;
    private PandaArchivesAdapter pandaArchivesAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_panda_archives;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {
        pandaArchivesPresenter.start();

    }

    @Override
    public void setPresenter(PandaArchivesModeContract.PandaArchivesPresenter pandaArchivesPresenter) {
        this.pandaArchivesPresenter = pandaArchivesPresenter;
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void setResult(PandaArchivesBean pandaArchivesBean) {
        pandaArchList.addAll(pandaArchivesBean.getVideo());
        pandaArchivesAdapter = new PandaArchivesAdapter(App.context, R.layout.pandalive_list_item, pandaArchList);
        pandaLiveListView.setAdapter(pandaArchivesAdapter);

        pandaLiveListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(App.context, VideoActivity.class);
                intent.putExtra("position",i);
                intent.putExtra("vid", pandaArchList.get(i).getVid());
                intent.putExtra("title", pandaArchList.get(i).getT());
                intent.putExtra("data", pandaArchList.get(i).getPtime());
                intent.putExtra("len", pandaArchList.get(i).getLen());
                //Log.e("aaaaaa",pandaLiveList.get(i).getVid());
                intent.putExtra("urlIg", pandaArchList.get(i).getImg());
                startActivity(intent);
            }
        });

    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(App.context, msg, Toast.LENGTH_SHORT).show();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_panda_archives, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
