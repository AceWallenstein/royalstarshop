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

import com.bumptech.glide.Glide;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.CartListsModel;
import com.pinnoocle.royalstarshop.common.BaseAdapter;
import com.pinnoocle.royalstarshop.event.CanSettlement;
import com.pinnoocle.royalstarshop.event.CartAllCheckedEvent;
import com.pinnoocle.royalstarshop.event.SetCartNums;
import com.pinnoocle.royalstarshop.event.UpdateTotalPriceEvent;
import com.pinnoocle.royalstarshop.widget.NumberButton;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShoppingCartAdapter extends BaseAdapter<CartListsModel.DataBean.GoodsListBean, ShoppingCartAdapter.VH> {



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
        holder.mCheckedCb.setChecked(mDatas.get(position).isIs_select());
        Glide.with(mContext).load(mDatas.get(position).getGoods_image()).fitCenter().into(holder.mGoodsIconIv);
        holder.mGoodsDescTv.setText(mDatas.get(position).getGoods_name());
        holder.mGoodsSkuTv.setText(mDatas.get(position).getGoods_sku().getGoods_attr());
        holder.mGoodsPriceTv.setText(mDatas.get(position).getGoods_price());
        if(mDatas.get(position).getType().getValue()==3)//会员商品
        {
            holder.tvVipDesc.setVisibility(View.VISIBLE);
            holder.tvVipDescValue.setVisibility(View.VISIBLE);
            holder.tvVipDescValue.setText(mDatas.get(position).getPoints()+"豆");
        }else {
            holder.tvVipDesc.setVisibility(View.GONE);
            holder.tvVipDescValue.setVisibility(View.GONE);

        }
        holder.rlCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = !holder.mCheckedCb.isChecked();
                mDatas.get(position).setIs_select(flag);
                holder.mCheckedCb.setChecked(flag);
                final boolean isAllChecked = isAllchecked(holder, position);
                isOnechecked(holder, position);
                EventBus.getDefault().post(new CartAllCheckedEvent(isAllChecked));
            }
        });
        holder.tvFreight.setText("运费：￥"+mDatas.get(position).getTotal_freight());
        holder.mGoodsCountBtn
//                .setBuyMax(buy_limit)
                .setCurrentNumber(mDatas.get(position).getTotal_num())
                .setOnNumberButtonListener(new NumberButton.OnNumberButtonListener() {
                    @Override
                    public void onNumberButtonListener(View v) {
                        holder.mCheckedCb.setChecked(true);
                        mDatas.get(position).setIs_select(true);
                        isOnechecked(holder, position);
                        mDatas.get(position).setTotal_num(holder.mGoodsCountBtn.getNumber());
                        holder.tvFreight.setText("运费：￥"+holder.mGoodsCountBtn.getNumber() * Double.parseDouble(mDatas.get(position).getFreight()));
                        EventBus.getDefault().post(new SetCartNums(mDatas.get(position).getGoods_id()+"",mDatas.get(position).getGoods_sku_id(), holder.mGoodsCountBtn.getNumber()+""));
                    }
                });
        ;
//                .setInventory(stock)
//                .setOnWarnListener(new NumberButton.OnWarnListener() {
//                    @Override
//                    public void onWarningForInventory(int inventory) {
//                        ToastUtils.showToast("当前库存:" + inventory);
//                    }
//
//                    @Override
//                    public void onWarningForBuyMax(int buyMax) {
//                        ToastUtils.showToast("超过最大购买数:" + buyMax);
//                    }
//                });
        holder.mGoodsIconIv.setOnClickListener(v -> {
            if (mOnItemDataClickListener != null) {
                mOnItemDataClickListener.onItemViewClick(v,position,mDatas.get(position));
            }
        });


    }
    private boolean isAllchecked(@NonNull VH holder, int position) {
        for (int i = 0; i < mDatas.size(); i++) {
            if (!mDatas.get(i).isIs_select()) {
                return false;
            }
        }
        return true;
    }

    private void isOnechecked(@NonNull VH holder, int position) {
        for (int i = 0; i < mDatas.size(); i++) {
            if (mDatas.get(i).isIs_select()) {
                EventBus.getDefault().post(new CanSettlement(true));
                return;
            }
        }
        EventBus.getDefault().post(new CanSettlement(false));
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    static class VH extends RecyclerView.ViewHolder {

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

        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
