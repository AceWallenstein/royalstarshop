package com.pinnoocle.royalstarshop.widget;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lxj.xpopup.core.BottomPopupView;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.ItemPledgeDialogAdapter;
import com.pinnoocle.royalstarshop.bean.ServiceBean;

import java.util.List;

public class DialogPledge extends BottomPopupView {
    private final Context mContext;
    private List<ServiceBean> services;
    private ItemPledgeDialogAdapter adapter;

    public DialogPledge(@NonNull Context context, List<ServiceBean> list) {
        super(context);
        this.mContext = context;
        this.services = list;
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.dialog_pledge;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        ImageView iv_close = findViewById(R.id.iv_close);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        adapter = new ItemPledgeDialogAdapter(mContext);
        adapter.setData(services);
        recyclerView.setAdapter(adapter);
        iv_close.setOnClickListener(v -> {
            dismiss();
        });

    }

}