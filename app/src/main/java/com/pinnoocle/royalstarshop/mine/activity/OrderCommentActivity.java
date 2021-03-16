package com.pinnoocle.royalstarshop.mine.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.GridViewAdapter;
import com.pinnoocle.royalstarshop.adapter.OrderDetailAdapter;
import com.pinnoocle.royalstarshop.bean.ImageModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.OrderDetailModel;
import com.pinnoocle.royalstarshop.bean.OrderListModel;
import com.pinnoocle.royalstarshop.bean.StatusModel;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.home.activity.TaskBigImgActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.pinnoocle.royalstarshop.widget.GlideEngine;
import com.pinnoocle.royalstarshop.widget.GridViewInScrollView;
import com.tbruyelle.rxpermissions3.RxPermissions;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class OrderCommentActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.iv_record)
    ImageView ivRecord;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.ll_goods)
    LinearLayout llGoods;
    @BindView(R.id.ll_comment_good)
    LinearLayout llCommentGood;
    @BindView(R.id.ll_comment_m)
    LinearLayout llCommentM;
    @BindView(R.id.ll_comment_bad)
    LinearLayout llCommentBad;
    @BindView(R.id.ll_comment_type)
    LinearLayout llCommentType;
    @BindView(R.id.ed_advise)
    EditText edAdvise;
    @BindView(R.id.gridView)
    GridViewInScrollView gridView;
    @BindView(R.id.tv_text_num)
    TextView tvTextNum;
    @BindView(R.id.tv_sure)
    TextView tvSure;
    @BindView(R.id.tv_good)
    TextView tvGood;
    @BindView(R.id.iv_good)
    ImageView ivGood;
    @BindView(R.id.tv_m)
    TextView tvM;
    @BindView(R.id.iv_m)
    ImageView ivM;
    @BindView(R.id.tv_bad)
    TextView tvBad;
    @BindView(R.id.iv_bad)
    ImageView ivBad;
    private DataRepository dataRepository;
    private OrderDetailAdapter adapter;
    private ArrayList<String> mList = new ArrayList<>();
    private List<LocalMedia> selectList = new ArrayList<>();
    private List<String> images = new ArrayList<>();
    private OrderDetailModel orderDetailModel;
    private String score = "10";
    private String content;

    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_comment);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new OrderDetailAdapter(this);
        recyclerView.setAdapter(adapter);
        grid(mList);
    }

    private void initData() {
        dataRepository = Injection.dataRepository(this);
        rxPermissionTest();
        orderDetail();
    }


    private void orderDetail() {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.order_id = getIntent().getStringExtra("order_id");

        ViewLoading.show(this);
        dataRepository.orderDetail(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                orderDetailModel = (OrderDetailModel) data;
                if (orderDetailModel.getCode() == 1) {
                    List<OrderListModel.DataBeanX.ListBean.DataBean.GoodsBean> goods = orderDetailModel.getData().getOrder().getGoods();
                    adapter.setData(goods);
                }
            }
        });
    }


    private void comment(String content, List<String> uploaded) {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.order_id = getIntent().getStringExtra("order_id");
        List<LoginBean.FormData> formDatas = new ArrayList<>();
//        for (int i = 0; i < orderDetailModel.getData().getOrder().getGoods().size(); i++) {
//            LoginBean.FormData formData = new LoginBean.FormData(score, content, orderDetailModel.getData().getOrder().getGoods().get(i).getOrder_goods_id() + "", orderDetailModel.getData().getOrder().getGoods().get(i).getGoods_id() + "");
//            formDatas.add(formData);
//        }
        LoginBean.FormData formData = new LoginBean.FormData(score, content, orderDetailModel.getData().getOrder().getGoods().get(0).getOrder_goods_id() + "", orderDetailModel.getData().getOrder().getGoods().get(0).getGoods_id() + "");
        if (uploaded!=null&&uploaded.size()>0)
            formData.uploaded = uploaded;
        formDatas.add(formData);
        String s = new Gson().toJson(formDatas);
        loginBean.formData = s;


        ViewLoading.show(this);
        dataRepository.comment(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                StatusModel statusModel = (StatusModel) data;
                if (statusModel.getCode() == 1) {
                    finish();
                    EventBus.getDefault().post("order_refresh");
                }
                ToastUtils.showToast(statusModel.getMsg());
            }
        });
    }

    private void image(String path) {
        File file = new File(path);
        RequestBody fileBody = RequestBody.create(MediaType.parse("image/png"), file);
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("iFile", file.getName(), fileBody);
        dataRepository.image("10001", FastData.getToken(), body, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {

            }

            @Override
            public void onSuccess(Object data) {
                ImageModel imageModel = (ImageModel) data;
                if (imageModel.getCode() == 1) {
                    String imgPath = imageModel.getData().getFile_path();
                    images.add(imageModel.getData().getFile_id());
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < images.size(); i++) {
                        if (i == images.size() - 1) {
                            sb.append(images.get(i));
                        } else {
                            sb.append(images.get(i) + ",");
                        }
                    }
                    comment(content, images);
                } else {
                    ToastUtils.showToast(imageModel.getMsg());
                }
            }
        });
    }


    private void grid(ArrayList<String> mList) {
        GridViewAdapter mGridViewAddImgAdapter = new GridViewAdapter(this, mList);

        gridView.setAdapter(mGridViewAddImgAdapter);
        mGridViewAddImgAdapter.setOnItemClickListener(new GridViewAdapter.OnItemClickListener() {
            @Override
            public void onItemViewClick(View view, int position) {
                mList.remove(position);
                mGridViewAddImgAdapter.notifyDataSetChanged();
            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                rxPermissionTest();
            }
        });

    }


    private void viewPluImg(ArrayList<String> list, int index) {
        Intent imgIntent = new Intent(this, TaskBigImgActivity.class);
        imgIntent.putStringArrayListExtra("paths", list);
        imgIntent.putExtra("position", index);
        startActivity(imgIntent);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        selectList = PictureSelector.obtainMultipleResult(data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    for (LocalMedia localMedia : selectList) {
                        String compressPath = localMedia.getCompressPath();
                        mList.add(compressPath);
                    }
                    grid(mList);
                    break;
                default:
                    break;
            }
        }
    }

    private void rxPermissionTest() {
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)
                .subscribe(granted -> {
                    if (granted) {
                        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view,
                                                    int position, long id) {
                                if (position == parent.getChildCount() - 1) {
                                    //如果“增加按钮形状的”图片的位置是最后一张，且添加了的图片的数量不超过5张，才能点击
                                    if (mList.size() == 3) {
                                        viewPluImg(mList, position);
                                    } else {
                                        //添加凭证图片
//                        selectPic();
                                        PictureSelector.create(OrderCommentActivity.this)
                                                .openGallery(PictureMimeType.ofImage())
                                                .selectionMode(PictureConfig.MULTIPLE)
                                                .compress(true)
                                                .loadImageEngine(GlideEngine.createGlideEngine())
                                                .enableCrop(false)
                                                .forResult(PictureConfig.CHOOSE_REQUEST);
                                    }
                                } else {
                                    viewPluImg(mList, position);
                                }
                            }
                        });

