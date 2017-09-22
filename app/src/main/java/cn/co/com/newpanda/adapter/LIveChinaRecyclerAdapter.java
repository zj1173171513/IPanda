package cn.co.com.newpanda.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cn.co.com.newpanda.R;
import cn.co.com.newpanda.model.entity.livechinaBean.ZiLiveChinaBean;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by Administrator on 2017/09/16.
 */

public class LIveChinaRecyclerAdapter extends RecyclerView.Adapter<LIveChinaRecyclerAdapter.MyHolder> {

    private Context context;
    private List<ZiLiveChinaBean.LiveBean> listliveBeen;
//    private String hls1;
//    private List<String> listshi;

//    public LIveChinaRecyclerAdapter(Context context, List<ZiLiveChinaBean.LiveBean> listliveBeen,List<String> listshi) {
//        this.context = context;
//        this.listliveBeen = listliveBeen;
//        this.listshi = listshi;
//    }


    public LIveChinaRecyclerAdapter(Context context, List<ZiLiveChinaBean.LiveBean> listliveBeen) {
        this.context = context;
        this.listliveBeen = listliveBeen;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.livechina_item, null);
        MyHolder holder = new MyHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {

//        String id = listliveBeen.get(position).getId();
//        String urls = "http://vdn.live.cntv.cn/api2/live.do?channel=pa://cctv_p2p_hd"+id+"&amp;client=androidapp\n";
//        OkHttpUtils.getInstance().get(urls, null, new MyNetWorkCallback<LiveChinaShiPin.HlsUrlBean>() {
//            @Override
//            public void onSuccess(LiveChinaShiPin.HlsUrlBean hlsUrlBean) {
//                String hls2 = hlsUrlBean.getHls2();
//
//                holder.jcVideoPlayer.setUp(hls2, " ");
//            }
//
//            @Override
//            public void onError(int errorCode, String errorMsg) {
//
//            }
//        });
        String s = "http://3811.liveplay.myqcloud.com/live/m3u8/3811_channel1099.m3u8?AUTH=5f6lFq/Fi2FNo4uGza4oNt4QDI5GJ2lzMQ5yrClqK9XfIRgenWkYrsQKLYN1xVw8MZhTVbJZJ7uhlNU2aEOZqg==";
        Glide.with(context).load(listliveBeen.get(position).getImage()).into(holder.jcVideoPlayer.ivThumb);
//        if(listshi!=null && listshi.size()>0){
//            holder.jcVideoPlayer.setUp(s, "");
//        }
        holder.jcVideoPlayer.setUp(s, "");
        holder.lc_name.setText(listliveBeen.get(position).getTitle());
        holder.lc_info.setText(listliveBeen.get(position).getBrief());
        holder.lc_info.setVisibility(View.GONE);

        holder.lc_img.setOnClickListener(new View.OnClickListener() {
            public int a = 0;

            @Override
            public void onClick(View v) {
                a += 1;
                switch (a % 2) {
                    case 0:
                        holder.lc_img.setImageResource(R.mipmap.com_facebook_tooltip_blue_bottomnub);
                        holder.lc_info.setVisibility(View.GONE);
                        break;
                    case 1:
                        holder.lc_img.setImageResource(R.mipmap.com_facebook_tooltip_blue_topnub);
                        holder.lc_info.setVisibility(View.VISIBLE);

                        break;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return listliveBeen.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        private final View view;
        private final JCVideoPlayer jcVideoPlayer;
        private final TextView lc_name;
        private final TextView lc_info;
        private final ImageView lc_img;

        public MyHolder(View itemView) {
            super(itemView);
            view = itemView;
            jcVideoPlayer = (JCVideoPlayer)itemView.findViewById(R.id.lc_videocontroller1);
            lc_name = (TextView) itemView.findViewById(R.id.lc_name);
            lc_info = (TextView) itemView.findViewById(R.id.lc_info);
            lc_img = (ImageView) itemView.findViewById(R.id.lc_img);

        }
    }
}
