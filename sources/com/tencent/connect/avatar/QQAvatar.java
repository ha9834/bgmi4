package com.tencent.connect.avatar;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import com.helpshift.analytics.AnalyticsEventKey;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.b.e;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.g;
import com.tencent.open.utils.j;
import com.tencent.open.utils.l;
import com.tencent.tauth.IUiListener;

/* loaded from: classes2.dex */
public class QQAvatar extends BaseApi {
    public static final String FROM_SDK_AVATAR_SET_IMAGE = "FROM_SDK_AVATAR_SET_IMAGE";

    /* renamed from: a, reason: collision with root package name */
    private IUiListener f6194a;

    public QQAvatar(QQToken qQToken) {
        super(qQToken);
    }

    private Intent a(Activity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, ImageActivity.class);
        return intent;
    }

    public void setAvatarByQQ(Activity activity, Uri uri, IUiListener iUiListener) {
        if (com.tencent.connect.a.a("QQAvatar", iUiListener)) {
            return;
        }
        IUiListener iUiListener2 = this.f6194a;
        if (iUiListener2 != null) {
            iUiListener2.onCancel();
        }
        this.f6194a = iUiListener;
        if (!j.b(activity)) {
            Toast.makeText(activity.getApplicationContext(), "当前手机未安装QQ，请安装最新版QQ后再试。", 1).show();
            return;
        }
        if (j.c(activity, "8.0.0") < 0) {
            Toast.makeText(activity.getApplicationContext(), "当前手机QQ版本过低，不支持设置头像功能。", 1).show();
            return;
        }
        String a2 = l.a(activity);
        StringBuffer stringBuffer = new StringBuffer("mqqapi://profile/sdk_avatar_edit?");
        if (!TextUtils.isEmpty(a2)) {
            if (a2.length() > 20) {
                a2 = a2.substring(0, 20) + "...";
            }
            stringBuffer.append("&app_name=" + Base64.encodeToString(l.j(a2), 2));
        }
        String appId = this.c.getAppId();
        String openId = this.c.getOpenId();
        if (!TextUtils.isEmpty(appId)) {
            stringBuffer.append("&share_id=" + appId);
        }
        if (!TextUtils.isEmpty(openId)) {
            stringBuffer.append("&open_id=" + Base64.encodeToString(l.j(openId), 2));
        }
        String b = l.b(activity, uri);
        if (!TextUtils.isEmpty(b)) {
            try {
                activity.grantUriPermission("com.tencent.mobileqq", uri, 3);
                stringBuffer.append("&set_uri=" + Base64.encodeToString(l.j(uri.toString()), 2));
            } catch (Exception e) {
                SLog.e("QQAvatar", "Exception", e);
            }
        }
        if (!TextUtils.isEmpty(b)) {
            stringBuffer.append("&set_path=" + Base64.encodeToString(l.j(b), 2));
        }
        stringBuffer.append("&sdk_version=" + Base64.encodeToString(l.j(Constants.SDK_VERSION), 2));
        SLog.v("QQAVATAR", "-->set avatar, url: " + stringBuffer.toString());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.putExtra("FROM_WHERE", FROM_SDK_AVATAR_SET_IMAGE);
        intent.putExtra(Constants.PARAM_PKG_NAME, activity.getPackageName());
        intent.setData(Uri.parse(stringBuffer.toString()));
        if (a(intent)) {
            UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_EDIT_AVATAR, iUiListener);
            a(activity, Constants.REQUEST_EDIT_AVATAR, intent, false);
        }
    }

    public void setDynamicAvatar(Activity activity, Uri uri, IUiListener iUiListener) {
        if (com.tencent.connect.a.a("QQAvatar", iUiListener)) {
            return;
        }
        IUiListener iUiListener2 = this.f6194a;
        if (iUiListener2 != null) {
            iUiListener2.onCancel();
        }
        this.f6194a = iUiListener;
        if (!j.b(activity)) {
            Toast.makeText(activity.getApplicationContext(), "当前手机未安装QQ，请安装最新版QQ后再试。", 1).show();
            return;
        }
        if (j.c(activity, "8.0.5") < 0) {
            Toast.makeText(activity.getApplicationContext(), "当前手机QQ版本过低，不支持设置头像功能。", 1).show();
            return;
        }
        String a2 = l.a(activity);
        StringBuffer stringBuffer = new StringBuffer("mqqapi://profile/sdk_dynamic_avatar_edit?");
        if (!TextUtils.isEmpty(a2)) {
            if (a2.length() > 20) {
                a2 = a2.substring(0, 20) + "...";
            }
            stringBuffer.append("&app_name=" + Base64.encodeToString(l.j(a2), 2));
        }
        String appId = this.c.getAppId();
        String openId = this.c.getOpenId();
        if (!TextUtils.isEmpty(appId)) {
            stringBuffer.append("&share_id=" + appId);
        }
        if (!TextUtils.isEmpty(openId)) {
            stringBuffer.append("&open_id=" + Base64.encodeToString(l.j(openId), 2));
        }
        String b = l.b(activity, uri);
        if (!TextUtils.isEmpty(b)) {
            try {
                activity.grantUriPermission("com.tencent.mobileqq", uri, 3);
                stringBuffer.append("&video_uri=");
                stringBuffer.append(Base64.encodeToString(l.j(uri.toString()), 2));
            } catch (Exception e) {
                SLog.e("QQAvatar", "Exception", e);
            }
        }
        if (!TextUtils.isEmpty(b)) {
            stringBuffer.append("&video_path=" + Base64.encodeToString(l.j(b), 2));
        }
        stringBuffer.append("&sdk_version=" + Base64.encodeToString(l.j(Constants.SDK_VERSION), 2));
        SLog.v("QQAVATAR", "-->set dynamic avatar, url: " + stringBuffer.toString());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.putExtra("FROM_WHERE", FROM_SDK_AVATAR_SET_IMAGE);
        intent.putExtra(Constants.PARAM_PKG_NAME, activity.getPackageName());
        intent.setData(Uri.parse(stringBuffer.toString()));
        if (a(intent)) {
            UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_EDIT_DYNAMIC_AVATAR, iUiListener);
            a(activity, Constants.REQUEST_EDIT_DYNAMIC_AVATAR, intent, false);
        }
    }

    public void setAvatar(Activity activity, Uri uri, IUiListener iUiListener, int i) {
        if (com.tencent.connect.a.a("QQAvatar", iUiListener)) {
            return;
        }
        IUiListener iUiListener2 = this.f6194a;
        if (iUiListener2 != null) {
            iUiListener2.onCancel();
        }
        this.f6194a = iUiListener;
        Bundle bundle = new Bundle();
        bundle.putString("picture", uri.toString());
        bundle.putInt("exitAnim", i);
        bundle.putString("appid", this.c.getAppId());
        bundle.putString("access_token", this.c.getAccessToken());
        bundle.putLong("expires_in", this.c.getExpireTimeInSecond());
        bundle.putString("openid", this.c.getOpenId());
        Intent a2 = a(activity);
        if (a(a2)) {
            a(activity, bundle, a2);
            e.a().a(this.c.getOpenId(), this.c.getAppId(), Constants.VIA_SET_AVATAR, Constants.VIA_REPORT_TYPE_SET_AVATAR, "18", "0");
        } else {
            e.a().a(this.c.getOpenId(), this.c.getAppId(), Constants.VIA_SET_AVATAR, Constants.VIA_REPORT_TYPE_SET_AVATAR, "18", "1");
        }
    }

    private void a(Activity activity, Bundle bundle, Intent intent) {
        a(bundle);
        intent.putExtra(Constants.KEY_ACTION, "action_avatar");
        intent.putExtra(Constants.KEY_PARAMS, bundle);
        UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_AVATER, this.f6194a);
        a(activity, intent, Constants.REQUEST_AVATER);
    }

    private void a(Bundle bundle) {
        if (this.c != null) {
            bundle.putString("appid", this.c.getAppId());
            if (this.c.isSessionValid()) {
                bundle.putString(Constants.PARAM_KEY_STR, this.c.getAccessToken());
                bundle.putString(Constants.PARAM_KEY_TYPE, "0x80");
            }
            String openId = this.c.getOpenId();
            if (openId != null) {
                bundle.putString("hopenid", openId);
            }
            bundle.putString(Constants.PARAM_PLATFORM, "androidqz");
            try {
                bundle.putString(Constants.PARAM_PLATFORM_ID, g.a().getSharedPreferences(Constants.PREFERENCE_PF, 0).getString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF));
            } catch (Exception e) {
                e.printStackTrace();
                bundle.putString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF);
            }
        }
        bundle.putString("sdkv", Constants.SDK_VERSION);
        bundle.putString("sdkp", AnalyticsEventKey.ACTION_SHA);
    }
}
