package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ch implements zzbbt {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbbr f2095a;
    private final /* synthetic */ zzakw b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(zzalu zzaluVar, zzbbr zzbbrVar, zzakw zzakwVar) {
        this.f2095a = zzbbrVar;
        this.b = zzakwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbt
    public final void run() {
        this.f2095a.setException(new zzali("Unable to obtain a JavascriptEngine."));
        this.b.release();
    }
}
