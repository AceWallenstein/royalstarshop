package com.pinnoocle.royalstarshop.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class HistoryBean {
    @Id
    Long id;
    String name;
    @Generated(hash = 1142511416)
    public HistoryBean(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 48590348)
    public HistoryBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
