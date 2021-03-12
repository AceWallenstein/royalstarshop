package com.pinnoocle.royalstarshop.bean;

import java.util.List;

public class MoneyListModel {
    /**
     * code : 1
     * msg : success
     * data : {"list":{"total":1,"per_page":15,"current_page":1,"last_page":1,"data":[{"id":10963,"user_id":19533,"order_id":10112,"order_type":{"text":"开通会员","value":200},"order_no":"VIP2021031216330110048101","order_price":"365.00","first_user_id":19529,"second_user_id":0,"third_user_id":0,"first_money":"10.00","second_money":"0.00","third_money":"0.00","is_invalid":0,"is_settled":1,"settle_time":1615538080,"wxapp_id":10001,"create_time":"2021-03-12 16:34:40","user":{"user_id":19533,"open_id":"","nickName":"厉害了","avatarUrl":"http://gsyp.vtui365.com/uploads/20210310161151c0f376216.jpeg","gender":"未知","country":"","province":"","city":"","address_id":13967,"balance":"0.00","points":1095,"pay_money":"12.00","expend_money":"0.00","grade_id":0,"is_new_user":1,"is_delete":0,"wxapp_id":10001,"create_time":"2021-03-08 11:57:12","update_time":"2021-03-12 16:34:40","phone":"15212790160","fid":0,"role":null,"lasttime":null,"group_tags":null,"company":null,"source_type":1,"scene":null,"source_id":null,"phonemodel":null,"address":null,"username":null,"invite_code":"2RdqGW","isVip":1,"vip_time":1615532201,"vip_expire":1647074080,"parent_id":19529,"service_id":0,"birth":null}}]},"total":"20.00"}
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
         * list : {"total":1,"per_page":15,"current_page":1,"last_page":1,"data":[{"id":10963,"user_id":19533,"order_id":10112,"order_type":{"text":"开通会员","value":200},"order_no":"VIP2021031216330110048101","order_price":"365.00","first_user_id":19529,"second_user_id":0,"third_user_id":0,"first_money":"10.00","second_money":"0.00","third_money":"0.00","is_invalid":0,"is_settled":1,"settle_time":1615538080,"wxapp_id":10001,"create_time":"2021-03-12 16:34:40","user":{"user_id":19533,"open_id":"","nickName":"厉害了","avatarUrl":"http://gsyp.vtui365.com/uploads/20210310161151c0f376216.jpeg","gender":"未知","country":"","province":"","city":"","address_id":13967,"balance":"0.00","points":1095,"pay_money":"12.00","expend_money":"0.00","grade_id":0,"is_new_user":1,"is_delete":0,"wxapp_id":10001,"create_time":"2021-03-08 11:57:12","update_time":"2021-03-12 16:34:40","phone":"15212790160","fid":0,"role":null,"lasttime":null,"group_tags":null,"company":null,"source_type":1,"scene":null,"source_id":null,"phonemodel":null,"address":null,"username":null,"invite_code":"2RdqGW","isVip":1,"vip_time":1615532201,"vip_expire":1647074080,"parent_id":19529,"service_id":0,"birth":null}}]}
         * total : 20.00
         */

        private ListBean list;
        private String total;

        public ListBean getList() {
            return list;
        }

