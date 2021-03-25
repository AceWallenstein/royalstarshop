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
import com.pinnoocle.royalstarshop.bean.MessageListModel;
import com.pinnoocle.royalstarshop.common.BaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MessageListAdapter extends BaseAdapter<MessageListModel.DataBeanX.ListBean.DataBean, MessageListAdapter.VH> {



    public MessageListAdapter(Context mContext) {
        super(mContext);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(mContext).inflate(R.layout.item_message_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        if(mDatas.get(position).getType()==10){
           holder.ivType.setImageResource(R.mipmap.system_message);
            holder.tvTitle.setText("系统消息");
        }else {
            holder.ivType.setImageResource(R.mipmap.transaction_logistics);
            holder.tvTitle.setText("物流消息");
        }
        if(!TextUtils.isEmpty(mDatas.get(position).getTitle()))
        {
            holder.tvTitle.setText(mDatas.get(position).getTitle());
        }
        holder.tvTime.setText(mDatas.get(position).getUpdate_time());
        holder.tvContent.setText(mDatas.get(position).getContent());
        holder.itemView.setOnClickListener(v -> {
            if (mOnItemDataClickListener != null) {
                mOnItemDataClickListener.onItemViewClick(v,position,mDatas.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }


    public static class VH extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_type)
        ImageView ivType;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_content)
        TextView tvContent;
        @BindView(R.id.rl_detail)
        RelativeLayout rlDetail;

        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}