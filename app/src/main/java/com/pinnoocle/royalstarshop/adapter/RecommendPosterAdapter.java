package com.pinnoocle.royalstarshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.ErCodeModel;
import com.pinnoocle.royalstarshop.common.BaseAdapter;
import com.pinnoocle.royalstarshop.mine.activity.RecommendedPosterActivity;
import com.pinnoocle.royalstarshop.widget.RoundImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecommendPosterAdapter extends BaseAdapter<ErCodeModel.DataBean.MyInviteBean, RecommendPosterAdapter.VH> {

    public RecommendPosterAdapter(Context mContext) {
        super(mContext);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(mContext).inflate(R.layout.item_recommend_poster, parent, false));
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Glide.with(mContext).load(mDatas.get(position).getAvatarUrl()).into(holder.ivAvatar);
        holder.tvName.setText(mDatas.get(position).getNickName());
        if (mDatas.get(position).getMoney() > 0) {
            holder.llMoney.setVisibility(View.VISIBLE);
            holder.tvMoney.setText("+" + mDatas.get(position).getMoney());
        } else {
            holder.llMoney.setVisibility(View.GONE);
        }
        if(mDatas.get(position).getVip_text().equals("已开通")){
            holder.tvStatus.setText(mDatas.get(position).getVip_text());
            holder.tvStatus.setTextColor(0xff59B442);
            holder.tvTime.setVisibility(View.VISIBLE);
            holder.tvTime.setText(mDatas.get(position).getCreate_time());
        }else {
            holder.tvStatus.setText(mDatas.get(position).getVip_text());
            holder.tvStatus.setTextColor(0xffFF5425);
            holder.tvTime.setVisibility(View.GONE);

        }
    }

    static class VH extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_avatar)
        RoundImageView ivAvatar;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_money)
        TextView tvMoney;
        @BindView(R.id.ll_money)
        LinearLayout llMoney;
        @BindView(R.id.tv_status)
        TextView tvStatus;
        @BindView(R.id.tv_time)
        TextView tvTime;

        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
