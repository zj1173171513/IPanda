package cn.co.com.newpanda.adapter.pandalive_adapter.bottonlive_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.co.com.newpanda.R;
import cn.co.com.newpanda.model.entity.pandaliveBean.PingLunBean;

/**
 * Created by 丶 on 2017/9/14.
 */

public class MuchliveAdapter extends RecyclerView.Adapter<MuchliveAdapter.MyViewHolder> {
    private Context context;
    //private List<PingLunBean.DataBean> list2;
    private List<PingLunBean.DataBean.ContentBean> list;


    public MuchliveAdapter(List<PingLunBean.DataBean.ContentBean> list, Context context) {
        this.context = context;
        this.list = list;
        //this.list2 = list2;
    }



    @Override
    public MuchliveAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.seechat_recycle_item, null);
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(params);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MuchliveAdapter.MyViewHolder holder, int position) {
        holder.message.setText(list.get(position).getMessage());
        holder.wangyou.setText(list.get(position).getAuthor());
//        holder.total.setText(list2.get(position).getTotal());
//        Log.e("TAG",list2.get(position).getTotal());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView message;
        private final TextView wangyou;
        private final TextView total;

        public MyViewHolder(View itemView) {
            super(itemView);
            message = itemView.findViewById(R.id.message);
            wangyou = itemView.findViewById(R.id.wangyou);
            total = itemView.findViewById(R.id.total);
        }
    }
}
