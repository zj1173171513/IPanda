package cn.co.com.newpanda.module.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.model.entity.homeBean.HomeBean;

/**
 * Created by ASUS on 2017/9/15.
 */

class HomeSixAdapter extends RecyclerView.Adapter<HomeSixAdapter.ViewHolder> {

    private Context context;
    private List<HomeBean.DataBean.ChinaliveBean.ListBeanXX> list;

    public HomeSixAdapter(Context mContext, List<HomeBean.DataBean.ChinaliveBean.ListBeanXX> list) {
        this.context = mContext;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.four_recy_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.fourItemTwoText.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getImage()).into(holder.fourItemOneImg);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

//        private final ImageView fourItemOneImg;
//        private final TextView fourItemTwoText;

        @BindView(R.id.four_item_one_img)
        ImageView fourItemOneImg;
        @BindView(R.id.four_item_two_text)
        TextView fourItemTwoText;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
//            fourItemOneImg = (ImageView) itemView.findViewById(R.id.four_item_one_img);
//            fourItemTwoText = (TextView) itemView.findViewById(R.id.four_item_two_text);
        }
    }
}
