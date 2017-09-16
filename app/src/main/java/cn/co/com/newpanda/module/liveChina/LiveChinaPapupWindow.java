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
import cn.co.com.newpanda.model.entity.LiVeChinaBean;


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
    private List<LiVeChinaBean.AlllistBean> listalllistBeen;
    private List<LiVeChinaBean.TablistBean> listtablistBeen;
    private  int BIANJI = 1;

    public LiveChinaPapupWindow(Context context, List<LiVeChinaBean.AlllistBean> listalllistBeen,List<LiVeChinaBean.TablistBean> listtablistBeen) {
        super(context);
        this.listalllistBeen = listalllistBeen;
        this.listtablistBeen =listtablistBeen;
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
        if (pupBianji.getText().equals("编辑")){
            pupBianji.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pupBianji.setText("完成");
                }
            });

        }else {
            pupBianji.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pupBianji.setText("编辑");
                }
            });
        }



        initGridLayout();
        pupBianji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BIANJI+=1;
                switch (BIANJI%2){
                    case 0:
                        pupBianji.setText("完成");
                        gridT.setOnItemClickListener(new LiVeChinaGridLayout.OnItemClickListener() {
                            @Override
                            public void onItemClick(TextView tv) {
                                gridT.removeView(tv);
                                gridQ.addItem(tv.getText().toString());

                            }
                        });
                        gridQ.setOnItemClickListener(new LiVeChinaGridLayout.OnItemClickListener() {
                            @Override
                            public void onItemClick(TextView tv) {
                                gridQ.removeView(tv);
                                gridT.addItem(tv.getText().toString());
                            }
                        });
                        break;
                    case 1:
                        pupBianji.setText("编辑");
                        gridT.setClickable(false);
                        gridQ.setClickable(false);
                        break;
                }



            }
        });




    }

    private void initGridLayout() {
        gridQ.setEnableDrag(true);
        list1 = new ArrayList<String>();
        for (int i = 0; i < listtablistBeen.size(); i++) {

            list1.add(listtablistBeen.get(i).getTitle());

        }
        gridQ.setItemList(list1);

        gridT.setEnableDrag(false);
        list2 = new ArrayList<String>();
        for (int i = 0; i < listalllistBeen.size(); i++) {
            list2.add(listalllistBeen.get(i).getTitle());
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
