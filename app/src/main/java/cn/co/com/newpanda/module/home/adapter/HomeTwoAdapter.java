package cn.co.com.newpanda.module.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cn.co.com.newpanda.R;
import cn.co.com.newpanda.model.entity.homeBean.HomeBean;
import cn.co.com.newpanda.module.home.homeactivity.VideoActivity;


/**
 * Created by ASUS on 2017/9/14.
 */

class HomeTwoAdapter extends RecyclerView.Adapter<HomeTwoAdapter.ViewHolder> {

    private Context context;
    private List<HomeBean.DataBean.AreaBean.ListscrollBean> listscroll;

    public HomeTwoAdapter(Context context, List<HomeBean.DataBean.AreaBean.ListscrollBean> listscroll) {
        this.context = context;
        this.listscroll = listscroll;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.two_recy_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.twoRecyText.setText(listscroll.get(position).getTitle());
        Glide.with(context).load(listscroll.get(position).getImage()).into(holder.twoRecyImg);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pid = listscroll.get(position).getPid();
                Intent intent = new Intent(context,VideoActivity.class);
                intent.putExtra("url",pid);
                intent.putExtra("title",listscroll.get(position).getTitle());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listscroll.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private  ImageView twoRecyImg;
        private  TextView twoRecyText;
        private  View itemview ;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView = itemView;
            twoRecyImg = (ImageView) itemView.findViewById(R.id.two_recy_img);
            twoRecyText = (TextView) itemView.findViewById(R.id.two_recy_text);
        }
    }
}
