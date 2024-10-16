package com.vk.api.sdk.internal;

import android.os.Bundle;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.nearby.messages.BleSignal;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.helpshift.analytics.AnalyticsEventKey;
import com.vk.api.sdk.exceptions.VKApiException;
import com.vk.api.sdk.exceptions.VKApiExecutionException;
import com.vk.api.sdk.exceptions.VKApiIllegalResponseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import kotlin.jvm.internal.h;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f6884a = new d();

    private d() {
    }

    public final boolean a(String str) {
        h.b(str, AnalyticsEventKey.RESPONSE);
        return b.f6882a.a(str, "error");
    }

    public final boolean a(String str, int[] iArr) {
        h.b(str, AnalyticsEventKey.RESPONSE);
        if (!b.f6882a.a(str, "execute_errors")) {
            return false;
        }
        if (iArr == null) {
            return true;
        }
        Set<Integer> b = b(str);
        for (int i : iArr) {
            b.remove(Integer.valueOf(i));
        }
        return !b.isEmpty();
    }

    private final Set<Integer> b(String str) {
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = new JSONObject(str).getJSONArray("execute_errors");
        int length = jSONArray.length();
        if (length > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                hashSet.add(Integer.valueOf(jSONArray.getJSONObject(i).getInt("error_code")));
                if (i2 >= length) {
                    break;
                }
                i = i2;
            }
        }
        return hashSet;
    }

    public final VKApiException a(String str, String str2, String str3) {
        h.b(str, "errorStr");
        JSONObject optJSONObject = new JSONObject(str).optJSONObject("error");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject(str);
        }
        return a(optJSONObject, str2, str3);
    }

    public static /* synthetic */ VKApiException a(d dVar, JSONObject jSONObject, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        return dVar.a(jSONObject, str, str2);
    }

    public final VKApiException a(JSONObject jSONObject, String str, String str2) {
        h.b(jSONObject, "errorJson");
        try {
            int optInt = jSONObject.optInt("error_code");
            Bundle bundle = null;
            if (optInt == 5) {
                JSONObject optJSONObject = jSONObject.optJSONObject("ban_info");
                if (optJSONObject != null) {
                    bundle = new Bundle();
                    bundle.putString("user_ban_info", optJSONObject.toString());
                }
            } else if (optInt == 14) {
                bundle = new Bundle();
                bundle.putString("captcha_sid", jSONObject.getString("captcha_sid"));
                bundle.putString("captcha_img", jSONObject.getString("captcha_img"));
            } else if (optInt == 17) {
                bundle = new Bundle();
                bundle.putString("validation_url", jSONObject.getString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI));
            } else if (optInt == 24) {
                bundle = new Bundle();
                bundle.putString("confirmation_text", jSONObject.getString("confirmation_text"));
            } else if (optInt == 3609) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("extend_hash", jSONObject.optString("extend_hash", null));
                bundle = bundle2;
            }
            if (str2 != null) {
                if (bundle == null) {
                    bundle = new Bundle(1);
                }
                bundle.putString("access_token", str2);
            }
            return VKApiExecutionException.b.a(jSONObject, str, bundle);
        } catch (Exception e) {
            String jSONObject2 = jSONObject.toString();
            h.a((Object) jSONObject2, "errorJson.toString()");
            return new VKApiIllegalResponseException(jSONObject2, e);
        }
    }

    public final VKApiException a(String str, String str2, int[] iArr) {
        h.b(str, AnalyticsEventKey.RESPONSE);
        h.b(str2, FirebaseAnalytics.Param.METHOD);
        JSONArray jSONArray = new JSONObject(str).getJSONArray("execute_errors");
        h.a((Object) jSONArray, "JSONObject(response).getJSONArray(VKApiCodes.PARAM_EXECUTE_ERRORS)");
        return a(jSONArray, str2, iArr);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x002c. Please report as an issue. */
    private final VKApiException a(JSONArray jSONArray, String str, int[] iArr) {
        try {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            int length = jSONArray.length();
            if (length > 0) {
                while (true) {
                    int i2 = i + 1;
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    h.a((Object) jSONObject, "errorsJson.getJSONObject(i)");
                    VKApiException a2 = a(this, jSONObject, null, null, 6, null);
                    if (!(a2 instanceof VKApiExecutionException)) {
                        return a2;
                    }
                    switch (((VKApiExecutionException) a2).a()) {
                        case 1:
                        case 4:
                        case 5:
                        case 6:
                        case 9:
                        case 10:
                        case 14:
                        case 17:
                        case 24:
                        case 25:
                            return a2;
                        default:
                            if (iArr == null || !kotlin.collections.d.a(iArr, ((VKApiExecutionException) a2).a())) {
                                arrayList.add(a2);
                            }
                            if (i2 >= length) {
                                break;
                            } else {
                                i = i2;
                            }
                            break;
                    }
                }
            }
            return new VKApiExecutionException(BleSignal.UNKNOWN_TX_POWER, str, false, "", null, arrayList, null, null, 0, 448, null);
        } catch (JSONException e) {
            return new VKApiIllegalResponseException(e);
        }
    }
}
