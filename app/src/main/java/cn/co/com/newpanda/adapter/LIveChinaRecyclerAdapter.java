package cn.co.com.newpanda.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        holder.jcVideoPlayer.setUp("http://asp.cntv.lxdns.com/asp/hls/main/0303000a/3/default/b258dc46dd0044f9a66ab99345412822/main.m3u8?maxbr=4096", "视频/MP3标题");
//      videoController.ivThumb.setThumbInCustomProject("视频/MP3缩略图地址");
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
