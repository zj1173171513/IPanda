package cn.co.com.newpanda.adapter.BoBaoAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import cn.co.com.newpanda.R;
import cn.co.com.newpanda.model.entity.BoBaoBean.PandaBroadcastInfoBean;

/**
 * Created by Administrator on 2017/9/18.
 */

public class MyRecycAdapter extends BaseAdapter {
    private Context context;
    private List<PandaBroadcastInfoBean.ListBean> data;

    public MyRecycAdapter(Context context, List<PandaBroadcastInfoBean.ListBean> data) {
        this.context = context;
        this.data = data;
    }



    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {

        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //赋值ViewHolder
        ViewHolder holder = null;
        if (view == null) {
            view = View.inflate(context, R.layout.item_pdbcinfo, null);
            holder = new ViewHolder();
            holder.image=(ImageView)view.findViewById(R.id.image);
            holder.tv_time=(TextView)view.findViewById(R.id.tv_time);
            holder.tv_title=(TextView)view.findViewById(R.id.tv_title);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        final PandaBroadcastInfoBean.ListBean mm = data.get(i);
        holder.tv_title.setText(mm.getTitle());
        holder.tv_time.setText(mm.getDatatype());
        Glide.with(context).load(mm.getPicurl()).into(holder.image);
        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView image;
        public TextView tv_title;
        public TextView tv_time;

//        public ViewHolder(View rootView) {
//            this.rootView = rootView;
//            this.image=(ImageView)rootView.findViewById(R.id.image);
//            this.tv_time=(TextView)rootView.findViewById(R.id.tv_time);
//            this.tv_title=(TextView)rootView.findViewById(R.id.tv_title);
//        }

    }
}
