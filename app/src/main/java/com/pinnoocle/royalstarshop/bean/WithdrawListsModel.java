package com.pinnoocle.royalstarshop.bean;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.pinnoocle.royalstarshop.adapter.RawStringJsonAdapter;

import java.util.List;

public class WithdrawListsModel {

    /**
     * code : 1
     * msg : success
     * data : {"list":{"total":2,"per_page":15,"current_page":1,"last_page":1,"data":[{"id":3,"user_id":19578,"money":"12.00","pay_type":10,"alipay_name":"","alipay_account":"","bank_name":"","bank_account":"","bank_card":"","apply_status":10,"audit_time":0,"reject_reason":"","wxapp_id":10001,"create_time":"2021-04-13 16:55:15"},{"id":2,"user_id":19578,"money":"12.00","pay_type":10,"alipay_name":"","alipay_account":"","bank_name":"","bank_account":"","bank_card":"","apply_status":10,"audit_time":0,"reject_reason":"","wxapp_id":10001,"create_time":"2021-04-13 16:54:00"}]},"words":{"index":{"title":{"default":"分销中心","value":"分销中心"},"words":{"not_dealer":{"default":"您还不是分销商，请先提交申请","value":"您还不是分销商，请先提交申请"},"apply_now":{"default":"立即加入","value":"立即加入"},"referee":{"default":"推荐人","value":"推荐人"},"money":{"default":"可提现佣金","value":"可提现"},"freeze_money":{"default":"待提现佣金","value":"待提现"},"total_money":{"default":"已提现金额","value":"已提现金额"},"withdraw":{"default":"去提现","value":"去提现"}}},"apply":{"title":{"default":"申请成为分销商","value":"申请成为分销商"},"words":{"title":{"default":"请填写申请信息","value":"请填写申请信息"},"license":{"default":"分销商申请协议","value":"分销商申请协议"},"submit":{"default":"申请成为经销商","value":"申请成为经销商"},"wait_audit":{"default":"您的申请已受理，正在进行信息核验，请耐心等待。","value":"您的申请已受理，正在进行信息核验，请耐心等待。"},"goto_mall":{"default":"去商城逛逛","value":"去商城逛逛"}}},"order":{"title":{"default":"分销订单","value":"分销订单"},"words":{"all":{"default":"全部","value":"全部"},"unsettled":{"default":"未结算","value":"未结算"},"settled":{"default":"已结算","value":"已结算"}}},"team":{"title":{"default":"我的团队","value":"我的团队"},"words":{"total_team":{"default":"团队总人数","value":"团队总人数"},"first":{"default":"一级团队","value":"一级团队"},"second":{"default":"二级团队","value":"二级团队"},"third":{"default":"三级团队","value":"三级团队"}}},"withdraw_list":{"title":{"default":"提现明细","value":"提现明细"},"words":{"all":{"default":"全部","value":"全部"},"apply_10":{"default":"审核中","value":"审核中"},"apply_20":{"default":"审核通过","value":"审核通过"},"apply_40":{"default":"已打款","value":"已打款"},"apply_30":{"default":"驳回","value":"驳回"}}},"withdraw_apply":{"title":{"default":"申请提现","value":"申请提现"},"words":{"capital":{"default":"可提现佣金","value":"可提现佣金"},"money":{"default":"提现金额","value":"提现金额"},"money_placeholder":{"default":"请输入要提取的金额","value":"请输入要提取的金额"},"min_money":{"default":"最低提现佣金","value":"最低提现佣金"},"submit":{"default":"提交申请","value":"提交申请"}}},"qrcode":{"title":{"default":"推广二维码","value":"推广二维码"}}}}
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
         * list : {"total":2,"per_page":15,"current_page":1,"last_page":1,"data":[{"id":3,"user_id":19578,"money":"12.00","pay_type":10,"alipay_name":"","alipay_account":"","bank_name":"","bank_account":"","bank_card":"","apply_status":10,"audit_time":0,"reject_reason":"","wxapp_id":10001,"create_time":"2021-04-13 16:55:15"},{"id":2,"user_id":19578,"money":"12.00","pay_type":10,"alipay_name":"","alipay_account":"","bank_name":"","bank_account":"","bank_card":"","apply_status":10,"audit_time":0,"reject_reason":"","wxapp_id":10001,"create_time":"2021-04-13 16:54:00"}]}
         * words : {"index":{"title":{"default":"分销中心","value":"分销中心"},"words":{"not_dealer":{"default":"您还不是分销商，请先提交申请","value":"您还不是分销商，请先提交申请"},"apply_now":{"default":"立即加入","value":"立即加入"},"referee":{"default":"推荐人","value":"推荐人"},"money":{"default":"可提现佣金","value":"可提现"},"freeze_money":{"default":"待提现佣金","value":"待提现"},"total_money":{"default":"已提现金额","value":"已提现金额"},"withdraw":{"default":"去提现","value":"去提现"}}},"apply":{"title":{"default":"申请成为分销商","value":"申请成为分销商"},"words":{"title":{"default":"请填写申请信息","value":"请填写申请信息"},"license":{"default":"分销商申请协议","value":"分销商申请协议"},"submit":{"default":"申请成为经销商","value":"申请成为经销商"},"wait_audit":{"default":"您的申请已受理，正在进行信息核验，请耐心等待。","value":"您的申请已受理，正在进行信息核验，请耐心等待。"},"goto_mall":{"default":"去商城逛逛","value":"去商城逛逛"}}},"order":{"title":{"default":"分销订单","value":"分销订单"},"words":{"all":{"default":"全部","value":"全部"},"unsettled":{"default":"未结算","value":"未结算"},"settled":{"default":"已结算","value":"已结算"}}},"team":{"title":{"default":"我的团队","value":"我的团队"},"words":{"total_team":{"default":"团队总人数","value":"团队总人数"},"first":{"default":"一级团队","value":"一级团队"},"second":{"default":"二级团队","value":"二级团队"},"third":{"default":"三级团队","value":"三级团队"}}},"withdraw_list":{"title":{"default":"提现明细","value":"提现明细"},"words":{"all":{"default":"全部","value":"全部"},"apply_10":{"default":"审核中","value":"审核中"},"apply_20":{"default":"审核通过","value":"审核通过"},"apply_40":{"default":"已打款","value":"已打款"},"apply_30":{"default":"驳回","value":"驳回"}}},"withdraw_apply":{"title":{"default":"申请提现","value":"申请提现"},"words":{"capital":{"default":"可提现佣金","value":"可提现佣金"},"money":{"default":"提现金额","value":"提现金额"},"money_placeholder":{"default":"请输入要提取的金额","value":"请输入要提取的金额"},"min_money":{"default":"最低提现佣金","value":"最低提现佣金"},"submit":{"default":"提交申请","value":"提交申请"}}},"qrcode":{"title":{"default":"推广二维码","value":"推广二维码"}}}
         */
        private String total;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        private ListBean list;
        @SerializedName("words")
        @JsonAdapter(RawStringJsonAdapter.class)
        private String words;

