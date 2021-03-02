package com.pinnoocle.royalstarshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.common.BaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoodsAdapter extends BaseAdapter<String, GoodsAdapter.VH> {



    public GoodsAdapter(Context mContext) {
        super(mContext);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(mContext).inflate(R.layout.item_goods, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

        holder.itemView.setOnClickListener(v ->
        {
            if (mOnItemDataClickListener != null) {
                mOnItemDataClickListener.onItemViewClick(v, position, mDatas.get(position));
            }
        });
        holder.ivShopCar.setOnClickListener(v -> {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemViewClick(v, position);
            }
            if (mOnItemDataClickListener != null) {
                mOnItemDataClickListener.onItemViewClick(v, position, mDatas.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
//        return mDatas == null ? 0 : mDatas.size();
        return 5;
    }


    public static class VH extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_goods_pic)
        ImageView ivGoodsPic;
        @BindView(R.id.tv_goods_title)
        TextView tvGoodsTitle;
        @BindView(R.id.tv_desc)
        TextView tvDesc;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.tv_vip_price)
        TextView tvVipPrice;
        @BindView(R.id.iv_shop_car)
        ImageView ivShopCar;

        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
