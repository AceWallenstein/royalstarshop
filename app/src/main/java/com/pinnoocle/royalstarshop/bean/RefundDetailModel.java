package com.pinnoocle.royalstarshop.bean;

import java.util.List;

public class RefundDetailModel {

    /**
     * code : 1
     * msg : success
     * data : {"detail":{"order_refund_id":10018,"order_id":26394,"order_goods_id":31673,"user_id":19533,"type":{"text":"换货","value":20},"apply_desc":"不要了","is_agree":{"text":"待审核","value":0},"refuse_desc":"","remark":"","refund_money":"0.00","is_user_send":0,"send_time":0,"express_id":"","express_no":"","is_receipt":0,"status":{"text":"进行中","value":0},"create_time":"2021-03-17 13:58:25","order_master":{"order_id":26394,"order_no":"2021031610162697544856","total_price":"0.00","order_price":"0.00","coupon_id":0,"coupon_money":"0.00","points_money":"0.00","points_num":0,"virtual_code":"","virtual_code_money":"0.00","points_exchange_num":0,"pay_price":"0.00","update_price":{"symbol":"+","value":"0.00"},"buyer_remark":"","seller_remark":"","pay_type":{"text":"余额支付","value":10},"pay_status":{"text":"已付款","value":20},"pay_time":1615860986,"delivery_type":{"text":"快递配送","value":10},"extract_shop_id":0,"extract_clerk_id":0,"express_price":"0.00","express_id":0,"express_company":"","express_no":"","delivery_status":{"text":"待发货","value":10},"delivery_time":0,"receipt_status":{"text":"待收货","value":10},"receipt_time":0,"order_status":{"text":"进行中","value":10},"cancel_time":0,"points_bonus":0,"is_settled":0,"transaction_id":"","is_comment":0,"order_source":10,"order_source_id":0,"source_id":0,"user_id":19533,"push_zto":0,"is_delete":0,"create_time":"2021-03-16 10:16:26","state_text":"待发货"},"image":[],"order_goods":{"order_goods_id":31673,"goods_id":12927,"goods_name":"海尔（Haier）2匹/3匹自清洁变频空调柜机 家用冷暖立式空调 客厅圆柱立柜式空调 帝樽EDS系列 KFR-50LW/07EDS83/2匹","image_id":26087,"deduct_stock_type":10,"spec_type":10,"spec_sku_id":"0","goods_sku_id":39246,"goods_attr":"","goods_no":"","goods_price":"4099.00","line_price":"6299.00","goods_weight":100,"is_user_grade":0,"grade_ratio":0,"grade_goods_price":"0.00","grade_total_money":"0.00","coupon_money":"0.00","points_money":"0.00","points_num":0,"points_bonus":0,"virtual_code_money":"0.00","exchange_points_num":0,"exchange_points_money":"0.00","total_num":1,"total_price":"0.00","total_pay_price":"0.00","is_ind_dealer":0,"dealer_money_type":10,"first_money":"0.00","second_money":"0.00","third_money":"0.00","is_comment":0,"order_id":26394,"user_id":19533,"image":{"file_id":26087,"storage":"local","group_id":0,"file_url":"","file_name":"20210304144650c92fa5848.jpg","file_size":202536,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"wxapp_id":10001,"create_time":"2021-03-04 14:46:50","file_path":"http://gsyp.vtui365.com/uploads/20210304144650c92fa5848.jpg"}},"express":null,"address":null,"state_text":"等待审核中"},"expressList":[{"express_id":10057,"express_name":"顺丰速运"}]}
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
         * detail : {"order_refund_id":10018,"order_id":26394,"order_goods_id":31673,"user_id":19533,"type":{"text":"换货","value":20},"apply_desc":"不要了","is_agree":{"text":"待审核","value":0},"refuse_desc":"","remark":"","refund_money":"0.00","is_user_send":0,"send_time":0,"express_id":"","express_no":"","is_receipt":0,"status":{"text":"进行中","value":0},"create_time":"2021-03-17 13:58:25","order_master":{"order_id":26394,"order_no":"2021031610162697544856","total_price":"0.00","order_price":"0.00","coupon_id":0,"coupon_money":"0.00","points_money":"0.00","points_num":0,"virtual_code":"","virtual_code_money":"0.00","points_exchange_num":0,"pay_price":"0.00","update_price":{"symbol":"+","value":"0.00"},"buyer_remark":"","seller_remark":"","pay_type":{"text":"余额支付","value":10},"pay_status":{"text":"已付款","value":20},"pay_time":1615860986,"delivery_type":{"text":"快递配送","value":10},"extract_shop_id":0,"extract_clerk_id":0,"express_price":"0.00","express_id":0,"express_company":"","express_no":"","delivery_status":{"text":"待发货","value":10},"delivery_time":0,"receipt_status":{"text":"待收货","value":10},"receipt_time":0,"order_status":{"text":"进行中","value":10},"cancel_time":0,"points_bonus":0,"is_settled":0,"transaction_id":"","is_comment":0,"order_source":10,"order_source_id":0,"source_id":0,"user_id":19533,"push_zto":0,"is_delete":0,"create_time":"2021-03-16 10:16:26","state_text":"待发货"},"image":[],"order_goods":{"order_goods_id":31673,"goods_id":12927,"goods_name":"海尔（Haier）2匹/3匹自清洁变频空调柜机 家用冷暖立式空调 客厅圆柱立柜式空调 帝樽EDS系列 KFR-50LW/07EDS83/2匹","image_id":26087,"deduct_stock_type":10,"spec_type":10,"spec_sku_id":"0","goods_sku_id":39246,"goods_attr":"","goods_no":"","goods_price":"4099.00","line_price":"6299.00","goods_weight":100,"is_user_grade":0,"grade_ratio":0,"grade_goods_price":"0.00","grade_total_money":"0.00","coupon_money":"0.00","points_money":"0.00","points_num":0,"points_bonus":0,"virtual_code_money":"0.00","exchange_points_num":0,"exchange_points_money":"0.00","total_num":1,"total_price":"0.00","total_pay_price":"0.00","is_ind_dealer":0,"dealer_money_type":10,"first_money":"0.00","second_money":"0.00","third_money":"0.00","is_comment":0,"order_id":26394,"user_id":19533,"image":{"file_id":26087,"storage":"local","group_id":0,"file_url":"","file_name":"20210304144650c92fa5848.jpg","file_size":202536,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"wxapp_id":10001,"create_time":"2021-03-04 14:46:50","file_path":"http://gsyp.vtui365.com/uploads/20210304144650c92fa5848.jpg"}},"express":null,"address":null,"state_text":"等待审核中"}
         * expressList : [{"express_id":10057,"express_name":"顺丰速运"}]
         */

