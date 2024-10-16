package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aog implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f2003a;
    private final /* synthetic */ int b;
    private final /* synthetic */ int c;
    private final /* synthetic */ float d;
    private final /* synthetic */ zzto e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aog(zzto zztoVar, int i, int i2, int i3, float f) {
        this.e = zztoVar;
        this.f2003a = i;
        this.b = i2;
        this.c = i3;
        this.d = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zztn zztnVar;
        zztnVar = this.e.b;
        zztnVar.zza(this.f2003a, this.b, this.c, this.d);
    }
}
