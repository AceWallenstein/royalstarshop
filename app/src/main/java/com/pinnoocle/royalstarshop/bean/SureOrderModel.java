package com.pinnoocle.royalstarshop.bean;

import java.io.Serializable;
import java.util.List;

public class SureOrderModel {


    /**
     * code : 1
     * msg : success
     * data : {"goods_list":[{"goods_id":12931,"goods_name":"电视","selling_point":"","category_id":10581,"spec_type":20,"deduct_stock_type":10,"goods_sort":1,"buy_limit":0,"goods_status":{"text":"上架","value":10},"type":{"value":3,"text":"会员商品"},"freight":"0.00","video_id":0,"points":0,"tag":{"value":1,"text":"精选"},"scan_num":97,"goods_stock":320,"goods_image":"http://gsyp.vtui365.com/uploads/20210305100227b997a3950.jpg","goods_sku":{"goods_sku_id":39258,"goods_id":12931,"spec_sku_id":"12185_12186","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"220.00","line_price":"0.00","stock_num":100,"goods_sales":0,"goods_weight":1000,"goods_attr":"颜色:黄色; 尺寸:22寸; ","image":null},"goods_multi_spec":{"spec_attr":[{"group_id":10403,"group_name":"颜色","spec_items":[{"item_id":12185,"spec_value":"黄色"},{"item_id":12180,"spec_value":"黑色"}]},{"group_id":10404,"group_name":"尺寸","spec_items":[{"item_id":12186,"spec_value":"22寸"},{"item_id":12187,"spec_value":"21寸"}]}],"spec_list":[{"goods_sku_id":39258,"spec_sku_id":"12185_12186","rows":[],"form":{"image_id":0,"image_path":"","goods_no":"","balance_price":"0.00","goods_price":"220.00","goods_weight":1000,"line_price":"0.00","stock_num":100}},{"goods_sku_id":39259,"spec_sku_id":"12185_12187","rows":[],"form":{"image_id":0,"image_path":"","goods_no":"","balance_price":"0.00","goods_price":"222.00","goods_weight":999,"line_price":"0.00","stock_num":99}},{"goods_sku_id":39260,"spec_sku_id":"12180_12186","rows":[],"form":{"image_id":0,"image_path":"","goods_no":"","balance_price":"0.00","goods_price":"218.00","goods_weight":998,"line_price":"0.00","stock_num":67}},{"goods_sku_id":39261,"spec_sku_id":"12180_12187","rows":[],"form":{"image_id":0,"image_path":"","goods_no":"","balance_price":"0.00","goods_price":"214.00","goods_weight":899,"line_price":"0.00","stock_num":54}}]},"goods_price":"220.00","balance_price":"0.00","total_num":"1","total_price":"220.00","total_need_points_num":"0","total_need_points_money":"0.00","total_freight":"0.00","is_user_grade":false,"grade_ratio":0,"grade_goods_price":0,"grade_total_money":0,"points_money":0,"points_num":0,"coupon_money":0,"virtual_code_money":0,"total_pay_price":"220.00","points_bonus":0,"video":null,"goods_sales":0}],"order_total_num":1,"coupon_list":[],"has_error":false,"error_msg":null,"delivery":10,"address":null,"exist_address":false,"express_price":0,"intra_region":true,"extract_shop":[],"is_allow_points":false,"is_use_points":0,"points_money":0,"points_bonus":0,"pay_type":20,"setting":{"delivery":[10,20,30],"points_name":"积分","points_describe":"a) 积分不可兑现、不可转让,仅可在本平台使用;\nb) 您在本平台参加特定活动也可使用积分,详细使用规则以具体活动时的规则为准;\nc) 积分的数值精确到个位(小数点后全部舍弃,不进行四舍五入)\nd) 买家在完成该笔交易(订单状态为\u201c已签收\u201d)后才能得到此笔交易的相应积分,如购买商品参加店铺其他优惠,则优惠的金额部分不享受积分获取;","tplSetting":{"payment":{"is_enable":"0","template_id":"","template_params":""},"delivery":{"is_enable":"0","template_id":"","template_params":""},"refund":{"is_enable":"0","template_id":"","template_params":""}}},"last_extract":{"linkman":"","phone":""},"deliverySetting":[10,20,30],"send_payment_msg":0,"send_delivery_msg":0,"send_refund_msg":0,"feight_price":0,"order_total_price":"220.00","coupon_id":0,"coupon_money":0,"virtual_code":"","virtual_code_money":0,"freight_price":"0.00","order_price":"220.00","order_pay_price":"220.00"}
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
        /**
         * goods_list : [{"goods_id":12931,"goods_name":"电视","selling_point":"","category_id":10581,"spec_type":20,"deduct_stock_type":10,"goods_sort":1,"buy_limit":0,"goods_status":{"text":"上架","value":10},"type":{"value":3,"text":"会员商品"},"freight":"0.00","video_id":0,"points":0,"tag":{"value":1,"text":"精选"},"scan_num":97,"goods_stock":320,"goods_image":"http://gsyp.vtui365.com/uploads/20210305100227b997a3950.jpg","goods_sku":{"goods_sku_id":39258,"goods_id":12931,"spec_sku_id":"12185_12186","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"220.00","line_price":"0.00","stock_num":100,"goods_sales":0,"goods_weight":1000,"goods_attr":"颜色:黄色; 尺寸:22寸; ","image":null},"goods_multi_spec":{"spec_attr":[{"group_id":10403,"group_name":"颜色","spec_items":[{"item_id":12185,"spec_value":"黄色"},{"item_id":12180,"spec_value":"黑色"}]},{"group_id":10404,"group_name":"尺寸","spec_items":[{"item_id":12186,"spec_value":"22寸"},{"item_id":12187,"spec_value":"21寸"}]}],"spec_list":[{"goods_sku_id":39258,"spec_sku_id":"12185_12186","rows":[],"form":{"image_id":0,"image_path":"","goods_no":"","balance_price":"0.00","goods_price":"220.00","goods_weight":1000,"line_price":"0.00","stock_num":100}},{"goods_sku_id":39259,"spec_sku_id":"12185_12187","rows":[],"form":{"image_id":0,"image_path":"","goods_no":"","balance_price":"0.00","goods_price":"222.00","goods_weight":999,"line_price":"0.00","stock_num":99}},{"goods_sku_id":39260,"spec_sku_id":"12180_12186","rows":[],"form":{"image_id":0,"image_path":"","goods_no":"","balance_price":"0.00","goods_price":"218.00","goods_weight":998,"line_price":"0.00","stock_num":67}},{"goods_sku_id":39261,"spec_sku_id":"12180_12187","rows":[],"form":{"image_id":0,"image_path":"","goods_no":"","balance_price":"0.00","goods_price":"214.00","goods_weight":899,"line_price":"0.00","stock_num":54}}]},"goods_price":"220.00","balance_price":"0.00","total_num":"1","total_price":"220.00","total_need_points_num":"0","total_need_points_money":"0.00","total_freight":"0.00","is_user_grade":false,"grade_ratio":0,"grade_goods_price":0,"grade_total_money":0,"points_money":0,"points_num":0,"coupon_money":0,"virtual_code_money":0,"total_pay_price":"220.00","points_bonus":0,"video":null,"goods_sales":0}]
         * order_total_num : 1
         * coupon_list : []
         * has_error : false
         * error_msg : null
         * delivery : 10
         * address : null
         * exist_address : false
         * express_price : 0
         * intra_region : true
         * extract_shop : []
         * is_allow_points : false
         * is_use_points : 0
         * points_money : 0
         * points_bonus : 0
         * pay_type : 20
         * setting : {"delivery":[10,20,30],"points_name":"积分","points_describe":"a) 积分不可兑现、不可转让,仅可在本平台使用;\nb) 您在本平台参加特定活动也可使用积分,详细使用规则以具体活动时的规则为准;\nc) 积分的数值精确到个位(小数点后全部舍弃,不进行四舍五入)\nd) 买家在完成该笔交易(订单状态为\u201c已签收\u201d)后才能得到此笔交易的相应积分,如购买商品参加店铺其他优惠,则优惠的金额部分不享受积分获取;","tplSetting":{"payment":{"is_enable":"0","template_id":"","template_params":""},"delivery":{"is_enable":"0","template_id":"","template_params":""},"refund":{"is_enable":"0","template_id":"","template_params":""}}}
         * last_extract : {"linkman":"","phone":""}
         * deliverySetting : [10,20,30]
         * send_payment_msg : 0
         * send_delivery_msg : 0
         * send_refund_msg : 0
         * feight_price : 0
         * order_total_price : 220.00
         * coupon_id : 0
         * coupon_money : 0
         * virtual_code :
         * virtual_code_money : 0
         * freight_price : 0.00
         * order_price : 220.00
         * order_pay_price : 220.00
         */

