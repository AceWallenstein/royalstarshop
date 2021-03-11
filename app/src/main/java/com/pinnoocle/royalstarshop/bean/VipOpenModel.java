package com.pinnoocle.royalstarshop.bean;

import com.google.gson.annotations.SerializedName;

public class VipOpenModel {

    /**
     * code : 1
     * msg : {"success":"充值成功","error":"订单未支付"}
     * data : {"payment":{"prepay_id":"wx111644573251845160ccd13ce2a5790000","nonceStr":"3f6932c21aae7e62ce2d178b52802507","timeStamp":"1615452297","paySign":"D1BB5043C40C6C5687A5623C1CC7D1E6","mch_id":"1605495785","app_id":"wx541630a0717a5007","package":"Sign=WXPay"},"message":{"success":"充值成功","error":"订单未支付"}}
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
         * success : 充值成功
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
         * payment : {"prepay_id":"wx111644573251845160ccd13ce2a5790000","nonceStr":"3f6932c21aae7e62ce2d178b52802507","timeStamp":"1615452297","paySign":"D1BB5043C40C6C5687A5623C1CC7D1E6","mch_id":"1605495785","app_id":"wx541630a0717a5007","package":"Sign=WXPay"}
         * message : {"success":"充值成功","error":"订单未支付"}
         */

        private PaymentBean payment;
        private MessageBean message;

        public PaymentBean getPayment() {
            return payment;
        }

        public void setPayment(PaymentBean payment) {
            this.payment = payment;
        }

        public MessageBean getMessage() {
            return message;
        }

        public void setMessage(MessageBean message) {
            this.message = message;
        }

        public static class PaymentBean {
            /**
             * prepay_id : wx111644573251845160ccd13ce2a5790000
             * nonceStr : 3f6932c21aae7e62ce2d178b52802507
             * timeStamp : 1615452297
             * paySign : D1BB5043C40C6C5687A5623C1CC7D1E6
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

        public static class MessageBean {
            /**
             * success : 充值成功
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
    }
}
