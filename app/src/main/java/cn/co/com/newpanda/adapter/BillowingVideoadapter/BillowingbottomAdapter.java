package cn.co.com.newpanda.adapter.BillowingVideoadapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cn.co.com.newpanda.R;
import cn.co.com.newpanda.adapter.pandalive_adapter.AbsAdapter;
import cn.co.com.newpanda.app.App;
import cn.co.com.newpanda.model.entity.BillowingVideoBean.BillowingItemBean;

/**
 * Created by 小七七 on 2017/9/17.
 */

public class BillowingbottomAdapter extends AbsAdapter<BillowingItemBean.VideoBean> {

    public BillowingbottomAdapter(Context context, int layoutId, List<BillowingItemBean.VideoBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void bindResponse(ViewHolder holder, BillowingItemBean.VideoBean data) {
        ImageView image_b = (ImageView) holder.getView(R.id.image_b);
        TextView time_b = (TextView) holder.getView(R.id.time_b);
        TextView title_b = (TextView) holder.getView(R.id.title_b);

        Glide.with(App.getContext()).load(data.getImg()).into(image_b);
        time_b.setText(data.getLen());
        title_b.setText(data.getT());
    }


}