        private int order_total_num;
        private boolean has_error;
        private Object error_msg;
        private int delivery;
        private Address address;
        private boolean exist_address;
        private int express_price;
        private boolean intra_region;
        private boolean is_allow_points;
        private int is_use_points;
        private double points_money;
        private int points_num;
        private double order_can_discount_money;

        public double getOrder_can_discount_money() {
            return order_can_discount_money;
        }

        public void setOrder_can_discount_money(double order_can_discount_money) {
            this.order_can_discount_money = order_can_discount_money;
        }

        public int getPoints_num() {
            return points_num;
        }

        public void setPoints_num(int points_num) {
            this.points_num = points_num;
        }

        private int user_points;

        public int getUser_points() {
            return user_points;
        }

        public void setUser_points(int user_points) {
            this.user_points = user_points;
        }

        private int points_bonus;
        private int pay_type;
        private SettingBean setting;
        private LastExtractBean last_extract;
        private int send_payment_msg;
        private int send_delivery_msg;
        private int send_refund_msg;
        private int feight_price;
        private String order_total_price;
        private int coupon_id;
        private int coupon_money;
        private String virtual_code;
        private int virtual_code_money;
        private String freight_price;
        private double freight_points_money;

        public double getFreight_points_money() {
            return freight_points_money;
        }

