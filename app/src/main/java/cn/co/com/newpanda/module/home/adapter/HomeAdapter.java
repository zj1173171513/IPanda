package cn.co.com.newpanda.module.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.recker.flybanner.FlyBanner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.model.entity.homeBean.CctvBean;
import cn.co.com.newpanda.model.entity.homeBean.HomeBean;
import cn.co.com.newpanda.model.entity.homeBean.NineBean;
import cn.co.com.newpanda.module.home.homeactivity.VideoActivity;
import cn.co.com.newpanda.module.home.homeactivity.WebViewActivity;
import cn.co.com.newpanda.module.home.homehttp.OkHttpUtil;
import cn.co.com.newpanda.view.activity.TwoActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by ASUS on 2017/9/14.
 */

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<HomeBean.DataBean> mList;
    private Context mContext;
    private static final int TYPE_ONE = 0;
    private static final int TYPE_TWO = 1;
    private static final int TYPE_THREE = 2;
    private static final int TYPE_FOUR = 3;
    private static final int TYPE_FIVE = 4;
    private static final int TYPE_SIX = 5;
    private static final int TYPE_SEVEN = 6;
    private static final int TYPE_EIGHT = 7;
    private static final int TYPE_NINE = 8;
    private ArrayList<String> bigImgBeen;
    private List<HomeBean.DataBean.AreaBean.ListscrollBean> listscroll;

    public HomeAdapter(List<HomeBean.DataBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_ONE;
        } else if (position == 1) {
            return TYPE_TWO;
        } else if (position == 2) {
            return TYPE_THREE;
        } else if (position == 3) {
            return TYPE_FOUR;
        } else if (position == 4) {
            return TYPE_FIVE;
        } else if (position == 5) {
            return TYPE_SIX;
        } else if (position == 6) {
            return TYPE_SEVEN;
        } else if (position == 7) {
            return TYPE_EIGHT;
        } else if (position == 8) {
            return TYPE_NINE;
        }
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ONE) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.home_one_item, parent, false);
            return new OneViewHolder(inflate);
        } else if (viewType == TYPE_TWO) {
            return new TwoViewHolder(LayoutInflater.from(mContext).inflate(R.layout.home_two_item, parent, false));
        } else if (viewType == TYPE_THREE) {
            return new ThreeViewHolder(LayoutInflater.from(mContext).inflate(R.layout.home_three_item, parent, false));
        } else if (viewType == TYPE_FOUR) {
            return new FourViewHolder(LayoutInflater.from(mContext).inflate(R.layout.home_four_item, parent, false));
        } else if (viewType == TYPE_FIVE) {
            return new FiveViewHolder(LayoutInflater.from(mContext).inflate(R.layout.home_four_item, parent, false));
        } else if (viewType == TYPE_SIX) {
            return new SixViewHolder(LayoutInflater.from(mContext).inflate(R.layout.home_four_item, parent, false));
        } else if (viewType == TYPE_SEVEN) {
            return new SevenViewHolder(LayoutInflater.from(mContext).inflate(R.layout.home_five_item, parent, false));
        } else if (viewType == TYPE_EIGHT) {
            return new EightViewHolder(LayoutInflater.from(mContext).inflate(R.layout.home_six_item, parent, false));
        } else if (viewType == TYPE_NINE) {
            return new NineViewHolder(LayoutInflater.from(mContext).inflate(R.layout.home_nine_item, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof OneViewHolder) {
            setFloorOne((OneViewHolder) holder);
        } else if (holder instanceof TwoViewHolder) {
            setFloorTwo((TwoViewHolder) holder);
        } else if (holder instanceof ThreeViewHolder) {
            setFloorThree((ThreeViewHolder) holder);
        } else if (holder instanceof FourViewHolder) {
            setFloorFour((FourViewHolder) holder);
        } else if (holder instanceof FiveViewHolder) {
            setFloorFive((FiveViewHolder) holder);
        } else if (holder instanceof SixViewHolder) {
            setFloorSix((SixViewHolder) holder);
        } else if (holder instanceof SevenViewHolder) {
            setFloorSeven((SevenViewHolder) holder);
        } else if (holder instanceof EightViewHolder) {
            setFloorEight((EightViewHolder) holder);
        } else if (holder instanceof NineViewHolder) {
            setFloorNint((NineViewHolder) holder);
        }
    }

    private void setFloorNint(final NineViewHolder holder) {
        List<HomeBean.DataBean.ListBeanXXX> list = mList.get(0).getList();
            holder.nineTitle.setText(list.get(0).getTitle());
        OkHttpUtil.getInstance().getRequest(list.get(0).getListUrl(), new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG", e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                NineBean nineBean = gson.fromJson(string, NineBean.class);
                final List<NineBean.ListBean> list1 = nineBean.getList();
                ((TwoActivity) mContext).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        LinearLayoutManager manager = new LinearLayoutManager(mContext);
                        manager.setOrientation(LinearLayoutManager.VERTICAL);
                        holder.nineRecy.setLayoutManager(manager);
                        ListAdapter listAdapter = new ListAdapter(mContext, list1);
                        holder.nineRecy.setAdapter(listAdapter);
                    }
                });
            }
        });
    }

    private void setFloorEight(final EightViewHolder holder) {
        holder.sixItemTitle.setText(mList.get(0).getCctv().getTitle());
        OkHttpUtil.getInstance().getRequest(mList.get(0).getCctv().getListurl(), new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG", e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                CctvBean cctvBean = gson.fromJson(string, CctvBean.class);
                final List<CctvBean.ListBean> list = cctvBean.getList();
                ((TwoActivity) mContext).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        GridLayoutManager manager = new GridLayoutManager(mContext, 2);
                        holder.itemSixRecy.setLayoutManager(manager);
                        CctvAdapter cctvAdapter = new CctvAdapter(mContext, list);
                        holder.itemSixRecy.setAdapter(cctvAdapter);
                    }
                });
            }
        });
    }

    private void setFloorSeven(SevenViewHolder holder) {
        HomeBean.DataBean.InteractiveBean interactive = mList.get(0).getInteractive();
        holder.fiveItemTitle.setText(interactive.getTitle());
        final List<HomeBean.DataBean.InteractiveBean.InteractiveoneBean> interactiveone = interactive.getInteractiveone();
        for (int i = 0; i < interactiveone.size(); i++) {
            holder.fiveItemContent.setText(interactiveone.get(i).getTitle());
            Glide.with(mContext).load(interactiveone.get(i).getImage()).into(holder.fiveItemImg);
        }
        holder.fiveItemImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,WebViewActivity.class);
                intent.putExtra("title",interactiveone.get(0).getTitle());
                intent.putExtra("url",interactiveone.get(0).getUrl());
                mContext.startActivity(intent);
            }
        });
    }

    private void setFloorSix(SixViewHolder holder) {
        HomeBean.DataBean.ChinaliveBean pandalive = mList.get(0).getChinalive();
        holder.fourItemTitle.setText(pandalive.getTitle());
        List<HomeBean.DataBean.ChinaliveBean.ListBeanXX> list = pandalive.getList();
        GridLayoutManager manager = new GridLayoutManager(mContext, 3);
        holder.fourItemRecy.setLayoutManager(manager);
        HomeSixAdapter homeFourAdapter = new HomeSixAdapter(mContext, list);
        holder.fourItemRecy.setAdapter(homeFourAdapter);

    }
    //长城直播
    private void setFloorFive(FiveViewHolder holder) {
        HomeBean.DataBean.WallliveBean pandalive = mList.get(0).getWalllive();
        holder.fourItemTitle.setText(pandalive.getTitle());
        List<HomeBean.DataBean.WallliveBean.ListBeanX> list = pandalive.getList();
        GridLayoutManager manager = new GridLayoutManager(mContext, 3);
        holder.fourItemRecy.setLayoutManager(manager);
        HomeFiveAdapter homeFourAdapter = new HomeFiveAdapter(mContext, list);
        holder.fourItemRecy.setAdapter(homeFourAdapter);
    }

    private void setFloorFour(FourViewHolder holder) {
        HomeBean.DataBean.PandaliveBean pandalive = mList.get(0).getPandalive();
        holder.fourItemTitle.setText(pandalive.getTitle());
        List<HomeBean.DataBean.PandaliveBean.ListBean> list = pandalive.getList();
        GridLayoutManager manager = new GridLayoutManager(mContext, 3);
        holder.fourItemRecy.setLayoutManager(manager);
        HomeFourAdapter homeFourAdapter = new HomeFourAdapter(mContext, list);
        holder.fourItemRecy.setAdapter(homeFourAdapter);
    }

    private void setFloorThree(ThreeViewHolder holder) {
        HomeBean.DataBean.PandaeyeBean pandaeye = mList.get(0).getPandaeye();
        holder.threeItemTitle.setText(pandaeye.getTitle());
        Glide.with(mContext).load(pandaeye.getPandaeyelogo()).into(holder.threeOneImg);
        List<HomeBean.DataBean.PandaeyeBean.ItemsBean> items = pandaeye.getItems();
        for (int i = 0; i < items.size(); i++) {
            holder.threeOneTitle.setText(items.get(i).getTitle());
            holder.threeTwoTitle.setText(items.get(i).getTitle());
        }
        holder.threeOneTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<HomeBean.DataBean.PandaeyeBean.ItemsBean> items1 = mList.get(0).getPandaeye().getItems();
                Intent intent = new Intent(mContext,VideoActivity.class);
                intent.putExtra("url",items1.get(0).getPid());
                intent.putExtra("title",items1.get(0).getTitle());
                mContext.startActivity(intent);
            }
        });
        holder.threeTwoTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<HomeBean.DataBean.PandaeyeBean.ItemsBean> items1 = mList.get(0).getPandaeye().getItems();
                Intent intent = new Intent(mContext,VideoActivity.class);
                intent.putExtra("url",items1.get(1).getPid());
                intent.putExtra("title",items1.get(1).getTitle());
                mContext.startActivity(intent);
            }
        });
    }

    private void setFloorTwo(TwoViewHolder holder) {
        listscroll = mList.get(0).getArea().getListscroll();
        holder.twoItemTitle.setText(mList.get(0).getArea().getTitle());
        Glide.with(mContext).load(mList.get(0).getArea().getImage()).into(holder.twoItemImg);
        setRecyclerView(holder.twoItemRecy);
    }

    private void setRecyclerView(RecyclerView twoItemRecy) {
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        twoItemRecy.setLayoutManager(manager);
        HomeTwoAdapter homeTwoAdapter = new HomeTwoAdapter(mContext, listscroll);
        twoItemRecy.setAdapter(homeTwoAdapter);
    }

    private void setFloorOne(OneViewHolder holder) {
        bigImgBeen = new ArrayList<>();
        final List<HomeBean.DataBean.BigImgBean> bigImg = mList.get(0).getBigImg();
        for (int i = 0; i < bigImg.size(); i++) {
            String image = bigImg.get(i).getImage();
            bigImgBeen.add(image);
        }
        holder.homeBanner.setImagesUrl(bigImgBeen);
        holder.homeBanner.setOnItemClickListener(new FlyBanner.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if (position == 0){
                    Intent intent = new Intent(mContext, WebViewActivity.class);
                    intent.putExtra("title",bigImg.get(position).getTitle());
                    intent.putExtra("url",bigImg.get(position).getUrl());
                    mContext.startActivity(intent);
                }else {
                    Intent intent = new Intent(mContext,VideoActivity.class);
                    intent.putExtra("url",bigImg.get(position).getPid());
                    intent.putExtra("title",bigImg.get(position).getTitle());
                    mContext.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class OneViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.home_banner)
        FlyBanner homeBanner;

        public OneViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class TwoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.two_item_img)
        ImageView twoItemImg;
        @BindView(R.id.two_item_title)
        TextView twoItemTitle;
        @BindView(R.id.two_item_recy)
        RecyclerView twoItemRecy;

        public TwoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class ThreeViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.three_item_title)
        TextView threeItemTitle;
        @BindView(R.id.three_one_img)
        ImageView threeOneImg;
        @BindView(R.id.three_one_title)
        TextView threeOneTitle;
        @BindView(R.id.three_two_title)
        TextView threeTwoTitle;
