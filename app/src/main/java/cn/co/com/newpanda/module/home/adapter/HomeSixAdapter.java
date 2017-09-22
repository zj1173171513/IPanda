package cn.co.com.newpanda.module.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.app.AppService;
import cn.co.com.newpanda.model.entity.homeBean.HomeBean;
import cn.co.com.newpanda.model.entity.homeBean.HomeLiveBean;
import cn.co.com.newpanda.module.home.homeactivity.HomeLiveActivity;
import cn.co.com.newpanda.module.home.homehttp.OkHttpUtil;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by ASUS on 2017/9/15.
 */

class HomeSixAdapter extends RecyclerView.Adapter<HomeSixAdapter.ViewHolder> {

    private Context context;
    private List<HomeBean.DataBean.ChinaliveBean.ListBeanXX> list;
    private int count;

    public HomeSixAdapter(Context mContext, List<HomeBean.DataBean.ChinaliveBean.ListBeanXX> list) {
        this.context = mContext;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.four_recy_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.fourItemTwoText.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getImage()).into(holder.fourItemOneImg);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                if (count == 1){
                    String id = list.get(position).getId();
                    OkHttpUtil.getInstance().getRequest(AppService.LIVE_URL + id + "&amp;client=androidapp", new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            Log.e("TAG",e.toString());
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            String string = response.body().string();
                            Gson gson = new Gson();
                            HomeLiveBean homeLiveBean = gson.fromJson(string, HomeLiveBean.class);
                            String hls1 = homeLiveBean.getHls_url().getHls1();
                            String flv2 = homeLiveBean.getFlv_url().getFlv2();
                            Intent intent = new Intent(context, HomeLiveActivity.class);
                            intent.putExtra("url",hls1);
                            intent.putExtra("title",list.get(position).getTitle());
                            context.startActivity(intent);
                        }
                    });
                }else {
                    Toast.makeText(context, "美女正在路上，请骚等！", Toast.LENGTH_SHORT).show();
                    count = 0;
                    return;
                }

            }
        });
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
