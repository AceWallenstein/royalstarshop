package com.pinnoocle.royalstarshop.bean;

import java.util.List;

public class VipGoodsModel {


    /**
     * code : 1
     * msg : success
     * data : {"vip_goods":{"goods_id":12941,"goods_name":"荣事达纯铁锅仅需9金豆","selling_point":"","category_id":10585,"spec_type":10,"deduct_stock_type":10,"content":"<p><img src=\"http://gsyp.vtui365.com/uploads/20210318141808dd8740239.gif\"/><\/p><p><img src=\"http://gsyp.vtui365.com/uploads/202103181418086449a4290.gif\"/><\/p><p><img src=\"http://gsyp.vtui365.com/uploads/202103181418082a1f09683.gif\"/><\/p><p><img src=\"http://gsyp.vtui365.com/uploads/20210318141807dfe101386.gif\"/><\/p><p><br/><\/p>","goods_sort":100,"buy_limit":0,"goods_status":{"text":"上架","value":10},"type":{"value":1,"text":"普通商品"},"freight":"20.00","video_id":0,"points":0,"tag":{"value":1,"text":"精选"},"scan_num":0,"recommend_type":0,"goods_stock":1000,"goods_image":"http://gsyp.vtui365.com/uploads/202103181414403c0815937.jpg","goods_sku":{"goods_sku_id":39307,"goods_id":12941,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"99.00","goods_price":"99.00","line_price":"0.00","stock_num":1000,"goods_sales":0,"goods_weight":3,"goods_attr":"","image":null},"goods_multi_spec":null,"category":{"category_id":10585,"name":"小家电馆","parent_id":0,"image_id":26088,"sort":100,"create_time":"2021-03-03 15:16:59"},"image":[{"id":34602,"goods_id":12941,"image_id":26186,"file_path":"http://gsyp.vtui365.com/uploads/202103181414403c0815937.jpg","file_name":"202103181414403c0815937.jpg","file_url":""}],"sku":[{"goods_sku_id":39307,"goods_id":12941,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"99.00","goods_price":"99.00","line_price":"0.00","stock_num":1000,"goods_sales":0,"goods_weight":3,"goods_attr":"","image":null}],"video":null,"goods_sales":100},"vip_goods_money":0,"vip_goods_point":"9","vip_goods_text":"荣事达纯铁锅仅需9金豆","vip_banner":{"file_id":26191,"storage":"local","group_id":0,"file_url":"","file_name":"20210318152717018c26728.png","file_size":90521,"file_type":"image","extension":"png","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://gsyp.vtui365.com/uploads/20210318152717018c26728.png"}}
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
         * vip_goods : {"goods_id":12941,"goods_name":"荣事达纯铁锅仅需9金豆","selling_point":"","category_id":10585,"spec_type":10,"deduct_stock_type":10,"content":"<p><img src=\"http://gsyp.vtui365.com/uploads/20210318141808dd8740239.gif\"/><\/p><p><img src=\"http://gsyp.vtui365.com/uploads/202103181418086449a4290.gif\"/><\/p><p><img src=\"http://gsyp.vtui365.com/uploads/202103181418082a1f09683.gif\"/><\/p><p><img src=\"http://gsyp.vtui365.com/uploads/20210318141807dfe101386.gif\"/><\/p><p><br/><\/p>","goods_sort":100,"buy_limit":0,"goods_status":{"text":"上架","value":10},"type":{"value":1,"text":"普通商品"},"freight":"20.00","video_id":0,"points":0,"tag":{"value":1,"text":"精选"},"scan_num":0,"recommend_type":0,"goods_stock":1000,"goods_image":"http://gsyp.vtui365.com/uploads/202103181414403c0815937.jpg","goods_sku":{"goods_sku_id":39307,"goods_id":12941,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"99.00","goods_price":"99.00","line_price":"0.00","stock_num":1000,"goods_sales":0,"goods_weight":3,"goods_attr":"","image":null},"goods_multi_spec":null,"category":{"category_id":10585,"name":"小家电馆","parent_id":0,"image_id":26088,"sort":100,"create_time":"2021-03-03 15:16:59"},"image":[{"id":34602,"goods_id":12941,"image_id":26186,"file_path":"http://gsyp.vtui365.com/uploads/202103181414403c0815937.jpg","file_name":"202103181414403c0815937.jpg","file_url":""}],"sku":[{"goods_sku_id":39307,"goods_id":12941,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"99.00","goods_price":"99.00","line_price":"0.00","stock_num":1000,"goods_sales":0,"goods_weight":3,"goods_attr":"","image":null}],"video":null,"goods_sales":100}
         * vip_goods_money : 0
         * vip_goods_point : 9
         * vip_goods_text : 荣事达纯铁锅仅需9金豆
         * vip_banner : {"file_id":26191,"storage":"local","group_id":0,"file_url":"","file_name":"20210318152717018c26728.png","file_size":90521,"file_type":"image","extension":"png","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://gsyp.vtui365.com/uploads/20210318152717018c26728.png"}
         */

        private VipGoodsBean vip_goods;
        private int vip_goods_money;
        private String vip_goods_point;
        private String vip_goods_text;
        private VipBannerBean vip_banner;

        public VipGoodsBean getVip_goods() {
            return vip_goods;
        }

        public void setVip_goods(VipGoodsBean vip_goods) {
            this.vip_goods = vip_goods;
        }

