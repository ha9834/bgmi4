package com.google.android.gms.internal.ads;

import com.google.android.gms.tagmanager.DataLayer;
import com.helpshift.analytics.AnalyticsEventKey;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class kn implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f2295a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;
    private final /* synthetic */ zzbft d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public kn(zzbft zzbftVar, String str, String str2, int i) {
        this.d = zzbftVar;
        this.f2295a = str;
        this.b = str2;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(DataLayer.EVENT_KEY, "precacheComplete");
        hashMap.put(AnalyticsEventKey.FAQ_SOURCE, this.f2295a);
        hashMap.put("cachedSrc", this.b);
        hashMap.put("totalBytes", Integer.toString(this.c));
        this.d.a("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
