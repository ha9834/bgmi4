package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class dk implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzgm f4808a;
    private final /* synthetic */ zzfj b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(zzfj zzfjVar, zzgm zzgmVar) {
        this.b = zzfjVar;
        this.f4808a = zzgmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a(this.f4808a);
        this.b.a();
    }
}
