package cn.co.com.newpanda.model.entity.homeBean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2017/9/20.
 */

public class CcAcBean implements Parcelable {
    @Override
    public String toString() {
        return "CcAcBean{" +
                "videoset=" + videoset +
                ", video=" + video +
                '}';
    }

    /**
     * videoset : {"0":{"vsid":"C14121","relvsid":"","name":"国宝档案","img":"http://p2.img.cctvpic.com/imagepic/nettv/explore/history/guobaodangan/ibugu/images/img1262400848646904.jpg","enname":"cctv4","url":"http://tv.cntv.cn/videoset/C14121","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"周一至周五 18:45","sbpd":"CCTV-4中文国际(亚)","desc":"《国宝档案》CCTV4亚洲首播：每天18：50重播：次日05：35<br>&nbsp;&nbsp;《国宝档案》栏目每期节目将介绍一个具体的国宝文物，这些凝聚着中华民族智慧和传统文化的历代传世国宝文物，既有受到政府保护收藏在祖国大陆各个博物馆中的，也有收藏于民间被国人精心呵护的；既有因历史原因东渡海峡存于宝岛台湾的，也有历尽磨难流失海外漂泊他乡的\u2026\u2026","playdesc":"","zcr":"","fcl":"CCTV-4 (亚洲)"},"count":"2643"}
     * video : [{"vsid":"C14121","order":"3176","vid":"19aebb121aa4490ba718f2b1cd62a7ae","t":"《国宝档案》 20170919 探秘什刹海\u2014\u2014火神庙里的前世今生","url":"http://tv.cntv.cn/video/C14121/19aebb121aa4490ba718f2b1cd62a7ae","ptime":"2017-09-19 18:45:00","img":"http://p5.img.cctvpic.com/fmspic/2017/09/19/19aebb121aa4490ba718f2b1cd62a7ae-430.jpg?p=2&h=120","len":"00:13:56","em":"CM01"},{"vsid":"C14121","order":"3175","vid":"7811791ac4a547358168804183e24b3e","t":"《国宝档案》 20170918 探秘什刹海\u2014\u2014崇忠念旧的贤良祠","url":"http://tv.cntv.cn/video/C14121/7811791ac4a547358168804183e24b3e","ptime":"2017-09-18 19:04:10","img":"http://p4.img.cctvpic.com/fmspic/2017/09/18/7811791ac4a547358168804183e24b3e-430.jpg?p=2&h=120","len":"00:13:57","em":"CM01"},{"vsid":"C14121","order":"3174","vid":"ac5951c37e1941c0a6dbb2cc69ef52c3","t":"《国宝档案》 20170915 海国微澜\u2014\u2014异国情调","url":"http://tv.cntv.cn/video/C14121/ac5951c37e1941c0a6dbb2cc69ef52c3","ptime":"2017-09-15 18:45:00","img":"http://p4.img.cctvpic.com/fmspic/2017/09/15/ac5951c37e1941c0a6dbb2cc69ef52c3-430.jpg?p=2&h=120","len":"00:13:57","em":"CM01"},{"vsid":"C14121","order":"3173","vid":"bfb1607380604565a75b920c015d5513","t":"《国宝档案》 20170914 海国微澜\u2014\u2014典雅陈设","url":"http://tv.cntv.cn/video/C14121/bfb1607380604565a75b920c015d5513","ptime":"2017-09-14 19:11:02","img":"http://p5.img.cctvpic.com/fmspic/2017/09/14/bfb1607380604565a75b920c015d5513-430.jpg?p=2&h=120","len":"00:13:56","em":"CM01"},{"vsid":"C14121","order":"3172","vid":"b3d3d34103774dd1b7534b6293e708d3","t":"《国宝档案》 20170913 海国微澜\u2014\u2014万国瓷风","url":"http://tv.cntv.cn/video/C14121/b3d3d34103774dd1b7534b6293e708d3","ptime":"2017-09-13 18:45:00","img":"http://p1.img.cctvpic.com/fmspic/2017/09/13/b3d3d34103774dd1b7534b6293e708d3-430.jpg?p=2&h=120","len":"00:13:58","em":"CM01"},{"vsid":"C14121","order":"3171","vid":"7c45600c3f32416d8dc49f6c3062a792","t":"《国宝档案》 20170913 海国微澜\u2014\u2014生活韵致","url":"http://tv.cntv.cn/video/C14121/7c45600c3f32416d8dc49f6c3062a792","ptime":"2017-09-13 01:10:07","img":"http://p3.img.cctvpic.com/fmspic/2017/09/13/7c45600c3f32416d8dc49f6c3062a792-430.jpg?p=2&h=120","len":"00:13:57","em":"CM01"}]
     */

    private VideosetBean videoset;
    private List<VideoBean> video;

    public VideosetBean getVideoset() {
        return videoset;
    }

    public void setVideoset(VideosetBean videoset) {
        this.videoset = videoset;
    }

