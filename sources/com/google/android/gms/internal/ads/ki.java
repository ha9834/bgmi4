package com.google.android.gms.internal.ads;

import com.google.android.gms.tagmanager.DataLayer;
import com.helpshift.analytics.AnalyticsEventKey;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
final class ki implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f2290a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;
    private final /* synthetic */ int d;
    private final /* synthetic */ boolean e = false;
    private final /* synthetic */ zzbft f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ki(zzbft zzbftVar, String str, String str2, int i, int i2, boolean z) {
        this.f = zzbftVar;
        this.f2290a = str;
        this.b = str2;
        this.c = i;
        this.d = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(DataLayer.EVENT_KEY, "precacheProgress");
        hashMap.put(AnalyticsEventKey.FAQ_SOURCE, this.f2290a);
        hashMap.put("cachedSrc", this.b);
        hashMap.put("bytesLoaded", Integer.toString(this.c));
        hashMap.put("totalBytes", Integer.toString(this.d));
        hashMap.put("cacheReady", this.e ? "1" : "0");
        this.f.a("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
