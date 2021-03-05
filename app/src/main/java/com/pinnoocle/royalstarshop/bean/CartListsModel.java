package com.pinnoocle.royalstarshop.bean;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CartListsModel {

    /**
     * code : 1
     * msg : success
     * data : {"goods_list":[{"goods_id":12926,"goods_name":"电视","selling_point":"","category_id":10581,"spec_type":20,"deduct_stock_type":10,"goods_sort":100,"buy_limit":0,"goods_status":{"text":"上架","value":10},"type":{"value":2,"text":"视频购物"},"freight":"10.00","video_id":26086,"points":0,"tag":{"value":2,"text":"热销爆款"},"goods_stock":200,"goods_image":"http://www.rongshida.com/uploads/20210225222922115662859.jpg","goods_sku":{"goods_sku_id":39248,"goods_id":12926,"spec_sku_id":"12180","image_id":0,"goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","line_price":"3000.00","stock_num":100,"goods_sales":0,"goods_weight":10,"goods_attr":"颜色:黑色; ","image":null},"goods_multi_spec":{"spec_attr":[{"group_id":10403,"group_name":"颜色","spec_items":[{"item_id":12180,"spec_value":"黑色"},{"item_id":12181,"spec_value":"白色"}]}],"spec_list":[{"goods_sku_id":39248,"spec_sku_id":"12180","rows":[],"form":{"image_id":0,"image_path":"","goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","goods_weight":10,"line_price":"3000.00","stock_num":100}},{"goods_sku_id":39249,"spec_sku_id":"12181","rows":[],"form":{"image_id":0,"image_path":"","goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","goods_weight":10,"line_price":"3000.00","stock_num":100}}]},"goods_sku_id":"39248","goods_price":"2000.00","total_num":1,"total_freight":"10.00","total_price":"2000.00","is_user_grade":false,"grade_ratio":0,"grade_goods_price":0,"grade_total_money":0,"points_money":0,"points_num":0,"coupon_money":0,"virtual_code_money":0,"total_pay_price":"2000.00","express_price":"0.00","points_bonus":0,"goods_sales":0}],"order_total_num":1,"coupon_list":[],"has_error":false,"error_msg":null,"delivery":10,"address":null,"exist_address":false,"express_price":"0.00","intra_region":true,"extract_shop":[],"is_allow_points":false,"is_use_points":0,"points_money":0,"points_bonus":0,"pay_type":20,"send_payment_msg":0,"send_delivery_msg":0,"send_refund_msg":0,"order_total_price":"2000.00","coupon_id":0,"coupon_money":0,"virtual_code":"","virtual_code_money":0,"freight_price":"10.00","order_price":"2000.00","order_pay_price":"2010.00"}
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
         * goods_list : [{"goods_id":12926,"goods_name":"电视","selling_point":"","category_id":10581,"spec_type":20,"deduct_stock_type":10,"goods_sort":100,"buy_limit":0,"goods_status":{"text":"上架","value":10},"type":{"value":2,"text":"视频购物"},"freight":"10.00","video_id":26086,"points":0,"tag":{"value":2,"text":"热销爆款"},"goods_stock":200,"goods_image":"http://www.rongshida.com/uploads/20210225222922115662859.jpg","goods_sku":{"goods_sku_id":39248,"goods_id":12926,"spec_sku_id":"12180","image_id":0,"goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","line_price":"3000.00","stock_num":100,"goods_sales":0,"goods_weight":10,"goods_attr":"颜色:黑色; ","image":null},"goods_multi_spec":{"spec_attr":[{"group_id":10403,"group_name":"颜色","spec_items":[{"item_id":12180,"spec_value":"黑色"},{"item_id":12181,"spec_value":"白色"}]}],"spec_list":[{"goods_sku_id":39248,"spec_sku_id":"12180","rows":[],"form":{"image_id":0,"image_path":"","goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","goods_weight":10,"line_price":"3000.00","stock_num":100}},{"goods_sku_id":39249,"spec_sku_id":"12181","rows":[],"form":{"image_id":0,"image_path":"","goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","goods_weight":10,"line_price":"3000.00","stock_num":100}}]},"goods_sku_id":"39248","goods_price":"2000.00","total_num":1,"total_freight":"10.00","total_price":"2000.00","is_user_grade":false,"grade_ratio":0,"grade_goods_price":0,"grade_total_money":0,"points_money":0,"points_num":0,"coupon_money":0,"virtual_code_money":0,"total_pay_price":"2000.00","express_price":"0.00","points_bonus":0,"goods_sales":0}]
         * order_total_num : 1
         * coupon_list : []
         * has_error : false
         * error_msg : null
         * delivery : 10
         * address : null
         * exist_address : false
         * express_price : 0.00
         * intra_region : true
         * extract_shop : []
         * is_allow_points : false
         * is_use_points : 0
         * points_money : 0
         * points_bonus : 0
         * pay_type : 20
         * send_payment_msg : 0
         * send_delivery_msg : 0
         * send_refund_msg : 0
         * order_total_price : 2000.00
         * coupon_id : 0
         * coupon_money : 0
         * virtual_code :
         * virtual_code_money : 0
         * freight_price : 10.00
         * order_price : 2000.00
         * order_pay_price : 2010.00
         */

        private int order_total_num;
        private boolean has_error;
        private Object error_msg;
        private int delivery;
        private Object address;
        private boolean exist_address;
        private String express_price;
        private boolean intra_region;
        private boolean is_allow_points;
        private int is_use_points;
        private int points_money;
        private int points_bonus;
        private int pay_type;
        private int send_payment_msg;
        private int send_delivery_msg;
        private int send_refund_msg;
        private String order_total_price;
        private int coupon_id;
        private int coupon_money;
        private String virtual_code;
        private int virtual_code_money;
        private String freight_price;
        private String order_price;
        private String order_pay_price;
        private List<GoodsListBean> goods_list;
        private List<?> coupon_list;
        private List<?> extract_shop;

        public int getOrder_total_num() {
            return order_total_num;
        }

        public void setOrder_total_num(int order_total_num) {
            this.order_total_num = order_total_num;
        }

        public boolean isHas_error() {
            return has_error;
        }

        public void setHas_error(boolean has_error) {
            this.has_error = has_error;
        }

        public Object getError_msg() {
            return error_msg;
        }

        public void setError_msg(Object error_msg) {
            this.error_msg = error_msg;
        }

        public int getDelivery() {
            return delivery;
        }

        public void setDelivery(int delivery) {
            this.delivery = delivery;
        }

        public Object getAddress() {
            return address;
        }

        public void setAddress(Object address) {
            this.address = address;
        }

        public boolean isExist_address() {
            return exist_address;
        }

        public void setExist_address(boolean exist_address) {
            this.exist_address = exist_address;
        }

        public String getExpress_price() {
            return express_price;
        }

        public void setExpress_price(String express_price) {
            this.express_price = express_price;
        }

        public boolean isIntra_region() {
            return intra_region;
        }

        public void setIntra_region(boolean intra_region) {
            this.intra_region = intra_region;
        }

        public boolean isIs_allow_points() {
            return is_allow_points;
        }

        public void setIs_allow_points(boolean is_allow_points) {
            this.is_allow_points = is_allow_points;
        }

        public int getIs_use_points() {
            return is_use_points;
        }

        public void setIs_use_points(int is_use_points) {
            this.is_use_points = is_use_points;
        }

        public int getPoints_money() {
            return points_money;
        }

        public void setPoints_money(int points_money) {
            this.points_money = points_money;
        }

        public int getPoints_bonus() {
            return points_bonus;
        }

        public void setPoints_bonus(int points_bonus) {
            this.points_bonus = points_bonus;
        }

        public int getPay_type() {
            return pay_type;
        }

        public void setPay_type(int pay_type) {
            this.pay_type = pay_type;
        }

        public int getSend_payment_msg() {
            return send_payment_msg;
        }

        public void setSend_payment_msg(int send_payment_msg) {
            this.send_payment_msg = send_payment_msg;
        }

        public int getSend_delivery_msg() {
            return send_delivery_msg;
        }

        public void setSend_delivery_msg(int send_delivery_msg) {
            this.send_delivery_msg = send_delivery_msg;
        }

        public int getSend_refund_msg() {
            return send_refund_msg;
        }

        public void setSend_refund_msg(int send_refund_msg) {
            this.send_refund_msg = send_refund_msg;
        }

        public String getOrder_total_price() {
            return order_total_price;
        }

        public void setOrder_total_price(String order_total_price) {
            this.order_total_price = order_total_price;
        }

        public int getCoupon_id() {
            return coupon_id;
        }

        public void setCoupon_id(int coupon_id) {
            this.coupon_id = coupon_id;
        }

        public int getCoupon_money() {
            return coupon_money;
        }

        public void setCoupon_money(int coupon_money) {
            this.coupon_money = coupon_money;
        }

        public String getVirtual_code() {
            return virtual_code;
        }

        public void setVirtual_code(String virtual_code) {
            this.virtual_code = virtual_code;
        }

        public int getVirtual_code_money() {
            return virtual_code_money;
        }

        public void setVirtual_code_money(int virtual_code_money) {
            this.virtual_code_money = virtual_code_money;
        }

        public String getFreight_price() {
            return freight_price;
        }

        public void setFreight_price(String freight_price) {
            this.freight_price = freight_price;
        }

        public String getOrder_price() {
            return order_price;
        }

        public void setOrder_price(String order_price) {
            this.order_price = order_price;
        }

        public String getOrder_pay_price() {
            return order_pay_price;
        }

        public void setOrder_pay_price(String order_pay_price) {
            this.order_pay_price = order_pay_price;
        }

        public List<GoodsListBean> getGoods_list() {
            return goods_list;
        }

        public void setGoods_list(List<GoodsListBean> goods_list) {
            this.goods_list = goods_list;
        }

        public List<?> getCoupon_list() {
            return coupon_list;
        }

        public void setCoupon_list(List<?> coupon_list) {
            this.coupon_list = coupon_list;
        }

        public List<?> getExtract_shop() {
            return extract_shop;
        }

        public void setExtract_shop(List<?> extract_shop) {
            this.extract_shop = extract_shop;
        }

        public static class GoodsListBean {
            /**
             * goods_id : 12926
             * goods_name : 电视
             * selling_point :
             * category_id : 10581
             * spec_type : 20
             * deduct_stock_type : 10
             * goods_sort : 100
             * buy_limit : 0
             * goods_status : {"text":"上架","value":10}
             * type : {"value":2,"text":"视频购物"}
             * freight : 10.00
             * video_id : 26086
             * points : 0
             * tag : {"value":2,"text":"热销爆款"}
             * goods_stock : 200
             * goods_image : http://www.rongshida.com/uploads/20210225222922115662859.jpg
             * goods_sku : {"goods_sku_id":39248,"goods_id":12926,"spec_sku_id":"12180","image_id":0,"goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","line_price":"3000.00","stock_num":100,"goods_sales":0,"goods_weight":10,"goods_attr":"颜色:黑色; ","image":null}
             * goods_multi_spec : {"spec_attr":[{"group_id":10403,"group_name":"颜色","spec_items":[{"item_id":12180,"spec_value":"黑色"},{"item_id":12181,"spec_value":"白色"}]}],"spec_list":[{"goods_sku_id":39248,"spec_sku_id":"12180","rows":[],"form":{"image_id":0,"image_path":"","goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","goods_weight":10,"line_price":"3000.00","stock_num":100}},{"goods_sku_id":39249,"spec_sku_id":"12181","rows":[],"form":{"image_id":0,"image_path":"","goods_no":"10001","balance_price":"1000.00","goods_price":"2000.00","goods_weight":10,"line_price":"3000.00","stock_num":100}}]}
             * goods_sku_id : 39248
             * goods_price : 2000.00
             * total_num : 1
             * total_freight : 10.00
             * total_price : 2000.00
             * is_user_grade : false
             * grade_ratio : 0
             * grade_goods_price : 0
             * grade_total_money : 0
             * points_money : 0
             * points_num : 0
             * coupon_money : 0
             * virtual_code_money : 0
             * total_pay_price : 2000.00
             * express_price : 0.00
             * points_bonus : 0
             * goods_sales : 0
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
            private int goods_stock;
            private String goods_image;
            private GoodsSkuBean goods_sku;
            private GoodsMultiSpecBean goods_multi_spec;
            private String goods_sku_id;
            private String goods_price;
            private int total_num;
            private String total_freight;
            private String total_price;
            private boolean is_user_grade;
            private int grade_ratio;
            private int grade_goods_price;
            private int grade_total_money;
            private int points_money;
            private int points_num;
            private int coupon_money;
            private int virtual_code_money;
            private String total_pay_price;
            private String express_price;
            private int points_bonus;
            private int goods_sales;
            private boolean is_select;
            private int nums;

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

            public String getGoods_sku_id() {
                return goods_sku_id;
            }

            public void setGoods_sku_id(String goods_sku_id) {
                this.goods_sku_id = goods_sku_id;
            }

            public String getGoods_price() {
                return goods_price;
            }

            public void setGoods_price(String goods_price) {
                this.goods_price = goods_price;
            }

            public int getTotal_num() {
                return total_num;
            }

            public void setTotal_num(int total_num) {
                this.total_num = total_num;
            }

            public String getTotal_freight() {
                return total_freight;
            }

            public void setTotal_freight(String total_freight) {
                this.total_freight = total_freight;
            }

            public String getTotal_price() {
                return total_price;
            }

            public void setTotal_price(String total_price) {
                this.total_price = total_price;
            }

            public boolean isIs_user_grade() {
                return is_user_grade;
            }

            public void setIs_user_grade(boolean is_user_grade) {
                this.is_user_grade = is_user_grade;
            }

            public int getGrade_ratio() {
                return grade_ratio;
            }

            public void setGrade_ratio(int grade_ratio) {
                this.grade_ratio = grade_ratio;
            }

            public int getGrade_goods_price() {
                return grade_goods_price;
            }

            public void setGrade_goods_price(int grade_goods_price) {
                this.grade_goods_price = grade_goods_price;
            }

            public int getGrade_total_money() {
                return grade_total_money;
            }

            public void setGrade_total_money(int grade_total_money) {
                this.grade_total_money = grade_total_money;
            }

            public int getPoints_money() {
                return points_money;
            }

            public void setPoints_money(int points_money) {
                this.points_money = points_money;
            }

            public int getPoints_num() {
                return points_num;
            }

            public void setPoints_num(int points_num) {
                this.points_num = points_num;
            }

            public int getCoupon_money() {
                return coupon_money;
            }

            public void setCoupon_money(int coupon_money) {
                this.coupon_money = coupon_money;
            }

            public int getVirtual_code_money() {
                return virtual_code_money;
            }

            public void setVirtual_code_money(int virtual_code_money) {
                this.virtual_code_money = virtual_code_money;
            }

            public String getTotal_pay_price() {
                return total_pay_price;
            }

            public void setTotal_pay_price(String total_pay_price) {
                this.total_pay_price = total_pay_price;
            }

            public String getExpress_price() {
                return express_price;
            }

            public void setExpress_price(String express_price) {
                this.express_price = express_price;
            }

            public int getPoints_bonus() {
                return points_bonus;
            }

            public void setPoints_bonus(int points_bonus) {
                this.points_bonus = points_bonus;
            }

            public int getGoods_sales() {
                return goods_sales;
            }

            public void setGoods_sales(int goods_sales) {
                this.goods_sales = goods_sales;
            }

            public boolean isIs_select() {
                return is_select;
            }

            public void setIs_select(boolean is_select) {
                this.is_select = is_select;
            }

            public void setNums(int nums) {
                this.nums = nums;
            }

            public int getNums() {
                return nums;
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
        }
    }
}
