package com.pinnoocle.royalstarshop.bean;

public class MessageCountModel {

    /**
     * code : 1
     * msg : success
     * data : {"system":{"count":1,"lastNews":{"id":1,"user_id":19533,"type":20,"content":"您的订单：2021032218305850501005已发货请注意查收","is_read":0,"wxapp_id":10001,"create_time":"2021-03-23 10:05:22","update_time":"2021-03-23 10:05:22"}},"trade":{"count":1,"lastNews":{"id":1,"user_id":19533,"type":20,"content":"您的订单：2021032218305850501005已发货请注意查收","is_read":0,"wxapp_id":10001,"create_time":"2021-03-23 10:05:22","update_time":"2021-03-23 10:05:22"}}}
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
         * system : {"count":1,"lastNews":{"id":1,"user_id":19533,"type":20,"content":"您的订单：2021032218305850501005已发货请注意查收","is_read":0,"wxapp_id":10001,"create_time":"2021-03-23 10:05:22","update_time":"2021-03-23 10:05:22"}}
         * trade : {"count":1,"lastNews":{"id":1,"user_id":19533,"type":20,"content":"您的订单：2021032218305850501005已发货请注意查收","is_read":0,"wxapp_id":10001,"create_time":"2021-03-23 10:05:22","update_time":"2021-03-23 10:05:22"}}
         */

        private SystemBean system;
        private TradeBean trade;

        public SystemBean getSystem() {
            return system;
        }

        public void setSystem(SystemBean system) {
            this.system = system;
        }

        public TradeBean getTrade() {
            return trade;
        }

        public void setTrade(TradeBean trade) {
            this.trade = trade;
        }

        public static class SystemBean {
            /**
             * count : 1
             * lastNews : {"id":1,"user_id":19533,"type":20,"content":"您的订单：2021032218305850501005已发货请注意查收","is_read":0,"wxapp_id":10001,"create_time":"2021-03-23 10:05:22","update_time":"2021-03-23 10:05:22"}
             */

            private int count;
            private LastNewsBean lastNews;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public LastNewsBean getLastNews() {
                return lastNews;
            }

            public void setLastNews(LastNewsBean lastNews) {
                this.lastNews = lastNews;
            }

            public static class LastNewsBean {
                /**
                 * id : 1
                 * user_id : 19533
                 * type : 20
                 * content : 您的订单：2021032218305850501005已发货请注意查收
                 * is_read : 0
                 * wxapp_id : 10001
                 * create_time : 2021-03-23 10:05:22
                 * update_time : 2021-03-23 10:05:22
                 */

                private int id;
                private int user_id;
                private int type;
                private String content;
                private int is_read;
                private int wxapp_id;
                private String create_time;
                private String update_time;

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

        public static class TradeBean {
            /**
             * count : 1
             * lastNews : {"id":1,"user_id":19533,"type":20,"content":"您的订单：2021032218305850501005已发货请注意查收","is_read":0,"wxapp_id":10001,"create_time":"2021-03-23 10:05:22","update_time":"2021-03-23 10:05:22"}
             */

            private int count;
            private LastNewsBeanX lastNews;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public LastNewsBeanX getLastNews() {
                return lastNews;
            }

            public void setLastNews(LastNewsBeanX lastNews) {
                this.lastNews = lastNews;
            }

            public static class LastNewsBeanX {
                /**
                 * id : 1
                 * user_id : 19533
                 * type : 20
                 * content : 您的订单：2021032218305850501005已发货请注意查收
                 * is_read : 0
                 * wxapp_id : 10001
                 * create_time : 2021-03-23 10:05:22
                 * update_time : 2021-03-23 10:05:22
                 */

                private int id;
                private int user_id;
                private int type;
                private String content;
                private int is_read;
                private int wxapp_id;
                private String create_time;
                private String update_time;

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
    }
}
