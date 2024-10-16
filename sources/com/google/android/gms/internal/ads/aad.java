package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
final /* synthetic */ class aad implements zzcuz {

    /* renamed from: a, reason: collision with root package name */
    static final zzcuz f1755a = new aad();

    private aad() {
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final void zzt(Object obj) {
        try {
            ((JSONObject) obj).getJSONObject("sdk_env").put("container_version", 12451009);
        } catch (JSONException unused) {
        }
    }
}
