package cn.co.com.newpanda.model.entity.pandaliveBean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 丶 on 2017/9/14.
 */

public class WonderfuMomentBean {

    /**
     * video : [{"em":"CM01","img":"http://p3.img.cctvpic.com/fmspic/2017/09/12/5dad3f624ed647528b277af06bb57ae4-9.jpg?p=2&h=120","len":"00:00:19","order":"4904","ptime":"2017-09-12 19:46:33","t":"《精彩一刻》 20170912 越狱不成，还暴露身材","url":"http://tv.cntv.cn/video/VSET100167216881/5dad3f624ed647528b277af06bb57ae4","vid":"5dad3f624ed647528b277af06bb57ae4","vsid":"VSET100167216881"},{"em":"CM01","img":"http://p4.img.cctvpic.com/fmspic/2017/09/12/c3f83828116f45ad940d876a34ac3472-9.jpg?p=2&h=120","len":"00:00:18","order":"4903","ptime":"2017-09-12 19:45:33","t":"《精彩一刻》 20170912 焦糖糯米团子上线了~","url":"http://tv.cntv.cn/video/VSET100167216881/c3f83828116f45ad940d876a34ac3472","vid":"c3f83828116f45ad940d876a34ac3472","vsid":"VSET100167216881"},{"em":"CM01","img":"http://p3.img.cctvpic.com/fmspic/2017/09/12/5ce114c48bd34e72b929b8db51fbcc9f-35.jpg?p=2&h=120","len":"00:00:49","order":"4905","ptime":"2017-09-12 19:44:17","t":"《精彩一刻》 20170912 两脚兽，你看我美吗~","url":"http://tv.cntv.cn/video/VSET100167216881/5ce114c48bd34e72b929b8db51fbcc9f","vid":"5ce114c48bd34e72b929b8db51fbcc9f","vsid":"VSET100167216881"},{"em":"CM01","img":"http://p4.img.cctvpic.com/fmspic/2017/09/12/88bc233d7da64fd382f3a4569b1f0fdb-33.jpg?p=2&h=120","len":"00:00:45","order":"4906","ptime":"2017-09-12 19:42:53","t":"《精彩一刻》 20170912 不要笋笋，要抱抱~","url":"http://tv.cntv.cn/video/VSET100167216881/88bc233d7da64fd382f3a4569b1f0fdb","vid":"88bc233d7da64fd382f3a4569b1f0fdb","vsid":"VSET100167216881"},{"em":"CM01","img":"http://p5.img.cctvpic.com/fmspic/2017/09/12/5c3ee6c68a324a63b6d6a8bc9647b581-21.jpg?p=2&h=120","len":"00:00:32","order":"4901","ptime":"2017-09-12 10:51:54","t":"《精彩一刻》 20170912 突如其来的追击","url":"http://tv.cntv.cn/video/VSET100167216881/5c3ee6c68a324a63b6d6a8bc9647b581","vid":"5c3ee6c68a324a63b6d6a8bc9647b581","vsid":"VSET100167216881"},{"em":"CM01","img":"http://p1.img.cctvpic.com/fmspic/2017/09/12/4942f9f34e5a448a9e7f22fa28f7e844-33.jpg?p=2&h=120","len":"00:00:46","order":"4902","ptime":"2017-09-12 10:50:01","t":"《精彩一刻》 20170912 最怕奶妈突然离去","url":"http://tv.cntv.cn/video/VSET100167216881/4942f9f34e5a448a9e7f22fa28f7e844","vid":"4942f9f34e5a448a9e7f22fa28f7e844","vsid":"VSET100167216881"},{"em":"CM01","img":"http://p3.img.cctvpic.com/fmspic/2017/09/12/2971619b8bd8422299dd41d6ece75201-33.jpg?p=2&h=120","len":"00:00:47","order":"4900","ptime":"2017-09-12 10:48:06","t":"《精彩一刻》 20170912 妈妈，这是你教我的","url":"http://tv.cntv.cn/video/VSET100167216881/2971619b8bd8422299dd41d6ece75201","vid":"2971619b8bd8422299dd41d6ece75201","vsid":"VSET100167216881"}]
     * videoset : {"0":{"bj":"","cd":"","desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","dy":"","enname":"其他","fcl":"","fl":"","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","js":"","name":"熊猫频道-精彩一刻","nf":"","playdesc":"","relvsid":"","sbpd":"其他","sbsj":"2013-05-01","url":"http://tv.cntv.cn/videoset/VSET100167216881","vsid":"VSET100167216881","yz":"","zcr":"","zy":""},"count":"4901"}
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

    public static class VideosetBean {
        /**
         * 0 : {"bj":"","cd":"","desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","dy":"","enname":"其他","fcl":"","fl":"","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","js":"","name":"熊猫频道-精彩一刻","nf":"","playdesc":"","relvsid":"","sbpd":"其他","sbsj":"2013-05-01","url":"http://tv.cntv.cn/videoset/VSET100167216881","vsid":"VSET100167216881","yz":"","zcr":"","zy":""}
         * count : 4901
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

        public static class _$0Bean {
            /**
             * bj :
             * cd :
             * desc : 精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。
             * dy :
             * enname : 其他
             * fcl :
             * fl :
             * img : http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg
             * js :
             * name : 熊猫频道-精彩一刻
             * nf :
             * playdesc :
             * relvsid :
             * sbpd : 其他
             * sbsj : 2013-05-01
             * url : http://tv.cntv.cn/videoset/VSET100167216881
             * vsid : VSET100167216881
             * yz :
             * zcr :
             * zy :
             */

