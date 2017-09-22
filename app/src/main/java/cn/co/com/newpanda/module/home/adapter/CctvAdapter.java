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
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.app.AppService;
import cn.co.com.newpanda.model.entity.homeBean.CctvBean;
import cn.co.com.newpanda.module.home.homeactivity.CctvActivity;

/**
 * Created by ASUS on 2017/9/15.
 */

class CctvAdapter extends RecyclerView.Adapter<CctvAdapter.ViewHolder> {


    private Context context;
    private List<CctvBean.ListBean> list;

    public CctvAdapter(Context mContext, List<CctvBean.ListBean> list) {
        this.context = mContext;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.ccty_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.cctvItemText.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getImage()).into(holder.cctvItemImg);
        holder.cctvItemItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(context, "此处没有pid", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,CctvActivity.class);
                if (position == 0){
                    intent.putExtra("cctv", AppService.GUO_URL);
                    intent.putExtra("won",AppService.GUO_WON);
                    intent.putExtra("position",position);
                } else if (position == 1) {
                    intent.putExtra("cctv",AppService.ZOU_URL);
                    intent.putExtra("won",AppService.ZOU_WON);
                    intent.putExtra("position",position);
                } else if (position == 2) {
                    intent.putExtra("cctv",AppService.HUA_URL);
                    intent.putExtra("won",AppService.HUA_WON);
                    intent.putExtra("position",position);
                }else if (position == 3){
                    intent.putExtra("cctv",AppService.ZHONG_URL);
                    intent.putExtra("won",AppService.ZHONG_WON);
                    intent.putExtra("position",position);
                }else {
                    Toast.makeText(context, "跑偏了跑偏了！", Toast.LENGTH_SHORT).show();
                }
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cctv_item_img)
        ImageView cctvItemImg;
        @BindView(R.id.cctv_item_text)
        TextView cctvItemText;
        @BindView(R.id.cctv_item_item)
        LinearLayout cctvItemItem;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
