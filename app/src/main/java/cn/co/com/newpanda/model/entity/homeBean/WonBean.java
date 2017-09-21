package cn.co.com.newpanda.model.entity.homeBean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ASUS on 2017/9/21.
 */

public class WonBean {
    /**
     * videoset : {"0":{"vsid":"C14121","relvsid":"","name":"国宝档案","img":"http://p2.img.cctvpic.com/imagepic/nettv/explore/history/guobaodangan/ibugu/images/img1262400848646904.jpg","enname":"cctv4","url":"http://tv.cntv.cn/videoset/C14121","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"周一至周五 18:45","sbpd":"CCTV-4中文国际(亚)","desc":"《国宝档案》CCTV4亚洲首播：每天18：50重播：次日05：35<br>&nbsp;&nbsp;《国宝档案》栏目每期节目将介绍一个具体的国宝文物，这些凝聚着中华民族智慧和传统文化的历代传世国宝文物，既有受到政府保护收藏在祖国大陆各个博物馆中的，也有收藏于民间被国人精心呵护的；既有因历史原因东渡海峡存于宝岛台湾的，也有历尽磨难流失海外漂泊他乡的\u2026\u2026","playdesc":"","zcr":"","fcl":"CCTV-4 (亚洲)"},"count":"525"}
     * video : [{"vsid":"C14121","order":"1199","vid":"fcfbdc3a79c5469b8b730d999f872cd4","t":"国宝档案 神面卣 2","url":"http://tv.cntv.cn/video/C14121/fcfbdc3a79c5469b8b730d999f872cd4","ptime":"","img":"http://p5.img.cctvpic.com/fmspic/2011/05/11/fcfbdc3a79c5469b8b730d999f872cd4-180.jpg","len":"00:06:45","em":"CM02"},{"vsid":"C14121","order":"1198","vid":"41cea57802f04debb2347488be0dd189","t":"国宝档案 神面卣 1","url":"http://tv.cntv.cn/video/C14121/41cea57802f04debb2347488be0dd189","ptime":"","img":"http://p3.img.cctvpic.com/fmspic/2011/05/11/41cea57802f04debb2347488be0dd189-180.jpg","len":"00:06:32","em":"CM02"},{"vsid":"C14121","order":"1196","vid":"1dc9488312424c14328c018c29805b8a","t":"国宝档案 遂公盨 2","url":"http://tv.cntv.cn/video/C14121/1dc9488312424c14328c018c29805b8a","ptime":"","img":"http://p2.img.cctvpic.com/fmspic/2011/05/10/1dc9488312424c14328c018c29805b8a-180.jpg","len":"00:06:59","em":"CM02"},{"vsid":"C14121","order":"1195","vid":"acc988ded83b4a5004b4a5afe05acbec","t":"国宝档案 遂公盨 1","url":"http://tv.cntv.cn/video/C14121/acc988ded83b4a5004b4a5afe05acbec","ptime":"","img":"http://p5.img.cctvpic.com/fmspic/2011/05/10/acc988ded83b4a5004b4a5afe05acbec-180.jpg","len":"00:06:21","em":"CM02"},{"vsid":"C14121","order":"1194","vid":"cf9af0fe078244f34c9bfda20dbea24d","t":"国宝档案 戗金云龙纹朱漆木箱 1","url":"http://tv.cntv.cn/video/C14121/cf9af0fe078244f34c9bfda20dbea24d","ptime":"","img":"http://p3.img.cctvpic.com/fmspic/2011/05/10/cf9af0fe078244f34c9bfda20dbea24d-180.jpg","len":"00:07:21","em":"CM02"},{"vsid":"C14121","order":"1193","vid":"4bc524a9aa1e47a64ea44593327e133a","t":"国宝档案 戗金云龙纹朱漆木箱 2","url":"http://tv.cntv.cn/video/C14121/4bc524a9aa1e47a64ea44593327e133a","ptime":"","img":"http://p4.img.cctvpic.com/fmspic/2011/05/10/4bc524a9aa1e47a64ea44593327e133a-180.jpg","len":"00:05:53","em":"CM02"}]
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
         * 0 : {"vsid":"C14121","relvsid":"","name":"国宝档案","img":"http://p2.img.cctvpic.com/imagepic/nettv/explore/history/guobaodangan/ibugu/images/img1262400848646904.jpg","enname":"cctv4","url":"http://tv.cntv.cn/videoset/C14121","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"周一至周五 18:45","sbpd":"CCTV-4中文国际(亚)","desc":"《国宝档案》CCTV4亚洲首播：每天18：50重播：次日05：35<br>&nbsp;&nbsp;《国宝档案》栏目每期节目将介绍一个具体的国宝文物，这些凝聚着中华民族智慧和传统文化的历代传世国宝文物，既有受到政府保护收藏在祖国大陆各个博物馆中的，也有收藏于民间被国人精心呵护的；既有因历史原因东渡海峡存于宝岛台湾的，也有历尽磨难流失海外漂泊他乡的\u2026\u2026","playdesc":"","zcr":"","fcl":"CCTV-4 (亚洲)"}
         * count : 525
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
        }
    }

    public static class VideoBean {
        /**
         * vsid : C14121
         * order : 1199
         * vid : fcfbdc3a79c5469b8b730d999f872cd4
         * t : 国宝档案 神面卣 2
         * url : http://tv.cntv.cn/video/C14121/fcfbdc3a79c5469b8b730d999f872cd4
         * ptime :
         * img : http://p5.img.cctvpic.com/fmspic/2011/05/11/fcfbdc3a79c5469b8b730d999f872cd4-180.jpg
         * len : 00:06:45
         * em : CM02
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
    }
}
