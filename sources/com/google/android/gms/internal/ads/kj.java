package com.google.android.gms.internal.ads;

import com.google.android.gms.tagmanager.DataLayer;
import com.helpshift.analytics.AnalyticsEventKey;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class kj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f2291a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;
    private final /* synthetic */ int d = 0;
    private final /* synthetic */ boolean e;
    private final /* synthetic */ int f;
    private final /* synthetic */ int g;
    private final /* synthetic */ zzbft h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public kj(zzbft zzbftVar, String str, String str2, int i, int i2, boolean z, int i3, int i4) {
        this.h = zzbftVar;
        this.f2291a = str;
        this.b = str2;
        this.c = i;
        this.e = z;
        this.f = i3;
        this.g = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(DataLayer.EVENT_KEY, "precacheProgress");
        hashMap.put(AnalyticsEventKey.FAQ_SOURCE, this.f2291a);
        hashMap.put("cachedSrc", this.b);
        hashMap.put("bytesLoaded", Integer.toString(this.c));
        hashMap.put("totalBytes", Integer.toString(this.d));
        hashMap.put("cacheReady", this.e ? "1" : "0");
        hashMap.put("playerCount", Integer.toString(this.f));
        hashMap.put("playerPreparedCount", Integer.toString(this.g));
        this.h.a("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
