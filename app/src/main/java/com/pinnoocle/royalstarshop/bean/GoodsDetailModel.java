package com.pinnoocle.royalstarshop.bean;

import java.util.List;

public class GoodsDetailModel {

    /**
     * code : 1
     * msg : success
     * data : {"detail":{"goods_id":12926,"goods_name":"电视","selling_point":"","category_id":10581,"spec_type":20,"deduct_stock_type":10,"content":"<p>fasdfasd <\/p>","goods_sort":100,"buy_limit":0,"goods_status":{"text":"上架","value":10},"type":{"value":2,"text":"视频购物"},"freight":"10.00","video_id":26086,"points":0,"tag":{"value":2,"text":"热销爆款"},"comment_data_count":0,"goods_stock":200,"goods_image":"http://www.rongshida.com/uploads/20210225222922115662859.jpg","goods_sku":{"goods_sku_id":39248,"goods_id":12926,"spec_sku_id":"12180","image_id":0,"goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","line_price":"3000.00","stock_num":100,"goods_sales":0,"goods_weight":10,"image":null},"goods_multi_spec":{"spec_attr":[{"group_id":10403,"group_name":"颜色","spec_items":[{"item_id":12180,"spec_value":"黑色"},{"item_id":12181,"spec_value":"白色"}]}],"spec_list":[{"goods_sku_id":39248,"spec_sku_id":"12180","rows":[],"form":{"image_id":0,"image_path":"","goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","goods_weight":10,"line_price":"3000.00","stock_num":100}},{"goods_sku_id":39249,"spec_sku_id":"12181","rows":[],"form":{"image_id":0,"image_path":"","goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","goods_weight":10,"line_price":"3000.00","stock_num":100}}]},"is_user_grade":false,"bought_num":0,"category":{"category_id":10581,"name":"电视","parent_id":0,"image_id":26082,"sort":100,"create_time":"2021-02-25 22:28:55"},"image":[{"id":34548,"goods_id":12926,"image_id":26082,"file_path":"http://www.rongshida.com/uploads/20210225222922115662859.jpg","file_name":"20210225222922115662859.jpg","file_url":""}],"sku":[{"goods_sku_id":39248,"goods_id":12926,"spec_sku_id":"12180","image_id":0,"goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","line_price":"3000.00","stock_num":100,"goods_sales":0,"goods_weight":10,"image":null},{"goods_sku_id":39249,"goods_id":12926,"spec_sku_id":"12181","image_id":0,"goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","line_price":"3000.00","stock_num":100,"goods_sales":0,"goods_weight":10,"image":null}],"comment_data":[],"video":{"file_id":26086,"storage":"local","group_id":0,"file_url":"","file_name":"603cb876f21a2.mp4","file_size":15048581,"file_type":"video","extension":"mp4","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://www.rongshida.com/uploads/603cb876f21a2.mp4"},"goods_sales":0},"cart_total_num":0,"specData":{"spec_attr":[{"group_id":10403,"group_name":"颜色","spec_items":[{"item_id":12180,"spec_value":"黑色"},{"item_id":12181,"spec_value":"白色"}]}],"spec_list":[{"goods_sku_id":39248,"spec_sku_id":"12180","rows":[],"form":{"image_id":0,"image_path":"","goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","goods_weight":10,"line_price":"3000.00","stock_num":100}},{"goods_sku_id":39249,"spec_sku_id":"12181","rows":[],"form":{"image_id":0,"image_path":"","goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","goods_weight":10,"line_price":"3000.00","stock_num":100}}]},"setting":{"points_name":"积分"}}
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
         * detail : {"goods_id":12926,"goods_name":"电视","selling_point":"","category_id":10581,"spec_type":20,"deduct_stock_type":10,"content":"<p>fasdfasd <\/p>","goods_sort":100,"buy_limit":0,"goods_status":{"text":"上架","value":10},"type":{"value":2,"text":"视频购物"},"freight":"10.00","video_id":26086,"points":0,"tag":{"value":2,"text":"热销爆款"},"comment_data_count":0,"goods_stock":200,"goods_image":"http://www.rongshida.com/uploads/20210225222922115662859.jpg","goods_sku":{"goods_sku_id":39248,"goods_id":12926,"spec_sku_id":"12180","image_id":0,"goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","line_price":"3000.00","stock_num":100,"goods_sales":0,"goods_weight":10,"image":null},"goods_multi_spec":{"spec_attr":[{"group_id":10403,"group_name":"颜色","spec_items":[{"item_id":12180,"spec_value":"黑色"},{"item_id":12181,"spec_value":"白色"}]}],"spec_list":[{"goods_sku_id":39248,"spec_sku_id":"12180","rows":[],"form":{"image_id":0,"image_path":"","goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","goods_weight":10,"line_price":"3000.00","stock_num":100}},{"goods_sku_id":39249,"spec_sku_id":"12181","rows":[],"form":{"image_id":0,"image_path":"","goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","goods_weight":10,"line_price":"3000.00","stock_num":100}}]},"is_user_grade":false,"bought_num":0,"category":{"category_id":10581,"name":"电视","parent_id":0,"image_id":26082,"sort":100,"create_time":"2021-02-25 22:28:55"},"image":[{"id":34548,"goods_id":12926,"image_id":26082,"file_path":"http://www.rongshida.com/uploads/20210225222922115662859.jpg","file_name":"20210225222922115662859.jpg","file_url":""}],"sku":[{"goods_sku_id":39248,"goods_id":12926,"spec_sku_id":"12180","image_id":0,"goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","line_price":"3000.00","stock_num":100,"goods_sales":0,"goods_weight":10,"image":null},{"goods_sku_id":39249,"goods_id":12926,"spec_sku_id":"12181","image_id":0,"goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","line_price":"3000.00","stock_num":100,"goods_sales":0,"goods_weight":10,"image":null}],"comment_data":[],"video":{"file_id":26086,"storage":"local","group_id":0,"file_url":"","file_name":"603cb876f21a2.mp4","file_size":15048581,"file_type":"video","extension":"mp4","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://www.rongshida.com/uploads/603cb876f21a2.mp4"},"goods_sales":0}
         * cart_total_num : 0
         * specData : {"spec_attr":[{"group_id":10403,"group_name":"颜色","spec_items":[{"item_id":12180,"spec_value":"黑色"},{"item_id":12181,"spec_value":"白色"}]}],"spec_list":[{"goods_sku_id":39248,"spec_sku_id":"12180","rows":[],"form":{"image_id":0,"image_path":"","goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","goods_weight":10,"line_price":"3000.00","stock_num":100}},{"goods_sku_id":39249,"spec_sku_id":"12181","rows":[],"form":{"image_id":0,"image_path":"","goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","goods_weight":10,"line_price":"3000.00","stock_num":100}}]}
         * setting : {"points_name":"积分"}
         */

