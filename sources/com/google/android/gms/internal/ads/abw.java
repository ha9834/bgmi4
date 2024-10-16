package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;

/* loaded from: classes2.dex */
final class abw extends zzdbt<zzdbp, zzdfv, zzdfr> implements zzdbs<zzdbp> {
    public abw() {
        super(zzdbp.class, zzdfv.class, zzdfr.class, "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey");
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final int getVersion() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final zzdgr.zzb a() {
        return zzdgr.zzb.ASYMMETRIC_PRIVATE;
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdfr b(zzdmr zzdmrVar) throws zzdok {
        return zzdfr.zzaz(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdfv a(zzdmr zzdmrVar) throws zzdok {
        return zzdfv.zzba(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdfv d(zzdfr zzdfrVar) throws GeneralSecurityException {
        zzdfr zzdfrVar2 = zzdfrVar;
        KeyPair zza = zzdkr.zza(zzdkr.zza(acb.a(zzdfrVar2.zzaqn().zzaqp().zzara())));
        ECPublicKey eCPublicKey = (ECPublicKey) zza.getPublic();
        ECPrivateKey eCPrivateKey = (ECPrivateKey) zza.getPrivate();
        ECPoint w = eCPublicKey.getW();
        return (zzdfv) ((zzdob) zzdfv.zzaqv().zzeg(0).zzb((zzdfx) ((zzdob) zzdfx.zzaqx().zzeh(0).zzc(zzdfrVar2.zzaqn()).zzbd(zzdmr.zzz(w.getAffineX().toByteArray())).zzbe(zzdmr.zzz(w.getAffineY().toByteArray())).zzaya())).zzbb(zzdmr.zzz(eCPrivateKey.getS().toByteArray())).zzaya());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdbp c(zzdfv zzdfvVar) throws GeneralSecurityException {
        zzdfv zzdfvVar2 = zzdfvVar;
        zzdft zzaqn = zzdfvVar2.zzaqu().zzaqn();
        zzdfz zzaqp = zzaqn.zzaqp();
        return new zzdkb(zzdkr.zza(acb.a(zzaqp.zzara()), zzdfvVar2.zzaoi().toByteArray()), zzaqp.zzarb().toByteArray(), acb.a(zzaqp.zzaoo()), acb.a(zzaqn.zzaqr()), new acd(zzaqn.zzaqq().zzaqk()));
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void b(zzdfr zzdfrVar) throws GeneralSecurityException {
        acb.a(zzdfrVar.zzaqn());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void a(zzdfv zzdfvVar) throws GeneralSecurityException {
        zzdfv zzdfvVar2 = zzdfvVar;
        zzdlx.zzu(zzdfvVar2.getVersion(), 0);
        acb.a(zzdfvVar2.zzaqu().zzaqn());
    }
}
