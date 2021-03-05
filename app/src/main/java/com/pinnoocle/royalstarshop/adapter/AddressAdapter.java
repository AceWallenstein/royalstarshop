package com.pinnoocle.royalstarshop.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.AddressListModel;
import com.pinnoocle.royalstarshop.common.BaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddressAdapter extends BaseAdapter<AddressListModel.DataBean.ListBean, AddressAdapter.VH> {


    private int default_id = -1;

    public AddressAdapter(Context mContext) {
        super(mContext);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(mContext).inflate(R.layout.item_address, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.tvPersonName.setText(mDatas.get(position).getName());
        if (!TextUtils.isEmpty(mDatas.get(position).getPhone()) && mDatas.get(position).getPhone().length() > 6) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mDatas.get(position).getPhone().length(); i++) {
                char c = mDatas.get(position).getPhone().charAt(i);
                if (i >= 3 && i <= 6) {
                    sb.append('*');
                } else {
                    sb.append(c);
                }
            }
            holder.tvPhone.setText(sb.toString());
        }
        holder.checkBox.setChecked(mDatas.get(position).getAddress_id() == default_id);//1表示默认地址
        if (mDatas.get(position).getAddress_id() == default_id) {
            holder.tvCheck.setText("默认");
        }else {
            holder.tvCheck.setText("选择");
        }
        holder.tvAddress.setText(mDatas.get(position).getRegion().getProvince() + mDatas.get(position).getRegion().getCity() + mDatas.get(position).getRegion().getRegion());
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    holder.tvCheck.setText("默认");
                } else {
                    holder.tvCheck.setText("选择");
                }
            }
        });
        holder.itemView.setOnClickListener(v -> mOnItemDataClickListener.onItemViewClick(v, position, mDatas.get(position)));
        holder.ll_check.setOnClickListener(v -> mOnItemDataClickListener.onItemViewClick(v, position, mDatas.get(position)));
        holder.tvDelete.setOnClickListener(v -> mOnItemDataClickListener.onItemViewClick(v, position, mDatas.get(position)));
        holder.tvEdit.setOnClickListener(v -> mOnItemDataClickListener.onItemViewClick(v, position, mDatas.get(position)));
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();

    }

    public void setDefaultId(int default_id) {
        this.default_id = default_id;
    }


    public static class VH extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_person_name)
        TextView tvPersonName;
        @BindView(R.id.tv_phone)
        TextView tvPhone;
        @BindView(R.id.tv_address)
        TextView tvAddress;
        @BindView(R.id.cb_check)
        CheckBox checkBox;
        @BindView(R.id.tv_check)
        TextView tvCheck;
        @BindView(R.id.tv_delete)
        TextView tvDelete;
        @BindView(R.id.tv_del)
        TextView tvEdit;
        @BindView(R.id.ll_check)
        LinearLayout ll_check;


        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
