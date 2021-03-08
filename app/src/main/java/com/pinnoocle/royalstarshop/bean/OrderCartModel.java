package com.pinnoocle.royalstarshop.bean;

import java.io.Serializable;
import java.util.List;

public class OrderCartModel {


    /**
     * code : 1
     * msg : success
     * data : {"goods_list":[{"goods_id":12931,"goods_name":"电视","selling_point":"","category_id":10581,"spec_type":20,"deduct_stock_type":10,"goods_sort":1,"buy_limit":0,"goods_status":{"text":"上架","value":10},"type":{"value":3,"text":"会员商品"},"freight":"0.00","video_id":0,"points":0,"tag":{"value":1,"text":"精选"},"scan_num":123,"goods_stock":320,"goods_image":"http://gsyp.vtui365.com/uploads/20210305100227b997a3950.jpg","goods_sku":{"goods_sku_id":39258,"goods_id":12931,"spec_sku_id":"12185_12186","image_id":0,"goods_no":"","balance_price":"0.00","goods_price":"220.00","line_price":"0.00","stock_num":100,"goods_sales":0,"goods_weight":1000,"goods_attr":"颜色:黄色; 尺寸:22寸; ","image":null},"goods_multi_spec":{"spec_attr":[{"group_id":10403,"group_name":"颜色","spec_items":[{"item_id":12185,"spec_value":"黄色"},{"item_id":12180,"spec_value":"黑色"}]},{"group_id":10404,"group_name":"尺寸","spec_items":[{"item_id":12186,"spec_value":"22寸"},{"item_id":12187,"spec_value":"21寸"}]}],"spec_list":[{"goods_sku_id":39258,"spec_sku_id":"12185_12186","rows":[],"form":{"image_id":0,"image_path":"","goods_no":"","balance_price":"0.00","goods_price":"220.00","goods_weight":1000,"line_price":"0.00","stock_num":100}},{"goods_sku_id":39259,"spec_sku_id":"12185_12187","rows":[],"form":{"image_id":0,"image_path":"","goods_no":"","balance_price":"0.00","goods_price":"222.00","goods_weight":999,"line_price":"0.00","stock_num":99}},{"goods_sku_id":39260,"spec_sku_id":"12180_12186","rows":[],"form":{"image_id":0,"image_path":"","goods_no":"","balance_price":"0.00","goods_price":"218.00","goods_weight":998,"line_price":"0.00","stock_num":67}},{"goods_sku_id":39261,"spec_sku_id":"12180_12187","rows":[],"form":{"image_id":0,"image_path":"","goods_no":"","balance_price":"0.00","goods_price":"214.00","goods_weight":899,"line_price":"0.00","stock_num":54}}]},"goods_sku_id":"39258","goods_price":"220.00","balance_price":"0.00","total_num":2,"total_freight":"0.00","total_price":"440.00","is_user_grade":false,"grade_ratio":0,"grade_goods_price":0,"grade_total_money":0,"points_money":0,"points_num":0,"coupon_money":0,"virtual_code_money":0,"total_pay_price":"440.00","points_bonus":0,"goods_sales":0}],"order_total_num":2,"coupon_list":[],"has_error":false,"error_msg":null,"delivery":10,"address":{"address_id":13967,"name":"cccc","phone":"16313131245","province_id":1,"city_id":2,"region_id":3,"district":"","detail":"ttttt","longitude":"","latitude":"","user_id":19533,"region":{"province":"北京市","city":"北京市","region":"东城区"}},"exist_address":true,"express_price":0,"intra_region":true,"extract_shop":[],"is_allow_points":false,"is_use_points":0,"points_money":0,"points_bonus":0,"pay_type":20,"setting":{"delivery":[10,20,30],"points_name":"积分","points_describe":"a) 积分不可兑现、不可转让,仅可在本平台使用;\nb) 您在本平台参加特定活动也可使用积分,详细使用规则以具体活动时的规则为准;\nc) 积分的数值精确到个位(小数点后全部舍弃,不进行四舍五入)\nd) 买家在完成该笔交易(订单状态为\u201c已签收\u201d)后才能得到此笔交易的相应积分,如购买商品参加店铺其他优惠,则优惠的金额部分不享受积分获取;","tplSetting":{"payment":{"is_enable":"0","template_id":"","template_params":""},"delivery":{"is_enable":"0","template_id":"","template_params":""},"refund":{"is_enable":"0","template_id":"","template_params":""}}},"last_extract":{"linkman":"","phone":""},"deliverySetting":[10,20,30],"send_payment_msg":0,"send_delivery_msg":0,"send_refund_msg":0,"feight_price":0,"order_total_price":"440.00","coupon_id":0,"coupon_money":0,"virtual_code":"","virtual_code_money":0,"freight_price":"0.00","order_price":"440.00","order_pay_price":"440.00"}
     */

    private int code;
    private String msg;
    private SureOrderModel.DataBean data;

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

    public SureOrderModel.DataBean getData() {
        return data;
    }

    public void setData(SureOrderModel.DataBean data) {
        this.data = data;
    }

}
