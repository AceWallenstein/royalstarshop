package com.pinnoocle.royalstarshop.bean;

import java.io.Serializable;
import java.util.List;

public class HomeModel implements Serializable  {

    /**
     * code : 1
     * msg : success
     * data : {"vipGoods":[{"goods_id":12924,"goods_name":"电视","selling_point":"电视","category_id":10581,"spec_type":10,"deduct_stock_type":10,"content":"<p>asdfasdf <\/p>","goods_sort":100,"buy_limit":0,"goods_status":{"text":"上架","value":10},"type":{"value":3,"text":"会员商品"},"freight":"10.00","video_id":0,"points":0,"tag":{"value":0,"text":""},"category":{"category_id":10581,"name":"电视","parent_id":0,"image_id":26082,"sort":100,"create_time":"2021-02-25 22:28:55"},"image":[{"id":34547,"goods_id":12924,"image_id":26082,"file_path":"http://www.rongshida.com/uploads/20210225222922115662859.jpg","file_name":"20210225222922115662859.jpg","file_url":""}],"sku":[{"goods_sku_id":39247,"goods_id":12924,"spec_sku_id":"0","image_id":0,"goods_no":"10001","balance_price":"1999.00","goods_price":"2199.00","line_price":"2299.00","stock_num":100,"goods_sales":0,"goods_weight":10,"image":null}],"goods_sales":0}],"videoGoods":[{"goods_id":12926,"goods_name":"电视","selling_point":"","category_id":10581,"spec_type":20,"deduct_stock_type":10,"content":"<p>fasdfasd <\/p>","goods_sort":100,"buy_limit":0,"goods_status":{"text":"上架","value":10},"type":{"value":2,"text":"视频购物"},"freight":"10.00","video_id":26086,"points":0,"tag":{"value":2,"text":"热销爆款"},"category":{"category_id":10581,"name":"电视","parent_id":0,"image_id":26082,"sort":100,"create_time":"2021-02-25 22:28:55"},"image":[{"id":34548,"goods_id":12926,"image_id":26082,"file_path":"http://www.rongshida.com/uploads/20210225222922115662859.jpg","file_name":"20210225222922115662859.jpg","file_url":""}],"sku":[{"goods_sku_id":39248,"goods_id":12926,"spec_sku_id":"12180","image_id":0,"goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","line_price":"3000.00","stock_num":100,"goods_sales":0,"goods_weight":10,"image":null},{"goods_sku_id":39249,"goods_id":12926,"spec_sku_id":"12181","image_id":0,"goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","line_price":"3000.00","stock_num":100,"goods_sales":0,"goods_weight":10,"image":null}],"goods_sales":0}],"tagGoods":[{"title":"精选","value":1,"list":[]},{"title":"热销爆款","value":2,"list":[]},{"title":"新品推荐","value":3,"list":[]},{"title":"疯狂折扣","value":4,"list":[]}]}
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

    public static class DataBean implements Serializable {
        private List<VipGoodsBean> vipGoods;
        private List<VideoGoodsBean> videoGoods;
        private List<TagGoodsBean> tagGoods;

        public List<VipGoodsBean> getVipGoods() {
            return vipGoods;
        }

        public void setVipGoods(List<VipGoodsBean> vipGoods) {
            this.vipGoods = vipGoods;
        }

        public List<VideoGoodsBean> getVideoGoods() {
            return videoGoods;
        }

        public void setVideoGoods(List<VideoGoodsBean> videoGoods) {
            this.videoGoods = videoGoods;
        }

        public List<TagGoodsBean> getTagGoods() {
            return tagGoods;
        }

        public void setTagGoods(List<TagGoodsBean> tagGoods) {
            this.tagGoods = tagGoods;
        }

        public static class VipGoodsBean implements Serializable {
            /**
             * goods_id : 12924
             * goods_name : 电视
             * selling_point : 电视
             * category_id : 10581
             * spec_type : 10
             * deduct_stock_type : 10
             * content : <p>asdfasdf </p>
             * goods_sort : 100
             * buy_limit : 0
             * goods_status : {"text":"上架","value":10}
             * type : {"value":3,"text":"会员商品"}
             * freight : 10.00
             * video_id : 0
             * points : 0
             * tag : {"value":0,"text":""}
             * category : {"category_id":10581,"name":"电视","parent_id":0,"image_id":26082,"sort":100,"create_time":"2021-02-25 22:28:55"}
             * image : [{"id":34547,"goods_id":12924,"image_id":26082,"file_path":"http://www.rongshida.com/uploads/20210225222922115662859.jpg","file_name":"20210225222922115662859.jpg","file_url":""}]
             * sku : [{"goods_sku_id":39247,"goods_id":12924,"spec_sku_id":"0","image_id":0,"goods_no":"10001","balance_price":"1999.00","goods_price":"2199.00","line_price":"2299.00","stock_num":100,"goods_sales":0,"goods_weight":10,"image":null}]
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
            private CategoryBean category;
            private int goods_sales;
            private List<ImageBean> image;
            private List<SkuBean> sku;
            private String goods_min_price;
            private String goods_max_price;
            private String goods_image;
            private GoodsSkuBean goods_sku;
            private int goods_stock;

            public String getGoods_min_price() {
                return goods_min_price;
            }

            public void setGoods_min_price(String goods_min_price) {
                this.goods_min_price = goods_min_price;
            }

            public String getGoods_max_price() {
                return goods_max_price;
            }

            public void setGoods_max_price(String goods_max_price) {
                this.goods_max_price = goods_max_price;
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

            public int getGoods_stock() {
                return goods_stock;
            }

            public void setGoods_stock(int goods_stock) {
                this.goods_stock = goods_stock;
            }

            public static class GoodsSkuBean implements Serializable {
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
                 * goods_attr : 颜色:黑色;
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
                private String goods_attr;
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

                public String getGoods_attr() {
                    return goods_attr;
                }

                public void setGoods_attr(String goods_attr) {
                    this.goods_attr = goods_attr;
                }

                public Object getImage() {
                    return image;
                }

                public void setImage(Object image) {
                    this.image = image;
                }
            }

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

            public CategoryBean getCategory() {
                return category;
            }

            public void setCategory(CategoryBean category) {
                this.category = category;
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

            public static class GoodsStatusBean implements Serializable {
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

            public static class TypeBean implements Serializable {
                /**
                 * value : 3
                 * text : 会员商品
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

            public static class TagBean implements Serializable {
                /**
                 * value : 0
                 * text :
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

            public static class CategoryBean implements Serializable {
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

            public static class ImageBean implements Serializable {
                /**
                 * id : 34547
                 * goods_id : 12924
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

            public static class SkuBean implements Serializable {
                /**
                 * goods_sku_id : 39247
                 * goods_id : 12924
                 * spec_sku_id : 0
                 * image_id : 0
                 * goods_no : 10001
                 * balance_price : 1999.00
                 * goods_price : 2199.00
                 * line_price : 2299.00
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

        public static class VideoGoodsBean implements Serializable {
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
             * category : {"category_id":10581,"name":"电视","parent_id":0,"image_id":26082,"sort":100,"create_time":"2021-02-25 22:28:55"}
             * image : [{"id":34548,"goods_id":12926,"image_id":26082,"file_path":"http://www.rongshida.com/uploads/20210225222922115662859.jpg","file_name":"20210225222922115662859.jpg","file_url":""}]
             * sku : [{"goods_sku_id":39248,"goods_id":12926,"spec_sku_id":"12180","image_id":0,"goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","line_price":"3000.00","stock_num":100,"goods_sales":0,"goods_weight":10,"image":null},{"goods_sku_id":39249,"goods_id":12926,"spec_sku_id":"12181","image_id":0,"goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","line_price":"3000.00","stock_num":100,"goods_sales":0,"goods_weight":10,"image":null}]
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
            private GoodsStatusBeanX goods_status;
            private TypeBeanX type;
            private String freight;
            private int video_id;
            private int points;
            private TagBeanX tag;
            private CategoryBeanX category;
            private int goods_sales;
            private List<ImageBeanX> image;
            private List<SkuBeanX> sku;
            private String goods_min_price;
            private String goods_max_price;
            private String goods_image;
            private GoodsSkuBean goods_sku;
            private int goods_stock;
            private VideoBean video;

            public VideoBean getVideo() {
                return video;
            }

            public void setVideo(VideoBean video) {
                this.video = video;
            }

            public static class VideoBean implements Serializable {
                /**
                 * value : 1
                 * text : 普通商品
                 */

