package com.pinnoocle.royalstarshop.shoppingcart;

import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.ShoppingCartAdapter;
import com.pinnoocle.royalstarshop.bean.CartListsModel;
import com.pinnoocle.royalstarshop.bean.GoodsListsModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.common.BaseFragment;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;

import java.util.List;

import butterknife.BindView;

public class ShoppingCartFragment extends BaseFragment {
    @BindView(R.id.tv_del)
    TextView tvDel;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.checkbox)
    CheckBox checkbox;
    @BindView(R.id.tv_all_select_1)
    TextView tvAllSelect1;
    @BindView(R.id.ll_all_select)
    LinearLayout llAllSelect;
    @BindView(R.id.tv_total)
    TextView tvTotal;
    @BindView(R.id.tv_total_price)
    TextView tvTotalPrice;
    @BindView(R.id.tv_freight)
    TextView tvFreight;
    @BindView(R.id.tv_settlement)
    TextView tvSettlement;
    @BindView(R.id.rl_panel)
    RelativeLayout rlPanel;
    private DataRepository dataRepository;
    private ShoppingCartAdapter shoppingCartAdapter;

    @Override
    protected int LayoutId() {
        return R.layout.fragment_shopping_cart;
    }

    @Override
    protected void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        shoppingCartAdapter = new ShoppingCartAdapter(getContext());
        recyclerView.setAdapter(shoppingCartAdapter);
    }

    @Override
    protected void initData() {
        dataRepository = Injection.dataRepository(getContext());
        cartLists();
    }

    private void cartLists() {
        ViewLoading.show(getContext());
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        dataRepository.cartLists(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(getContext());
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(getContext());
                CartListsModel cartListsModel = (CartListsModel) data;
                if (cartListsModel.getCode() == 1) {
                    List<CartListsModel.DataBean.GoodsListBean> goods_list = cartListsModel.getData().getGoods_list();
                    shoppingCartAdapter.setData(goods_list);
                }
            }
        });
    }
}
