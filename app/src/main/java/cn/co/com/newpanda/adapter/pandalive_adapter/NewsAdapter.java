package cn.co.com.newpanda.adapter.pandalive_adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cn.co.com.newpanda.R;
import cn.co.com.newpanda.app.App;
import cn.co.com.newpanda.model.entity.pandaliveBean.NewsBean;

/**
 * Created by 丶 on 2017/9/16.
 */

public class NewsAdapter extends AbsAdapter<NewsBean.VideoBean> {
    public NewsAdapter(Context context, int layoutId, List<NewsBean.VideoBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void bindResponse(ViewHolder holder, NewsBean.VideoBean data) {
        ImageView pandaLiveImg = (ImageView) holder.getView(R.id.pandaLiveImg);
        TextView pandaLiveTitle = (TextView) holder.getView(R.id.pandaLiveTitle);
        TextView pandaLiveDate = (TextView) holder.getView(R.id.pandaLiveDate);
        TextView pandaLiveLen = (TextView) holder.getView(R.id.pandaLiveLen);


        Glide.with(App.context).load(data.getImg()).into(pandaLiveImg);
        pandaLiveTitle.setText(data.getT());
        pandaLiveDate.setText(data.getPtime());
        pandaLiveLen.setText(data.getLen());
    }
}
