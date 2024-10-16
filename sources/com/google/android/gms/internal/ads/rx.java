package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class rx implements zzban<zzbgz> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f2478a;
    private final /* synthetic */ Map b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public rx(zzccj zzccjVar, String str, Map map) {
        this.f2478a = str;
        this.b = map;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void zzb(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void zzk(zzbgz zzbgzVar) {
        zzbgzVar.zza(this.f2478a, this.b);
    }
}
