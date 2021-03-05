package com.pinnoocle.royalstarshop.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.GoodsListsModel;
import com.pinnoocle.royalstarshop.widget.GlideCircleTransform;
import com.pinnoocle.royalstarshop.widget.GlideRoundTransform;

import java.util.List;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;


/**
 * @author: xl
 * @date: 2017/7/19
 */

public class AdoptAdapter extends RecyclerView.Adapter<AdoptAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private Context context;
    private List<GoodsListsModel.DataBeanX.ListBean.DataBean> dataBeanList;

    public AdoptAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_video_shop, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
//        holder.tv_see_num.setText(dataBeanList.get(position).);
        holder.tv_name.setText(dataBeanList.get(position).getGoods_name());
        holder.tv_money.setText(dataBeanList.get(position).getGoods_sku().getGoods_price());
        holder.tv_sales.setText(dataBeanList.get(position).getGoods_sku().getGoods_sales() + "件已售");
        holder.tv_vip_price.setText("会员￥" + dataBeanList.get(position).getGoods_sku().getBalance_price());
        Glide.with(context).load(dataBeanList.get(position).getGoods_image()).apply(bitmapTransform(new GlideRoundTransform(context))).into(holder.iv_image);

        holder.iv_image.setOnClickListener(v ->
        {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(position);
            }
        });
    }

    public void setData(List<GoodsListsModel.DataBeanX.ListBean.DataBean> dataBeans) {
        this.dataBeanList = dataBeans;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataBeanList == null ? 0 : dataBeanList.size();
    }

    //**********************itemClick************************
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }
    //**************************************************************

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_image;
        private TextView tv_see_num;
        private TextView tv_name;
        private TextView tv_money;
        private TextView tv_vip_price;
        private TextView tv_sales;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_image = itemView.findViewById(R.id.iv_image);
            tv_see_num = itemView.findViewById(R.id.tv_see_num);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_money = itemView.findViewById(R.id.tv_money);
            tv_vip_price = itemView.findViewById(R.id.tv_vip_price);
            tv_sales = itemView.findViewById(R.id.tv_sales);
        }
    }
}
