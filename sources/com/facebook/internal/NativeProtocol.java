package com.facebook.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookSdk;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.DefaultAudience;
import com.facebook.messenger.MessengerUtils;
import com.tencent.imsdk.android.tools.InnerStat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.d;
import kotlin.collections.j;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.text.l;

/* loaded from: classes.dex */
public final class NativeProtocol {
    public static final String ACTION_APPINVITE_DIALOG = "com.facebook.platform.action.request.APPINVITES_DIALOG";
    public static final String ACTION_CAMERA_EFFECT = "com.facebook.platform.action.request.CAMERA_EFFECT";
    public static final String ACTION_FEED_DIALOG = "com.facebook.platform.action.request.FEED_DIALOG";
    public static final String ACTION_LIKE_DIALOG = "com.facebook.platform.action.request.LIKE_DIALOG";
    public static final String ACTION_MESSAGE_DIALOG = "com.facebook.platform.action.request.MESSAGE_DIALOG";
    public static final String ACTION_OGACTIONPUBLISH_DIALOG = "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";
    public static final String ACTION_OGMESSAGEPUBLISH_DIALOG = "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG";
    public static final String ACTION_SHARE_STORY = "com.facebook.platform.action.request.SHARE_STORY";
    public static final String AUDIENCE_EVERYONE = "everyone";
    public static final String AUDIENCE_FRIENDS = "friends";
    public static final String AUDIENCE_ME = "only_me";
    public static final String BRIDGE_ARG_ACTION_ID_STRING = "action_id";
    public static final String BRIDGE_ARG_APP_NAME_STRING = "app_name";
    public static final String BRIDGE_ARG_ERROR_BUNDLE = "error";
    public static final String BRIDGE_ARG_ERROR_CODE = "error_code";
    public static final String BRIDGE_ARG_ERROR_DESCRIPTION = "error_description";
    public static final String BRIDGE_ARG_ERROR_JSON = "error_json";
    public static final String BRIDGE_ARG_ERROR_SUBCODE = "error_subcode";
    public static final String BRIDGE_ARG_ERROR_TYPE = "error_type";
    private static final String CONTENT_SCHEME = "content://";
    public static final String ERROR_APPLICATION_ERROR = "ApplicationError";
    public static final String ERROR_NETWORK_ERROR = "NetworkError";
    public static final String ERROR_PERMISSION_DENIED = "PermissionDenied";
    public static final String ERROR_PROTOCOL_ERROR = "ProtocolError";
    public static final String ERROR_SERVICE_DISABLED = "ServiceDisabled";
    public static final String ERROR_UNKNOWN_ERROR = "UnknownError";
    public static final String ERROR_USER_CANCELED = "UserCanceled";
    public static final String EXTRA_ACCESS_TOKEN = "com.facebook.platform.extra.ACCESS_TOKEN";
    public static final String EXTRA_APPLICATION_ID = "com.facebook.platform.extra.APPLICATION_ID";
    public static final String EXTRA_APPLICATION_NAME = "com.facebook.platform.extra.APPLICATION_NAME";
    public static final String EXTRA_DATA_ACCESS_EXPIRATION_TIME = "com.facebook.platform.extra.EXTRA_DATA_ACCESS_EXPIRATION_TIME";
    public static final String EXTRA_DIALOG_COMPLETE_KEY = "com.facebook.platform.extra.DID_COMPLETE";
    public static final String EXTRA_DIALOG_COMPLETION_GESTURE_KEY = "com.facebook.platform.extra.COMPLETION_GESTURE";
    public static final String EXTRA_EXPIRES_SECONDS_SINCE_EPOCH = "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH";
    public static final String EXTRA_GET_INSTALL_DATA_PACKAGE = "com.facebook.platform.extra.INSTALLDATA_PACKAGE";
    public static final String EXTRA_GRAPH_API_VERSION = "com.facebook.platform.extra.GRAPH_API_VERSION";
    public static final String EXTRA_LOGGER_REF = "com.facebook.platform.extra.LOGGER_REF";
    public static final String EXTRA_PERMISSIONS = "com.facebook.platform.extra.PERMISSIONS";
    public static final String EXTRA_PROTOCOL_ACTION = "com.facebook.platform.protocol.PROTOCOL_ACTION";
    public static final String EXTRA_PROTOCOL_BRIDGE_ARGS = "com.facebook.platform.protocol.BRIDGE_ARGS";
    public static final String EXTRA_PROTOCOL_CALL_ID = "com.facebook.platform.protocol.CALL_ID";
    public static final String EXTRA_PROTOCOL_METHOD_ARGS = "com.facebook.platform.protocol.METHOD_ARGS";
    public static final String EXTRA_PROTOCOL_METHOD_RESULTS = "com.facebook.platform.protocol.RESULT_ARGS";
    public static final String EXTRA_PROTOCOL_VERSION = "com.facebook.platform.protocol.PROTOCOL_VERSION";
    public static final String EXTRA_PROTOCOL_VERSIONS = "com.facebook.platform.extra.PROTOCOL_VERSIONS";
    public static final String EXTRA_TOAST_DURATION_MS = "com.facebook.platform.extra.EXTRA_TOAST_DURATION_MS";
    public static final String EXTRA_USER_ID = "com.facebook.platform.extra.USER_ID";
    private static final String FACEBOOK_PROXY_AUTH_ACTIVITY = "com.facebook.katana.ProxyAuth";
    public static final String FACEBOOK_PROXY_AUTH_APP_ID_KEY = "client_id";
    public static final String FACEBOOK_PROXY_AUTH_E2E_KEY = "e2e";
    public static final String FACEBOOK_PROXY_AUTH_PERMISSIONS_KEY = "scope";
    public static final String FACEBOOK_SDK_VERSION_KEY = "facebook_sdk_version";
    private static final String FACEBOOK_TOKEN_REFRESH_ACTIVITY = "com.facebook.katana.platform.TokenRefreshService";
    public static final String IMAGE_URL_KEY = "url";
    public static final String IMAGE_USER_GENERATED_KEY = "user_generated";
    public static final NativeProtocol INSTANCE;
    public static final String INTENT_ACTION_PLATFORM_ACTIVITY = "com.facebook.platform.PLATFORM_ACTIVITY";
    public static final String INTENT_ACTION_PLATFORM_SERVICE = "com.facebook.platform.PLATFORM_SERVICE";
    private static final Integer[] KNOWN_PROTOCOL_VERSIONS;
    public static final int MESSAGE_GET_ACCESS_TOKEN_REPLY = 65537;
    public static final int MESSAGE_GET_ACCESS_TOKEN_REQUEST = 65536;
    public static final int MESSAGE_GET_AK_SEAMLESS_TOKEN_REPLY = 65545;
    public static final int MESSAGE_GET_AK_SEAMLESS_TOKEN_REQUEST = 65544;
    public static final int MESSAGE_GET_INSTALL_DATA_REPLY = 65541;
    public static final int MESSAGE_GET_INSTALL_DATA_REQUEST = 65540;
    public static final int MESSAGE_GET_LIKE_STATUS_REPLY = 65543;
    public static final int MESSAGE_GET_LIKE_STATUS_REQUEST = 65542;
    public static final int MESSAGE_GET_LOGIN_STATUS_REPLY = 65547;
    public static final int MESSAGE_GET_LOGIN_STATUS_REQUEST = 65546;
    public static final int MESSAGE_GET_PROTOCOL_VERSIONS_REPLY = 65539;
    public static final int MESSAGE_GET_PROTOCOL_VERSIONS_REQUEST = 65538;
    public static final int NO_PROTOCOL_AVAILABLE = -1;
    public static final String OPEN_GRAPH_CREATE_OBJECT_KEY = "fbsdk:create_object";
    private static final String PLATFORM_PROVIDER = ".provider.PlatformProvider";
    private static final String PLATFORM_PROVIDER_VERSIONS = ".provider.PlatformProvider/versions";
    private static final String PLATFORM_PROVIDER_VERSION_COLUMN = "version";
    public static final int PROTOCOL_VERSION_20121101 = 20121101;
    public static final int PROTOCOL_VERSION_20130502 = 20130502;
    public static final int PROTOCOL_VERSION_20130618 = 20130618;
    public static final int PROTOCOL_VERSION_20131107 = 20131107;
    public static final int PROTOCOL_VERSION_20140204 = 20140204;
    public static final int PROTOCOL_VERSION_20140324 = 20140324;
    public static final int PROTOCOL_VERSION_20140701 = 20140701;
    public static final int PROTOCOL_VERSION_20141001 = 20141001;
    public static final int PROTOCOL_VERSION_20141028 = 20141028;
    public static final int PROTOCOL_VERSION_20141107 = 20141107;
    public static final int PROTOCOL_VERSION_20141218 = 20141218;
    public static final int PROTOCOL_VERSION_20160327 = 20160327;
    public static final int PROTOCOL_VERSION_20170213 = 20170213;
    public static final int PROTOCOL_VERSION_20170411 = 20170411;
    public static final int PROTOCOL_VERSION_20170417 = 20170417;
    public static final int PROTOCOL_VERSION_20171115 = 20171115;
    public static final String RESULT_ARGS_ACCESS_TOKEN = "access_token";
    public static final String RESULT_ARGS_DIALOG_COMPLETE_KEY = "didComplete";
    public static final String RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY = "completionGesture";
    public static final String RESULT_ARGS_EXPIRES_SECONDS_SINCE_EPOCH = "expires_seconds_since_epoch";
    public static final String RESULT_ARGS_GRAPH_DOMAIN = "graph_domain";
    public static final String RESULT_ARGS_PERMISSIONS = "permissions";
    public static final String RESULT_ARGS_SIGNED_REQUEST = "signed request";
    public static final String STATUS_ERROR_CODE = "com.facebook.platform.status.ERROR_CODE";
    public static final String STATUS_ERROR_DESCRIPTION = "com.facebook.platform.status.ERROR_DESCRIPTION";
    public static final String STATUS_ERROR_JSON = "com.facebook.platform.status.ERROR_JSON";
    public static final String STATUS_ERROR_SUBCODE = "com.facebook.platform.status.ERROR_SUBCODE";
    public static final String STATUS_ERROR_TYPE = "com.facebook.platform.status.ERROR_TYPE";
    private static final String TAG;
    public static final String WEB_DIALOG_ACTION = "action";
    public static final String WEB_DIALOG_IS_FALLBACK = "is_fallback";
    public static final String WEB_DIALOG_PARAMS = "params";
    public static final String WEB_DIALOG_URL = "url";
    private static final Map<String, List<NativeAppInfo>> actionToAppInfoMap;
    private static final List<NativeAppInfo> effectCameraAppInfoList;
    private static final List<NativeAppInfo> facebookAppInfoList;
    private static final AtomicBoolean protocolVersionsAsyncUpdating;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class KatanaAppInfo extends NativeAppInfo {
        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getLoginActivity() {
            return NativeProtocol.FACEBOOK_PROXY_AUTH_ACTIVITY;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getPackage() {
            return InnerStat.ThirdPN.FACEBOOK;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class WakizashiAppInfo extends NativeAppInfo {
        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getLoginActivity() {
            return NativeProtocol.FACEBOOK_PROXY_AUTH_ACTIVITY;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getPackage() {
            return "com.facebook.wakizashi";
        }
    }

    public static /* synthetic */ void getLatestKnownVersion$annotations() {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
        }
    }

    static {
        NativeProtocol nativeProtocol = new NativeProtocol();
        INSTANCE = nativeProtocol;
        String name = NativeProtocol.class.getName();
        h.a((Object) name, "NativeProtocol::class.java.name");
        TAG = name;
        facebookAppInfoList = nativeProtocol.buildFacebookAppList();
        effectCameraAppInfoList = nativeProtocol.buildEffectCameraAppInfoList();
        actionToAppInfoMap = nativeProtocol.buildActionToAppInfoMap();
        protocolVersionsAsyncUpdating = new AtomicBoolean(false);
        KNOWN_PROTOCOL_VERSIONS = new Integer[]{Integer.valueOf(PROTOCOL_VERSION_20170417), Integer.valueOf(PROTOCOL_VERSION_20160327), Integer.valueOf(PROTOCOL_VERSION_20141218), Integer.valueOf(PROTOCOL_VERSION_20141107), Integer.valueOf(PROTOCOL_VERSION_20141028), Integer.valueOf(PROTOCOL_VERSION_20141001), Integer.valueOf(PROTOCOL_VERSION_20140701), Integer.valueOf(PROTOCOL_VERSION_20140324), Integer.valueOf(PROTOCOL_VERSION_20140204), Integer.valueOf(PROTOCOL_VERSION_20131107), Integer.valueOf(PROTOCOL_VERSION_20130618), Integer.valueOf(PROTOCOL_VERSION_20130502), Integer.valueOf(PROTOCOL_VERSION_20121101)};
    }

    private NativeProtocol() {
    }

    public static final /* synthetic */ TreeSet access$fetchAllAvailableProtocolVersionsForAppInfo(NativeProtocol nativeProtocol, NativeAppInfo nativeAppInfo) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            return nativeProtocol.fetchAllAvailableProtocolVersionsForAppInfo(nativeAppInfo);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    public static final /* synthetic */ List access$getFacebookAppInfoList$p(NativeProtocol nativeProtocol) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            return facebookAppInfoList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    public static final /* synthetic */ AtomicBoolean access$getProtocolVersionsAsyncUpdating$p(NativeProtocol nativeProtocol) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            return protocolVersionsAsyncUpdating;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    private final List<NativeAppInfo> buildFacebookAppList() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return j.c(new KatanaAppInfo(), new WakizashiAppInfo());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final List<NativeAppInfo> buildEffectCameraAppInfoList() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList c = j.c(new EffectTestAppInfo());
            c.addAll(buildFacebookAppList());
            return c;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final Map<String, List<NativeAppInfo>> buildActionToAppInfoMap() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new MessengerAppInfo());
            hashMap.put(ACTION_OGACTIONPUBLISH_DIALOG, facebookAppInfoList);
            hashMap.put(ACTION_FEED_DIALOG, facebookAppInfoList);
            hashMap.put(ACTION_LIKE_DIALOG, facebookAppInfoList);
            hashMap.put(ACTION_APPINVITE_DIALOG, facebookAppInfoList);
            hashMap.put(ACTION_MESSAGE_DIALOG, arrayList);
            hashMap.put(ACTION_OGMESSAGEPUBLISH_DIALOG, arrayList);
            hashMap.put(ACTION_CAMERA_EFFECT, effectCameraAppInfoList);
            hashMap.put(ACTION_SHARE_STORY, facebookAppInfoList);
            return hashMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public static final Intent validateActivityIntent(Context context, Intent intent, NativeAppInfo nativeAppInfo) {
        ResolveInfo resolveActivity;
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            h.b(context, "context");
            if (intent == null || (resolveActivity = context.getPackageManager().resolveActivity(intent, 0)) == null) {
                return null;
            }
            String str = resolveActivity.activityInfo.packageName;
            h.a((Object) str, "resolveInfo.activityInfo.packageName");
            if (FacebookSignatureValidator.validateSignature(context, str)) {
                return intent;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    public static final Intent validateServiceIntent(Context context, Intent intent, NativeAppInfo nativeAppInfo) {
        ResolveInfo resolveService;
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            h.b(context, "context");
            if (intent == null || (resolveService = context.getPackageManager().resolveService(intent, 0)) == null) {
                return null;
            }
            String str = resolveService.serviceInfo.packageName;
            h.a((Object) str, "resolveInfo.serviceInfo.packageName");
            if (FacebookSignatureValidator.validateSignature(context, str)) {
                return intent;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    public static final Intent createFacebookLiteIntent(Context context, String str, Collection<String> collection, String str2, boolean z, boolean z2, DefaultAudience defaultAudience, String str3, String str4) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            h.b(context, "context");
            h.b(str, "applicationId");
            h.b(collection, "permissions");
            h.b(str2, "e2e");
            h.b(defaultAudience, "defaultAudience");
            h.b(str3, "clientState");
            h.b(str4, "authType");
            FBLiteAppInfo fBLiteAppInfo = new FBLiteAppInfo();
            return validateActivityIntent(context, INSTANCE.createNativeAppIntent(fBLiteAppInfo, str, collection, str2, z2, defaultAudience, str3, str4, false), fBLiteAppInfo);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    private final Intent createNativeAppIntent(NativeAppInfo nativeAppInfo, String str, Collection<String> collection, String str2, boolean z, DefaultAudience defaultAudience, String str3, String str4, boolean z2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            String loginActivity = nativeAppInfo.getLoginActivity();
            if (loginActivity == null) {
                return null;
            }
            Intent putExtra = new Intent().setClassName(nativeAppInfo.getPackage(), loginActivity).putExtra("client_id", str);
            h.a((Object) putExtra, "Intent()\n            .se…PP_ID_KEY, applicationId)");
            putExtra.putExtra(FACEBOOK_SDK_VERSION_KEY, FacebookSdk.getSdkVersion());
            if (!Utility.isNullOrEmpty(collection)) {
                putExtra.putExtra("scope", TextUtils.join(",", collection));
            }
            if (!Utility.isNullOrEmpty(str2)) {
                putExtra.putExtra("e2e", str2);
            }
            putExtra.putExtra("state", str3);
            putExtra.putExtra(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST);
            putExtra.putExtra(ServerProtocol.DIALOG_PARAM_RETURN_SCOPES, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            if (z) {
                putExtra.putExtra(ServerProtocol.DIALOG_PARAM_DEFAULT_AUDIENCE, defaultAudience.getNativeProtocolAudience());
            }
            putExtra.putExtra(ServerProtocol.DIALOG_PARAM_LEGACY_OVERRIDE, FacebookSdk.getGraphApiVersion());
            putExtra.putExtra(ServerProtocol.DIALOG_PARAM_AUTH_TYPE, str4);
            if (z2) {
                putExtra.putExtra(ServerProtocol.DIALOG_PARAM_FAIL_ON_LOGGED_OUT, true);
            }
            return putExtra;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public static final List<Intent> createProxyAuthIntents(Context context, String str, Collection<String> collection, String str2, boolean z, boolean z2, DefaultAudience defaultAudience, String str3, String str4, boolean z3) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            h.b(str, "applicationId");
            h.b(collection, "permissions");
            h.b(str2, "e2e");
            h.b(defaultAudience, "defaultAudience");
            h.b(str3, "clientState");
            h.b(str4, "authType");
            List<NativeAppInfo> list = facebookAppInfoList;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ArrayList arrayList2 = arrayList;
                Intent createNativeAppIntent = INSTANCE.createNativeAppIntent((NativeAppInfo) it.next(), str, collection, str2, z2, defaultAudience, str3, str4, z3);
                if (createNativeAppIntent != null) {
                    arrayList2.add(createNativeAppIntent);
                }
                arrayList = arrayList2;
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    public static final Intent createTokenRefreshIntent(Context context) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            h.b(context, "context");
            for (NativeAppInfo nativeAppInfo : facebookAppInfoList) {
                Intent validateServiceIntent = validateServiceIntent(context, new Intent().setClassName(nativeAppInfo.getPackage(), FACEBOOK_TOKEN_REFRESH_ACTIVITY), nativeAppInfo);
                if (validateServiceIntent != null) {
                    return validateServiceIntent;
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    public static final int getLatestKnownVersion() {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return 0;
        }
        try {
            return KNOWN_PROTOCOL_VERSIONS[0].intValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return 0;
        }
    }

    public static final boolean isVersionCompatibleWithBucketedIntent(int i) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return false;
        }
        try {
            return d.a(KNOWN_PROTOCOL_VERSIONS, Integer.valueOf(i)) && i >= 20140701;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return false;
        }
    }

    public static final Intent createPlatformActivityIntent(Context context, String str, String str2, ProtocolVersionQueryResult protocolVersionQueryResult, Bundle bundle) {
        NativeAppInfo appInfo;
        Intent validateActivityIntent;
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            h.b(context, "context");
            if (protocolVersionQueryResult == null || (appInfo = protocolVersionQueryResult.getAppInfo()) == null || (validateActivityIntent = validateActivityIntent(context, new Intent().setAction(INTENT_ACTION_PLATFORM_ACTIVITY).setPackage(appInfo.getPackage()).addCategory("android.intent.category.DEFAULT"), appInfo)) == null) {
                return null;
            }
            setupProtocolRequestIntent(validateActivityIntent, str, str2, protocolVersionQueryResult.getProtocolVersion(), bundle);
            return validateActivityIntent;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    public static final void setupProtocolRequestIntent(Intent intent, String str, String str2, int i, Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return;
        }
        try {
            h.b(intent, SDKConstants.PARAM_INTENT);
            String applicationId = FacebookSdk.getApplicationId();
            String applicationName = FacebookSdk.getApplicationName();
            intent.putExtra(EXTRA_PROTOCOL_VERSION, i).putExtra(EXTRA_PROTOCOL_ACTION, str2).putExtra(EXTRA_APPLICATION_ID, applicationId);
            if (isVersionCompatibleWithBucketedIntent(i)) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("action_id", str);
                Utility.putNonEmptyString(bundle2, "app_name", applicationName);
                intent.putExtra(EXTRA_PROTOCOL_BRIDGE_ARGS, bundle2);
                if (bundle == null) {
                    bundle = new Bundle();
                }
                h.a((Object) intent.putExtra(EXTRA_PROTOCOL_METHOD_ARGS, bundle), "intent.putExtra(EXTRA_PR…OD_ARGS, methodArguments)");
                return;
            }
            intent.putExtra(EXTRA_PROTOCOL_CALL_ID, str);
            if (!Utility.isNullOrEmpty(applicationName)) {
                intent.putExtra(EXTRA_APPLICATION_NAME, applicationName);
            }
            if (bundle != null) {
                intent.putExtras(bundle);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
        }
    }

    public static final Intent createProtocolResultIntent(Intent intent, Bundle bundle, FacebookException facebookException) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            h.b(intent, "requestIntent");
            UUID callIdFromIntent = getCallIdFromIntent(intent);
            if (callIdFromIntent == null) {
                return null;
            }
            Intent intent2 = new Intent();
            intent2.putExtra(EXTRA_PROTOCOL_VERSION, getProtocolVersionFromIntent(intent));
            Bundle bundle2 = new Bundle();
            bundle2.putString("action_id", callIdFromIntent.toString());
            if (facebookException != null) {
                bundle2.putBundle("error", createBundleForException(facebookException));
            }
            intent2.putExtra(EXTRA_PROTOCOL_BRIDGE_ARGS, bundle2);
            if (bundle != null) {
                intent2.putExtra(EXTRA_PROTOCOL_METHOD_RESULTS, bundle);
            }
            return intent2;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    public static final Intent createPlatformServiceIntent(Context context) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            h.b(context, "context");
            for (NativeAppInfo nativeAppInfo : facebookAppInfoList) {
                Intent validateServiceIntent = validateServiceIntent(context, new Intent(INTENT_ACTION_PLATFORM_SERVICE).setPackage(nativeAppInfo.getPackage()).addCategory("android.intent.category.DEFAULT"), nativeAppInfo);
                if (validateServiceIntent != null) {
                    return validateServiceIntent;
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    public static final int getProtocolVersionFromIntent(Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return 0;
        }
        try {
            h.b(intent, SDKConstants.PARAM_INTENT);
            return intent.getIntExtra(EXTRA_PROTOCOL_VERSION, 0);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return 0;
        }
    }

    public static final UUID getCallIdFromIntent(Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class) || intent == null) {
            return null;
        }
        try {
            String str = (String) null;
            if (isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
                Bundle bundleExtra = intent.getBundleExtra(EXTRA_PROTOCOL_BRIDGE_ARGS);
                if (bundleExtra != null) {
                    str = bundleExtra.getString("action_id");
                }
            } else {
                str = intent.getStringExtra(EXTRA_PROTOCOL_CALL_ID);
            }
            UUID uuid = (UUID) null;
            if (str == null) {
                return uuid;
            }
            try {
                return UUID.fromString(str);
            } catch (IllegalArgumentException unused) {
                return uuid;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    public static final Bundle getBridgeArgumentsFromIntent(Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            h.b(intent, SDKConstants.PARAM_INTENT);
            if (isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
                return intent.getBundleExtra(EXTRA_PROTOCOL_BRIDGE_ARGS);
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    public static final Bundle getMethodArgumentsFromIntent(Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            h.b(intent, SDKConstants.PARAM_INTENT);
            if (!isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
                return intent.getExtras();
            }
            return intent.getBundleExtra(EXTRA_PROTOCOL_METHOD_ARGS);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    public static final Bundle getSuccessResultsFromIntent(Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            h.b(intent, "resultIntent");
            int protocolVersionFromIntent = getProtocolVersionFromIntent(intent);
            Bundle extras = intent.getExtras();
            if (isVersionCompatibleWithBucketedIntent(protocolVersionFromIntent) && extras != null) {
                return extras.getBundle(EXTRA_PROTOCOL_METHOD_RESULTS);
            }
            return extras;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    public static final boolean isErrorResult(Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return false;
        }
        try {
            h.b(intent, "resultIntent");
            Bundle bridgeArgumentsFromIntent = getBridgeArgumentsFromIntent(intent);
            if (bridgeArgumentsFromIntent != null) {
                return bridgeArgumentsFromIntent.containsKey("error");
            }
            return intent.hasExtra(STATUS_ERROR_TYPE);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return false;
        }
    }

    public static final Bundle getErrorDataFromResultIntent(Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            h.b(intent, "resultIntent");
            if (!isErrorResult(intent)) {
                return null;
            }
            Bundle bridgeArgumentsFromIntent = getBridgeArgumentsFromIntent(intent);
            if (bridgeArgumentsFromIntent != null) {
                return bridgeArgumentsFromIntent.getBundle("error");
            }
            return intent.getExtras();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    public static final FacebookException getExceptionFromErrorData(Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class) || bundle == null) {
            return null;
        }
        try {
            String string = bundle.getString("error_type");
            if (string == null) {
                string = bundle.getString(STATUS_ERROR_TYPE);
            }
            String string2 = bundle.getString(BRIDGE_ARG_ERROR_DESCRIPTION);
            if (string2 == null) {
                string2 = bundle.getString(STATUS_ERROR_DESCRIPTION);
            }
            if (string != null && l.a(string, ERROR_USER_CANCELED, true)) {
                return new FacebookOperationCanceledException(string2);
            }
            return new FacebookException(string2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    public static final Bundle createBundleForException(FacebookException facebookException) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class) || facebookException == null) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString(BRIDGE_ARG_ERROR_DESCRIPTION, facebookException.toString());
            if (facebookException instanceof FacebookOperationCanceledException) {
                bundle.putString("error_type", ERROR_USER_CANCELED);
            }
            return bundle;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    public static final int getLatestAvailableProtocolVersionForService(int i) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return 0;
        }
        try {
            return INSTANCE.getLatestAvailableProtocolVersionForAppInfoList(facebookAppInfoList, new int[]{i}).getProtocolVersion();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return 0;
        }
    }

    public static final ProtocolVersionQueryResult getLatestAvailableProtocolVersionForAction(String str, int[] iArr) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            h.b(str, "action");
            h.b(iArr, "versionSpec");
            List<NativeAppInfo> list = actionToAppInfoMap.get(str);
            if (list == null) {
                list = j.a();
            }
            return INSTANCE.getLatestAvailableProtocolVersionForAppInfoList(list, iArr);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    private final ProtocolVersionQueryResult getLatestAvailableProtocolVersionForAppInfoList(List<? extends NativeAppInfo> list, int[] iArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            updateAllAvailableProtocolVersionsAsync();
            if (list == null) {
                return ProtocolVersionQueryResult.Companion.createEmpty();
            }
            for (NativeAppInfo nativeAppInfo : list) {
                int computeLatestAvailableVersionFromVersionSpec = computeLatestAvailableVersionFromVersionSpec(nativeAppInfo.getAvailableVersions(), getLatestKnownVersion(), iArr);
                if (computeLatestAvailableVersionFromVersionSpec != -1) {
                    return ProtocolVersionQueryResult.Companion.create(nativeAppInfo, computeLatestAvailableVersionFromVersionSpec);
                }
            }
            return ProtocolVersionQueryResult.Companion.createEmpty();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public static final void updateAllAvailableProtocolVersionsAsync() {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return;
        }
        try {
            if (protocolVersionsAsyncUpdating.compareAndSet(false, true)) {
                FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.internal.NativeProtocol$updateAllAvailableProtocolVersionsAsync$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (CrashShieldHandler.isObjectCrashing(this)) {
                            return;
                        }
                        try {
                            if (CrashShieldHandler.isObjectCrashing(this)) {
                                return;
                            }
                            try {
                                try {
                                    Iterator it = NativeProtocol.access$getFacebookAppInfoList$p(NativeProtocol.INSTANCE).iterator();
                                    while (it.hasNext()) {
                                        ((NativeProtocol.NativeAppInfo) it.next()).fetchAvailableVersions(true);
                                    }
                                } finally {
                                    NativeProtocol.access$getProtocolVersionsAsyncUpdating$p(NativeProtocol.INSTANCE).set(false);
                                }
                            } catch (Throwable th) {
                                CrashShieldHandler.handleThrowable(th, this);
                            }
                        } catch (Throwable th2) {
                            CrashShieldHandler.handleThrowable(th2, this);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
        }
    }

    private final TreeSet<Integer> fetchAllAvailableProtocolVersionsForAppInfo(NativeAppInfo nativeAppInfo) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            TreeSet<Integer> treeSet = new TreeSet<>();
            Context applicationContext = FacebookSdk.getApplicationContext();
            h.a((Object) applicationContext, "appContext");
            ContentResolver contentResolver = applicationContext.getContentResolver();
            String[] strArr = {"version"};
            Uri buildPlatformProviderVersionURI = buildPlatformProviderVersionURI(nativeAppInfo);
            Cursor cursor = (Cursor) null;
            try {
                Context applicationContext2 = FacebookSdk.getApplicationContext();
                h.a((Object) applicationContext2, "FacebookSdk.getApplicationContext()");
                ProviderInfo providerInfo = (ProviderInfo) null;
                try {
                    providerInfo = applicationContext2.getPackageManager().resolveContentProvider(nativeAppInfo.getPackage() + PLATFORM_PROVIDER, 0);
                } catch (RuntimeException e) {
                    Log.e(TAG, "Failed to query content resolver.", e);
                }
                if (providerInfo != null) {
                    try {
                        try {
                            cursor = contentResolver.query(buildPlatformProviderVersionURI, strArr, null, null, null);
                        } catch (IllegalArgumentException unused) {
                            Log.e(TAG, "Failed to query content resolver.");
                            cursor = null;
                        }
                    } catch (NullPointerException unused2) {
                        Log.e(TAG, "Failed to query content resolver.");
                        cursor = null;
                    } catch (SecurityException unused3) {
                        Log.e(TAG, "Failed to query content resolver.");
                        cursor = null;
                    }
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            treeSet.add(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("version"))));
                        }
                    }
                }
                return treeSet;
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public static final int computeLatestAvailableVersionFromVersionSpec(TreeSet<Integer> treeSet, int i, int[] iArr) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return 0;
        }
        try {
            h.b(iArr, "versionSpec");
            if (treeSet == null) {
                return -1;
            }
            int length = iArr.length - 1;
            Iterator<Integer> descendingIterator = treeSet.descendingIterator();
            int i2 = length;
            int i3 = -1;
            while (descendingIterator.hasNext()) {
                Integer next = descendingIterator.next();
                h.a((Object) next, "fbAppVersion");
                i3 = Math.max(i3, next.intValue());
                while (i2 >= 0 && iArr[i2] > next.intValue()) {
                    i2--;
                }
                if (i2 < 0) {
                    return -1;
                }
                if (iArr[i2] == next.intValue()) {
                    if (i2 % 2 == 0) {
                        return Math.min(i3, i);
                    }
                    return -1;
                }
            }
            return -1;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return 0;
        }
    }

    private final Uri buildPlatformProviderVersionURI(NativeAppInfo nativeAppInfo) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Uri parse = Uri.parse("content://" + nativeAppInfo.getPackage() + PLATFORM_PROVIDER_VERSIONS);
            h.a((Object) parse, "Uri.parse(CONTENT_SCHEME…ATFORM_PROVIDER_VERSIONS)");
            return parse;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class NativeAppInfo {
        private TreeSet<Integer> availableVersions;

        public abstract String getLoginActivity();

        public abstract String getPackage();

        public final TreeSet<Integer> getAvailableVersions() {
            TreeSet<Integer> treeSet = this.availableVersions;
            if (treeSet == null || treeSet == null || treeSet.isEmpty()) {
                fetchAvailableVersions(false);
            }
            return this.availableVersions;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x000f, code lost:
        
            if (r1.isEmpty() == false) goto L11;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final synchronized void fetchAvailableVersions(boolean r1) {
            /*
                r0 = this;
                monitor-enter(r0)
                if (r1 != 0) goto L11
                java.util.TreeSet<java.lang.Integer> r1 = r0.availableVersions     // Catch: java.lang.Throwable -> L1b
                if (r1 == 0) goto L11
                java.util.TreeSet<java.lang.Integer> r1 = r0.availableVersions     // Catch: java.lang.Throwable -> L1b
                if (r1 == 0) goto L11
                boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L1b
                if (r1 == 0) goto L19
            L11:
                com.facebook.internal.NativeProtocol r1 = com.facebook.internal.NativeProtocol.INSTANCE     // Catch: java.lang.Throwable -> L1b
                java.util.TreeSet r1 = com.facebook.internal.NativeProtocol.access$fetchAllAvailableProtocolVersionsForAppInfo(r1, r0)     // Catch: java.lang.Throwable -> L1b
                r0.availableVersions = r1     // Catch: java.lang.Throwable -> L1b
            L19:
                monitor-exit(r0)
                return
            L1b:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.NativeProtocol.NativeAppInfo.fetchAvailableVersions(boolean):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class MessengerAppInfo extends NativeAppInfo {
        /* renamed from: getLoginActivity, reason: collision with other method in class */
        public Void m6getLoginActivity() {
            return null;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getPackage() {
            return MessengerUtils.PACKAGE_NAME;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public /* bridge */ /* synthetic */ String getLoginActivity() {
            return (String) m6getLoginActivity();
        }
    }

    /* loaded from: classes.dex */
    private static final class FBLiteAppInfo extends NativeAppInfo {
        public static final Companion Companion = new Companion(null);
        public static final String FACEBOOK_LITE_ACTIVITY = "com.facebook.lite.platform.LoginGDPDialogActivity";

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getLoginActivity() {
            return FACEBOOK_LITE_ACTIVITY;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getPackage() {
            return "com.facebook.lite";
        }

        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(f fVar) {
                this();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class EffectTestAppInfo extends NativeAppInfo {
        /* renamed from: getLoginActivity, reason: collision with other method in class */
        public Void m5getLoginActivity() {
            return null;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getPackage() {
            return "com.facebook.arstudio.player";
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public /* bridge */ /* synthetic */ String getLoginActivity() {
            return (String) m5getLoginActivity();
        }
    }

    /* loaded from: classes.dex */
    public static final class ProtocolVersionQueryResult {
        public static final Companion Companion = new Companion(null);
        private NativeAppInfo appInfo;
        private int protocolVersion;

        public static final ProtocolVersionQueryResult create(NativeAppInfo nativeAppInfo, int i) {
            return Companion.create(nativeAppInfo, i);
        }

        public static final ProtocolVersionQueryResult createEmpty() {
            return Companion.createEmpty();
        }

        private ProtocolVersionQueryResult() {
        }

        public /* synthetic */ ProtocolVersionQueryResult(f fVar) {
            this();
        }

        public final NativeAppInfo getAppInfo() {
            return this.appInfo;
        }

        public final int getProtocolVersion() {
            return this.protocolVersion;
        }

        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final ProtocolVersionQueryResult create(NativeAppInfo nativeAppInfo, int i) {
                ProtocolVersionQueryResult protocolVersionQueryResult = new ProtocolVersionQueryResult(null);
                protocolVersionQueryResult.appInfo = nativeAppInfo;
                protocolVersionQueryResult.protocolVersion = i;
                return protocolVersionQueryResult;
            }

            public final ProtocolVersionQueryResult createEmpty() {
                ProtocolVersionQueryResult protocolVersionQueryResult = new ProtocolVersionQueryResult(null);
                protocolVersionQueryResult.protocolVersion = -1;
                return protocolVersionQueryResult;
            }
        }
    }
}
