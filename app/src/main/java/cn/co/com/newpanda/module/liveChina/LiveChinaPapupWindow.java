package cn.co.com.newpanda.module.liveChina;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.co.com.newpanda.R;
import cn.co.com.newpanda.model.entity.livechinaBean.ShuLiveChina;
import cn.co.com.newpanda.model.entity.livechinaBean.dao.DaoMaster;
import cn.co.com.newpanda.model.entity.livechinaBean.dao.DaoSession;
import cn.co.com.newpanda.model.entity.livechinaBean.dao.ShuLiveChinaDao;

import static cn.co.com.newpanda.app.App.context;


/**
 * Created by Administrator on 2017/09/14.
 */

public class LiveChinaPapupWindow extends PopupWindow {
    private final View mContentView;
    private int mWidth;
    private int mHeight;
    private final ImageView imageView;
    private ArrayList<String> list1;
    private ArrayList<String> list2;
    private final TextView pupBianji;
    private final LiVeChinaGridLayout gridQ;
    private final LiVeChinaGridLayout gridT;
    private  int BIANJI = 1;
    private ShuLiveChinaDao shuLiveChinaDao;
    private ShuLiveChinaDao shuLiveChinaDao2;

    public LiveChinaPapupWindow(final Context context) {
        super(context);
        //计算宽度和高度
        calWidthAndHeight(context);
        setWidth(mWidth);
        setHeight(mHeight);
        mContentView = LayoutInflater.from(context).inflate(R.layout.papu_livechina, null);
        //设置布局与相关属性
        setContentView(mContentView);
        setFocusable(true);
        setTouchable(true);
        setTouchable(true);
        imageView = mContentView.findViewById(R.id.liveChina_img);
        pupBianji = (TextView)mContentView.findViewById(R.id.pup_bianji);
        gridQ = mContentView.findViewById(R.id.grid_q);
        gridT = mContentView.findViewById(R.id.grid_t);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();

            }
        });

        initDao();
        initGridLayout();
        pupBianji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pupBianji.getText().equals("编辑")){
                    pupBianji.setText("完成");
                        gridT.setOnItemClickListener(new LiVeChinaGridLayout.OnItemClickListener() {
                            @Override
                            public void onItemClick(TextView tv) {
                                String s = tv.getText().toString();
                                gridT.removeView(tv);
                                gridQ.addItem(s);
                                ShuLiveChina shuLiveChina = new ShuLiveChina();
                                shuLiveChina.setTitle(s);
                                shuLiveChinaDao.insert(shuLiveChina);
                                shuLiveChinaDao2.delete(shuLiveChina);
                            }
                        });
                        gridQ.setOnItemClickListener(new LiVeChinaGridLayout.OnItemClickListener() {
                            @Override
                            public void onItemClick(TextView tv) {
                                String s = tv.getText().toString();
                                gridQ.removeView(tv);
                                gridT.addItem(s);
                                ShuLiveChina shuLiveChina = new ShuLiveChina();
                                shuLiveChina.setTitle(s);
                                shuLiveChinaDao2.insert(shuLiveChina);
                                shuLiveChinaDao.delete(shuLiveChina);
                            }
                        });
                }else {
                    pupBianji.setText("编辑");
                    gridT.setOnItemClickListener(new LiVeChinaGridLayout.OnItemClickListener() {
                        @Override
                        public void onItemClick(TextView tv) {
                            String s =  tv.getText().toString();

                        }
                    });
                    gridQ.setOnItemClickListener(new LiVeChinaGridLayout.OnItemClickListener() {
                        @Override
                        public void onItemClick(TextView tv) {
                            String s = tv.getText().toString();

                        }
                    });
                }

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
    }

    private void initGridLayout() {
        gridQ.setEnableDrag(true);
        list1 = new ArrayList<>();
        List<ShuLiveChina> listShus1 = shuLiveChinaDao.queryBuilder().list();
        for (int i = 0; i < listShus1.size(); i++) {
            String title = listShus1.get(i).getTitle();
            list1.add(title);
        }
        gridQ.setItemList(list1);




        gridT.setEnableDrag(false);
        list2 = new ArrayList<String>();
        List<ShuLiveChina> listShus2 = shuLiveChinaDao2.queryBuilder().list();
        for (int i = 0; i < listShus2.size(); i++) {
            String title = listShus2.get(i).getTitle();
            list2.add(title);
        }
        gridT.setItemList(list2);


    }

    private void calWidthAndHeight(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(metrics);

        mWidth = metrics.widthPixels;
        //设置高度为全屏高度
        mHeight = (int) (metrics.heightPixels);
    }

}
