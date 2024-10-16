package com.tencent.connect.common;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.helpshift.analytics.AnalyticsEventKey;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.common.Constants;
import com.tencent.open.TDialog;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.f;
import com.tencent.open.utils.g;
import com.tencent.open.utils.j;
import com.tencent.open.utils.l;
import com.tencent.tauth.IRequestListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class BaseApi {
    public static String businessId;
    public static String installChannel;
    public static boolean isOEM;
    public static String registerChannel;
    protected c b;
    protected QQToken c;

    public void releaseResource() {
    }

    public BaseApi(c cVar, QQToken qQToken) {
        this.b = cVar;
        this.c = qQToken;
    }

    public BaseApi(QQToken qQToken) {
        this(null, qQToken);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("format", "json");
        bundle.putString("status_os", Build.VERSION.RELEASE);
        bundle.putString("status_machine", f.a().b(g.a()));
        bundle.putString("status_version", Build.VERSION.SDK);
        bundle.putString("sdkv", Constants.SDK_VERSION);
        bundle.putString("sdkp", AnalyticsEventKey.ACTION_SHA);
        QQToken qQToken = this.c;
        if (qQToken != null && qQToken.isSessionValid()) {
            bundle.putString("access_token", this.c.getAccessToken());
            bundle.putString("oauth_consumer_key", this.c.getAppId());
            bundle.putString("openid", this.c.getOpenId());
        }
        SharedPreferences sharedPreferences = g.a().getSharedPreferences(Constants.PREFERENCE_PF, 0);
        if (isOEM) {
            bundle.putString(Constants.PARAM_PLATFORM_ID, "desktop_m_qq-" + installChannel + "-android-" + registerChannel + "-" + businessId);
        } else {
            bundle.putString(Constants.PARAM_PLATFORM_ID, sharedPreferences.getString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF));
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a(String str) {
        Bundle a2 = a();
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            a2.putString("need_version", str);
        }
        sb.append("https://openmobile.qq.com/oauth2.0/m_jump_by_version?");
        sb.append(HttpUtils.encodeUrl(a2));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(StringBuilder sb, Activity activity) {
        if (sb.indexOf("?") < 0) {
            sb.append("?");
        } else {
            sb.append("&");
        }
        sb.append(Constants.JumpUrlConstants.URL_KEY_SRC);
        sb.append("=");
        sb.append(Constants.JumpUrlConstants.SRC_TYPE_APP);
        String appId = this.c.getAppId();
        String openId = this.c.getOpenId();
        if (!TextUtils.isEmpty(appId)) {
            a(sb, "app_id", appId);
        }
        if (!TextUtils.isEmpty(openId)) {
            a(sb, Constants.JumpUrlConstants.URL_KEY_OPENID, l.l(openId));
        }
        String a2 = l.a(activity);
        if (!TextUtils.isEmpty(a2)) {
            if (a2.length() > 20) {
                a2 = a2.substring(0, 20) + "...";
            }
            a(sb, "app_name", l.l(a2));
        }
        a(sb, Constants.JumpUrlConstants.URL_KEY_SDK_VERSION, l.l(Constants.SDK_VERSION));
    }

    protected void a(StringBuilder sb, String str, String str2) {
        sb.append("&");
        sb.append(str);
        sb.append("=");
        sb.append(l.f(str2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bundle b() {
        Bundle bundle = new Bundle();
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
        SharedPreferences sharedPreferences = g.a().getSharedPreferences(Constants.PREFERENCE_PF, 0);
        if (isOEM) {
            bundle.putString(Constants.PARAM_PLATFORM_ID, "desktop_m_qq-" + installChannel + "-android-" + registerChannel + "-" + businessId);
        } else {
            bundle.putString(Constants.PARAM_PLATFORM_ID, sharedPreferences.getString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF));
            bundle.putString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF);
        }
        bundle.putString("sdkv", Constants.SDK_VERSION);
        bundle.putString("sdkp", AnalyticsEventKey.ACTION_SHA);
        return bundle;
    }

    private Intent a(Activity activity, Intent intent, Map<String, Object> map) {
        Intent intent2 = new Intent(activity.getApplicationContext(), (Class<?>) AssistActivity.class);
        intent2.putExtra("is_login", true);
        intent2.putExtra(AssistActivity.EXTRA_INTENT, intent);
        if (map == null) {
            return intent2;
        }
        try {
            if (map.containsKey(Constants.KEY_RESTORE_LANDSCAPE)) {
                intent2.putExtra(Constants.KEY_RESTORE_LANDSCAPE, ((Boolean) map.get(Constants.KEY_RESTORE_LANDSCAPE)).booleanValue());
            }
        } catch (Exception e) {
            SLog.e("openSDK_LOG.BaseApi", "Exception", e);
        }
        return intent2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Activity activity, int i, Intent intent, boolean z) {
        Intent intent2 = new Intent(activity.getApplicationContext(), (Class<?>) AssistActivity.class);
        if (z) {
            intent2.putExtra("is_qq_mobile_share", true);
        }
        intent2.putExtra(AssistActivity.EXTRA_INTENT, intent);
        activity.startActivityForResult(intent2, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Activity activity, Intent intent, int i) {
        a(activity, intent, i, (Map<String, Object>) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Activity activity, Intent intent, int i, Map<String, Object> map) {
        intent.putExtra(Constants.KEY_REQUEST_CODE, i);
        activity.startActivityForResult(a(activity, intent, map), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Fragment fragment, Intent intent, int i, Map<String, Object> map) {
        intent.putExtra(Constants.KEY_REQUEST_CODE, i);
        fragment.startActivityForResult(a(fragment.getActivity(), intent, map), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(Intent intent) {
        if (intent != null) {
            return j.a(g.a(), intent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Intent b(String str) {
        Intent intent = new Intent();
        if (l.c(g.a())) {
            intent.setClassName(Constants.PACKAGE_QQ_PAD, str);
            if (j.a(g.a(), intent)) {
                return intent;
            }
        }
        intent.setClassName("com.tencent.mobileqq", str);
        if (j.a(g.a(), intent)) {
            return intent;
        }
        intent.setClassName(Constants.PACKAGE_TIM, str);
        if (j.a(g.a(), intent)) {
            return intent;
        }
        intent.setClassName(Constants.PACKAGE_QQ_SPEED, str);
        if (j.a(g.a(), intent)) {
            return intent;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.BaseApi", "--handleDownloadLastestQQ");
        new TDialog(activity, "", "https://imgcache.qq.com/ptlogin/static/qzsjump.html?" + HttpUtils.encodeUrl(bundle), null, this.c).show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Intent c(String str) {
        Intent intent = new Intent();
        Intent b = b(str);
        if (b == null || b.getComponent() == null) {
            return null;
        }
        intent.setClassName(b.getComponent().getPackageName(), "com.tencent.open.agent.AgentActivity");
        return intent;
    }

    /* loaded from: classes2.dex */
    public class TempRequestListener implements IRequestListener {
        private final IUiListener b;
        private final Handler c;

        public TempRequestListener(IUiListener iUiListener) {
            this.b = iUiListener;
            this.c = new Handler(g.a().getMainLooper()) { // from class: com.tencent.connect.common.BaseApi.TempRequestListener.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (message.what == 0) {
                        TempRequestListener.this.b.onComplete(message.obj);
                    } else {
                        TempRequestListener.this.b.onError(new UiError(message.what, (String) message.obj, null));
                    }
                }
            };
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onComplete(JSONObject jSONObject) {
            Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = jSONObject;
            obtainMessage.what = 0;
            this.c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onIOException(IOException iOException) {
            Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = iOException.getMessage();
            obtainMessage.what = -2;
            this.c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onMalformedURLException(MalformedURLException malformedURLException) {
            Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = malformedURLException.getMessage();
            obtainMessage.what = -3;
            this.c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onJSONException(JSONException jSONException) {
            Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = jSONException.getMessage();
            obtainMessage.what = -4;
            this.c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onSocketTimeoutException(SocketTimeoutException socketTimeoutException) {
            Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = socketTimeoutException.getMessage();
            obtainMessage.what = -8;
            this.c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onNetworkUnavailableException(HttpUtils.NetworkUnavailableException networkUnavailableException) {
            Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = networkUnavailableException.getMessage();
            obtainMessage.what = -10;
            this.c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onHttpStatusException(HttpUtils.HttpStatusException httpStatusException) {
            Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = httpStatusException.getMessage();
            obtainMessage.what = -9;
            this.c.sendMessage(obtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onUnknowException(Exception exc) {
            Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = exc.getMessage();
            obtainMessage.what = -6;
            this.c.sendMessage(obtainMessage);
        }
    }
}
