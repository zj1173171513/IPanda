package cn.co.com.newpanda.model.entity.homeBean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2017/9/13.
 */

public class InfoBean implements Parcelable {
    private List<InteractiveBean> interactive;

    public List<InteractiveBean> getInteractive() {
        return interactive;
    }

    public void setInteractive(List<InteractiveBean> interactive) {
        this.interactive = interactive;
    }

    public static class InteractiveBean implements Parcelable {
        /**
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/6/5/1496626374961_922.jpg
         * title : 二十四节气——芒种
         * url : http://webapp.cctv.com/h5/travel/U80531QU7SY7.html
         * order : 1
         */

        private String image;
        private String title;
        private String url;
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

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.image);
            dest.writeString(this.title);
            dest.writeString(this.url);
            dest.writeString(this.order);
        }

        public InteractiveBean() {
        }

        protected InteractiveBean(Parcel in) {
            this.image = in.readString();
            this.title = in.readString();
            this.url = in.readString();
            this.order = in.readString();
        }

        public static final Creator<InteractiveBean> CREATOR = new Creator<InteractiveBean>() {
            @Override
            public InteractiveBean createFromParcel(Parcel source) {
                return new InteractiveBean(source);
            }

            @Override
            public InteractiveBean[] newArray(int size) {
                return new InteractiveBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.interactive);
    }

    public InfoBean() {
    }

    protected InfoBean(Parcel in) {
        this.interactive = new ArrayList<InteractiveBean>();
        in.readList(this.interactive, InteractiveBean.class.getClassLoader());
    }

    public static final Creator<InfoBean> CREATOR = new Creator<InfoBean>() {
        @Override
        public InfoBean createFromParcel(Parcel source) {
            return new InfoBean(source);
        }

        @Override
        public InfoBean[] newArray(int size) {
            return new InfoBean[size];
        }
    };
}
