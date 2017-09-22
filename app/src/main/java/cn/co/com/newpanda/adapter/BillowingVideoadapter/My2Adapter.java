package cn.co.com.newpanda.adapter.BillowingVideoadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cn.co.com.newpanda.R;
import cn.co.com.newpanda.model.entity.BillowingVideoBean.BillowingItemBean;
import cn.co.com.newpanda.view.activity.BillowingVideoActicity.ShiPinActivity;

/**
 * Created by lihan on 2017/9/22.
 */

public class My2Adapter extends BaseAdapter {
    private List<BillowingItemBean.VideoBean> list;
    private ShiPinActivity shiPinActivity;

    private My2Adapter.MyViewHolder vh;

    public My2Adapter(List<BillowingItemBean.VideoBean> list, ShiPinActivity shiPinActivity) {
        this.list = list;
        this.shiPinActivity = shiPinActivity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            vh = new My2Adapter.MyViewHolder();
            view = LayoutInflater.from(shiPinActivity).inflate(R.layout.billowing_bottom_item, null);
            vh.imageView = (ImageView) view.findViewById(R.id.image_b);
            vh.cicle = (TextView) view.findViewById(R.id.time_b);
            vh.content = (TextView) view.findViewById(R.id.title_b);
            view.setTag(vh);
        } else {
            vh = (My2Adapter.MyViewHolder) view.getTag();
        }
        Glide.with(shiPinActivity).load(list.get(i).getImg()).into(vh.imageView);
        vh.cicle.setText(list.get(i).getLen());
        vh.content.setText(list.get(i).getT());
        return view;
    }

    class MyViewHolder {
        ImageView imageView;
        TextView cicle;
        TextView content;
    }
}
