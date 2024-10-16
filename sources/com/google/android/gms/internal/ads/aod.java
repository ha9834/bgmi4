package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aod implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f2000a;
    private final /* synthetic */ long b;
    private final /* synthetic */ long c;
    private final /* synthetic */ zzto d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aod(zzto zztoVar, String str, long j, long j2) {
        this.d = zztoVar;
        this.f2000a = str;
        this.b = j;
        this.c = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zztn zztnVar;
        zztnVar = this.d.b;
        zztnVar.zze(this.f2000a, this.b, this.c);
    }
}
