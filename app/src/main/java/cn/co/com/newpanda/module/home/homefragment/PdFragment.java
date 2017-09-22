package cn.co.com.newpanda.module.home.homefragment;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.model.entity.homeBean.CcAcBean;
import cn.co.com.newpanda.module.home.adapter.PdListAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class PdFragment extends Fragment {

    private List<CcAcBean.VideoBean> mList = new ArrayList<>();
    @BindView(R.id.pd_listview)
    ListView pdListview;
    Unbinder unbinder;
    private BroadcastReceiver rece = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            CcAcBean list = intent.getParcelableExtra("list");
            Log.e("TAG",list.getVideo().get(0).getT());
            List<CcAcBean.VideoBean> video = list.getVideo();
            mList.addAll(video);
            pdListAdapter.notifyDataSetChanged();
        }
    };
    private PdListAdapter pdListAdapter;

    public PdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_pd, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        initAdapter();
        initData();
        initListener();
        return inflate;
    }

    private void initListener() {
        pdListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String vid = mList.get(i).getVid();
                Intent intent = new Intent("vid");
                intent.putExtra("vid",vid);
                getActivity().sendBroadcast(intent);
            }
        });
    }

    private void initAdapter() {
        pdListAdapter = new PdListAdapter(mList, getActivity());
        pdListview.setAdapter(pdListAdapter);
    }

    private void initData() {
        IntentFilter fiter = new IntentFilter("pd");
        Log.e("TAG","------------注册广播---------------");
        getActivity().registerReceiver(rece,fiter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        getActivity().unregisterReceiver(rece);
    }
}
