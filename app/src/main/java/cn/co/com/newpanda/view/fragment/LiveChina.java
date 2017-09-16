package cn.co.com.newpanda.view.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.adapter.LiveChinaStatePagerAdapter;
import cn.co.com.newpanda.base.BaseFragment;
import cn.co.com.newpanda.model.entity.LiVeChinaBean;
import cn.co.com.newpanda.module.liveChina.LiveChinaPapupWindow;
import cn.co.com.newpanda.net.OkHttpUtils;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;

import static cn.co.com.newpanda.config.Urls.LIVECHINA;


/**
 * Created by Administrator on 2017/9/12.
 * 作者：大姨夫
 * 站在顶峰,看世界
 * 跌在谷底,思人生
 */

public class LiveChina extends BaseFragment {
    @BindView(R.id.tab_china)
    TabLayout tabChina;
    @BindView(R.id.live_china_img)
    ImageView img;
    @BindView(R.id.pager_china)
    ViewPager pagerChina;
    Unbinder unbinder;
    private LiveChinaPapupWindow liveChinaPapupWindow;

    private List<LiVeChinaBean.AlllistBean> listalllistBeen = new ArrayList<>();
    private List<LiVeChinaBean.TablistBean> listtablistBeen = new ArrayList<>();
    private List<Fragment> listfrag = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.livechina_fragment;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {

        //请求
        OkHttpUtils.getInstance().get(LIVECHINA, null, new MyNetWorkCallback<LiVeChinaBean>() {

            @Override
            public void onSuccess(LiVeChinaBean liVeChinaBean) {
                listalllistBeen.addAll(liVeChinaBean.getAlllist());
                listtablistBeen.addAll(liVeChinaBean.getTablist());


                for (int i = 0; i < listalllistBeen.size(); i++) {
                    listfrag.add(new ZiLiveChinaFragment());
                }
                LiveChinaStatePagerAdapter liveChinaStatePagerAdapter = new LiveChinaStatePagerAdapter(getActivity()
                        .getSupportFragmentManager(),listfrag,listtablistBeen);
                tabChina.setupWithViewPager(pagerChina);
                pagerChina.setAdapter(liveChinaStatePagerAdapter);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });







        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                liveChinaPapupWindow = new LiveChinaPapupWindow(getActivity(),listalllistBeen,listtablistBeen);
                liveChinaPapupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        // popupWindow隐藏时恢复屏幕正常透明度
                        setBackgroundAlpha();
                    }
                });

                //点击时弹出PopupWindow，屏幕变暗
                liveChinaPapupWindow.setAnimationStyle(R.style.dialogWindowAnim);
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.livechina_fragment, null);
                liveChinaPapupWindow.showAsDropDown(inflate);

            }
        });



    }
    public void setBackgroundAlpha() {
        WindowManager.LayoutParams lp=getActivity().getWindow().getAttributes();
        lp.alpha=1.0f;
        getActivity().getWindow().setAttributes(lp);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
