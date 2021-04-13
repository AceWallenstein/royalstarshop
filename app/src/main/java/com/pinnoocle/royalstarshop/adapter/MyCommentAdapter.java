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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jaeger.ninegridimageview.NineGridImageView;
import com.jaeger.ninegridimageview.NineGridImageViewAdapter;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.CommentModel;
import com.pinnoocle.royalstarshop.common.BaseAdapter;
import com.pinnoocle.royalstarshop.home.activity.GoodsDetailActivity;
import com.pinnoocle.royalstarshop.home.activity.TaskBigImgActivity;
import com.pinnoocle.royalstarshop.widget.GlideRoundTransform;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class MyCommentAdapter extends BaseAdapter<CommentModel.DataBeanX.DataBean, MyCommentAdapter.VH> {



    public MyCommentAdapter(Context mContext) {
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
        List<CommentModel.DataBeanX.DataBean.ImageBean> image = mDatas.get(position).getImage();
        List<String> paths = new ArrayList<>();
        for (int i = 0; i < image.size(); i++) {
            paths.add(image.get(i).getFile_path());
        }
        InnerImageAdapter adapter = new InnerImageAdapter(mContext);
        holder.recyclerView.setLayoutManager(new GridLayoutManager(mContext,3));
        holder.recyclerView.setAdapter(adapter);

        adapter.setData(paths);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemViewClick(View view, int position) {
                viewPluImg((ArrayList<String>) paths, position);
            }
        });

        Glide.with(mContext).load(mDatas.get(position).getOrder_goods().getImage().getFile_path()).apply(bitmapTransform(new GlideRoundTransform(mContext))).into(holder.ivShop);
        holder.tvTitle.setText(mDatas.get(position).getOrder_goods().getGoods_name());
        holder.tvGoodsPattern.setText(mDatas.get(position).getOrder_goods().getGoods_attr());
        holder.tvPrice.setText("￥" + mDatas.get(position).getOrder_goods().getGoods_price());

        holder.rlGoods.setOnClickListener(v -> {
            Intent intent = new Intent(mContext, GoodsDetailActivity.class);
            intent.putExtra("goods_id", mDatas.get(position).getOrder_goods().getGoods_id() + "");
            mContext.startActivity(intent);
        });


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
        @BindView(R.id.recyclerView)
        RecyclerView recyclerView;
        @BindView(R.id.iv_shop)
        ImageView ivShop;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_goods_pattern)
        TextView tvGoodsPattern;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.tv_num)
        TextView tvNum;
        @BindView(R.id.rl_goods)
        RelativeLayout rlGoods;

        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
