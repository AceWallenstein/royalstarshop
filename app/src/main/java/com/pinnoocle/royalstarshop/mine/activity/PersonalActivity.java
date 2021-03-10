package com.pinnoocle.royalstarshop.mine.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopupext.listener.TimePickerListener;
import com.lxj.xpopupext.popup.TimePickerPopup;
import com.pedaily.yc.ycdialoglib.dialog.loading.ViewLoading;
import com.pedaily.yc.ycdialoglib.dialog.select.CustomSelectDialog;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.ImageModel;
import com.pinnoocle.royalstarshop.bean.LoginBean;
import com.pinnoocle.royalstarshop.bean.ResultModel;
import com.pinnoocle.royalstarshop.bean.UserDetailModel;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.nets.DataRepository;
import com.pinnoocle.royalstarshop.nets.Injection;
import com.pinnoocle.royalstarshop.nets.RemotDataSource;
import com.pinnoocle.royalstarshop.utils.FastData;
import com.pinnoocle.royalstarshop.widget.GlideCircleTransform;
import com.pinnoocle.royalstarshop.widget.GlideEngine;
import com.pinnoocle.royalstarshop.widget.RoundImageView;
import com.tbruyelle.rxpermissions3.RxPermissions;
import com.timmy.tdialog.TDialog;
import com.timmy.tdialog.base.BindViewHolder;
import com.timmy.tdialog.listener.OnBindViewListener;
import com.timmy.tdialog.listener.OnViewClickListener;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class PersonalActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.rl_birth)
    RelativeLayout rlBirth;
    @BindView(R.id.tv_birth)
    TextView tvBirth;
    @BindView(R.id.rl_head)
    RelativeLayout rlHead;
    @BindView(R.id.iv_avatar)
    RoundImageView ivAvatar;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_nickname)
    TextView tvNickname;
    @BindView(R.id.iv_right1)
    ImageView ivRight1;
    @BindView(R.id.rl_nickname)
    RelativeLayout rlNickname;
    private DataRepository dataRepository;
    private EditText ed_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initWhite();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        ButterKnife.bind(this);
        dataRepository = Injection.dataRepository(this);
        userInfo();
    }

    private void userInfo() {
        LoginBean loginBean = new LoginBean();
        loginBean.token = FastData.getToken();
        loginBean.wxapp_id = "10001";
        dataRepository.userDetail(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {

            }

            @Override
            public void onSuccess(Object data) {
                UserDetailModel userDetailModel = (UserDetailModel) data;
                if (userDetailModel.getCode() == 1) {
                    if (TextUtils.isEmpty(userDetailModel.getData().getUserInfo().getBirth())) {
                        tvBirth.setText("");
                    }else {
                        tvBirth.setText(userDetailModel.getData().getUserInfo().getBirth());
                    }
                    if (TextUtils.isEmpty(userDetailModel.getData().getUserInfo().getAvatarUrl())) {
                        ivAvatar.setImageResource(R.drawable.default_avatar);
                    } else {
                        Glide.with(PersonalActivity.this).load(userDetailModel.getData().getUserInfo().getAvatarUrl()).into(ivAvatar);
                    }
                    tvNickname.setText(userDetailModel.getData().getUserInfo().getNickName());
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < userDetailModel.getData().getUserInfo().getPhone().length(); i++) {
                        char c = userDetailModel.getData().getUserInfo().getPhone().charAt(i);
                        if (i >= 3 && i <= 6) {
                            sb.append('*');
                        } else {
                            sb.append(c);
                        }
                    }
                    tvPhone.setText(sb.toString());
                }
            }
        });
    }

    @OnClick({R.id.iv_back, R.id.rl_birth, R.id.rl_head, R.id.rl_nickname})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_birth:
                showTimerPickerPopup(tvBirth);
                break;
            case R.id.rl_head:
                rxPermissionTest();
                break;
            case R.id.rl_nickname:
                new TDialog.Builder(getSupportFragmentManager())
                        .setLayoutRes(R.layout.dialog_one)
                        .setScreenWidthAspect(this, 0.7f)
                        .setGravity(Gravity.CENTER)
                        .setCancelableOutside(false)
                        .addOnClickListener(R.id.tv_cancel, R.id.tv_sure)
                        .setOnBindViewListener(new OnBindViewListener() {
                            @Override
                            public void bindView(BindViewHolder viewHolder) {
                                ed_name = viewHolder.itemView.findViewById(R.id.ed_name);
                            }
                        })
                        .setOnViewClickListener(new OnViewClickListener() {
                            @Override
                            public void onViewClick(BindViewHolder viewHolder, View view, TDialog tDialog) {
                                switch (view.getId()) {
                                    case R.id.tv_cancel:
                                        tDialog.dismiss();
                                        break;
                                    case R.id.tv_sure:
                                        tDialog.dismiss();
                                        LoginBean loginBean = new LoginBean();
                                        loginBean.token = FastData.getToken();
                                        loginBean.nickName = ed_name.getText().toString();
                                        loginBean.wxapp_id = "10001";
                                        changeInfo(loginBean, "2");
                                        break;
                                }
                            }
                        })
                        .create()
                        .show();
                break;
        }
    }

    private void rxPermissionTest() {
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)
                .subscribe(granted -> {
                    if (granted) {
                        showCustomDialog();
                    } else {
                        // Oups permission denied
                    }
                });
    }

    private void showCustomDialog() {
        final List<String> names = new ArrayList<>();
        names.add("拍照");
        names.add("相册");
        showDialog(new CustomSelectDialog.SelectDialogListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                if (position == 0) {
                    openCamera();
                } else {
                    openAlbum();
                }
            }
        }, names);
    }

    private void openCamera() {
        PictureSelector.create(this)
                .openCamera(PictureMimeType.ofImage())
                .enableCrop(true)
                .compress(true)
                .forResult(PictureConfig.REQUEST_CAMERA);
    }

    private void openAlbum() {
        PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage())
                .selectionMode(PictureConfig.SINGLE)
                .loadImageEngine(GlideEngine.createGlideEngine())
                .enableCrop(true)
                .compress(true)
                .forResult(PictureConfig.CHOOSE_REQUEST);
    }

    private CustomSelectDialog showDialog(CustomSelectDialog.SelectDialogListener listener,
                                          List<String> names) {
        CustomSelectDialog dialog = new CustomSelectDialog(this,
                R.style.transparentFrameWindowStyle, listener, names);
        dialog.setItemColor(R.color.black, R.color.black);
        //判断activity是否finish
        if (!this.isFinishing()) {
            dialog.show();
        }
        return dialog;
    }

    private void showTimerPickerPopup(TextView textView) {
        TimePickerPopup popup = new TimePickerPopup(this)
                .setTimePickerListener(new TimePickerListener() {
                    @Override
                    public void onTimeChanged(Date date) {

                    }

                    @Override
                    public void onTimeConfirm(Date date, View view) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        textView.setText(simpleDateFormat.format(date));

                        LoginBean loginBean = new LoginBean();
                        loginBean.token = FastData.getToken();
                        loginBean.birth = simpleDateFormat.format(date);
                        loginBean.wxapp_id = "10001";
                        changeInfo(loginBean, "3");
                    }
                });

        new XPopup.Builder(this)
                .asCustom(popup)
                .show();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.REQUEST_CAMERA:
                    for (LocalMedia localMedia : selectList) {
                        String compressPath = localMedia.getCompressPath();
                        File file = new File(compressPath);
                        image(file);
                    }
                    break;
                case PictureConfig.CHOOSE_REQUEST:
                    for (LocalMedia localMedia : selectList) {
                        String compressPath = localMedia.getCompressPath();
                        File file = new File(compressPath);
                        image(file);
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private void image(File file) {
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
                    LoginBean loginBean = new LoginBean();
                    loginBean.token = FastData.getToken();
                    loginBean.avatarUrl = imageModel.getData().getFile_path();
                    loginBean.wxapp_id = "10001";
                    changeInfo(loginBean, "1");
                } else {
                    ToastUtils.showToast(imageModel.getMsg());
                }
            }
        });
    }

    private void changeInfo(LoginBean loginBean, String type) {
        ViewLoading.show(this);
        dataRepository.changeInfo(loginBean, new RemotDataSource.getCallback() {
            @Override
            public void onFailure(String info) {
                ViewLoading.dismiss(PersonalActivity.this);
            }

            @Override
            public void onSuccess(Object data) {
                ViewLoading.dismiss(PersonalActivity.this);
                ResultModel data1 = (ResultModel) data;
                if (data1.getCode() == 1) {
                    ToastUtils.showToast("修改成功");
                    if (type.equals("1")) {
                        Glide.with(PersonalActivity.this).load(loginBean.avatarUrl).apply(bitmapTransform(new GlideCircleTransform(PersonalActivity.this))).into(ivAvatar);
                    } else if (type.equals("2")) {
                        tvNickname.setText(ed_name.getText().toString());
                    }
                    EventBus.getDefault().post("4");
                }
            }
        });
    }

}