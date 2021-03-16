package com.pinnoocle.royalstarshop.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jaeger.ninegridimageview.NineGridImageView;
import com.jaeger.ninegridimageview.NineGridImageViewAdapter;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.CommentListModel;
import com.pinnoocle.royalstarshop.bean.CommentModel;
import com.pinnoocle.royalstarshop.common.BaseAdapter;
import com.pinnoocle.royalstarshop.home.activity.TaskBigImgActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoodsCommentAdapter extends BaseAdapter<CommentListModel.DataBeanX.ListBean.DataBean, GoodsCommentAdapter.VH> {


    public GoodsCommentAdapter(Context mContext) {
        super(mContext);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(mContext).inflate(R.layout.item_my_comment, parent, false));
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        if (mDatas.get(position).getScore() == 10) {
            holder.ivRating.setImageResource(R.mipmap.praise_good);
            holder.tvRating.setText("好评");
            holder.tvRating.setTextColor(0xffFF2329);
        } else if (mDatas.get(position).getScore() == 20) {
            holder.ivRating.setImageResource(R.mipmap.praise_middle);
            holder.tvRating.setText("中评");
            holder.tvRating.setTextColor(0xffFFAB36);
        } else if (mDatas.get(position).getScore() == 30) {
            holder.ivRating.setImageResource(R.mipmap.praise_bad);
            holder.tvRating.setText("差评");
            holder.tvRating.setTextColor(0xff808080);
        }
        holder.tvContent.setText(mDatas.get(position).getContent());
        holder.tvTime.setText(mDatas.get(position).getCreate_time());
        List<CommentListModel.DataBeanX.ListBean.DataBean.ImageBean> image = mDatas.get(position).getImage();
        List<String> paths = new ArrayList<>();
        for (int i = 0; i < image.size(); i++) {
            paths.add(image.get(i).getFile_path());
        }

        holder.nineGridImageView.setAdapter(new NineGridImageViewAdapter<String>() {
            @Override
            protected void onDisplayImage(Context context, ImageView imageView, String o) {
                Glide.with(context)
                        .load(o)
                        .dontAnimate()
                        .into(imageView);
            }

            @Override
            protected void onItemImageClick(Context context, ImageView imageView, int index, List list) {
                viewPluImg((ArrayList<String>) list, index);
            }
        });
        holder.nineGridImageView.setImagesData(paths);

    }
    private void viewPluImg(ArrayList<String> list, int index) {
        Intent imgIntent = new Intent(mContext, TaskBigImgActivity.class);
        imgIntent.putStringArrayListExtra("paths", list);
        imgIntent.putExtra("position", index);
        mContext.startActivity(imgIntent);
    }


    static class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_rating)
        ImageView ivRating;
        @BindView(R.id.tv_rating)
        TextView tvRating;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.rl_one)
        RelativeLayout rlOne;
        @BindView(R.id.tv_content)
        TextView tvContent;
        @BindView(R.id.nineGridImageView)
        NineGridImageView nineGridImageView;

        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
