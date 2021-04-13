package com.pinnoocle.royalstarshop.adapter;

import android.content.Context;
import android.text.TextUtils;
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
import com.pinnoocle.royalstarshop.bean.OrderDetailModel;
import com.pinnoocle.royalstarshop.common.BaseAdapter;
import com.pinnoocle.royalstarshop.utils.NumberUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderDetailAdapter extends BaseAdapter<OrderDetailModel.DataBean.OrderBean.GoodsBeanX, OrderDetailAdapter.VH> {


    private String state_text;
    private boolean isVipGoods = false;
    private boolean hide = false;

    public OrderDetailAdapter(Context mContext) {
        super(mContext);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(mContext).inflate(R.layout.item_order_detail, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

        Glide.with(mContext).load(mDatas.get(position).getImage().getFile_path()).fitCenter().into(holder.ivShop);
        holder.tvTitle.setText(mDatas.get(position).getGoods_name());
        holder.tvGoodsPattern.setText(mDatas.get(position).getGoods_attr());
        holder.tvNum.setText("x" + mDatas.get(position).getTotal_num());
//        holder.tv_status.setText(mDatas.get(position).ge);
        holder.rlGoods.setOnClickListener(v -> {
            if (mOnItemDataClickListener != null) {
                mOnItemDataClickListener.onItemViewClick(v, position, mDatas.get(position));
            }
        });
        if (mDatas.get(position).getType() == 3) {
            holder.rlJinDou.setVisibility(View.VISIBLE);
        } else {
            holder.rlJinDou.setVisibility(View.GONE);
        }
        if (isVipGoods) {
            holder.tvPoints.setText(mDatas.get(position).getPoints_bonus() + "金豆");
            holder.tvFreight.setText(NumberUtil.String2Int(mDatas.get(position).getTotal_freight()) + "金豆");
            holder.tvIsVipGoods.setVisibility(View.VISIBLE);
            holder.tvPrice.setText(NumberUtil.String2Int(mDatas.get(position).getGoods_price()) + "金豆");

        } else {
            holder.tvPrice.setText("￥" + mDatas.get(position).getGoods_price());
            holder.tvIsVipGoods.setVisibility(View.GONE);
            holder.tvPoints.setText("￥" + mDatas.get(position).getPoints_bonus());
            holder.tvFreight.setText("￥" + mDatas.get(position).getTotal_freight());
        }
        holder.tvAfterSale.setOnClickListener(v -> {
            if (mOnItemDataClickListener != null) {
                mOnItemDataClickListener.onItemViewClick(v, position, mDatas.get(position));
            }
        });

        if (!TextUtils.isEmpty(state_text)) {
            switch (state_text) {
                case "待付款":
                    holder.tvAfterSale.setVisibility(View.GONE);
//                    holder.tv_after_sale.setVisibility(View.VISIBLE);
                    break;
                case "待收货":
                case "待发货":
                case "已完成":
                case "待评价":
                    holder.tvAfterSale.setVisibility(View.VISIBLE);
                    if (mDatas.get(position).getRefund() != null) {
                        holder.tvAfterSale.setVisibility(View.GONE);
                        holder.tvAfterSaleText.setVisibility(View.VISIBLE);
                    } else {
                        holder.tvAfterSale.setVisibility(View.VISIBLE);
                        holder.tvAfterSaleText.setVisibility(View.GONE);
                    }
                    break;

            }
        }

        holder.ivQuestion.setOnClickListener(v -> {
            if (mOnItemDataClickListener != null) {
                mOnItemDataClickListener.onItemViewClick(v, position, mDatas.get(position));
            }
        });

        if(hide){
            holder.tvAfterSale.setVisibility(View.GONE);
        }


    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    public void setType(String state_text) {
        this.state_text = state_text;
    }

    public void setIsVipGoods(boolean b) {
        this.isVipGoods = b;
        notifyDataSetChanged();
    }

    public void setHiden(boolean b) {
        this.hide = b;
    }


    public static class VH extends RecyclerView.ViewHolder {


        @BindView(R.id.iv_shop)
        ImageView ivShop;
        @BindView(R.id.tv_is_vip_goods)
        TextView tvIsVipGoods;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_goods_pattern)
        TextView tvGoodsPattern;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.tv_status)
        TextView tvStatus;
        @BindView(R.id.tv_num)
        TextView tvNum;
        @BindView(R.id.rl_goods)
        RelativeLayout rlGoods;
        @BindView(R.id.tv_points_1)
        TextView tvPoints1;
        @BindView(R.id.iv_question)
        ImageView ivQuestion;
        @BindView(R.id.tv_points)
        TextView tvPoints;
        @BindView(R.id.rl_jin_dou)
        RelativeLayout rlJinDou;
        @BindView(R.id.tv_freight)
        TextView tvFreight;
        @BindView(R.id.rl_freight)
        RelativeLayout rlFreight;
        @BindView(R.id.tv_after_sale_text)
        TextView tvAfterSaleText;
        @BindView(R.id.tv_after_sale)
        TextView tvAfterSale;
        @BindView(R.id.rl_after_sale)
        RelativeLayout rlAfterSale;

        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