        public ListBean getList() {
            return list;
        }

        public void setList(ListBean list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * total : 2
             * per_page : 15
             * current_page : 1
             * last_page : 1
             * data : [{"id":3,"user_id":19578,"money":"12.00","pay_type":10,"alipay_name":"","alipay_account":"","bank_name":"","bank_account":"","bank_card":"","apply_status":10,"audit_time":0,"reject_reason":"","wxapp_id":10001,"create_time":"2021-04-13 16:55:15"},{"id":2,"user_id":19578,"money":"12.00","pay_type":10,"alipay_name":"","alipay_account":"","bank_name":"","bank_account":"","bank_card":"","apply_status":10,"audit_time":0,"reject_reason":"","wxapp_id":10001,"create_time":"2021-04-13 16:54:00"}]
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
                 * id : 3
                 * user_id : 19578
                 * money : 12.00
                 * pay_type : 10
                 * alipay_name :
                 * alipay_account :
                 * bank_name :
                 * bank_account :
                 * bank_card :
                 * apply_status : 10
                 * audit_time : 0
                 * reject_reason :
                 * wxapp_id : 10001
                 * create_time : 2021-04-13 16:55:15
                 */

                private int id;
                private int user_id;
                private String money;
                private int pay_type;
                private String alipay_name;
                private String alipay_account;
                private String bank_name;
                private String bank_account;
                private String bank_card;
                private int apply_status;
                private int audit_time;
                private String reject_reason;
                private int wxapp_id;
                private String create_time;

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

                public String getMoney() {
                    return money;
                }

                public void setMoney(String money) {
                    this.money = money;
                }

                public int getPay_type() {
                    return pay_type;
                }

                public void setPay_type(int pay_type) {
                    this.pay_type = pay_type;
                }

                public String getAlipay_name() {
                    return alipay_name;
                }

                public void setAlipay_name(String alipay_name) {
                    this.alipay_name = alipay_name;
                }

                public String getAlipay_account() {
                    return alipay_account;
                }

                public void setAlipay_account(String alipay_account) {
                    this.alipay_account = alipay_account;
                }

                public String getBank_name() {
                    return bank_name;
                }

                public void setBank_name(String bank_name) {
                    this.bank_name = bank_name;
                }

                public String getBank_account() {
                    return bank_account;
                }

                public void setBank_account(String bank_account) {
                    this.bank_account = bank_account;
                }

                public String getBank_card() {
                    return bank_card;
                }

                public void setBank_card(String bank_card) {
                    this.bank_card = bank_card;
                }

                public int getApply_status() {
                    return apply_status;
                }

                public void setApply_status(int apply_status) {
                    this.apply_status = apply_status;
                }

                public int getAudit_time() {
                    return audit_time;
                }

                public void setAudit_time(int audit_time) {
                    this.audit_time = audit_time;
                }

                public String getReject_reason() {
                    return reject_reason;
                }

                public void setReject_reason(String reject_reason) {
                    this.reject_reason = reject_reason;
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
            }
        }