    public List<VideoBean> getVideo() {
        return video;
    }

    public void setVideo(List<VideoBean> video) {
        this.video = video;
    }

    public static class VideosetBean implements Parcelable {
        @Override
        public String toString() {
            return "VideosetBean{" +
                    "_$0=" + _$0 +
                    ", count='" + count + '\'' +
                    '}';
        }

        /**
         * 0 : {"vsid":"C14121","relvsid":"","name":"国宝档案","img":"http://p2.img.cctvpic.com/imagepic/nettv/explore/history/guobaodangan/ibugu/images/img1262400848646904.jpg","enname":"cctv4","url":"http://tv.cntv.cn/videoset/C14121","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"周一至周五 18:45","sbpd":"CCTV-4中文国际(亚)","desc":"《国宝档案》CCTV4亚洲首播：每天18：50重播：次日05：35<br>&nbsp;&nbsp;《国宝档案》栏目每期节目将介绍一个具体的国宝文物，这些凝聚着中华民族智慧和传统文化的历代传世国宝文物，既有受到政府保护收藏在祖国大陆各个博物馆中的，也有收藏于民间被国人精心呵护的；既有因历史原因东渡海峡存于宝岛台湾的，也有历尽磨难流失海外漂泊他乡的\u2026\u2026","playdesc":"","zcr":"","fcl":"CCTV-4 (亚洲)"}
         * count : 2643
         */

        @SerializedName("0")
        private _$0Bean _$0;
        private String count;

        public _$0Bean get_$0() {
            return _$0;
        }

