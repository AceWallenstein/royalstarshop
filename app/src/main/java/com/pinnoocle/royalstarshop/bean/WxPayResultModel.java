package com.pinnoocle.royalstarshop.bean;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.pinnoocle.royalstarshop.adapter.RawStringJsonAdapter;

public class WxPayResultModel {

    /**
     * code : 1
     * msg : {"success":"支付成功","error":"订单未支付"}
     * data : {"order_id":"26233","pay_type":"20","wx_payment":true,"payment":{"prepay_id":"wx11140431963012c5cb5a8cd613d3130000","nonceStr":"ca39047264ad5a85a7f3c640289e48d4","timeStamp":"1615442671","paySign":"7DADAB91C216E61708420EF8F82ABEA8","mch_id":"1605495785","app_id":"wx541630a0717a5007","package":"Sign=WXPay"}}
     */

    private int code;
    private MsgBean msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public MsgBean getMsg() {
        return msg;
    }

    public void setMsg(MsgBean msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class MsgBean {
        /**
         * success : 支付成功
         * error : 订单未支付
         */

        private String success;
        private String error;

        public String getSuccess() {
            return success;
        }

        public void setSuccess(String success) {
            this.success = success;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    public static class DataBean {
        /**
         * order_id : 26233
         * pay_type : 20
         * wx_payment : true
         * payment : {"prepay_id":"wx11140431963012c5cb5a8cd613d3130000","nonceStr":"ca39047264ad5a85a7f3c640289e48d4","timeStamp":"1615442671","paySign":"7DADAB91C216E61708420EF8F82ABEA8","mch_id":"1605495785","app_id":"wx541630a0717a5007","package":"Sign=WXPay"}
         */

        private String order_id;
        private String pay_type;
        private boolean wx_payment;

        public String getPayment() {
            return payment;
        }

        public void setPayment(String payment) {
            this.payment = payment;
        }

        @SerializedName("payment")
        @JsonAdapter(RawStringJsonAdapter.class)
        private String payment;

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public String getPay_type() {
            return pay_type;
        }

        public void setPay_type(String pay_type) {
            this.pay_type = pay_type;
        }

        public boolean isWx_payment() {
            return wx_payment;
        }

        public void setWx_payment(boolean wx_payment) {
            this.wx_payment = wx_payment;
        }



        public static class PaymentBean {
            /**
             * prepay_id : wx11140431963012c5cb5a8cd613d3130000
             * nonceStr : ca39047264ad5a85a7f3c640289e48d4
             * timeStamp : 1615442671
             * paySign : 7DADAB91C216E61708420EF8F82ABEA8
             * mch_id : 1605495785
             * app_id : wx541630a0717a5007
             * package : Sign=WXPay
             */

            private String prepay_id;
            private String nonceStr;
            private String timeStamp;
            private String paySign;
            private String mch_id;
            private String app_id;
            @SerializedName("package")
            private String packageX;

            public String getPrepay_id() {
                return prepay_id;
            }

            public void setPrepay_id(String prepay_id) {
                this.prepay_id = prepay_id;
            }

            public String getNonceStr() {
                return nonceStr;
            }

            public void setNonceStr(String nonceStr) {
                this.nonceStr = nonceStr;
            }

            public String getTimeStamp() {
                return timeStamp;
            }

            public void setTimeStamp(String timeStamp) {
                this.timeStamp = timeStamp;
            }

            public String getPaySign() {
                return paySign;
            }

            public void setPaySign(String paySign) {
                this.paySign = paySign;
            }

            public String getMch_id() {
                return mch_id;
            }

            public void setMch_id(String mch_id) {
                this.mch_id = mch_id;
            }

            public String getApp_id() {
                return app_id;
            }

            public void setApp_id(String app_id) {
                this.app_id = app_id;
            }

            public String getPackageX() {
                return packageX;
            }

            public void setPackageX(String packageX) {
                this.packageX = packageX;
            }
        }
    }
}