        private DetailBean detail;
        private int cart_total_num;
        private SpecDataBean specData;
        private SettingBean setting;

        public DetailBean getDetail() {
            return detail;
        }

        public void setDetail(DetailBean detail) {
            this.detail = detail;
        }

        public int getCart_total_num() {
            return cart_total_num;
        }

        public void setCart_total_num(int cart_total_num) {
            this.cart_total_num = cart_total_num;
        }

        public SpecDataBean getSpecData() {
            return specData;
        }

        public void setSpecData(SpecDataBean specData) {
            this.specData = specData;
        }

        public SettingBean getSetting() {
            return setting;
        }

        public void setSetting(SettingBean setting) {
            this.setting = setting;
        }

        public static class DetailBean {
            /**
             * goods_id : 12926
             * goods_name : 电视
             * selling_point :
             * category_id : 10581
             * spec_type : 20
             * deduct_stock_type : 10
             * content : <p>fasdfasd </p>
             * goods_sort : 100
             * buy_limit : 0
             * goods_status : {"text":"上架","value":10}
             * type : {"value":2,"text":"视频购物"}
             * freight : 10.00
             * video_id : 26086
             * points : 0
             * tag : {"value":2,"text":"热销爆款"}
             * comment_data_count : 0
             * goods_stock : 200
             * goods_image : http://www.rongshida.com/uploads/20210225222922115662859.jpg
             * goods_sku : {"goods_sku_id":39248,"goods_id":12926,"spec_sku_id":"12180","image_id":0,"goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","line_price":"3000.00","stock_num":100,"goods_sales":0,"goods_weight":10,"image":null}
             * goods_multi_spec : {"spec_attr":[{"group_id":10403,"group_name":"颜色","spec_items":[{"item_id":12180,"spec_value":"黑色"},{"item_id":12181,"spec_value":"白色"}]}],"spec_list":[{"goods_sku_id":39248,"spec_sku_id":"12180","rows":[],"form":{"image_id":0,"image_path":"","goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","goods_weight":10,"line_price":"3000.00","stock_num":100}},{"goods_sku_id":39249,"spec_sku_id":"12181","rows":[],"form":{"image_id":0,"image_path":"","goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","goods_weight":10,"line_price":"3000.00","stock_num":100}}]}
             * is_user_grade : false
             * bought_num : 0
             *  "is_collect": 0
             * category : {"category_id":10581,"name":"电视","parent_id":0,"image_id":26082,"sort":100,"create_time":"2021-02-25 22:28:55"}
             * image : [{"id":34548,"goods_id":12926,"image_id":26082,"file_path":"http://www.rongshida.com/uploads/20210225222922115662859.jpg","file_name":"20210225222922115662859.jpg","file_url":""}]
             * sku : [{"goods_sku_id":39248,"goods_id":12926,"spec_sku_id":"12180","image_id":0,"goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","line_price":"3000.00","stock_num":100,"goods_sales":0,"goods_weight":10,"image":null},{"goods_sku_id":39249,"goods_id":12926,"spec_sku_id":"12181","image_id":0,"goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","line_price":"3000.00","stock_num":100,"goods_sales":0,"goods_weight":10,"image":null}]
             * comment_data : []
             * video : {"file_id":26086,"storage":"local","group_id":0,"file_url":"","file_name":"603cb876f21a2.mp4","file_size":15048581,"file_type":"video","extension":"mp4","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://www.rongshida.com/uploads/603cb876f21a2.mp4"}
             * goods_sales : 0
             */

