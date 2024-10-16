package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* loaded from: classes2.dex */
final /* synthetic */ class tv implements zzczc {

    /* renamed from: a, reason: collision with root package name */
    static final zzczc f2529a = new tv();

    private tv() {
    }

    @Override // com.google.android.gms.internal.ads.zzczc
    public final Object apply(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        zzawz.zzds("Ad request signals:");
        zzawz.zzds(jSONObject.toString(2));
        return jSONObject;
    }
}
