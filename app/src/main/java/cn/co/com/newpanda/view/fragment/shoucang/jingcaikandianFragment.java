package cn.co.com.newpanda.view.fragment.shoucang;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cn.co.com.newpanda.R;
import cn.co.com.newpanda.adapter.shoucangadapter.listAdapter;
import cn.co.com.newpanda.model.entity.livechinaBean.ShuLiveChina;
import cn.co.com.newpanda.model.entity.livechinaBean.dao.DaoMaster;
import cn.co.com.newpanda.model.entity.livechinaBean.dao.ShuLiveChinaDao;

/**
 * A simple {@link Fragment} subclass.
 */
public class jingcaikandianFragment extends Fragment {

    private List<ShuLiveChina> list = new ArrayList<>();
    private ListView listview;
    private listAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_jingcaikandian, container, false);
        initView(inflate);
        initData();
        return inflate;
    }


    private void initView(View inflate) {
        listview = inflate.findViewById(R.id.shoucang_listView);

        adapter = new listAdapter(list, getContext());
        listview.setAdapter(adapter);

    }

    private void initData() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(getContext(), "aaa.db");
        DaoMaster daoMaster = new DaoMaster(helper.getReadableDatabase());
        ShuLiveChinaDao dao = daoMaster.newSession().getShuLiveChinaDao();


        List<ShuLiveChina> list2 = dao.queryBuilder().list();
        list.addAll(list2);
        adapter.notifyDataSetChanged();


    }

}
