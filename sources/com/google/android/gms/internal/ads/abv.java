package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
final class abv extends zzdbt<zzdbj, zzdig, zzdgh> {
    public abv() {
        super(zzdbj.class, zzdig.class, zzdgh.class, "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* bridge */ /* synthetic */ void b(zzdgh zzdghVar) throws GeneralSecurityException {
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final int getVersion() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final zzdgr.zzb a() {
        return zzdgr.zzb.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdgh b(zzdmr zzdmrVar) throws zzdok {
        return zzdgh.zzbj(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdig a(zzdmr zzdmrVar) throws zzdok {
        return zzdig.zzcx(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdig d(zzdgh zzdghVar) throws GeneralSecurityException {
        return (zzdig) ((zzdob) zzdig.zzaus().zzfe(0).zzcy(zzdmr.zzz(zzdlo.zzff(32))).zzaya());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdbj c(zzdig zzdigVar) throws GeneralSecurityException {
        return new zzdma(zzdigVar.zzaoi().toByteArray());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void a(zzdig zzdigVar) throws GeneralSecurityException {
        zzdig zzdigVar2 = zzdigVar;
        zzdlx.zzu(zzdigVar2.getVersion(), 0);
        if (zzdigVar2.zzaoi().size() != 32) {
            throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
        }
    }
}
