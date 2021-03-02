package com.pinnoocle.royalstarshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.common.BaseAdapter;

public class CommentAdapter extends BaseAdapter<String, CommentAdapter.VH> {

    public CommentAdapter(Context mContext) {
        super(mContext);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(mContext).inflate(R.layout.item_goods_comment, parent, false));
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

    }

    static class VH extends RecyclerView.ViewHolder {

        public VH(@NonNull View itemView) {
            super(itemView);
        }
    }
}
