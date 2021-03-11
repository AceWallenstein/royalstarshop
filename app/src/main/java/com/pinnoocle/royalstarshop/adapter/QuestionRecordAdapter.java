package com.pinnoocle.royalstarshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.FeedbackListModel;
import com.pinnoocle.royalstarshop.bean.IndexModel;
import com.pinnoocle.royalstarshop.common.BaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuestionRecordAdapter extends BaseAdapter<FeedbackListModel.DataBeanX.DataBean, QuestionRecordAdapter.VH> {


    public QuestionRecordAdapter(Context mContext) {
        super(mContext);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(mContext).inflate(R.layout.item_question_record, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.tvQuestionType.setText(mDatas.get(position).getType());
        holder.tvTime.setText(mDatas.get(position).getCreate_time());
        holder.tvTime.setText(mDatas.get(position).getCreate_time());
        holder.tvQuestionContent.setText(mDatas.get(position).getContent());
        if (mDatas.get(position).getAnswer() != null) {

        }else {
            holder.tvFeedBackContent.setText("暂未回复");
        }

        holder.itemView.setOnClickListener(v -> {
            if (mOnItemDataClickListener != null) {
                mOnItemDataClickListener.onItemViewClick(v, position, mDatas.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {

        return mDatas == null ? 0 : mDatas.size();
    }

    static class VH extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_question_type)
        TextView tvQuestionType;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_question_content)
        TextView tvQuestionContent;
        @BindView(R.id.iv_kefu)
        ImageView ivKefu;
        @BindView(R.id.tv_feed_back)
        TextView tvFeedBack;
        @BindView(R.id.tv_feed_back_content)
        TextView tvFeedBackContent;

        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
