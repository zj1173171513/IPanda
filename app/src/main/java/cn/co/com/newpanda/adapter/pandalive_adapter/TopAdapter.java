package cn.co.com.newpanda.adapter.pandalive_adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cn.co.com.newpanda.R;
import cn.co.com.newpanda.model.entity.pandaliveBean.TopBean;

/**
 * Created by 丶 on 2017/9/15.
 */

public class TopAdapter extends AbsAdapter<TopBean.VideoBean> {
    Context context;
    public TopAdapter(Context context, int layoutId, List<TopBean.VideoBean> datas) {
        super(context, layoutId, datas);
        this.context=context;
    }

    @Override
    public void bindResponse(ViewHolder holder, TopBean.VideoBean data) {
        ImageView pandaLiveImg = (ImageView) holder.getView(R.id.pandaLiveImg);
        TextView pandaLiveTitle = (TextView) holder.getView(R.id.pandaLiveTitle);
        TextView pandaLiveDate = (TextView) holder.getView(R.id.pandaLiveDate);
        TextView pandaLiveLen = (TextView) holder.getView(R.id.pandaLiveLen);


        Glide.with(context).load(data.getImg()).into(pandaLiveImg);
        pandaLiveTitle.setText(data.getT());
        pandaLiveDate.setText(data.getPtime());
        pandaLiveLen.setText(data.getLen());
    }
}
