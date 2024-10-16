package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* loaded from: classes2.dex */
public final class zzdma extends adz {
    public zzdma(byte[] bArr) throws InvalidKeyException {
        super(bArr);
    }

    @Override // com.google.android.gms.internal.ads.adz
    final ady a(byte[] bArr, int i) throws InvalidKeyException {
        return new aef(bArr, i);
    }

    @Override // com.google.android.gms.internal.ads.adz, com.google.android.gms.internal.ads.zzdbj
    public final /* bridge */ /* synthetic */ byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return super.zzc(bArr, bArr2);
    }
}
