package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ta extends zzair {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Object f2508a;
    private final /* synthetic */ String b;
    private final /* synthetic */ long c;
    private final /* synthetic */ zzbbr d;
    private final /* synthetic */ zzcgb e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ta(zzcgb zzcgbVar, Object obj, String str, long j, zzbbr zzbbrVar) {
        this.e = zzcgbVar;
        this.f2508a = obj;
        this.b = str;
        this.c = j;
        this.d = zzbbrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaiq
    public final void onInitializationSucceeded() {
        synchronized (this.f2508a) {
            this.e.a(this.b, true, "", (int) (zzk.zzln().elapsedRealtime() - this.c));
            this.d.set(true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaiq
    public final void onInitializationFailed(String str) {
        synchronized (this.f2508a) {
            this.e.a(this.b, false, str, (int) (zzk.zzln().elapsedRealtime() - this.c));
            this.d.set(false);
        }
    }
}
