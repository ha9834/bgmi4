package com.tencent.tauth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.mediatek.powerhalmgr.sdk.BuildConfig;
import com.tencent.connect.api.QQAuthManage;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.avatar.QQAvatar;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.connect.emotion.QQEmotion;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzonePublish;
import com.tencent.connect.share.QzoneShare;
import com.tencent.midas.oversea.api.CocosPayHelper;
import com.tencent.mtt.spcialcall.sdk.RecommendParams;
import com.tencent.open.SocialOperation;
import com.tencent.open.a.a;
import com.tencent.open.apireq.IApiCallback;
import com.tencent.open.b.b;
import com.tencent.open.im.IM;
import com.tencent.open.log.SLog;
import com.tencent.open.log.Tracer;
import com.tencent.open.miniapp.MiniApp;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.g;
import com.tencent.open.utils.h;
import com.tencent.open.utils.j;
import com.tencent.open.utils.l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class Tencent {
    public static final int REQUEST_LOGIN = 10001;
    public static boolean USE_ONE_HOUR;
    private static Tencent c;
    private static boolean d;

    /* renamed from: a, reason: collision with root package name */
    private final c f6542a;
    private String b;

    private Tencent(String str, Context context) {
        this.f6542a = c.a(str, context);
        b.a().a(str, context);
    }

    public static void setIsPermissionGranted(boolean z) {
        d = z;
    }

    public static boolean isPermissionNotGranted() {
        return !d;
    }

    public static synchronized Tencent createInstance(String str, Context context, String str2) {
        Tencent createInstance;
        synchronized (Tencent.class) {
            createInstance = createInstance(str, context);
            SLog.i("openSDK_LOG.Tencent", "createInstance()  -- start, appId = " + str + ", authorities=" + str2);
            a("createInstance_authority", "appid", str, "authorities", str2);
            if (createInstance != null) {
                createInstance.b = str2;
            } else {
                SLog.i("openSDK_LOG.Tencent", "null == tencent set mAuthorities fail");
            }
        }
        return createInstance;
    }

    public static synchronized Tencent createInstance(String str, Context context) {
        synchronized (Tencent.class) {
            g.a(context.getApplicationContext());
            SLog.i("openSDK_LOG.Tencent", "createInstance()  -- start, appId = " + str);
            if (TextUtils.isEmpty(str)) {
                SLog.e("openSDK_LOG.Tencent", "appId should not be empty!");
                return null;
            }
            if (c == null) {
                c = new Tencent(str, context);
            } else if (!str.equals(c.getAppId())) {
                c.logout(context);
                c = new Tencent(str, context);
            }
            if (!a(context, str)) {
                return null;
            }
            a("createInstance", "appid", str);
            a.a().a(h.a(context, str));
            SLog.i("openSDK_LOG.Tencent", "createInstance()  -- end");
            return c;
        }
    }

    public static synchronized String getAuthorities(String str) {
        synchronized (Tencent.class) {
            a("getAuthorities", "appid", str);
            if (TextUtils.isEmpty(str)) {
                SLog.i("openSDK_LOG.Tencent", "TextUtils.isEmpty(appId)");
                return null;
            }
            if (c == null) {
                SLog.i("openSDK_LOG.Tencent", "sInstance == null");
                return null;
            }
            return str.equals(c.getAppId()) ? c.b : "";
        }
    }

    public static void setCustomLogger(Tracer tracer) {
        SLog.i("openSDK_LOG.Tencent", "setCustomLogger");
        a("setCustomLogger", new Object[0]);
        SLog.getInstance().setCustomLogger(tracer);
    }

    private static boolean a(Context context, String str) {
        try {
            context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity"), 128);
            try {
                context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity"), 128);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
                SLog.e("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.connect.common.AssistActivity\n" + ("没有在AndroidManifest.xml中检测到com.tencent.connect.common.AssistActivity,请加上com.tencent.connect.common.AssistActivity,详细信息请查看官网文档.\n配置示例如下: \n<activity\n     android:name=\"com.tencent.connect.common.AssistActivity\"\n     android:screenOrientation=\"behind\"\n     android:theme=\"@android:style/Theme.Translucent.NoTitleBar\"\n     android:configChanges=\"orientation|keyboardHidden\">\n</activity>"));
                return false;
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            SLog.e("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.tauth.AuthActivity" + (("没有在AndroidManifest.xml中检测到com.tencent.tauth.AuthActivity,请加上com.tencent.tauth.AuthActivity,并配置<data android:scheme=\"tencent" + str + "\" />,详细信息请查看官网文档.") + "\n配置示例如下: \n<activity\n     android:name=\"com.tencent.tauth.AuthActivity\"\n     android:noHistory=\"true\"\n     android:launchMode=\"singleTask\">\n<intent-filter>\n    <action android:name=\"android.intent.action.VIEW\" />\n    <category android:name=\"android.intent.category.DEFAULT\" />\n    <category android:name=\"android.intent.category.BROWSABLE\" />\n    <data android:scheme=\"tencent" + str + "\" />\n</intent-filter>\n</activity>"));
            return false;
        }
    }

    public static Map<String, String> parseMiniParameters(Intent intent) {
        String stringExtra;
        a("parseMiniParameters", new Object[0]);
        HashMap hashMap = new HashMap();
        if (intent == null) {
            SLog.e("openSDK_LOG.Tencent", "parseMiniParameters null == intent");
            return hashMap;
        }
        try {
            stringExtra = intent.getStringExtra("appParameter");
        } catch (Exception e) {
            SLog.e("openSDK_LOG.Tencent", "parseMiniParameters Exception", e);
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            SLog.d("openSDK_LOG.Tencent", "parseMiniParameters appParameter=" + stringExtra);
            JSONObject jSONObject = new JSONObject(stringExtra);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            return hashMap;
        }
        Uri data = intent.getData();
        if (data == null) {
            SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uri==null");
            return hashMap;
        }
        String uri = data.toString();
        if (TextUtils.isEmpty(uri)) {
            SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uriStr isEmpty");
            return hashMap;
        }
        String substring = uri.substring(uri.lastIndexOf(63) + 1);
        if (TextUtils.isEmpty(substring)) {
            SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uriParam is empty");
            return hashMap;
        }
        SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uriParam=" + substring);
        for (String str : substring.split("&")) {
            String[] split = str.split("=");
            if (split.length == 2) {
                hashMap.put(split[0], split[1]);
            }
        }
        return hashMap;
    }

    public int login(Activity activity, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "login() with activity, scope is " + str);
        a("login_scope", "scope", str);
        return this.f6542a.a(activity, str, iUiListener);
    }

    public int login(Activity activity, IUiListener iUiListener, Map<String, Object> map) {
        SLog.i("openSDK_LOG.Tencent", "login activity with params");
        a("login_param", new Object[0]);
        return this.f6542a.a(activity, iUiListener, map);
    }

    public int login(Activity activity, String str, IUiListener iUiListener, boolean z) {
        SLog.i("openSDK_LOG.Tencent", "login() with activity, scope is " + str);
        a("login_qrcode", "scope", str, "qrcode", Boolean.valueOf(z));
        return this.f6542a.a(activity, str, iUiListener, z);
    }

    public int login(Fragment fragment, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "login() with fragment, scope is " + str);
        a("login_fragment_scope", "scope", str);
        return this.f6542a.a(fragment, str, iUiListener, "");
    }

    public int login(Fragment fragment, String str, IUiListener iUiListener, boolean z) {
        SLog.i("openSDK_LOG.Tencent", "login() with fragment, scope is " + str);
        a("login_fragment_scope_qrcode", "scope", str, "qrcode", Boolean.valueOf(z));
        return this.f6542a.a(fragment, str, iUiListener, "", z);
    }

    public int loginServerSide(Activity activity, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "loginServerSide() with activity, scope = " + str + ",server_side");
        a("loginServerSide_activity", "scope", str);
        return this.f6542a.a(activity, str + ",server_side", iUiListener);
    }

    public int loginServerSide(Fragment fragment, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "loginServerSide() with fragment, scope = " + str + ",server_side");
        a("loginServerSide_fragment", "scope", str);
        return this.f6542a.a(fragment, str + ",server_side", iUiListener, "");
    }

    public int loginWithOEM(Activity activity, String str, IUiListener iUiListener, boolean z, String str2, String str3, String str4) {
        SLog.i("openSDK_LOG.Tencent", "loginWithOEM() with activity, scope = " + str);
        a("loginWithOEM", "scope", str, "qrcode", Boolean.valueOf(z), "registerChannel", str2, "installChannel", str3, "businessId", str4);
        return this.f6542a.a(activity, str, iUiListener, z, str2, str3, str4);
    }

    public void logout(Context context) {
        SLog.i("openSDK_LOG.Tencent", "logout()");
        a("logout", new Object[0]);
        this.f6542a.b().setAccessToken(null, "0");
        this.f6542a.b().setOpenId(null);
        this.f6542a.b().removeSession(this.f6542a.b().getAppId());
    }

    public int reAuth(Activity activity, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "reAuth() with activity, scope = " + str);
        a("reAuth", "scope", str);
        return this.f6542a.b(activity, str, iUiListener);
    }

    public void reportDAU() {
        SLog.i("openSDK_LOG.Tencent", "reportDAU() ");
        a("reportDAU", new Object[0]);
        this.f6542a.a();
    }

    public void checkLogin(IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "checkLogin()");
        a("checkLogin", new Object[0]);
        this.f6542a.a(iUiListener);
    }

    public void requestAsync(String str, Bundle bundle, String str2, IRequestListener iRequestListener) {
        SLog.i("openSDK_LOG.Tencent", "requestAsync()");
        a("requestAsync", "graphPath", str, "httpMethod", str2);
        HttpUtils.requestAsync(this.f6542a.b(), g.a(), str, bundle, str2, iRequestListener);
    }

    public JSONObject request(String str, Bundle bundle, String str2) throws IOException, JSONException, HttpUtils.NetworkUnavailableException, HttpUtils.HttpStatusException {
        SLog.i("openSDK_LOG.Tencent", "request()");
        a("request", "graphPath", str, "httpMethod", str2);
        return HttpUtils.request(this.f6542a.b(), g.a(), str, bundle, str2);
    }

    public void shareToQQ(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "shareToQQ()");
        a("shareToQQ", new Object[0]);
        if (TextUtils.isEmpty(this.b)) {
            iUiListener.onWarning(-19);
        }
        new QQShare(activity, this.f6542a.b()).shareToQQ(activity, bundle, iUiListener);
    }

    public void shareToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "shareToQzone()");
        a("shareToQzone", new Object[0]);
        new QzoneShare(activity, this.f6542a.b()).shareToQzone(activity, bundle, iUiListener);
    }

    public void publishToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "publishToQzone()");
        a("publishToQzone", new Object[0]);
        new QzonePublish(activity, this.f6542a.b()).publishToQzone(activity, bundle, iUiListener);
    }

    public void setAvatar(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "setAvatar()");
        a("setAvatar", new Object[0]);
        String string = bundle.getString("picture");
        new QQAvatar(this.f6542a.b()).setAvatar(activity, Uri.parse(string), iUiListener, bundle.getInt("exitAnim"));
    }

    public void setAvatar(Activity activity, Bundle bundle, IUiListener iUiListener, int i, int i2) {
        SLog.i("openSDK_LOG.Tencent", "setAvatar()");
        a("setAvatar_anim", new Object[0]);
        bundle.putInt("exitAnim", i2);
        activity.overridePendingTransition(i, 0);
        setAvatar(activity, bundle, iUiListener);
    }

    public void setAvatarByQQ(Activity activity, Uri uri, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "setAvatarByQQ()");
        a("setAvatarByQQ", new Object[0]);
        new QQAvatar(this.f6542a.b()).setAvatarByQQ(activity, uri, iUiListener);
    }

    public void setDynamicAvatar(Activity activity, Uri uri, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "setDynamicAvatar()");
        a("setDynamicAvatar", new Object[0]);
        new QQAvatar(this.f6542a.b()).setDynamicAvatar(activity, uri, iUiListener);
    }

    public void setEmotions(Activity activity, ArrayList<Uri> arrayList, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "saveQQEmotions()");
        a("setEmotions", new Object[0]);
        new QQEmotion(this.f6542a.b()).setEmotions(activity, arrayList, iUiListener);
    }

    public static boolean onActivityResultData(int i, int i2, Intent intent, IUiListener iUiListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("onActivityResultData() reqcode = ");
        sb.append(i);
        sb.append(", resultcode = ");
        sb.append(i2);
        sb.append(", data = null ? ");
        sb.append(intent == null);
        sb.append(", listener = null ? ");
        sb.append(iUiListener == null);
        SLog.i("openSDK_LOG.Tencent", sb.toString());
        a("onActivityResultData", "requestCode", Integer.valueOf(i), CocosPayHelper.RES_CODE, Integer.valueOf(i2));
        return UIListenerManager.getInstance().onActivityResult(i, i2, intent, iUiListener);
    }

    public boolean isSessionValid() {
        boolean c2 = this.f6542a.c();
        SLog.i("openSDK_LOG.Tencent", "isSessionValid() isvalid =" + c2);
        a("isSessionValid", Boolean.valueOf(c2));
        return c2;
    }

    public String getAppId() {
        String appId = this.f6542a.b().getAppId();
        SLog.i("openSDK_LOG.Tencent", "getAppId() appid =" + appId);
        a("getAppId", appId);
        return appId;
    }

    public String getAccessToken() {
        String accessToken = this.f6542a.b().getAccessToken();
        SLog.i("openSDK_LOG.Tencent", "getAccessToken() accessToken = " + accessToken);
        a("getAccessToken", new Object[0]);
        return accessToken;
    }

    public long getExpiresIn() {
        long expireTimeInSecond = this.f6542a.b().getExpireTimeInSecond();
        SLog.i("openSDK_LOG.Tencent", "getExpiresIn() expiresin= " + expireTimeInSecond);
        a("getExpiresIn", Long.valueOf(expireTimeInSecond));
        return expireTimeInSecond;
    }

    public String getOpenId() {
        String openId = this.f6542a.b().getOpenId();
        SLog.i("openSDK_LOG.Tencent", "getOpenId() openid= " + openId);
        a("getOpenId", new Object[0]);
        return openId;
    }

    @Deprecated
    public void handleLoginData(Intent intent, IUiListener iUiListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("handleLoginData() data = null ? ");
        sb.append(intent == null);
        sb.append(", listener = null ? ");
        sb.append(iUiListener == null);
        SLog.i("openSDK_LOG.Tencent", sb.toString());
        a("handleLoginData", new Object[0]);
        UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
    }

    public static void handleResultData(Intent intent, IUiListener iUiListener) {
        StringBuilder sb = new StringBuilder();
        sb.append("handleResultData() data = null ? ");
        sb.append(intent == null);
        sb.append(", listener = null ? ");
        sb.append(iUiListener == null);
        SLog.i("openSDK_LOG.Tencent", sb.toString());
        a("handleResultData", new Object[0]);
        UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
    }

    public void setAccessToken(String str, String str2) {
        SLog.i("openSDK_LOG.Tencent", "setAccessToken(), expiresIn = " + str2 + "");
        a("setAccessToken", new Object[0]);
        this.f6542a.a(str, str2);
    }

    public void setOpenId(String str) {
        SLog.i("openSDK_LOG.Tencent", "setOpenId() --start");
        a("setOpenId", new Object[0]);
        this.f6542a.b(g.a(), str);
        SLog.i("openSDK_LOG.Tencent", "setOpenId() --end");
    }

    public boolean isReady() {
        boolean z = isSessionValid() && getOpenId() != null;
        SLog.i("openSDK_LOG.Tencent", "isReady() --ready=" + z);
        a("isReady", Boolean.valueOf(z));
        return z;
    }

    public QQToken getQQToken() {
        SLog.i("openSDK_LOG.Tencent", "getQQToken()");
        a("getQQToken", new Object[0]);
        return this.f6542a.b();
    }

    public boolean isSupportSSOLogin(Activity activity) {
        SLog.i("openSDK_LOG.Tencent", "isSupportSSOLogin()");
        boolean z = true;
        if (l.c(activity) && j.a((Context) activity, Constants.PACKAGE_QQ_PAD) != null) {
            a("isSupportSSOLogin", (Object) true);
            return true;
        }
        if (j.c(activity, "4.1") < 0 && j.d(activity, "1.1") < 0 && j.e(activity, BuildConfig.VERSION_NAME) < 0) {
            z = false;
        }
        SLog.i("openSDK_LOG.Tencent", "isSupportSSOLogin() support=" + z);
        a("isSupportSSOLogin", Boolean.valueOf(z));
        return z;
    }

    public static boolean isSupportShareToQQ(Context context) {
        SLog.i("openSDK_LOG.Tencent", "isSupportShareToQQ()");
        boolean z = true;
        if (l.c(context) && j.a(context, Constants.PACKAGE_QQ_PAD) != null) {
            a("isSupportShareToQQ", (Object) true);
            return true;
        }
        if (j.c(context, "4.1") < 0 && j.a(context, Constants.PACKAGE_TIM) == null && j.a(context, Constants.PACKAGE_QQ_SPEED) == null) {
            z = false;
        }
        SLog.i("openSDK_LOG.Tencent", "isSupportShareToQQ() support=" + z);
        a("isSupportShareToQQ", Boolean.valueOf(z));
        return z;
    }

    public static boolean isSupportPushToQZone(Context context) {
        boolean z = j.c(context, "5.9.5") >= 0 || j.a(context, Constants.PACKAGE_QQ_SPEED) != null;
        SLog.i("openSDK_LOG.Tencent", "isSupportPushToQZone() support=" + z);
        a("isSupportPushToQZone", Boolean.valueOf(z));
        return z;
    }

    public boolean isQQInstalled(Context context) {
        boolean b = j.b(context);
        SLog.i("openSDK_LOG.Tencent", "isQQInstalled() installed=" + b);
        a("isQQInstalled", Boolean.valueOf(b));
        return b;
    }

    public void saveSession(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        sb.append("saveSession() length=");
        sb.append(jSONObject != null ? jSONObject.length() : 0);
        SLog.i("openSDK_LOG.Tencent", sb.toString());
        a("saveSession", new Object[0]);
        this.f6542a.b().saveSession(jSONObject);
    }

    public JSONObject loadSession(String str) {
        JSONObject loadSession = this.f6542a.b().loadSession(str);
        StringBuilder sb = new StringBuilder();
        sb.append("loadSession() appid ");
        sb.append(str);
        sb.append(", length=");
        sb.append(loadSession != null ? loadSession.length() : 0);
        SLog.i("openSDK_LOG.Tencent", sb.toString());
        a("loadSession", "appid", str);
        return loadSession;
    }

    public void initSessionCache(JSONObject jSONObject) {
        a("initSessionCache", new Object[0]);
        try {
            String string = jSONObject.getString("access_token");
            String string2 = jSONObject.getString("expires_in");
            String string3 = jSONObject.getString("openid");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                setAccessToken(string, string2);
                setOpenId(string3);
            }
            SLog.i("openSDK_LOG.Tencent", "initSessionCache()");
        } catch (Exception e) {
            SLog.i("QQToken", "initSessionCache " + e.toString());
        }
    }

    public int startIMAio(Activity activity, String str, String str2) {
        SLog.i("openSDK_LOG.Tencent", "startIMAio()");
        a("startIMAio", RecommendParams.KEY_UIN, str, Constants.PARAM_PKG_NAME, str2);
        return startIMConversation(activity, IM.CHAT_TYPE_AIO, str, str2);
    }

    public int startIMAudio(Activity activity, String str, String str2) {
        SLog.i("openSDK_LOG.Tencent", "startIMAudio()");
        a("startIMAudio", RecommendParams.KEY_UIN, str, Constants.PARAM_PKG_NAME, str2);
        return startIMConversation(activity, IM.CHAT_TYPE_AUDIO_CHAT, str, str2);
    }

    public int startIMVideo(Activity activity, String str, String str2) {
        SLog.i("openSDK_LOG.Tencent", "startIMVideo()");
        a("startIMVideo", RecommendParams.KEY_UIN, str, Constants.PARAM_PKG_NAME, str2);
        return startIMConversation(activity, IM.CHAT_TYPE_VIDEO_CHAT, str, str2);
    }

    public int startIMConversation(Activity activity, String str, String str2, String str3) {
        a("startIMConversation", "chatType", str, RecommendParams.KEY_UIN, str2, Constants.PARAM_PKG_NAME, str3);
        return new IM(getQQToken()).startIMConversation(activity, str, str2, str3);
    }

    public int startMiniApp(Activity activity, String str, String str2, String str3) {
        SLog.i("openSDK_LOG.Tencent", "startMiniApp()");
        a("startMiniApp", "miniAppId", str, "miniAppPath", str2, "miniAppVersion", str3);
        return new MiniApp(getQQToken()).startMiniApp(activity, MiniApp.MINIAPP_TYPE_NORMAL, str, "21", str2, str3);
    }

    public void startAuthManagePage(Activity activity, IApiCallback iApiCallback) {
        SLog.i("openSDK_LOG.Tencent", "startAuthManagePage");
        new QQAuthManage(this.f6542a, getQQToken()).gotoManagePage(activity, iApiCallback);
    }

    private static void a(String str, Object... objArr) {
        b.a().a(str, a(objArr));
    }

    private static String a(Object... objArr) {
        if (objArr == null || objArr.length == 0 || objArr.length % 2 != 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = objArr.length;
        for (int i = 0; i < length; i += 2) {
            if (i > 0) {
                sb.append('|');
            }
            sb.append(objArr[i]);
            sb.append(':');
            sb.append(objArr[i + 1]);
        }
        return sb.toString();
    }

    private static void a(String str, Object obj) {
        b.a().a(str, obj);
    }

    public void bindQQGroup(Activity activity, String str, String str2, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "bindQQGroup()");
        a("bindQQGroup", "organizationId", str, "organizationName", str2);
        new SocialOperation(getQQToken()).bindQQGroup(activity, str, str2, iUiListener);
    }

    public void joinQQGroup(Activity activity, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "joinQQGroup()");
        a("joinQQGroup", "organizationId", str);
        new SocialOperation(getQQToken()).joinGroup(activity, str, iUiListener);
    }

    public void unBindQQGroup(Context context, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "unBindQQGroup()");
        a("unBindQQGroup", "organizationId", str);
        new SocialOperation(getQQToken()).unBindGroup(context, str, iUiListener);
    }
}
