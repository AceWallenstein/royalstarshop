package com.pinnoocle.royalstarshop.mine.activity;

import android.Manifest;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.GoldenBeanAdapter;
import com.pinnoocle.royalstarshop.adapter.RecommendPosterAdapter;
import com.pinnoocle.royalstarshop.bean.ErCodeModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.PointsModel;
import com.pinnoocle.royalstarshop.bean.PosterModel;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.pinnoocle.royalstarshop.utils.SaveImageUtils;
import com.pinnoocle.royalstarshop.widget.CommItemDecoration;
import com.pinnoocle.royalstarshop.widget.RoundImageView;
import com.tbruyelle.rxpermissions3.RxPermissions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecommendedPosterActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.iv_avatar)
    RoundImageView ivAvatar;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.iv_code)
    ImageView ivCode;
    @BindView(R.id.tv_code)
    TextView tvCode;
    @BindView(R.id.tv_save)
    TextView tvSave;
    @BindView(R.id.tv_apply)
    TextView tvApply;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    private DataRepository dataRepository;
    private RecommendPosterAdapter recommendPosterAdapter;
    private List<ErCodeModel.DataBean.MyInviteBean> data1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initTransparent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommended_poster);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);
        if (TextUtils.isEmpty(getIntent().getStringExtra("avatar"))) {
            ivAvatar.setImageResource(R.drawable.default_avatar);
        } else {
            Glide.with(RecommendedPosterActivity.this).load(getIntent().getStringExtra("avatar")).into(ivAvatar);
        }
        tvName.setText(getIntent().getStringExtra("name"));

        recommendPosterAdapter = new RecommendPosterAdapter(this);
        recycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycleView.setAdapter(recommendPosterAdapter);

        erCode();
    }

    private void erCode() {
        ViewLoading.show(this);
        LoginBean loginBean = new LoginBean();
        loginBean.token = FastData.getToken();
        loginBean.wxapp_id = "10001";
        dataRepository.erCode(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(RecommendedPosterActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(RecommendedPosterActivity.this);
                ErCodeModel erCodeModel = (ErCodeModel) data;
                if (erCodeModel.getCode() == 1) {
                    Glide.with(RecommendedPosterActivity.this).load(erCodeModel.getData().getFile_path()).into(ivCode);
                    tvCode.setText("邀请码：" + erCodeModel.getData().getInvite_code());
                    tvApply.setText(erCodeModel.getData().getCount() + "");
                    tvMoney.setText(erCodeModel.getData().getTotal());

                    data1.addAll(erCodeModel.getData().getMy_invite());
                    recommendPosterAdapter.setData(data1);
                }
            }
        });
    }

    @OnClick({R.id.iv_back, R.id.tv_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_save:
                rxPermissionTest();
                break;
        }
    }

    private void poster() {
        ViewLoading.show(this);
        LoginBean loginBean = new LoginBean();
        loginBean.token = FastData.getToken();
        loginBean.wxapp_id = "10001";
        dataRepository.poster(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(RecommendedPosterActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(RecommendedPosterActivity.this);
                PosterModel posterModel = (PosterModel) data;
                if (posterModel.getCode() == 1) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                final Bitmap myBitmap = Glide.with(RecommendedPosterActivity.this)//上下文
                                        .asBitmap() //必须
                                        .load(posterModel.getData().getPath())//url
                                        .centerCrop()
                                        .into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                                        .get();
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        SaveImageUtils.saveImageToGallerys(RecommendedPosterActivity.this, myBitmap);
                                    }
                                });

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                }
            }
        });
    }

    private void rxPermissionTest() {
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request( Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)
                .subscribe(granted -> {
                    if (granted) {
                        poster();
                    } else {
                        // Oups permission denied
                    }
                });
    }
}