        public static class WordsBeanXXXXXX {
            /**
             * index : {"title":{"default":"分销中心","value":"分销中心"},"words":{"not_dealer":{"default":"您还不是分销商，请先提交申请","value":"您还不是分销商，请先提交申请"},"apply_now":{"default":"立即加入","value":"立即加入"},"referee":{"default":"推荐人","value":"推荐人"},"money":{"default":"可提现佣金","value":"可提现"},"freeze_money":{"default":"待提现佣金","value":"待提现"},"total_money":{"default":"已提现金额","value":"已提现金额"},"withdraw":{"default":"去提现","value":"去提现"}}}
             * apply : {"title":{"default":"申请成为分销商","value":"申请成为分销商"},"words":{"title":{"default":"请填写申请信息","value":"请填写申请信息"},"license":{"default":"分销商申请协议","value":"分销商申请协议"},"submit":{"default":"申请成为经销商","value":"申请成为经销商"},"wait_audit":{"default":"您的申请已受理，正在进行信息核验，请耐心等待。","value":"您的申请已受理，正在进行信息核验，请耐心等待。"},"goto_mall":{"default":"去商城逛逛","value":"去商城逛逛"}}}
             * order : {"title":{"default":"分销订单","value":"分销订单"},"words":{"all":{"default":"全部","value":"全部"},"unsettled":{"default":"未结算","value":"未结算"},"settled":{"default":"已结算","value":"已结算"}}}
             * team : {"title":{"default":"我的团队","value":"我的团队"},"words":{"total_team":{"default":"团队总人数","value":"团队总人数"},"first":{"default":"一级团队","value":"一级团队"},"second":{"default":"二级团队","value":"二级团队"},"third":{"default":"三级团队","value":"三级团队"}}}
             * withdraw_list : {"title":{"default":"提现明细","value":"提现明细"},"words":{"all":{"default":"全部","value":"全部"},"apply_10":{"default":"审核中","value":"审核中"},"apply_20":{"default":"审核通过","value":"审核通过"},"apply_40":{"default":"已打款","value":"已打款"},"apply_30":{"default":"驳回","value":"驳回"}}}
             * withdraw_apply : {"title":{"default":"申请提现","value":"申请提现"},"words":{"capital":{"default":"可提现佣金","value":"可提现佣金"},"money":{"default":"提现金额","value":"提现金额"},"money_placeholder":{"default":"请输入要提取的金额","value":"请输入要提取的金额"},"min_money":{"default":"最低提现佣金","value":"最低提现佣金"},"submit":{"default":"提交申请","value":"提交申请"}}}
             * qrcode : {"title":{"default":"推广二维码","value":"推广二维码"}}
             */

            private IndexBean index;
            private ApplyBean apply;
            private OrderBean order;
            private TeamBean team;
            private WithdrawListBean withdraw_list;
            private WithdrawApplyBean withdraw_apply;
            private QrcodeBean qrcode;

            public IndexBean getIndex() {
                return index;
            }

            public void setIndex(IndexBean index) {
                this.index = index;
            }

            public ApplyBean getApply() {
                return apply;
            }

            public void setApply(ApplyBean apply) {
                this.apply = apply;
            }

            public OrderBean getOrder() {
                return order;
            }

            public void setOrder(OrderBean order) {
                this.order = order;
            }

            public TeamBean getTeam() {
                return team;
            }

            public void setTeam(TeamBean team) {
                this.team = team;
            }

            public WithdrawListBean getWithdraw_list() {
                return withdraw_list;
            }

            public void setWithdraw_list(WithdrawListBean withdraw_list) {
                this.withdraw_list = withdraw_list;
            }

            public WithdrawApplyBean getWithdraw_apply() {
                return withdraw_apply;
            }

            public void setWithdraw_apply(WithdrawApplyBean withdraw_apply) {
                this.withdraw_apply = withdraw_apply;
            }

            public QrcodeBean getQrcode() {
                return qrcode;
            }

            public void setQrcode(QrcodeBean qrcode) {
                this.qrcode = qrcode;
            }

            public static class IndexBean {
                /**
                 * title : {"default":"分销中心","value":"分销中心"}
                 * words : {"not_dealer":{"default":"您还不是分销商，请先提交申请","value":"您还不是分销商，请先提交申请"},"apply_now":{"default":"立即加入","value":"立即加入"},"referee":{"default":"推荐人","value":"推荐人"},"money":{"default":"可提现佣金","value":"可提现"},"freeze_money":{"default":"待提现佣金","value":"待提现"},"total_money":{"default":"已提现金额","value":"已提现金额"},"withdraw":{"default":"去提现","value":"去提现"}}
                 */

                private TitleBean title;
                private WordsBean words;

                public TitleBean getTitle() {
                    return title;
                }

                public void setTitle(TitleBean title) {
                    this.title = title;
                }

                public WordsBean getWords() {
                    return words;
                }

                public void setWords(WordsBean words) {
                    this.words = words;
                }

                public static class TitleBean {
                    /**
                     * default : 分销中心
                     * value : 分销中心
                     */

                    @SerializedName("default")
                    private String defaultX;
                    private String value;

                    public String getDefaultX() {
                        return defaultX;
                    }

                    public void setDefaultX(String defaultX) {
                        this.defaultX = defaultX;
                    }

                    public String getValue() {
                        return value;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }
                }

                public static class WordsBean {
                    /**
                     * not_dealer : {"default":"您还不是分销商，请先提交申请","value":"您还不是分销商，请先提交申请"}
                     * apply_now : {"default":"立即加入","value":"立即加入"}
                     * referee : {"default":"推荐人","value":"推荐人"}
                     * money : {"default":"可提现佣金","value":"可提现"}
                     * freeze_money : {"default":"待提现佣金","value":"待提现"}
                     * total_money : {"default":"已提现金额","value":"已提现金额"}
                     * withdraw : {"default":"去提现","value":"去提现"}
                     */

