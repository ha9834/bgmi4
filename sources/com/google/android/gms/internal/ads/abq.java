package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
final class abq extends zzdbt<zzdbj, zzdeh, zzdej> {
    public abq() {
        super(zzdbj.class, zzdeh.class, zzdej.class, "type.googleapis.com/google.crypto.tink.AesEaxKey");
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
    protected final /* synthetic */ zzdej b(zzdmr zzdmrVar) throws zzdok {
        return zzdej.zzaf(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdeh a(zzdmr zzdmrVar) throws zzdok {
        return zzdeh.zzad(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdeh d(zzdej zzdejVar) throws GeneralSecurityException {
        zzdej zzdejVar2 = zzdejVar;
        return (zzdeh) ((zzdob) zzdeh.zzapc().zzae(zzdmr.zzz(zzdlo.zzff(zzdejVar2.getKeySize()))).zzb(zzdejVar2.zzapb()).zzdx(0).zzaya());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdbj c(zzdeh zzdehVar) throws GeneralSecurityException {
        zzdeh zzdehVar2 = zzdehVar;
        return new zzdjk(zzdehVar2.zzaoi().toByteArray(), zzdehVar2.zzapb().zzaoy());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void b(zzdej zzdejVar) throws GeneralSecurityException {
        zzdej zzdejVar2 = zzdejVar;
        zzdlx.zzfg(zzdejVar2.getKeySize());
        if (zzdejVar2.zzapb().zzaoy() != 12 && zzdejVar2.zzapb().zzaoy() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void a(zzdeh zzdehVar) throws GeneralSecurityException {
        zzdeh zzdehVar2 = zzdehVar;
        zzdlx.zzu(zzdehVar2.getVersion(), 0);
        zzdlx.zzfg(zzdehVar2.zzaoi().size());
        if (zzdehVar2.zzapb().zzaoy() != 12 && zzdehVar2.zzapb().zzaoy() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
