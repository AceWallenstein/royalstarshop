package com.pinnoocle.royalstarshop.bean;

import java.util.List;

public class BackTypeModel {


    /**
     * code : 1
     * msg : success
     * data : ["产品使用问题","产品使用问题2"]
     */

    private int code;
    private String msg;
    private List<String> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
