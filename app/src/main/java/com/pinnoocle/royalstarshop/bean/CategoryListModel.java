package com.pinnoocle.royalstarshop.bean;

import java.util.List;

public class CategoryListModel {

    /**
     * code : 1
     * msg : success
     * data : {"list":[{"category_id":10565,"name":"家具","parent_id":0,"image_id":25603,"sort":100,"create_time":"2020-12-17 09:34:53","image_id2":25609,"image":"http://www.huantenghui.com/uploads/20201217093442460794044.png","image2":"http://www.huantenghui.com/uploads/2020121716172223e2c1086.png","child":[{"category_id":10569,"name":"椅子","parent_id":10565,"image_id":25603,"sort":100,"create_time":"2020-12-17 11:04:00","image_id2":0,"image":"http://www.huantenghui.com/uploads/20201217093442460794044.png"}]}]}
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
             * category_id : 10565
             * name : 家具
             * parent_id : 0
             * image_id : 25603
             * sort : 100
             * create_time : 2020-12-17 09:34:53
             * image_id2 : 25609
             * image : http://www.huantenghui.com/uploads/20201217093442460794044.png
             * image2 : http://www.huantenghui.com/uploads/2020121716172223e2c1086.png
             * child : [{"category_id":10569,"name":"椅子","parent_id":10565,"image_id":25603,"sort":100,"create_time":"2020-12-17 11:04:00","image_id2":0,"image":"http://www.huantenghui.com/uploads/20201217093442460794044.png"}]
             */

            private int category_id;
            private String name;
            private int parent_id;
            private int image_id;
            private int sort;
            private String create_time;
            private int image_id2;
            private String image;
            private String image2;
            private List<ChildBean> child;

            public int getCategory_id() {
                return category_id;
            }

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getParent_id() {
                return parent_id;
            }

            public void setParent_id(int parent_id) {
                this.parent_id = parent_id;
            }

            public int getImage_id() {
                return image_id;
            }

            public void setImage_id(int image_id) {
                this.image_id = image_id;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public int getImage_id2() {
                return image_id2;
            }

            public void setImage_id2(int image_id2) {
                this.image_id2 = image_id2;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getImage2() {
                return image2;
            }

            public void setImage2(String image2) {
                this.image2 = image2;
            }

            public List<ChildBean> getChild() {
                return child;
            }

            public void setChild(List<ChildBean> child) {
                this.child = child;
            }

            public static class ChildBean {
                /**
                 * category_id : 10569
                 * name : 椅子
                 * parent_id : 10565
                 * image_id : 25603
                 * sort : 100
                 * create_time : 2020-12-17 11:04:00
                 * image_id2 : 0
                 * image : http://www.huantenghui.com/uploads/20201217093442460794044.png
                 */

                private int category_id;
                private String name;
                private int parent_id;
                private int image_id;
                private int sort;
                private String create_time;
                private int image_id2;
                private String image;

                public int getCategory_id() {
                    return category_id;
                }

                public void setCategory_id(int category_id) {
                    this.category_id = category_id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getParent_id() {
                    return parent_id;
                }

                public void setParent_id(int parent_id) {
                    this.parent_id = parent_id;
                }

                public int getImage_id() {
                    return image_id;
                }

                public void setImage_id(int image_id) {
                    this.image_id = image_id;
                }

                public int getSort() {
                    return sort;
                }

                public void setSort(int sort) {
                    this.sort = sort;
                }

                public String getCreate_time() {
                    return create_time;
                }

                public void setCreate_time(String create_time) {
                    this.create_time = create_time;
                }

                public int getImage_id2() {
                    return image_id2;
                }

                public void setImage_id2(int image_id2) {
                    this.image_id2 = image_id2;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }
            }
        }
    }
}
