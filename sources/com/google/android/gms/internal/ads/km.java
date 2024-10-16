package com.google.android.gms.internal.ads;

import com.google.android.gms.tagmanager.DataLayer;
import com.helpshift.analytics.AnalyticsEventKey;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class km implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f2294a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;
    private final /* synthetic */ int d;
    private final /* synthetic */ long e;
    private final /* synthetic */ long f;
    private final /* synthetic */ boolean g;
    private final /* synthetic */ int h;
    private final /* synthetic */ int i;
    private final /* synthetic */ zzbft j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public km(zzbft zzbftVar, String str, String str2, int i, int i2, long j, long j2, boolean z, int i3, int i4) {
        this.j = zzbftVar;
        this.f2294a = str;
        this.b = str2;
        this.c = i;
        this.d = i2;
        this.e = j;
        this.f = j2;
        this.g = z;
        this.h = i3;
        this.i = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(DataLayer.EVENT_KEY, "precacheProgress");
        hashMap.put(AnalyticsEventKey.FAQ_SOURCE, this.f2294a);
        hashMap.put("cachedSrc", this.b);
        hashMap.put("bytesLoaded", Integer.toString(this.c));
        hashMap.put("totalBytes", Integer.toString(this.d));
        hashMap.put("bufferedDuration", Long.toString(this.e));
        hashMap.put("totalDuration", Long.toString(this.f));
        hashMap.put("cacheReady", this.g ? "1" : "0");
        hashMap.put("playerCount", Integer.toString(this.h));
        hashMap.put("playerPreparedCount", Integer.toString(this.i));
        this.j.a("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
