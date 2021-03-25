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
import com.pinnoocle.royalstarshop.bean.OrderListModel;
import com.pinnoocle.royalstarshop.common.BaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderDetailAdapter extends BaseAdapter<OrderListModel.DataBeanX.ListBean.DataBean.GoodsBean, OrderDetailAdapter.VH> {


    private String state_text;

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
        holder.tvPoints.setText("￥" + mDatas.get(position).getPoints_bonus());
        holder.tvFreight.setText("￥" + mDatas.get(position).getTotal_freight());
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
                case "待发货":
                case "已完成":
                case "待收货":
                case "待评价":
                    holder.tvAfterSale.setVisibility(View.VISIBLE);
                    break;

            }
        }
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    public void setType(String state_text) {
        this.state_text = state_text;
    }


    public static class VH extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_shop)
        ImageView ivShop;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_goods_pattern)
        TextView tvGoodsPattern;
        @BindView(R.id.tv_status)
        TextView tvStatus;
        @BindView(R.id.tv_num)
        TextView tvNum;
        @BindView(R.id.rl_goods)
        RelativeLayout rlGoods;
        @BindView(R.id.tv_points)
        TextView tvPoints;
        @BindView(R.id.rl_jin_dou)
        RelativeLayout rlJinDou;
        @BindView(R.id.tv_freight)
        TextView tvFreight;
        @BindView(R.id.rl_freight)
        RelativeLayout rlFreight;
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
