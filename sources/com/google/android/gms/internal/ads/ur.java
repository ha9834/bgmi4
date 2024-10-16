package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final /* synthetic */ class ur implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final zzbgz f2548a;

    private ur(zzbgz zzbgzVar) {
        this.f2548a = zzbgzVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable a(zzbgz zzbgzVar) {
        return new ur(zzbgzVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2548a.zzaav();
    }
}