            private int goods_id;
            private String goods_name;
            private String selling_point;
            private int category_id;
            private int spec_type;
            private int deduct_stock_type;
            private String content;
            private int goods_sort;
            private int buy_limit;
            private GoodsStatusBean goods_status;
            private TypeBean type;
            private String freight;
            private int video_id;
            private int points;
            private TagBean tag;
            private int comment_data_count;
            private int goods_stock;
            private String goods_image;
            private GoodsSkuBean goods_sku;
            private GoodsMultiSpecBean goods_multi_spec;
            private boolean is_user_grade;
            private int bought_num;
            private int is_collect;

            public int getIs_collect() {
                return is_collect;
            }

            public void setIs_collect(int is_collect) {
                this.is_collect = is_collect;
            }

            private CategoryBean category;
            private VideoBean video;
            private int goods_sales;
            private List<ImageBean> image;
            private List<SkuBean> sku;
            private List<?> comment_data;

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getSelling_point() {
                return selling_point;
            }

            public void setSelling_point(String selling_point) {
                this.selling_point = selling_point;
            }

            public int getCategory_id() {
                return category_id;
            }

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
            }

            public int getSpec_type() {
                return spec_type;
            }

            public void setSpec_type(int spec_type) {
                this.spec_type = spec_type;
            }

            public int getDeduct_stock_type() {
                return deduct_stock_type;
            }

