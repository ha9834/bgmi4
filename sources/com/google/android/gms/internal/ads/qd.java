package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final /* synthetic */ class qd implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final zzbzb f2434a;

    private qd(zzbzb zzbzbVar) {
        this.f2434a = zzbzbVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable a(zzbzb zzbzbVar) {
        return new qd(zzbzbVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2434a.zzahm();
    }
}
