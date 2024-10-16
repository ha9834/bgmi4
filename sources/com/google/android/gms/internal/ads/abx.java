package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
final class abx extends zzdbt<zzdbq, zzdfx, zzdgh> {
    public abx() {
        super(zzdbq.class, zzdfx.class, zzdgh.class, "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey");
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
        return zzdgr.zzb.ASYMMETRIC_PUBLIC;
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdgh b(zzdmr zzdmrVar) throws zzdok {
        return zzdgh.zzbj(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdfx a(zzdmr zzdmrVar) throws zzdok {
        return zzdfx.zzbc(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdfx d(zzdgh zzdghVar) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented.");
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdbq c(zzdfx zzdfxVar) throws GeneralSecurityException {
        zzdfx zzdfxVar2 = zzdfxVar;
        zzdft zzaqn = zzdfxVar2.zzaqn();
        zzdfz zzaqp = zzaqn.zzaqp();
        return new zzdkc(zzdkr.zza(acb.a(zzaqp.zzara()), zzdfxVar2.zzaqf().toByteArray(), zzdfxVar2.zzaqg().toByteArray()), zzaqp.zzarb().toByteArray(), acb.a(zzaqp.zzaoo()), acb.a(zzaqn.zzaqr()), new acd(zzaqn.zzaqq().zzaqk()));
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void a(zzdfx zzdfxVar) throws GeneralSecurityException {
        zzdfx zzdfxVar2 = zzdfxVar;
        zzdlx.zzu(zzdfxVar2.getVersion(), 0);
        acb.a(zzdfxVar2.zzaqn());
    }
}
