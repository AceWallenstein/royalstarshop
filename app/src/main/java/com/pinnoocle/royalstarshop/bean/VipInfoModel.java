package com.pinnoocle.royalstarshop.bean;

import java.util.List;

public class VipInfoModel {

    /**
     * code : 1
     * msg : success
     * data : {"time":"365","point":"99","money":"99","discount_money":"0","title":"广视优品尊享会员一年","vip_goods":{"goods_id":12941,"goods_name":"荣事达纯铁锅仅需9金豆","selling_point":"","category_id":10585,"spec_type":10,"deduct_stock_type":10,"content":"<p><img src=\"http://gsyp.vtui365.com/uploads/20210318141808dd8740239.gif\"/><\/p><p><img src=\"http://gsyp.vtui365.com/uploads/202103181418086449a4290.gif\"/><\/p><p><img src=\"http://gsyp.vtui365.com/uploads/202103181418082a1f09683.gif\"/><\/p><p><img src=\"http://gsyp.vtui365.com/uploads/20210318141807dfe101386.gif\"/><\/p><p><br/><\/p>","goods_sort":100,"buy_limit":0,"goods_status":{"text":"上架","value":10},"type":{"value":1,"text":"普通商品"},"freight":"20.00","video_id":0,"points":0,"tag":{"value":1,"text":"精选"},"scan_num":0,"recommend_type":0,"goods_stock":957,"goods_image":"http://gsyp.vtui365.com/uploads/202103181414403c0815937.jpg","goods_sku":{"goods_sku_id":39307,"goods_id":12941,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"99.00","goods_price":"99.00","line_price":"0.00","stock_num":957,"goods_sales":14,"goods_weight":3,"goods_attr":"","image":null},"goods_multi_spec":null,"category":{"category_id":10585,"name":"小家电馆","parent_id":0,"image_id":26088,"sort":100,"create_time":"2021-03-03 15:16:59"},"image":[{"id":34602,"goods_id":12941,"image_id":26186,"file_path":"http://gsyp.vtui365.com/uploads/202103181414403c0815937.jpg","file_name":"202103181414403c0815937.jpg","file_url":""}],"sku":[{"goods_sku_id":39307,"goods_id":12941,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"99.00","goods_price":"99.00","line_price":"0.00","stock_num":957,"goods_sales":14,"goods_weight":3,"goods_attr":"","image":null}],"video":null,"goods_sales":114},"vip_goods_money":0,"vip_goods_point":"9","vip_text":"成为会员立送99金豆","vip_goods_text":"荣事达纯铁锅仅需9金豆","userInfo":{"user_id":19533,"nickName":"厉害了","avatarUrl":"http://gsyp.vtui365.com/uploads/20210319141411b7abf7346.jpeg","gender":"未知","address_id":13991,"balance":"0.00","points":602,"pay_money":"12.00","expend_money":"0.00","phone":"15212790160","lasttime":null,"address":[{"address_id":13990,"name":"ttttt","phone":"13612121369","province_id":1,"city_id":2,"region_id":3,"district":"","detail":"ttt","longitude":"","latitude":"","user_id":19533,"region":{"province":"北京市","city":"北京市","region":"东城区"}},{"address_id":13991,"name":"ABC","phone":"13332153636","province_id":1,"city_id":2,"region_id":3,"district":"","detail":"tttt","longitude":"","latitude":"","user_id":19533,"region":{"province":"北京市","city":"北京市","region":"东城区"}}],"username":null,"invite_code":"2RdqGW","isVip":1,"vip_time":1615532201,"vip_expire":"2022-03-12","parent_id":19529,"service_id":0,"birth":null,"ercode":"/tmp/qrcode/qrcode_19533.png","poster":"/tmp/poster/poster_19533.png","login_num":13,"vip_order":0,"is_expire":0,"next_time":"2023-03-12","address_default":{"address_id":13991,"name":"ABC","phone":"13332153636","province_id":1,"city_id":2,"region_id":3,"district":"","detail":"tttt","longitude":"","latitude":"","user_id":19533,"region":{"province":"北京市","city":"北京市","region":"东城区"}},"grade":null}}
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
         * time : 365
         * point : 99
         * money : 99
         * discount_money : 0
         * title : 广视优品尊享会员一年
         * vip_goods : {"goods_id":12941,"goods_name":"荣事达纯铁锅仅需9金豆","selling_point":"","category_id":10585,"spec_type":10,"deduct_stock_type":10,"content":"<p><img src=\"http://gsyp.vtui365.com/uploads/20210318141808dd8740239.gif\"/><\/p><p><img src=\"http://gsyp.vtui365.com/uploads/202103181418086449a4290.gif\"/><\/p><p><img src=\"http://gsyp.vtui365.com/uploads/202103181418082a1f09683.gif\"/><\/p><p><img src=\"http://gsyp.vtui365.com/uploads/20210318141807dfe101386.gif\"/><\/p><p><br/><\/p>","goods_sort":100,"buy_limit":0,"goods_status":{"text":"上架","value":10},"type":{"value":1,"text":"普通商品"},"freight":"20.00","video_id":0,"points":0,"tag":{"value":1,"text":"精选"},"scan_num":0,"recommend_type":0,"goods_stock":957,"goods_image":"http://gsyp.vtui365.com/uploads/202103181414403c0815937.jpg","goods_sku":{"goods_sku_id":39307,"goods_id":12941,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"99.00","goods_price":"99.00","line_price":"0.00","stock_num":957,"goods_sales":14,"goods_weight":3,"goods_attr":"","image":null},"goods_multi_spec":null,"category":{"category_id":10585,"name":"小家电馆","parent_id":0,"image_id":26088,"sort":100,"create_time":"2021-03-03 15:16:59"},"image":[{"id":34602,"goods_id":12941,"image_id":26186,"file_path":"http://gsyp.vtui365.com/uploads/202103181414403c0815937.jpg","file_name":"202103181414403c0815937.jpg","file_url":""}],"sku":[{"goods_sku_id":39307,"goods_id":12941,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"99.00","goods_price":"99.00","line_price":"0.00","stock_num":957,"goods_sales":14,"goods_weight":3,"goods_attr":"","image":null}],"video":null,"goods_sales":114}
         * vip_goods_money : 0
         * vip_goods_point : 9
         * vip_text : 成为会员立送99金豆
         * vip_goods_text : 荣事达纯铁锅仅需9金豆
         * userInfo : {"user_id":19533,"nickName":"厉害了","avatarUrl":"http://gsyp.vtui365.com/uploads/20210319141411b7abf7346.jpeg","gender":"未知","address_id":13991,"balance":"0.00","points":602,"pay_money":"12.00","expend_money":"0.00","phone":"15212790160","lasttime":null,"address":[{"address_id":13990,"name":"ttttt","phone":"13612121369","province_id":1,"city_id":2,"region_id":3,"district":"","detail":"ttt","longitude":"","latitude":"","user_id":19533,"region":{"province":"北京市","city":"北京市","region":"东城区"}},{"address_id":13991,"name":"ABC","phone":"13332153636","province_id":1,"city_id":2,"region_id":3,"district":"","detail":"tttt","longitude":"","latitude":"","user_id":19533,"region":{"province":"北京市","city":"北京市","region":"东城区"}}],"username":null,"invite_code":"2RdqGW","isVip":1,"vip_time":1615532201,"vip_expire":"2022-03-12","parent_id":19529,"service_id":0,"birth":null,"ercode":"/tmp/qrcode/qrcode_19533.png","poster":"/tmp/poster/poster_19533.png","login_num":13,"vip_order":0,"is_expire":0,"next_time":"2023-03-12","address_default":{"address_id":13991,"name":"ABC","phone":"13332153636","province_id":1,"city_id":2,"region_id":3,"district":"","detail":"tttt","longitude":"","latitude":"","user_id":19533,"region":{"province":"北京市","city":"北京市","region":"东城区"}},"grade":null}
         */
        private String  user_time;

