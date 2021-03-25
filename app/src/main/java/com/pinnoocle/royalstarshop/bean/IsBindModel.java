package com.pinnoocle.royalstarshop.bean;

public class IsBindModel {

    /**
     * code : 1
     * msg : success
     * data : {"openid":"owVVk65ax2bCDloPYAE5EDUzDLjo","code":1}
     */

    private int code;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * openid : owVVk65ax2bCDloPYAE5EDUzDLjo
         * code : 1
         */

        private String openid;
        private int code;

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }
}