//                        PictureSelector
//                                .create(AdviseActivity.this, PictureSelector.SELECT_REQUEST_CODE)
//                                .selectPicture(true);

                    } else {
                        // Oups permission denied
                    }
                });
    }

    private void selectCommentType(TextView textView, ImageView imageView) {
        tvGood.setTextColor(getResources().getColor(R.color.grey_1));
        tvM.setTextColor(getResources().getColor(R.color.grey_1));
        tvBad.setTextColor(getResources().getColor(R.color.grey_1));

        ivGood.setImageResource(R.mipmap.praise_bad);
        ivM.setImageResource(R.mipmap.praise_bad);
        ivBad.setImageResource(R.mipmap.praise_bad);

        textView.setTextColor(getResources().getColor(R.color.light_red));
        imageView.setImageResource(R.mipmap.praise_good);
    }


    @OnClick({R.id.iv_back, R.id.tv_sure, R.id.ll_comment_good, R.id.ll_comment_m, R.id.ll_comment_bad})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_sure:
                content = edAdvise.getText().toString();

                if (selectList != null && selectList.size() > 0) {
                    for (int i = 0; i < selectList.size(); i++) {
                        image(selectList.get(i).getCompressPath());
                    }
                } else {
                    comment(content, null);
                }


                break;

//            (10好评 20中评 30差评)
            case R.id.ll_comment_good:
                score = "10";
                selectCommentType(tvGood, ivGood);
                break;
            case R.id.ll_comment_m:
                score = "20";

                selectCommentType(tvM, ivM);
                break;
            case R.id.ll_comment_bad:
                score = "30";
                selectCommentType(tvBad, ivBad);
                break;
        }
    }

}
