package cn.co.com.newpanda.adapter.BoBaoAdapter;

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
import cn.co.com.newpanda.model.entity.BoBaoBean.PandaBroadcastInfoBean;
import cn.co.com.newpanda.view.activity.BoBao.WebViewActivity;

/**
 * Created by Administrator on 2017/9/18.
 */

public class MyRecycAdapter extends RecyclerView.Adapter<MyRecycAdapter.ViewHolder>{
    private Context context;
    private List<PandaBroadcastInfoBean.ListBean> data;

    public MyRecycAdapter(Context context, List<PandaBroadcastInfoBean.ListBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(context).inflate(R.layout.item_pdbcinfo, parent, false);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        itemview.setLayoutParams(layoutParams);
        ViewHolder viewHolder = new ViewHolder(itemview);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final PandaBroadcastInfoBean.ListBean mm = data.get(position);
        holder.title.setText(mm.getTitle());
        holder.time.setText(mm.getDatatype());
        Glide.with(context).load(mm.getPicurl()).into(holder.image);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, WebViewActivity.class);
                intent.putExtra("name",data.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView time;
        private ImageView image;
        //private   View   recycleItemview;
        private View view;
        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            //recycleItemview=itemView;
            title = (TextView) itemView.findViewById(R.id.tv_title);
            time = (TextView) itemView.findViewById(R.id.tv_time);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
