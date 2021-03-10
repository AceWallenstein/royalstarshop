package com.pinnoocle.royalstarshop.bean;

import java.util.List;

public class CollectListModel {
    /**
     * code : 1
     * msg : success
     * data : {"list":{"total":1,"per_page":10,"current_page":1,"last_page":1,"data":[{"collect_id":68,"user_id":19530,"goods_id":12931,"goods_sku_id":39258,"wxapp_id":10001,"create_time":"2021-03-09 14:17:02","goods":{"goods_id":12931,"goods_name":"电视","selling_point":"","category_id":10581,"spec_type":20,"deduct_stock_type":10,"goods_sort":1,"buy_limit":0,"goods_status":{"text":"上架","value":10},"type":{"value":3,"text":"会员商品"},"freight":"0.00","video_id":0,"points":0,"tag":{"value":1,"text":"精选"},"scan_num":195,"goods_stock":311,"goods_image":"http://gsyp.vtui365.com/uploads/20210305100227b997a3950.jpg","goods_sku":{"goods_sku_id":39262,"goods_id":12931,"spec_sku_id":"12185_12186","image_id":26092,"goods_no":"","balance_price":"0.00","goods_price":"220.00","line_price":"0.00","stock_num":95,"goods_sales":0,"goods_weight":1000,"image":{"file_id":26092,"storage":"local","group_id":0,"file_url":"","file_name":"202103051002271d00e4277.jpg","file_size":41903,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://gsyp.vtui365.com/uploads/202103051002271d00e4277.jpg"}},"goods_multi_spec":{"spec_attr":[{"group_id":10403,"group_name":"颜色","spec_items":[{"item_id":12185,"spec_value":"黄色"},{"item_id":12180,"spec_value":"黑色"}]},{"group_id":10404,"group_name":"尺寸","spec_items":[{"item_id":12186,"spec_value":"22寸"},{"item_id":12187,"spec_value":"21寸"}]}],"spec_list":[{"goods_sku_id":39262,"spec_sku_id":"12185_12186","rows":[],"form":{"image_id":26092,"image_path":"http://gsyp.vtui365.com/uploads/202103051002271d00e4277.jpg","goods_no":"","balance_price":"0.00","goods_price":"220.00","goods_weight":1000,"line_price":"0.00","stock_num":95}},{"goods_sku_id":39263,"spec_sku_id":"12185_12187","rows":[],"form":{"image_id":26091,"image_path":"http://gsyp.vtui365.com/uploads/20210305100227b997a3950.jpg","goods_no":"","balance_price":"0.00","goods_price":"222.00","goods_weight":999,"line_price":"0.00","stock_num":95}},{"goods_sku_id":39264,"spec_sku_id":"12180_12186","rows":[],"form":{"image_id":26090,"image_path":"http://gsyp.vtui365.com/uploads/202103051002278c6566507.jpg","goods_no":"","balance_price":"0.00","goods_price":"218.00","goods_weight":998,"line_price":"0.00","stock_num":67}},{"goods_sku_id":39265,"spec_sku_id":"12180_12187","rows":[],"form":{"image_id":26088,"image_path":"http://gsyp.vtui365.com/uploads/20210305095413e69454970.png","goods_no":"","balance_price":"0.00","goods_price":"214.00","goods_weight":899,"line_price":"0.00","stock_num":54}}]},"category":{"category_id":10581,"name":"电视","parent_id":0,"image_id":26087,"sort":100,"create_time":"2021-02-25 22:28:55"},"image":[{"id":34560,"goods_id":12931,"image_id":26091,"file_path":"http://gsyp.vtui365.com/uploads/20210305100227b997a3950.jpg","file_name":"20210305100227b997a3950.jpg","file_url":""}],"sku":[{"goods_sku_id":39262,"goods_id":12931,"spec_sku_id":"12185_12186","image_id":26092,"goods_no":"","balance_price":"0.00","goods_price":"220.00","line_price":"0.00","stock_num":95,"goods_sales":0,"goods_weight":1000,"image":{"file_id":26092,"storage":"local","group_id":0,"file_url":"","file_name":"202103051002271d00e4277.jpg","file_size":41903,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://gsyp.vtui365.com/uploads/202103051002271d00e4277.jpg"}},{"goods_sku_id":39263,"goods_id":12931,"spec_sku_id":"12185_12187","image_id":26091,"goods_no":"","balance_price":"0.00","goods_price":"222.00","line_price":"0.00","stock_num":95,"goods_sales":0,"goods_weight":999,"image":{"file_id":26091,"storage":"local","group_id":0,"file_url":"","file_name":"20210305100227b997a3950.jpg","file_size":22572,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://gsyp.vtui365.com/uploads/20210305100227b997a3950.jpg"}},{"goods_sku_id":39264,"goods_id":12931,"spec_sku_id":"12180_12186","image_id":26090,"goods_no":"","balance_price":"0.00","goods_price":"218.00","line_price":"0.00","stock_num":67,"goods_sales":0,"goods_weight":998,"image":{"file_id":26090,"storage":"local","group_id":0,"file_url":"","file_name":"202103051002278c6566507.jpg","file_size":14646,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://gsyp.vtui365.com/uploads/202103051002278c6566507.jpg"}},{"goods_sku_id":39265,"goods_id":12931,"spec_sku_id":"12180_12187","image_id":26088,"goods_no":"","balance_price":"0.00","goods_price":"214.00","line_price":"0.00","stock_num":54,"goods_sales":0,"goods_weight":899,"image":{"file_id":26088,"storage":"local","group_id":0,"file_url":"","file_name":"20210305095413e69454970.png","file_size":376823,"file_type":"image","extension":"png","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://gsyp.vtui365.com/uploads/20210305095413e69454970.png"}}],"goods_sales":0}}]}}
     */