//        @Bind(R.id.three_two_img)
//        ImageView threeTwoImg;
//        @Bind(R.id.three_four_title)
//        TextView threeFourTitle;
//        @Bind(R.id.three_four_time)
//        TextView threeFourTime;
//        @Bind(R.id.three_three_img)
//        ImageView threeThreeImg;
//        @Bind(R.id.three_five_title)
//        TextView threeFiveTitle;
//        @Bind(R.id.three_five_time)
//        TextView threeFiveTime;

        public ThreeViewHolder(View inflate) {
            super(inflate);
            ButterKnife.bind(this, inflate);
        }
    }

    public class FourViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.four_item_title)
        TextView fourItemTitle;
        @BindView(R.id.four_item_recy)
        RecyclerView fourItemRecy;

        public FourViewHolder(View inflate) {
            super(inflate);
            ButterKnife.bind(this, inflate);
        }
    }

    public class FiveViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.four_item_title)
        TextView fourItemTitle;
        @BindView(R.id.four_item_recy)
        RecyclerView fourItemRecy;

        public FiveViewHolder(View inflate) {
            super(inflate);
            ButterKnife.bind(this, inflate);
        }
    }

    public class SixViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.four_item_title)
        TextView fourItemTitle;
        @BindView(R.id.four_item_recy)
        RecyclerView fourItemRecy;

        public SixViewHolder(View inflate) {
            super(inflate);
            ButterKnife.bind(this, inflate);
        }
    }

    public class SevenViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.five_item_title)
        TextView fiveItemTitle;
        @BindView(R.id.five_item_img)
        ImageView fiveItemImg;
        @BindView(R.id.five_item_content)
        TextView fiveItemContent;

        public SevenViewHolder(View inflate) {
            super(inflate);
            ButterKnife.bind(this, inflate);
        }
    }

    public class EightViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.six_item_title)
        TextView sixItemTitle;
        @BindView(R.id.item_six_recy)
        RecyclerView itemSixRecy;

        public EightViewHolder(View inflate) {
            super(inflate);
            ButterKnife.bind(this, inflate);
        }
    }

    public class NineViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.nine_title)
        TextView nineTitle;
        @BindView(R.id.nine_recy)
        RecyclerView nineRecy;

        public NineViewHolder(View inflate) {
            super(inflate);
            ButterKnife.bind(this, inflate);
        }
    }
}
