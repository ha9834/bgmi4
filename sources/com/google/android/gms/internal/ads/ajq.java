package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ajq implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f1918a;
    private final /* synthetic */ int b;
    private final /* synthetic */ float c;
    private final /* synthetic */ zzhd d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ajq(zzhd zzhdVar, int i, int i2, float f) {
        this.d = zzhdVar;
        this.f1918a = i;
        this.b = i2;
        this.c = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzhh zzhhVar;
        zzhhVar = this.d.c;
        zzhhVar.zza(this.f1918a, this.b, this.c);
    }
}
