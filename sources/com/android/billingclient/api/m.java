package com.android.billingclient.api;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private final String f979a;
    private final String b;
    private final JSONObject c;

    public m(String str, String str2) throws JSONException {
        this.f979a = str;
        this.b = str2;
        this.c = new JSONObject(this.f979a);
    }

    public String a() {
        JSONObject jSONObject = this.c;
        return jSONObject.optString("token", jSONObject.optString("purchaseToken"));
    }

    public String b() {
        return this.f979a;
    }

    public String c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return TextUtils.equals(this.f979a, mVar.b()) && TextUtils.equals(this.b, mVar.c());
    }

    public int hashCode() {
        return this.f979a.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.f979a);
        return valueOf.length() != 0 ? "PurchaseHistoryRecord. Json: ".concat(valueOf) : new String("PurchaseHistoryRecord. Json: ");
    }
}
