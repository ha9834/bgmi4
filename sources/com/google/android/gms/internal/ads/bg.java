package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class bg implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f2071a;
    private final /* synthetic */ zzajy b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(zzajy zzajyVar, String str) {
        this.b = zzajyVar;
        this.f2071a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbgz zzbgzVar;
        zzbgzVar = this.b.f2743a;
        zzbgzVar.loadUrl(this.f2071a);
    }
}