        public String getUser_time() {
            return user_time;
        }

        public void setUser_time(String user_time) {
            this.user_time = user_time;
        }

        private String time;
        private String point;
        private String money;
        private String discount_money;
        private String title;
        private VipGoodsBean vip_goods;
        private int vip_goods_money;
        private String vip_goods_point;
        private String vip_text;
        private String vip_goods_text;
        private UserInfoBean userInfo;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getPoint() {
            return point;
        }

        public void setPoint(String point) {
            this.point = point;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getDiscount_money() {
            return discount_money;
        }

        public void setDiscount_money(String discount_money) {
            this.discount_money = discount_money;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

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

        public String getVip_text() {
            return vip_text;
        }

        public void setVip_text(String vip_text) {
            this.vip_text = vip_text;
        }

        public String getVip_goods_text() {
            return vip_goods_text;
        }

        public void setVip_goods_text(String vip_goods_text) {
            this.vip_goods_text = vip_goods_text;
        }

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
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
             * goods_stock : 957
             * goods_image : http://gsyp.vtui365.com/uploads/202103181414403c0815937.jpg
             * goods_sku : {"goods_sku_id":39307,"goods_id":12941,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"99.00","goods_price":"99.00","line_price":"0.00","stock_num":957,"goods_sales":14,"goods_weight":3,"goods_attr":"","image":null}
             * goods_multi_spec : null
             * category : {"category_id":10585,"name":"小家电馆","parent_id":0,"image_id":26088,"sort":100,"create_time":"2021-03-03 15:16:59"}
             * image : [{"id":34602,"goods_id":12941,"image_id":26186,"file_path":"http://gsyp.vtui365.com/uploads/202103181414403c0815937.jpg","file_name":"202103181414403c0815937.jpg","file_url":""}]
             * sku : [{"goods_sku_id":39307,"goods_id":12941,"spec_sku_id":"0","image_id":0,"goods_no":"","balance_price":"99.00","goods_price":"99.00","line_price":"0.00","stock_num":957,"goods_sales":14,"goods_weight":3,"goods_attr":"","image":null}]
             * video : null
             * goods_sales : 114
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
                 * stock_num : 957
                 * goods_sales : 14
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
                 * stock_num : 957
                 * goods_sales : 14
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

        public static class UserInfoBean {
            /**
             * user_id : 19533
             * nickName : 厉害了
             * avatarUrl : http://gsyp.vtui365.com/uploads/20210319141411b7abf7346.jpeg
             * gender : 未知
             * address_id : 13991
             * balance : 0.00
             * points : 602
             * pay_money : 12.00
             * expend_money : 0.00
             * phone : 15212790160
             * lasttime : null
             * address : [{"address_id":13990,"name":"ttttt","phone":"13612121369","province_id":1,"city_id":2,"region_id":3,"district":"","detail":"ttt","longitude":"","latitude":"","user_id":19533,"region":{"province":"北京市","city":"北京市","region":"东城区"}},{"address_id":13991,"name":"ABC","phone":"13332153636","province_id":1,"city_id":2,"region_id":3,"district":"","detail":"tttt","longitude":"","latitude":"","user_id":19533,"region":{"province":"北京市","city":"北京市","region":"东城区"}}]
             * username : null
             * invite_code : 2RdqGW
             * isVip : 1
             * vip_time : 1615532201
             * vip_expire : 2022-03-12
             * parent_id : 19529
             * service_id : 0
             * birth : null
             * ercode : /tmp/qrcode/qrcode_19533.png
             * poster : /tmp/poster/poster_19533.png
             * login_num : 13
             * vip_order : 0
             * is_expire : 0
             * next_time : 2023-03-12
             * address_default : {"address_id":13991,"name":"ABC","phone":"13332153636","province_id":1,"city_id":2,"region_id":3,"district":"","detail":"tttt","longitude":"","latitude":"","user_id":19533,"region":{"province":"北京市","city":"北京市","region":"东城区"}}
             * grade : null
             */

            private int user_id;
            private String nickName;
            private String avatarUrl;
            private String gender;
            private int address_id;
            private String balance;
            private int points;
            private String pay_money;
            private String expend_money;
            private String phone;
            private Object lasttime;
            private Object username;
            private String invite_code;
            private int isVip;
            private int vip_time;
            private String vip_expire;
            private int parent_id;
            private int service_id;
            private Object birth;
            private String ercode;
            private String poster;
            private int login_num;
            private int vip_order;
            private int is_expire;
            private String next_time;
            private AddressDefaultBean address_default;
            private Object grade;
            private List<AddressBean> address;

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getAvatarUrl() {
                return avatarUrl;
            }

            public void setAvatarUrl(String avatarUrl) {
                this.avatarUrl = avatarUrl;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            public int getAddress_id() {
                return address_id;
            }

            public void setAddress_id(int address_id) {
                this.address_id = address_id;
            }

            public String getBalance() {
                return balance;
            }

            public void setBalance(String balance) {
                this.balance = balance;
            }

            public int getPoints() {
                return points;
            }

            public void setPoints(int points) {
                this.points = points;
            }

            public String getPay_money() {
                return pay_money;
            }

            public void setPay_money(String pay_money) {
                this.pay_money = pay_money;
            }

            public String getExpend_money() {
                return expend_money;
            }

            public void setExpend_money(String expend_money) {
                this.expend_money = expend_money;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public Object getLasttime() {
                return lasttime;
            }

            public void setLasttime(Object lasttime) {
                this.lasttime = lasttime;
            }

            public Object getUsername() {
                return username;
            }

            public void setUsername(Object username) {
                this.username = username;
            }

            public String getInvite_code() {
                return invite_code;
            }

            public void setInvite_code(String invite_code) {
                this.invite_code = invite_code;
            }

            public int getIsVip() {
                return isVip;
            }

            public void setIsVip(int isVip) {
                this.isVip = isVip;
            }

            public int getVip_time() {
                return vip_time;
            }

            public void setVip_time(int vip_time) {
                this.vip_time = vip_time;
            }

            public String getVip_expire() {
                return vip_expire;
            }

            public void setVip_expire(String vip_expire) {
                this.vip_expire = vip_expire;
            }

            public int getParent_id() {
                return parent_id;
            }

            public void setParent_id(int parent_id) {
                this.parent_id = parent_id;
            }

            public int getService_id() {
                return service_id;
            }

            public void setService_id(int service_id) {
                this.service_id = service_id;
            }

            public Object getBirth() {
                return birth;
            }

            public void setBirth(Object birth) {
                this.birth = birth;
            }

            public String getErcode() {
                return ercode;
            }

            public void setErcode(String ercode) {
                this.ercode = ercode;
            }

            public String getPoster() {
                return poster;
            }

            public void setPoster(String poster) {
                this.poster = poster;
            }

            public int getLogin_num() {
                return login_num;
            }

            public void setLogin_num(int login_num) {
                this.login_num = login_num;
            }

            public int getVip_order() {
                return vip_order;
            }

            public void setVip_order(int vip_order) {
                this.vip_order = vip_order;
            }

            public int getIs_expire() {
                return is_expire;
            }

            public void setIs_expire(int is_expire) {
                this.is_expire = is_expire;
            }

            public String getNext_time() {
                return next_time;
            }

            public void setNext_time(String next_time) {
                this.next_time = next_time;
            }

            public AddressDefaultBean getAddress_default() {
                return address_default;
            }

            public void setAddress_default(AddressDefaultBean address_default) {
                this.address_default = address_default;
            }

            public Object getGrade() {
                return grade;
            }

            public void setGrade(Object grade) {
                this.grade = grade;
            }

            public List<AddressBean> getAddress() {
                return address;
            }

            public void setAddress(List<AddressBean> address) {
                this.address = address;
            }

            public static class AddressDefaultBean {
                /**
                 * address_id : 13991
                 * name : ABC
                 * phone : 13332153636
                 * province_id : 1
                 * city_id : 2
                 * region_id : 3
                 * district :
                 * detail : tttt
                 * longitude :
                 * latitude :
                 * user_id : 19533
                 * region : {"province":"北京市","city":"北京市","region":"东城区"}
                 */

                private int address_id;
                private String name;
                private String phone;
                private int province_id;
                private int city_id;
                private int region_id;
                private String district;
                private String detail;
                private String longitude;
                private String latitude;
                private int user_id;
                private RegionBean region;

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

                public int getProvince_id() {
                    return province_id;
                }

                public void setProvince_id(int province_id) {
                    this.province_id = province_id;
                }

                public int getCity_id() {
                    return city_id;
                }

                public void setCity_id(int city_id) {
                    this.city_id = city_id;
                }

                public int getRegion_id() {
                    return region_id;
                }

                public void setRegion_id(int region_id) {
                    this.region_id = region_id;
                }

                public String getDistrict() {
                    return district;
                }

                public void setDistrict(String district) {
                    this.district = district;
                }

                public String getDetail() {
                    return detail;
                }

                public void setDetail(String detail) {
                    this.detail = detail;
                }

                public String getLongitude() {
                    return longitude;
                }

                public void setLongitude(String longitude) {
                    this.longitude = longitude;
                }

                public String getLatitude() {
                    return latitude;
                }

                public void setLatitude(String latitude) {
                    this.latitude = latitude;
                }

                public int getUser_id() {
                    return user_id;
                }

                public void setUser_id(int user_id) {
                    this.user_id = user_id;
                }

                public RegionBean getRegion() {
                    return region;
                }

                public void setRegion(RegionBean region) {
                    this.region = region;
                }

                public static class RegionBean {
                    /**
                     * province : 北京市
                     * city : 北京市
                     * region : 东城区
                     */

                    private String province;
                    private String city;
                    private String region;

                    public String getProvince() {
                        return province;
                    }

                    public void setProvince(String province) {
                        this.province = province;
                    }

                    public String getCity() {
                        return city;
                    }

                    public void setCity(String city) {
                        this.city = city;
                    }

                    public String getRegion() {
                        return region;
                    }

                    public void setRegion(String region) {
                        this.region = region;
                    }
                }
            }

            public static class AddressBean {
                /**
                 * address_id : 13990
                 * name : ttttt
                 * phone : 13612121369
                 * province_id : 1
                 * city_id : 2
                 * region_id : 3
                 * district :
                 * detail : ttt
                 * longitude :
                 * latitude :
                 * user_id : 19533
                 * region : {"province":"北京市","city":"北京市","region":"东城区"}
                 */

                private int address_id;
                private String name;
                private String phone;
                private int province_id;
                private int city_id;
                private int region_id;
                private String district;
                private String detail;
                private String longitude;
                private String latitude;
                private int user_id;
                private RegionBeanX region;

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

                public int getProvince_id() {
                    return province_id;
                }

                public void setProvince_id(int province_id) {
                    this.province_id = province_id;
                }

                public int getCity_id() {
                    return city_id;
                }

                public void setCity_id(int city_id) {
                    this.city_id = city_id;
                }

                public int getRegion_id() {
                    return region_id;
                }

                public void setRegion_id(int region_id) {
                    this.region_id = region_id;
                }

                public String getDistrict() {
                    return district;
                }

                public void setDistrict(String district) {
                    this.district = district;
                }

                public String getDetail() {
                    return detail;
                }

                public void setDetail(String detail) {
                    this.detail = detail;
                }

                public String getLongitude() {
                    return longitude;
                }

                public void setLongitude(String longitude) {
                    this.longitude = longitude;
                }

                public String getLatitude() {
                    return latitude;
                }

                public void setLatitude(String latitude) {
                    this.latitude = latitude;
                }

                public int getUser_id() {
                    return user_id;
                }

                public void setUser_id(int user_id) {
                    this.user_id = user_id;
                }

                public RegionBeanX getRegion() {
                    return region;
                }

                public void setRegion(RegionBeanX region) {
                    this.region = region;
                }

                public static class RegionBeanX {
                    /**
                     * province : 北京市
                     * city : 北京市
                     * region : 东城区
                     */

                    private String province;
                    private String city;
                    private String region;

                    public String getProvince() {
                        return province;
                    }

                    public void setProvince(String province) {
                        this.province = province;
                    }

                    public String getCity() {
                        return city;
                    }

                    public void setCity(String city) {
                        this.city = city;
                    }

                    public String getRegion() {
                        return region;
                    }

                    public void setRegion(String region) {
                        this.region = region;
                    }
                }
            }
        }
    }
}
