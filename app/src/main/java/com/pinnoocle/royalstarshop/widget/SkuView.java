package com.pinnoocle.royalstarshop.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.GoodsDetailModel;
import com.pinnoocle.royalstarshop.bean.GoodsSku;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class SkuView extends FrameLayout {


    private GoodsSku mGoodsSku;
    private TextView tvSpec;
    private TagFlowLayout flowlayout;
    private int position;

    public TagFlowLayout getFlowlayout() {
        return flowlayout;
    }

    public int getCurrentId() {
        return currentId;
    }

    private int currentId;

    public SkuView(@NonNull Context context) {
        this(context, null);
        initView();
    }

    public SkuView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
        initView();

    }

    public SkuView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {

        View.inflate(getContext(), R.layout.layout_sku_view, this);
        tvSpec = findViewById(R.id.tv_spec);
        flowlayout = findViewById(R.id.flowlayout);
    }


    /*
    动态设置SKU数据
     */
    public void setSkuData(String group_name, List<GoodsDetailModel.DataBean.SpecDataBean.SpecAttrBeanX.SpecItemsBeanX> spec_items) {
        tvSpec.setText(group_name);
        //FlowLayout设置数据
        flowlayout.setAdapter(new TagAdapter<GoodsDetailModel.DataBean.SpecDataBean.SpecAttrBeanX.SpecItemsBeanX>(spec_items) {
            @Override
            public void onSelected(int position, View view) {
                super.onSelected(position, view);
                TextView textView = view.findViewById(R.id.text);
                textView.setTextColor(Color.WHITE);
                currentId = spec_items.get(position).getItem_id();

            }

            @Override
            public void unSelected(int position, View view) {
                super.unSelected(position, view);
                TextView textView = view.findViewById(R.id.text);
                textView.setTextColor(Color.BLACK);

            }

            @Override
            public TextView getView(FlowLayout parent, int position,GoodsDetailModel.DataBean.SpecDataBean.SpecAttrBeanX.SpecItemsBeanX s) {
                TextView view = (TextView) LayoutInflater.from(getContext())
                        .inflate(R.layout.layout_sku_item, parent, false);
                view.setText(s.getSpec_value());
                return view;
            }
        });
        flowlayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {

                return true;
            }
        });
        flowlayout.getAdapter().setSelectedList(0);

    }

    public boolean isSelectNone() {
        return flowlayout.getSelectedList().size() == 0 ? true : false;
    }

    /*
    获取选择的SKU
     */


    public void setPosition(int i) {
        this.position = i;
    }
}
