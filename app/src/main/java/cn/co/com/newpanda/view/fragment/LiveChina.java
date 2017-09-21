package cn.co.com.newpanda.view.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import cn.co.com.newpanda.model.entity.livechinaBean.LiVeChinaBean;
import cn.co.com.newpanda.model.entity.livechinaBean.ShuLiveChina;
import cn.co.com.newpanda.model.entity.livechinaBean.dao.DaoMaster;
import cn.co.com.newpanda.model.entity.livechinaBean.dao.DaoSession;
import cn.co.com.newpanda.model.entity.livechinaBean.dao.ShuLiveChinaDao;
import cn.co.com.newpanda.module.liveChina.LiveChinaPapupWindow;
import cn.co.com.newpanda.net.OkHttpUtils;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;

import static cn.co.com.newpanda.app.App.context;
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
    private ShuLiveChinaDao shuLiveChinaDao;
    private List<ShuLiveChina> listdao = new ArrayList<>();
    private LiveChinaStatePagerAdapter liveChinaStatePagerAdapter;
    private Handler handler= new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    liveChinaStatePagerAdapter.notifyDataSetChanged();
                    break;
            }
        }
    };
    private ShuLiveChinaDao shuLiveChinaDao2;
    private ShuLiveChinaDao shuLiveChinaDao3;

    @Override
    protected int getLayoutId() {
        return R.layout.livechina_fragment;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {
        initDao();
        //请求
        OkHttpUtils.getInstance().get(LIVECHINA, null, new MyNetWorkCallback<LiVeChinaBean>() {

            private List<ShuLiveChina> listShu2;

            @Override
            public void onSuccess(LiVeChinaBean liVeChinaBean) {
                listalllistBeen.addAll(liVeChinaBean.getAlllist());
                listtablistBeen.addAll(liVeChinaBean.getTablist());
                List<ShuLiveChina> listShu3 =  shuLiveChinaDao3.queryBuilder().list();
                if (listShu3.size()==0){
                    for (int i = 0; i < listalllistBeen.size(); i++) {
                        String title = listalllistBeen.get(i).getTitle();
                        String url = listalllistBeen.get(i).getUrl();
                        ShuLiveChina shuLiveChina = new ShuLiveChina();
                        shuLiveChina.setTitle(title);
                        shuLiveChina.setUrl(url);
                        shuLiveChinaDao3.insert(shuLiveChina);
                    }
                }
                List<ShuLiveChina> listShu2 =  shuLiveChinaDao2.queryBuilder().list();
                if (listShu2.size()==0){
                    for (int i = 0; i < listalllistBeen.size(); i++) {
                        String title = listalllistBeen.get(i).getTitle();
                        ShuLiveChina shuLiveChina = new ShuLiveChina();
                        shuLiveChina.setTitle(title);
                        shuLiveChinaDao2.insert(shuLiveChina);
                    }
                }
                List<ShuLiveChina> listShu1 = shuLiveChinaDao.queryBuilder().list();
                if (listShu1.size()==0){
                    for (int i = 0; i < listtablistBeen.size(); i++) {
                        String title = listtablistBeen.get(i).getTitle();
                        ShuLiveChina shuLiveChina = new ShuLiveChina();
                        shuLiveChina.setTitle(title);
                        shuLiveChinaDao.insert(shuLiveChina);
                        ShuLiveChina unique = shuLiveChinaDao2.queryBuilder().where(ShuLiveChinaDao.Properties.Title.eq(title)).build().unique();
                        shuLiveChinaDao2.delete(unique);
                    }
                }
                List<ShuLiveChina> listShus1 = shuLiveChinaDao.queryBuilder().list();
                listdao.addAll(listShus1);

                for (int i = 0; i < listdao.size(); i++) {
                    String title = listdao.get(i).getTitle();
                    ShuLiveChina unique = shuLiveChinaDao3.queryBuilder().where(ShuLiveChinaDao.Properties.Title.eq(title)).build().unique();
                    String url = unique.getUrl();
                    listfrag.add(new ZiLiveChinaFragment(url));
                }
                liveChinaStatePagerAdapter = new LiveChinaStatePagerAdapter(getActivity().getSupportFragmentManager(), listfrag,listdao);
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
                liveChinaPapupWindow = new LiveChinaPapupWindow(getActivity());
                liveChinaPapupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        // popupWindow隐藏时恢复屏幕正常透明度
                        setBackgroundAlpha();
                        listdao.clear();
                        List<ShuLiveChina> listSh = shuLiveChinaDao.queryBuilder().list();
                        listdao.addAll(listSh);
                        listfrag.clear();
                        for (int i = 0; i < listdao.size(); i++) {
                            String title = listdao.get(i).getTitle();
                            ShuLiveChina unique = shuLiveChinaDao3.queryBuilder().where(ShuLiveChinaDao.Properties.Title.eq(title)).build().unique();
                            String url = unique.getUrl();
                            listfrag.add(new ZiLiveChinaFragment(url));
                        }
                        handler.sendEmptyMessage(0);

                    }
                });
                //点击时弹出PopupWindow，屏幕变暗
                liveChinaPapupWindow.setAnimationStyle(R.style.dialogWindowAnim);
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.livechina_fragment, null);
                liveChinaPapupWindow.showAsDropDown(inflate);
                handler.sendEmptyMessage(0);
            }
        });




    }

    private void initDao() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context,"livechina.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getReadableDb());
        DaoSession daoSession = daoMaster.newSession();
        shuLiveChinaDao = daoSession.getShuLiveChinaDao();

        DaoMaster.DevOpenHelper devOpenHelper2 = new DaoMaster.DevOpenHelper(context,"livechina2.db");
        DaoMaster daoMaster2 = new DaoMaster(devOpenHelper2.getReadableDb());
        DaoSession daoSession2 = daoMaster2.newSession();
        shuLiveChinaDao2 = daoSession2.getShuLiveChinaDao();

        DaoMaster.DevOpenHelper devOpenHelper3 = new DaoMaster.DevOpenHelper(context,"livechina5.db");
        DaoMaster daoMaster3 = new DaoMaster(devOpenHelper3.getReadableDb());
        DaoSession daoSession3 = daoMaster3.newSession();
        shuLiveChinaDao3 = daoSession3.getShuLiveChinaDao();


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
