package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class dz implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbah f2137a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dz(zzaqx zzaqxVar, zzbah zzbahVar, String str) {
        this.f2137a = zzbahVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2137a.zzed(this.b);
    }
}
