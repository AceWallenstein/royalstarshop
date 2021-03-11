package com.pinnoocle.royalstarshop.bean;

import java.util.List;

public class QuestionModel {
    /**
     * code : 1
     * msg : success
     * data : [{"id":1,"title":"购物车商品怎么删除不了","content":"购物车商品怎么删除不了","create_time":"1970-01-01 08:00:00","wxapp_id":10001}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * title : 购物车商品怎么删除不了
         * content : 购物车商品怎么删除不了
         * create_time : 1970-01-01 08:00:00
         * wxapp_id : 10001
         */

        private int id;
        private String title;
        private String content;
        private String create_time;
        private int wxapp_id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public int getWxapp_id() {
            return wxapp_id;
        }

        public void setWxapp_id(int wxapp_id) {
            this.wxapp_id = wxapp_id;
        }
    }
}
