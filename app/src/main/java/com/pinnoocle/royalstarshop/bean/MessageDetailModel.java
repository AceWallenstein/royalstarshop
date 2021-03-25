package com.pinnoocle.royalstarshop.bean;

public class MessageDetailModel {

    /**
     * code : 1
     * msg : success
     * data : {"id":2,"user_id":19556,"type":10,"content":"您的订单：2021032314525353985650支付成功，平台会尽快给您发货！","is_read":1,"wxapp_id":10001,"create_time":"2021-03-23 14:57:04","update_time":"2021-03-23 14:57:04"}
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
         * id : 2
         * user_id : 19556
         * type : 10
         * content : 您的订单：2021032314525353985650支付成功，平台会尽快给您发货！
         * is_read : 1
         * wxapp_id : 10001
         * create_time : 2021-03-23 14:57:04
         * update_time : 2021-03-23 14:57:04
         */

        private int id;
        private int user_id;
        private int type;
        private String content;
        private int is_read;
        private int wxapp_id;
        private String create_time;
        private String update_time;
        private String title;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getIs_read() {
            return is_read;
        }

        public void setIs_read(int is_read) {
            this.is_read = is_read;
        }

        public int getWxapp_id() {
            return wxapp_id;
        }

        public void setWxapp_id(int wxapp_id) {
            this.wxapp_id = wxapp_id;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
        }
    }
}
