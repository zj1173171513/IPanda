package cn.co.com.newpanda.view.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.co.com.newpanda.adapter.MyAdapter;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.base.BaseFragment;
import cn.co.com.newpanda.model.entity.BillowingVideoBean.BillowingVideolistBean;
import cn.co.com.newpanda.model.entity.PandaLiveBean;
import cn.co.com.newpanda.module.home.HomeContract;
import cn.co.com.newpanda.net.OkHttpUtils;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;
import cn.co.com.newpanda.view.activity.BillowingVideoActicity.ShiPinActivity;

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

    private List<BillowingVideolistBean.ListBean> listBeen = new ArrayList<>();
    private ImageView image;

    @Override
    protected int getLayoutId() {
        return R.layout.billowingvideo_fragment;

    }

    @Override
    protected void init(View view) {
        liListview = view.findViewById(R.id.li_listView);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.item_tou, null);

        ImageView image = inflate.findViewById(R.id.tou_image);

        liListview.addHeaderView(inflate);

    }

    @Override
    protected void loadData() {
        OkHttpUtils.getInstance().get(url, null, new MyNetWorkCallback<BillowingVideolistBean>() {
            @Override
            public void onSuccess(BillowingVideolistBean billowingVideolistBean) {
                listBeen.addAll(billowingVideolistBean.getList());
                billowing = billowingVideolistBean;

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
                intent.putExtra("url", listBeen.get(i).getId());
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
    public void setResult(PandaLiveBean pandaLiveBean) {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {

    }
}
