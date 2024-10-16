package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import java.security.GeneralSecurityException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class abp extends zzdbt<zzdlk, zzdeb, zzded> {
    public abp() {
        super(zzdlk.class, zzdeb.class, zzded.class, "type.googleapis.com/google.crypto.tink.AesCtrKey");
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final int getVersion() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final zzdgr.zzb a() {
        return zzdgr.zzb.SYMMETRIC;
    }

    private static void a(zzdef zzdefVar) throws GeneralSecurityException {
        if (zzdefVar.zzaoy() < 12 || zzdefVar.zzaoy() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzded b(zzdmr zzdmrVar) throws zzdok {
        return zzded.zzac(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdeb a(zzdmr zzdmrVar) throws zzdok {
        return zzdeb.zzaa(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdeb d(zzded zzdedVar) throws GeneralSecurityException {
        zzded zzdedVar2 = zzdedVar;
        return (zzdeb) ((zzdob) zzdeb.zzaot().zzc(zzdedVar2.zzaos()).zzab(zzdmr.zzz(zzdlo.zzff(zzdedVar2.getKeySize()))).zzdw(0).zzaya());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdlk c(zzdeb zzdebVar) throws GeneralSecurityException {
        zzdeb zzdebVar2 = zzdebVar;
        return new zzdjj(zzdebVar2.zzaoi().toByteArray(), zzdebVar2.zzaos().zzaoy());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void b(zzded zzdedVar) throws GeneralSecurityException {
        zzded zzdedVar2 = zzdedVar;
        zzdlx.zzfg(zzdedVar2.getKeySize());
        a(zzdedVar2.zzaos());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void a(zzdeb zzdebVar) throws GeneralSecurityException {
        zzdeb zzdebVar2 = zzdebVar;
        zzdlx.zzu(zzdebVar2.getVersion(), 0);
        zzdlx.zzfg(zzdebVar2.zzaoi().size());
        a(zzdebVar2.zzaos());
    }
}
