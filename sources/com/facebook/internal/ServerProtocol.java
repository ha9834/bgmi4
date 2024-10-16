package com.facebook.internal;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import java.util.Arrays;
import java.util.Collection;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.l;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class ServerProtocol {
    private static final String DIALOG_AUTHORITY_FORMAT = "m.%s";
    public static final String DIALOG_CANCEL_URI = "fbconnect://cancel";
    public static final String DIALOG_PARAM_ACCESS_TOKEN = "access_token";
    public static final String DIALOG_PARAM_APP_ID = "app_id";
    public static final String DIALOG_PARAM_AUTH_TYPE = "auth_type";
    public static final String DIALOG_PARAM_CBT = "cbt";
    public static final String DIALOG_PARAM_CCT_OVER_LOGGED_OUT_APP_SWITCH = "cct_over_app_switch";
    public static final String DIALOG_PARAM_CLIENT_ID = "client_id";
    public static final String DIALOG_PARAM_CUSTOM_TABS_PREFETCHING = "cct_prefetching";
    public static final String DIALOG_PARAM_DEFAULT_AUDIENCE = "default_audience";
    public static final String DIALOG_PARAM_DISPLAY = "display";
    public static final String DIALOG_PARAM_DISPLAY_TOUCH = "touch";
    public static final String DIALOG_PARAM_E2E = "e2e";
    public static final String DIALOG_PARAM_FAIL_ON_LOGGED_OUT = "fail_on_logged_out";
    public static final String DIALOG_PARAM_IES = "ies";
    public static final String DIALOG_PARAM_LEGACY_OVERRIDE = "legacy_override";
    public static final String DIALOG_PARAM_LOGIN_BEHAVIOR = "login_behavior";
    public static final String DIALOG_PARAM_REDIRECT_URI = "redirect_uri";
    public static final String DIALOG_PARAM_RESPONSE_TYPE = "response_type";
    public static final String DIALOG_PARAM_RETURN_SCOPES = "return_scopes";
    public static final String DIALOG_PARAM_SCOPE = "scope";
    public static final String DIALOG_PARAM_SDK_VERSION = "sdk";
    public static final String DIALOG_PARAM_SSO_DEVICE = "sso";
    public static final String DIALOG_PARAM_STATE = "state";
    public static final String DIALOG_PATH = "dialog/";
    public static final String DIALOG_REDIRECT_CHROME_OS_URI = "fbconnect://chrome_os_success";
    public static final String DIALOG_REDIRECT_URI = "fbconnect://success";
    public static final String DIALOG_REREQUEST_AUTH_TYPE = "rerequest";
    public static final String DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST = "token,signed_request,graph_domain";
    public static final String DIALOG_RETURN_SCOPES_TRUE = "true";
    public static final String FALLBACK_DIALOG_DISPLAY_VALUE_TOUCH = "touch";
    public static final String FALLBACK_DIALOG_PARAM_APP_ID = "app_id";
    public static final String FALLBACK_DIALOG_PARAM_BRIDGE_ARGS = "bridge_args";
    public static final String FALLBACK_DIALOG_PARAM_KEY_HASH = "android_key_hash";
    public static final String FALLBACK_DIALOG_PARAM_METHOD_ARGS = "method_args";
    public static final String FALLBACK_DIALOG_PARAM_METHOD_RESULTS = "method_results";
    public static final String FALLBACK_DIALOG_PARAM_VERSION = "version";
    private static final String GRAPH_URL_FORMAT = "https://graph.%s";
    private static final String GRAPH_VIDEO_URL_FORMAT = "https://graph-video.%s";
    public static final ServerProtocol INSTANCE = new ServerProtocol();
    private static final String TAG;
    private static final String errorConnectionFailure;
    private static final Collection<String> errorsProxyAuthDisabled;
    private static final Collection<String> errorsUserCanceled;

    public static final String getDefaultAPIVersion() {
        return "v9.0";
    }

    public static /* synthetic */ void getErrorConnectionFailure$annotations() {
    }

    public static /* synthetic */ void getErrorsProxyAuthDisabled$annotations() {
    }

    public static /* synthetic */ void getErrorsUserCanceled$annotations() {
    }

    static {
        String name = ServerProtocol.class.getName();
        h.a((Object) name, "ServerProtocol::class.java.name");
        TAG = name;
        errorsProxyAuthDisabled = Utility.unmodifiableCollection("service_disabled", "AndroidAuthKillSwitchException");
        errorsUserCanceled = Utility.unmodifiableCollection("access_denied", "OAuthAccessDeniedException");
        errorConnectionFailure = "CONNECTION_FAILURE";
    }

    private ServerProtocol() {
    }

    public static final Collection<String> getErrorsProxyAuthDisabled() {
        return errorsProxyAuthDisabled;
    }

    public static final Collection<String> getErrorsUserCanceled() {
        return errorsUserCanceled;
    }

    public static final String getErrorConnectionFailure() {
        return errorConnectionFailure;
    }

    public static final String getDialogAuthority() {
        l lVar = l.f6973a;
        Object[] objArr = {FacebookSdk.getFacebookDomain()};
        String format = String.format(DIALOG_AUTHORITY_FORMAT, Arrays.copyOf(objArr, objArr.length));
        h.a((Object) format, "java.lang.String.format(format, *args)");
        return format;
    }

    public static final String getGraphUrlBase() {
        l lVar = l.f6973a;
        Object[] objArr = {FacebookSdk.getGraphDomain()};
        String format = String.format(GRAPH_URL_FORMAT, Arrays.copyOf(objArr, objArr.length));
        h.a((Object) format, "java.lang.String.format(format, *args)");
        return format;
    }

    public static final String getGraphVideoUrlBase() {
        l lVar = l.f6973a;
        Object[] objArr = {FacebookSdk.getGraphDomain()};
        String format = String.format(GRAPH_VIDEO_URL_FORMAT, Arrays.copyOf(objArr, objArr.length));
        h.a((Object) format, "java.lang.String.format(format, *args)");
        return format;
    }

    public static final Bundle getQueryParamsForPlatformActivityIntentWebFallback(String str, int i, Bundle bundle) {
        h.b(str, "callId");
        String applicationSignature = FacebookSdk.getApplicationSignature(FacebookSdk.getApplicationContext());
        if (Utility.isNullOrEmpty(applicationSignature)) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString(FALLBACK_DIALOG_PARAM_KEY_HASH, applicationSignature);
        bundle2.putString("app_id", FacebookSdk.getApplicationId());
        bundle2.putInt("version", i);
        bundle2.putString(DIALOG_PARAM_DISPLAY, "touch");
        Bundle bundle3 = new Bundle();
        bundle3.putString("action_id", str);
        try {
            JSONObject convertToJSON = BundleJSONConverter.convertToJSON(bundle3);
            if (bundle == null) {
                bundle = new Bundle();
            }
            JSONObject convertToJSON2 = BundleJSONConverter.convertToJSON(bundle);
            if (convertToJSON != null && convertToJSON2 != null) {
                bundle2.putString(FALLBACK_DIALOG_PARAM_BRIDGE_ARGS, convertToJSON.toString());
                bundle2.putString(FALLBACK_DIALOG_PARAM_METHOD_ARGS, convertToJSON2.toString());
                return bundle2;
            }
            return null;
        } catch (IllegalArgumentException e) {
            Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, 6, TAG, "Error creating Url -- " + e);
            return null;
        } catch (JSONException e2) {
            Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, 6, TAG, "Error creating Url -- " + e2);
            return null;
        }
    }
}