            public void setDeduct_stock_type(int deduct_stock_type) {
                this.deduct_stock_type = deduct_stock_type;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getGoods_sort() {
                return goods_sort;
            }

            public void setGoods_sort(int goods_sort) {
                this.goods_sort = goods_sort;
            }

            public int getBuy_limit() {
                return buy_limit;
            }

            public void setBuy_limit(int buy_limit) {
                this.buy_limit = buy_limit;
            }

            public GoodsStatusBean getGoods_status() {
                return goods_status;
            }

            public void setGoods_status(GoodsStatusBean goods_status) {
                this.goods_status = goods_status;
            }

            public TypeBean getType() {
                return type;
            }

            public void setType(TypeBean type) {
                this.type = type;
            }

            public String getFreight() {
                return freight;
            }

            public void setFreight(String freight) {
                this.freight = freight;
            }

            public int getVideo_id() {
                return video_id;
            }

            public void setVideo_id(int video_id) {
                this.video_id = video_id;
            }

            public int getPoints() {
                return points;
            }

            public void setPoints(int points) {
                this.points = points;
            }

            public TagBean getTag() {
                return tag;
            }

            public void setTag(TagBean tag) {
                this.tag = tag;
            }

            public int getComment_data_count() {
                return comment_data_count;
            }

            public void setComment_data_count(int comment_data_count) {
                this.comment_data_count = comment_data_count;
            }

            public int getGoods_stock() {
                return goods_stock;
            }

            public void setGoods_stock(int goods_stock) {
                this.goods_stock = goods_stock;
            }

            public String getGoods_image() {
                return goods_image;
            }

            public void setGoods_image(String goods_image) {
                this.goods_image = goods_image;
            }

            public GoodsSkuBean getGoods_sku() {
                return goods_sku;
            }

            public void setGoods_sku(GoodsSkuBean goods_sku) {
                this.goods_sku = goods_sku;
            }

            public GoodsMultiSpecBean getGoods_multi_spec() {
                return goods_multi_spec;
            }

            public void setGoods_multi_spec(GoodsMultiSpecBean goods_multi_spec) {
                this.goods_multi_spec = goods_multi_spec;
            }

            public boolean isIs_user_grade() {
                return is_user_grade;
            }

            public void setIs_user_grade(boolean is_user_grade) {
                this.is_user_grade = is_user_grade;
            }

            public int getBought_num() {
                return bought_num;
            }

            public void setBought_num(int bought_num) {
                this.bought_num = bought_num;
            }

            public CategoryBean getCategory() {
                return category;
            }

            public void setCategory(CategoryBean category) {
                this.category = category;
            }

            public VideoBean getVideo() {
                return video;
            }

            public void setVideo(VideoBean video) {
                this.video = video;
            }

            public int getGoods_sales() {
                return goods_sales;
            }

            public void setGoods_sales(int goods_sales) {
                this.goods_sales = goods_sales;
            }

            public List<ImageBean> getImage() {
                return image;
            }

            public void setImage(List<ImageBean> image) {
                this.image = image;
            }

            public List<SkuBean> getSku() {
                return sku;
            }

            public void setSku(List<SkuBean> sku) {
                this.sku = sku;
            }

            public List<?> getComment_data() {
                return comment_data;
            }

            public void setComment_data(List<?> comment_data) {
                this.comment_data = comment_data;
            }

            public static class GoodsStatusBean {
                /**
                 * text : 上架
                 * value : 10
                 */

                private String text;
                private int value;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }
            }

            public static class TypeBean {
                /**
                 * value : 2
                 * text : 视频购物
                 */

