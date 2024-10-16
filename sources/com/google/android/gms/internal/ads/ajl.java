package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ajl implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f1916a;
    private final /* synthetic */ long b;
    private final /* synthetic */ long c;
    private final /* synthetic */ zzgr d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ajl(zzgr zzgrVar, String str, long j, long j2) {
        this.d = zzgrVar;
        this.f1916a = str;
        this.b = j;
        this.c = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgw zzgwVar;
        zzgwVar = this.d.i;
        zzgwVar.zza(this.f1916a, this.b, this.c);
    }
}
