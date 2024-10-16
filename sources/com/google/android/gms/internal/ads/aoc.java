package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aoc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zznc f1999a;
    private final /* synthetic */ zzto b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aoc(zzto zztoVar, zznc zzncVar) {
        this.b = zztoVar;
        this.f1999a = zzncVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zztn zztnVar;
        zztnVar = this.b.b;
        zztnVar.zze(this.f1999a);
    }
}
