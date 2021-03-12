package com.pinnoocle.royalstarshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.MoneyListModel;
import com.pinnoocle.royalstarshop.common.BaseAdapter;
import com.pinnoocle.royalstarshop.widget.GlideRoundTransform;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class MoneyListAdapter extends BaseAdapter<MoneyListModel.DataBeanX.ListBean.DataBean, MoneyListAdapter.VH> {

    public MoneyListAdapter(Context mContext) {
        super(mContext);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(mContext).inflate(R.layout.item_money_list, parent, false));
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.tvMoney.setText("+" + mDatas.get(position).getFirst_money());
        holder.tvOrder.setText("交易号：" + mDatas.get(position).getOrder_no());
        holder.tvTime.setText(mDatas.get(position).getCreate_time());
    }

    static class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_order)
        TextView tvOrder;
        @BindView(R.id.tv_money)
        TextView tvMoney;

        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
