package com.pinnoocle.royalstarshop.home.fragment;

import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.GoodsAdapter;
import com.pinnoocle.royalstarshop.adapter.GoodsListAdapter;
import com.pinnoocle.royalstarshop.bean.CartAddModel;
import com.pinnoocle.royalstarshop.bean.HomeModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.common.BaseAdapter;
import com.pinnoocle.royalstarshop.common.BaseFragment;
import com.pinnoocle.royalstarshop.event.ShopCartRefreshEvent;
import com.pinnoocle.royalstarshop.home.activity.GoodsDetailActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class GoodsFragment extends BaseFragment {
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    List<HomeModel.DataBean.TagGoodsBean.ListBean> list = new ArrayList<>();
    private String s = "";
    private DataRepository dataRepository;

    public GoodsFragment(List<HomeModel.DataBean.TagGoodsBean.ListBean> list) {
        this.list = list;
    }

    public GoodsFragment(String s) {
        this.s = s;
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_goods;
    }

    @Override
    protected void initView() {
        recycleView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        GoodsListAdapter goodsAdapter = new GoodsListAdapter(getContext());
        if (!s.equals("1")) {
            goodsAdapter.setData(list);
        }
        recycleView.setAdapter(goodsAdapter);
        goodsAdapter.setOnItemDataClickListener(new BaseAdapter.OnItemDataClickListener<HomeModel.DataBean.TagGoodsBean.ListBean>() {
            @Override
            public void onItemViewClick(View view, int position, HomeModel.DataBean.TagGoodsBean.ListBean o) {
                switch (view.getId()){
                    case R.id.iv_shop_car:
                        cartAdd(o.getGoods_id(),o.getGoods_sku().getGoods_sku_id(),1);
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
    }

    private void cartAdd(int goods_id, int goods_sku_id, int goods_num) {
        ViewLoading.show(getContext());
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.goods_id = goods_id + "";
        loginBean.goods_sku_id = goods_sku_id + "";
        loginBean.goods_num = goods_num+"";
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

}
