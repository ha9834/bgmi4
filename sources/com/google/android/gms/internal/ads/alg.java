package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class alg implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f1951a;
    private final /* synthetic */ zzma b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public alg(zzma zzmaVar, int i) {
        this.b = zzmaVar;
        this.f1951a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlz zzlzVar;
        zzlzVar = this.b.b;
        zzlzVar.zzag(this.f1951a);
    }
}