                    private NotDealerBean not_dealer;
                    private ApplyNowBean apply_now;
                    private RefereeBean referee;
                    private MoneyBean money;
                    private FreezeMoneyBean freeze_money;
                    private TotalMoneyBean total_money;
                    private WithdrawBean withdraw;

                    public NotDealerBean getNot_dealer() {
                        return not_dealer;
                    }

                    public void setNot_dealer(NotDealerBean not_dealer) {
                        this.not_dealer = not_dealer;
                    }

                    public ApplyNowBean getApply_now() {
                        return apply_now;
                    }

                    public void setApply_now(ApplyNowBean apply_now) {
                        this.apply_now = apply_now;
                    }

                    public RefereeBean getReferee() {
                        return referee;
                    }

                    public void setReferee(RefereeBean referee) {
                        this.referee = referee;
                    }

                    public MoneyBean getMoney() {
                        return money;
                    }

                    public void setMoney(MoneyBean money) {
                        this.money = money;
                    }

                    public FreezeMoneyBean getFreeze_money() {
                        return freeze_money;
                    }

                    public void setFreeze_money(FreezeMoneyBean freeze_money) {
                        this.freeze_money = freeze_money;
                    }

                    public TotalMoneyBean getTotal_money() {
                        return total_money;
                    }

                    public void setTotal_money(TotalMoneyBean total_money) {
                        this.total_money = total_money;
                    }

                    public WithdrawBean getWithdraw() {
                        return withdraw;
                    }

                    public void setWithdraw(WithdrawBean withdraw) {
                        this.withdraw = withdraw;
                    }

                    public static class NotDealerBean {
                        /**
                         * default : 您还不是分销商，请先提交申请
                         * value : 您还不是分销商，请先提交申请
                         */

                        @SerializedName("default")
                        private String defaultX;
                        private String value;

                        public String getDefaultX() {
                            return defaultX;
                        }

                        public void setDefaultX(String defaultX) {
                            this.defaultX = defaultX;
                        }

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }
                    }

                    public static class ApplyNowBean {
                        /**
                         * default : 立即加入
                         * value : 立即加入
                         */

                        @SerializedName("default")
                        private String defaultX;
                        private String value;

                        public String getDefaultX() {
                            return defaultX;
                        }

                        public void setDefaultX(String defaultX) {
                            this.defaultX = defaultX;
                        }

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }
                    }

                    public static class RefereeBean {
                        /**
                         * default : 推荐人
                         * value : 推荐人
                         */

                        @SerializedName("default")
                        private String defaultX;
                        private String value;

                        public String getDefaultX() {
                            return defaultX;
                        }

                        public void setDefaultX(String defaultX) {
                            this.defaultX = defaultX;
                        }

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }
                    }

                    public static class MoneyBean {
                        /**
                         * default : 可提现佣金
                         * value : 可提现
                         */

                        @SerializedName("default")
                        private String defaultX;
                        private String value;

                        public String getDefaultX() {
                            return defaultX;
                        }

