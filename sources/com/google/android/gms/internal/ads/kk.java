package com.google.android.gms.internal.ads;

import com.google.android.gms.tagmanager.DataLayer;
import com.helpshift.analytics.AnalyticsEventKey;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class kk implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f2292a;
    private final /* synthetic */ String b;
    private final /* synthetic */ long c;
    private final /* synthetic */ long d;
    private final /* synthetic */ boolean e;
    private final /* synthetic */ zzbft f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public kk(zzbft zzbftVar, String str, String str2, long j, long j2, boolean z) {
        this.f = zzbftVar;
        this.f2292a = str;
        this.b = str2;
        this.c = j;
        this.d = j2;
        this.e = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(DataLayer.EVENT_KEY, "precacheProgress");
        hashMap.put(AnalyticsEventKey.FAQ_SOURCE, this.f2292a);
        hashMap.put("cachedSrc", this.b);
        hashMap.put("bufferedDuration", Long.toString(this.c));
        hashMap.put("totalDuration", Long.toString(this.d));
        hashMap.put("cacheReady", this.e ? "1" : "0");
        this.f.a("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
