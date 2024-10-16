package com.android.billingclient.api;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private final String f980a;
    private final JSONObject b;

    public p(String str) throws JSONException {
        this.f980a = str;
        this.b = new JSONObject(this.f980a);
        if (TextUtils.isEmpty(this.b.optString("productId"))) {
            throw new IllegalArgumentException("SKU cannot be empty.");
        }
        if (TextUtils.isEmpty(this.b.optString("type"))) {
            throw new IllegalArgumentException("SkuType cannot be empty.");
        }
    }

    public String a() {
        return this.f980a;
    }

    public String b() {
        return this.b.optString("productId");
    }

    public String c() {
        return this.b.optString("type");
    }

    public String d() {
        return this.b.optString(FirebaseAnalytics.Param.PRICE);
    }

    public long e() {
        return this.b.optLong("price_amount_micros");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            return TextUtils.equals(this.f980a, ((p) obj).f980a);
        }
        return false;
    }

    public String f() {
        return this.b.optString("price_currency_code");
    }

    public String g() {
        if (this.b.has("original_price")) {
            return this.b.optString("original_price");
        }
        return d();
    }

    public long h() {
        if (this.b.has("original_price_micros")) {
            return this.b.optLong("original_price_micros");
        }
        return e();
    }

    public int hashCode() {
        return this.f980a.hashCode();
    }

    public String i() {
        return this.b.optString("introductoryPrice");
    }

    public long j() {
        return this.b.optLong("introductoryPriceAmountMicros");
    }

    public String k() {
        return this.b.optString("introductoryPricePeriod");
    }

    public int l() {
        return this.b.optInt("introductoryPriceCycles");
    }

    public final String m() {
        return this.b.optString("packageName");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String n() {
        return this.b.optString("skuDetailsToken");
    }

    public String o() {
        return this.b.optString("offer_id");
    }

    public int p() {
        return this.b.optInt("offer_type");
    }

    public String toString() {
        String valueOf = String.valueOf(this.f980a);
        return valueOf.length() != 0 ? "SkuDetails: ".concat(valueOf) : new String("SkuDetails: ");
    }
}
