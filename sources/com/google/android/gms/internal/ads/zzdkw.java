package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zzdkw implements zzdbj {

    /* renamed from: a, reason: collision with root package name */
    private final zzdlk f3573a;
    private final zzdby b;
    private final int c;

    public zzdkw(zzdlk zzdlkVar, zzdby zzdbyVar, int i) {
        this.f3573a = zzdlkVar;
        this.b = zzdbyVar;
        this.c = i;
    }

    @Override // com.google.android.gms.internal.ads.zzdbj
    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] zzo = this.f3573a.zzo(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        return zzdjs.zza(zzo, this.b.zzk(zzdjs.zza(bArr2, zzo, Arrays.copyOf(ByteBuffer.allocate(8).putLong(bArr2.length * 8).array(), 8))));
    }
}
