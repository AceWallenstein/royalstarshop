package com.pinnoocle.royalstarshop.adapter;


import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.SuperscriptSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.pinnoocle.royalstarshop.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GridOrderAdapter extends BaseAdapter {

    private final ArrayList<Map<String, Object>> dataList;
    private LayoutInflater layoutInflater;

    private Context context;
    private List<Integer> orderStatusNums = new ArrayList<>();

    public GridOrderAdapter(Context context, ArrayList<Map<String, Object>> dataList) {
        this.dataList = dataList;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public void setOrderStatusNums(List<Integer> orderStatusNums) {
        this.orderStatusNums = orderStatusNums;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

//    private OnItemClickListener mOnItemClickListener;
//
//    public void setItemClickListener(OnItemClickListener mOnItemClickListener) {
//        this.mOnItemClickListener = mOnItemClickListener;
//    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.grid_item_order, null);
            holder = new ViewHolder();
            holder.text = convertView.findViewById(R.id.text);
            holder.image = convertView.findViewById(R.id.image);
            holder.tvDot = convertView.findViewById(R.id.tv_dot);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.text.setText(dataList.get(position).get("text").toString());
        holder.image.setImageResource((Integer) dataList.get(position).get("image"));
        if (orderStatusNums != null && orderStatusNums.size() > 0) {
            if(position<orderStatusNums.size()){

                Integer num = orderStatusNums.get(position);
                if (num > 0) {
                    holder.tvDot.setVisibility(View.VISIBLE);
                    if (num <= 99) {
                        holder.tvDot.setTextSize(8);
                        holder.tvDot.setText(num + "");
                    } else {
                        holder.tvDot.setTextSize(7);
//                holder.tvDot.setText("99+");
                        SpannableString spannableString = new SpannableString("99+");
                        //将+用作上标显示
                        spannableString.setSpan(new SuperscriptSpan(), 2, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        holder.tvDot.setText(spannableString);
                    }
                } else {
                    holder.tvDot.setVisibility(View.GONE);
                }
            }
        }
        return convertView;
    }

    class ViewHolder {
        TextView text;
        TextView tvDot;
        ImageView image;
    }
}