        private DetailBean detail;
        private List<ExpressListBean> expressList;

        public DetailBean getDetail() {
            return detail;
        }

        public void setDetail(DetailBean detail) {
            this.detail = detail;
        }

        public List<ExpressListBean> getExpressList() {
            return expressList;
        }

        public void setExpressList(List<ExpressListBean> expressList) {
            this.expressList = expressList;
        }

        public static class DetailBean {
            /**
             * order_refund_id : 10018
             * order_id : 26394
             * order_goods_id : 31673
             * user_id : 19533
             * type : {"text":"换货","value":20}
             * apply_desc : 不要了
             * is_agree : {"text":"待审核","value":0}
             * refuse_desc :
             * remark :
             * refund_money : 0.00
             * is_user_send : 0
             * send_time : 0
             * express_id :
             * express_no :
             * is_receipt : 0
             * status : {"text":"进行中","value":0}
             * create_time : 2021-03-17 13:58:25
             * order_master : {"order_id":26394,"order_no":"2021031610162697544856","total_price":"0.00","order_price":"0.00","coupon_id":0,"coupon_money":"0.00","points_money":"0.00","points_num":0,"virtual_code":"","virtual_code_money":"0.00","points_exchange_num":0,"pay_price":"0.00","update_price":{"symbol":"+","value":"0.00"},"buyer_remark":"","seller_remark":"","pay_type":{"text":"余额支付","value":10},"pay_status":{"text":"已付款","value":20},"pay_time":1615860986,"delivery_type":{"text":"快递配送","value":10},"extract_shop_id":0,"extract_clerk_id":0,"express_price":"0.00","express_id":0,"express_company":"","express_no":"","delivery_status":{"text":"待发货","value":10},"delivery_time":0,"receipt_status":{"text":"待收货","value":10},"receipt_time":0,"order_status":{"text":"进行中","value":10},"cancel_time":0,"points_bonus":0,"is_settled":0,"transaction_id":"","is_comment":0,"order_source":10,"order_source_id":0,"source_id":0,"user_id":19533,"push_zto":0,"is_delete":0,"create_time":"2021-03-16 10:16:26","state_text":"待发货"}
             * image : []
             * order_goods : {"order_goods_id":31673,"goods_id":12927,"goods_name":"海尔（Haier）2匹/3匹自清洁变频空调柜机 家用冷暖立式空调 客厅圆柱立柜式空调 帝樽EDS系列 KFR-50LW/07EDS83/2匹","image_id":26087,"deduct_stock_type":10,"spec_type":10,"spec_sku_id":"0","goods_sku_id":39246,"goods_attr":"","goods_no":"","goods_price":"4099.00","line_price":"6299.00","goods_weight":100,"is_user_grade":0,"grade_ratio":0,"grade_goods_price":"0.00","grade_total_money":"0.00","coupon_money":"0.00","points_money":"0.00","points_num":0,"points_bonus":0,"virtual_code_money":"0.00","exchange_points_num":0,"exchange_points_money":"0.00","total_num":1,"total_price":"0.00","total_pay_price":"0.00","is_ind_dealer":0,"dealer_money_type":10,"first_money":"0.00","second_money":"0.00","third_money":"0.00","is_comment":0,"order_id":26394,"user_id":19533,"image":{"file_id":26087,"storage":"local","group_id":0,"file_url":"","file_name":"20210304144650c92fa5848.jpg","file_size":202536,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"wxapp_id":10001,"create_time":"2021-03-04 14:46:50","file_path":"http://gsyp.vtui365.com/uploads/20210304144650c92fa5848.jpg"}}
             * express : null
             * address : null
             * state_text : 等待审核中
             * total_freight
             */

