package com.pinnoocle.royalstarshop.home.activity;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;

import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.FragmentTabAdapter;
import com.pinnoocle.royalstarshop.bean.CommentListModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.home.fragment.GoodsCommentFragment;
import com.pinnoocle.royalstarshop.home.fragment.HomeFragment;
import com.pinnoocle.royalstarshop.mine.fragment.MineFragment;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.shoppingcart.ShoppingCartFragment;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.pinnoocle.royalstarshop.video.VideoFragment;
import com.pinnoocle.royalstarshop.vip.VipFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GoodsCommentActivity extends BaseActivity {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.rb_all)
    RadioButton rbAll;
    @BindView(R.id.rb_good)
    RadioButton rbGood;
    @BindView(R.id.rb_m)
    RadioButton rbM;
    @BindView(R.id.rb_bad)
    RadioButton rbBad;
    @BindView(R.id.radiogroup)
    RadioGroup radiogroup;
    @BindView(R.id.fl_layout)
    FrameLayout flLayout;

    private DataRepository dataRepository;
    private List<Fragment> fragments = new ArrayList<>();
    private FragmentTabAdapter tabAdapter;


    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_goods_comment);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        String goods_id = getIntent().getStringExtra("goods_id");
        fragments.add(new GoodsCommentFragment(goods_id,""));
        fragments.add(new GoodsCommentFragment(goods_id,"10"));
        fragments.add(new GoodsCommentFragment(goods_id,"20"));
        fragments.add(new GoodsCommentFragment(goods_id,"30"));
        tabAdapter = new FragmentTabAdapter(this, fragments, R.id.fl_layout);
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_all:
                        tabAdapter.setCurrentFragment(0);
                        break;
                    case R.id.rb_good:
                        tabAdapter.setCurrentFragment(1);
                        break;
                    case R.id.rb_m:
                        tabAdapter.setCurrentFragment(2);
                        break;
                    case R.id.rb_bad:
                        tabAdapter.setCurrentFragment(3);
                        break;
                }
            }
        });
//        initListener();
    }


    protected void initListener() {
        tabAdapter.setOnTabChangeListener(new FragmentTabAdapter.OnTabChangeListener() {
            @Override
            public void OnTabChanged(int index) {
//                tvTabHome.setTextColor(getResources().getColor(R.color.grey));
//                tvTabVideo.setTextColor(getResources().getColor(R.color.grey));
//                tvTabVip.setTextColor(getResources().getColor(R.color.grey));
                switch (index) {
                    case 0:

                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;

                }
            }
        });
    }

    private void initRb(RadioButton rb) {
        rbGood.setTextColor(0x333333);
        rbAll.setTextColor(0x333333);
        rbM.setTextColor(0x333333);
        rbBad.setTextColor(0x333333);

        rb.setTextColor(0xffffff);
    }


    private void initData() {
        dataRepository = Injection.dataRepository(this);
        commentList();
    }


    private void commentList() {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.goods_id = getIntent().getStringExtra("goods_id");
        ViewLoading.show(this);
        dataRepository.commentList(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                CommentListModel commentListModel = (CommentListModel) data;
                if (commentListModel.getCode() == 1) {
                    int all = commentListModel.getData().getTotal().getAll();
                    int goods = commentListModel.getData().getTotal().getPraise();
                    int review = commentListModel.getData().getTotal().getReview();
                    int bad = commentListModel.getData().getTotal().getNegative();
                    String all_ = dealNum(all);
                    String goods_ = dealNum(goods);
                    String review_ = dealNum(review);
                    String bad_ = dealNum(bad);
                    rbAll.setText("全部(" + all_ + ")");
                    rbGood.setText("好评(" + goods_ + ")");
                    rbM.setText("中评(" + review_ + ")");
                    rbBad.setText("差评(" + bad_ + ")");
                }

            }
        });
    }

    private String dealNum(int all) {
        if (all > 99) {
            return "99+";
        }
        return all + "";
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
