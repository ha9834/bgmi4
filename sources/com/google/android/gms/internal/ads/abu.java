package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
final class abu extends zzdbt<zzdbj, zzdhi, zzdhk> {
    public abu() {
        super(zzdbj.class, zzdhi.class, zzdhk.class, "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* bridge */ /* synthetic */ void b(zzdhk zzdhkVar) throws GeneralSecurityException {
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final int getVersion() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final zzdgr.zzb a() {
        return zzdgr.zzb.REMOTE;
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdhk b(zzdmr zzdmrVar) throws zzdok {
        return zzdhk.zzbs(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdhi a(zzdmr zzdmrVar) throws zzdok {
        return zzdhi.zzbr(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdhi d(zzdhk zzdhkVar) throws GeneralSecurityException {
        return (zzdhi) ((zzdob) zzdhi.zzatd().zzb(zzdhkVar).zzey(0).zzaya());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdbj c(zzdhi zzdhiVar) throws GeneralSecurityException {
        zzdhi zzdhiVar2 = zzdhiVar;
        String zzatf = zzdhiVar2.zzatc().zzatf();
        return new zzdcs(zzdhiVar2.zzatc().zzatg(), zzdbx.zzgh(zzatf).zzgg(zzatf));
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void a(zzdhi zzdhiVar) throws GeneralSecurityException {
        zzdlx.zzu(zzdhiVar.getVersion(), 0);
    }
}
