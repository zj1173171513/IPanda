package cn.co.com.newpanda.model.entity.BoBaoBean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/19.
 */

public class PandaBroadCastBean {
    /**
     * data : {"bigImg":[{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/9/6/1504660666980_910.jpg","title":"法动物园制作30天成长视频庆祝迷你圆仔满月","url":"http://panview.ipanda.com/2017/09/06/VIDEZGPylez5MmN1Thzk3kIl170906.shtml","id":"TITE1504660688117143","type":"2","stype":"","pid":"131f4ea93cc54714961db89ecd2ba797","vid":"","order":"1"}],"listurl":"http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1422435191506336&serviceId=panda"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * bigImg : [{"image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/9/6/1504660666980_910.jpg","title":"法动物园制作30天成长视频庆祝迷你圆仔满月","url":"http://panview.ipanda.com/2017/09/06/VIDEZGPylez5MmN1Thzk3kIl170906.shtml","id":"TITE1504660688117143","type":"2","stype":"","pid":"131f4ea93cc54714961db89ecd2ba797","vid":"","order":"1"}]
         * listurl : http://api.cntv.cn/apicommon/index?path=iphoneInterface/general/getArticleAndVideoListInfo.json&primary_id=PAGE1422435191506336&serviceId=panda
         */

        private String listurl;
        private List<BigImgBean> bigImg;

        public String getListurl() {
            return listurl;
        }

        public void setListurl(String listurl) {
            this.listurl = listurl;
        }

        public List<BigImgBean> getBigImg() {
            return bigImg;
        }

        public void setBigImg(List<BigImgBean> bigImg) {
            this.bigImg = bigImg;
        }

        public static class BigImgBean {
            /**
             * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/9/6/1504660666980_910.jpg
             * title : 法动物园制作30天成长视频庆祝迷你圆仔满月
             * url : http://panview.ipanda.com/2017/09/06/VIDEZGPylez5MmN1Thzk3kIl170906.shtml
             * id : TITE1504660688117143
             * type : 2
             * stype :
             * pid : 131f4ea93cc54714961db89ecd2ba797
             * vid :
             * order : 1
             */

            private String image;
            private String title;
            private String url;
            private String id;
            private String type;
            private String stype;
            private String pid;
            private String vid;
            private String order;

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getStype() {
                return stype;
            }

            public void setStype(String stype) {
                this.stype = stype;
            }

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public String getVid() {
                return vid;
            }

            public void setVid(String vid) {
                this.vid = vid;
            }

            public String getOrder() {
                return order;
            }

            public void setOrder(String order) {
                this.order = order;
            }
        }
    }



}
