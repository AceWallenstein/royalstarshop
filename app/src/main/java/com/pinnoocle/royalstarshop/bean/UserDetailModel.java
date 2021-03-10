package com.pinnoocle.royalstarshop.bean;

import java.util.List;

public class UserDetailModel {
    /**
     * code : 1
     * msg : success
     * data : {"userInfo":{"user_id":19529,"nickName":"","avatarUrl":"","gender":"未知","address_id":13935,"balance":"0.00","points":0,"pay_money":"0.00","expend_money":"2410.00","phone":"15665336289","lasttime":null,"address":[{"address_id":13935,"name":"123","phone":"15665336289","province_id":1046,"city_id":1047,"region_id":1051,"district":"","detail":"123","longitude":"","latitude":"","user_id":19529,"region":{"province":"安徽省","city":"合肥市","region":"包河区"}},{"address_id":13936,"name":"123","phone":"15665336289","province_id":1,"city_id":2,"region_id":3,"district":"","detail":"123","longitude":"","latitude":"","user_id":19529,"region":{"province":"北京市","city":"北京市","region":"东城区"}},{"address_id":13937,"name":"123","phone":"15665336289","province_id":1,"city_id":2,"region_id":3,"district":"","detail":"123","longitude":"","latitude":"","user_id":19529,"region":{"province":"北京市","city":"北京市","region":"东城区"}},{"address_id":13938,"name":"123","phone":"15665336289","province_id":1,"city_id":2,"region_id":3,"district":"","detail":"123","longitude":"","latitude":"","user_id":19529,"region":{"province":"北京市","city":"北京市","region":"东城区"}}],"username":null,"invite_code":null,"isVip":1,"vip_time":0,"vip_expire":0,"parent_id":0,"service_id":0,"total_balance":"0.00","is_exprire":1,"address_default":{"address_id":13935,"name":"123","phone":"15665336289","province_id":1046,"city_id":1047,"region_id":1051,"district":"","detail":"123","longitude":"","latitude":"","user_id":19529,"region":{"province":"安徽省","city":"合肥市","region":"包河区"}},"grade":null},"orderCount":{"payment":0,"received":0,"comment":1}}
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
         * userInfo : {"user_id":19529,"nickName":"","avatarUrl":"","gender":"未知","address_id":13935,"balance":"0.00","points":0,"pay_money":"0.00","expend_money":"2410.00","phone":"15665336289","lasttime":null,"address":[{"address_id":13935,"name":"123","phone":"15665336289","province_id":1046,"city_id":1047,"region_id":1051,"district":"","detail":"123","longitude":"","latitude":"","user_id":19529,"region":{"province":"安徽省","city":"合肥市","region":"包河区"}},{"address_id":13936,"name":"123","phone":"15665336289","province_id":1,"city_id":2,"region_id":3,"district":"","detail":"123","longitude":"","latitude":"","user_id":19529,"region":{"province":"北京市","city":"北京市","region":"东城区"}},{"address_id":13937,"name":"123","phone":"15665336289","province_id":1,"city_id":2,"region_id":3,"district":"","detail":"123","longitude":"","latitude":"","user_id":19529,"region":{"province":"北京市","city":"北京市","region":"东城区"}},{"address_id":13938,"name":"123","phone":"15665336289","province_id":1,"city_id":2,"region_id":3,"district":"","detail":"123","longitude":"","latitude":"","user_id":19529,"region":{"province":"北京市","city":"北京市","region":"东城区"}}],"username":null,"invite_code":null,"isVip":1,"vip_time":0,"vip_expire":0,"parent_id":0,"service_id":0,"total_balance":"0.00","is_exprire":1,"address_default":{"address_id":13935,"name":"123","phone":"15665336289","province_id":1046,"city_id":1047,"region_id":1051,"district":"","detail":"123","longitude":"","latitude":"","user_id":19529,"region":{"province":"安徽省","city":"合肥市","region":"包河区"}},"grade":null}
         * orderCount : {"payment":0,"received":0,"comment":1}
         */

        private UserInfoBean userInfo;
        private OrderCountBean orderCount;

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public OrderCountBean getOrderCount() {
            return orderCount;
        }

        public void setOrderCount(OrderCountBean orderCount) {
            this.orderCount = orderCount;
        }