                        public void setDefaultX(String defaultX) {
                            this.defaultX = defaultX;
                        }

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }
                    }

                    public static class FreezeMoneyBean {
                        /**
                         * default : 待提现佣金
                         * value : 待提现
                         */

                        @SerializedName("default")
                        private String defaultX;
                        private String value;

                        public String getDefaultX() {
                            return defaultX;
                        }

                        public void setDefaultX(String defaultX) {
                            this.defaultX = defaultX;
                        }

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }
                    }

                    public static class TotalMoneyBean {
                        /**
                         * default : 已提现金额
                         * value : 已提现金额
                         */

                        @SerializedName("default")
                        private String defaultX;
                        private String value;

                        public String getDefaultX() {
                            return defaultX;
                        }

                        public void setDefaultX(String defaultX) {
                            this.defaultX = defaultX;
                        }

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }
                    }

                    public static class WithdrawBean {
                        /**
                         * default : 去提现
                         * value : 去提现
                         */

                        @SerializedName("default")
                        private String defaultX;
                        private String value;

                        public String getDefaultX() {
                            return defaultX;
                        }

                        public void setDefaultX(String defaultX) {
                            this.defaultX = defaultX;
                        }

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }
                    }
                }
            }

            public static class ApplyBean {
                /**
                 * title : {"default":"申请成为分销商","value":"申请成为分销商"}
                 * words : {"title":{"default":"请填写申请信息","value":"请填写申请信息"},"license":{"default":"分销商申请协议","value":"分销商申请协议"},"submit":{"default":"申请成为经销商","value":"申请成为经销商"},"wait_audit":{"default":"您的申请已受理，正在进行信息核验，请耐心等待。","value":"您的申请已受理，正在进行信息核验，请耐心等待。"},"goto_mall":{"default":"去商城逛逛","value":"去商城逛逛"}}
                 */

                private TitleBeanX title;
                private WordsBeanX words;

                public TitleBeanX getTitle() {
                    return title;
                }

                public void setTitle(TitleBeanX title) {
                    this.title = title;
                }

                public WordsBeanX getWords() {
                    return words;
                }

                public void setWords(WordsBeanX words) {
                    this.words = words;
                }

                public static class TitleBeanX {
                    /**
                     * default : 申请成为分销商
                     * value : 申请成为分销商
                     */

                    @SerializedName("default")
                    private String defaultX;
                    private String value;

                    public String getDefaultX() {
                        return defaultX;
                    }

                    public void setDefaultX(String defaultX) {
                        this.defaultX = defaultX;
                    }

                    public String getValue() {
                        return value;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }
                }

                public static class WordsBeanX {
                    /**
                     * title : {"default":"请填写申请信息","value":"请填写申请信息"}
                     * license : {"default":"分销商申请协议","value":"分销商申请协议"}
                     * submit : {"default":"申请成为经销商","value":"申请成为经销商"}
                     * wait_audit : {"default":"您的申请已受理，正在进行信息核验，请耐心等待。","value":"您的申请已受理，正在进行信息核验，请耐心等待。"}
                     * goto_mall : {"default":"去商城逛逛","value":"去商城逛逛"}
                     */

                    private TitleBeanXX title;
                    private LicenseBean license;
                    private SubmitBean submit;
                    private WaitAuditBean wait_audit;
                    private GotoMallBean goto_mall;

                    public TitleBeanXX getTitle() {
                        return title;
                    }

                    public void setTitle(TitleBeanXX title) {
                        this.title = title;
                    }

                    public LicenseBean getLicense() {
                        return license;
                    }

                    public void setLicense(LicenseBean license) {
                        this.license = license;
                    }

                    public SubmitBean getSubmit() {
                        return submit;
                    }

                    public void setSubmit(SubmitBean submit) {
                        this.submit = submit;
                    }

                    public WaitAuditBean getWait_audit() {
                        return wait_audit;
                    }

                    public void setWait_audit(WaitAuditBean wait_audit) {
                        this.wait_audit = wait_audit;
                    }

                    public GotoMallBean getGoto_mall() {
                        return goto_mall;
                    }

                    public void setGoto_mall(GotoMallBean goto_mall) {
                        this.goto_mall = goto_mall;
                    }

                    public static class TitleBeanXX {
                        /**
                         * default : 请填写申请信息
                         * value : 请填写申请信息
                         */

                        @SerializedName("default")
                        private String defaultX;
                        private String value;

                        public String getDefaultX() {
                            return defaultX;
                        }

                        public void setDefaultX(String defaultX) {
                            this.defaultX = defaultX;
                        }

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }
                    }

                    public static class LicenseBean {
                        /**
                         * default : 分销商申请协议
                         * value : 分销商申请协议
                         */

                        @SerializedName("default")
                        private String defaultX;
                        private String value;

                        public String getDefaultX() {
                            return defaultX;
                        }

                        public void setDefaultX(String defaultX) {
                            this.defaultX = defaultX;
                        }

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }
                    }

                    public static class SubmitBean {
                        /**
                         * default : 申请成为经销商
                         * value : 申请成为经销商
                         */

                        @SerializedName("default")
                        private String defaultX;
                        private String value;

                        public String getDefaultX() {
                            return defaultX;
                        }

                        public void setDefaultX(String defaultX) {
                            this.defaultX = defaultX;
                        }

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }
                    }

                    public static class WaitAuditBean {
                        /**
                         * default : 您的申请已受理，正在进行信息核验，请耐心等待。
                         * value : 您的申请已受理，正在进行信息核验，请耐心等待。
                         */

                        @SerializedName("default")
                        private String defaultX;
                        private String value;

                        public String getDefaultX() {
                            return defaultX;
                        }

                        public void setDefaultX(String defaultX) {
                            this.defaultX = defaultX;
                        }

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }
                    }

                    public static class GotoMallBean {
                        /**
                         * default : 去商城逛逛
                         * value : 去商城逛逛
                         */

                        @SerializedName("default")
                        private String defaultX;
                        private String value;

                        public String getDefaultX() {
                            return defaultX;
                        }

                        public void setDefaultX(String defaultX) {
                            this.defaultX = defaultX;
                        }

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }
                    }
                }
            }

            public static class OrderBean {
                /**
                 * title : {"default":"分销订单","value":"分销订单"}
                 * words : {"all":{"default":"全部","value":"全部"},"unsettled":{"default":"未结算","value":"未结算"},"settled":{"default":"已结算","value":"已结算"}}
                 */

                private TitleBeanXXX title;
                private WordsBeanXX words;

                public TitleBeanXXX getTitle() {
                    return title;
                }

                public void setTitle(TitleBeanXXX title) {
                    this.title = title;
                }

                public WordsBeanXX getWords() {
                    return words;
                }

                public void setWords(WordsBeanXX words) {
                    this.words = words;
                }

                public static class TitleBeanXXX {
                    /**
                     * default : 分销订单
                     * value : 分销订单
                     */

                    @SerializedName("default")
                    private String defaultX;
                    private String value;

                    public String getDefaultX() {
                        return defaultX;
                    }

                    public void setDefaultX(String defaultX) {
                        this.defaultX = defaultX;
                    }

                    public String getValue() {
                        return value;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }
                }

                public static class WordsBeanXX {
                    /**
                     * all : {"default":"全部","value":"全部"}
                     * unsettled : {"default":"未结算","value":"未结算"}
                     * settled : {"default":"已结算","value":"已结算"}
                     */

                    private AllBean all;
                    private UnsettledBean unsettled;
                    private SettledBean settled;

                    public AllBean getAll() {
                        return all;
                    }

                    public void setAll(AllBean all) {
                        this.all = all;
                    }

                    public UnsettledBean getUnsettled() {
                        return unsettled;
                    }

                    public void setUnsettled(UnsettledBean unsettled) {
                        this.unsettled = unsettled;
                    }

                    public SettledBean getSettled() {
                        return settled;
                    }

                    public void setSettled(SettledBean settled) {
                        this.settled = settled;
                    }

                    public static class AllBean {
                        /**
                         * default : 全部
                         * value : 全部
                         */

                        @SerializedName("default")
                        private String defaultX;
                        private String value;

                        public String getDefaultX() {
                            return defaultX;
                        }

                        public void setDefaultX(String defaultX) {
                            this.defaultX = defaultX;
                        }

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }
                    }

                    public static class UnsettledBean {
                        /**
                         * default : 未结算
                         * value : 未结算
                         */

                        @SerializedName("default")
                        private String defaultX;
                        private String value;

                        public String getDefaultX() {
                            return defaultX;
                        }

                        public void setDefaultX(String defaultX) {
                            this.defaultX = defaultX;
                        }

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }
                    }

                    public static class SettledBean {
                        /**
                         * default : 已结算
                         * value : 已结算
                         */

                        @SerializedName("default")
                        private String defaultX;
                        private String value;

                        public String getDefaultX() {
                            return defaultX;
                        }

                        public void setDefaultX(String defaultX) {
                            this.defaultX = defaultX;
                        }

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }
                    }
                }
            }

            public static class TeamBean {
                /**
                 * title : {"default":"我的团队","value":"我的团队"}
                 * words : {"total_team":{"default":"团队总人数","value":"团队总人数"},"first":{"default":"一级团队","value":"一级团队"},"second":{"default":"二级团队","value":"二级团队"},"third":{"default":"三级团队","value":"三级团队"}}
                 */

                private TitleBeanXXXX title;
                private WordsBeanXXX words;

                public TitleBeanXXXX getTitle() {
                    return title;
                }

                public void setTitle(TitleBeanXXXX title) {
                    this.title = title;
                }

                public WordsBeanXXX getWords() {
                    return words;
                }

                public void setWords(WordsBeanXXX words) {
                    this.words = words;
                }

                public static class TitleBeanXXXX {
                    /**
                     * default : 我的团队
                     * value : 我的团队
                     */

                    @SerializedName("default")
                    private String defaultX;
                    private String value;

                    public String getDefaultX() {
                        return defaultX;
                    }

                    public void setDefaultX(String defaultX) {
                        this.defaultX = defaultX;
                    }

                    public String getValue() {
                        return value;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }
                }

                public static class WordsBeanXXX {
                    /**
                     * total_team : {"default":"团队总人数","value":"团队总人数"}
                     * first : {"default":"一级团队","value":"一级团队"}
                     * second : {"default":"二级团队","value":"二级团队"}
                     * third : {"default":"三级团队","value":"三级团队"}
                     */

                    private TotalTeamBean total_team;
                    private FirstBean first;
                    private SecondBean second;
                    private ThirdBean third;

                    public TotalTeamBean getTotal_team() {
                        return total_team;
                    }

                    public void setTotal_team(TotalTeamBean total_team) {
                        this.total_team = total_team;
                    }

                    public FirstBean getFirst() {
                        return first;
                    }

                    public void setFirst(FirstBean first) {
                        this.first = first;
                    }

                    public SecondBean getSecond() {
                        return second;
                    }

                    public void setSecond(SecondBean second) {
                        this.second = second;
                    }

                    public ThirdBean getThird() {
                        return third;
                    }

                    public void setThird(ThirdBean third) {
                        this.third = third;
                    }

                    public static class TotalTeamBean {
                        /**
                         * default : 团队总人数
                         * value : 团队总人数
                         */

                        @SerializedName("default")
                        private String defaultX;
                        private String value;

                        public String getDefaultX() {
                            return defaultX;
                        }

                        public void setDefaultX(String defaultX) {
                            this.defaultX = defaultX;
                        }

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }
                    }

                    public static class FirstBean {
                        /**
                         * default : 一级团队
                         * value : 一级团队
                         */

                        @SerializedName("default")
                        private String defaultX;
                        private String value;

                        public String getDefaultX() {
                            return defaultX;
                        }

                        public void setDefaultX(String defaultX) {
                            this.defaultX = defaultX;
                        }

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }
                    }

                    public static class SecondBean {
                        /**
                         * default : 二级团队
                         * value : 二级团队
                         */

                        @SerializedName("default")
                        private String defaultX;
                        private String value;

                        public String getDefaultX() {
                            return defaultX;
                        }

                        public void setDefaultX(String defaultX) {
                            this.defaultX = defaultX;
                        }

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }
                    }

                    public static class ThirdBean {
                        /**
                         * default : 三级团队
                         * value : 三级团队
                         */

                        @SerializedName("default")
                        private String defaultX;
                        private String value;

                        public String getDefaultX() {
                            return defaultX;
                        }

                        public void setDefaultX(String defaultX) {
                            this.defaultX = defaultX;
                        }

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }
                    }
                }
            }

            public static class WithdrawListBean {
                /**
                 * title : {"default":"提现明细","value":"提现明细"}
                 * words : {"all":{"default":"全部","value":"全部"},"apply_10":{"default":"审核中","value":"审核中"},"apply_20":{"default":"审核通过","value":"审核通过"},"apply_40":{"default":"已打款","value":"已打款"},"apply_30":{"default":"驳回","value":"驳回"}}
                 */

                private TitleBeanXXXXX title;
                private WordsBeanXXXX words;

                public TitleBeanXXXXX getTitle() {
                    return title;
                }

                public void setTitle(TitleBeanXXXXX title) {
                    this.title = title;
                }

                public WordsBeanXXXX getWords() {
                    return words;
                }

                public void setWords(WordsBeanXXXX words) {
                    this.words = words;
                }

                public static class TitleBeanXXXXX {
                    /**
                     * default : 提现明细
                     * value : 提现明细
                     */

                    @SerializedName("default")
                    private String defaultX;
                    private String value;

                    public String getDefaultX() {
                        return defaultX;
                    }

                    public void setDefaultX(String defaultX) {
                        this.defaultX = defaultX;
                    }

                    public String getValue() {
                        return value;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }
                }

                public static class WordsBeanXXXX {
                    /**
                     * all : {"default":"全部","value":"全部"}
                     * apply_10 : {"default":"审核中","value":"审核中"}
                     * apply_20 : {"default":"审核通过","value":"审核通过"}
                     * apply_40 : {"default":"已打款","value":"已打款"}
                     * apply_30 : {"default":"驳回","value":"驳回"}
                     */

                    private AllBeanX all;
                    private Apply10Bean apply_10;
                    private Apply20Bean apply_20;
                    private Apply40Bean apply_40;
                    private Apply30Bean apply_30;

                    public AllBeanX getAll() {
                        return all;
                    }

                    public void setAll(AllBeanX all) {
                        this.all = all;
                    }

                    public Apply10Bean getApply_10() {
                        return apply_10;
                    }

                    public void setApply_10(Apply10Bean apply_10) {
                        this.apply_10 = apply_10;
                    }

                    public Apply20Bean getApply_20() {
                        return apply_20;
                    }

                    public void setApply_20(Apply20Bean apply_20) {
                        this.apply_20 = apply_20;
                    }

                    public Apply40Bean getApply_40() {
                        return apply_40;
                    }

                    public void setApply_40(Apply40Bean apply_40) {
                        this.apply_40 = apply_40;
                    }

                    public Apply30Bean getApply_30() {
                        return apply_30;
                    }

                    public void setApply_30(Apply30Bean apply_30) {
                        this.apply_30 = apply_30;
                    }

                    public static class AllBeanX {
                        /**
                         * default : 全部
                         * value : 全部
                         */

                        @SerializedName("default")
                        private String defaultX;
                        private String value;

                        public String getDefaultX() {
                            return defaultX;
                        }

                        public void setDefaultX(String defaultX) {
                            this.defaultX = defaultX;
                        }

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }
                    }

                    public static class Apply10Bean {
                        /**
                         * default : 审核中
                         * value : 审核中
                         */

                        @SerializedName("default")
                        private String defaultX;
                        private String value;

                        public String getDefaultX() {
                            return defaultX;
                        }

                        public void setDefaultX(String defaultX) {
                            this.defaultX = defaultX;
                        }

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }
                    }

                    public static class Apply20Bean {
                        /**
                         * default : 审核通过
                         * value : 审核通过
                         */

                        @SerializedName("default")
                        private String defaultX;
                        private String value;

                        public String getDefaultX() {
                            return defaultX;
                        }

                        public void setDefaultX(String defaultX) {
                            this.defaultX = defaultX;
                        }

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }
                    }

                    public static class Apply40Bean {
                        /**
                         * default : 已打款
                         * value : 已打款
                         */

                        @SerializedName("default")
                        private String defaultX;
                        private String value;

                        public String getDefaultX() {
                            return defaultX;
                        }

                        public void setDefaultX(String defaultX) {
                            this.defaultX = defaultX;
                        }

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }
                    }

                    public static class Apply30Bean {
                        /**
                         * default : 驳回
                         * value : 驳回
                         */

                        @SerializedName("default")
                        private String defaultX;
                        private String value;

                        public String getDefaultX() {
                            return defaultX;
                        }

                        public void setDefaultX(String defaultX) {
                            this.defaultX = defaultX;
                        }

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }
                    }
                }
            }

            public static class WithdrawApplyBean {
                /**
                 * title : {"default":"申请提现","value":"申请提现"}
                 * words : {"capital":{"default":"可提现佣金","value":"可提现佣金"},"money":{"default":"提现金额","value":"提现金额"},"money_placeholder":{"default":"请输入要提取的金额","value":"请输入要提取的金额"},"min_money":{"default":"最低提现佣金","value":"最低提现佣金"},"submit":{"default":"提交申请","value":"提交申请"}}
                 */

                private TitleBeanXXXXXX title;
                private WordsBeanXXXXX words;

                public TitleBeanXXXXXX getTitle() {
                    return title;
                }

                public void setTitle(TitleBeanXXXXXX title) {
                    this.title = title;
                }

                public WordsBeanXXXXX getWords() {
                    return words;
                }

                public void setWords(WordsBeanXXXXX words) {
                    this.words = words;
                }

                public static class TitleBeanXXXXXX {
                    /**
                     * default : 申请提现
                     * value : 申请提现
                     */

                    @SerializedName("default")
                    private String defaultX;
                    private String value;

                    public String getDefaultX() {
                        return defaultX;
                    }

                    public void setDefaultX(String defaultX) {
                        this.defaultX = defaultX;
                    }

                    public String getValue() {
                        return value;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }
                }

                public static class WordsBeanXXXXX {
                    /**
                     * capital : {"default":"可提现佣金","value":"可提现佣金"}
                     * money : {"default":"提现金额","value":"提现金额"}
                     * money_placeholder : {"default":"请输入要提取的金额","value":"请输入要提取的金额"}
                     * min_money : {"default":"最低提现佣金","value":"最低提现佣金"}
                     * submit : {"default":"提交申请","value":"提交申请"}
                     */

                    private CapitalBean capital;
                    private MoneyBeanX money;
                    private MoneyPlaceholderBean money_placeholder;
                    private MinMoneyBean min_money;
                    private SubmitBeanX submit;

                    public CapitalBean getCapital() {
                        return capital;
                    }

                    public void setCapital(CapitalBean capital) {
                        this.capital = capital;
                    }

                    public MoneyBeanX getMoney() {
                        return money;
                    }

                    public void setMoney(MoneyBeanX money) {
                        this.money = money;
                    }

                    public MoneyPlaceholderBean getMoney_placeholder() {
                        return money_placeholder;
                    }

                    public void setMoney_placeholder(MoneyPlaceholderBean money_placeholder) {
                        this.money_placeholder = money_placeholder;
                    }

                    public MinMoneyBean getMin_money() {
                        return min_money;
                    }

                    public void setMin_money(MinMoneyBean min_money) {
                        this.min_money = min_money;
                    }

                    public SubmitBeanX getSubmit() {
                        return submit;
                    }

                    public void setSubmit(SubmitBeanX submit) {
                        this.submit = submit;
                    }

                    public static class CapitalBean {
                        /**
                         * default : 可提现佣金
                         * value : 可提现佣金
                         */

                        @SerializedName("default")
                        private String defaultX;
                        private String value;

                        public String getDefaultX() {
                            return defaultX;
                        }

                        public void setDefaultX(String defaultX) {
                            this.defaultX = defaultX;
                        }

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }
                    }

                    public static class MoneyBeanX {
                        /**
                         * default : 提现金额
                         * value : 提现金额
                         */

                        @SerializedName("default")
                        private String defaultX;
                        private String value;

                        public String getDefaultX() {
                            return defaultX;
                        }

                        public void setDefaultX(String defaultX) {
                            this.defaultX = defaultX;
                        }

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }
                    }

                    public static class MoneyPlaceholderBean {
                        /**
                         * default : 请输入要提取的金额
                         * value : 请输入要提取的金额
                         */

                        @SerializedName("default")
                        private String defaultX;
                        private String value;

                        public String getDefaultX() {
                            return defaultX;
                        }

                        public void setDefaultX(String defaultX) {
                            this.defaultX = defaultX;
                        }

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }
                    }

                    public static class MinMoneyBean {
                        /**
                         * default : 最低提现佣金
                         * value : 最低提现佣金
                         */

                        @SerializedName("default")
                        private String defaultX;
                        private String value;

                        public String getDefaultX() {
                            return defaultX;
                        }

                        public void setDefaultX(String defaultX) {
                            this.defaultX = defaultX;
                        }

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }
                    }

                    public static class SubmitBeanX {
                        /**
                         * default : 提交申请
                         * value : 提交申请
                         */

                        @SerializedName("default")
                        private String defaultX;
                        private String value;

                        public String getDefaultX() {
                            return defaultX;
                        }

                        public void setDefaultX(String defaultX) {
                            this.defaultX = defaultX;
                        }

                        public String getValue() {
                            return value;
                        }

                        public void setValue(String value) {
                            this.value = value;
                        }
                    }
                }
            }

            public static class QrcodeBean {
                /**
                 * title : {"default":"推广二维码","value":"推广二维码"}
                 */

                private TitleBeanXXXXXXX title;

                public TitleBeanXXXXXXX getTitle() {
                    return title;
                }

                public void setTitle(TitleBeanXXXXXXX title) {
                    this.title = title;
                }

                public static class TitleBeanXXXXXXX {
                    /**
                     * default : 推广二维码
                     * value : 推广二维码
                     */

                    @SerializedName("default")
                    private String defaultX;
                    private String value;

                    public String getDefaultX() {
                        return defaultX;
                    }

                    public void setDefaultX(String defaultX) {
                        this.defaultX = defaultX;
                    }

                    public String getValue() {
                        return value;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }
                }
            }
        }
    }
}
