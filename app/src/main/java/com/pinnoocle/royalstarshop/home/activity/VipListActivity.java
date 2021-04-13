package com.pinnoocle.royalstarshop.home.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.MyApp;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.GoodsAdapter;
import com.pinnoocle.royalstarshop.adapter.VipGoodsAdapter;
import com.pinnoocle.royalstarshop.bean.CartAddModel;
import com.pinnoocle.royalstarshop.bean.GoodsListsModel;
import com.pinnoocle.royalstarshop.bean.HistoryBean;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.common.BaseAdapter;
import com.pinnoocle.royalstarshop.event.ShopCartRefreshEvent;
import com.pinnoocle.royalstarshop.greendao.HistoryBeanDao;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VipListActivity extends BaseActivity implements OnRefreshLoadMoreListener {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.et_home_search)
    EditText etHomeSearch;
    @BindView(R.id.iv_close)
    ImageView ivClose;
    @BindView(R.id.tv_search)
    TextView tvSearch;
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
    @BindView(R.id.iv_empty)
    ImageView ivEmpty;
    @BindView(R.id.rl_empty)
    RelativeLayout rlEmpty;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
    private String search = "";

    TextView[] pageIds;
    private DataRepository dataRepository;
    private GoodsAdapter goodsAdapter;
    private int page = 1;
    private List<GoodsListsModel.DataBeanX.ListBean.DataBean> dataBeanList = new ArrayList<>();
    private String sortType = "all";
    private String orderType = "asc ";
    private boolean countFlag = false;
    private boolean priceFlag = false;
    private int currentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vip_list);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        pageIds = new TextView[]{tvComposite, tvSales, tvPrice};
        recycleView.setLayoutManager(new GridLayoutManager(mContext, 2));
        goodsAdapter = new GoodsAdapter(mContext);
        recycleView.setAdapter(goodsAdapter);
        refresh.setOnRefreshLoadMoreListener(this);
        goodsAdapter.setOnItemDataClickListener(new BaseAdapter.OnItemDataClickListener<GoodsListsModel.DataBeanX.ListBean.DataBean>() {
            @Override
            public void onItemViewClick(View view, int position, GoodsListsModel.DataBeanX.ListBean.DataBean o) {
                switch (view.getId()) {
                    case R.id.iv_shop_car:
                        cartAdd(o.getGoods_id(), o.getGoods_sku().getGoods_sku_id(), 1);
                        break;
                    default:
                        Intent intent = new Intent(mContext, GoodsDetailActivity.class);
                        intent.putExtra("goods_id", o.getGoods_id() + "");
                        startActivity(intent);
                        break;
                }
            }
        });

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

        etHomeSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEARCH) {
                    ((InputMethodManager) etHomeSearch.getContext().getSystemService(Context.INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(
                                    getWindow().getDecorView().getWindowToken(),
                                    InputMethodManager.HIDE_NOT_ALWAYS);
//                    if (etHomeSearch.getText().toString().equals("")) {
//                        ToastUtils.showToast("搜索内容不能为空");
//                    } else {
                        ((InputMethodManager) etHomeSearch.getContext().getSystemService(Context.INPUT_METHOD_SERVICE))
                                .hideSoftInputFromWindow(
                                        getWindow().getDecorView().getWindowToken(),
                                        InputMethodManager.HIDE_NOT_ALWAYS);
                        search();
//                    }
                    return true;
                }
                return false;
            }
        });
    }

    private void search() {
        search = etHomeSearch.getText().toString();
        page = 1;
        dataBeanList.clear();
        goodsLists();
    }


    protected void initData() {
        dataRepository = Injection.dataRepository(mContext);
        switchPage(0);
//        goodsLists();
    }

    private void goodsLists() {
        ViewLoading.show(mContext);
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.type = 3 + "";
        loginBean.page = page + "";
        loginBean.search = search;
        loginBean.sortType = sortType;
        loginBean.orderType = orderType;
        dataRepository.goodsLists(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                refresh.finishRefresh();
                ViewLoading.dismiss(mContext);
                GoodsListsModel goodsListsModel = (GoodsListsModel) data;
                if (goodsListsModel.getCode() == 1) {
                    if (goodsListsModel.getData().getList().getCurrent_page() == goodsListsModel.getData().getList().getLast_page()) {
                        refresh.finishLoadMoreWithNoMoreData();
                    } else {
                        refresh.finishLoadMore();
                    }
                    if (dataBeanList.size() == 0 && goodsListsModel.getData().getList().getData().size() == 0) {
                        rlEmpty.setVisibility(View.VISIBLE);
                        recycleView.setVisibility(View.GONE);
                    } else {
                        rlEmpty.setVisibility(View.GONE);
                        recycleView.setVisibility(View.VISIBLE);
                        dataBeanList.addAll(goodsListsModel.getData().getList().getData());
                        goodsAdapter.setData(dataBeanList);
                    }

                }
            }
        });
    }

    private void cartAdd(int goods_id, int goods_sku_id, int goods_num) {
        ViewLoading.show(mContext);
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.goods_id = goods_id + "";
        loginBean.goods_sku_id = goods_sku_id + "";
        loginBean.goods_num = goods_num + "";
        dataRepository.cartAdd(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                CartAddModel cartAddModel = (CartAddModel) data;
                if (cartAddModel.getCode() == 1) {
                    EventBus.getDefault().post(new ShopCartRefreshEvent());
                }
                ToastUtils.showToast(cartAddModel.getMsg());
            }
        });
    }


    private void switchPage(int page_) {         //排序 all 全部 sales 销量 price 价格    desc 降序 asc 升序

        if (page_ == 0) {
//            EventBus.getDefault().post(new ComprehensiveEvent());
            sortType = "all";
            orderType = "asc";
            setSortViewStatus(ivSortComposite, R.mipmap.sort_down_red);

        } else if (page_ == 1) {
            countFlag = !countFlag;
            sortType = "sales";
            if (countFlag) {
                orderType = "asc";
                setSortViewStatus(ivSortSalesTop, R.mipmap.sort_top_red);
            } else {
                orderType = "desc";
                setSortViewStatus(ivSortSalesDown, R.mipmap.sort_down_red);
            }
//            EventBus.getDefault().post(new BuyCountSortEvent(countFlag));

        } else if (page_ == 2) {
            priceFlag = !priceFlag;
            sortType = "price";
            if (priceFlag) {
                orderType = "asc";
                setSortViewStatus(ivSortPriceTop, R.mipmap.sort_top_red);
            } else {
                orderType = "desc";
                setSortViewStatus(ivSortPriceDown, R.mipmap.sort_down_red);
            }
//            EventBus.getDefault().post(new PriceSortEvent(priceFlag));

        }
        for (int i = 0; i < pageIds.length; i++) {
            if (i == page_) {
                pageIds[i].setTextColor(getResources().getColor(R.color.light_red));
            } else {
                pageIds[i].setTextColor(getResources().getColor(R.color.black_3));
            }

        }
        currentPage = page_;
        page = 1;
        dataBeanList.clear();
        goodsLists();


    }

    private void setSortViewStatus(ImageView imageView, int res) {
        ivSortComposite.setImageResource(R.mipmap.sort_down);
        ivSortPriceTop.setImageResource(R.mipmap.sort_top);
        ivSortPriceDown.setImageResource(R.mipmap.sort_down);
        ivSortSalesTop.setImageResource(R.mipmap.sort_top);
        ivSortSalesDown.setImageResource(R.mipmap.sort_down);

        imageView.setImageResource(res);
    }

    @OnClick({R.id.rl_composite, R.id.rl_sales, R.id.rl_price, R.id.iv_back, R.id.tv_search, R.id.iv_close})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_composite:
                switchPage(0);
                break;
            case R.id.rl_sales:
                switchPage(1);
                break;
            case R.id.rl_price:
                switchPage(2);
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_search:
//                if (etHomeSearch.getText().toString().equals("")) {
//                    ToastUtils.showToast("搜索内容不能为空");
//                } else {
                    ((InputMethodManager) etHomeSearch.getContext().getSystemService(Context.INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(
                                    getWindow().getDecorView().getWindowToken(),
                                    InputMethodManager.HIDE_NOT_ALWAYS);
                    search();
//                }
                break;
            case R.id.iv_close:
                etHomeSearch.setText("");
                break;
        }
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        page++;
        goodsLists();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        page = 1;
        dataBeanList.clear();
        goodsLists();
    }

}
