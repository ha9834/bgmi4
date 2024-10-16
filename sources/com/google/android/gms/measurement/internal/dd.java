package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class dd implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzfj f4801a;
    private final /* synthetic */ zzef b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dd(zzez zzezVar, zzfj zzfjVar, zzef zzefVar) {
        this.f4801a = zzfjVar;
        this.b = zzefVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f4801a.zzht() == null) {
            this.b.zzgk().zzao("Install Referrer Reporter is null");
            return;
        }
        zzeu zzht = this.f4801a.zzht();
        zzht.f4936a.d();
        zzht.a(zzht.f4936a.getContext().getPackageName());
    }
}