            private String bj;
            private String cd;
            private String desc;
            private String dy;
            private String enname;
            private String fcl;
            private String fl;
            private String img;
            private String js;
            private String name;
            private String nf;
            private String playdesc;
            private String relvsid;
            private String sbpd;
            private String sbsj;
            private String url;
            private String vsid;
            private String yz;
            private String zcr;
            private String zy;

            public String getBj() {
                return bj;
            }

            public void setBj(String bj) {
                this.bj = bj;
            }

            public String getCd() {
                return cd;
            }

            public void setCd(String cd) {
                this.cd = cd;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getDy() {
                return dy;
            }

            public void setDy(String dy) {
                this.dy = dy;
            }

            public String getEnname() {
                return enname;
            }

            public void setEnname(String enname) {
                this.enname = enname;
            }

            public String getFcl() {
                return fcl;
            }

            public void setFcl(String fcl) {
                this.fcl = fcl;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getJs() {
                return js;
            }

            public void setJs(String js) {
                this.js = js;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getNf() {
                return nf;
            }

            public void setNf(String nf) {
                this.nf = nf;
            }

            public String getPlaydesc() {
                return playdesc;
            }

            public void setPlaydesc(String playdesc) {
                this.playdesc = playdesc;
            }

            public String getRelvsid() {
                return relvsid;
            }

            public void setRelvsid(String relvsid) {
                this.relvsid = relvsid;
            }

            public String getSbpd() {
                return sbpd;
            }

            public void setSbpd(String sbpd) {
                this.sbpd = sbpd;
            }

            public String getSbsj() {
                return sbsj;
            }

            public void setSbsj(String sbsj) {
                this.sbsj = sbsj;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getVsid() {
                return vsid;
            }

            public void setVsid(String vsid) {
                this.vsid = vsid;
            }

            public String getYz() {
                return yz;
            }

            public void setYz(String yz) {
                this.yz = yz;
            }

            public String getZcr() {
                return zcr;
            }

            public void setZcr(String zcr) {
                this.zcr = zcr;
            }

            public String getZy() {
                return zy;
            }

            public void setZy(String zy) {
                this.zy = zy;
            }
        }
    }

    public static class VideoBean {
        /**
         * em : CM01
         * img : http://p3.img.cctvpic.com/fmspic/2017/09/12/5dad3f624ed647528b277af06bb57ae4-9.jpg?p=2&h=120
         * len : 00:00:19
         * order : 4904
         * ptime : 2017-09-12 19:46:33
         * t : 《精彩一刻》 20170912 越狱不成，还暴露身材
         * url : http://tv.cntv.cn/video/VSET100167216881/5dad3f624ed647528b277af06bb57ae4
         * vid : 5dad3f624ed647528b277af06bb57ae4
         * vsid : VSET100167216881
         */

        private String em;
        private String img;
        private String len;
        private String order;
        private String ptime;
        private String t;
        private String url;
        private String vid;
        private String vsid;

        public String getEm() {
            return em;
        }

        public void setEm(String em) {
            this.em = em;
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

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
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

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getVsid() {
            return vsid;
        }

        public void setVsid(String vsid) {
            this.vsid = vsid;
        }
    }
}
