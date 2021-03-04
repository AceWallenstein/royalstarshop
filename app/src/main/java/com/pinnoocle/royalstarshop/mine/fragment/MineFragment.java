package com.pinnoocle.royalstarshop.mine.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.common.BaseFragment;
import com.pinnoocle.royalstarshop.mine.activity.AddressActivity;
import com.pinnoocle.royalstarshop.vip.VipRenewActivity;
import com.pinnoocle.royalstarshop.widget.RoundImageView;
import com.pinnoocle.royalstarshop.widget.TagsGridView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

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

    @Override
    protected int LayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {
        grid();
        gridMyService();
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

                        break;
                    case 1: //待付款

                        break;
                    case 2: //待发货

                        break;
                    case 3: //待评价

                        break;
                    case 4: //退换
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

                break;
            case 1: //提现

                break;
            case 2: //我的金豆

                break;
            case 3: //我的收藏

                break;
            case 4: //收货地址
                startActivity(new Intent(getContext(), AddressActivity.class));
                break;
            case 5: //我的客服
                break;
            case 6: //评价
                break;
            case 7: //常见问题
                break;
            case 8: //意见反馈
                break;
            default:
                break;
        }
    }

    @OnClick({R.id.iv_setting, R.id.iv_sign_in})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_setting:
                Intent intent = new Intent(getContext(), SettingActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_sign_in:
                break;
        }
    }
}
