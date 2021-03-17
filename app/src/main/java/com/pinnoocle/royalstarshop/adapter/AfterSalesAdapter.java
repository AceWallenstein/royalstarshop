package com.pinnoocle.royalstarshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.RefundListsModel;
import com.pinnoocle.royalstarshop.common.BaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AfterSalesAdapter extends BaseAdapter<RefundListsModel.DataBeanX.ListBean.DataBean, AfterSalesAdapter.VH> {



    public AfterSalesAdapter(Context mContext) {
        super(mContext);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(mContext).inflate(R.layout.item_after_sales, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.tvOrderCode.setText(mDatas.get(position).getOrder_master().getOrder_no());
        holder.tvStatus.setText(mDatas.get(position).getState_text());
        Glide.with(mContext).load(mDatas.get(position).getOrder_goods().getImage().getFile_path()).fitCenter().into(holder.ivShop);
        holder.tvTitle.setText(mDatas.get(position).getOrder_goods().getGoods_name());
        holder.tvGoodsPattern.setText(mDatas.get(position).getOrder_goods().getGoods_attr());
        holder.tvNum.setText("x" + mDatas.get(position).getOrder_goods().getTotal_num());

        holder.itemView.setOnClickListener(v -> {
            if (mOnItemDataClickListener != null) {
                mOnItemDataClickListener.onItemViewClick(v,position,mDatas.get(position));
            }
        });


    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }


    public static class VH extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_status)
        TextView tvStatus;
        @BindView(R.id.tv_order_code_1)
        TextView tvOrderCode1;
        @BindView(R.id.tv_order_code)
        TextView tvOrderCode;
        @BindView(R.id.iv_shop)
        ImageView ivShop;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_goods_pattern)
        TextView tvGoodsPattern;
        @BindView(R.id.tv_num)
        TextView tvNum;
        @BindView(R.id.ll_order)
        LinearLayout llOrder;


        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
