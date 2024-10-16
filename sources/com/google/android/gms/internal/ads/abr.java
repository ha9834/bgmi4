package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
final class abr extends zzdbt<zzdbj, zzdet, zzdev> {
    public abr() {
        super(zzdbj.class, zzdet.class, zzdev.class, "type.googleapis.com/google.crypto.tink.AesGcmKey");
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
    protected final /* synthetic */ zzdev b(zzdmr zzdmrVar) throws zzdok {
        return zzdev.zzal(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdet a(zzdmr zzdmrVar) throws zzdok {
        return zzdet.zzaj(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdet d(zzdev zzdevVar) throws GeneralSecurityException {
        return (zzdet) ((zzdob) zzdet.zzapn().zzak(zzdmr.zzz(zzdlo.zzff(zzdevVar.getKeySize()))).zzdz(0).zzaya());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdbj c(zzdet zzdetVar) throws GeneralSecurityException {
        return new zzdjm(zzdetVar.zzaoi().toByteArray());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void b(zzdev zzdevVar) throws GeneralSecurityException {
        zzdlx.zzfg(zzdevVar.getKeySize());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void a(zzdet zzdetVar) throws GeneralSecurityException {
        zzdet zzdetVar2 = zzdetVar;
        zzdlx.zzu(zzdetVar2.getVersion(), 0);
        zzdlx.zzfg(zzdetVar2.zzaoi().size());
    }
}
