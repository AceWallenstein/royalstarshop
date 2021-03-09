package com.pinnoocle.royalstarshop.video;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.core.app.ActivityCompat;

import com.bumptech.glide.Glide;
import com.pedaily.yc.ycdialoglib.toast.ToastUtils;
import com.pinnoocle.royalstarshop.R;
import com.pinnoocle.royalstarshop.bean.GoodsListsModel;
import com.pinnoocle.royalstarshop.common.BaseActivity;
import com.pinnoocle.royalstarshop.receiver.NetUtils;
import com.pinnoocle.royalstarshop.widget.GlideRoundTransform;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class VideoDetailActivity extends BaseActivity {

    @BindView(R.id.iv_close)
    ImageView ivClose;
    @BindView(R.id.videoView)
    VideoView videoView;
    @BindView(R.id.iv_image)
    ImageView ivImage;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.ll_money)
    LinearLayout llMoney;
    @BindView(R.id.ll_buy)
    LinearLayout llBuy;
    @BindView(R.id.rl_goods_detail)
    RelativeLayout rlGoodsDetail;
    @BindView(R.id.iv_thumb)
    ImageView ivThumb;
    @BindView(R.id.iv_start)
    ImageView ivStart;
    @BindView(R.id.video_view_container)
    RelativeLayout videoViewContainer;
    @BindView(R.id.iv_loading)
    ImageView ivLoading;
    @BindView(R.id.start_time)
    TextView startTime;
    @BindView(R.id.seek)
    SeekBar seek;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.iv_volume)
    ImageView ivVolume;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_vip_price)
    TextView tvVipPrice;
    @BindView(R.id.tv_sales)
    TextView tvSales;
    private ObjectAnimator bufferAnimation;
    private Handler mHandler = new Handler();
    private Runnable mRunnable;
    private int currentProgress;
    private boolean isPlayOver = false;
    private boolean isVolume = true;
    private AudioManager mAudioManager;
    private List<GoodsListsModel.DataBeanX.ListBean.DataBean> dataBeanList = new ArrayList<>();
    private int pos;
    private int time;

    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100, sticky = false) //在ui线程执行，优先级为100
    public void onEvent(String event) {
        if (event.equals("1")) {
            if (time == 0) {
                ivStart.setVisibility(View.GONE);
                ivThumb.setVisibility(View.GONE);
                ivLoading.setVisibility(View.VISIBLE);
                startBufferAnimation();
                String videoUrl2 = dataBeanList.get(pos).getVideo().getFile_path();
                //设置视频控制器
//                videoView.setMediaController(new MediaController(this));
                //播放完成回调
                videoView.setOnCompletionListener(new MyPlayerOnCompletionListener());
                //设置视频路径
                videoView.setVideoPath(videoUrl2);
                videoView.requestFocus();
                videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        ivLoading.setVisibility(View.GONE);
                        stopBufferAnimation();
                        mp.setVideoScalingMode(MediaPlayer.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING);
                        seek.setVisibility(View.VISIBLE);
                        startTime.setVisibility(View.VISIBLE);
                        tvTime.setVisibility(View.VISIBLE);
                        ivVolume.setVisibility(View.VISIBLE);
                        tvTime.setText(stringForTime(videoView.getDuration()));
                        mHandler.post(mRunnable);
                        mp.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                            @Override
                            public boolean onInfo(MediaPlayer mp, int what, int extra) {
                                if (what == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START) {
//                                    // video 视屏播放的时候把背景设置为透明
                                    videoView.setBackgroundColor(Color.TRANSPARENT);
                                    return true;
                                }
                                return false;
                            }
                        });
                    }
                });
                //开始播放视频
                videoView.start();
            } else {
                ivStart.setVisibility(View.GONE);
                videoView.start();
            }
        } else if (event.equals("2")) {
            if (videoView.isPlaying()) {
                time = videoView.getCurrentPosition();
                videoView.pause();
                ivStart.setVisibility(View.VISIBLE);
            }
            if (NetUtils.isConnected(this)) {
                ToastUtils.showToast("您当前处于移动网络状态，请注意流量使用");
            } else {
                ToastUtils.showToast("当前无网络连接");
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initBlack();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_detail);
        ButterKnife.bind(this);

        dataBeanList = (List<GoodsListsModel.DataBeanX.ListBean.DataBean>) getIntent().getSerializableExtra("dataBeanList");
        pos = getIntent().getIntExtra("pos", -1);
        Glide.with(this).load(dataBeanList.get(pos).getGoods_image()).into(ivThumb);
        Glide.with(this).load(dataBeanList.get(pos).getGoods_image()).apply(bitmapTransform(new GlideRoundTransform(this))).into(ivImage);
        tvName.setText(dataBeanList.get(pos).getGoods_name());
        tvMoney.setText(dataBeanList.get(pos).getGoods_sku().getGoods_price());
        tvSales.setText(dataBeanList.get(pos).getGoods_sku().getGoods_sales() + "件已售");
        tvVipPrice.setText("会员￥" + dataBeanList.get(pos).getGoods_sku().getBalance_price());

        verifyStoragePermissions(this);

        mRunnable = new Runnable() {
            @Override
            public void run() {
                if (videoView != null) {
                    float position = videoView.getCurrentPosition();
                    currentProgress = (int) ((position / videoView.getDuration()) * 100);
                    if (!isPlayOver) {
                        seek.setProgress(currentProgress);
                    }
                    startTime.setText(stringForTime((int) position));
                    mHandler.postDelayed(mRunnable, 500);
                }
            }
        };

        mAudioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (videoView != null) {
                    int position = (int) ((seekBar.getProgress() * 1.0f /
                            seekBar.getMax()) * videoView.getDuration());
                    videoView.seekTo(position);
                }
            }
        });
    }

    private Bitmap createVideoThumbnail(String url) {
        Bitmap bitmap = null;
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        int kind = MediaStore.Video.Thumbnails.MINI_KIND;
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                retriever.setDataSource(url, new HashMap<String, String>());
            } else {
                retriever.setDataSource(url);
            }
            bitmap = retriever.getFrameAtTime();
        } catch (IllegalArgumentException ex) {
            // Assume this is a corrupt video file
        } catch (RuntimeException ex) {
            // Assume this is a corrupt video file.
        } finally {
            try {
                retriever.release();
            } catch (RuntimeException ex) {
                // Ignore failures while cleaning up.
            }
        }
        return bitmap;
    }

    //设置读写权限
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE"
    };

    public static void verifyStoragePermissions(Activity activity) {
        try {
            //检测是否有写的权限
            int permission = ActivityCompat.checkSelfPermission(activity,
                    "android.permission.WRITE_EXTERNAL_STORAGE");
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // 没有写的权限，去申请写的权限，会弹出对话框
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClick({R.id.iv_close, R.id.iv_start, R.id.iv_volume})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_volume:
                if (isVolume) {
                    ivVolume.setImageResource(R.mipmap.stop);
                    isVolume = false;
                    mAudioManager.setStreamMute(AudioManager.STREAM_MUSIC, true);
                } else {
                    ivVolume.setImageResource(R.mipmap.volume);
                    isVolume = true;
                    mAudioManager.setStreamMute(AudioManager.STREAM_MUSIC, false);
                }
                break;
            case R.id.iv_close:
                finish();
                break;
            case R.id.iv_start:
                if (!videoView.isPlaying()) {
                    ivStart.setVisibility(View.GONE);
                    ivThumb.setVisibility(View.GONE);
                    ivLoading.setVisibility(View.VISIBLE);
                    startBufferAnimation();
                    String videoUrl2 = dataBeanList.get(pos).getVideo().getFile_path();
                    //设置视频控制器
//                videoView.setMediaController(new MediaController(this));
                    //播放完成回调
                    videoView.setOnCompletionListener(new MyPlayerOnCompletionListener());
                    //设置视频路径
                    videoView.setVideoPath(videoUrl2);
                    videoView.requestFocus();
                    videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            ivLoading.setVisibility(View.GONE);
                            stopBufferAnimation();
                            mp.setVideoScalingMode(MediaPlayer.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING);
                            seek.setVisibility(View.VISIBLE);
                            startTime.setVisibility(View.VISIBLE);
                            tvTime.setVisibility(View.VISIBLE);
                            ivVolume.setVisibility(View.VISIBLE);
                            tvTime.setText(stringForTime(videoView.getDuration()));
                            mHandler.post(mRunnable);
                            mp.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                                @Override
                                public boolean onInfo(MediaPlayer mp, int what, int extra) {
                                    if (what == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START) {
//                                    // video 视屏播放的时候把背景设置为透明
                                        videoView.setBackgroundColor(Color.TRANSPARENT);
                                        return true;
                                    }
                                    return false;
                                }
                            });
                        }
                    });
                    //开始播放视频
                    videoView.start();
                } else {
                    videoView.start();
                }
                break;
        }
    }

    private String stringForTime(int timeMs) {
        if (timeMs <= 0 || timeMs >= 24 * 60 * 60 * 1000) {
            return "00:00";
        }
        int totalSeconds = timeMs / 1000;
        int seconds = totalSeconds % 60;
        int minutes = (totalSeconds / 60) % 60;
        int hours = totalSeconds / 3600;
        StringBuilder stringBuilder = new StringBuilder();
        Formatter mFormatter = new Formatter(stringBuilder, Locale.getDefault());
        if (hours > 0) {
            return mFormatter.format("%d:%02d:%02d", hours, minutes, seconds).toString();
        } else {
            return mFormatter.format("%02d:%02d", minutes, seconds).toString();
        }
    }

    private void startBufferAnimation() {
        if (bufferAnimation == null) {
            bufferAnimation = ObjectAnimator.ofFloat(ivLoading, "rotation", 0, 359);
            bufferAnimation.setDuration(1500);
            bufferAnimation.setInterpolator(new LinearInterpolator());
            bufferAnimation.setRepeatCount(ObjectAnimator.INFINITE);
        }
        if (!bufferAnimation.isRunning()) {
            bufferAnimation.start();
        }
    }

    private void stopBufferAnimation() {
        if (bufferAnimation != null) {
            bufferAnimation.cancel();
        }
    }

    class MyPlayerOnCompletionListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mp) {
            ivStart.setVisibility(View.VISIBLE);
            ivThumb.setVisibility(View.VISIBLE);
            videoView.stopPlayback();
            videoView.setOnCompletionListener(null);
            videoView.setOnPreparedListener(null);
            seek.setProgress(0);
            seek.setVisibility(View.GONE);
            startTime.setVisibility(View.GONE);
            tvTime.setVisibility(View.GONE);
            ivVolume.setVisibility(View.GONE);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        videoView.stopPlayback();
        videoView.setOnCompletionListener(null);
        videoView.setOnPreparedListener(null);
        videoViewContainer.removeAllViews();
        videoView = null;
    }
}