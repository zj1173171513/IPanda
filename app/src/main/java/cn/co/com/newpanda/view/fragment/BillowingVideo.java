package cn.co.com.newpanda.view.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import cn.co.com.newpanda.R;
import cn.co.com.newpanda.adapter.BillowingVideoadapter.MyAdapter;
import cn.co.com.newpanda.app.App;
import cn.co.com.newpanda.base.BaseFragment;
import cn.co.com.newpanda.model.entity.BillowingVideoBean.BillowingVideolistBean;
import cn.co.com.newpanda.model.entity.PandaLiveBean;
import cn.co.com.newpanda.model.entity.homeBean.HomeBean;
import cn.co.com.newpanda.module.home.HomeContract;
import cn.co.com.newpanda.net.OkHttpUtils;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;
import cn.co.com.newpanda.view.activity.BillowingVideoActicity.ShiPinActivity;
import cn.co.com.newpanda.view.activity.BillowingVideoActicity.toushipinActivity;

/**
 * Created by Administrator on 2017/9/12.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class BillowingVideo extends BaseFragment implements HomeContract.View {
    String url = "http://www.ipanda.com/kehuduan/video/index.json";
    private ListView liListview;
    BillowingVideolistBean billowing;
    private ImageView addImg;
    private TextView addTitle;
    private List<BillowingVideolistBean.ListBean> listBeen = new ArrayList<>();
    private String pid;

    @Override
    protected int getLayoutId() {
        return R.layout.billowingvideo_fragment;

    }

    @Override
    protected void init(View view) {
        liListview = view.findViewById(R.id.li_listView);

        liListview.addHeaderView(View.inflate(App.context, R.layout.imglayout, null));
        addImg = view.findViewById(R.id.addImg);
        addTitle = view.findViewById(R.id.addTitle);

    }

    @Override
    protected void loadData() {
        OkHttpUtils.getInstance().get(url, null, new MyNetWorkCallback<BillowingVideolistBean>() {

            private String image;

            @Override
            public void onSuccess(BillowingVideolistBean billowingVideolistBean) {
                listBeen.addAll(billowingVideolistBean.getList());
                billowing = billowingVideolistBean;

                pid = billowing.getBigImg().get(0).getPid();
                image = billowing.getBigImg().get(0).getImage();
                Glide.with(App.context).load(image).fitCenter().into(addImg);
                addTitle.setText(billowing.getBigImg().get(0).getTitle());
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                Toast.makeText(getContext(), "您可能没网了", Toast.LENGTH_SHORT).show();
            }
        });

        MyAdapter adapter = new MyAdapter(listBeen, getContext());
        liListview.setAdapter(adapter);

        liListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), ShiPinActivity.class);
                intent.putExtra("id", listBeen.get(i - 1).getId());
                intent.putExtra("name", listBeen.get(i - 1).getTitle());
                startActivity(intent);
            }
        });
        addImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), toushipinActivity.class);
                intent.putExtra("pid", pid);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onHidden() {
        super.onHidden();
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void setResult(HomeBean homeBean) {

    }

    public void setResult(PandaLiveBean pandaLiveBean) {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {

    }
}