        public void setFreight_points_money(double freight_points_money) {
            this.freight_points_money = freight_points_money;
        }

        private String order_price;
        private String order_pay_price;
        private List<GoodsListBean> goods_list;
        private List<?> coupon_list;
        private List<?> extract_shop;
        private List<Integer> deliverySetting;

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

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public boolean isExist_address() {
            return exist_address;
        }

        public void setExist_address(boolean exist_address) {
            this.exist_address = exist_address;
        }

        public int getExpress_price() {
            return express_price;
        }

        public void setExpress_price(int express_price) {
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

        public double getPoints_money() {
            return points_money;
        }

        public void setPoints_money(double points_money) {
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

        public SettingBean getSetting() {
            return setting;
        }

        public void setSetting(SettingBean setting) {
            this.setting = setting;
        }

        public LastExtractBean getLast_extract() {
            return last_extract;
        }

        public void setLast_extract(LastExtractBean last_extract) {
            this.last_extract = last_extract;
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

        public int getFeight_price() {
            return feight_price;
        }

        public void setFeight_price(int feight_price) {
            this.feight_price = feight_price;
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

        public List<Integer> getDeliverySetting() {
            return deliverySetting;
        }

        public void setDeliverySetting(List<Integer> deliverySetting) {
            this.deliverySetting = deliverySetting;
        }

        public static class Address implements Serializable{

            /**
             * address_id : 13967
             * name : cccc
             * phone : 16313131245
             * province_id : 1
             * city_id : 2
             * region_id : 3
             * district :
             * detail : ttttt
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

            public static class RegionBean implements  Serializable{
                /**
                 * province : 北京市
                 * city : 北京市
                 * region : 东城区
                 */

                private String province;
                private String city;
                private String region;

                @Override
                public String toString() {
                    return province+city+region;
                }

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

        public static class SettingBean implements Serializable {
            /**
             * delivery : [10,20,30]
             * points_name : 积分
             * points_describe : a) 积分不可兑现、不可转让,仅可在本平台使用;
             b) 您在本平台参加特定活动也可使用积分,详细使用规则以具体活动时的规则为准;
             c) 积分的数值精确到个位(小数点后全部舍弃,不进行四舍五入)
             d) 买家在完成该笔交易(订单状态为“已签收”)后才能得到此笔交易的相应积分,如购买商品参加店铺其他优惠,则优惠的金额部分不享受积分获取;
             * tplSetting : {"payment":{"is_enable":"0","template_id":"","template_params":""},"delivery":{"is_enable":"0","template_id":"","template_params":""},"refund":{"is_enable":"0","template_id":"","template_params":""}}
             */

            private String points_name;
            private String points_describe;
            private TplSettingBean tplSetting;
            private List<Integer> delivery;

            public String getPoints_name() {
                return points_name;
            }

            public void setPoints_name(String points_name) {
                this.points_name = points_name;
            }

            public String getPoints_describe() {
                return points_describe;
            }

            public void setPoints_describe(String points_describe) {
                this.points_describe = points_describe;
            }

            public TplSettingBean getTplSetting() {
                return tplSetting;
            }

            public void setTplSetting(TplSettingBean tplSetting) {
                this.tplSetting = tplSetting;
            }

            public List<Integer> getDelivery() {
                return delivery;
            }

            public void setDelivery(List<Integer> delivery) {
                this.delivery = delivery;
            }

            public static class TplSettingBean implements Serializable {
                /**
                 * payment : {"is_enable":"0","template_id":"","template_params":""}
                 * delivery : {"is_enable":"0","template_id":"","template_params":""}
                 * refund : {"is_enable":"0","template_id":"","template_params":""}
                 */

                private PaymentBean payment;
                private DeliveryBean delivery;
                private RefundBean refund;

                public PaymentBean getPayment() {
                    return payment;
                }

                public void setPayment(PaymentBean payment) {
                    this.payment = payment;
                }

                public DeliveryBean getDelivery() {
                    return delivery;
                }

                public void setDelivery(DeliveryBean delivery) {
                    this.delivery = delivery;
                }

                public RefundBean getRefund() {
                    return refund;
                }

                public void setRefund(RefundBean refund) {
                    this.refund = refund;
                }

                public static class PaymentBean implements Serializable {
                    /**
                     * is_enable : 0
                     * template_id :
                     * template_params :
                     */

                    private String is_enable;
                    private String template_id;
                    private String template_params;

                    public String getIs_enable() {
                        return is_enable;
                    }

                    public void setIs_enable(String is_enable) {
                        this.is_enable = is_enable;
                    }

                    public String getTemplate_id() {
                        return template_id;
                    }

                    public void setTemplate_id(String template_id) {
                        this.template_id = template_id;
                    }

                    public String getTemplate_params() {
                        return template_params;
                    }

                    public void setTemplate_params(String template_params) {
                        this.template_params = template_params;
                    }
                }

                public static class DeliveryBean implements Serializable{
                    /**
                     * is_enable : 0
                     * template_id :
                     * template_params :
                     */

                    private String is_enable;
                    private String template_id;
                    private String template_params;

                    public String getIs_enable() {
                        return is_enable;
                    }

                    public void setIs_enable(String is_enable) {
                        this.is_enable = is_enable;
                    }

                    public String getTemplate_id() {
                        return template_id;
                    }

                    public void setTemplate_id(String template_id) {
                        this.template_id = template_id;
                    }

                    public String getTemplate_params() {
                        return template_params;
                    }

                    public void setTemplate_params(String template_params) {
                        this.template_params = template_params;
                    }
                }

                public static class RefundBean implements Serializable {
                    /**
                     * is_enable : 0
                     * template_id :
                     * template_params :
                     */

                    private String is_enable;
                    private String template_id;
                    private String template_params;

                    public String getIs_enable() {
                        return is_enable;
                    }

                    public void setIs_enable(String is_enable) {
                        this.is_enable = is_enable;
                    }

                    public String getTemplate_id() {
                        return template_id;
                    }

                    public void setTemplate_id(String template_id) {
                        this.template_id = template_id;
                    }

                    public String getTemplate_params() {
                        return template_params;
                    }

                    public void setTemplate_params(String template_params) {
                        this.template_params = template_params;
                    }
                }
            }
        }

        public static class LastExtractBean implements Serializable {
            /**
             * linkman :
             * phone :
             */

            private String linkman;
            private String phone;

            public String getLinkman() {
                return linkman;
            }

            public void setLinkman(String linkman) {
                this.linkman = linkman;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }
        }

        public static class GoodsListBean implements Serializable {
            /**
             * goods_id : 12931
             * goods_name : 电视
             * selling_point :
             * category_id : 10581
             * spec_type : 20
             * deduct_stock_type : 10
             * goods_sort : 1
             * buy_limit : 0
             * goods_status : {"text":"上架","value":10}
             * type : {"value":3,"text":"会员商品"}
             * freight : 0.00
             * video_id : 0
             * points : 0
             * tag : {"value":1,"text":"精选"}
             * scan_num : 97
             * goods_stock : 320
             * goods_image : http://gsyp.vtui365.com/uploads/20210305100227b997a3950.jpg
             * goods_sku : {"goods_sku_id":39258,"goods_id":12931,"spec_sku_id":"12185_12186","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"220.00","line_price":"0.00","stock_num":100,"goods_sales":0,"goods_weight":1000,"goods_attr":"颜色:黄色; 尺寸:22寸; ","image":null}
             * goods_multi_spec : {"spec_attr":[{"group_id":10403,"group_name":"颜色","spec_items":[{"item_id":12185,"spec_value":"黄色"},{"item_id":12180,"spec_value":"黑色"}]},{"group_id":10404,"group_name":"尺寸","spec_items":[{"item_id":12186,"spec_value":"22寸"},{"item_id":12187,"spec_value":"21寸"}]}],"spec_list":[{"goods_sku_id":39258,"spec_sku_id":"12185_12186","rows":[],"form":{"image_id":0,"image_path":"","goods_no":"","balance_price":"0.00","goods_price":"220.00","goods_weight":1000,"line_price":"0.00","stock_num":100}},{"goods_sku_id":39259,"spec_sku_id":"12185_12187","rows":[],"form":{"image_id":0,"image_path":"","goods_no":"","balance_price":"0.00","goods_price":"222.00","goods_weight":999,"line_price":"0.00","stock_num":99}},{"goods_sku_id":39260,"spec_sku_id":"12180_12186","rows":[],"form":{"image_id":0,"image_path":"","goods_no":"","balance_price":"0.00","goods_price":"218.00","goods_weight":998,"line_price":"0.00","stock_num":67}},{"goods_sku_id":39261,"spec_sku_id":"12180_12187","rows":[],"form":{"image_id":0,"image_path":"","goods_no":"","balance_price":"0.00","goods_price":"214.00","goods_weight":899,"line_price":"0.00","stock_num":54}}]}
             * goods_price : 220.00
             * balance_price : 0.00
             * total_num : 1
             * total_price : 220.00
             * total_need_points_num : 0
             * total_need_points_money : 0.00
             * total_freight : 0.00
             * is_user_grade : false
             * grade_ratio : 0
             * grade_goods_price : 0
             * grade_total_money : 0
             * points_money : 0
             * points_num : 0
             * coupon_money : 0
             * virtual_code_money : 0
             * total_pay_price : 220.00
             * points_bonus : 0
             * video : null
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
            private int scan_num;
            private int goods_stock;
            private String goods_image;
            private GoodsSkuBean goods_sku;
            private GoodsMultiSpecBean goods_multi_spec;
            private String goods_price;
            private String balance_price;
            private String total_num;
            private String total_price;
            private String total_need_points_num;
            private String total_need_points_money;
            private String total_freight;
            private boolean is_user_grade;
            private int grade_ratio;
            private int grade_goods_price;
            private int grade_total_money;
            private int points_money;
            private int points_num;
            private int coupon_money;
            private int virtual_code_money;
            private String total_pay_price;
            private int points_bonus;
            private Object video;
            private int goods_sales;

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

            public int getScan_num() {
                return scan_num;
            }

            public void setScan_num(int scan_num) {
                this.scan_num = scan_num;
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

            public String getGoods_price() {
                return goods_price;
            }

            public void setGoods_price(String goods_price) {
                this.goods_price = goods_price;
            }

            public String getBalance_price() {
                return balance_price;
            }

            public void setBalance_price(String balance_price) {
                this.balance_price = balance_price;
            }

            public String getTotal_num() {
                return total_num;
            }

            public void setTotal_num(String total_num) {
                this.total_num = total_num;
            }

            public String getTotal_price() {
                return total_price;
            }

            public void setTotal_price(String total_price) {
                this.total_price = total_price;
            }

            public String getTotal_need_points_num() {
                return total_need_points_num;
            }

            public void setTotal_need_points_num(String total_need_points_num) {
                this.total_need_points_num = total_need_points_num;
            }

            public String getTotal_need_points_money() {
                return total_need_points_money;
            }

            public void setTotal_need_points_money(String total_need_points_money) {
                this.total_need_points_money = total_need_points_money;
            }

            public String getTotal_freight() {
                return total_freight;
            }

            public void setTotal_freight(String total_freight) {
                this.total_freight = total_freight;
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

            public int getPoints_bonus() {
                return points_bonus;
            }

            public void setPoints_bonus(int points_bonus) {
                this.points_bonus = points_bonus;
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

            public static class GoodsStatusBean  implements Serializable{
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

            public static class TypeBean implements Serializable{
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

            public static class TagBean  implements Serializable{
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
                 * goods_sku_id : 39258
                 * goods_id : 12931
                 * spec_sku_id : 12185_12186
                 * image_id : 0
                 * goods_no :
                 * balance_price : 0.00
                 * goods_price : 220.00
                 * line_price : 0.00
                 * stock_num : 100
                 * goods_sales : 0
                 * goods_weight : 1000
                 * goods_attr : 颜色:黄色; 尺寸:22寸;
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

            public static class GoodsMultiSpecBean implements Serializable {
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

                public static class SpecAttrBean  implements Serializable{
                    /**
                     * group_id : 10403
                     * group_name : 颜色
                     * spec_items : [{"item_id":12185,"spec_value":"黄色"},{"item_id":12180,"spec_value":"黑色"}]
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

                    public static class SpecItemsBean implements Serializable{
                        /**
                         * item_id : 12185
                         * spec_value : 黄色
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

                public static class SpecListBean implements Serializable{
                    /**
                     * goods_sku_id : 39258
                     * spec_sku_id : 12185_12186
                     * rows : []
                     * form : {"image_id":0,"image_path":"","goods_no":"","balance_price":"0.00","goods_price":"220.00","goods_weight":1000,"line_price":"0.00","stock_num":100}
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

                    public static class FormBean implements Serializable{
                        /**
                         * image_id : 0
                         * image_path :
                         * goods_no :
                         * balance_price : 0.00
                         * goods_price : 220.00
                         * goods_weight : 1000
                         * line_price : 0.00
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
