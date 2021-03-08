package com.pinnoocle.royalstarshop.bean;

import java.util.List;

public class GoodsSku {

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
