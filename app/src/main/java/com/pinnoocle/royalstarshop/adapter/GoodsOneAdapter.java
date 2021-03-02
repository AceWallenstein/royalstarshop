package com.pinnoocle.royalstarshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.common.BaseAdapter;

import butterknife.ButterKnife;

public class GoodsOneAdapter extends BaseAdapter<String, GoodsOneAdapter.VH> {


    public GoodsOneAdapter(Context mContext) {
        super(mContext);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(mContext).inflate(R.layout.item_goods_one,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
       holder.itemView.setOnClickListener(v -> {
           if (mOnItemClickListener != null) {
               mOnItemClickListener.onItemViewClick(v,position);
           }
       });
    }

    @Override
    public int getItemCount() {
//        return mDatas == null ? 0 : mDatas.size();
        return 3;
    }

    static class VH extends RecyclerView.ViewHolder {

        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