            private String total_freight;

            public String getTotal_freight() {
                return total_freight;
            }

            public void setTotal_freight(String total_freight) {
                this.total_freight = total_freight;
            }

            private int order_refund_id;
            private int order_id;
            private int order_goods_id;
            private int user_id;
            private TypeBean type;
            private String apply_desc;
            private IsAgreeBean is_agree;
            private String refuse_desc;
            private String remark;
            private String refund_money;
            private int is_user_send;
            private int send_time;
            private String express_id;
            private String express_no;
            private int is_receipt;
            private StatusBean status;
            private String create_time;
            private OrderMasterBean order_master;
            private OrderGoodsBean order_goods;
            private Object express;
            private OrderDetailModel.DataBean.OrderBean.AddressBean address;
            private String state_text;
            private List<?> image;

            public int getOrder_refund_id() {
                return order_refund_id;
            }

            public void setOrder_refund_id(int order_refund_id) {
                this.order_refund_id = order_refund_id;
            }

            public int getOrder_id() {
                return order_id;
            }

            public void setOrder_id(int order_id) {
                this.order_id = order_id;
            }

            public int getOrder_goods_id() {
                return order_goods_id;
            }

            public void setOrder_goods_id(int order_goods_id) {
                this.order_goods_id = order_goods_id;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public TypeBean getType() {
                return type;
            }

            public void setType(TypeBean type) {
                this.type = type;
            }

            public String getApply_desc() {
                return apply_desc;
            }

            public void setApply_desc(String apply_desc) {
                this.apply_desc = apply_desc;
            }

            public IsAgreeBean getIs_agree() {
                return is_agree;
            }

            public void setIs_agree(IsAgreeBean is_agree) {
                this.is_agree = is_agree;
            }

            public String getRefuse_desc() {
                return refuse_desc;
            }

            public void setRefuse_desc(String refuse_desc) {
                this.refuse_desc = refuse_desc;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getRefund_money() {
                return refund_money;
            }

            public void setRefund_money(String refund_money) {
                this.refund_money = refund_money;
            }

            public int getIs_user_send() {
                return is_user_send;
            }

            public void setIs_user_send(int is_user_send) {
                this.is_user_send = is_user_send;
            }

            public int getSend_time() {
                return send_time;
            }

            public void setSend_time(int send_time) {
                this.send_time = send_time;
            }

            public String getExpress_id() {
                return express_id;
            }

            public void setExpress_id(String express_id) {
                this.express_id = express_id;
            }

            public String getExpress_no() {
                return express_no;
            }

            public void setExpress_no(String express_no) {
                this.express_no = express_no;
            }

            public int getIs_receipt() {
                return is_receipt;
            }

            public void setIs_receipt(int is_receipt) {
                this.is_receipt = is_receipt;
            }

            public StatusBean getStatus() {
                return status;
            }

            public void setStatus(StatusBean status) {
                this.status = status;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public OrderMasterBean getOrder_master() {
                return order_master;
            }

            public void setOrder_master(OrderMasterBean order_master) {
                this.order_master = order_master;
            }

            public OrderGoodsBean getOrder_goods() {
                return order_goods;
            }

            public void setOrder_goods(OrderGoodsBean order_goods) {
                this.order_goods = order_goods;
            }

            public Object getExpress() {
                return express;
            }

            public void setExpress(Object express) {
                this.express = express;
            }

            public OrderDetailModel.DataBean.OrderBean.AddressBean getAddress() {
                return address;
            }

            public void setAddress(OrderDetailModel.DataBean.OrderBean.AddressBean address) {
                this.address = address;
            }

            public String getState_text() {
                return state_text;
            }

            public void setState_text(String state_text) {
                this.state_text = state_text;
            }

            public List<?> getImage() {
                return image;
            }

            public void setImage(List<?> image) {
                this.image = image;
            }

            public static class TypeBean {
                /**
                 * text : 换货
                 * value : 20
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

            public static class IsAgreeBean {
                /**
                 * text : 待审核
                 * value : 0
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

            public static class StatusBean {
                /**
                 * text : 进行中
                 * value : 0
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

            public static class OrderMasterBean {
                /**
                 * order_id : 26394
                 * order_no : 2021031610162697544856
                 * total_price : 0.00
                 * order_price : 0.00
                 * coupon_id : 0
                 * coupon_money : 0.00
                 * points_money : 0.00
                 * points_num : 0
                 * virtual_code :
                 * virtual_code_money : 0.00
                 * points_exchange_num : 0
                 * pay_price : 0.00
                 * update_price : {"symbol":"+","value":"0.00"}
                 * buyer_remark :
                 * seller_remark :
                 * pay_type : {"text":"余额支付","value":10}
                 * pay_status : {"text":"已付款","value":20}
                 * pay_time : 1615860986
                 * delivery_type : {"text":"快递配送","value":10}
                 * extract_shop_id : 0
                 * extract_clerk_id : 0
                 * express_price : 0.00
                 * express_id : 0
                 * express_company :
                 * express_no :
                 * delivery_status : {"text":"待发货","value":10}
                 * delivery_time : 0
                 * receipt_status : {"text":"待收货","value":10}
                 * receipt_time : 0
                 * order_status : {"text":"进行中","value":10}
                 * cancel_time : 0
                 * points_bonus : 0
                 * is_settled : 0
                 * transaction_id :
                 * is_comment : 0
                 * order_source : 10
                 * order_source_id : 0
                 * source_id : 0
                 * user_id : 19533
                 * push_zto : 0
                 * is_delete : 0
                 * create_time : 2021-03-16 10:16:26
                 * state_text : 待发货
                 */
                private int is_vip_order;

                public int getIs_vip_order() {
                    return is_vip_order;
                }

                public void setIs_vip_order(int is_vip_order) {
                    this.is_vip_order = is_vip_order;
                }

                private int order_id;
                private String order_no;
                private String total_price;
                private String order_price;
                private int coupon_id;
                private String coupon_money;
                private String points_money;
                private int points_num;
                private String virtual_code;
                private String virtual_code_money;
                private int points_exchange_num;
                private String pay_price;
                private UpdatePriceBean update_price;
                private String buyer_remark;
                private String seller_remark;
                private PayTypeBean pay_type;
                private PayStatusBean pay_status;
                private int pay_time;
                private DeliveryTypeBean delivery_type;
                private int extract_shop_id;
                private int extract_clerk_id;
                private String express_price;
                private int express_id;
                private String express_company;
                private String express_no;
                private DeliveryStatusBean delivery_status;
                private int delivery_time;
                private ReceiptStatusBean receipt_status;
                private int receipt_time;
                private OrderStatusBean order_status;
                private int cancel_time;
                private int points_bonus;
                private int is_settled;
                private String transaction_id;
                private int is_comment;
                private int order_source;
                private int order_source_id;
                private int source_id;
                private int user_id;
                private int push_zto;
                private int is_delete;
                private String create_time;
                private String state_text;

                public int getOrder_id() {
                    return order_id;
                }

                public void setOrder_id(int order_id) {
                    this.order_id = order_id;
                }

                public String getOrder_no() {
                    return order_no;
                }

                public void setOrder_no(String order_no) {
                    this.order_no = order_no;
                }

                public String getTotal_price() {
                    return total_price;
                }

                public void setTotal_price(String total_price) {
                    this.total_price = total_price;
                }

                public String getOrder_price() {
                    return order_price;
                }

                public void setOrder_price(String order_price) {
                    this.order_price = order_price;
                }

                public int getCoupon_id() {
                    return coupon_id;
                }

                public void setCoupon_id(int coupon_id) {
                    this.coupon_id = coupon_id;
                }

                public String getCoupon_money() {
                    return coupon_money;
                }

                public void setCoupon_money(String coupon_money) {
                    this.coupon_money = coupon_money;
                }

                public String getPoints_money() {
                    return points_money;
                }

                public void setPoints_money(String points_money) {
                    this.points_money = points_money;
                }

                public int getPoints_num() {
                    return points_num;
                }

                public void setPoints_num(int points_num) {
                    this.points_num = points_num;
                }

                public String getVirtual_code() {
                    return virtual_code;
                }

                public void setVirtual_code(String virtual_code) {
                    this.virtual_code = virtual_code;
                }

                public String getVirtual_code_money() {
                    return virtual_code_money;
                }

                public void setVirtual_code_money(String virtual_code_money) {
                    this.virtual_code_money = virtual_code_money;
                }

                public int getPoints_exchange_num() {
                    return points_exchange_num;
                }

                public void setPoints_exchange_num(int points_exchange_num) {
                    this.points_exchange_num = points_exchange_num;
                }

                public String getPay_price() {
                    return pay_price;
                }

                public void setPay_price(String pay_price) {
                    this.pay_price = pay_price;
                }

                public UpdatePriceBean getUpdate_price() {
                    return update_price;
                }

                public void setUpdate_price(UpdatePriceBean update_price) {
                    this.update_price = update_price;
                }

                public String getBuyer_remark() {
                    return buyer_remark;
                }

                public void setBuyer_remark(String buyer_remark) {
                    this.buyer_remark = buyer_remark;
                }

                public String getSeller_remark() {
                    return seller_remark;
                }

                public void setSeller_remark(String seller_remark) {
                    this.seller_remark = seller_remark;
                }

                public PayTypeBean getPay_type() {
                    return pay_type;
                }

                public void setPay_type(PayTypeBean pay_type) {
                    this.pay_type = pay_type;
                }

                public PayStatusBean getPay_status() {
                    return pay_status;
                }

                public void setPay_status(PayStatusBean pay_status) {
                    this.pay_status = pay_status;
                }

                public int getPay_time() {
                    return pay_time;
                }

                public void setPay_time(int pay_time) {
                    this.pay_time = pay_time;
                }

                public DeliveryTypeBean getDelivery_type() {
                    return delivery_type;
                }

                public void setDelivery_type(DeliveryTypeBean delivery_type) {
                    this.delivery_type = delivery_type;
                }

                public int getExtract_shop_id() {
                    return extract_shop_id;
                }

                public void setExtract_shop_id(int extract_shop_id) {
                    this.extract_shop_id = extract_shop_id;
                }

                public int getExtract_clerk_id() {
                    return extract_clerk_id;
                }

                public void setExtract_clerk_id(int extract_clerk_id) {
                    this.extract_clerk_id = extract_clerk_id;
                }

                public String getExpress_price() {
                    return express_price;
                }

                public void setExpress_price(String express_price) {
                    this.express_price = express_price;
                }

                public int getExpress_id() {
                    return express_id;
                }

                public void setExpress_id(int express_id) {
                    this.express_id = express_id;
                }

                public String getExpress_company() {
                    return express_company;
                }

                public void setExpress_company(String express_company) {
                    this.express_company = express_company;
                }

                public String getExpress_no() {
                    return express_no;
                }

                public void setExpress_no(String express_no) {
                    this.express_no = express_no;
                }

                public DeliveryStatusBean getDelivery_status() {
                    return delivery_status;
                }

                public void setDelivery_status(DeliveryStatusBean delivery_status) {
                    this.delivery_status = delivery_status;
                }

                public int getDelivery_time() {
                    return delivery_time;
                }

                public void setDelivery_time(int delivery_time) {
                    this.delivery_time = delivery_time;
                }

                public ReceiptStatusBean getReceipt_status() {
                    return receipt_status;
                }

                public void setReceipt_status(ReceiptStatusBean receipt_status) {
                    this.receipt_status = receipt_status;
                }

                public int getReceipt_time() {
                    return receipt_time;
                }

                public void setReceipt_time(int receipt_time) {
                    this.receipt_time = receipt_time;
                }

                public OrderStatusBean getOrder_status() {
                    return order_status;
                }

                public void setOrder_status(OrderStatusBean order_status) {
                    this.order_status = order_status;
                }

                public int getCancel_time() {
                    return cancel_time;
                }

                public void setCancel_time(int cancel_time) {
                    this.cancel_time = cancel_time;
                }

                public int getPoints_bonus() {
                    return points_bonus;
                }

                public void setPoints_bonus(int points_bonus) {
                    this.points_bonus = points_bonus;
                }

                public int getIs_settled() {
                    return is_settled;
                }

                public void setIs_settled(int is_settled) {
                    this.is_settled = is_settled;
                }

                public String getTransaction_id() {
                    return transaction_id;
                }

                public void setTransaction_id(String transaction_id) {
                    this.transaction_id = transaction_id;
                }

                public int getIs_comment() {
                    return is_comment;
                }

                public void setIs_comment(int is_comment) {
                    this.is_comment = is_comment;
                }

                public int getOrder_source() {
                    return order_source;
                }

                public void setOrder_source(int order_source) {
                    this.order_source = order_source;
                }

                public int getOrder_source_id() {
                    return order_source_id;
                }

                public void setOrder_source_id(int order_source_id) {
                    this.order_source_id = order_source_id;
                }

                public int getSource_id() {
                    return source_id;
                }

                public void setSource_id(int source_id) {
                    this.source_id = source_id;
                }

                public int getUser_id() {
                    return user_id;
                }

                public void setUser_id(int user_id) {
                    this.user_id = user_id;
                }

                public int getPush_zto() {
                    return push_zto;
                }

                public void setPush_zto(int push_zto) {
                    this.push_zto = push_zto;
                }

                public int getIs_delete() {
                    return is_delete;
                }

                public void setIs_delete(int is_delete) {
                    this.is_delete = is_delete;
                }

                public String getCreate_time() {
                    return create_time;
                }

                public void setCreate_time(String create_time) {
                    this.create_time = create_time;
                }

                public String getState_text() {
                    return state_text;
                }

                public void setState_text(String state_text) {
                    this.state_text = state_text;
                }

                public static class UpdatePriceBean {
                    /**
                     * symbol : +
                     * value : 0.00
                     */

                    private String symbol;
                    private String value;

                    public String getSymbol() {
                        return symbol;
                    }

                    public void setSymbol(String symbol) {
                        this.symbol = symbol;
                    }

                    public String getValue() {
                        return value;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }
                }

                public static class PayTypeBean {
                    /**
                     * text : 余额支付
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

                public static class PayStatusBean {
                    /**
                     * text : 已付款
                     * value : 20
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

                public static class DeliveryTypeBean {
                    /**
                     * text : 快递配送
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

                public static class DeliveryStatusBean {
                    /**
                     * text : 待发货
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

                public static class ReceiptStatusBean {
                    /**
                     * text : 待收货
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

                public static class OrderStatusBean {
                    /**
                     * text : 进行中
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
            }

            public static class OrderGoodsBean {
                public String getTotal_freight() {
                    return total_freight;
                }

                public void setTotal_freight(String total_freight) {
                    this.total_freight = total_freight;
                }

                /**
                 * order_goods_id : 31673
                 * goods_id : 12927
                 * goods_name : 海尔（Haier）2匹/3匹自清洁变频空调柜机 家用冷暖立式空调 客厅圆柱立柜式空调 帝樽EDS系列 KFR-50LW/07EDS83/2匹
                 * image_id : 26087
                 * deduct_stock_type : 10
                 * spec_type : 10
                 * spec_sku_id : 0
                 * goods_sku_id : 39246
                 * goods_attr :
                 * goods_no :
                 * goods_price : 4099.00
                 * line_price : 6299.00
                 * goods_weight : 100
                 * is_user_grade : 0
                 * grade_ratio : 0
                 * grade_goods_price : 0.00
                 * grade_total_money : 0.00
                 * coupon_money : 0.00
                 * points_money : 0.00
                 * points_num : 0
                 * points_bonus : 0
                 * virtual_code_money : 0.00
                 * exchange_points_num : 0
                 * exchange_points_money : 0.00
                 * total_num : 1
                 * total_price : 0.00
                 * total_pay_price : 0.00
                 * is_ind_dealer : 0
                 * dealer_money_type : 10
                 * first_money : 0.00
                 * second_money : 0.00
                 * third_money : 0.00
                 * is_comment : 0
                 * order_id : 26394
                 * user_id : 19533
                 * image : {"file_id":26087,"storage":"local","group_id":0,"file_url":"","file_name":"20210304144650c92fa5848.jpg","file_size":202536,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"wxapp_id":10001,"create_time":"2021-03-04 14:46:50","file_path":"http://gsyp.vtui365.com/uploads/20210304144650c92fa5848.jpg"}
                 */


                private String total_freight;
                private int order_goods_id;
                private int goods_id;
                private String goods_name;
                private int image_id;
                private int deduct_stock_type;
                private int spec_type;
                private String spec_sku_id;
                private int goods_sku_id;
                private String goods_attr;
                private String goods_no;
                private String goods_price;
                private String line_price;
                private int goods_weight;
                private int is_user_grade;
                private int grade_ratio;
                private String grade_goods_price;
                private String grade_total_money;
                private String coupon_money;
                private String points_money;
                private int points_num;
                private int points_bonus;
                private String virtual_code_money;
                private int exchange_points_num;
                private String exchange_points_money;
                private int total_num;
                private String total_price;
                private String total_pay_price;
                private int is_ind_dealer;
                private int dealer_money_type;
                private String first_money;
                private String second_money;
                private String third_money;
                private int is_comment;
                private int order_id;
                private int user_id;
                private ImageBean image;

                public int getOrder_goods_id() {
                    return order_goods_id;
                }

                public void setOrder_goods_id(int order_goods_id) {
                    this.order_goods_id = order_goods_id;
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

                public int getImage_id() {
                    return image_id;
                }

                public void setImage_id(int image_id) {
                    this.image_id = image_id;
                }

                public int getDeduct_stock_type() {
                    return deduct_stock_type;
                }

                public void setDeduct_stock_type(int deduct_stock_type) {
                    this.deduct_stock_type = deduct_stock_type;
                }

                public int getSpec_type() {
                    return spec_type;
                }

                public void setSpec_type(int spec_type) {
                    this.spec_type = spec_type;
                }

                public String getSpec_sku_id() {
                    return spec_sku_id;
                }

                public void setSpec_sku_id(String spec_sku_id) {
                    this.spec_sku_id = spec_sku_id;
                }

                public int getGoods_sku_id() {
                    return goods_sku_id;
                }

                public void setGoods_sku_id(int goods_sku_id) {
                    this.goods_sku_id = goods_sku_id;
                }

                public String getGoods_attr() {
                    return goods_attr;
                }

                public void setGoods_attr(String goods_attr) {
                    this.goods_attr = goods_attr;
                }

                public String getGoods_no() {
                    return goods_no;
                }

                public void setGoods_no(String goods_no) {
                    this.goods_no = goods_no;
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

                public int getGoods_weight() {
                    return goods_weight;
                }

                public void setGoods_weight(int goods_weight) {
                    this.goods_weight = goods_weight;
                }

                public int getIs_user_grade() {
                    return is_user_grade;
                }

                public void setIs_user_grade(int is_user_grade) {
                    this.is_user_grade = is_user_grade;
                }

                public int getGrade_ratio() {
                    return grade_ratio;
                }

                public void setGrade_ratio(int grade_ratio) {
                    this.grade_ratio = grade_ratio;
                }

                public String getGrade_goods_price() {
                    return grade_goods_price;
                }

                public void setGrade_goods_price(String grade_goods_price) {
                    this.grade_goods_price = grade_goods_price;
                }

                public String getGrade_total_money() {
                    return grade_total_money;
                }

                public void setGrade_total_money(String grade_total_money) {
                    this.grade_total_money = grade_total_money;
                }

                public String getCoupon_money() {
                    return coupon_money;
                }

                public void setCoupon_money(String coupon_money) {
                    this.coupon_money = coupon_money;
                }

                public String getPoints_money() {
                    return points_money;
                }

                public void setPoints_money(String points_money) {
                    this.points_money = points_money;
                }

                public int getPoints_num() {
                    return points_num;
                }

                public void setPoints_num(int points_num) {
                    this.points_num = points_num;
                }

                public int getPoints_bonus() {
                    return points_bonus;
                }

                public void setPoints_bonus(int points_bonus) {
                    this.points_bonus = points_bonus;
                }

                public String getVirtual_code_money() {
                    return virtual_code_money;
                }

                public void setVirtual_code_money(String virtual_code_money) {
                    this.virtual_code_money = virtual_code_money;
                }

                public int getExchange_points_num() {
                    return exchange_points_num;
                }

                public void setExchange_points_num(int exchange_points_num) {
                    this.exchange_points_num = exchange_points_num;
                }

                public String getExchange_points_money() {
                    return exchange_points_money;
                }

                public void setExchange_points_money(String exchange_points_money) {
                    this.exchange_points_money = exchange_points_money;
                }

                public int getTotal_num() {
                    return total_num;
                }

                public void setTotal_num(int total_num) {
                    this.total_num = total_num;
                }

                public String getTotal_price() {
                    return total_price;
                }

                public void setTotal_price(String total_price) {
                    this.total_price = total_price;
                }

                public String getTotal_pay_price() {
                    return total_pay_price;
                }

                public void setTotal_pay_price(String total_pay_price) {
                    this.total_pay_price = total_pay_price;
                }

                public int getIs_ind_dealer() {
                    return is_ind_dealer;
                }

                public void setIs_ind_dealer(int is_ind_dealer) {
                    this.is_ind_dealer = is_ind_dealer;
                }

                public int getDealer_money_type() {
                    return dealer_money_type;
                }

                public void setDealer_money_type(int dealer_money_type) {
                    this.dealer_money_type = dealer_money_type;
                }

                public String getFirst_money() {
                    return first_money;
                }

                public void setFirst_money(String first_money) {
                    this.first_money = first_money;
                }

                public String getSecond_money() {
                    return second_money;
                }

                public void setSecond_money(String second_money) {
                    this.second_money = second_money;
                }

                public String getThird_money() {
                    return third_money;
                }

                public void setThird_money(String third_money) {
                    this.third_money = third_money;
                }

                public int getIs_comment() {
                    return is_comment;
                }

                public void setIs_comment(int is_comment) {
                    this.is_comment = is_comment;
                }

                public int getOrder_id() {
                    return order_id;
                }

                public void setOrder_id(int order_id) {
                    this.order_id = order_id;
                }

                public int getUser_id() {
                    return user_id;
                }

                public void setUser_id(int user_id) {
                    this.user_id = user_id;
                }

                public ImageBean getImage() {
                    return image;
                }

                public void setImage(ImageBean image) {
                    this.image = image;
                }

                public static class ImageBean {
                    /**
                     * file_id : 26087
                     * storage : local
                     * group_id : 0
                     * file_url :
                     * file_name : 20210304144650c92fa5848.jpg
                     * file_size : 202536
                     * file_type : image
                     * extension : jpg
                     * is_user : 0
                     * is_recycle : 0
                     * is_delete : 0
                     * wxapp_id : 10001
                     * create_time : 2021-03-04 14:46:50
                     * file_path : http://gsyp.vtui365.com/uploads/20210304144650c92fa5848.jpg
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
                    private int wxapp_id;
                    private String create_time;
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

                    public String getFile_path() {
                        return file_path;
                    }

                    public void setFile_path(String file_path) {
                        this.file_path = file_path;
                    }
                }
            }
        }

        public static class ExpressListBean {
            /**
             * express_id : 10057
             * express_name : 顺丰速运
             */

            private int express_id;
            private String express_name;

            public int getExpress_id() {
                return express_id;
            }

            public void setExpress_id(int express_id) {
                this.express_id = express_id;
            }

            public String getExpress_name() {
                return express_name;
            }

            public void setExpress_name(String express_name) {
                this.express_name = express_name;
            }
        }
    }
}
