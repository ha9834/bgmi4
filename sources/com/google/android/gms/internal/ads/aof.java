package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aof implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f2002a;
    private final /* synthetic */ long b;
    private final /* synthetic */ zzto c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aof(zzto zztoVar, int i, long j) {
        this.c = zztoVar;
        this.f2002a = i;
        this.b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zztn zztnVar;
        zztnVar = this.c.b;
        zztnVar.zzb(this.f2002a, this.b);
    }
}
