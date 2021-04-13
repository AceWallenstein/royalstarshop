package com.pinnoocle.royalstarshop.mine.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.adapter.GridViewAdapter;
import com.pinnoocle.royalstarshop.adapter.OrderAfterSalesAdapter;
import com.pinnoocle.royalstarshop.bean.ImageModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.OrderDetailModel;
import com.pinnoocle.royalstarshop.bean.ResultModel;
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
import java.util.concurrent.atomic.AtomicInteger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.FuncN;
import rx.schedulers.Schedulers;

public class ApplyForAfterSalesActivity extends BaseActivity {
    @BindView(R.id.iv_bg)
    ImageView ivBg;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_exchange_goods)
    TextView tvExchangeGoods;
    @BindView(R.id.tv_return_goods)
    TextView tvReturnGoods;
    @BindView(R.id.rl_address)
    RelativeLayout rlAddress;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.ll_tips)
    LinearLayout llTips;
    @BindView(R.id.tv_reason)
    TextView tvReason;
    @BindView(R.id.ed_advise)
    EditText edAdvise;
    @BindView(R.id.gridView)
    GridViewInScrollView gridView;
    @BindView(R.id.tv_text_num)
    TextView tvTextNum;
    @BindView(R.id.iv_no_question)
    ImageView ivNoQuestion;
    @BindView(R.id.tv_no_question)
    TextView tvNoQuestion;
    @BindView(R.id.rl_2)
    RelativeLayout rl2;
    @BindView(R.id.tv_sure)
    TextView tvSure;
    @BindView(R.id.tv_order_time)
    TextView tvOrderTime;
    @BindView(R.id.tv_order_code_1)
    TextView tvOrderCode1;
    @BindView(R.id.tv_order_code)
    TextView tvOrderCode;
    @BindView(R.id.tv_contact_after_sales)
    TextView tvContactAfterSales;
    @BindView(R.id.rl_1)
    RelativeLayout rl1;
    private DataRepository dataRepository;
    private OrderAfterSalesAdapter adapter;
    private String type = "20";
    private List<String> images = new ArrayList<>();
    private ArrayList<String> mList = new ArrayList<>();
    private List<LocalMedia> selectList = new ArrayList<>();
    private AtomicInteger carSize = new AtomicInteger();
    StringBuilder sb = new StringBuilder();

    List<String> imagePath = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initRed();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_for_aftersales);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        selectType(tvExchangeGoods);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new OrderAfterSalesAdapter(this);
        recyclerView.setAdapter(adapter);
        grid(mList);
    }

    private void initData() {
        dataRepository = Injection.dataRepository(this);
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
                OrderDetailModel orderDetailModel = (OrderDetailModel) data;
                if (orderDetailModel.getCode() == 1) {
                    tvOrderCode.setText(orderDetailModel.getData().getOrder().getOrder_no());
                    tvOrderTime.setText(orderDetailModel.getData().getOrder().getCreate_time());
                    List<OrderDetailModel.DataBean.OrderBean.GoodsBeanX> goods = orderDetailModel.getData().getOrder().getGoods();
                    List<OrderDetailModel.DataBean.OrderBean.GoodsBeanX> select = new ArrayList<>();
                    for (int i = 0; i < goods.size(); i++) {
                        if (goods.get(i).getOrder_goods_id() == getIntent().getIntExtra("order_goods_id", 0)) {
                            select.add(goods.get(i));
                        }

                    }
                    if (orderDetailModel.getData().getOrder().getIs_vip_order() == 1) {
                        adapter.setIsVipGoods(true);
                    } else {
                        adapter.setIsVipGoods(false);
                    }
                    adapter.setData(select);
                    if (orderDetailModel.getData().getOrder().getState_text().equals("待发货")) {
                        tvExchangeGoods.setVisibility(View.GONE);
                        selectType(tvReturnGoods);
                    } else {
                        tvExchangeGoods.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
    }

    private void applyRefund(String content, String images) {
        LoginBean loginBean = new LoginBean();
        loginBean.wxapp_id = "10001";
        loginBean.token = FastData.getToken();
        loginBean.order_goods_id = getIntent().getIntExtra("order_goods_id", 0) + "";
        loginBean.type = type;
        loginBean.content = content;
        loginBean.images = images;

        ViewLoading.show(this);
        dataRepository.applyRefund(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(mContext);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(mContext);
                ResultModel resultModel = (ResultModel) data;
                if (resultModel.getCode() == 1) {
                    EventBus.getDefault().post("1001");
                    finish();
                }
                ToastUtils.showToast(resultModel.getMsg());
            }
        });
    }

    private void images(List<String> paths) {
        List<Observable<ImageModel>> requests = new ArrayList<>();
        for (int i = 0; i < paths.size(); i++) {
            String path = paths.get(i);
            File file = new File(path);
            RequestBody fileBody = RequestBody.create(MediaType.parse("image/png"), file);
            MultipartBody.Part body =
                    MultipartBody.Part.createFormData("iFile", file.getName(), fileBody);
            requests.add(dataRepository.imageObservable("10001", FastData.getToken(), body));
        }
        Observable.zip(
                requests, new FuncN<List<String>>() {
                    @Override
                    public List<String> call(Object... args) {
                        for (int i = 0; i < args.length; i++) {
                            images.add(((ImageModel) args[i]).getData().getFile_path());
                        }
                        return images;
                    }
                }
        ).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())// After all requests had been performed the next observer will receive the Object, returned from Function
                .subscribe(new Subscriber<List<String>>() {
                               @Override
                               public void onCompleted() {

                               }

                               @Override
                               public void onError(Throwable e) {

                               }

                               @Override
                               public void onNext(List<String> images) {
                                   StringBuilder sb = new StringBuilder();
                                   for (int i = 0; i < images.size(); i++) {
                                       if (i == images.size() - 1) {
                                           sb.append(images.get(i));
                                       } else {
                                           sb.append(images.get(i) + ",");
                                       }
                                   }
                                   applyRefund(edAdvise.getText().toString(), sb.toString());
                               }
                           }
                );
    }


    private void image(String path) {
        File file = new File(path);
        RequestBody fileBody = RequestBody.create(MediaType.parse("image/png"), file);
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("iFile", file.getName(), fileBody);
        dataRepository.image("10001", FastData.getToken(), body, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                carSize.getAndIncrement();
            }

            @Override
            public void onSuccess(Object data) {
                carSize.getAndIncrement();
                ImageModel imageModel = (ImageModel) data;
                if (imageModel.getCode() == 1) {
                    String imgPath = imageModel.getData().getFile_path();
                    images.add(imgPath);


                    for (int i = 0; i < images.size(); i++) {
                        if (i == images.size() - 1) {
                            sb.append(images.get(i));
                        } else {
                            sb.append(images.get(i) + ",");
                        }
                    }
                    if (carSize.get() >= selectList.size()){
                        applyRefund(edAdvise.getText().toString(), sb.toString());
                    }

                } else {
                    ToastUtils.showToast(imageModel.getMsg());
                }
            }
        });
    }


    private void selectType(TextView textView) {
        tvExchangeGoods.setTextColor(getResources().getColor(R.color.black_3));
        tvReturnGoods.setTextColor(getResources().getColor(R.color.black_3));
        tvExchangeGoods.setBackground(getResources().getDrawable(R.drawable.bg_stroke_17));
        tvReturnGoods.setBackground(getResources().getDrawable(R.drawable.bg_stroke_17));

        textView.setTextColor(getResources().getColor(R.color.light_red_2));
        textView.setBackground(getResources().getDrawable(R.drawable.bg_red_stroke_17));

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
                                        PictureSelector.create(ApplyForAfterSalesActivity.this)
                                                .openGallery(PictureMimeType.ofImage())
                                                .selectionMode(PictureConfig.MULTIPLE)
                                                .compress(true)
                                                .maxSelectNum(3)
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


    @OnClick({R.id.iv_back, R.id.tv_exchange_goods, R.id.tv_return_goods, R.id.tv_sure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_exchange_goods:
                type = "20";
                tvReason.setText("换货原因");
                selectType(tvExchangeGoods);
                break;
            case R.id.tv_return_goods:
                type = "10";
                tvReason.setText("退货原因");
                selectType(tvReturnGoods);

                break;
            case R.id.tv_sure:
                if (TextUtils.isEmpty(edAdvise.getText().toString())) {
                    ToastUtils.showToast("请输入退换货原因");
                    return;
                }

                if (selectList != null && selectList.size() > 0) {
                    for (int i = 0; i < selectList.size(); i++) {
                        image(selectList.get(i).getCompressPath());
                    }
                } else {
                    applyRefund(edAdvise.getText().toString(), "");
                }
                break;
        }
    }
}
