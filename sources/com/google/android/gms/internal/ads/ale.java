package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ale implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f1949a;
    private final /* synthetic */ long b;
    private final /* synthetic */ long c;
    private final /* synthetic */ zzma d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ale(zzma zzmaVar, int i, long j, long j2) {
        this.d = zzmaVar;
        this.f1949a = i;
        this.b = j;
        this.c = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlz zzlzVar;
        zzlzVar = this.d.b;
        zzlzVar.zzc(this.f1949a, this.b, this.c);
    }
}