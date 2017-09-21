package cn.co.com.newpanda.module.home.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.model.entity.homeBean.CcAcBean;

/**
 * Created by ASUS on 2017/9/20.
 */

public class PdListAdapter extends BaseAdapter {
    private List<CcAcBean.VideoBean> list;
    private Context context;
    private ViewHolder viewHolder;

    public PdListAdapter(List<CcAcBean.VideoBean> list, Context context) {
        this.list = list;
        this.context = context;
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
            view = View.inflate(context, R.layout.pd_list_item, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.pdListItemVideoLength.setText(list.get(i).getLen());
        viewHolder.pdListItemTitle.setText(list.get(i).getT());
        Glide.with(context).load(list.get(i).getImg()).into(viewHolder.pdListItemImg);
        return view;
    }

    static class ViewHolder {
        @BindView(R.id.pd_list_item_img)
        ImageView pdListItemImg;
        @BindView(R.id.pd_list_item_two_img)
        ImageView pdListItemTwoImg;
        @BindView(R.id.pd_list_item_three_img)
        ImageView pdListItemThreeImg;
        @BindView(R.id.pd_list_item_videoLength)
        TextView pdListItemVideoLength;
        @BindView(R.id.pd_list_item_title)
        TextView pdListItemTitle;
        @BindView(R.id.pd_list_item_button)
        LinearLayout pdListItemButton;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
