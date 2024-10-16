package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class rv implements zzban<zzbgz> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f2476a;
    private final /* synthetic */ zzaho b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public rv(zzccj zzccjVar, String str, zzaho zzahoVar) {
        this.f2476a = str;
        this.b = zzahoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void zzb(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void zzk(zzbgz zzbgzVar) {
        zzbgzVar.zza(this.f2476a, this.b);
    }
}
