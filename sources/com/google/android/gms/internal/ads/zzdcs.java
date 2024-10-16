package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
public final class zzdcs implements zzdbj {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f3545a = new byte[0];
    private final zzdgw b;
    private final zzdbj c;

    public zzdcs(zzdgw zzdgwVar, zzdbj zzdbjVar) {
        this.b = zzdgwVar;
        this.c = zzdbjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdbj
    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] byteArray = zzdcf.zzb(this.b).toByteArray();
        byte[] zzc = this.c.zzc(byteArray, f3545a);
        byte[] zzc2 = ((zzdbj) zzdcf.zza(this.b.zzart(), byteArray, zzdbj.class)).zzc(bArr, bArr2);
        return ByteBuffer.allocate(zzc.length + 4 + zzc2.length).putInt(zzc.length).put(zzc).put(zzc2).array();
    }
}
