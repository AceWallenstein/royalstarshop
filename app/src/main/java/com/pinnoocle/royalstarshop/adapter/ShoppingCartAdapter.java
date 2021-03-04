package com.pinnoocle.royalstarshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.CartListsModel;
import com.pinnoocle.royalstarshop.common.BaseAdapter;
import com.pinnoocle.royalstarshop.widget.NumberButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShoppingCartAdapter extends BaseAdapter<CartListsModel.DataBean.GoodsListBean, ShoppingCartAdapter.VH> {


    @BindView(R.id.mCheckedCb)
    CheckBox mCheckedCb;
    @BindView(R.id.rl_check_box)
    RelativeLayout rlCheckBox;
    @BindView(R.id.mGoodsIconIv)
    ImageView mGoodsIconIv;
    @BindView(R.id.mGoodsDescTv)
    TextView mGoodsDescTv;
    @BindView(R.id.mGoodsSkuTv)
    TextView mGoodsSkuTv;
    @BindView(R.id.mGoodsPriceTv)
    TextView mGoodsPriceTv;
    @BindView(R.id.mGoodsCountBtn)
    NumberButton mGoodsCountBtn;
    @BindView(R.id.tv_vip_desc)
    TextView tvVipDesc;
    @BindView(R.id.tv_vip_desc_value)
    TextView tvVipDescValue;
    @BindView(R.id.tv_freight)
    TextView tvFreight;
    @BindView(R.id.rl_item)
    RelativeLayout rlItem;

    public ShoppingCartAdapter(Context mContext) {
        super(mContext);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(mContext).inflate(R.layout.item_shopping_cart, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    static class VH extends RecyclerView.ViewHolder {

        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
