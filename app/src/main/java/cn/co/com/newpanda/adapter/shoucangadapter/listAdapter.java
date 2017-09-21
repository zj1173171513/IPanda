package cn.co.com.newpanda.adapter.shoucangadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cn.co.com.newpanda.R;
import cn.co.com.newpanda.model.entity.livechinaBean.ShuLiveChina;

/**
 * Created by lihan on 2017/9/21.
 */

public class listAdapter extends BaseAdapter {
    private Context context;
    private List<ShuLiveChina> list;

    public listAdapter(List<ShuLiveChina> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        MyView myView = null;
        if (convertView == null) {
            myView = new MyView();
            convertView = LayoutInflater.from(context).inflate(R.layout.item2, null);
            myView.infos = convertView.findViewById(R.id.info);
            convertView.setTag(myView);
        } else {
            myView = (MyView) convertView.getTag();
        }
        ShuLiveChina bean = list.get(position);
        myView.infos.setText(bean.getTitle());
        return convertView;
    }

    class MyView {
        TextView infos;
    }
}
