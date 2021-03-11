package com.pinnoocle.royalstarshop.bean;

import java.util.List;

public class FeedbackListModel {


    /**
     * code : 1
     * msg : success
     * data : {"total":1,"per_page":10,"current_page":1,"last_page":1,"data":[{"id":1,"user_id":19533,"wxapp_id":10001,"type":"产品使用问题","content":"不高兴","create_time":"2021-03-11 13:50:05","answer":null,"phone":"13613136719","image":[{"id":1,"feedback_id":1,"image_id":0,"wxapp_id":10001,"create_time":"2021-03-11 13:50:05","file_path":null,"file_name":null,"file_url":null}]}]}
     */

    private int code;
    private String msg;
    private DataBeanX data;

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

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * total : 1
         * per_page : 10
         * current_page : 1
         * last_page : 1
         * data : [{"id":1,"user_id":19533,"wxapp_id":10001,"type":"产品使用问题","content":"不高兴","create_time":"2021-03-11 13:50:05","answer":null,"phone":"13613136719","image":[{"id":1,"feedback_id":1,"image_id":0,"wxapp_id":10001,"create_time":"2021-03-11 13:50:05","file_path":null,"file_name":null,"file_url":null}]}]
         */

        private int total;
        private int per_page;
        private int current_page;
        private int last_page;
        private List<DataBean> data;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPer_page() {
            return per_page;
        }

        public void setPer_page(int per_page) {
            this.per_page = per_page;
        }

        public int getCurrent_page() {
            return current_page;
        }

        public void setCurrent_page(int current_page) {
            this.current_page = current_page;
        }

        public int getLast_page() {
            return last_page;
        }

        public void setLast_page(int last_page) {
            this.last_page = last_page;
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
             * user_id : 19533
             * wxapp_id : 10001
             * type : 产品使用问题
             * content : 不高兴
             * create_time : 2021-03-11 13:50:05
             * answer : null
             * phone : 13613136719
             * image : [{"id":1,"feedback_id":1,"image_id":0,"wxapp_id":10001,"create_time":"2021-03-11 13:50:05","file_path":null,"file_name":null,"file_url":null}]
             */

            private int id;
            private int user_id;
            private int wxapp_id;
            private String type;
            private String content;
            private String create_time;
            private Object answer;
            private String phone;
            private List<ImageBean> image;

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

            public int getWxapp_id() {
                return wxapp_id;
            }

            public void setWxapp_id(int wxapp_id) {
                this.wxapp_id = wxapp_id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
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

            public Object getAnswer() {
                return answer;
            }

            public void setAnswer(Object answer) {
                this.answer = answer;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public List<ImageBean> getImage() {
                return image;
            }

            public void setImage(List<ImageBean> image) {
                this.image = image;
            }

            public static class ImageBean {
                /**
                 * id : 1
                 * feedback_id : 1
                 * image_id : 0
                 * wxapp_id : 10001
                 * create_time : 2021-03-11 13:50:05
                 * file_path : null
                 * file_name : null
                 * file_url : null
                 */

                private int id;
                private int feedback_id;
                private int image_id;
                private int wxapp_id;
                private String create_time;
                private Object file_path;
                private Object file_name;
                private Object file_url;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getFeedback_id() {
                    return feedback_id;
                }

                public void setFeedback_id(int feedback_id) {
                    this.feedback_id = feedback_id;
                }

                public int getImage_id() {
                    return image_id;
                }

                public void setImage_id(int image_id) {
                    this.image_id = image_id;
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

                public Object getFile_path() {
                    return file_path;
                }

                public void setFile_path(Object file_path) {
                    this.file_path = file_path;
                }

                public Object getFile_name() {
                    return file_name;
                }

                public void setFile_name(Object file_name) {
                    this.file_name = file_name;
                }

                public Object getFile_url() {
                    return file_url;
                }

                public void setFile_url(Object file_url) {
                    this.file_url = file_url;
                }
            }
        }
    }
}
