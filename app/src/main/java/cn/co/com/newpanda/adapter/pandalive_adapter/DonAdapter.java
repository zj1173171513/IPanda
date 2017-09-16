package cn.co.com.newpanda.adapter.pandalive_adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cn.co.com.newpanda.R;
import cn.co.com.newpanda.app.App;
import cn.co.com.newpanda.model.entity.pandaliveBean.DonBean;

/**
 * Created by 丶 on 2017/9/15.
 */

public class DonAdapter extends AbsAdapter<DonBean.VideoBean> {

    public DonAdapter(Context context, int layoutId, List<DonBean.VideoBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void bindResponse(ViewHolder holder, DonBean.VideoBean data) {

        ImageView donImg = (ImageView) holder.getView(R.id.pandaLiveImg);
        TextView donLen = (TextView) holder.getView(R.id.pandaLiveLen);
        TextView donTitle = (TextView) holder.getView(R.id.pandaLiveTitle);
        TextView donData = (TextView) holder.getView(R.id.pandaLiveDate);

        Glide.with(App.context).load(data.getImg()).into(donImg);
        donData.setText(data.getPtime());
        donLen.setText(data.getLen());
        donTitle.setText(data.getT());


    }


}
