package com.android.billingclient.api;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private final String f977a;
    private final String b;
    private final JSONObject c;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<l> f978a;
        private final h b;

        public a(h hVar, List<l> list) {
            this.f978a = list;
            this.b = hVar;
        }

        public h a() {
            return this.b;
        }

        public int b() {
            return a().a();
        }

        public List<l> c() {
            return this.f978a;
        }
    }

    public l(String str, String str2) throws JSONException {
        this.f977a = str;
        this.b = str2;
        this.c = new JSONObject(this.f977a);
    }

    public String a() {
        return this.c.optString("orderId");
    }

    public String b() {
        return this.c.optString("productId");
    }

    public String c() {
        JSONObject jSONObject = this.c;
        return jSONObject.optString("token", jSONObject.optString("purchaseToken"));
    }

    public int d() {
        return this.c.optInt("purchaseState", 1) != 4 ? 1 : 2;
    }

    public String e() {
        return this.f977a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return TextUtils.equals(this.f977a, lVar.e()) && TextUtils.equals(this.b, lVar.f());
    }

    public String f() {
        return this.b;
    }

    public com.android.billingclient.api.a g() {
        String optString = this.c.optString("obfuscatedAccountId");
        String optString2 = this.c.optString("obfuscatedProfileId");
        if (optString == null && optString2 == null) {
            return null;
        }
        return new com.android.billingclient.api.a(optString, optString2);
    }

    public int hashCode() {
        return this.f977a.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.f977a);
        return valueOf.length() != 0 ? "Purchase. Json: ".concat(valueOf) : new String("Purchase. Json: ");
    }
}