                private int value;
                private String text;

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class TagBean {
                /**
                 * value : 2
                 * text : 热销爆款
                 */

                private int value;
                private String text;

                public int getValue() {
                    return value;
                }

                public void setValue(int value) {
                    this.value = value;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }

            public static class GoodsSkuBean {
                /**
                 * goods_sku_id : 39248
                 * goods_id : 12926
                 * spec_sku_id : 12180
                 * image_id : 0
                 * goods_no : 10001
                 * balance_price : 1000.00
                 * goods_price : 2000.00
                 * line_price : 3000.00
                 * stock_num : 100
                 * goods_sales : 0
                 * goods_weight : 10
                 * image : null
                 */

                private int goods_sku_id;
                private int goods_id;
                private String spec_sku_id;
                private int image_id;
                private String goods_no;
                private String balance_price;
                private String goods_price;
                private String line_price;
                private int stock_num;
                private int goods_sales;
                private int goods_weight;
                private Image image;

                public static class  Image{

                    /**
                     * file_id : 26088
                     * storage : local
                     * group_id : 0
                     * file_url :
                     * file_name : 20210305095413e69454970.png
                     * file_size : 376823
                     * file_type : image
                     * extension : png
                     * is_user : 0
                     * is_recycle : 0
                     * is_delete : 0
                     * file_path : http://gsyp.vtui365.com/uploads/20210305095413e69454970.png
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

                public int getGoods_sku_id() {
                    return goods_sku_id;
                }

                public void setGoods_sku_id(int goods_sku_id) {
                    this.goods_sku_id = goods_sku_id;
                }

                public int getGoods_id() {
                    return goods_id;
                }

                public void setGoods_id(int goods_id) {
                    this.goods_id = goods_id;
                }

                public String getSpec_sku_id() {
                    return spec_sku_id;
                }

                public void setSpec_sku_id(String spec_sku_id) {
                    this.spec_sku_id = spec_sku_id;
                }

                public int getImage_id() {
                    return image_id;
                }

                public void setImage_id(int image_id) {
                    this.image_id = image_id;
                }

                public String getGoods_no() {
                    return goods_no;
                }

                public void setGoods_no(String goods_no) {
                    this.goods_no = goods_no;
                }

                public String getBalance_price() {
                    return balance_price;
                }

                public void setBalance_price(String balance_price) {
                    this.balance_price = balance_price;
                }

                public String getGoods_price() {
                    return goods_price;
                }

                public void setGoods_price(String goods_price) {
                    this.goods_price = goods_price;
                }

                public String getLine_price() {
                    return line_price;
                }

                public void setLine_price(String line_price) {
                    this.line_price = line_price;
                }

                public int getStock_num() {
                    return stock_num;
                }

                public void setStock_num(int stock_num) {
                    this.stock_num = stock_num;
                }

                public int getGoods_sales() {
                    return goods_sales;
                }

                public void setGoods_sales(int goods_sales) {
                    this.goods_sales = goods_sales;
                }

                public int getGoods_weight() {
                    return goods_weight;
                }

                public void setGoods_weight(int goods_weight) {
                    this.goods_weight = goods_weight;
                }

                public Image getImage() {
                    return image;
                }

                public void setImage(Image image) {
                    this.image = image;
                }
            }

            public static class GoodsMultiSpecBean {
                private List<SpecAttrBean> spec_attr;
                private List<SpecListBean> spec_list;

                public List<SpecAttrBean> getSpec_attr() {
                    return spec_attr;
                }

                public void setSpec_attr(List<SpecAttrBean> spec_attr) {
                    this.spec_attr = spec_attr;
                }

                public List<SpecListBean> getSpec_list() {
                    return spec_list;
                }

                public void setSpec_list(List<SpecListBean> spec_list) {
                    this.spec_list = spec_list;
                }

                public static class SpecAttrBean {
                    /**
                     * group_id : 10403
                     * group_name : 颜色
                     * spec_items : [{"item_id":12180,"spec_value":"黑色"},{"item_id":12181,"spec_value":"白色"}]
                     */

                    private int group_id;
                    private String group_name;
                    private List<SpecItemsBean> spec_items;

                    public int getGroup_id() {
                        return group_id;
                    }

                    public void setGroup_id(int group_id) {
                        this.group_id = group_id;
                    }

                    public String getGroup_name() {
                        return group_name;
                    }

                    public void setGroup_name(String group_name) {
                        this.group_name = group_name;
                    }

                    public List<SpecItemsBean> getSpec_items() {
                        return spec_items;
                    }

                    public void setSpec_items(List<SpecItemsBean> spec_items) {
                        this.spec_items = spec_items;
                    }

                    public static class SpecItemsBean {
                        /**
                         * item_id : 12180
                         * spec_value : 黑色
                         */

                        private int item_id;
                        private String spec_value;

                        public int getItem_id() {
                            return item_id;
                        }

                        public void setItem_id(int item_id) {
                            this.item_id = item_id;
                        }

                        public String getSpec_value() {
                            return spec_value;
                        }

                        public void setSpec_value(String spec_value) {
                            this.spec_value = spec_value;
                        }
                    }
                }

                public static class SpecListBean {
                    /**
                     * goods_sku_id : 39248
                     * spec_sku_id : 12180
                     * rows : []
                     * form : {"image_id":0,"image_path":"","goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","goods_weight":10,"line_price":"3000.00","stock_num":100}
                     */

                    private int goods_sku_id;
                    private String spec_sku_id;
                    private FormBean form;
                    private List<?> rows;

                    public int getGoods_sku_id() {
                        return goods_sku_id;
                    }

                    public void setGoods_sku_id(int goods_sku_id) {
                        this.goods_sku_id = goods_sku_id;
                    }

                    public String getSpec_sku_id() {
                        return spec_sku_id;
                    }

                    public void setSpec_sku_id(String spec_sku_id) {
                        this.spec_sku_id = spec_sku_id;
                    }

                    public FormBean getForm() {
                        return form;
                    }

                    public void setForm(FormBean form) {
                        this.form = form;
                    }

                    public List<?> getRows() {
                        return rows;
                    }

                    public void setRows(List<?> rows) {
                        this.rows = rows;
                    }

                    public static class FormBean {
                        /**
                         * image_id : 0
                         * image_path :
                         * goods_no : 10001
                         * balance_price : 1000.00
                         * goods_price : 2000.00
                         * goods_weight : 10
                         * line_price : 3000.00
                         * stock_num : 100
                         */

                        private int image_id;
                        private String image_path;
                        private String goods_no;
                        private String balance_price;
                        private String goods_price;
                        private int goods_weight;
                        private String line_price;
                        private int stock_num;

                        public int getImage_id() {
                            return image_id;
                        }

                        public void setImage_id(int image_id) {
                            this.image_id = image_id;
                        }

                        public String getImage_path() {
                            return image_path;
                        }

                        public void setImage_path(String image_path) {
                            this.image_path = image_path;
                        }

                        public String getGoods_no() {
                            return goods_no;
                        }

                        public void setGoods_no(String goods_no) {
                            this.goods_no = goods_no;
                        }

                        public String getBalance_price() {
                            return balance_price;
                        }

                        public void setBalance_price(String balance_price) {
                            this.balance_price = balance_price;
                        }

                        public String getGoods_price() {
                            return goods_price;
                        }

                        public void setGoods_price(String goods_price) {
                            this.goods_price = goods_price;
                        }

                        public int getGoods_weight() {
                            return goods_weight;
                        }

                        public void setGoods_weight(int goods_weight) {
                            this.goods_weight = goods_weight;
                        }

                        public String getLine_price() {
                            return line_price;
                        }

                        public void setLine_price(String line_price) {
                            this.line_price = line_price;
                        }

                        public int getStock_num() {
                            return stock_num;
                        }

                        public void setStock_num(int stock_num) {
                            this.stock_num = stock_num;
                        }
                    }
                }
            }

            public static class CategoryBean {
                /**
                 * category_id : 10581
                 * name : 电视
                 * parent_id : 0
                 * image_id : 26082
                 * sort : 100
                 * create_time : 2021-02-25 22:28:55
                 */

                private int category_id;
                private String name;
                private int parent_id;
                private int image_id;
                private int sort;
                private String create_time;

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
            }

            public static class VideoBean {
                /**
                 * file_id : 26086
                 * storage : local
                 * group_id : 0
                 * file_url :
                 * file_name : 603cb876f21a2.mp4
                 * file_size : 15048581
                 * file_type : video
                 * extension : mp4
                 * is_user : 0
                 * is_recycle : 0
                 * is_delete : 0
                 * file_path : http://www.rongshida.com/uploads/603cb876f21a2.mp4
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

            public static class ImageBean {
                /**
                 * id : 34548
                 * goods_id : 12926
                 * image_id : 26082
                 * file_path : http://www.rongshida.com/uploads/20210225222922115662859.jpg
                 * file_name : 20210225222922115662859.jpg
                 * file_url :
                 */

                private int id;
                private int goods_id;
                private int image_id;
                private String file_path;
                private String file_name;
                private String file_url;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getGoods_id() {
                    return goods_id;
                }

                public void setGoods_id(int goods_id) {
                    this.goods_id = goods_id;
                }

                public int getImage_id() {
                    return image_id;
                }

                public void setImage_id(int image_id) {
                    this.image_id = image_id;
                }

                public String getFile_path() {
                    return file_path;
                }

                public void setFile_path(String file_path) {
                    this.file_path = file_path;
                }

                public String getFile_name() {
                    return file_name;
                }

                public void setFile_name(String file_name) {
                    this.file_name = file_name;
                }

                public String getFile_url() {
                    return file_url;
                }

                public void setFile_url(String file_url) {
                    this.file_url = file_url;
                }
            }

            public static class SkuBean {
                /**
                 * goods_sku_id : 39248
                 * goods_id : 12926
                 * spec_sku_id : 12180
                 * image_id : 0
                 * goods_no : 10001
                 * balance_price : 1000.00
                 * goods_price : 2000.00
                 * line_price : 3000.00
                 * stock_num : 100
                 * goods_sales : 0
                 * goods_weight : 10
                 * image : null
                 */

                private int goods_sku_id;
                private int goods_id;
                private String spec_sku_id;
                private int image_id;
                private String goods_no;
                private String balance_price;
                private String goods_price;
                private String line_price;
                private int stock_num;
                private int goods_sales;
                private int goods_weight;
                private Object image;

                public int getGoods_sku_id() {
                    return goods_sku_id;
                }

                public void setGoods_sku_id(int goods_sku_id) {
                    this.goods_sku_id = goods_sku_id;
                }

                public int getGoods_id() {
                    return goods_id;
                }

                public void setGoods_id(int goods_id) {
                    this.goods_id = goods_id;
                }

                public String getSpec_sku_id() {
                    return spec_sku_id;
                }

                public void setSpec_sku_id(String spec_sku_id) {
                    this.spec_sku_id = spec_sku_id;
                }

                public int getImage_id() {
                    return image_id;
                }

                public void setImage_id(int image_id) {
                    this.image_id = image_id;
                }

                public String getGoods_no() {
                    return goods_no;
                }

                public void setGoods_no(String goods_no) {
                    this.goods_no = goods_no;
                }

                public String getBalance_price() {
                    return balance_price;
                }

                public void setBalance_price(String balance_price) {
                    this.balance_price = balance_price;
                }

                public String getGoods_price() {
                    return goods_price;
                }

                public void setGoods_price(String goods_price) {
                    this.goods_price = goods_price;
                }

                public String getLine_price() {
                    return line_price;
                }

                public void setLine_price(String line_price) {
                    this.line_price = line_price;
                }

                public int getStock_num() {
                    return stock_num;
                }

                public void setStock_num(int stock_num) {
                    this.stock_num = stock_num;
                }

                public int getGoods_sales() {
                    return goods_sales;
                }

                public void setGoods_sales(int goods_sales) {
                    this.goods_sales = goods_sales;
                }

                public int getGoods_weight() {
                    return goods_weight;
                }

                public void setGoods_weight(int goods_weight) {
                    this.goods_weight = goods_weight;
                }

                public Object getImage() {
                    return image;
                }

                public void setImage(Object image) {
                    this.image = image;
                }
            }
        }

