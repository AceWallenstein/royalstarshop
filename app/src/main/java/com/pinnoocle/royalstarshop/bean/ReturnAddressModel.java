package com.pinnoocle.royalstarshop.bean;

import java.util.List;

public class ReturnAddressModel {

    /**
     * code : 1
     * msg : success
     * data : {"list":[{"address_id":10006,"name":"ccc","phone":"15212790101","detail":"测试地址","sort":100,"is_delete":0,"wxapp_id":10001,"create_time":"2021-03-17 13:59:48","update_time":"2021-03-17 13:59:48"}]}
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
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * address_id : 10006
             * name : ccc
             * phone : 15212790101
             * detail : 测试地址
             * sort : 100
             * is_delete : 0
             * wxapp_id : 10001
             * create_time : 2021-03-17 13:59:48
             * update_time : 2021-03-17 13:59:48
             */

            private int address_id;
            private String name;
            private String phone;
            private String detail;
            private int sort;
            private int is_delete;
            private int wxapp_id;
            private String create_time;
            private String update_time;

            public int getAddress_id() {
                return address_id;
            }

            public void setAddress_id(int address_id) {
                this.address_id = address_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public int getIs_delete() {
                return is_delete;
            }

            public void setIs_delete(int is_delete) {
                this.is_delete = is_delete;
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
}
