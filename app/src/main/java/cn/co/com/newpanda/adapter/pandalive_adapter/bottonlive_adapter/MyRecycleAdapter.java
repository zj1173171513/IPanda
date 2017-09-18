package cn.co.com.newpanda.adapter.pandalive_adapter.bottonlive_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import cn.co.com.newpanda.R;
import cn.co.com.newpanda.model.entity.PandaLiveBean;

/**
 * Created by 丶 on 2017/9/16.
 */

public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.ViewHolder> {
    public Context context;
    private ArrayList<PandaLiveBean.ListBean> pandalist = new ArrayList<>();

    public MyRecycleAdapter(Context context, ArrayList<PandaLiveBean.ListBean> pandalist) {
        this.context = context;
        this.pandalist = pandalist;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_item, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.livetitle.setText(pandalist.get(position).getTitle());
        Glide.with(context).load(pandalist.get(position).getImage()).into(viewHolder.pandaLiveImg);
    }

    @Override
    public int getItemCount() {
        return pandalist.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView livetitle;
        private ImageView pandaLiveImg;

        public ViewHolder(View view) {
            super(view);
            livetitle = view.findViewById(R.id.livetitle);
            pandaLiveImg = view.findViewById(R.id.pandaLiveImg);
        }
    }
}