        public static class SpecDataBean {
            private List<SpecAttrBeanX> spec_attr;
            private List<SpecListBeanX> spec_list;

            public List<SpecAttrBeanX> getSpec_attr() {
                return spec_attr;
            }

            public void setSpec_attr(List<SpecAttrBeanX> spec_attr) {
                this.spec_attr = spec_attr;
            }

            public List<SpecListBeanX> getSpec_list() {
                return spec_list;
            }

            public void setSpec_list(List<SpecListBeanX> spec_list) {
                this.spec_list = spec_list;
            }

            public static class SpecAttrBeanX {
                /**
                 * group_id : 10403
                 * group_name : 颜色
                 * spec_items : [{"item_id":12180,"spec_value":"黑色"},{"item_id":12181,"spec_value":"白色"}]
                 */

                private int group_id;
                private String group_name;
                private List<SpecItemsBeanX> spec_items;

                public int getGroup_id() {
                    return group_id;
                }

                public void setGroup_id(int group_id) {
                    this.group_id = group_id;
                }

                public String getGroup_name() {
                    return group_name;
                }

                public void setGroup_name(String group_name) {
                    this.group_name = group_name;
                }

                public List<SpecItemsBeanX> getSpec_items() {
                    return spec_items;
                }

                public void setSpec_items(List<SpecItemsBeanX> spec_items) {
                    this.spec_items = spec_items;
                }

