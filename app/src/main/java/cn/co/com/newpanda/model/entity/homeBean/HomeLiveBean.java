package cn.co.com.newpanda.model.entity.homeBean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ASUS on 2017/9/22.
 */

public class HomeLiveBean {
    /**
     * ack : yes
     * client_sid : fd8b9780-9f44-11e7-b2c0-005056895c00
     * flv_cdn_info : {"cdn_code":"LIVE-FLV-CDN-CNC","cdn_name":"3rdFLV网宿"}
     * flv_url : {"flv1":"","flv2":"http://ipanda.vtime.cntv.cloudcdn.net:8000/live/flv/channel54?AUTH=+ZH07xOrVqdV3U/ixPI2fzs9OPf5ldIxd5cggV4aOp0d3i9hfPJyCrglqd1X6cGCixHPG04dRaE2QP7YP4KU+Q==","flv3":"qita?AUTH=+ZH07xOrVqdV3U/ixPI2fzs9OPf5ldIxd5cggV4aOp0d3i9hfPJyCrglqd1X6cGCixHPG04dRaE2QP7YP4KU+Q==","flv4":"http://ipandaapp.vtime.cntv.wscdns.com/live/no/54_/seg0/index.m3u8?AUTH=+ZH07xOrVqdV3U/ixPI2fzs9OPf5ldIxd5cggV4aOp0d3i9hfPJyCrglqd1X6cGCixHPG04dRaE2QP7YP4KU+Q==","flv5":"http://ipandaapp.vtime.cntv.wscdns.com/cache/54_/channel.pub?AUTH=+ZH07xOrVqdV3U/ixPI2fzs9OPf5ldIxd5cggV4aOp0d3i9hfPJyCrglqd1X6cGCixHPG04dRaE2QP7YP4KU+Q==","flv6":""}
     * hds_cdn_info : {"cdn_code":"LIVE-HDS-CDN-CNC","cdn_name":"3rdHDS网宿"}
     * hds_url : {"hds1":"http://ipanda.vtime.cntv.cloudcdn.net/cache/ipandahds.f4m?AUTH=+ZH07xOrVqdV3U/ixPI2fzs9OPf5ldIxd5cggV4aOp0d3i9hfPJyCrglqd1X6cGCixHPG04dRaE2QP7YP4KU+Q==","hds2":"http://ipanda.vtime.cntv.cloudcdn.net:8000/live/flv/channel54?AUTH=+ZH07xOrVqdV3U/ixPI2fzs9OPf5ldIxd5cggV4aOp0d3i9hfPJyCrglqd1X6cGCixHPG04dRaE2QP7YP4KU+Q==","hds3":"qita?AUTH=ip%3D182.18.115.127%7Est%3D1506050131%7Eexp%3D1506136531%7Eacl%3D%2F*%7Ehmac%3D8a80b6a2f7bfef6384e0fdeb5ecdb2005de25057eeef04b7a69c35bd4e356218","hds4":"","hds5":"","hds6":""}
     * hls_cdn_info : {"cdn_code":"LIVE-HLS-CDN-CNC","cdn_name":"3rdHLS网宿"}
     * hls_url : {"hls1":"http://ipanda.vtime.cntv.cloudcdn.net/live/ipandahls_/index.m3u8?AUTH=+ZH07xOrVqdV3U/ixPI2fzs9OPf5ldIxd5cggV4aOp0d3i9hfPJyCrglqd1X6cGCixHPG04dRaE2QP7YP4KU+Q==","hls2":"http://ipanda.vtime.cntv.cloudcdn.net/live/no/54_/seg0/index.m3u8?uid=default&AUTH=+ZH07xOrVqdV3U/ixPI2fzs9OPf5ldIxd5cggV4aOp0d3i9hfPJyCrglqd1X6cGCixHPG04dRaE2QP7YP4KU+Q==","hls3":"qita?AUTH=+ZH07xOrVqdV3U/ixPI2fzs9OPf5ldIxd5cggV4aOp0d3i9hfPJyCrglqd1X6cGCixHPG04dRaE2QP7YP4KU+Q==","hls4":"http://ipanda.vtime.cntv.cloudcdn.net:8000/live/no/54_/seg0/index.m3u8?AUTH=+ZH07xOrVqdV3U/ixPI2fzs9OPf5ldIxd5cggV4aOp0d3i9hfPJyCrglqd1X6cGCixHPG04dRaE2QP7YP4KU+Q==","hls5":"http://ipanda.vtime.cntv.cloudcdn.net:8000/live/pic/channel54?AUTH=+ZH07xOrVqdV3U/ixPI2fzs9OPf5ldIxd5cggV4aOp0d3i9hfPJyCrglqd1X6cGCixHPG04dRaE2QP7YP4KU+Q==","hls6":"http://audio.live.cntvws.cloudcdn.net:8000/cache/54_/seg2/index.m3u8?AUTH=+ZH07xOrVqdV3U/ixPI2fzs9OPf5ldIxd5cggV4aOp0d3i9hfPJyCrglqd1X6cGCixHPG04dRaE2QP7YP4KU+Q=="}
     * lc : {"city_code":"","country_code":"CN","ip":"182.18.115.127","isp_code":"1","provice_code":"BJ"}
     * public : 1
     */

