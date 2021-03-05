package com.pinnoocle.royalstarshop.event;

public class SetCartNums {
    private String goods_id;
    private String goods_sku_id;
    private String num;

    public SetCartNums(String goods_id, String goods_sku_id, String num) {
        this.goods_id = goods_id;
        this.goods_sku_id = goods_sku_id;
        this.num = num;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_sku_id() {
        return goods_sku_id;
    }

    public void setGoods_sku_id(String goods_sku_id) {
        this.goods_sku_id = goods_sku_id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