                public static class SpecItemsBeanX {
                    /**
                     * item_id : 12180
                     * spec_value : 黑色
                     */

                    private String item_id;
                    private String spec_value;

                    public String getItem_id() {
                        return item_id;
                    }

                    public void setItem_id(String item_id) {
                        this.item_id = item_id;
                    }

                    public String getSpec_value() {
                        return spec_value;
                    }

                    public void setSpec_value(String spec_value) {
                        this.spec_value = spec_value;
                    }
                }
            }

            public static class SpecListBeanX {
                /**
                 * goods_sku_id : 39248
                 * spec_sku_id : 12180
                 * rows : []
                 * form : {"image_id":0,"image_path":"","goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","goods_weight":10,"line_price":"3000.00","stock_num":100}
                 */

                private int goods_sku_id;
                private String spec_sku_id;
                private FormBeanX form;
                private List<?> rows;

                public int getGoods_sku_id() {
                    return goods_sku_id;
                }

                public void setGoods_sku_id(int goods_sku_id) {
                    this.goods_sku_id = goods_sku_id;
                }

                public String getSpec_sku_id() {
                    return spec_sku_id;
                }

                public void setSpec_sku_id(String spec_sku_id) {
                    this.spec_sku_id = spec_sku_id;
                }

                public FormBeanX getForm() {
                    return form;
                }