    private String ack;
    private String client_sid;
    private FlvCdnInfoBean flv_cdn_info;
    private FlvUrlBean flv_url;
    private HdsCdnInfoBean hds_cdn_info;
    private HdsUrlBean hds_url;
    private HlsCdnInfoBean hls_cdn_info;
    private HlsUrlBean hls_url;
    private LcBean lc;
    @SerializedName("public")
    private String publicX;

    public String getAck() {
        return ack;
    }

    public void setAck(String ack) {
        this.ack = ack;
    }

    public String getClient_sid() {
        return client_sid;
    }

    public void setClient_sid(String client_sid) {
        this.client_sid = client_sid;
    }

    public FlvCdnInfoBean getFlv_cdn_info() {
        return flv_cdn_info;
    }

    public void setFlv_cdn_info(FlvCdnInfoBean flv_cdn_info) {
        this.flv_cdn_info = flv_cdn_info;
    }

    public FlvUrlBean getFlv_url() {
        return flv_url;
    }

    public void setFlv_url(FlvUrlBean flv_url) {
        this.flv_url = flv_url;
    }

    public HdsCdnInfoBean getHds_cdn_info() {
        return hds_cdn_info;
    }

    public void setHds_cdn_info(HdsCdnInfoBean hds_cdn_info) {
        this.hds_cdn_info = hds_cdn_info;
    }

    public HdsUrlBean getHds_url() {
        return hds_url;
    }

    public void setHds_url(HdsUrlBean hds_url) {
        this.hds_url = hds_url;
    }

    public HlsCdnInfoBean getHls_cdn_info() {
        return hls_cdn_info;
    }

    public void setHls_cdn_info(HlsCdnInfoBean hls_cdn_info) {
        this.hls_cdn_info = hls_cdn_info;
    }

    public HlsUrlBean getHls_url() {
        return hls_url;
    }

    public void setHls_url(HlsUrlBean hls_url) {
        this.hls_url = hls_url;
    }

    public LcBean getLc() {
        return lc;
    }

    public void setLc(LcBean lc) {
        this.lc = lc;
    }

    public String getPublicX() {
        return publicX;
    }

    public void setPublicX(String publicX) {
        this.publicX = publicX;
    }

    public static class FlvCdnInfoBean {
        /**
         * cdn_code : LIVE-FLV-CDN-CNC
         * cdn_name : 3rdFLV网宿
         */

        private String cdn_code;
        private String cdn_name;

        public String getCdn_code() {
            return cdn_code;
        }

        public void setCdn_code(String cdn_code) {
            this.cdn_code = cdn_code;
        }

        public String getCdn_name() {
            return cdn_name;
        }

        public void setCdn_name(String cdn_name) {
            this.cdn_name = cdn_name;
        }
    }

