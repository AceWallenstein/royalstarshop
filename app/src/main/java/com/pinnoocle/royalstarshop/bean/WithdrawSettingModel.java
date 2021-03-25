package com.pinnoocle.royalstarshop.bean;

public class WithdrawSettingModel {


    /**
     * code : 1
     * msg : success
     * data : {"min":0.01,"max":20000,"rate":"0.6","openid":"owVVk65ax2bCDloPYAE5EDUzDLjo","money":"0.00"}
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
         * min : 0.01
         * max : 20000
         * rate : 0.6
         * openid : owVVk65ax2bCDloPYAE5EDUzDLjo
         * money : 0.00
         */

        private double min;
        private double max;
        private double rate;
        private String openid;
        private String money;

        public double getMin() {
            return min;
        }

        public void setMin(double min) {
            this.min = min;
        }

        public double getMax() {
            return max;
        }

        public void setMax(double max) {
            this.max = max;
        }

        public double getRate() {
            return rate;
        }

        public void setRate(double rate) {
            this.rate = rate;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }
    }
}
