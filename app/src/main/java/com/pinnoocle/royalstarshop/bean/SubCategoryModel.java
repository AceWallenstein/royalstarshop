package com.pinnoocle.royalstarshop.bean;

import java.util.List;

public class SubCategoryModel {

    /**
     * code : 1
     * msg : success
     * data : [{"category_id":10582,"name":"冰洗馆","parent_id":0,"image_id":26082,"sort":100,"create_time":"2021-03-03 15:15:36","image":{"file_id":26082,"storage":"local","group_id":0,"file_url":"","file_name":"20210225222922115662859.jpg","file_size":1470,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://gsyp.vtui365.com/uploads/20210225222922115662859.jpg"}},{"category_id":10586,"name":"立柜式","parent_id":10582,"image_id":26082,"sort":100,"create_time":"2021-03-03 15:18:35","image":{"file_id":26082,"storage":"local","group_id":0,"file_url":"","file_name":"20210225222922115662859.jpg","file_size":1470,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://gsyp.vtui365.com/uploads/20210225222922115662859.jpg"}},{"category_id":10587,"name":"台式","parent_id":10582,"image_id":0,"sort":100,"create_time":"2021-03-03 15:18:55","image":null},{"category_id":10588,"name":"节能式","parent_id":10582,"image_id":0,"sort":100,"create_time":"2021-03-03 15:19:24","image":null}]
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
         * category_id : 10582
         * name : 冰洗馆
         * parent_id : 0
         * image_id : 26082
         * sort : 100
         * create_time : 2021-03-03 15:15:36
         * image : {"file_id":26082,"storage":"local","group_id":0,"file_url":"","file_name":"20210225222922115662859.jpg","file_size":1470,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://gsyp.vtui365.com/uploads/20210225222922115662859.jpg"}
         */

        private int category_id;
        private String name;
        private int parent_id;
        private int image_id;
        private int sort;
        private String create_time;
        private ImageBean image;

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

        public ImageBean getImage() {
            return image;
        }

        public void setImage(ImageBean image) {
            this.image = image;
        }

        public static class ImageBean {
            /**
             * file_id : 26082
             * storage : local
             * group_id : 0
             * file_url :
             * file_name : 20210225222922115662859.jpg
             * file_size : 1470
             * file_type : image
             * extension : jpg
             * is_user : 0
             * is_recycle : 0
             * is_delete : 0
             * file_path : http://gsyp.vtui365.com/uploads/20210225222922115662859.jpg
             */

            private int file_id;
            private String storage;
            private int group_id;
            private String file_url;
            private String file_name;
            private int file_size;
            private String file_type;
            private String extension;
            private int is_user;
            private int is_recycle;
            private int is_delete;
            private String file_path;

            public int getFile_id() {
                return file_id;
            }

            public void setFile_id(int file_id) {
                this.file_id = file_id;
            }

            public String getStorage() {
                return storage;
            }

            public void setStorage(String storage) {
                this.storage = storage;
            }

            public int getGroup_id() {
                return group_id;
            }

            public void setGroup_id(int group_id) {
                this.group_id = group_id;
            }

            public String getFile_url() {
                return file_url;
            }

            public void setFile_url(String file_url) {
                this.file_url = file_url;
            }

            public String getFile_name() {
                return file_name;
            }

            public void setFile_name(String file_name) {
                this.file_name = file_name;
            }

            public int getFile_size() {
                return file_size;
            }

            public void setFile_size(int file_size) {
                this.file_size = file_size;
            }

            public String getFile_type() {
                return file_type;
            }

            public void setFile_type(String file_type) {
                this.file_type = file_type;
            }

            public String getExtension() {
                return extension;
            }

            public void setExtension(String extension) {
                this.extension = extension;
            }

            public int getIs_user() {
                return is_user;
            }

            public void setIs_user(int is_user) {
                this.is_user = is_user;
            }

            public int getIs_recycle() {
                return is_recycle;
            }

            public void setIs_recycle(int is_recycle) {
                this.is_recycle = is_recycle;
            }

            public int getIs_delete() {
                return is_delete;
            }

            public void setIs_delete(int is_delete) {
                this.is_delete = is_delete;
            }

            public String getFile_path() {
                return file_path;
            }

            public void setFile_path(String file_path) {
                this.file_path = file_path;
            }
        }
    }
}
