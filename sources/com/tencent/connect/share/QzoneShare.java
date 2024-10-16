package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.TDialog;
import com.tencent.open.b.e;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.j;
import com.tencent.open.utils.l;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.twitter.sdk.android.core.internal.scribe.ScribeConfig;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class QzoneShare extends BaseApi {
    public static final String SHARE_TO_QQ_APP_NAME = "appName";
    public static final String SHARE_TO_QQ_AUDIO_URL = "audio_url";
    public static final String SHARE_TO_QQ_EXT_INT = "cflag";
    public static final String SHARE_TO_QQ_EXT_STR = "share_qq_ext_str";
    public static final String SHARE_TO_QQ_IMAGE_LOCAL_URL = "imageLocalUrl";
    public static final String SHARE_TO_QQ_IMAGE_URL = "imageUrl";
    public static final String SHARE_TO_QQ_SITE = "site";
    public static final String SHARE_TO_QQ_SUMMARY = "summary";
    public static final String SHARE_TO_QQ_TARGET_URL = "targetUrl";
    public static final String SHARE_TO_QQ_TITLE = "title";
    public static final String SHARE_TO_QZONE_EXTMAP = "extMap";
    public static final String SHARE_TO_QZONE_KEY_TYPE = "req_type";
    public static final int SHARE_TO_QZONE_TYPE_IMAGE = 5;
    public static final int SHARE_TO_QZONE_TYPE_IMAGE_TEXT = 1;
    public static final int SHARE_TO_QZONE_TYPE_MINI_PROGRAM = 7;
    public static final int SHARE_TO_QZONE_TYPE_NO_TYPE = 0;

    /* renamed from: a, reason: collision with root package name */
    private boolean f6212a;
    private boolean d;
    private boolean e;
    private boolean f;
    public String mViaShareQzoneType;

    @Override // com.tencent.connect.common.BaseApi
    public void releaseResource() {
    }

    public QzoneShare(Context context, QQToken qQToken) {
        super(qQToken);
        this.mViaShareQzoneType = "";
        this.f6212a = true;
        this.d = false;
        this.e = false;
        this.f = false;
    }

    public void shareToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        String str;
        SLog.i("openSDK_LOG.QzoneShare", "shareToQzone() -- start");
        if (com.tencent.connect.a.a("openSDK_LOG.QzoneShare", iUiListener)) {
            return;
        }
        if (bundle == null) {
            iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_NULL_ERROR, null));
            SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() params is null");
            e.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_NULL_ERROR);
            return;
        }
        String string = bundle.getString("title");
        String string2 = bundle.getString("summary");
        String string3 = bundle.getString("targetUrl");
        String string4 = bundle.getString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_APPID);
        String string5 = bundle.getString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_PATH);
        ArrayList<String> stringArrayList = bundle.getStringArrayList("imageUrl");
        String a2 = l.a(activity);
        if (a2 == null) {
            a2 = bundle.getString("appName");
        } else if (a2.length() > 20) {
            a2 = a2.substring(0, 20) + "...";
        }
        int i = bundle.getInt("req_type");
        SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() get SHARE_TO_QZONE_KEY_TYPE: " + i);
        if (i == 1) {
            this.mViaShareQzoneType = "1";
        } else if (i == 5) {
            this.mViaShareQzoneType = "2";
        } else {
            this.mViaShareQzoneType = "1";
        }
        if (i == 1) {
            SLog.e("openSDK_LOG.QzoneShare", "-->shareToQzone, SHARE_TO_QZONE_TYPE_IMAGE_TEXT needTitle = true");
            this.f6212a = true;
            this.d = false;
            this.e = true;
            this.f = false;
        } else {
            if (i == 5) {
                iUiListener.onError(new UiError(-5, Constants.MSG_SHARE_TYPE_ERROR, null));
                SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() error--end请选择支持的分享类型");
                e.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() 请选择支持的分享类型");
                return;
            }
            if (i == 7) {
                if (TextUtils.isEmpty(string4) || TextUtils.isEmpty(string5)) {
                    iUiListener.onError(new UiError(-5, Constants.MSG_PARAM_ERROR, "appid or path empty."));
                }
                this.e = false;
                this.f = false;
                this.f6212a = false;
            } else {
                if (l.e(string) && l.e(string2)) {
                    if (stringArrayList != null && stringArrayList.size() != 0) {
                        this.f6212a = false;
                    } else {
                        string = "来自" + a2 + "的分享";
                        this.f6212a = true;
                    }
                } else {
                    this.f6212a = true;
                }
                this.d = false;
                SLog.e("openSDK_LOG.QzoneShare", "-->shareToQzone, default needTitle = true, shareType = " + i);
                this.e = true;
                this.f = false;
            }
        }
        if (!l.a() && l.g(activity, "4.5.0")) {
            iUiListener.onError(new UiError(-6, Constants.MSG_SHARE_NOSD_ERROR, null));
            SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() sdcard is null--end");
            e.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_NOSD_ERROR);
            return;
        }
        if (this.f6212a) {
            if (TextUtils.isEmpty(string3)) {
                iUiListener.onError(new UiError(-5, Constants.MSG_PARAM_TARGETURL_NULL_ERROR, null));
                SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() targetUrl null error--end");
                e.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_TARGETURL_NULL_ERROR);
                return;
            } else if (!l.h(string3)) {
                iUiListener.onError(new UiError(-5, Constants.MSG_PARAM_TARGETURL_ERROR, null));
                SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() targetUrl error--end");
                e.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_TARGETURL_ERROR);
                return;
            }
        }
        if (this.d) {
            bundle.putString("title", "");
            bundle.putString("summary", "");
        } else {
            if (this.e && l.e(string)) {
                iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_TITLE_NULL_ERROR, null));
                SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() title is null--end");
                e.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() title is null");
                return;
            }
            if (l.e(string) || string.length() <= 200) {
                str = null;
            } else {
                str = null;
                bundle.putString("title", l.a(string, 200, (String) null, (String) null));
            }
            if (!l.e(string2) && string2.length() > 600) {
                bundle.putString("summary", l.a(string2, ScribeConfig.DEFAULT_SEND_INTERVAL_SECONDS, str, str));
            }
        }
        if (!TextUtils.isEmpty(a2)) {
            bundle.putString("appName", a2);
        }
        if (stringArrayList == null || (stringArrayList != null && stringArrayList.size() == 0)) {
            if (this.f) {
                iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_ERROR, null));
                SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() imageUrl is null -- end");
                e.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() imageUrl is null");
                return;
            }
        } else {
            int i2 = 0;
            while (i2 < stringArrayList.size()) {
                String str2 = stringArrayList.get(i2);
                if (!l.h(str2) && !l.i(str2)) {
                    stringArrayList.remove(i2);
                    i2--;
                }
                i2++;
            }
            if (stringArrayList.size() == 0) {
                iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_URL_FORMAT_ERROR, null));
                SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() MSG_PARAM_IMAGE_URL_FORMAT_ERROR--end");
                e.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() 非法的图片地址!");
                return;
            }
            bundle.putStringArrayList("imageUrl", stringArrayList);
        }
        if (!l.g(activity, "4.6.0")) {
            SLog.i("openSDK_LOG.QzoneShare", "shareToQzone() qqver greater than 4.6.0");
            b(activity, bundle, iUiListener);
        } else if (j.c(activity, "4.2.0") >= 0 && j.c(activity, "4.6.0") < 0) {
            SLog.w("openSDK_LOG.QzoneShare", "shareToQzone() qqver between 4.2.0 and 4.6.0, will use qqshare");
            QQShare qQShare = new QQShare(activity, this.c);
            if (stringArrayList != null && stringArrayList.size() > 0) {
                String str3 = stringArrayList.get(0);
                if (i == 5 && !l.i(str3)) {
                    iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_URL_MUST_BE_LOCAL, null));
                    SLog.e("openSDK_LOG.QzoneShare", "shareToQzone()手Q版本过低，纯图分享不支持网路图片");
                    e.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone()手Q版本过低，纯图分享不支持网路图片");
                    return;
                }
                bundle.putString("imageLocalUrl", str3);
            }
            if (!l.g(activity, "4.5.0")) {
                bundle.putInt("cflag", 1);
            }
            qQShare.shareToQQ(activity, bundle, iUiListener);
        } else {
            SLog.w("openSDK_LOG.QzoneShare", "shareToQzone() qqver below 4.2.0, will show download dialog");
            new TDialog(activity, "", a(""), null, this.c).show();
        }
        SLog.i("openSDK_LOG.QzoneShare", "shareToQzone() --end");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0393  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b(android.app.Activity r26, android.os.Bundle r27, com.tencent.tauth.IUiListener r28) {
        /*
            Method dump skipped, instructions count: 1111
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.share.QzoneShare.b(android.app.Activity, android.os.Bundle, com.tencent.tauth.IUiListener):void");
    }
}
