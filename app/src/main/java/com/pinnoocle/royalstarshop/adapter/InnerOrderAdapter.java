package com.pinnoocle.royalstarshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.OrderListModel;
import com.pinnoocle.royalstarshop.common.BaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InnerOrderAdapter extends BaseAdapter<OrderListModel.DataBeanX.ListBean.DataBean.GoodsBean, InnerOrderAdapter.VH> {



    public InnerOrderAdapter(Context mContext) {
        super(mContext);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(mContext).inflate(R.layout.item_inner_order, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Glide.with(mContext).load(mDatas.get(position).getImage().getFile_path()).fitCenter().into(holder.ivShop);
        holder.tvTitle.setText(mDatas.get(position).getGoods_name());
        holder.tvGoodsPattern.setText(mDatas.get(position).getGoods_attr());
        holder.tvNum.setText("x"+mDatas.get(position).getTotal_num());
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }


    public static class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_shop)
        ImageView ivShop;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_goods_pattern)
        TextView tvGoodsPattern;
        @BindView(R.id.tv_num)
        TextView tvNum;

        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
