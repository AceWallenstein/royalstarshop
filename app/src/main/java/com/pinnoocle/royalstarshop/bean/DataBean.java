package com.pinnoocle.royalstarshop.bean;

import com.google.gson.annotations.SerializedName;

public class DataBean {

    public String pay_type;
    public String money;

    public DataBean(String pay_type, String money) {
        this.pay_type = pay_type;
        this.money = money;
    }
}
