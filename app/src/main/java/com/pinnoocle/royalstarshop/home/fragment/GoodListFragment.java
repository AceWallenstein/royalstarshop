package com.pinnoocle.royalstarshop.home.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.GoodsAdapter;
import com.pinnoocle.royalstarshop.bean.CartAddModel;
import com.pinnoocle.royalstarshop.bean.GoodsListsModel;
import com.pinnoocle.royalstarshop.bean.HistoryBean;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.common.BaseAdapter;
import com.pinnoocle.royalstarshop.common.BaseFragment;
import com.pinnoocle.royalstarshop.event.ShopCartRefreshEvent;
import com.pinnoocle.royalstarshop.home.activity.GoodsDetailActivity;
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
import butterknife.OnClick;

public class GoodListFragment extends BaseFragment implements OnRefreshLoadMoreListener {
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;
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
    @BindView(R.id.rl_empty)
    RelativeLayout rlEmpty;

    private List<HistoryBean> historyList = new ArrayList<>();
    private boolean countFlag = false;
    private boolean priceFlag = false;
    TextView[] pageIds;
    private int currentPage;
    private int category_id;
    private DataRepository dataRepository;
    private GoodsAdapter goodsAdapter;
    private int page = 1;
    private List<GoodsListsModel.DataBeanX.ListBean.DataBean> dataBeanList = new ArrayList<>();
    private String sortType = "all";
    private String orderType = "asc ";

    public GoodListFragment(int category_id) {
        this.category_id = category_id;
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_goods_list;
    }

    @Override
    protected void initView() {
        pageIds = new TextView[]{tvComposite, tvSales, tvPrice};
        recycleView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        goodsAdapter = new GoodsAdapter(getContext());
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
                        Intent intent = new Intent(getContext(), GoodsDetailActivity.class);
                        intent.putExtra("goods_id", o.getGoods_id() + "");
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    @Override
    protected void initData() {
        dataRepository = Injection.dataRepository(getContext());
        switchPage(0);
//        goodsLists();
    }

    private void goodsLists() {
        ViewLoading.show(getContext());
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.category_id = category_id + "";
        loginBean.page = page + "";
        loginBean.sortType = sortType;
        loginBean.orderType = orderType;
        dataRepository.goodsLists(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(getContext());
            }

            @Override
            public void onSuccess(Object data) {
                refresh.finishRefresh();
                ViewLoading.dismiss(getContext());
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
        ViewLoading.show(getContext());
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.goods_id = goods_id + "";
        loginBean.goods_sku_id = goods_sku_id + "";
        loginBean.goods_num = goods_num + "";
        dataRepository.cartAdd(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(getContext());
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(getContext());
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

    @OnClick({R.id.rl_composite, R.id.rl_sales, R.id.rl_price})
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
