package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class rw implements zzban<zzbgz> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f2477a;
    private final /* synthetic */ zzaho b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public rw(zzccj zzccjVar, String str, zzaho zzahoVar) {
        this.f2477a = str;
        this.b = zzahoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void zzb(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void zzk(zzbgz zzbgzVar) {
        zzbgzVar.zzb(this.f2477a, this.b);
    }
}