        public static class UserInfoBean {
            /**
             * user_id : 19529
             * nickName :
             * avatarUrl :
             * gender : 未知
             * address_id : 13935
             * balance : 0.00
             * points : 0
             * pay_money : 0.00
             * expend_money : 2410.00
             * phone : 15665336289
             * lasttime : null
             * address : [{"address_id":13935,"name":"123","phone":"15665336289","province_id":1046,"city_id":1047,"region_id":1051,"district":"","detail":"123","longitude":"","latitude":"","user_id":19529,"region":{"province":"安徽省","city":"合肥市","region":"包河区"}},{"address_id":13936,"name":"123","phone":"15665336289","province_id":1,"city_id":2,"region_id":3,"district":"","detail":"123","longitude":"","latitude":"","user_id":19529,"region":{"province":"北京市","city":"北京市","region":"东城区"}},{"address_id":13937,"name":"123","phone":"15665336289","province_id":1,"city_id":2,"region_id":3,"district":"","detail":"123","longitude":"","latitude":"","user_id":19529,"region":{"province":"北京市","city":"北京市","region":"东城区"}},{"address_id":13938,"name":"123","phone":"15665336289","province_id":1,"city_id":2,"region_id":3,"district":"","detail":"123","longitude":"","latitude":"","user_id":19529,"region":{"province":"北京市","city":"北京市","region":"东城区"}}]
             * username : null
             * invite_code : null
             * isVip : 1
             * vip_time : 0
             * vip_expire : 0
             * parent_id : 0
             * service_id : 0
             * total_balance : 0.00
             * is_exprire : 1
             * address_default : {"address_id":13935,"name":"123","phone":"15665336289","province_id":1046,"city_id":1047,"region_id":1051,"district":"","detail":"123","longitude":"","latitude":"","user_id":19529,"region":{"province":"安徽省","city":"合肥市","region":"包河区"}}
             * grade : null
             */

            private int user_id;
            private String nickName;
            private String san_num;
            private String avatarUrl;
            private String gender;
            private int address_id;
            private String balance;
            private int points;
            private String pay_money;
            private String expend_money;
            private String phone;
            private String birth;
            private Object lasttime;
            private Object username;
            private Object invite_code;
            private int isVip;
            private int vip_time;
            private int vip_expire;
            private int parent_id;
            private int service_id;
            private String total_balance;
            private int is_exprire;
            private AddressDefaultBean address_default;
            private Object grade;
            private List<AddressBean> address;

            public String getBirth() {
                return birth;
            }

            public void setBirth(String birth) {
                this.birth = birth;
            }

            public String getSan_num() {
                return san_num;
            }

            public void setSan_num(String san_num) {
                this.san_num = san_num;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
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

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public Object getLasttime() {
                return lasttime;
            }

            public void setLasttime(Object lasttime) {
                this.lasttime = lasttime;
            }

            public Object getUsername() {
                return username;
            }

            public void setUsername(Object username) {
                this.username = username;
            }

            public Object getInvite_code() {
                return invite_code;
            }

            public void setInvite_code(Object invite_code) {
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

            public String getTotal_balance() {
                return total_balance;
            }

            public void setTotal_balance(String total_balance) {
                this.total_balance = total_balance;
            }

            public int getIs_exprire() {
                return is_exprire;
            }

            public void setIs_exprire(int is_exprire) {
                this.is_exprire = is_exprire;
            }

            public AddressDefaultBean getAddress_default() {
                return address_default;
            }

            public void setAddress_default(AddressDefaultBean address_default) {
                this.address_default = address_default;
            }

            public Object getGrade() {
                return grade;
            }

            public void setGrade(Object grade) {
                this.grade = grade;
            }

            public List<AddressBean> getAddress() {
                return address;
            }

            public void setAddress(List<AddressBean> address) {
                this.address = address;
            }

            public static class AddressDefaultBean {
                /**
                 * address_id : 13935
                 * name : 123
                 * phone : 15665336289
                 * province_id : 1046
                 * city_id : 1047
                 * region_id : 1051
                 * district :
                 * detail : 123
                 * longitude :
                 * latitude :
                 * user_id : 19529
                 * region : {"province":"安徽省","city":"合肥市","region":"包河区"}
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

                public static class RegionBean {
                    /**
                     * province : 安徽省
                     * city : 合肥市
                     * region : 包河区
                     */

                    private String province;
                    private String city;
                    private String region;

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

            public static class AddressBean {
                /**
                 * address_id : 13935
                 * name : 123
                 * phone : 15665336289
                 * province_id : 1046
                 * city_id : 1047
                 * region_id : 1051
                 * district :
                 * detail : 123
                 * longitude :
                 * latitude :
                 * user_id : 19529
                 * region : {"province":"安徽省","city":"合肥市","region":"包河区"}
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
                private RegionBeanX region;

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

                public RegionBeanX getRegion() {
                    return region;
                }

                public void setRegion(RegionBeanX region) {
                    this.region = region;
                }

                public static class RegionBeanX {
                    /**
                     * province : 安徽省
                     * city : 合肥市
                     * region : 包河区
                     */

                    private String province;
                    private String city;
                    private String region;

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
        }

        public static class OrderCountBean {
            /**
             * payment : 0
             * received : 0
             * comment : 1
             */

            private int payment;
            private int received;
            private int comment;

            public int getPayment() {
                return payment;
            }

            public void setPayment(int payment) {
                this.payment = payment;
            }

            public int getReceived() {
                return received;
            }

            public void setReceived(int received) {
                this.received = received;
            }

            public int getComment() {
                return comment;
            }

            public void setComment(int comment) {
                this.comment = comment;
            }
        }
    }
}