    private int code;
    private String msg;
    private DataBeanX data;

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

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * list : {"total":1,"per_page":10,"current_page":1,"last_page":1,"data":[{"collect_id":68,"user_id":19530,"goods_id":12931,"goods_sku_id":39258,"wxapp_id":10001,"create_time":"2021-03-09 14:17:02","goods":{"goods_id":12931,"goods_name":"电视","selling_point":"","category_id":10581,"spec_type":20,"deduct_stock_type":10,"goods_sort":1,"buy_limit":0,"goods_status":{"text":"上架","value":10},"type":{"value":3,"text":"会员商品"},"freight":"0.00","video_id":0,"points":0,"tag":{"value":1,"text":"精选"},"scan_num":195,"goods_stock":311,"goods_image":"http://gsyp.vtui365.com/uploads/20210305100227b997a3950.jpg","goods_sku":{"goods_sku_id":39262,"goods_id":12931,"spec_sku_id":"12185_12186","image_id":26092,"goods_no":"","balance_price":"0.00","goods_price":"220.00","line_price":"0.00","stock_num":95,"goods_sales":0,"goods_weight":1000,"image":{"file_id":26092,"storage":"local","group_id":0,"file_url":"","file_name":"202103051002271d00e4277.jpg","file_size":41903,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://gsyp.vtui365.com/uploads/202103051002271d00e4277.jpg"}},"goods_multi_spec":{"spec_attr":[{"group_id":10403,"group_name":"颜色","spec_items":[{"item_id":12185,"spec_value":"黄色"},{"item_id":12180,"spec_value":"黑色"}]},{"group_id":10404,"group_name":"尺寸","spec_items":[{"item_id":12186,"spec_value":"22寸"},{"item_id":12187,"spec_value":"21寸"}]}],"spec_list":[{"goods_sku_id":39262,"spec_sku_id":"12185_12186","rows":[],"form":{"image_id":26092,"image_path":"http://gsyp.vtui365.com/uploads/202103051002271d00e4277.jpg","goods_no":"","balance_price":"0.00","goods_price":"220.00","goods_weight":1000,"line_price":"0.00","stock_num":95}},{"goods_sku_id":39263,"spec_sku_id":"12185_12187","rows":[],"form":{"image_id":26091,"image_path":"http://gsyp.vtui365.com/uploads/20210305100227b997a3950.jpg","goods_no":"","balance_price":"0.00","goods_price":"222.00","goods_weight":999,"line_price":"0.00","stock_num":95}},{"goods_sku_id":39264,"spec_sku_id":"12180_12186","rows":[],"form":{"image_id":26090,"image_path":"http://gsyp.vtui365.com/uploads/202103051002278c6566507.jpg","goods_no":"","balance_price":"0.00","goods_price":"218.00","goods_weight":998,"line_price":"0.00","stock_num":67}},{"goods_sku_id":39265,"spec_sku_id":"12180_12187","rows":[],"form":{"image_id":26088,"image_path":"http://gsyp.vtui365.com/uploads/20210305095413e69454970.png","goods_no":"","balance_price":"0.00","goods_price":"214.00","goods_weight":899,"line_price":"0.00","stock_num":54}}]},"category":{"category_id":10581,"name":"电视","parent_id":0,"image_id":26087,"sort":100,"create_time":"2021-02-25 22:28:55"},"image":[{"id":34560,"goods_id":12931,"image_id":26091,"file_path":"http://gsyp.vtui365.com/uploads/20210305100227b997a3950.jpg","file_name":"20210305100227b997a3950.jpg","file_url":""}],"sku":[{"goods_sku_id":39262,"goods_id":12931,"spec_sku_id":"12185_12186","image_id":26092,"goods_no":"","balance_price":"0.00","goods_price":"220.00","line_price":"0.00","stock_num":95,"goods_sales":0,"goods_weight":1000,"image":{"file_id":26092,"storage":"local","group_id":0,"file_url":"","file_name":"202103051002271d00e4277.jpg","file_size":41903,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://gsyp.vtui365.com/uploads/202103051002271d00e4277.jpg"}},{"goods_sku_id":39263,"goods_id":12931,"spec_sku_id":"12185_12187","image_id":26091,"goods_no":"","balance_price":"0.00","goods_price":"222.00","line_price":"0.00","stock_num":95,"goods_sales":0,"goods_weight":999,"image":{"file_id":26091,"storage":"local","group_id":0,"file_url":"","file_name":"20210305100227b997a3950.jpg","file_size":22572,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://gsyp.vtui365.com/uploads/20210305100227b997a3950.jpg"}},{"goods_sku_id":39264,"goods_id":12931,"spec_sku_id":"12180_12186","image_id":26090,"goods_no":"","balance_price":"0.00","goods_price":"218.00","line_price":"0.00","stock_num":67,"goods_sales":0,"goods_weight":998,"image":{"file_id":26090,"storage":"local","group_id":0,"file_url":"","file_name":"202103051002278c6566507.jpg","file_size":14646,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://gsyp.vtui365.com/uploads/202103051002278c6566507.jpg"}},{"goods_sku_id":39265,"goods_id":12931,"spec_sku_id":"12180_12187","image_id":26088,"goods_no":"","balance_price":"0.00","goods_price":"214.00","line_price":"0.00","stock_num":54,"goods_sales":0,"goods_weight":899,"image":{"file_id":26088,"storage":"local","group_id":0,"file_url":"","file_name":"20210305095413e69454970.png","file_size":376823,"file_type":"image","extension":"png","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://gsyp.vtui365.com/uploads/20210305095413e69454970.png"}}],"goods_sales":0}}]}
         */

        private ListBean list;

        public ListBean getList() {
            return list;
        }

        public void setList(ListBean list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * total : 1
             * per_page : 10
             * current_page : 1
             * last_page : 1
             * data : [{"collect_id":68,"user_id":19530,"goods_id":12931,"goods_sku_id":39258,"wxapp_id":10001,"create_time":"2021-03-09 14:17:02","goods":{"goods_id":12931,"goods_name":"电视","selling_point":"","category_id":10581,"spec_type":20,"deduct_stock_type":10,"goods_sort":1,"buy_limit":0,"goods_status":{"text":"上架","value":10},"type":{"value":3,"text":"会员商品"},"freight":"0.00","video_id":0,"points":0,"tag":{"value":1,"text":"精选"},"scan_num":195,"goods_stock":311,"goods_image":"http://gsyp.vtui365.com/uploads/20210305100227b997a3950.jpg","goods_sku":{"goods_sku_id":39262,"goods_id":12931,"spec_sku_id":"12185_12186","image_id":26092,"goods_no":"","balance_price":"0.00","goods_price":"220.00","line_price":"0.00","stock_num":95,"goods_sales":0,"goods_weight":1000,"image":{"file_id":26092,"storage":"local","group_id":0,"file_url":"","file_name":"202103051002271d00e4277.jpg","file_size":41903,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://gsyp.vtui365.com/uploads/202103051002271d00e4277.jpg"}},"goods_multi_spec":{"spec_attr":[{"group_id":10403,"group_name":"颜色","spec_items":[{"item_id":12185,"spec_value":"黄色"},{"item_id":12180,"spec_value":"黑色"}]},{"group_id":10404,"group_name":"尺寸","spec_items":[{"item_id":12186,"spec_value":"22寸"},{"item_id":12187,"spec_value":"21寸"}]}],"spec_list":[{"goods_sku_id":39262,"spec_sku_id":"12185_12186","rows":[],"form":{"image_id":26092,"image_path":"http://gsyp.vtui365.com/uploads/202103051002271d00e4277.jpg","goods_no":"","balance_price":"0.00","goods_price":"220.00","goods_weight":1000,"line_price":"0.00","stock_num":95}},{"goods_sku_id":39263,"spec_sku_id":"12185_12187","rows":[],"form":{"image_id":26091,"image_path":"http://gsyp.vtui365.com/uploads/20210305100227b997a3950.jpg","goods_no":"","balance_price":"0.00","goods_price":"222.00","goods_weight":999,"line_price":"0.00","stock_num":95}},{"goods_sku_id":39264,"spec_sku_id":"12180_12186","rows":[],"form":{"image_id":26090,"image_path":"http://gsyp.vtui365.com/uploads/202103051002278c6566507.jpg","goods_no":"","balance_price":"0.00","goods_price":"218.00","goods_weight":998,"line_price":"0.00","stock_num":67}},{"goods_sku_id":39265,"spec_sku_id":"12180_12187","rows":[],"form":{"image_id":26088,"image_path":"http://gsyp.vtui365.com/uploads/20210305095413e69454970.png","goods_no":"","balance_price":"0.00","goods_price":"214.00","goods_weight":899,"line_price":"0.00","stock_num":54}}]},"category":{"category_id":10581,"name":"电视","parent_id":0,"image_id":26087,"sort":100,"create_time":"2021-02-25 22:28:55"},"image":[{"id":34560,"goods_id":12931,"image_id":26091,"file_path":"http://gsyp.vtui365.com/uploads/20210305100227b997a3950.jpg","file_name":"20210305100227b997a3950.jpg","file_url":""}],"sku":[{"goods_sku_id":39262,"goods_id":12931,"spec_sku_id":"12185_12186","image_id":26092,"goods_no":"","balance_price":"0.00","goods_price":"220.00","line_price":"0.00","stock_num":95,"goods_sales":0,"goods_weight":1000,"image":{"file_id":26092,"storage":"local","group_id":0,"file_url":"","file_name":"202103051002271d00e4277.jpg","file_size":41903,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://gsyp.vtui365.com/uploads/202103051002271d00e4277.jpg"}},{"goods_sku_id":39263,"goods_id":12931,"spec_sku_id":"12185_12187","image_id":26091,"goods_no":"","balance_price":"0.00","goods_price":"222.00","line_price":"0.00","stock_num":95,"goods_sales":0,"goods_weight":999,"image":{"file_id":26091,"storage":"local","group_id":0,"file_url":"","file_name":"20210305100227b997a3950.jpg","file_size":22572,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://gsyp.vtui365.com/uploads/20210305100227b997a3950.jpg"}},{"goods_sku_id":39264,"goods_id":12931,"spec_sku_id":"12180_12186","image_id":26090,"goods_no":"","balance_price":"0.00","goods_price":"218.00","line_price":"0.00","stock_num":67,"goods_sales":0,"goods_weight":998,"image":{"file_id":26090,"storage":"local","group_id":0,"file_url":"","file_name":"202103051002278c6566507.jpg","file_size":14646,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://gsyp.vtui365.com/uploads/202103051002278c6566507.jpg"}},{"goods_sku_id":39265,"goods_id":12931,"spec_sku_id":"12180_12187","image_id":26088,"goods_no":"","balance_price":"0.00","goods_price":"214.00","line_price":"0.00","stock_num":54,"goods_sales":0,"goods_weight":899,"image":{"file_id":26088,"storage":"local","group_id":0,"file_url":"","file_name":"20210305095413e69454970.png","file_size":376823,"file_type":"image","extension":"png","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://gsyp.vtui365.com/uploads/20210305095413e69454970.png"}}],"goods_sales":0}}]
             */

            private int total;
            private int per_page;
            private int current_page;
            private int last_page;
            private List<DataBean> data;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getPer_page() {
                return per_page;
            }

            public void setPer_page(int per_page) {
                this.per_page = per_page;
            }

            public int getCurrent_page() {
                return current_page;
            }

            public void setCurrent_page(int current_page) {
                this.current_page = current_page;
            }

            public int getLast_page() {
                return last_page;
            }

            public void setLast_page(int last_page) {
                this.last_page = last_page;
            }

            public List<DataBean> getData() {
                return data;
            }

            public void setData(List<DataBean> data) {
                this.data = data;
            }

            public static class DataBean {
                /**
                 * collect_id : 68
                 * user_id : 19530
                 * goods_id : 12931
                 * goods_sku_id : 39258
                 * wxapp_id : 10001
                 * create_time : 2021-03-09 14:17:02
                 * goods : {"goods_id":12931,"goods_name":"电视","selling_point":"","category_id":10581,"spec_type":20,"deduct_stock_type":10,"goods_sort":1,"buy_limit":0,"goods_status":{"text":"上架","value":10},"type":{"value":3,"text":"会员商品"},"freight":"0.00","video_id":0,"points":0,"tag":{"value":1,"text":"精选"},"scan_num":195,"goods_stock":311,"goods_image":"http://gsyp.vtui365.com/uploads/20210305100227b997a3950.jpg","goods_sku":{"goods_sku_id":39262,"goods_id":12931,"spec_sku_id":"12185_12186","image_id":26092,"goods_no":"","balance_price":"0.00","goods_price":"220.00","line_price":"0.00","stock_num":95,"goods_sales":0,"goods_weight":1000,"image":{"file_id":26092,"storage":"local","group_id":0,"file_url":"","file_name":"202103051002271d00e4277.jpg","file_size":41903,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://gsyp.vtui365.com/uploads/202103051002271d00e4277.jpg"}},"goods_multi_spec":{"spec_attr":[{"group_id":10403,"group_name":"颜色","spec_items":[{"item_id":12185,"spec_value":"黄色"},{"item_id":12180,"spec_value":"黑色"}]},{"group_id":10404,"group_name":"尺寸","spec_items":[{"item_id":12186,"spec_value":"22寸"},{"item_id":12187,"spec_value":"21寸"}]}],"spec_list":[{"goods_sku_id":39262,"spec_sku_id":"12185_12186","rows":[],"form":{"image_id":26092,"image_path":"http://gsyp.vtui365.com/uploads/202103051002271d00e4277.jpg","goods_no":"","balance_price":"0.00","goods_price":"220.00","goods_weight":1000,"line_price":"0.00","stock_num":95}},{"goods_sku_id":39263,"spec_sku_id":"12185_12187","rows":[],"form":{"image_id":26091,"image_path":"http://gsyp.vtui365.com/uploads/20210305100227b997a3950.jpg","goods_no":"","balance_price":"0.00","goods_price":"222.00","goods_weight":999,"line_price":"0.00","stock_num":95}},{"goods_sku_id":39264,"spec_sku_id":"12180_12186","rows":[],"form":{"image_id":26090,"image_path":"http://gsyp.vtui365.com/uploads/202103051002278c6566507.jpg","goods_no":"","balance_price":"0.00","goods_price":"218.00","goods_weight":998,"line_price":"0.00","stock_num":67}},{"goods_sku_id":39265,"spec_sku_id":"12180_12187","rows":[],"form":{"image_id":26088,"image_path":"http://gsyp.vtui365.com/uploads/20210305095413e69454970.png","goods_no":"","balance_price":"0.00","goods_price":"214.00","goods_weight":899,"line_price":"0.00","stock_num":54}}]},"category":{"category_id":10581,"name":"电视","parent_id":0,"image_id":26087,"sort":100,"create_time":"2021-02-25 22:28:55"},"image":[{"id":34560,"goods_id":12931,"image_id":26091,"file_path":"http://gsyp.vtui365.com/uploads/20210305100227b997a3950.jpg","file_name":"20210305100227b997a3950.jpg","file_url":""}],"sku":[{"goods_sku_id":39262,"goods_id":12931,"spec_sku_id":"12185_12186","image_id":26092,"goods_no":"","balance_price":"0.00","goods_price":"220.00","line_price":"0.00","stock_num":95,"goods_sales":0,"goods_weight":1000,"image":{"file_id":26092,"storage":"local","group_id":0,"file_url":"","file_name":"202103051002271d00e4277.jpg","file_size":41903,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://gsyp.vtui365.com/uploads/202103051002271d00e4277.jpg"}},{"goods_sku_id":39263,"goods_id":12931,"spec_sku_id":"12185_12187","image_id":26091,"goods_no":"","balance_price":"0.00","goods_price":"222.00","line_price":"0.00","stock_num":95,"goods_sales":0,"goods_weight":999,"image":{"file_id":26091,"storage":"local","group_id":0,"file_url":"","file_name":"20210305100227b997a3950.jpg","file_size":22572,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://gsyp.vtui365.com/uploads/20210305100227b997a3950.jpg"}},{"goods_sku_id":39264,"goods_id":12931,"spec_sku_id":"12180_12186","image_id":26090,"goods_no":"","balance_price":"0.00","goods_price":"218.00","line_price":"0.00","stock_num":67,"goods_sales":0,"goods_weight":998,"image":{"file_id":26090,"storage":"local","group_id":0,"file_url":"","file_name":"202103051002278c6566507.jpg","file_size":14646,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://gsyp.vtui365.com/uploads/202103051002278c6566507.jpg"}},{"goods_sku_id":39265,"goods_id":12931,"spec_sku_id":"12180_12187","image_id":26088,"goods_no":"","balance_price":"0.00","goods_price":"214.00","line_price":"0.00","stock_num":54,"goods_sales":0,"goods_weight":899,"image":{"file_id":26088,"storage":"local","group_id":0,"file_url":"","file_name":"20210305095413e69454970.png","file_size":376823,"file_type":"image","extension":"png","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://gsyp.vtui365.com/uploads/20210305095413e69454970.png"}}],"goods_sales":0}
                 */

                private int collect_id;
                private int user_id;
                private int goods_id;
                private int goods_sku_id;
                private int wxapp_id;
                private String create_time;
                private GoodsBean goods;

                public int getCollect_id() {
                    return collect_id;
                }

                public void setCollect_id(int collect_id) {
                    this.collect_id = collect_id;
                }

                public int getUser_id() {
                    return user_id;
                }

                public void setUser_id(int user_id) {
                    this.user_id = user_id;
                }

                public int getGoods_id() {
                    return goods_id;
                }

                public void setGoods_id(int goods_id) {
                    this.goods_id = goods_id;
                }

                public int getGoods_sku_id() {
                    return goods_sku_id;
                }

                public void setGoods_sku_id(int goods_sku_id) {
                    this.goods_sku_id = goods_sku_id;
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

                public GoodsBean getGoods() {
                    return goods;
                }

                public void setGoods(GoodsBean goods) {
                    this.goods = goods;
                }

                public static class GoodsBean {
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
                     * scan_num : 195
                     * goods_stock : 311
                     * goods_image : http://gsyp.vtui365.com/uploads/20210305100227b997a3950.jpg
                     * goods_sku : {"goods_sku_id":39262,"goods_id":12931,"spec_sku_id":"12185_12186","image_id":26092,"goods_no":"","balance_price":"0.00","goods_price":"220.00","line_price":"0.00","stock_num":95,"goods_sales":0,"goods_weight":1000,"image":{"file_id":26092,"storage":"local","group_id":0,"file_url":"","file_name":"202103051002271d00e4277.jpg","file_size":41903,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://gsyp.vtui365.com/uploads/202103051002271d00e4277.jpg"}}
                     * goods_multi_spec : {"spec_attr":[{"group_id":10403,"group_name":"颜色","spec_items":[{"item_id":12185,"spec_value":"黄色"},{"item_id":12180,"spec_value":"黑色"}]},{"group_id":10404,"group_name":"尺寸","spec_items":[{"item_id":12186,"spec_value":"22寸"},{"item_id":12187,"spec_value":"21寸"}]}],"spec_list":[{"goods_sku_id":39262,"spec_sku_id":"12185_12186","rows":[],"form":{"image_id":26092,"image_path":"http://gsyp.vtui365.com/uploads/202103051002271d00e4277.jpg","goods_no":"","balance_price":"0.00","goods_price":"220.00","goods_weight":1000,"line_price":"0.00","stock_num":95}},{"goods_sku_id":39263,"spec_sku_id":"12185_12187","rows":[],"form":{"image_id":26091,"image_path":"http://gsyp.vtui365.com/uploads/20210305100227b997a3950.jpg","goods_no":"","balance_price":"0.00","goods_price":"222.00","goods_weight":999,"line_price":"0.00","stock_num":95}},{"goods_sku_id":39264,"spec_sku_id":"12180_12186","rows":[],"form":{"image_id":26090,"image_path":"http://gsyp.vtui365.com/uploads/202103051002278c6566507.jpg","goods_no":"","balance_price":"0.00","goods_price":"218.00","goods_weight":998,"line_price":"0.00","stock_num":67}},{"goods_sku_id":39265,"spec_sku_id":"12180_12187","rows":[],"form":{"image_id":26088,"image_path":"http://gsyp.vtui365.com/uploads/20210305095413e69454970.png","goods_no":"","balance_price":"0.00","goods_price":"214.00","goods_weight":899,"line_price":"0.00","stock_num":54}}]}
                     * category : {"category_id":10581,"name":"电视","parent_id":0,"image_id":26087,"sort":100,"create_time":"2021-02-25 22:28:55"}
                     * image : [{"id":34560,"goods_id":12931,"image_id":26091,"file_path":"http://gsyp.vtui365.com/uploads/20210305100227b997a3950.jpg","file_name":"20210305100227b997a3950.jpg","file_url":""}]
                     * sku : [{"goods_sku_id":39262,"goods_id":12931,"spec_sku_id":"12185_12186","image_id":26092,"goods_no":"","balance_price":"0.00","goods_price":"220.00","line_price":"0.00","stock_num":95,"goods_sales":0,"goods_weight":1000,"image":{"file_id":26092,"storage":"local","group_id":0,"file_url":"","file_name":"202103051002271d00e4277.jpg","file_size":41903,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://gsyp.vtui365.com/uploads/202103051002271d00e4277.jpg"}},{"goods_sku_id":39263,"goods_id":12931,"spec_sku_id":"12185_12187","image_id":26091,"goods_no":"","balance_price":"0.00","goods_price":"222.00","line_price":"0.00","stock_num":95,"goods_sales":0,"goods_weight":999,"image":{"file_id":26091,"storage":"local","group_id":0,"file_url":"","file_name":"20210305100227b997a3950.jpg","file_size":22572,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://gsyp.vtui365.com/uploads/20210305100227b997a3950.jpg"}},{"goods_sku_id":39264,"goods_id":12931,"spec_sku_id":"12180_12186","image_id":26090,"goods_no":"","balance_price":"0.00","goods_price":"218.00","line_price":"0.00","stock_num":67,"goods_sales":0,"goods_weight":998,"image":{"file_id":26090,"storage":"local","group_id":0,"file_url":"","file_name":"202103051002278c6566507.jpg","file_size":14646,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://gsyp.vtui365.com/uploads/202103051002278c6566507.jpg"}},{"goods_sku_id":39265,"goods_id":12931,"spec_sku_id":"12180_12187","image_id":26088,"goods_no":"","balance_price":"0.00","goods_price":"214.00","line_price":"0.00","stock_num":54,"goods_sales":0,"goods_weight":899,"image":{"file_id":26088,"storage":"local","group_id":0,"file_url":"","file_name":"20210305095413e69454970.png","file_size":376823,"file_type":"image","extension":"png","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://gsyp.vtui365.com/uploads/20210305095413e69454970.png"}}]
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
                    private CategoryBean category;
                    private int goods_sales;
                    private List<ImageBeanX> image;
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

                    public CategoryBean getCategory() {
                        return category;
                    }

                    public void setCategory(CategoryBean category) {
                        this.category = category;
                    }

                    public int getGoods_sales() {
                        return goods_sales;
                    }

                    public void setGoods_sales(int goods_sales) {
                        this.goods_sales = goods_sales;
                    }

                    public List<ImageBeanX> getImage() {
                        return image;
                    }

                    public void setImage(List<ImageBeanX> image) {
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
                         * goods_sku_id : 39262
                         * goods_id : 12931
                         * spec_sku_id : 12185_12186
                         * image_id : 26092
                         * goods_no :
                         * balance_price : 0.00
                         * goods_price : 220.00
                         * line_price : 0.00
                         * stock_num : 95
                         * goods_sales : 0
                         * goods_weight : 1000
                         * image : {"file_id":26092,"storage":"local","group_id":0,"file_url":"","file_name":"202103051002271d00e4277.jpg","file_size":41903,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://gsyp.vtui365.com/uploads/202103051002271d00e4277.jpg"}
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
                        private ImageBean image;

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

                        public ImageBean getImage() {
                            return image;
                        }

                        public void setImage(ImageBean image) {
                            this.image = image;
                        }

                        public static class ImageBean {
                            /**
                             * file_id : 26092
                             * storage : local
                             * group_id : 0
                             * file_url :
                             * file_name : 202103051002271d00e4277.jpg
                             * file_size : 41903
                             * file_type : image
                             * extension : jpg
                             * is_user : 0
                             * is_recycle : 0
                             * is_delete : 0
                             * file_path : http://gsyp.vtui365.com/uploads/202103051002271d00e4277.jpg
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

                            public static class SpecItemsBean {
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

                        public static class SpecListBean {
                            /**
                             * goods_sku_id : 39262
                             * spec_sku_id : 12185_12186
                             * rows : []
                             * form : {"image_id":26092,"image_path":"http://gsyp.vtui365.com/uploads/202103051002271d00e4277.jpg","goods_no":"","balance_price":"0.00","goods_price":"220.00","goods_weight":1000,"line_price":"0.00","stock_num":95}
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
                                 * image_id : 26092
                                 * image_path : http://gsyp.vtui365.com/uploads/202103051002271d00e4277.jpg
                                 * goods_no :
                                 * balance_price : 0.00
                                 * goods_price : 220.00
                                 * goods_weight : 1000
                                 * line_price : 0.00
                                 * stock_num : 95
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

                    public static class CategoryBean {
                        /**
                         * category_id : 10581
                         * name : 电视
                         * parent_id : 0
                         * image_id : 26087
                         * sort : 100
                         * create_time : 2021-02-25 22:28:55
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

                    public static class ImageBeanX {
                        /**
                         * id : 34560
                         * goods_id : 12931
                         * image_id : 26091
                         * file_path : http://gsyp.vtui365.com/uploads/20210305100227b997a3950.jpg
                         * file_name : 20210305100227b997a3950.jpg
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
                         * goods_sku_id : 39262
                         * goods_id : 12931
                         * spec_sku_id : 12185_12186
                         * image_id : 26092
                         * goods_no :
                         * balance_price : 0.00
                         * goods_price : 220.00
                         * line_price : 0.00
                         * stock_num : 95
                         * goods_sales : 0
                         * goods_weight : 1000
                         * image : {"file_id":26092,"storage":"local","group_id":0,"file_url":"","file_name":"202103051002271d00e4277.jpg","file_size":41903,"file_type":"image","extension":"jpg","is_user":0,"is_recycle":0,"is_delete":0,"file_path":"http://gsyp.vtui365.com/uploads/202103051002271d00e4277.jpg"}
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
                        private ImageBeanXX image;

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

                        public ImageBeanXX getImage() {
                            return image;
                        }

                        public void setImage(ImageBeanXX image) {
                            this.image = image;
                        }

                        public static class ImageBeanXX {
                            /**
                             * file_id : 26092
                             * storage : local
                             * group_id : 0
                             * file_url :
                             * file_name : 202103051002271d00e4277.jpg
                             * file_size : 41903
                             * file_type : image
                             * extension : jpg
                             * is_user : 0
                             * is_recycle : 0
                             * is_delete : 0
                             * file_path : http://gsyp.vtui365.com/uploads/202103051002271d00e4277.jpg
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
            }
        }
    }
}
