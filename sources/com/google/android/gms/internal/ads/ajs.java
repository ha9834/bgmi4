package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ajs implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f1920a;
    private final /* synthetic */ long b;
    private final /* synthetic */ zzhd c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ajs(zzhd zzhdVar, int i, long j) {
        this.c = zzhdVar;
        this.f1920a = i;
        this.b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzhh zzhhVar;
        zzhhVar = this.c.c;
        zzhhVar.zzb(this.f1920a, this.b);
    }
}