        public int getVip_goods_money() {
            return vip_goods_money;
        }

        public void setVip_goods_money(int vip_goods_money) {
            this.vip_goods_money = vip_goods_money;
        }

        public String getVip_goods_point() {
            return vip_goods_point;
        }

        public void setVip_goods_point(String vip_goods_point) {
            this.vip_goods_point = vip_goods_point;
        }

        public String getVip_goods_text() {
            return vip_goods_text;
        }

        public void setVip_goods_text(String vip_goods_text) {
            this.vip_goods_text = vip_goods_text;
        }

        public VipBannerBean getVip_banner() {
            return vip_banner;
        }

        public void setVip_banner(VipBannerBean vip_banner) {
            this.vip_banner = vip_banner;
        }

        public static class VipGoodsBean {
            /**
             * goods_id : 12941
             * goods_name : 荣事达纯铁锅仅需9金豆
             * selling_point :
             * category_id : 10585
             * spec_type : 10
             * deduct_stock_type : 10
             * content : <p><img src="http://gsyp.vtui365.com/uploads/20210318141808dd8740239.gif"/></p><p><img src="http://gsyp.vtui365.com/uploads/202103181418086449a4290.gif"/></p><p><img src="http://gsyp.vtui365.com/uploads/202103181418082a1f09683.gif"/></p><p><img src="http://gsyp.vtui365.com/uploads/20210318141807dfe101386.gif"/></p><p><br/></p>
             * goods_sort : 100
             * buy_limit : 0
             * goods_status : {"text":"上架","value":10}
             * type : {"value":1,"text":"普通商品"}
             * freight : 20.00
             * video_id : 0
             * points : 0
             * tag : {"value":1,"text":"精选"}
             * scan_num : 0
             * recommend_type : 0
             * goods_stock : 1000
             * goods_image : http://gsyp.vtui365.com/uploads/202103181414403c0815937.jpg
             * goods_sku : {"goods_sku_id":39307,"goods_id":12941,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"99.00","goods_price":"99.00","line_price":"0.00","stock_num":1000,"goods_sales":0,"goods_weight":3,"goods_attr":"","image":null}
             * goods_multi_spec : null
             * category : {"category_id":10585,"name":"小家电馆","parent_id":0,"image_id":26088,"sort":100,"create_time":"2021-03-03 15:16:59"}
             * image : [{"id":34602,"goods_id":12941,"image_id":26186,"file_path":"http://gsyp.vtui365.com/uploads/202103181414403c0815937.jpg","file_name":"202103181414403c0815937.jpg","file_url":""}]
             * sku : [{"goods_sku_id":39307,"goods_id":12941,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"99.00","goods_price":"99.00","line_price":"0.00","stock_num":1000,"goods_sales":0,"goods_weight":3,"goods_attr":"","image":null}]
             * video : null
             * goods_sales : 100
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
            private int scan_num;
            private int recommend_type;
            private int goods_stock;
            private String goods_image;
            private GoodsSkuBean goods_sku;
            private Object goods_multi_spec;
            private CategoryBean category;
            private Object video;
            private int goods_sales;
            private List<ImageBean> image;
            private List<SkuBean> sku;

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

            public int getScan_num() {
                return scan_num;
            }

            public void setScan_num(int scan_num) {
                this.scan_num = scan_num;
            }

            public int getRecommend_type() {
                return recommend_type;
            }

            public void setRecommend_type(int recommend_type) {
                this.recommend_type = recommend_type;
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

            public CategoryBean getCategory() {
                return category;
            }

            public void setCategory(CategoryBean category) {
                this.category = category;
            }

            public Object getVideo() {
                return video;
            }

            public void setVideo(Object video) {
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

            public static class TagBean {
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

            public static class GoodsSkuBean {
                /**
                 * goods_sku_id : 39307
                 * goods_id : 12941
                 * spec_sku_id : 0
                 * image_id : 0
                 * goods_no :
                 * balance_price : 99.00
                 * goods_price : 99.00
                 * line_price : 0.00
                 * stock_num : 1000
                 * goods_sales : 0
                 * goods_weight : 3
                 * goods_attr :
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

            public static class CategoryBean {
                /**
                 * category_id : 10585
                 * name : 小家电馆
                 * parent_id : 0
                 * image_id : 26088
                 * sort : 100
                 * create_time : 2021-03-03 15:16:59
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

            public static class ImageBean {
                /**
                 * id : 34602
                 * goods_id : 12941
                 * image_id : 26186
                 * file_path : http://gsyp.vtui365.com/uploads/202103181414403c0815937.jpg
                 * file_name : 202103181414403c0815937.jpg
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
                 * goods_sku_id : 39307
                 * goods_id : 12941
                 * spec_sku_id : 0
                 * image_id : 0
                 * goods_no :
                 * balance_price : 99.00
                 * goods_price : 99.00
                 * line_price : 0.00
                 * stock_num : 1000
                 * goods_sales : 0
                 * goods_weight : 3
                 * goods_attr :
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
        }

        public static class VipBannerBean {
            /**
             * file_id : 26191
             * storage : local
             * group_id : 0
             * file_url :
             * file_name : 20210318152717018c26728.png
             * file_size : 90521
             * file_type : image
             * extension : png
             * is_user : 0
             * is_recycle : 0
             * is_delete : 0
             * file_path : http://gsyp.vtui365.com/uploads/20210318152717018c26728.png
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
