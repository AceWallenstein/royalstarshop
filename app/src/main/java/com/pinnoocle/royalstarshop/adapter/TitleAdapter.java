package com.pinnoocle.royalstarshop.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.TitleBean;
import com.pinnoocle.royalstarshop.common.BaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TitleAdapter extends BaseAdapter<TitleBean, TitleAdapter.VH> {
    private int pos;

    public TitleAdapter(Context mContext) {
        super(mContext);
    }

    public void setPos(int position)
    {
       pos = position;
       notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(mContext).inflate(R.layout.item_title, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.title.setText(mDatas.get(position).title);
        holder.title1.setText(mDatas.get(position).title1);
        if (position == pos) {
            holder.title.setTextColor(mContext.getResources().getColor(R.color.light_red));
            holder.title1.setTextColor(mContext.getResources().getColor(R.color.white));
            holder.title1.setBackgroundResource(R.mipmap.bg_title_1);
        } else {
            holder.title.setTextColor(mContext.getResources().getColor(R.color.black_1));
            holder.title1.setTextColor(mContext.getResources().getColor(R.color.grey));
            holder.title1.setBackgroundColor(Color.argb(0,0,0,0));
        }
        holder.itemView.setOnClickListener((v) -> {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemViewClick(v, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();

    }

    static class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.title_1)
        TextView title1;

        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
