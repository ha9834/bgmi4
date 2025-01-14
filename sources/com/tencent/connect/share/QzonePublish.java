package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.TDialog;
import com.tencent.open.b.e;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.l;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class QzonePublish extends BaseApi {
    public static final String HULIAN_CALL_BACK = "hulian_call_back";
    public static final String HULIAN_EXTRA_SCENE = "hulian_extra_scene";
    public static final String PUBLISH_TO_QZONE_APP_NAME = "appName";
    public static final String PUBLISH_TO_QZONE_EXTMAP = "extMap";
    public static final String PUBLISH_TO_QZONE_IMAGE_URL = "imageUrl";
    public static final String PUBLISH_TO_QZONE_KEY_TYPE = "req_type";
    public static final String PUBLISH_TO_QZONE_SUMMARY = "summary";
    public static final int PUBLISH_TO_QZONE_TYPE_PUBLISHMOOD = 3;
    public static final int PUBLISH_TO_QZONE_TYPE_PUBLISHVIDEO = 4;
    public static final String PUBLISH_TO_QZONE_VIDEO_DURATION = "videoDuration";
    public static final String PUBLISH_TO_QZONE_VIDEO_PATH = "videoPath";
    public static final String PUBLISH_TO_QZONE_VIDEO_SIZE = "videoSize";

    public QzonePublish(Context context, QQToken qQToken) {
        super(qQToken);
    }

    public void publishToQzone(final Activity activity, final Bundle bundle, final IUiListener iUiListener) {
        SLog.i("openSDK_LOG.QzonePublish", "publishToQzone() -- start");
        if (com.tencent.connect.a.a("openSDK_LOG.QzonePublish", iUiListener)) {
            return;
        }
        if (bundle == null) {
            iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_NULL_ERROR, null));
            SLog.e("openSDK_LOG.QzonePublish", "-->publishToQzone, params is null");
            e.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_NULL_ERROR);
            return;
        }
        if (!l.f(activity)) {
            iUiListener.onError(new UiError(-15, Constants.MSG_PARAM_VERSION_TOO_LOW, null));
            SLog.e("openSDK_LOG.QzonePublish", "-->publishToQzone, this is not support below qq 5.9.5");
            e.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "publicToQzone, this is not support below qq 5.9.5");
            new TDialog(activity, "", a(""), null, this.c).show();
            return;
        }
        String a2 = l.a(activity);
        int i = 0;
        if (a2 == null) {
            a2 = bundle.getString("appName");
        } else if (a2.length() > 20) {
            a2 = a2.substring(0, 20) + "...";
        }
        if (!TextUtils.isEmpty(a2)) {
            bundle.putString("appName", a2);
        }
        int i2 = bundle.getInt("req_type");
        if (i2 == 3) {
            ArrayList<String> stringArrayList = bundle.getStringArrayList("imageUrl");
            if (stringArrayList != null && stringArrayList.size() > 0) {
                while (i < stringArrayList.size()) {
                    if (!l.i(stringArrayList.get(i))) {
                        stringArrayList.remove(i);
                        i--;
                    }
                    i++;
                }
                bundle.putStringArrayList("imageUrl", stringArrayList);
            }
            b(activity, bundle, iUiListener);
            SLog.i("openSDK_LOG.QzonePublish", "publishToQzone() --end");
            return;
        }
        if (i2 == 4) {
            final String string = bundle.getString(PUBLISH_TO_QZONE_VIDEO_PATH);
            if (!l.i(string)) {
                SLog.e("openSDK_LOG.QzonePublish", "publishToQzone() video url invalid");
                iUiListener.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
                return;
            }
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.tencent.connect.share.QzonePublish.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer2) {
                    long length = new File(string).length();
                    int duration = mediaPlayer2.getDuration();
                    bundle.putString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH, string);
                    bundle.putInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, duration);
                    bundle.putLong(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, length);
                    QzonePublish.this.b(activity, bundle, iUiListener);
                    SLog.i("openSDK_LOG.QzonePublish", "publishToQzone() --end");
                }
            });
            mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.tencent.connect.share.QzonePublish.2
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer2, int i3, int i4) {
                    SLog.e("openSDK_LOG.QzonePublish", "publishToQzone() mediaplayer onError()");
                    iUiListener.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
                    return false;
                }
            });
            try {
                mediaPlayer.setDataSource(string);
                mediaPlayer.prepareAsync();
                return;
            } catch (Exception unused) {
                SLog.e("openSDK_LOG.QzonePublish", "publishToQzone() exception(s) occurred when preparing mediaplayer");
                iUiListener.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
                return;
            }
        }
        iUiListener.onError(new UiError(-5, Constants.MSG_SHARE_TYPE_ERROR, null));
        SLog.e("openSDK_LOG.QzonePublish", "publishToQzone() error--end请选择支持的分享类型");
        e.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "publishToQzone() 请选择支持的分享类型");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00cc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0200  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(android.app.Activity r33, android.os.Bundle r34, com.tencent.tauth.IUiListener r35) {
        /*
            Method dump skipped, instructions count: 949
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.share.QzonePublish.b(android.app.Activity, android.os.Bundle, com.tencent.tauth.IUiListener):void");
    }
}
