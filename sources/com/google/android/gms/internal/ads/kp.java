package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.tagmanager.DataLayer;
import com.helpshift.analytics.AnalyticsEventKey;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class kp implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f2297a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;
    private final /* synthetic */ zzbft e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public kp(zzbft zzbftVar, String str, String str2, String str3, String str4) {
        this.e = zzbftVar;
        this.f2297a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String b;
        HashMap hashMap = new HashMap();
        hashMap.put(DataLayer.EVENT_KEY, "precacheCanceled");
        hashMap.put(AnalyticsEventKey.FAQ_SOURCE, this.f2297a);
        if (!TextUtils.isEmpty(this.b)) {
            hashMap.put("cachedSrc", this.b);
        }
        zzbft zzbftVar = this.e;
        b = zzbft.b(this.c);
        hashMap.put("type", b);
        hashMap.put("reason", this.c);
        if (!TextUtils.isEmpty(this.d)) {
            hashMap.put("message", this.d);
        }
        this.e.a("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