        public void set_$0(_$0Bean _$0) {
            this._$0 = _$0;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public static class _$0Bean implements Parcelable {
            /**
             * vsid : C14121
             * relvsid :
             * name : 国宝档案
             * img : http://p2.img.cctvpic.com/imagepic/nettv/explore/history/guobaodangan/ibugu/images/img1262400848646904.jpg
             * enname : cctv4
             * url : http://tv.cntv.cn/videoset/C14121
             * cd :
             * zy :
             * bj :
             * dy :
             * js :
             * nf :
             * yz :
             * fl :
             * sbsj : 周一至周五 18:45
             * sbpd : CCTV-4中文国际(亚)
             * desc : 《国宝档案》CCTV4亚洲首播：每天18：50重播：次日05：35<br>&nbsp;&nbsp;《国宝档案》栏目每期节目将介绍一个具体的国宝文物，这些凝聚着中华民族智慧和传统文化的历代传世国宝文物，既有受到政府保护收藏在祖国大陆各个博物馆中的，也有收藏于民间被国人精心呵护的；既有因历史原因东渡海峡存于宝岛台湾的，也有历尽磨难流失海外漂泊他乡的……
             * playdesc :
             * zcr :
             * fcl : CCTV-4 (亚洲)
             */

            private String vsid;
            private String relvsid;
            private String name;
            private String img;
            private String enname;
            private String url;
            private String cd;
            private String zy;
            private String bj;
            private String dy;
            private String js;
            private String nf;
            private String yz;
            private String fl;
            private String sbsj;
            private String sbpd;
            private String desc;
            private String playdesc;
            private String zcr;
            private String fcl;

            public String getVsid() {
                return vsid;
            }

            public void setVsid(String vsid) {
                this.vsid = vsid;
            }

            public String getRelvsid() {
                return relvsid;
            }

            public void setRelvsid(String relvsid) {
                this.relvsid = relvsid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getEnname() {
                return enname;
            }

            public void setEnname(String enname) {
                this.enname = enname;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getCd() {
                return cd;
            }

            public void setCd(String cd) {
                this.cd = cd;
            }

            public String getZy() {
                return zy;
            }

            public void setZy(String zy) {
                this.zy = zy;
            }

            public String getBj() {
                return bj;
            }

            public void setBj(String bj) {
                this.bj = bj;
            }

            public String getDy() {
                return dy;
            }

            public void setDy(String dy) {
                this.dy = dy;
            }

            public String getJs() {
                return js;
            }

            public void setJs(String js) {
                this.js = js;
            }

            public String getNf() {
                return nf;
            }

            public void setNf(String nf) {
                this.nf = nf;
            }

            public String getYz() {
                return yz;
            }

            public void setYz(String yz) {
                this.yz = yz;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getSbsj() {
                return sbsj;
            }

            public void setSbsj(String sbsj) {
                this.sbsj = sbsj;
            }

            public String getSbpd() {
                return sbpd;
            }

            public void setSbpd(String sbpd) {
                this.sbpd = sbpd;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPlaydesc() {
                return playdesc;
            }

            public void setPlaydesc(String playdesc) {
                this.playdesc = playdesc;
            }

            public String getZcr() {
                return zcr;
            }

            public void setZcr(String zcr) {
                this.zcr = zcr;
            }

            public String getFcl() {
                return fcl;
            }

            public void setFcl(String fcl) {
                this.fcl = fcl;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.vsid);
                dest.writeString(this.relvsid);
                dest.writeString(this.name);
                dest.writeString(this.img);
                dest.writeString(this.enname);
                dest.writeString(this.url);
                dest.writeString(this.cd);
                dest.writeString(this.zy);
                dest.writeString(this.bj);
                dest.writeString(this.dy);
                dest.writeString(this.js);
                dest.writeString(this.nf);
                dest.writeString(this.yz);
                dest.writeString(this.fl);
                dest.writeString(this.sbsj);
                dest.writeString(this.sbpd);
                dest.writeString(this.desc);
                dest.writeString(this.playdesc);
                dest.writeString(this.zcr);
                dest.writeString(this.fcl);
            }

            public _$0Bean() {
            }

            protected _$0Bean(Parcel in) {
                this.vsid = in.readString();
                this.relvsid = in.readString();
                this.name = in.readString();
                this.img = in.readString();
                this.enname = in.readString();
                this.url = in.readString();
                this.cd = in.readString();
                this.zy = in.readString();
                this.bj = in.readString();
                this.dy = in.readString();
                this.js = in.readString();
                this.nf = in.readString();
                this.yz = in.readString();
                this.fl = in.readString();
                this.sbsj = in.readString();
                this.sbpd = in.readString();
                this.desc = in.readString();
                this.playdesc = in.readString();
                this.zcr = in.readString();
                this.fcl = in.readString();
            }

            public static final Creator<_$0Bean> CREATOR = new Creator<_$0Bean>() {
                @Override
                public _$0Bean createFromParcel(Parcel source) {
                    return new _$0Bean(source);
                }

                @Override
                public _$0Bean[] newArray(int size) {
                    return new _$0Bean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(this._$0, flags);
            dest.writeString(this.count);
        }

        public VideosetBean() {
        }

        protected VideosetBean(Parcel in) {
            this._$0 = in.readParcelable(_$0Bean.class.getClassLoader());
            this.count = in.readString();
        }

        public static final Creator<VideosetBean> CREATOR = new Creator<VideosetBean>() {
            @Override
            public VideosetBean createFromParcel(Parcel source) {
                return new VideosetBean(source);
            }

            @Override
            public VideosetBean[] newArray(int size) {
                return new VideosetBean[size];
            }
        };
    }

    public static class VideoBean implements Parcelable {
        /**
         * vsid : C14121
         * order : 3176
         * vid : 19aebb121aa4490ba718f2b1cd62a7ae
         * t : 《国宝档案》 20170919 探秘什刹海——火神庙里的前世今生
         * url : http://tv.cntv.cn/video/C14121/19aebb121aa4490ba718f2b1cd62a7ae
         * ptime : 2017-09-19 18:45:00
         * img : http://p5.img.cctvpic.com/fmspic/2017/09/19/19aebb121aa4490ba718f2b1cd62a7ae-430.jpg?p=2&h=120
         * len : 00:13:56
         * em : CM01
         */

        private String vsid;
        private String order;
        private String vid;
        private String t;
        private String url;
        private String ptime;
        private String img;
        private String len;
        private String em;

        public String getVsid() {
            return vsid;
        }

        public void setVsid(String vsid) {
            this.vsid = vsid;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getLen() {
            return len;
        }

        public void setLen(String len) {
            this.len = len;
        }

        public String getEm() {
            return em;
        }

        public void setEm(String em) {
            this.em = em;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.vsid);
            dest.writeString(this.order);
            dest.writeString(this.vid);
            dest.writeString(this.t);
            dest.writeString(this.url);
            dest.writeString(this.ptime);
            dest.writeString(this.img);
            dest.writeString(this.len);
            dest.writeString(this.em);
        }

        public VideoBean() {
        }

        protected VideoBean(Parcel in) {
            this.vsid = in.readString();
            this.order = in.readString();
            this.vid = in.readString();
            this.t = in.readString();
            this.url = in.readString();
            this.ptime = in.readString();
            this.img = in.readString();
            this.len = in.readString();
            this.em = in.readString();
        }

        public static final Creator<VideoBean> CREATOR = new Creator<VideoBean>() {
            @Override
            public VideoBean createFromParcel(Parcel source) {
                return new VideoBean(source);
            }

            @Override
            public VideoBean[] newArray(int size) {
                return new VideoBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.videoset, flags);
        dest.writeList(this.video);
    }

    public CcAcBean() {
    }

    protected CcAcBean(Parcel in) {
        this.videoset = in.readParcelable(VideosetBean.class.getClassLoader());
        this.video = new ArrayList<VideoBean>();
        in.readList(this.video, VideoBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<CcAcBean> CREATOR = new Parcelable.Creator<CcAcBean>() {
        @Override
        public CcAcBean createFromParcel(Parcel source) {
            return new CcAcBean(source);
        }

        @Override
        public CcAcBean[] newArray(int size) {
            return new CcAcBean[size];
        }
    };
}
