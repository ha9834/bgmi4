package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class lj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbhk f2317a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public lj(zzbhk zzbhkVar) {
        this.f2317a = zzbhkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbgz zzbgzVar;
        zzbgzVar = this.f2317a.f2873a;
        zzbgzVar.destroy();
    }
}