    public static class FlvUrlBean {
        /**
         * flv1 :
         * flv2 : http://ipanda.vtime.cntv.cloudcdn.net:8000/live/flv/channel54?AUTH=+ZH07xOrVqdV3U/ixPI2fzs9OPf5ldIxd5cggV4aOp0d3i9hfPJyCrglqd1X6cGCixHPG04dRaE2QP7YP4KU+Q==
         * flv3 : qita?AUTH=+ZH07xOrVqdV3U/ixPI2fzs9OPf5ldIxd5cggV4aOp0d3i9hfPJyCrglqd1X6cGCixHPG04dRaE2QP7YP4KU+Q==
         * flv4 : http://ipandaapp.vtime.cntv.wscdns.com/live/no/54_/seg0/index.m3u8?AUTH=+ZH07xOrVqdV3U/ixPI2fzs9OPf5ldIxd5cggV4aOp0d3i9hfPJyCrglqd1X6cGCixHPG04dRaE2QP7YP4KU+Q==
         * flv5 : http://ipandaapp.vtime.cntv.wscdns.com/cache/54_/channel.pub?AUTH=+ZH07xOrVqdV3U/ixPI2fzs9OPf5ldIxd5cggV4aOp0d3i9hfPJyCrglqd1X6cGCixHPG04dRaE2QP7YP4KU+Q==
         * flv6 :
         */

        private String flv1;
        private String flv2;
        private String flv3;
        private String flv4;
        private String flv5;
        private String flv6;

        public String getFlv1() {
            return flv1;
        }

        public void setFlv1(String flv1) {
            this.flv1 = flv1;
        }

        public String getFlv2() {
            return flv2;
        }

        public void setFlv2(String flv2) {
            this.flv2 = flv2;
        }

        public String getFlv3() {
            return flv3;
        }

        public void setFlv3(String flv3) {
            this.flv3 = flv3;
        }

        public String getFlv4() {
            return flv4;
        }

        public void setFlv4(String flv4) {
            this.flv4 = flv4;
        }

        public String getFlv5() {
            return flv5;
        }

        public void setFlv5(String flv5) {
            this.flv5 = flv5;
        }

        public String getFlv6() {
            return flv6;
        }

        public void setFlv6(String flv6) {
            this.flv6 = flv6;
        }
    }

    public static class HdsCdnInfoBean {
        /**
         * cdn_code : LIVE-HDS-CDN-CNC
         * cdn_name : 3rdHDS网宿
         */

        private String cdn_code;
        private String cdn_name;

        public String getCdn_code() {
            return cdn_code;
        }

        public void setCdn_code(String cdn_code) {
            this.cdn_code = cdn_code;
        }

        public String getCdn_name() {
            return cdn_name;
        }

        public void setCdn_name(String cdn_name) {
            this.cdn_name = cdn_name;
        }
    }

    public static class HdsUrlBean {
        /**
         * hds1 : http://ipanda.vtime.cntv.cloudcdn.net/cache/ipandahds.f4m?AUTH=+ZH07xOrVqdV3U/ixPI2fzs9OPf5ldIxd5cggV4aOp0d3i9hfPJyCrglqd1X6cGCixHPG04dRaE2QP7YP4KU+Q==
         * hds2 : http://ipanda.vtime.cntv.cloudcdn.net:8000/live/flv/channel54?AUTH=+ZH07xOrVqdV3U/ixPI2fzs9OPf5ldIxd5cggV4aOp0d3i9hfPJyCrglqd1X6cGCixHPG04dRaE2QP7YP4KU+Q==
         * hds3 : qita?AUTH=ip%3D182.18.115.127%7Est%3D1506050131%7Eexp%3D1506136531%7Eacl%3D%2F*%7Ehmac%3D8a80b6a2f7bfef6384e0fdeb5ecdb2005de25057eeef04b7a69c35bd4e356218
         * hds4 :
         * hds5 :
         * hds6 :
         */

        private String hds1;
        private String hds2;
        private String hds3;
        private String hds4;
        private String hds5;
        private String hds6;

        public String getHds1() {
            return hds1;
        }

        public void setHds1(String hds1) {
            this.hds1 = hds1;
        }

        public String getHds2() {
            return hds2;
        }

        public void setHds2(String hds2) {
            this.hds2 = hds2;
        }

        public String getHds3() {
            return hds3;
        }

        public void setHds3(String hds3) {
            this.hds3 = hds3;
        }

        public String getHds4() {
            return hds4;
        }

        public void setHds4(String hds4) {
            this.hds4 = hds4;
        }

        public String getHds5() {
            return hds5;
        }

        public void setHds5(String hds5) {
            this.hds5 = hds5;
        }

        public String getHds6() {
            return hds6;
        }

        public void setHds6(String hds6) {
            this.hds6 = hds6;
        }
    }

