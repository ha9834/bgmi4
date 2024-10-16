package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
final class aca implements zzdbq {

    /* renamed from: a, reason: collision with root package name */
    private final zzdca<zzdbq> f1785a;

    public aca(zzdca<zzdbq> zzdcaVar) {
        this.f1785a = zzdcaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdbq
    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return zzdjs.zza(this.f1785a.zzanu().zzanx(), this.f1785a.zzanu().zzanv().zzc(bArr, bArr2));
    }
}
