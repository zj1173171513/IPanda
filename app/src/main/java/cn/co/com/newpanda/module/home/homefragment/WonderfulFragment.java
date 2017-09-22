package cn.co.com.newpanda.module.home.homefragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.model.entity.homeBean.CcAcBean;
import cn.co.com.newpanda.module.home.adapter.PdListAdapter;
import cn.co.com.newpanda.module.home.homepresent.MPresenter;
import cn.co.com.newpanda.module.home.homeview.IGetView;

/**
 * A simple {@link Fragment} subclass.
 */
public class WonderfulFragment extends Fragment implements IGetView<CcAcBean>{


    @BindView(R.id.won_listview)
    ListView wonListview;
    Unbinder unbinder;
    private String won;
    private MPresenter mPresenter;
    private List<CcAcBean.VideoBean> video = new ArrayList<>();
    private PdListAdapter pdListAdapter;

    public WonderfulFragment(String won) {
        this.won = won;
    }


    public WonderfulFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_wonderful, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        mPresenter = new MPresenter(this);
        initData();
        initLinener();
        return inflate;
    }

    private void initLinener() {
        wonListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String vid = video.get(i).getVid();
                Intent intent = new Intent("vid");
                intent.putExtra("vid",vid);
                getActivity().sendBroadcast(intent);
            }
        });
    }

    private void initAdapter() {
        pdListAdapter = new PdListAdapter(video, getActivity());
        wonListview.setAdapter(pdListAdapter);
    }

    private void initData() {
        mPresenter.getWonData(won);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismisLoading() {

    }

    @Override
    public void toMainSucceed(List<CcAcBean> list) {
        video = list.get(0).getVideo();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                initAdapter();
            }
        });
    }

    @Override
    public void toMainFail(String e) {
        Toast.makeText(getActivity(), ""+e, Toast.LENGTH_SHORT).show();
    }
}
