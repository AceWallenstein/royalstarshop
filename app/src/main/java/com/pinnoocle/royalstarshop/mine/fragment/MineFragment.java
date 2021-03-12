package com.pinnoocle.royalstarshop.mine.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;

import com.bumptech.glide.Glide;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.UserDetailModel;
import com.pinnoocle.royalstarshop.common.BaseFragment;
import com.pinnoocle.royalstarshop.mine.activity.AddressActivity;
import com.pinnoocle.royalstarshop.mine.activity.AfterSalesListActivity;
import com.pinnoocle.royalstarshop.mine.activity.CollectionActivity;
import com.pinnoocle.royalstarshop.mine.activity.CommonProblemActivity;
import com.pinnoocle.royalstarshop.mine.activity.GoldenBeanActivity;
import com.pinnoocle.royalstarshop.mine.activity.OrderActivity;
import com.pinnoocle.royalstarshop.mine.activity.PersonalActivity;
import com.pinnoocle.royalstarshop.mine.activity.QuestionFeedbackActivity;
import com.pinnoocle.royalstarshop.mine.activity.RecommendedIncomeActivity;
import com.pinnoocle.royalstarshop.mine.activity.ScanListActivity;
import com.pinnoocle.royalstarshop.mine.activity.SettingActivity;
import com.pinnoocle.royalstarshop.mine.activity.WithdrawalActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.pinnoocle.royalstarshop.widget.RoundImageView;
import com.pinnoocle.royalstarshop.widget.TagsGridView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class MineFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_avater)
    RoundImageView ivAvater;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.iv_setting)
    ImageView ivSetting;
    @BindView(R.id.iv_sign_in)
    ImageView ivSignIn;
    @BindView(R.id.rl_person_info)
    RelativeLayout rlPersonInfo;
    @BindView(R.id.tv_recommended_revenue)
    TextView tvRecommendedRevenue;
    @BindView(R.id.ll_recommended_revenue)
    LinearLayout llRecommendedRevenue;
    @BindView(R.id.tv_golden_bean)
    TextView tvGoldenBean;
    @BindView(R.id.ll_golden_bean)
    LinearLayout llGoldenBean;
    @BindView(R.id.tv_history)
    TextView tvHistory;
    @BindView(R.id.ll_history)
    LinearLayout llHistory;
    @BindView(R.id.ll_1)
    LinearLayout ll1;
    @BindView(R.id.tv_vip_1)
    TextView tvVip1;
    @BindView(R.id.tv_vip_2)
    TextView tvVip2;
    @BindView(R.id.tv_all_order)
    TextView tvAllOrder;
    @BindView(R.id.gridView)
    TagsGridView gridView;
    @BindView(R.id.iv_award)
    ImageView ivAward;
    @BindView(R.id.grid_service)
    TagsGridView gridService;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    @BindView(R.id.iv_header)
    ImageView ivHeader;
    @BindView(R.id.tv_vip_3)
    TextView tvVip3;
    @BindView(R.id.nestedScrollView)
    NestedScrollView nestedScrollView;
    @BindView(R.id.tv_balance)
    TextView tvBalance;
    @BindView(R.id.tv_points)
    TextView tvPoints;
    @BindView(R.id.tv_footprint)
    TextView tvFootprint;
    @BindView(R.id.tv_vip_4)
    TextView tvVip4;
    @BindView(R.id.iv_crown)
    ImageView ivCrown;
    @BindView(R.id.rl_avatar)
    RelativeLayout rlAvatar;
    @BindView(R.id.iv_avater1)
    RoundImageView ivAvater1;
    @BindView(R.id.rl_avatar1)
    RelativeLayout rlAvatar1;
    @BindView(R.id.iv_vip)
    ImageView ivVip;

    private int[] icon = {R.mipmap.order, R.mipmap.to_be_paid, R.mipmap.to_be_delivered, R.mipmap.to_be_evaluated, R.mipmap.after_sells
    };
    private String[] iconName = {"全部订单", "待付款", "待发货", "待评价", "退换/售后"};


    private int[] serviceIcon = {R.mipmap.profit, R.mipmap.withdrawal, R.mipmap.jin_dou, R.mipmap.mark, R.mipmap.gps, R.mipmap.ic_kefu, R.mipmap.flower, R.mipmap.question
            , R.mipmap.advise
    };
    private String[] serviceIconName = {"推荐收益", "提现", "我的金豆", "我的收藏", "收货地址", "我的客服", "评价", "常见问题", "意见反馈"};

    private SimpleAdapter sim_adapter;
    private List<Map<String, Object>> data_list;
    private List<Map<String, Object>> serviceDataList;
    private float mOffset;
    private float mScrollY;
    private DataRepository dataRepository;
    private UserDetailModel userDetailModel;
    private ImageView iv_ali_mark, iv_wx_mark;
    private String pay_mode = "";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {
        dataRepository = Injection.dataRepository(getContext());
        refresh.setOnMultiPurposeListener(new OnMultiPurposeListener() {
            @Override
            public void onHeaderMoving(RefreshHeader header, boolean isDragging, float percent, int offset, int headerHeight, int maxDragHeight) {
                mOffset = offset;
                ivHeader.setTranslationY(mOffset - mScrollY);
            }

            @Override
            public void onHeaderReleased(RefreshHeader header, int headerHeight, int maxDragHeight) {

            }

            @Override
            public void onHeaderStartAnimator(RefreshHeader header, int headerHeight, int maxDragHeight) {

            }

            @Override
            public void onHeaderFinish(RefreshHeader header, boolean success) {
                refresh.finishRefresh();
            }

            @Override
            public void onFooterMoving(RefreshFooter footer, boolean isDragging, float percent, int offset, int footerHeight, int maxDragHeight) {

            }

            @Override
            public void onFooterReleased(RefreshFooter footer, int footerHeight, int maxDragHeight) {

            }

            @Override
            public void onFooterStartAnimator(RefreshFooter footer, int footerHeight, int maxDragHeight) {

            }

            @Override
            public void onFooterFinish(RefreshFooter footer, boolean success) {

            }

            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                userInfo();
            }

            @Override
            public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {

            }
        });

        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                ivHeader.setTranslationY(-scrollY);
            }
        });
        grid();
        gridMyService();

        userInfo();
    }

    private void userInfo() {
        LoginBean loginBean = new LoginBean();
        loginBean.token = FastData.getToken();
        loginBean.wxapp_id = "10001";
        dataRepository.userDetail(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {

            }

            @Override
            public void onSuccess(Object data) {
                refresh.finishRefresh();
                userDetailModel = (UserDetailModel) data;
                if (userDetailModel.getCode() == 1) {
                    if (TextUtils.isEmpty(userDetailModel.getData().getUserInfo().getAvatarUrl())) {
                        ivAvater.setImageResource(R.drawable.default_avatar);
                        ivAvater1.setImageResource(R.drawable.default_avatar);
                    } else {
                        Glide.with(getActivity()).load(userDetailModel.getData().getUserInfo().getAvatarUrl()).into(ivAvater);
                        Glide.with(getActivity()).load(userDetailModel.getData().getUserInfo().getAvatarUrl()).into(ivAvater1);
                    }
                    tvName.setText(userDetailModel.getData().getUserInfo().getNickName());
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < userDetailModel.getData().getUserInfo().getPhone().length(); i++) {
                        char c = userDetailModel.getData().getUserInfo().getPhone().charAt(i);
                        if (i >= 3 && i <= 6) {
                            sb.append('*');
                        } else {
                            sb.append(c);
                        }
                    }
                    tvPhone.setText(sb.toString());
                    tvBalance.setText(userDetailModel.getData().getUserInfo().getMoney());
                    tvPoints.setText(userDetailModel.getData().getUserInfo().getPoints() + "");
                    tvFootprint.setText(userDetailModel.getData().getUserInfo().getSan_num());
                    if (userDetailModel.getData().getUserInfo().getIsVip() == 1) {
                        rlAvatar.setVisibility(View.VISIBLE);
                        ivAvater1.setVisibility(View.GONE);
                        ivCrown.setVisibility(View.VISIBLE);
                        tvVip3.setText("尊享会员");
                        tvVip4.setText("专属特权 超值返豆");
                        if (userDetailModel.getData().getUserInfo().getIs_exprire() == 1) {
                            tvVip2.setText("立即续费");
                            tvVip2.setVisibility(View.VISIBLE);
                        } else {
                            tvVip2.setVisibility(View.GONE);
                        }
                        ivVip.setVisibility(View.VISIBLE);
                    } else {
                        ivVip.setVisibility(View.GONE);
                        rlAvatar.setVisibility(View.GONE);
                        ivAvater1.setVisibility(View.VISIBLE);
                        tvVip3.setText("开通会员");
                        tvVip4.setText("超值权益 等你来享");
                        tvVip2.setText("立即开通");
                    }
                }
            }
        });
    }

    private void grid() {
        data_list = new ArrayList<>();
        //获取数据
        getData();
        //新建适配器
        String[] from = {"image", "text"};
        int[] to = {R.id.image, R.id.text};
        sim_adapter = new SimpleAdapter(getContext(), data_list, R.layout.grid_item_order, from, to);
        //配置适配器
        gridView.setAdapter(sim_adapter);
        gridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: //全部
                        startActivity(new Intent(getContext(), OrderActivity.class));
                        break;
                    case 1: //待付款
                        Intent intent1 = new Intent(getContext(), OrderActivity.class);
                        intent1.putExtra("type", 1);
                        startActivity(intent1);
                        break;
                    case 2: //待发货
                        Intent intent2 = new Intent(getContext(), OrderActivity.class);
                        intent2.putExtra("type", 2);
                        startActivity(intent2);
                        break;
                    case 3: //待评价
                        Intent intent3 = new Intent(getContext(), OrderActivity.class);
                        intent3.putExtra("type", 4);
                        startActivity(intent3);
                        break;
                    case 4: //退换
                        startActivity(new Intent(getContext(), AfterSalesListActivity.class));
                        break;
                    default:
                        break;
                }
            }
        });
    }

    public List<Map<String, Object>> getData() {
        //cion和iconName的长度是相同的，这里任选其一都可以
        for (int i = 0; i < icon.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }
        return data_list;
    }

    private void gridMyService() {
        serviceDataList = new ArrayList<>();
        //获取数据
        getServiceData();
        //新建适配器
        String[] from = {"image", "text"};
        int[] to = {R.id.image, R.id.text};
        sim_adapter = new SimpleAdapter(getContext(), serviceDataList, R.layout.grid_item_service, from, to);
        //配置适配器
        gridService.setAdapter(sim_adapter);
        gridService.setSelector(new ColorDrawable(Color.TRANSPARENT));
        gridService.setOnItemClickListener(this);
    }

    public List<Map<String, Object>> getServiceData() {
        //cion和iconName的长度是相同的，这里任选其一都可以
        for (int i = 0; i < serviceIcon.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", serviceIcon[i]);
            map.put("text", serviceIconName[i]);
            serviceDataList.add(map);
        }
        return serviceDataList;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0: //推荐收益
                if (userDetailModel.getData().getUserInfo().getIsVip() == 1) {
                    Intent intent1 = new Intent(getContext(), RecommendedIncomeActivity.class);
                    startActivity(intent1);
                } else {
                    ToastUtils.showToast("会员可查看");
                }
                break;
            case 1: //提现
                startActivity(new Intent(getContext(), WithdrawalActivity.class));
                break;
            case 2: //我的金豆
                startActivity(new Intent(getContext(), GoldenBeanActivity.class));
                break;
            case 3: //我的收藏
                startActivity(new Intent(getContext(), CollectionActivity.class));
                break;
            case 4: //收货地址
                startActivity(new Intent(getContext(), AddressActivity.class));
                break;
            case 5: //我的客服
                break;
            case 6: //评价
                break;
            case 7: //常见问题
                startActivity(new Intent(getContext(), CommonProblemActivity.class));
                break;
            case 8: //意见反馈
                startActivity(new Intent(getContext(), QuestionFeedbackActivity.class));
                break;
            default:
                break;
        }
    }

    @OnClick({R.id.rl_avatar, R.id.iv_avater1, R.id.iv_setting, R.id.iv_sign_in, R.id.ll_recommended_revenue, R.id.ll_golden_bean, R.id.tv_all_order, R.id.ll_history, R.id.tv_vip_2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_avatar:
            case R.id.iv_avater1:
                startActivity(new Intent(getContext(), PersonalActivity.class));
                break;
            case R.id.iv_setting:
                Intent intent = new Intent(getContext(), SettingActivity.class);
                intent.putExtra("phone", tvPhone.getText().toString());
                startActivity(intent);
                break;
            case R.id.iv_sign_in:
                break;
            case R.id.ll_recommended_revenue:
                if (userDetailModel.getData().getUserInfo().getIsVip() == 1) {
                    Intent intent1 = new Intent(getContext(), RecommendedIncomeActivity.class);
                    startActivity(intent1);
                } else {
                    ToastUtils.showToast("会员可查看");
                }
                break;
            case R.id.ll_golden_bean:
                Intent intent1 = new Intent(getContext(), GoldenBeanActivity.class);
                intent1.putExtra("golden", userDetailModel.getData().getUserInfo().getPoints() + "");
                startActivity(intent1);
                break;
            case R.id.tv_all_order:
                startActivity(new Intent(getContext(), OrderActivity.class));
                break;
            case R.id.ll_history:
                startActivity(new Intent(getContext(), ScanListActivity.class));
                break;
            case R.id.tv_vip_2:
                EventBus.getDefault().post("5");
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //在ui线程执行，优先级为100
    public void onEvent(String event) {
        if (event.equals("4")) {
            userInfo();
        }
    }
}
