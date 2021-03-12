package com.pinnoocle.royalstarshop.bean;

public class MoneyModel {
    /**
     * code : 1
     * msg : success
     * data : {"money":"0.00","today_money":0}
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
         * money : 0.00
         * today_money : 0
         */

        private String money;
        private int today_money;

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public int getToday_money() {
            return today_money;
        }

        public void setToday_money(int today_money) {
            this.today_money = today_money;
        }
    }
}
