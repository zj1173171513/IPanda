package cn.co.com.newpanda.module.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.model.entity.homeBean.NineBean;
import cn.co.com.newpanda.module.home.homeactivity.VideoActivity;

/**
 * Created by ASUS on 2017/9/15.
 */

class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private Context context;
    private List<NineBean.ListBean> list;

    public ListAdapter(Context mContext, List<NineBean.ListBean> list) {
        this.context = mContext;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.listItemTitle.setText(list.get(position).getTitle());
        holder.listItemTime.setText(list.get(position).getDaytime());
        holder.listItemVideoLength.setText(list.get(position).getVideoLength());
        Glide.with(context).load(list.get(position).getImage()).into(holder.listItemImg);
        holder.listItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,VideoActivity.class);
                intent.putExtra("url",list.get(position).getPid());
                intent.putExtra("title",list.get(position).getTitle());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.list_item_img)
        ImageView listItemImg;
        @BindView(R.id.list_item_two_img)
        ImageView listItemTwoImg;
        @BindView(R.id.list_item_three_img)
        ImageView listItemThreeImg;
        @BindView(R.id.list_item_videoLength)
        TextView listItemVideoLength;
        @BindView(R.id.list_item_title)
        TextView listItemTitle;
        @BindView(R.id.list_item_time)
        TextView listItemTime;
        @BindView(R.id.list_item_button)
        LinearLayout listItemButton;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
