package com.pinnoocle.royalstarshop.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.OrderListModel;
import com.pinnoocle.royalstarshop.common.BaseAdapter;
import com.pinnoocle.royalstarshop.mine.activity.OrderDetailActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderAdapter extends BaseAdapter<OrderListModel.DataBeanX.ListBean.DataBean, OrderAdapter.VH> {


    public OrderAdapter(Context mContext) {
        super(mContext);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(mContext).inflate(R.layout.item_order, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.tvOrderCode.setText("订单号：" + mDatas.get(position).getOrder_no());
        holder.tvStatus.setText(mDatas.get(position).getState_text());
        holder.tvTotalNums.setText("共" + mDatas.get(position).getGoods().size() + "件商品，实付款");
        holder.tvPrice.setText("￥" + mDatas.get(position).getPay_price());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        List<OrderListModel.DataBeanX.ListBean.DataBean.GoodsBean> goods = mDatas.get(position).getGoods();
        InnerOrderAdapter adapter = new InnerOrderAdapter(mContext);
        adapter.setData(goods);
        holder.recyclerView.setAdapter(adapter);
        holder.tvCancel.setVisibility(View.VISIBLE);;
        switch (mDatas.get(position).getState_text()) {
            case "待付款":
                holder.rl_panel.setVisibility(View.VISIBLE);
                holder.tvStatus.setTextColor(0xffFF5126);
                holder.tvCancel.setText("取消");
                holder.tvPay.setText("去付款");
                break;
            case "待发货":
                holder.rl_panel.setVisibility(View.GONE);
                holder.tvStatus.setTextColor(0xff00D572);
                break;
            case "待收货":
                holder.rl_panel.setVisibility(View.VISIBLE);
                holder.tvStatus.setTextColor(0xffFFB400);
                holder.tvCancel.setText("联系客服");
                holder.tvPay.setText("确认收货");
                break;
            case "已完成":
                holder.rl_panel.setVisibility(View.VISIBLE);
                holder.tvStatus.setTextColor(0xff666666);
                holder.tvCancel.setVisibility(View.GONE);
                holder.tvPay.setText("去评价");

                break;
            case "已评价":
                holder.rl_panel.setVisibility(View.GONE);
                holder.tvStatus.setTextColor(0xff666666);

                break;

        }


        holder.llOrder.setOnClickListener(v ->
        {
            Intent intent = new Intent(mContext, OrderDetailActivity.class);
            mContext.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }


    public static class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_status)
        TextView tvStatus;
        @BindView(R.id.tv_order_code)
        TextView tvOrderCode;
        @BindView(R.id.recyclerView)
        RecyclerView recyclerView;
        @BindView(R.id.tv_total_nums)
        TextView tvTotalNums;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.tv_cancel)
        TextView tvCancel;
        @BindView(R.id.tv_pay)
        TextView tvPay;
        @BindView(R.id.ll_order)
        LinearLayout llOrder;
        @BindView(R.id.rl_panel)
        RelativeLayout rl_panel;


        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
