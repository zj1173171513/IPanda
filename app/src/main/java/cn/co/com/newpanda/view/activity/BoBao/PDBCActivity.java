package cn.co.com.newpanda.view.activity.BoBao;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.co.com.newpanda.R;
import cn.co.com.newpanda.app.App;
import cn.co.com.newpanda.base.BaseActivity;
import cn.co.com.newpanda.config.UMengUtls;
import cn.co.com.newpanda.model.entity.BoBaoBean.PDBCInfotwoBean;
import cn.co.com.newpanda.model.entity.BoBaoBean.PandaBroadcastInfoBean;
import cn.co.com.newpanda.model.entity.livechinaBean.dao.DaoMaster;
import cn.co.com.newpanda.model.entity.livechinaBean.dao.DaoSession;
import cn.co.com.newpanda.model.entity.livechinaBean.dao.DaoUtil;
import cn.co.com.newpanda.model.entity.livechinaBean.dao.SQLBeans;
import cn.co.com.newpanda.model.entity.livechinaBean.dao.ShuLiveChinaDao;
import cn.co.com.newpanda.module.pandabroadcast.vedio.PDBCInfoContract;
import cn.co.com.newpanda.net.OkHttpUtils;
import cn.co.com.newpanda.net.callback.MyNetWorkCallback;

public class PDBCActivity extends BaseActivity {
    PDBCInfoContract.Presenter presenter;

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.image_shoucang)
    CheckBox imageShoucang;
    @BindView(R.id.image_share)
    CheckBox imageShare;
    @BindView(R.id.activity_pdbc)
    LinearLayout activityPdbc;
    private Handler handler;
    public static String id;
    private SQLiteDatabase w;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private ShuLiveChinaDao shu;
    private SQLBeans sqlBeans;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_pdbc;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        w = DaoUtil.getIn(App.getContext()).getW();
        daoMaster = new DaoMaster(w);
        daoSession = daoMaster.newSession();
        shu = daoSession.getShuLiveChinaDao();
        sqlBeans = new SQLBeans();
//        PandaBroadcastInfoBean.ListBean list = (PandaBroadcastInfoBean.ListBean) getIntent().getSerializableExtra("list");

//        id = list.getId();

        Intent intent = getIntent();
        PandaBroadcastInfoBean.ListBean list = intent.getParcelableExtra("list");
         id = list.getId();
        Log.e("Tag", PDBCActivity.id);
        final String path = "http://api.cntv.cn/article/contentinfo?id=" + PDBCActivity.id + "&serviceId=panda";
        OkHttpUtils.getInstance().get(path, null, new MyNetWorkCallback<PDBCInfotwoBean>(){
            @Override
            public void onSuccess(PDBCInfotwoBean pdbcInfotwoBean) {
                final String title1 = pdbcInfotwoBean.getTitle();
                final String pubtime = pdbcInfotwoBean.getPubtime();
                final String logo = pdbcInfotwoBean.getLogo();
                title.setText(title1);
                time.setText(pubtime);
                final String content = pdbcInfotwoBean.getContent();
                text.setMovementMethod(ScrollingMovementMethod.getInstance());
                handler = new Handler() {


                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        if (msg.what == 0 * 101) {

                            text.setText((CharSequence) msg.obj);
                        }
                    }
                };
                Thread t = new Thread(new Runnable() {
                    Message msg = Message.obtain();

                    @Override
                    public void run() {
                        Html.ImageGetter imageGetter = new Html.ImageGetter() {
                            @Override
                            public Drawable getDrawable(String s) {
                                URL url;
                                Drawable drawable = null;
                                try {
                                    url = new URL(s);
                                    drawable = Drawable.createFromStream(url.openStream(), null);
                                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth()*3, drawable.getIntrinsicHeight()*3);

                                } catch (MalformedURLException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }


                                return drawable;
                            }
                        };
                        CharSequence test = Html.fromHtml(content, imageGetter, null);
                        msg.what = 0 * 101;
                        msg.obj = test;
                        handler.sendMessage(msg);
                    }

                });
                t.start();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        imageShoucang.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(PDBCActivity.this, "你点击了收藏", Toast.LENGTH_SHORT).show();
//                                sqlBeans.setDaoUrl(path);
//                                sqlBeans.setUrlData(pubtime);
//                                sqlBeans.setUrlTitle(title1);
//
//                                sqlBeansDao.insert(sqlBeans);

                            }
                        });
                        imageShare.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(PDBCActivity.this, "网络有点不给力哦", Toast.LENGTH_SHORT).show();
                                UMImage imgs = new UMImage(App.context, logo);
                                new ShareAction(PDBCActivity.this)
                                        .setPlatform(SHARE_MEDIA.QQ)//传入平台
                                        .withText(path)
                                        .withMedia(imgs)
                                        .setCallback(UMengUtls.shareListener)//回调监听器
                                        .share();
                            }
                        });
                    }
                });

            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }



}