package com.pinnoocle.royalstarshop.bean;

import com.google.gson.annotations.SerializedName;

public class DataBean {

    public int pay_type;
    public String money;

    public DataBean(int pay_type, String money) {
        this.pay_type = pay_type;
        this.money = money;
    }
}
