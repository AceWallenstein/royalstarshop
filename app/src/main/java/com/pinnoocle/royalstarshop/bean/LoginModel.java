package com.pinnoocle.royalstarshop.bean;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.pinnoocle.royalstarshop.adapter.RawStringJsonAdapter;

import java.util.List;

public class LoginModel {
    /**
     * code : 1
     * msg : success
     * data : {"user":{"user_id":19529,"nickName":"","avatarUrl":"","gender":"未知","address_id":0,"balance":"0.00","points":0,"pay_money":"0.00","expend_money":"0.00","phone":"15665336289","lasttime":null,"address":[],"username":null,"invite_code":null,"isVip":0,"vip_time":0,"vip_expire":0,"parent_id":0,"service_id":0,"address_default":null},"token":"ca14c082473b67d4e9f5e2abdd458e66"}
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
         * user : {"user_id":19529,"nickName":"","avatarUrl":"","gender":"未知","address_id":0,"balance":"0.00","points":0,"pay_money":"0.00","expend_money":"0.00","phone":"15665336289","lasttime":null,"address":[],"username":null,"invite_code":null,"isVip":0,"vip_time":0,"vip_expire":0,"parent_id":0,"service_id":0,"address_default":null}
         * token : ca14c082473b67d4e9f5e2abdd458e66
         */

        private UserBean user;
        private String token;
        private int is_first;

        public int getIs_first() {
            return is_first;
        }

        public void setIs_first(int is_first) {
            this.is_first = is_first;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public static class UserBean {
            /**
             * user_id : 19529
             * nickName :
             * avatarUrl :
             * gender : 未知
             * address_id : 0
             * balance : 0.00
             * points : 0
             * pay_money : 0.00
             * expend_money : 0.00
             * phone : 15665336289
             * lasttime : null
             * address : []
             * username : null
             * invite_code : null
             * isVip : 0
             * vip_time : 0
             * vip_expire : 0
             * parent_id : 0
             * service_id : 0
             * address_default : null
             */

            private int user_id;
            private String nickName;
            private String avatarUrl;
            private String gender;
            private int address_id;
            private String balance;
            private int points;
            private String pay_money;
            private String expend_money;
            private String phone;
            private Object lasttime;
            private Object username;
            private Object invite_code;
            private int isVip;
            private int vip_time;
            private int vip_expire;
            private int parent_id;
            private int service_id;
            private Object address_default;
            private List<?> address;

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getAvatarUrl() {
                return avatarUrl;
            }

            public void setAvatarUrl(String avatarUrl) {
                this.avatarUrl = avatarUrl;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            public int getAddress_id() {
                return address_id;
            }

            public void setAddress_id(int address_id) {
                this.address_id = address_id;
            }

            public String getBalance() {
                return balance;
            }

            public void setBalance(String balance) {
                this.balance = balance;
            }

            public int getPoints() {
                return points;
            }

            public void setPoints(int points) {
                this.points = points;
            }

            public String getPay_money() {
                return pay_money;
            }

            public void setPay_money(String pay_money) {
                this.pay_money = pay_money;
            }

            public String getExpend_money() {
                return expend_money;
            }

            public void setExpend_money(String expend_money) {
                this.expend_money = expend_money;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public Object getLasttime() {
                return lasttime;
            }

            public void setLasttime(Object lasttime) {
                this.lasttime = lasttime;
            }

            public Object getUsername() {
                return username;
            }

            public void setUsername(Object username) {
                this.username = username;
            }

            public Object getInvite_code() {
                return invite_code;
            }

            public void setInvite_code(Object invite_code) {
                this.invite_code = invite_code;
            }

            public int getIsVip() {
                return isVip;
            }

            public void setIsVip(int isVip) {
                this.isVip = isVip;
            }

            public int getVip_time() {
                return vip_time;
            }

            public void setVip_time(int vip_time) {
                this.vip_time = vip_time;
            }

            public int getVip_expire() {
                return vip_expire;
            }

            public void setVip_expire(int vip_expire) {
                this.vip_expire = vip_expire;
            }

            public int getParent_id() {
                return parent_id;
            }

            public void setParent_id(int parent_id) {
                this.parent_id = parent_id;
            }

            public int getService_id() {
                return service_id;
            }

            public void setService_id(int service_id) {
                this.service_id = service_id;
            }

            public Object getAddress_default() {
                return address_default;
            }

            public void setAddress_default(Object address_default) {
                this.address_default = address_default;
            }

            public List<?> getAddress() {
                return address;
            }

            public void setAddress(List<?> address) {
                this.address = address;
            }
        }
    }
}
