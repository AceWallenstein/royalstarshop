package com.pinnoocle.royalstarshop.bean;

public class PosterModel {
    /**
     * code : 1
     * msg : success
     * data : {"path":"http://gsyp.vtui365.com/tmp/poster/poster_19529.png"}
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
         * path : http://gsyp.vtui365.com/tmp/poster/poster_19529.png
         */

        private String path;

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
    }
}