        public void setList(ListBean list) {
            this.list = list;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public static class ListBean {
            /**
             * total : 1
             * per_page : 15
             * current_page : 1
             * last_page : 1
             * data : [{"id":10963,"user_id":19533,"order_id":10112,"order_type":{"text":"开通会员","value":200},"order_no":"VIP2021031216330110048101","order_price":"365.00","first_user_id":19529,"second_user_id":0,"third_user_id":0,"first_money":"10.00","second_money":"0.00","third_money":"0.00","is_invalid":0,"is_settled":1,"settle_time":1615538080,"wxapp_id":10001,"create_time":"2021-03-12 16:34:40","user":{"user_id":19533,"open_id":"","nickName":"厉害了","avatarUrl":"http://gsyp.vtui365.com/uploads/20210310161151c0f376216.jpeg","gender":"未知","country":"","province":"","city":"","address_id":13967,"balance":"0.00","points":1095,"pay_money":"12.00","expend_money":"0.00","grade_id":0,"is_new_user":1,"is_delete":0,"wxapp_id":10001,"create_time":"2021-03-08 11:57:12","update_time":"2021-03-12 16:34:40","phone":"15212790160","fid":0,"role":null,"lasttime":null,"group_tags":null,"company":null,"source_type":1,"scene":null,"source_id":null,"phonemodel":null,"address":null,"username":null,"invite_code":"2RdqGW","isVip":1,"vip_time":1615532201,"vip_expire":1647074080,"parent_id":19529,"service_id":0,"birth":null}}]
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
                 * id : 10963
                 * user_id : 19533
                 * order_id : 10112
                 * order_type : {"text":"开通会员","value":200}
                 * order_no : VIP2021031216330110048101
                 * order_price : 365.00
                 * first_user_id : 19529
                 * second_user_id : 0
                 * third_user_id : 0
                 * first_money : 10.00
                 * second_money : 0.00
                 * third_money : 0.00
                 * is_invalid : 0
                 * is_settled : 1
                 * settle_time : 1615538080
                 * wxapp_id : 10001
                 * create_time : 2021-03-12 16:34:40
                 * user : {"user_id":19533,"open_id":"","nickName":"厉害了","avatarUrl":"http://gsyp.vtui365.com/uploads/20210310161151c0f376216.jpeg","gender":"未知","country":"","province":"","city":"","address_id":13967,"balance":"0.00","points":1095,"pay_money":"12.00","expend_money":"0.00","grade_id":0,"is_new_user":1,"is_delete":0,"wxapp_id":10001,"create_time":"2021-03-08 11:57:12","update_time":"2021-03-12 16:34:40","phone":"15212790160","fid":0,"role":null,"lasttime":null,"group_tags":null,"company":null,"source_type":1,"scene":null,"source_id":null,"phonemodel":null,"address":null,"username":null,"invite_code":"2RdqGW","isVip":1,"vip_time":1615532201,"vip_expire":1647074080,"parent_id":19529,"service_id":0,"birth":null}
                 */

                private int id;
                private int user_id;
                private int order_id;
                private OrderTypeBean order_type;
                private String order_no;
                private String order_price;
                private int first_user_id;
                private int second_user_id;
                private int third_user_id;
                private String first_money;
                private String second_money;
                private String third_money;
                private int is_invalid;
                private int is_settled;
                private int settle_time;
                private int wxapp_id;
                private String create_time;
                private UserBean user;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getUser_id() {
                    return user_id;
                }

                public void setUser_id(int user_id) {
                    this.user_id = user_id;
                }

                public int getOrder_id() {
                    return order_id;
                }

                public void setOrder_id(int order_id) {
                    this.order_id = order_id;
                }

                public OrderTypeBean getOrder_type() {
                    return order_type;
                }

                public void setOrder_type(OrderTypeBean order_type) {
                    this.order_type = order_type;
                }

                public String getOrder_no() {
                    return order_no;
                }

                public void setOrder_no(String order_no) {
                    this.order_no = order_no;
                }

                public String getOrder_price() {
                    return order_price;
                }

                public void setOrder_price(String order_price) {
                    this.order_price = order_price;
                }

                public int getFirst_user_id() {
                    return first_user_id;
                }

                public void setFirst_user_id(int first_user_id) {
                    this.first_user_id = first_user_id;
                }

                public int getSecond_user_id() {
                    return second_user_id;
                }

                public void setSecond_user_id(int second_user_id) {
                    this.second_user_id = second_user_id;
                }

                public int getThird_user_id() {
                    return third_user_id;
                }

                public void setThird_user_id(int third_user_id) {
                    this.third_user_id = third_user_id;
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

                public int getIs_invalid() {
                    return is_invalid;
                }

                public void setIs_invalid(int is_invalid) {
                    this.is_invalid = is_invalid;
                }

                public int getIs_settled() {
                    return is_settled;
                }

                public void setIs_settled(int is_settled) {
                    this.is_settled = is_settled;
                }

                public int getSettle_time() {
                    return settle_time;
                }

                public void setSettle_time(int settle_time) {
                    this.settle_time = settle_time;
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

                public UserBean getUser() {
                    return user;
                }

                public void setUser(UserBean user) {
                    this.user = user;
                }

                public static class OrderTypeBean {
                    /**
                     * text : 开通会员
                     * value : 200
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

                public static class UserBean {
                    /**
                     * user_id : 19533
                     * open_id :
                     * nickName : 厉害了
                     * avatarUrl : http://gsyp.vtui365.com/uploads/20210310161151c0f376216.jpeg
                     * gender : 未知
                     * country :
                     * province :
                     * city :
                     * address_id : 13967
                     * balance : 0.00
                     * points : 1095
                     * pay_money : 12.00
                     * expend_money : 0.00
                     * grade_id : 0
                     * is_new_user : 1
                     * is_delete : 0
                     * wxapp_id : 10001
                     * create_time : 2021-03-08 11:57:12
                     * update_time : 2021-03-12 16:34:40
                     * phone : 15212790160
                     * fid : 0
                     * role : null
                     * lasttime : null
                     * group_tags : null
                     * company : null
                     * source_type : 1
                     * scene : null
                     * source_id : null
                     * phonemodel : null
                     * address : null
                     * username : null
                     * invite_code : 2RdqGW
                     * isVip : 1
                     * vip_time : 1615532201
                     * vip_expire : 1647074080
                     * parent_id : 19529
                     * service_id : 0
                     * birth : null
                     */

                    private int user_id;
                    private String open_id;
                    private String nickName;
                    private String avatarUrl;
                    private String gender;
                    private String country;
                    private String province;
                    private String city;
                    private int address_id;
                    private String balance;
                    private int points;
                    private String pay_money;
                    private String expend_money;
                    private int grade_id;
                    private int is_new_user;
                    private int is_delete;
                    private int wxapp_id;
                    private String create_time;
                    private String update_time;
                    private String phone;
                    private int fid;
                    private Object role;
                    private Object lasttime;
                    private Object group_tags;
                    private Object company;
                    private int source_type;
                    private Object scene;
                    private Object source_id;
                    private Object phonemodel;
                    private Object address;
                    private Object username;
                    private String invite_code;
                    private int isVip;
                    private int vip_time;
                    private int vip_expire;
                    private int parent_id;
                    private int service_id;
                    private Object birth;

                    public int getUser_id() {
                        return user_id;
                    }

                    public void setUser_id(int user_id) {
                        this.user_id = user_id;
                    }

                    public String getOpen_id() {
                        return open_id;
                    }

                    public void setOpen_id(String open_id) {
                        this.open_id = open_id;
                    }

                    public String getNickName() {
                        return nickName;
                    }

                    public void setNickName(String nickName) {
                        this.nickName = nickName;
                    }

                    public String getAvatarUrl() {
                        return avatarUrl;
                    }

                    public void setAvatarUrl(String avatarUrl) {
                        this.avatarUrl = avatarUrl;
                    }

                    public String getGender() {
                        return gender;
                    }

                    public void setGender(String gender) {
                        this.gender = gender;
                    }

                    public String getCountry() {
                        return country;
                    }

                    public void setCountry(String country) {
                        this.country = country;
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

                    public int getAddress_id() {
                        return address_id;
                    }

                    public void setAddress_id(int address_id) {
                        this.address_id = address_id;
                    }

                    public String getBalance() {
                        return balance;
                    }

                    public void setBalance(String balance) {
                        this.balance = balance;
                    }

                    public int getPoints() {
                        return points;
                    }

                    public void setPoints(int points) {
                        this.points = points;
                    }

                    public String getPay_money() {
                        return pay_money;
                    }

                    public void setPay_money(String pay_money) {
                        this.pay_money = pay_money;
                    }

                    public String getExpend_money() {
                        return expend_money;
                    }

                    public void setExpend_money(String expend_money) {
                        this.expend_money = expend_money;
                    }

                    public int getGrade_id() {
                        return grade_id;
                    }

                    public void setGrade_id(int grade_id) {
                        this.grade_id = grade_id;
                    }

                    public int getIs_new_user() {
                        return is_new_user;
                    }

                    public void setIs_new_user(int is_new_user) {
                        this.is_new_user = is_new_user;
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

                    public String getUpdate_time() {
                        return update_time;
                    }

                    public void setUpdate_time(String update_time) {
                        this.update_time = update_time;
                    }

                    public String getPhone() {
                        return phone;
                    }

                    public void setPhone(String phone) {
                        this.phone = phone;
                    }

                    public int getFid() {
                        return fid;
                    }

                    public void setFid(int fid) {
                        this.fid = fid;
                    }

                    public Object getRole() {
                        return role;
                    }

                    public void setRole(Object role) {
                        this.role = role;
                    }

                    public Object getLasttime() {
                        return lasttime;
                    }

                    public void setLasttime(Object lasttime) {
                        this.lasttime = lasttime;
                    }

                    public Object getGroup_tags() {
                        return group_tags;
                    }

                    public void setGroup_tags(Object group_tags) {
                        this.group_tags = group_tags;
                    }

                    public Object getCompany() {
                        return company;
                    }

                    public void setCompany(Object company) {
                        this.company = company;
                    }

                    public int getSource_type() {
                        return source_type;
                    }

                    public void setSource_type(int source_type) {
                        this.source_type = source_type;
                    }

                    public Object getScene() {
                        return scene;
                    }

                    public void setScene(Object scene) {
                        this.scene = scene;
                    }

                    public Object getSource_id() {
                        return source_id;
                    }

                    public void setSource_id(Object source_id) {
                        this.source_id = source_id;
                    }

                    public Object getPhonemodel() {
                        return phonemodel;
                    }

                    public void setPhonemodel(Object phonemodel) {
                        this.phonemodel = phonemodel;
                    }

                    public Object getAddress() {
                        return address;
                    }

                    public void setAddress(Object address) {
                        this.address = address;
                    }

                    public Object getUsername() {
                        return username;
                    }

                    public void setUsername(Object username) {
                        this.username = username;
                    }

                    public String getInvite_code() {
                        return invite_code;
                    }

                    public void setInvite_code(String invite_code) {
                        this.invite_code = invite_code;
                    }

                    public int getIsVip() {
                        return isVip;
                    }

                    public void setIsVip(int isVip) {
                        this.isVip = isVip;
                    }

                    public int getVip_time() {
                        return vip_time;
                    }

                    public void setVip_time(int vip_time) {
                        this.vip_time = vip_time;
                    }

                    public int getVip_expire() {
                        return vip_expire;
                    }

                    public void setVip_expire(int vip_expire) {
                        this.vip_expire = vip_expire;
                    }

                    public int getParent_id() {
                        return parent_id;
                    }

                    public void setParent_id(int parent_id) {
                        this.parent_id = parent_id;
                    }

                    public int getService_id() {
                        return service_id;
                    }

                    public void setService_id(int service_id) {
                        this.service_id = service_id;
                    }

                    public Object getBirth() {
                        return birth;
                    }

                    public void setBirth(Object birth) {
                        this.birth = birth;
                    }
                }
            }
        }
    }
}
