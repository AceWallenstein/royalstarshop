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
import com.pinnoocle.royalstarshop.bean.HomeModel;
import com.pinnoocle.royalstarshop.common.BaseAdapter;
import com.pinnoocle.royalstarshop.widget.GlideRoundTransform;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class GoodsTwoAdapter extends BaseAdapter<HomeModel.DataBean.VideoGoodsBean, GoodsTwoAdapter.VH> {


    public GoodsTwoAdapter(Context mContext) {
        super(mContext);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(mContext).inflate(R.layout.item_goods_two, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.tvTitle.setText(mDatas.get(position).getGoods_name());
        if (mDatas.get(position).getSku() != null && mDatas.get(position).getSku().size() > 0){
            holder.tvPrice.setText("￥" + mDatas.get(position).getGoods_sku().getGoods_price());
            holder.tvVipPrice.setText("￥" + mDatas.get(position).getGoods_sku().getBalance_price());
        }
        holder.tvDesc.setText(mDatas.get(position).getSelling_point());
        if (mDatas.get(position).getImage() != null && mDatas.get(position).getImage().size() > 0)
            Glide.with(mContext).load(mDatas.get(position).getGoods_image()).apply(bitmapTransform(new GlideRoundTransform(mContext))).into(holder.ivGoodsPic);

        holder.itemView.setOnClickListener(v -> {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemViewClick(v, position);
            }
        });
        holder.itemView.setOnClickListener(v -> {
            if (mOnItemDataClickListener != null) {
                mOnItemDataClickListener.onItemViewClick(v, position,mDatas.get(position));
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
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_desc)
        TextView tvDesc;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.tv_vip_price)
        TextView tvVipPrice;

        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