                public void setForm(FormBeanX form) {
                    this.form = form;
                }

                public List<?> getRows() {
                    return rows;
                }

                public void setRows(List<?> rows) {
                    this.rows = rows;
                }

                public static class FormBeanX {
                    /**
                     * image_id : 0
                     * image_path :
                     * goods_no : 10001
                     * balance_price : 1000.00
                     * goods_price : 2000.00
                     * goods_weight : 10
                     * line_price : 3000.00
                     * stock_num : 100
                     */

                    private int image_id;
                    private String image_path;
                    private String goods_no;
                    private String balance_price;
                    private String goods_price;
                    private int goods_weight;
                    private String line_price;
                    private int stock_num;

                    public int getImage_id() {
                        return image_id;
                    }

                    public void setImage_id(int image_id) {
                        this.image_id = image_id;
                    }

                    public String getImage_path() {
                        return image_path;
                    }

                    public void setImage_path(String image_path) {
                        this.image_path = image_path;
                    }

                    public String getGoods_no() {
                        return goods_no;
                    }

                    public void setGoods_no(String goods_no) {
                        this.goods_no = goods_no;
                    }

                    public String getBalance_price() {
                        return balance_price;
                    }

                    public void setBalance_price(String balance_price) {
                        this.balance_price = balance_price;
                    }

                    public String getGoods_price() {
                        return goods_price;
                    }

                    public void setGoods_price(String goods_price) {
                        this.goods_price = goods_price;
                    }

                    public int getGoods_weight() {
                        return goods_weight;
                    }

                    public void setGoods_weight(int goods_weight) {
                        this.goods_weight = goods_weight;
                    }

                    public String getLine_price() {
                        return line_price;
                    }

                    public void setLine_price(String line_price) {
                        this.line_price = line_price;
                    }

                    public int getStock_num() {
                        return stock_num;
                    }

                    public void setStock_num(int stock_num) {
                        this.stock_num = stock_num;
                    }
                }
            }
        }

        public static class SettingBean {
            /**
             * points_name : 积分
             */

            private String points_name;

            public String getPoints_name() {
                return points_name;
            }

            public void setPoints_name(String points_name) {
                this.points_name = points_name;
            }
        }
    }
}
