package cn.co.com.newpanda.adapter.BillowingVideoadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cn.co.com.newpanda.R;
import cn.co.com.newpanda.model.entity.BillowingVideoBean.BillowingVideolistBean;

/**
 * Created by lihan on 2017/9/14.
 */

public class MyAdapter extends BaseAdapter {
    private List<BillowingVideolistBean.ListBean> listBeen;
    private Context context;
    private MyViewHolder vh;

    public MyAdapter(List<BillowingVideolistBean.ListBean> listBeen, Context context) {
        this.listBeen = listBeen;
        this.context = context;
    }



    @Override
    public int getCount() {
        return listBeen.size();
    }

    @Override
    public Object getItem(int i) {
        return listBeen.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            vh = new MyViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.gungunshiping, null);
            vh.imageView = (ImageView) view.findViewById(R.id.imageView);
            vh.cicle = (TextView) view.findViewById(R.id.TV_cicle);
            vh.content = (TextView) view.findViewById(R.id.TV_context);
            vh.time = (TextView) view.findViewById(R.id.TV_time);
            view.setTag(vh);
        } else {
            vh = (MyViewHolder) view.getTag();
        }
        Glide.with(context).load(listBeen.get(i).getImage()).into(vh.imageView);
        vh.cicle.setText(listBeen.get(i).getTitle());
        vh.content.setText(listBeen.get(i).getBrief());
        vh.time.setText(listBeen.get(i).getVideoLength());
        return view;
    }

    class MyViewHolder {
        ImageView imageView;
        TextView cicle;
        TextView content;
        TextView time;
    }
}
