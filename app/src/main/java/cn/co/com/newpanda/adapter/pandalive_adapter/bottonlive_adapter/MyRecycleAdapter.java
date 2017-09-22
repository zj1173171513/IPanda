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

public class MyRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    public Context context;
    private ArrayList<PandaLiveBean.ListBean> pandalist = new ArrayList<>();
    private OnItemClickListener onItemClickListener;
    private boolean includeEdge;

    public MyRecycleAdapter(Context context, ArrayList<PandaLiveBean.ListBean> pandalist) {
        this.context = context;
        this.pandalist = pandalist;
    }

    //创建新View，被LayoutManager所调用

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_item, viewGroup,false);
        ViewHolder vh = new ViewHolder(itemView,onItemClickListener);

        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;
        vh.livetitle.setText(pandalist.get(position).getTitle());
        Glide.with(context).load(pandalist.get(position).getImage()).into(vh.pandaLiveImg);

    }

    @Override
    public int getItemCount() {
        return pandalist.size();
    }

    public interface OnItemClickListener{

        void click(View view, int adapterPosition);

    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    //自定义的ViewHolder
   class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView livetitle;
        private ImageView pandaLiveImg;

        public ViewHolder(View view, OnItemClickListener onItemClickListener) {
            super(view);
            livetitle = view.findViewById(R.id.livetitle);
            pandaLiveImg = view.findViewById(R.id.pandaLiveImg);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (onItemClickListener !=null)
                onItemClickListener.click(view,getAdapterPosition());
        }
    }
}
