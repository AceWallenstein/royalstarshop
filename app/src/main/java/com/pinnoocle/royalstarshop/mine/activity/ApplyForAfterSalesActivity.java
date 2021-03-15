package com.pinnoocle.royalstarshop.mine.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.widget.GridViewInScrollView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ApplyForAfterSalesActivity extends BaseActivity {
    @BindView(R.id.iv_bg)
    ImageView ivBg;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_exchange_goods)
    TextView tvExchangeGoods;
    @BindView(R.id.tv_return_goods)
    TextView tvReturnGoods;
    @BindView(R.id.rl_address)
    RelativeLayout rlAddress;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.ll_tips)
    LinearLayout llTips;
    @BindView(R.id.tv_reason)
    TextView tvReason;
    @BindView(R.id.ed_advise)
    EditText edAdvise;
    @BindView(R.id.gridView)
    GridViewInScrollView gridView;
    @BindView(R.id.tv_text_num)
    TextView tvTextNum;
    @BindView(R.id.iv_no_question)
    ImageView ivNoQuestion;
    @BindView(R.id.tv_no_question)
    TextView tvNoQuestion;
    @BindView(R.id.rl_2)
    RelativeLayout rl2;
    @BindView(R.id.tv_sure)
    TextView tvSure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initRed();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_for_aftersales);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        selectType(tvExchangeGoods);
    }

    private void initData() {

    }


    private void selectType(TextView textView) {
        tvExchangeGoods.setTextColor(getResources().getColor(R.color.black_3));
        tvReturnGoods.setTextColor(getResources().getColor(R.color.black_3));
        tvExchangeGoods.setBackground(getResources().getDrawable(R.drawable.bg_stroke_17));
        tvReturnGoods.setBackground(getResources().getDrawable(R.drawable.bg_stroke_17));

        textView.setTextColor(getResources().getColor(R.color.light_red_2));
        textView.setBackground(getResources().getDrawable(R.drawable.bg_red_stroke_17));

    }

    @OnClick({R.id.iv_back, R.id.tv_exchange_goods, R.id.tv_return_goods, R.id.tv_sure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_exchange_goods:
                selectType(tvExchangeGoods);
                break;
            case R.id.tv_return_goods:
                selectType(tvReturnGoods);

                break;
            case R.id.tv_sure:
                break;
        }
    }
}
