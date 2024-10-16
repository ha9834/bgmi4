package com.vk.api.sdk.exceptions;

import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.j;
import kotlin.collections.v;
import kotlin.collections.w;
import kotlin.d.c;
import kotlin.d.d;
import kotlin.i;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class VKApiExecutionException extends VKApiException {
    public static final a b = new a(null);
    public static final long serialVersionUID = 7524047853274172872L;
    private final String apiMethod;
    private final int code;
    private final String detailMessage;
    private final String errorMsg;
    private final List<VKApiExecutionException> executeErrors;
    private final Bundle extra;
    private final boolean hasLocalizedMessage;
    private final Map<String, String> requestParams;
    private final int subcode;

    public final int a() {
        return this.code;
    }

    public final String b() {
        return this.apiMethod;
    }

    public /* synthetic */ VKApiExecutionException(int i, String str, boolean z, String str2, Bundle bundle, List list, String str3, Map map, int i2, int i3, f fVar) {
        this(i, str, z, str2, (i3 & 16) != 0 ? Bundle.EMPTY : bundle, (i3 & 32) != 0 ? null : list, (i3 & 64) != 0 ? null : str3, (i3 & 128) != 0 ? null : map, (i3 & 256) != 0 ? -1 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public VKApiExecutionException(int i, String str, boolean z, String str2, Bundle bundle, List<? extends VKApiExecutionException> list, String str3, Map<String, String> map, int i2) {
        super(str2);
        h.b(str, "apiMethod");
        h.b(str2, "detailMessage");
        this.code = i;
        this.apiMethod = str;
        this.hasLocalizedMessage = z;
        this.detailMessage = str2;
        this.extra = bundle;
        this.executeErrors = list;
        this.errorMsg = str3;
        this.requestParams = map;
        this.subcode = i2;
    }

    public final boolean c() {
        int i = this.code;
        return i == 1 || i == 10 || i == 13;
    }

    public final boolean d() {
        return this.code == 6;
    }

    public final boolean e() {
        int i = this.code;
        if (i != 3610) {
            switch (i) {
                case 4:
                case 5:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public final boolean f() {
        return this.code == 24;
    }

    public final boolean g() {
        return this.code == 17;
    }

    public final boolean h() {
        return this.code == 14;
    }

    public final boolean i() {
        return this.code == 29;
    }

    public final String j() {
        String string;
        Bundle bundle = this.extra;
        return (bundle == null || (string = bundle.getString("captcha_sid", "")) == null) ? "" : string;
    }

    public final String k() {
        String string;
        Bundle bundle = this.extra;
        return (bundle == null || (string = bundle.getString("captcha_img", "")) == null) ? "" : string;
    }

    public final String l() {
        String string;
        Bundle bundle = this.extra;
        return (bundle == null || (string = bundle.getString("validation_url", "")) == null) ? "" : string;
    }

    public final String m() {
        String string;
        Bundle bundle = this.extra;
        return (bundle == null || (string = bundle.getString("confirmation_text", "")) == null) ? "" : string;
    }

    public final JSONObject n() {
        String string;
        Bundle bundle = this.extra;
        if (bundle == null || (string = bundle.getString("user_ban_info")) == null) {
            return null;
        }
        return new JSONObject(string);
    }

    public final String o() {
        Bundle bundle = this.extra;
        if (bundle == null) {
            return null;
        }
        return bundle.getString("access_token", null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VKApiExecutionException)) {
            return false;
        }
        VKApiExecutionException vKApiExecutionException = (VKApiExecutionException) obj;
        if (this.code != vKApiExecutionException.code) {
            return false;
        }
        Bundle bundle = this.extra;
        return !(bundle == null ? vKApiExecutionException.extra != null : !h.a(bundle, vKApiExecutionException.extra));
    }

    public int hashCode() {
        int i = this.code * 31;
        Bundle bundle = this.extra;
        return i + (bundle == null ? 0 : bundle.hashCode());
    }

    @Override // java.lang.Throwable
    public String toString() {
        Bundle bundle;
        Bundle bundle2 = this.extra;
        boolean z = false;
        if (bundle2 != null && bundle2.containsKey("access_token")) {
            z = true;
        }
        if (z) {
            bundle = new Bundle(this.extra);
            bundle.putString("access_token", "hidden");
        } else {
            bundle = this.extra;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("VKApiExecutionException{code=");
        sb.append(this.code);
        sb.append(", extra=");
        sb.append(bundle);
        sb.append(", method=");
        sb.append(this.apiMethod);
        sb.append(", executeErrors=");
        List<VKApiExecutionException> list = this.executeErrors;
        sb.append((Object) (list == null ? null : j.a(list, null, "[", "]", 0, null, null, 57, null)));
        sb.append(", super=");
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    public static final class a {
        public /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
        }

        public final VKApiExecutionException a(JSONObject jSONObject, String str, Bundle bundle) {
            JSONArray jSONArray;
            String str2;
            h.b(jSONObject, "json");
            if (str == null) {
                str = jSONObject.optString(FirebaseAnalytics.Param.METHOD);
            }
            if (str == null) {
                str = "";
            }
            String str3 = str;
            int optInt = jSONObject.optInt("error_code", 1);
            int optInt2 = jSONObject.optInt(NativeProtocol.BRIDGE_ARG_ERROR_SUBCODE, 1);
            String optString = jSONObject.optString("error_msg");
            if (optString == null) {
                optString = "";
            }
            String str4 = optString;
            try {
                jSONArray = jSONObject.getJSONArray("request_params");
            } catch (JSONException unused) {
                jSONArray = new JSONArray();
            }
            c b = d.b(0, jSONArray.length());
            LinkedHashMap linkedHashMap = new LinkedHashMap(d.c(w.a(j.a(b, 10)), 16));
            Iterator<Integer> it = b.iterator();
            while (it.hasNext()) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(((v) it).b());
                Pair a2 = i.a(jSONObject2.getString("key"), jSONObject2.getString("value"));
                linkedHashMap.put(a2.a(), a2.b());
            }
            if (jSONObject.has("error_text")) {
                boolean z = true;
                String optString2 = jSONObject.optString("error_text");
                return new VKApiExecutionException(optInt, str3, z, optString2 == null ? "" : optString2, bundle, null, str4, linkedHashMap, optInt2, 32, null);
            }
            String optString3 = jSONObject.optString("error_msg");
            if (optString3 == null) {
                String jSONObject3 = jSONObject.toString();
                h.a((Object) jSONObject3, "json.toString()");
                str2 = jSONObject3;
            } else {
                str2 = optString3;
            }
            return new VKApiExecutionException(optInt, str3, false, str2 + " | by [" + str3 + ']', bundle, null, str2, linkedHashMap, optInt2, 32, null);
        }
    }
}