                private int file_id;
                private int group_id;
                private int is_user;
                private int is_recycle;
                private int is_delete;
                private String storage;
                private String file_url;
                private String file_name;
                private String file_size;
                private String file_type;
                private String extension;
                private String file_path;

                public int getFile_id() {
                    return file_id;
                }

                public void setFile_id(int file_id) {
                    this.file_id = file_id;
                }

                public int getGroup_id() {
                    return group_id;
                }

                public void setGroup_id(int group_id) {
                    this.group_id = group_id;
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

                public String getStorage() {
                    return storage;
                }

                public void setStorage(String storage) {
                    this.storage = storage;
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

                public String getFile_size() {
                    return file_size;
                }

                public void setFile_size(String file_size) {
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

                public String getFile_path() {
                    return file_path;
                }

                public void setFile_path(String file_path) {
                    this.file_path = file_path;
                }
            }
            public String getGoods_min_price() {
                return goods_min_price;
            }

            public void setGoods_min_price(String goods_min_price) {
                this.goods_min_price = goods_min_price;
            }

            public String getGoods_max_price() {
                return goods_max_price;
            }

            public void setGoods_max_price(String goods_max_price) {
                this.goods_max_price = goods_max_price;
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

            public int getGoods_stock() {
                return goods_stock;
            }

            public void setGoods_stock(int goods_stock) {
                this.goods_stock = goods_stock;
            }

            public static class GoodsSkuBean implements Serializable {
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
                 * goods_attr : 颜色:黑色;
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
                private String goods_attr;
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

                public String getGoods_attr() {
                    return goods_attr;
                }

                public void setGoods_attr(String goods_attr) {
                    this.goods_attr = goods_attr;
                }

                public Object getImage() {
                    return image;
                }

                public void setImage(Object image) {
                    this.image = image;
                }
            }

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

            public GoodsStatusBeanX getGoods_status() {
                return goods_status;
            }

            public void setGoods_status(GoodsStatusBeanX goods_status) {
                this.goods_status = goods_status;
            }

            public TypeBeanX getType() {
                return type;
            }

            public void setType(TypeBeanX type) {
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

            public TagBeanX getTag() {
                return tag;
            }

            public void setTag(TagBeanX tag) {
                this.tag = tag;
            }

            public CategoryBeanX getCategory() {
                return category;
            }

            public void setCategory(CategoryBeanX category) {
                this.category = category;
            }

            public int getGoods_sales() {
                return goods_sales;
            }

            public void setGoods_sales(int goods_sales) {
                this.goods_sales = goods_sales;
            }

            public List<ImageBeanX> getImage() {
                return image;
            }

            public void setImage(List<ImageBeanX> image) {
                this.image = image;
            }

            public List<SkuBeanX> getSku() {
                return sku;
            }

            public void setSku(List<SkuBeanX> sku) {
                this.sku = sku;
            }

            public static class GoodsStatusBeanX implements Serializable {
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

            public static class TypeBeanX implements Serializable {
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

            public static class TagBeanX implements Serializable {
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

            public static class CategoryBeanX implements Serializable {
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

            public static class ImageBeanX implements Serializable {
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

            public static class SkuBeanX implements Serializable {
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

        public static class TagGoodsBean implements Serializable {
            /**
             * title : 精选
             * value : 1
             * list : []
             */

            private String title;
            private String sub_title;
            private int value;
            private List<ListBean> list;

            public String getSub_title() {
                return sub_title;
            }

            public void setSub_title(String sub_title) {
                this.sub_title = sub_title;
            }

            public static class ListBean implements Serializable {
                /**
                 * goods_id : 12927
                 * goods_name : 海尔（Haier）2匹/3匹自清洁变频空调柜机 家用冷暖立式空调 客厅圆柱立柜式空调 帝樽EDS系列 KFR-50LW/07EDS83/2匹
                 * selling_point : 产品特色：自动清洁，静音空调，圆柱式空调
                 * category_id : 10586
                 * spec_type : 10
                 * deduct_stock_type : 10
                 * goods_sort : 100
                 * buy_limit : 0
                 * goods_status : {"text":"上架","value":10}
                 * type : {"value":1,"text":"普通商品"}
                 * freight : 0.00
                 * video_id : 0
                 * points : 0
                 * tag : {"value":1,"text":"精选"}
                 * goods_sales : 0
                 * goods_min_price : 4099.00
                 * goods_max_price : 4099.00
                 * goods_stock : 1000
                 * goods_image : http://gsyp.vtui365.com/uploads/20210304144650c92fa5848.jpg
                 * goods_sku : {"goods_sku_id":39246,"goods_id":12927,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"4099.00","line_price":"6299.00","stock_num":1000,"goods_sales":0,"goods_weight":100,"image":null}
                 * goods_multi_spec : null
                 * is_user_grade : false
                 */

                private int goods_id;
                private String goods_name;
                private String selling_point;
                private int category_id;
                private int spec_type;
                private int deduct_stock_type;
                private int goods_sort;
                private int buy_limit;
                private GoodsStatusBean goods_status;
                private TypeBean type;
                private String freight;
                private int video_id;
                private int points;
                private TagBean tag;
                private int goods_sales;
                private String goods_min_price;
                private String goods_max_price;
                private int goods_stock;
                private String goods_image;
                private GoodsSkuBean goods_sku;
                private Object goods_multi_spec;
                private CategoryBeanX category;
                private List<ImageBeanX> image;
                private List<SkuBeanX> sku;

                public CategoryBeanX getCategory() {
                    return category;
                }

                public void setCategory(CategoryBeanX category) {
                    this.category = category;
                }

                public List<ImageBeanX> getImage() {
                    return image;
                }

                public void setImage(List<ImageBeanX> image) {
                    this.image = image;
                }

                public List<SkuBeanX> getSku() {
                    return sku;
                }

                public void setSku(List<SkuBeanX> sku) {
                    this.sku = sku;
                }

                public static class CategoryBeanX implements Serializable {
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

                public static class ImageBeanX implements Serializable {
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

                public static class SkuBeanX implements Serializable {
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

                public int getGoods_sales() {
                    return goods_sales;
                }

                public void setGoods_sales(int goods_sales) {
                    this.goods_sales = goods_sales;
                }

                public String getGoods_min_price() {
                    return goods_min_price;
                }

                public void setGoods_min_price(String goods_min_price) {
                    this.goods_min_price = goods_min_price;
                }

                public String getGoods_max_price() {
                    return goods_max_price;
                }

                public void setGoods_max_price(String goods_max_price) {
                    this.goods_max_price = goods_max_price;
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

                public Object getGoods_multi_spec() {
                    return goods_multi_spec;
                }

                public void setGoods_multi_spec(Object goods_multi_spec) {
                    this.goods_multi_spec = goods_multi_spec;
                }


                public static class GoodsStatusBean implements Serializable {
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

                public static class TypeBean implements Serializable {
                    /**
                     * value : 1
                     * text : 普通商品
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

                public static class TagBean implements Serializable {
                    /**
                     * value : 1
                     * text : 精选
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

                public static class GoodsSkuBean implements Serializable {
                    /**
                     * goods_sku_id : 39246
                     * goods_id : 12927
                     * spec_sku_id : 0
                     * image_id : 0
                     * goods_no :
                     * balance_price : 0.00
                     * goods_price : 4099.00
                     * line_price : 6299.00
                     * stock_num : 1000
                     * goods_sales : 0
                     * goods_weight : 100
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

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }
        }
    }
}
