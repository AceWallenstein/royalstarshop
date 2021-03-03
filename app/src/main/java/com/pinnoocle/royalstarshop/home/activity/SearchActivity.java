package com.pinnoocle.royalstarshop.home.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.library.AutoFlowLayout;
import com.example.library.FlowAdapter;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.MainActivity;
import com.pinnoocle.royalstarshop.MyApp;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.GoodsListsModel;
import com.pinnoocle.royalstarshop.bean.HistoryBean;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.LoginModel;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.greendao.HistoryBeanDao;
import com.pinnoocle.royalstarshop.login.LoginActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity implements AutoFlowLayout.OnItemClickListener {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_search)
    TextView tvSearch;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.et_home_search)
    EditText etHomeSearch;
    @BindView(R.id.iv_close)
    ImageView ivClose;
    @BindView(R.id.rl_history)
    RelativeLayout rlHistory;
    @BindView(R.id.flow_layout)
    AutoFlowLayout flowLayout;
    @BindView(R.id.iv_delete)
    ImageView ivDelete;
    @BindView(R.id.tv_hint)
    TextView tvHint;
    @BindView(R.id.ll_history)
    LinearLayout llHistory;
    @BindView(R.id.tv_composite)
    TextView tvComposite;
    @BindView(R.id.iv_sort_composite)
    ImageView ivSortComposite;
    @BindView(R.id.rl_composite)
    RelativeLayout rlComposite;
    @BindView(R.id.tv_sales)
    TextView tvSales;
    @BindView(R.id.iv_sort_sales_top)
    ImageView ivSortSalesTop;
    @BindView(R.id.iv_sort_sales_down)
    ImageView ivSortSalesDown;
    @BindView(R.id.rl_sales)
    RelativeLayout rlSales;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.iv_sort_price_top)
    ImageView ivSortPriceTop;
    @BindView(R.id.iv_sort_price_down)
    ImageView ivSortPriceDown;
    @BindView(R.id.rl_price)
    RelativeLayout rlPrice;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    private List<HistoryBean> historyList = new ArrayList<>();
    private boolean countFlag = false;
    private boolean priceFlag = false;
    TextView[] pageIds;
    private int currentPage;
    private DataRepository dataRepository;
    private String search = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        initView();
        initData();
    }



    private void initView() {
        pageIds   = new TextView[]{tvComposite, tvSales, tvPrice};
        historyList = MyApp.getInstance().getDaoSession().getHistoryBeanDao().queryBuilder().orderDesc(HistoryBeanDao.Properties.Id).list();
        if (historyList != null && historyList.size() > 0) {
            flowLayout.setVisibility(View.VISIBLE);
            ivDelete.setVisibility(View.VISIBLE);
            tvHint.setVisibility(View.GONE);
            flowLayout.setAdapter(new FlowAdapter(historyList) {
                @Override
                public View getView(int position) {
                    View item = LayoutInflater.from(SearchActivity.this).inflate(R.layout.special_item, null);
                    TextView tvAttrTag = (TextView) item.findViewById(R.id.tv_attr_tag);
                    tvAttrTag.setText(historyList.get(position).getName());
                    return item;
                }
            });
        }
        flowLayout.setOnItemClickListener(this);

        etHomeSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() > 0) {
                    ivClose.setVisibility(View.VISIBLE);
                } else {
                    ivClose.setVisibility(View.GONE);
                }
            }
        });
    }
    private void initData() {
        dataRepository = Injection.dataRepository(this);
        switchPage(0);
        goodsLists();
    }

    private void goodsLists() {
        ViewLoading.show(this);
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.search = search;
        loginBean.tag = "";
        dataRepository.goodsLists(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(SearchActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(SearchActivity.this);
                GoodsListsModel goodsListsModel = (GoodsListsModel) data;
//                if(goodsListsModel.getCode() == 1){
//                }
            }
        });
    }

    private void switchPage(int page) {

        if (page == 0) {
//            EventBus.getDefault().post(new ComprehensiveEvent());
            setSortViewStatus(ivSortComposite, R.mipmap.sort_down_red);

        } else if (page == 1) {
            countFlag = !countFlag;
            if (countFlag) {
                setSortViewStatus(ivSortSalesTop, R.mipmap.sort_top_red);
            } else {
                setSortViewStatus(ivSortSalesDown, R.mipmap.sort_down_red);
            }
//            EventBus.getDefault().post(new BuyCountSortEvent(countFlag));

        } else if (page == 2) {
            priceFlag = !priceFlag;
            if (priceFlag) {
                setSortViewStatus(ivSortPriceTop, R.mipmap.sort_top_red);
            } else {
                setSortViewStatus(ivSortPriceDown, R.mipmap.sort_down_red);
            }
//            EventBus.getDefault().post(new PriceSortEvent(priceFlag));

        }
        for (int i = 0; i < pageIds.length; i++) {
            if (i == page) {
                pageIds[i].setTextColor(getResources().getColor(R.color.light_red));
            } else {
                pageIds[i].setTextColor(getResources().getColor(R.color.black_3));
            }

        }
        currentPage = page;
    }

    private void setSortViewStatus(ImageView imageView, int res) {
        ivSortComposite.setImageResource(R.mipmap.sort_down);
        ivSortPriceTop.setImageResource(R.mipmap.sort_top);
        ivSortPriceDown.setImageResource(R.mipmap.sort_down);
        ivSortSalesTop.setImageResource(R.mipmap.sort_top);
        ivSortSalesDown.setImageResource(R.mipmap.sort_down);

        imageView.setImageResource(res);
    }


    @OnClick({R.id.iv_back, R.id.tv_search, R.id.iv_close, R.id.iv_delete, R.id.rl_composite, R.id.rl_sales, R.id.rl_price})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_search:
                if (etHomeSearch.getText().toString().equals("")) {
                    ToastUtils.showToast("搜索内容不能为空");
                } else {
                    ((InputMethodManager) etHomeSearch.getContext().getSystemService(Context.INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(
                                    getCurrentFocus().getWindowToken(),
                                    InputMethodManager.HIDE_NOT_ALWAYS);
                    MyApp.getInstance().getDaoSession().getHistoryBeanDao().queryBuilder().where(HistoryBeanDao.Properties.Name.eq(etHomeSearch.getText().toString())).buildDelete().executeDeleteWithoutDetachingEntities();
                    HistoryBean history = new HistoryBean();
                    history.setName(etHomeSearch.getText().toString());
                    MyApp.getInstance().getDaoSession().getHistoryBeanDao().insert(history);
                    llHistory.setVisibility(View.GONE);
                }
                break;
            case R.id.iv_close:
                etHomeSearch.setText("");
                break;
            case R.id.iv_delete:
                MyApp.getInstance().getDaoSession().getHistoryBeanDao().deleteAll();
                flowLayout.clearViews();
                tvHint.setVisibility(View.VISIBLE);
                flowLayout.setVisibility(View.GONE);
                ivDelete.setVisibility(View.GONE);
                break;
            case R.id.rl_composite:
                switchPage(0);
                break;
            case R.id.rl_sales:
                switchPage(1);
                break;
            case R.id.rl_price:
                switchPage(2);
                break;
        }
    }

    @Override
    public void onItemClick(int i, View view) {
        etHomeSearch.setText(historyList.get(i).getName());
        MyApp.getInstance().getDaoSession().getHistoryBeanDao().queryBuilder().where(HistoryBeanDao.Properties.Name.eq(etHomeSearch.getText().toString())).buildDelete().executeDeleteWithoutDetachingEntities();
        HistoryBean history = new HistoryBean();
        history.setName(etHomeSearch.getText().toString());
        MyApp.getInstance().getDaoSession().getHistoryBeanDao().insert(history);
        llHistory.setVisibility(View.GONE);
    }
}