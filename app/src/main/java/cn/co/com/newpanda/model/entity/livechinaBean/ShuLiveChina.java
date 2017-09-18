package cn.co.com.newpanda.model.entity.livechinaBean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2017/09/18.
 */
@Entity
public class ShuLiveChina {
    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "stitle")
    private String title;
    @Generated(hash = 945641035)
    public ShuLiveChina(Long id, String title) {
        this.id = id;
        this.title = title;
    }
    @Generated(hash = 191026411)
    public ShuLiveChina() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
}
