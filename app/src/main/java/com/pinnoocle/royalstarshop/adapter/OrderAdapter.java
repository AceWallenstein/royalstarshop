package com.pinnoocle.royalstarshop.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
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
import com.pinnoocle.royalstarshop.utils.NumberUtil;

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
        if (mDatas.get(position).getIs_vip_order() == 1) {
            holder.tvTotalNums.setText("合计");
            holder.tvPrice.setText(NumberUtil.String2Int(mDatas.get(position).getPoints_money()) + "金豆");
        } else {
            holder.tvTotalNums.setText("共" + mDatas.get(position).getGoods().size() + "件商品，实付款");
            holder.tvPrice.setText("￥" + mDatas.get(position).getPay_price());
        }
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        List<OrderListModel.DataBeanX.ListBean.DataBean.GoodsBean> goods = mDatas.get(position).getGoods();
        InnerOrderAdapter adapter = new InnerOrderAdapter(mContext);
        if (mDatas.get(position).getIs_vip_order() == 1) {
            adapter.setType(1);
        } else {
            adapter.setType(0);
        }
        adapter.setData(goods);
        holder.recyclerView.setAdapter(adapter);
        holder.tvCancel.setVisibility(View.VISIBLE);
        ;
        if (!TextUtils.isEmpty(mDatas.get(position).getExpress_company()
        )) {
            holder.rlExpress.setVisibility(View.VISIBLE);
            holder.tvExpressCode.setText(mDatas.get(position).getExpress_company());
        } else {
            holder.rlExpress.setVisibility(View.GONE);
        }
        if (!TextUtils.isEmpty(mDatas.get(position).getExpress_no()
        )) {
            holder.rlLogistics.setVisibility(View.VISIBLE);
            holder.tvLogisticsCode.setText(mDatas.get(position).getExpress_no());
        } else {
            holder.rlLogistics.setVisibility(View.GONE);

        }

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
                if (mDatas.get(position).getIs_comment() == 0) {
                    holder.rl_panel.setVisibility(View.VISIBLE);
                    holder.tvStatus.setTextColor(0xff666666);
                    holder.tvCancel.setVisibility(View.GONE);
                    holder.tvPay.setText("去评价");
                } else {
                    holder.rl_panel.setVisibility(View.GONE);
                    holder.tvStatus.setTextColor(0xff666666);
                }

                break;
            case "已评价":
            case "已取消":
                holder.rl_panel.setVisibility(View.GONE);
                holder.tvStatus.setTextColor(0xff666666);
                break;

        }
        holder.tvPay.setOnClickListener(v -> {
            if (mOnItemDataClickListener != null) {
                mOnItemDataClickListener.onItemViewClick(v, position, mDatas.get(position));
            }
        });
        holder.tvCancel.setOnClickListener(v -> {
            if (mOnItemDataClickListener != null) {
                mOnItemDataClickListener.onItemViewClick(v, position, mDatas.get(position));
            }
        });

        holder.itemView.setOnClickListener(v ->
        {
            Intent intent = new Intent(mContext, OrderDetailActivity.class);
            intent.putExtra("order_id", mDatas.get(position).getOrder_id());
            mContext.startActivity(intent);
        });
        adapter.setOnItemClickListener((v, pos) -> {
            Intent intent = new Intent(mContext, OrderDetailActivity.class);
            intent.putExtra("order_id", mDatas.get(position).getOrder_id());
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
        @BindView(R.id.tv_logistics_code)
        TextView tvLogisticsCode;
        @BindView(R.id.tv_logistics)
        TextView tvLogistics;
        @BindView(R.id.rl_logistics)
        RelativeLayout rlLogistics;
        @BindView(R.id.tv_express_code)
        TextView tvExpressCode;
        @BindView(R.id.tv_express)
        TextView tvExpress;
        @BindView(R.id.rl_express)
        RelativeLayout rlExpress;
        @BindView(R.id.tv_cancel)
        TextView tvCancel;
        @BindView(R.id.tv_pay)
        TextView tvPay;
        @BindView(R.id.rl_panel)
        RelativeLayout rl_panel;
        @BindView(R.id.ll_order)
        LinearLayout llOrder;


        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
