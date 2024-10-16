package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;

/* loaded from: classes2.dex */
public final class zzdkc implements zzdbq {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f3566a = new byte[0];
    private final zzdke b;
    private final String c;
    private final byte[] d;
    private final zzdkv e;
    private final zzdka f;

    public zzdkc(ECPublicKey eCPublicKey, byte[] bArr, String str, zzdkv zzdkvVar, zzdka zzdkaVar) throws GeneralSecurityException {
        zzdkr.a(eCPublicKey);
        this.b = new zzdke(eCPublicKey);
        this.d = bArr;
        this.c = str;
        this.e = zzdkvVar;
        this.f = zzdkaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdbq
    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzdkf zza = this.b.zza(this.c, this.d, bArr2, this.f.zzanz(), this.e);
        byte[] zzc = this.f.zzm(zza.zzaux()).zzc(bArr, f3566a);
        byte[] zzauw = zza.zzauw();
        return ByteBuffer.allocate(zzauw.length + zzc.length).put(zzauw).put(zzc).array();
    }
}
