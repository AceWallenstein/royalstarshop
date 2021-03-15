package com.pinnoocle.royalstarshop.bean;

import java.util.List;

public class ErCodeModel {
    /**
     * code : 1
     * msg : success
     * data : {"file_path":"http://gsyp.vtui365.com/tmp/qrcode/qrcode_19529.png","invite_code":"naL87W","count":2,"total":"20.00","my_invite":[{"user_id":19536,"phone":"13075070618","nickName":"","create_time":null,"first_money":null,"avatarUrl":"","isVip":1,"vip_text":"已开通","money":0},{"user_id":19533,"phone":"15212790160","nickName":"厉害了","create_time":"2021-03-14","first_money":"10.00","avatarUrl":"http://gsyp.vtui365.com/uploads/20210310161151c0f376216.jpeg","isVip":1,"vip_text":"已开通","money":"10.00"}]}
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
         * file_path : http://gsyp.vtui365.com/tmp/qrcode/qrcode_19529.png
         * invite_code : naL87W
         * count : 2
         * total : 20.00
         * my_invite : [{"user_id":19536,"phone":"13075070618","nickName":"","create_time":null,"first_money":null,"avatarUrl":"","isVip":1,"vip_text":"已开通","money":0},{"user_id":19533,"phone":"15212790160","nickName":"厉害了","create_time":"2021-03-14","first_money":"10.00","avatarUrl":"http://gsyp.vtui365.com/uploads/20210310161151c0f376216.jpeg","isVip":1,"vip_text":"已开通","money":"10.00"}]
         */

        private String file_path;
        private String invite_code;
        private int count;
        private String total;
        private List<MyInviteBean> my_invite;

        public String getFile_path() {
            return file_path;
        }

        public void setFile_path(String file_path) {
            this.file_path = file_path;
        }

        public String getInvite_code() {
            return invite_code;
        }

        public void setInvite_code(String invite_code) {
            this.invite_code = invite_code;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public List<MyInviteBean> getMy_invite() {
            return my_invite;
        }

        public void setMy_invite(List<MyInviteBean> my_invite) {
            this.my_invite = my_invite;
        }

        public static class MyInviteBean {
            /**
             * user_id : 19536
             * phone : 13075070618
             * nickName :
             * create_time : null
             * first_money : null
             * avatarUrl :
             * isVip : 1
             * vip_text : 已开通
             * money : 0
             */

            private int user_id;
            private String phone;
            private String nickName;
            private String create_time;
            private Object first_money;
            private String avatarUrl;
            private int isVip;
            private String vip_text;
            private int money;

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public Object getFirst_money() {
                return first_money;
            }

            public void setFirst_money(Object first_money) {
                this.first_money = first_money;
            }

            public String getAvatarUrl() {
                return avatarUrl;
            }

            public void setAvatarUrl(String avatarUrl) {
                this.avatarUrl = avatarUrl;
            }

            public int getIsVip() {
                return isVip;
            }

            public void setIsVip(int isVip) {
                this.isVip = isVip;
            }

            public String getVip_text() {
                return vip_text;
            }

            public void setVip_text(String vip_text) {
                this.vip_text = vip_text;
            }

            public int getMoney() {
                return money;
            }

            public void setMoney(int money) {
                this.money = money;
            }
        }
    }
}
