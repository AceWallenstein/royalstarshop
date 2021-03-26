package com.pinnoocle.royalstarshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.SureOrderModel;
import com.pinnoocle.royalstarshop.common.BaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VipOrderConfirmAdapter extends BaseAdapter<SureOrderModel.DataBean.GoodsListBean, VipOrderConfirmAdapter.VH> {


    public VipOrderConfirmAdapter(Context mContext) {
        super(mContext);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int vieType) {
        return new VH(LayoutInflater.from(mContext).inflate(R.layout.item_goods_order_confirm, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Glide.with(mContext).load(mDatas.get(position).getGoods_image()).fitCenter().into(holder.ivGoodsPic);
        holder.tvGoodsTitle.setText(mDatas.get(position).getGoods_name());
        holder.tvPrice.setText(mDatas.get(position).getGoods_price() + "金豆");
        holder.tvSpec.setText(mDatas.get(position).getGoods_sku().getGoods_attr());
        holder.tvNums.setText("x" + mDatas.get(position).getTotal_num());
        holder.tvPoints.setText(mDatas.get(position).getPoints_bonus() + "金豆");
        holder.tvFreight.setText(mDatas.get(position).getTotal_freight()+ "金豆");
//        holder.tvRemarks.setText(mDatas.get(position).get);
        if (mDatas.get(position).getType().getValue() == 3) {
            holder.returnGoldBean.setVisibility(View.VISIBLE);
        } else {
            holder.returnGoldBean.setVisibility(View.GONE);
        }

        holder.rlItem.setOnClickListener(v -> {
            if (mOnItemDataClickListener != null) {
                mOnItemDataClickListener.onItemViewClick(v, position, mDatas.get(position));
            }
        });

        holder.ivQuestion.setOnClickListener(v -> {
            if (mOnItemDataClickListener != null) {
                mOnItemDataClickListener.onItemViewClick(v, position, mDatas.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    static class VH extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_goods_pic)
        ImageView ivGoodsPic;
        @BindView(R.id.tv_goods_title)
        TextView tvGoodsTitle;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.tv_spec)
        TextView tvSpec;
        @BindView(R.id.tv_nums)
        TextView tvNums;
        @BindView(R.id.rl_item)
        RelativeLayout rlItem;
        @BindView(R.id.tv_remarks)
        TextView tvRemarks;
        @BindView(R.id.tv_freight)
        TextView tvFreight;
        @BindView(R.id.tv_points)
        TextView tvPoints;
        @BindView(R.id.return_gold_bean)
        RelativeLayout returnGoldBean;
        @BindView(R.id.iv_question)
        ImageView ivQuestion;


        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
