package com.pinnoocle.royalstarshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.MoneyListModel;
import com.pinnoocle.royalstarshop.bean.PointsModel;
import com.pinnoocle.royalstarshop.common.BaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoldenBeanAdapter extends BaseAdapter<PointsModel.DataBeanX.ListBean.DataBean, GoldenBeanAdapter.VH> {

    public GoldenBeanAdapter(Context mContext) {
        super(mContext);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(mContext).inflate(R.layout.item_golden_bean, parent, false));
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.tvName.setText(mDatas.get(position).getDescribe());
        if (mDatas.get(position).getValue() > 0) {
            holder.tvMoney.setText("+" + mDatas.get(position).getValue());
            holder.tvMoney.setTextColor(0xff111111);
        } else {
            holder.tvMoney.setText("-" + mDatas.get(position).getValue());
            holder.tvMoney.setTextColor(0xffFF2329);
        }
        holder.tvTime.setText(mDatas.get(position).getCreate_time());
    }

    static class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_money)
        TextView tvMoney;

        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