    public static class HlsCdnInfoBean {
        /**
         * cdn_code : LIVE-HLS-CDN-CNC
         * cdn_name : 3rdHLS网宿
         */

        private String cdn_code;
        private String cdn_name;

        public String getCdn_code() {
            return cdn_code;
        }

        public void setCdn_code(String cdn_code) {
            this.cdn_code = cdn_code;
        }

        public String getCdn_name() {
            return cdn_name;
        }

        public void setCdn_name(String cdn_name) {
            this.cdn_name = cdn_name;
        }
    }

    public static class HlsUrlBean {
        /**
         * hls1 : http://ipanda.vtime.cntv.cloudcdn.net/live/ipandahls_/index.m3u8?AUTH=+ZH07xOrVqdV3U/ixPI2fzs9OPf5ldIxd5cggV4aOp0d3i9hfPJyCrglqd1X6cGCixHPG04dRaE2QP7YP4KU+Q==
         * hls2 : http://ipanda.vtime.cntv.cloudcdn.net/live/no/54_/seg0/index.m3u8?uid=default&AUTH=+ZH07xOrVqdV3U/ixPI2fzs9OPf5ldIxd5cggV4aOp0d3i9hfPJyCrglqd1X6cGCixHPG04dRaE2QP7YP4KU+Q==
         * hls3 : qita?AUTH=+ZH07xOrVqdV3U/ixPI2fzs9OPf5ldIxd5cggV4aOp0d3i9hfPJyCrglqd1X6cGCixHPG04dRaE2QP7YP4KU+Q==
         * hls4 : http://ipanda.vtime.cntv.cloudcdn.net:8000/live/no/54_/seg0/index.m3u8?AUTH=+ZH07xOrVqdV3U/ixPI2fzs9OPf5ldIxd5cggV4aOp0d3i9hfPJyCrglqd1X6cGCixHPG04dRaE2QP7YP4KU+Q==
         * hls5 : http://ipanda.vtime.cntv.cloudcdn.net:8000/live/pic/channel54?AUTH=+ZH07xOrVqdV3U/ixPI2fzs9OPf5ldIxd5cggV4aOp0d3i9hfPJyCrglqd1X6cGCixHPG04dRaE2QP7YP4KU+Q==
         * hls6 : http://audio.live.cntvws.cloudcdn.net:8000/cache/54_/seg2/index.m3u8?AUTH=+ZH07xOrVqdV3U/ixPI2fzs9OPf5ldIxd5cggV4aOp0d3i9hfPJyCrglqd1X6cGCixHPG04dRaE2QP7YP4KU+Q==
         */

        private String hls1;
        private String hls2;
        private String hls3;
        private String hls4;
        private String hls5;
        private String hls6;

        public String getHls1() {
            return hls1;
        }

        public void setHls1(String hls1) {
            this.hls1 = hls1;
        }

        public String getHls2() {
            return hls2;
        }

        public void setHls2(String hls2) {
            this.hls2 = hls2;
        }

        public String getHls3() {
            return hls3;
        }

        public void setHls3(String hls3) {
            this.hls3 = hls3;
        }

        public String getHls4() {
            return hls4;
        }

        public void setHls4(String hls4) {
            this.hls4 = hls4;
        }

        public String getHls5() {
            return hls5;
        }

        public void setHls5(String hls5) {
            this.hls5 = hls5;
        }

        public String getHls6() {
            return hls6;
        }

        public void setHls6(String hls6) {
            this.hls6 = hls6;
        }
    }

    public static class LcBean {
        /**
         * city_code :
         * country_code : CN
         * ip : 182.18.115.127
         * isp_code : 1
         * provice_code : BJ
         */

        private String city_code;
        private String country_code;
        private String ip;
        private String isp_code;
        private String provice_code;

        public String getCity_code() {
            return city_code;
        }

        public void setCity_code(String city_code) {
            this.city_code = city_code;
        }

        public String getCountry_code() {
            return country_code;
        }

        public void setCountry_code(String country_code) {
            this.country_code = country_code;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getIsp_code() {
            return isp_code;
        }

        public void setIsp_code(String isp_code) {
            this.isp_code = isp_code;
        }

        public String getProvice_code() {
            return provice_code;
        }

        public void setProvice_code(String provice_code) {
            this.provice_code = provice_code;
        }
    }
}
