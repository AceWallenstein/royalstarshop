package com.pinnoocle.royalstarshop.home.activity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.library.AutoFlowLayout;
import com.example.library.FlowAdapter;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.MyApp;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.HistoryBean;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.greendao.HistoryBeanDao;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity implements AutoFlowLayout.OnItemClickListener {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_search)
    TextView tvSearch;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.et_home_search)
    EditText etHomeSearch;
    @BindView(R.id.iv_close)
    ImageView ivClose;
    @BindView(R.id.rl_history)
    RelativeLayout rlHistory;
    @BindView(R.id.flow_layout)
    AutoFlowLayout flowLayout;
    @BindView(R.id.iv_delete)
    ImageView ivDelete;
    @BindView(R.id.tv_hint)
    TextView tvHint;
    @BindView(R.id.ll_history)
    LinearLayout llHistory;
    private List<HistoryBean> historyList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        historyList = MyApp.getInstance().getDaoSession().getHistoryBeanDao().queryBuilder().orderDesc(HistoryBeanDao.Properties.Id).list();
        if (historyList != null && historyList.size() > 0) {
            flowLayout.setVisibility(View.VISIBLE);
            ivDelete.setVisibility(View.VISIBLE);
            tvHint.setVisibility(View.GONE);
            flowLayout.setAdapter(new FlowAdapter(historyList) {
                @Override
                public View getView(int position) {
                    View item = LayoutInflater.from(SearchActivity.this).inflate(R.layout.special_item, null);
                    TextView tvAttrTag = (TextView) item.findViewById(R.id.tv_attr_tag);
                    tvAttrTag.setText(historyList.get(position).getName());
                    return item;
                }
            });
        }
        flowLayout.setOnItemClickListener(this);

        etHomeSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() > 0) {
                    ivClose.setVisibility(View.VISIBLE);
                }else {
                    ivClose.setVisibility(View.GONE);
                }
            }
        });
    }

    @OnClick({R.id.iv_back, R.id.tv_search, R.id.iv_close, R.id.iv_delete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_search:
                ((InputMethodManager) etHomeSearch.getContext().getSystemService(Context.INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(
                                getCurrentFocus().getWindowToken(),
                                InputMethodManager.HIDE_NOT_ALWAYS);
                if (etHomeSearch.getText().toString().equals("")) {
                    ToastUtils.showToast("搜索内容不能为空");
                } else {
                    MyApp.getInstance().getDaoSession().getHistoryBeanDao().queryBuilder().where(HistoryBeanDao.Properties.Name.eq(etHomeSearch.getText().toString())).buildDelete().executeDeleteWithoutDetachingEntities();
                    HistoryBean history = new HistoryBean();
                    history.setName(etHomeSearch.getText().toString());
                    MyApp.getInstance().getDaoSession().getHistoryBeanDao().insert(history);
                    llHistory.setVisibility(View.GONE);
                }
                break;
            case R.id.iv_close:
                etHomeSearch.setText("");
                break;
            case R.id.iv_delete:
                MyApp.getInstance().getDaoSession().getHistoryBeanDao().deleteAll();
                flowLayout.clearViews();
                tvHint.setVisibility(View.VISIBLE);
                flowLayout.setVisibility(View.GONE);
                ivDelete.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void onItemClick(int i, View view) {
        etHomeSearch.setText(historyList.get(i).getName());
        MyApp.getInstance().getDaoSession().getHistoryBeanDao().queryBuilder().where(HistoryBeanDao.Properties.Name.eq(etHomeSearch.getText().toString())).buildDelete().executeDeleteWithoutDetachingEntities();
        HistoryBean history = new HistoryBean();
        history.setName(etHomeSearch.getText().toString());
        MyApp.getInstance().getDaoSession().getHistoryBeanDao().insert(history);
        llHistory.setVisibility(View.GONE);
    }
}