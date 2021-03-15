package com.pinnoocle.royalstarshop.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginBean {
    public String mobile;
    public String type;
    public String code;
    public String wxapp_id;
    public String token;
    public String address_id;
    public String region;
    public String name;
    public String phone;
    public String detail;
    public String category_id;
    public String search;
    public String tag;
    public String page;
    public String goods_id;
    public String goods_sku_id;
    public String goods_num;
    public String is_default;
    public String num;
    public String cart_ids;
    public String pay_type;
    public String dataType;
    public String collect_id;
    public String order_id;
    public String avatarUrl;
    public String nickName;
    public String birth;
    public String content;
    public String images;
    public String sortType;
    public String orderType;
    public List<FormData> formData;


    public static class FormData{
        public FormData(String _$Score45, String _$Content2, String _$Order_goods_id83, String _$Goods_id241) {
            this._$Score45 = _$Score45;
            this._$Content2 = _$Content2;
            this._$Order_goods_id83 = _$Order_goods_id83;
            this._$Goods_id241 = _$Goods_id241;
        }

        @SerializedName("score")
        private String _$Score45; // FIXME check this code
        @SerializedName("content")
        private String _$Content2; // FIXME check this code
        @SerializedName("order_goods_id")
        private String _$Order_goods_id83; // FIXME check this code
        @SerializedName("goods_id")
        private String _$Goods_id241; // FIXME check this code
        @SerializedName("uploaded")
        private List<Integer> _$Uploaded222; // FIXME check this code

        public String get_$Score45() {
            return _$Score45;
        }

        public void set_$Score45(String _$Score45) {
            this._$Score45 = _$Score45;
        }

        public String get_$Content2() {
            return _$Content2;
        }

        public void set_$Content2(String _$Content2) {
            this._$Content2 = _$Content2;
        }

        public String get_$Order_goods_id83() {
            return _$Order_goods_id83;
        }

        public void set_$Order_goods_id83(String _$Order_goods_id83) {
            this._$Order_goods_id83 = _$Order_goods_id83;
        }

        public String get_$Goods_id241() {
            return _$Goods_id241;
        }

        public void set_$Goods_id241(String _$Goods_id241) {
            this._$Goods_id241 = _$Goods_id241;
        }

        public List<Integer> get_$Uploaded222() {
            return _$Uploaded222;
        }

        public void set_$Uploaded222(List<Integer> _$Uploaded222) {
            this._$Uploaded222 = _$Uploaded222;
        }
    }
}
