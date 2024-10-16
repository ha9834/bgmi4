package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
final class abs extends zzdbt<zzdbj, zzdfb, zzdgh> {
    public abs() {
        super(zzdbj.class, zzdfb.class, zzdgh.class, "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
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
    protected final /* synthetic */ zzdfb a(zzdmr zzdmrVar) throws zzdok {
        return zzdfb.zzap(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdfb d(zzdgh zzdghVar) throws GeneralSecurityException {
        return (zzdfb) ((zzdob) zzdfb.zzapt().zzeb(0).zzaq(zzdmr.zzz(zzdlo.zzff(32))).zzaya());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdbj c(zzdfb zzdfbVar) throws GeneralSecurityException {
        return new zzdjv(zzdfbVar.zzaoi().toByteArray());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void a(zzdfb zzdfbVar) throws GeneralSecurityException {
        zzdfb zzdfbVar2 = zzdfbVar;
        zzdlx.zzu(zzdfbVar2.getVersion(), 0);
        if (zzdfbVar2.zzaoi().size() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }
}
