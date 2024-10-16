package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ald implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzlh f1948a;
    private final /* synthetic */ zzma b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ald(zzma zzmaVar, zzlh zzlhVar) {
        this.b = zzmaVar;
        this.f1948a = zzlhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlz zzlzVar;
        zzlzVar = this.b.b;
        zzlzVar.zzb(this.f1948a);
    }
}
